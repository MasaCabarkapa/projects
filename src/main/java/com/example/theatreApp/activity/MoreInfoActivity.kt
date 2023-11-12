package com.example.theatreApp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.theatreApp.R

class MoreInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

        val myWebView: WebView = findViewById(R.id.webview);
        myWebView.loadUrl("https://www.snp.org.rs/");
    }
}