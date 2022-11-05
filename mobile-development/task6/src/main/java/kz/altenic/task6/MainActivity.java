package kz.altenic.task6;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private final int LARGE_FONT = 16; // Размер шрифта для режима крупного шрифта
    private final int SMALL_FONT = 12; // Размер шрифта для режима обычного шрифта
    private int fontSize = SMALL_FONT; // Выбранный размер шрифта

    MySQLite db = new MySQLite(this); // Класс работы с нашей базой данных

    EditText editText; // Компонент для задания строки поиска
    WebView webView;

    String resourceDir;

    static final String FILTER = "FILTER"; // Имя параметра для сохранения при переворачивании экрана
    String filter = ""; // Фильтр поиска

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Сохранение данных при перевороте экрана
        savedInstanceState.putString(FILTER, filter);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Активация меню
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Доступ к компонентам
        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);

        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.getSettings().setLoadWithOverviewMode(false);
        webView.getSettings().setUseWideViewPort(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);

        resourceDir = getString(R.string.resource_directory);

        webView.loadUrl(resourceDir + "loading.html");
        // Восстановление фильтра после переворота экрана
        if (savedInstanceState != null) {
            editText.setText(savedInstanceState.getString(FILTER));
        }

        // Обработчик изменения текста в компоненте "editText"
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                // Сделаем поиск данных в другом потоке
                new Thread(new Runnable() {
                    public void run() {
                        filter = editText.getText().toString().trim();
                        final String data = db.getData(filter);
                        webView.post(new Runnable() {
                            @Override
                            public void run() {
                                webView.loadData(getString(R.string.open_html) + data + getString(R.string.open_html), "text/html; charset=utf-8", "UTF-8");
                            }
                        });
                    }
                }).start();

            }

        });

        // Инициализация начального поиска (показать все записи)
        editText.post(new Runnable() {
            public void run() {
                editText.setText(filter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // Установка правильного отображения пункта выбора крупного шрифта
        return true;
    }

    // Обработчик выбора пунктов меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // Написать автору
        if (id == R.id.email) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.myemail)});
            i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.Добавьте_еще_номер));
            i.putExtra(Intent.EXTRA_TEXT, getString(R.string.Предлагаю_такой_номер));
            try {
                startActivity(Intent.createChooser(i, getString(R.string.Посылка_письма)));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this, R.string.Нет_установленного_почтового_клиента, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        // Выход
        if (id == R.id.exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
