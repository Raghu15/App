package com.example.punit.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by punit on 16/01/2016.
 */
public class ViewActivity extends AppCompatActivity {
    WebView webview1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);


        webview1 = (WebView) findViewById(R.id.webView1);
        webview1.loadUrl("https://www.Felight.com");
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
            }

    @Override
    protected void onStart() {
        super.onStart();
        webview1.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(view.INVISIBLE);
            }
        });

        WebSettings webSettings = webview1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview1.setWebChromeClient(new WebChromeClient());


    }
}
