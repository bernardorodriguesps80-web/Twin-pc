package com.twinpc.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.content.Context
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*

class MainActivity : Activity() {
    private val navy = Color.rgb(20, 40, 75)
    private val blue = Color.rgb(0, 120, 215)
    private lateinit var root: LinearLayout
    private lateinit var address: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun showHome() {
        root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.rgb(240, 244, 250))
            setPadding(22, 28, 22, 22)
        }
        val header = TextView(this).apply {
            text = "⊞  Twin PC"
            textSize = 30f
            setTextColor(Color.WHITE)
            setPadding(20, 24, 20, 24)
            setBackgroundColor(navy)
        }
        root.addView(header, LinearLayout.LayoutParams(-1, -2))
        val title = TextView(this).apply {
            text = "Seu computador, em qualquer lugar."
            textSize = 21f
            setTextColor(Color.rgb(25, 45, 75))
            setPadding(0, 28, 0, 8)
        }
        root.addView(title)
        val info = TextView(this).apply {
            text = "Conecte-se a um computador remoto compatível com navegador (por exemplo, uma sessão noVNC). O servidor Windows precisa existir separadamente."
            textSize = 15f
            setTextColor(Color.DKGRAY)
        }
        root.addView(info)
        val label = TextView(this).apply {
            text = "Endereço da sessão remota"
            textSize = 15f
            setTextColor(navy)
            setPadding(0, 26, 0, 8)
        }
        root.addView(label)
        address = EditText(this).apply {
            hint = "https://endereco-da-sua-sessao"
            textSize = 15f
            singleLine = true
            inputType =  UriInputType()
            setPadding(14, 12, 14, 12)
            setBackgroundColor(Color.WHITE)
        }
        root.addView(address, LinearLayout.LayoutParams(-1, -2))
        val connect = Button(this).apply {
            text = "CONECTAR"
            setTextColor(Color.WHITE)
            setBackgroundColor(blue)
            setOnClickListener {
                val url = address.text.toString().trim()
                if (!url.startsWith("https://")) {
                    Toast.makeText(this@MainActivity, "Use um endereço HTTPS válido.", Toast.LENGTH_LONG).show()
                } else {
                    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                        .hideSoftInputFromWindow(address.windowToken, 0)
                    showRemote(url)
                }
            }
        }
        val p = LinearLayout.LayoutParams(-1, -2)
        p.topMargin = 18
        root.addView(connect, p)
        val footer = TextView(this).apply {
            text = "TWIN PC  •  VERSÃO 1.0  •  PROTÓTIPO"
            textSize = 11f
            setTextColor(Color.GRAY)
            gravity = Gravity.CENTER
            setPadding(0, 32, 0, 0)
        }
        root.addView(footer)
        setContentView(root)
    }

    private fun UriInputType(): Int = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_URI

    private fun showRemote(url: String) {
        val web = WebView(this)
        web.settings.javaScriptEnabled = true
        web.settings.domStorageEnabled = true
        web.webChromeClient = WebChromeClient()
        web.webViewClient = WebViewClient()
        web.loadUrl(url)
        setContentView(web)
    }

    @Deprecated("Deprecated in Android")
    override fun onBackPressed() {
        showHome()
    }
}
