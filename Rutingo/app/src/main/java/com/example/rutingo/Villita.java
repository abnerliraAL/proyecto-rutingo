package com.example.rutingo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Villita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_villita);
        WebView view = (WebView) findViewById(R.id. webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.loadUrl("https://www.google.com/maps/d/u/0/viewer?mid=1_9R9Y6BiT0K5gbrsqgwA1WKjwcxHQuKj&ll=20.07778561406383%2C-98.399135&z=14");


        view.setWebViewClient(new WebViewClient(){
            public boolean shouldOverriceUrlLoalding(WebViewClient view, String url){
                return false;
            }
        });

    }
    }
