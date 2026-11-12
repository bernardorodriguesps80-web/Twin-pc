package com.twinpc.app

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setBackgroundColor(0xFF0078D4.toInt())

        val title = TextView(this)
        title.text = "Twin PC"
        title.textSize = 28f
        title.setTextColor(-1)
        title.setPadding(20, 30, 20, 20)
        layout.addView(title)

        val address = EditText(this)
        address.hint = "Digite o endereço do seu PC"
        address.setSingleLine(true)
        address.setText("https://")
        layout.addView(address)

        val button = Button(this)
        button.text = "Conectar"
        layout.addView(button)

        val web = WebView(this)
        web.settings.javaScriptEnabled = true
        web.settings.domStorageEnabled = true
        web.webViewClient = WebViewClient()
        web.webChromeClient = WebChromeClient()

        layout.addView(
            web,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        button.setOnClickListener {
            val url = address.text.toString().trim()
            if (url.startsWith("https://") || url.startsWith("http://")) {
                web.loadUrl(url)
            } else {
                Toast.makeText(this, "Endereço inválido", Toast.LENGTH_SHORT).show()
            }
        }

        setContentView(layout)
    }
}
