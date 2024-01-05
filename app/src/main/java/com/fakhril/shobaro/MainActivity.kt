package com.fakhril.shobaro

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.fakhril.shobaro.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var urlWeb: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        urlWeb = intent.getStringExtra("urlWeb").toString()

        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl(urlWeb)

        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.webView.visibility == View.VISIBLE) {
                    // dont pass back button action
                    if (binding.webView.canGoBack()) {
                        binding.webView.goBack()
                    }
                    else{
                        finish()
                    }
                } else {
                    // pass back button action
                    finish()
                }
            }
        })
    }
}