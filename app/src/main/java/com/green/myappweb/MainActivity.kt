package com.green.myappweb

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    lateinit internal var edtUrl : EditText
    lateinit internal var btnGo : Button
    lateinit internal var btnBack : Button
    lateinit internal var web : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
//        getSupportActionBar()!!.setIcon(R.drawable.web)


        edtUrl = findViewById<EditText>(R.id.edtUrl)
        btnGo = findViewById<Button>(R.id.btnGo)
        btnBack = findViewById<Button>(R.id.btnBack)
        web = findViewById<WebView>(R.id.webView1)

        web.webViewClient = CookWebViewClient()

        var webSet = web.settings
        //webSet.builtInZoomControls = true는 안드로이드에서 WebView 객체의 기본 제공 줌 컨트롤을 활성화하는 것을 나타냅니다.
        //WebView는 안드로이드 앱에서 웹 페이지를 표시하기 위한 컴포넌트입니다. 이 설정은 WebView에 내장된 줌 컨트롤을 사용할지 여부를 결정합니다. 만약 builtInZoomControls가 true로 설정되어 있다면, WebView에서는 사용자가 화면을 확대 또는 축소할 수 있는 기본 제공 줌 컨트롤이 표시됩니다. 사용자는 화면을 터치하고 제스처로 확대/축소할 수 있게 됩니다.
        webSet.builtInZoomControls = true

        btnGo.setOnClickListener {
            web.loadUrl(edtUrl.text.toString())
        }

        btnBack.setOnClickListener {
            web.goBack()
        }

    }


    class CookWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?,request: WebResourceRequest?): Boolean {
            return super.shouldOverrideUrlLoading(view, request)
        }
    }
}