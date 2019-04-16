package com.example.rutingo;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Ampliacion extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ampliacion);
        WebView view = (WebView) findViewById(R.id. webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(true);
        view.loadUrl("https://www.google.com/maps/d/u/0/viewer?mid=1qaqne8IDKY9Ofjab_AjRTcY-J_v8PskE&ll=0%2C0&z=14");


        view.setWebViewClient(new WebViewClient(){
            public boolean shouldOverriceUrlLoalding(WebViewClient view, String url){
                return false;
            }
        });

    }
}


