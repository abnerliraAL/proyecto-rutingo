package com.example.rutingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Francisco_villa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_francisco_villa);
        WebView view = (WebView) findViewById(R.id. webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.loadUrl("https://www.google.com/maps/d/u/0/viewer?mid=1VsoidXJHYH6avHHqGJ-30vniKKBFMOTf&ll=20.0791646%2C-98.36824489999998&z=14");


        view.setWebViewClient(new WebViewClient(){
            public boolean shouldOverriceUrlLoalding(WebViewClient view, String url){
                return false;
            }
        });

    }
    }
