package com.google.mlkit.vision.demo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.mlkit.vision.demo.R
import com.google.mlkit.vision.demo.databinding.FragmentHelperBinding


class HelperFragment : Fragment() {

    lateinit var binding:FragmentHelperBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHelperBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var myWebView = binding.webview

        myWebView.loadUrl("https://www.sulekha.com/disabled-care-services/delhi?ref=google&qz_q=disabled%20care%20services&qz_ad=609889088325&th=phrase&utm_source=google&utm_medium=cpc&utm_campaign=phrase&campaign=17735831270&Adgroup=144414395728&pagetype=sem ")
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(viewx: WebView, urlx: String): Boolean {
                viewx.loadUrl(urlx)
                return false
            }
        }
    }
}