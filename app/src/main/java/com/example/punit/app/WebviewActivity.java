package com.example.punit.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by punit on 16/01/2016.
 */
public class WebviewActivity extends AppCompatActivity {

    private WebView wvResult;
    private ProgressBar pbLoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewactivity);
        wvResult = (WebView) findViewById(R.id.wvResult);
        pbLoad = (ProgressBar) findViewById(R.id.pbLoad);
    }



    @Override
    protected void onStart() {
        super.onStart();
        wvResult.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pbLoad.setVisibility(View.INVISIBLE);

            }
        });

        wvResult.loadUrl("https://www.Google.com");
        WebSettings webSettings = wvResult.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvResult.setWebChromeClient(new WebChromeClient());
    }

}
