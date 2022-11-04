package kz.altenic.task5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Доступ к компоненту отображения HTML-страниц
        WebView webView = findViewById(R.id.webView);

        webView.getSettings().setDefaultTextEncodingName("utf-8");
        if ((android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)) {
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setJavaScriptEnabled(true);
        } else {
            webView.getSettings().setLoadWithOverviewMode(false);
            webView.getSettings().setUseWideViewPort(false);
            webView.getSettings().setBuiltInZoomControls(false);
            webView.getSettings().setSupportZoom(false);
            webView.getSettings().setJavaScriptEnabled(true);
        }
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);

        // Считываем название страницы и имя файла для отображения
        String titleMarker = getIntent().getStringExtra(getString(R.string.tMarker));
        String markerFileName = getIntent().getStringExtra(getString(R.string.mfile));

        // Загрузка HTML-страницы в компонет из внутреннего ресурса
        webView.loadUrl(markerFileName);

        // Установка заголовка окна
        this.setTitle(titleMarker);
    }

    // Метод для выхода из окна
    public void detailButtonClickExit(View view) {
        finish();
    }

}
