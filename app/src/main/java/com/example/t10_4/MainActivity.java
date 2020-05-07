package com.example.t10_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText webText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        webText = findViewById(R.id.webText);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

    }

    public void executeInit(View v) {
        web.evaluateJavascript("javascript:initialize()", null);
    }

    public void executeShout(View v) {
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    private String getAddress() {
        String a = webText.getText().toString();
        return a;
    }

    public void loadPage(View v) {
        String a = getAddress();
        String beginning = "http://";
        if (!a.equals("index.html")) {
            a = beginning + a;
            web.loadUrl(a);
        } else {
            web.loadUrl("file:///android_asset/index.html");
        }

    }

    public void refreshPage(View v) {
        web.reload();
    }

    public void goBack(View v) {
        web.goBack();
    }

    public void goForward(View v) {
        web.goForward();
    }

}
