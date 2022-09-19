package kz.altenic.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Переменная доступа к компоненту окна с инициализацией
        TextView textInfo = findViewById(R.id.text_info);

        textInfo.setText("");

        textInfo.append(String.format("%s %s \n", getString(R.string.info_name), getIntent().getStringExtra("name")));
        textInfo.append(String.format("%s %s \n", getString(R.string.info_lang), getIntent().getStringExtra("lang")));
        textInfo.append(String.format("%s %s \n", getString(R.string.info_os), getIntent().getStringExtra("os")));
    }

    // МЕТОД ДЛЯ КНОПКИ НАЗАД
    public void onBack(View v) {
        setResult(RESULT_OK);
        finish();
    }

    // МЕТОД ДЛЯ КНОПКИ ВЫХОДА
    public void onExit(View v) {
        finishAffinity();
    }
}