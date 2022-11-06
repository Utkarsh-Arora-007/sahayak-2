package com.google.mlkit.vision.demo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.mlkit.vision.demo.R


class WheelChairFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_wheel_chair, container, false)
        // val url :String = arguments?.getString("https://www.irctctourism.com/wheelchair").toString()
        view.findViewById<WebView>(R.id.webview).webViewClient = WebViewClient()
        view.findViewById<WebView>(R.id.webview).loadUrl("https://www.irctctourism.com/wheelchair")

        return view
    }

}