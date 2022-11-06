package com.google.mlkit.vision.demo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.mlkit.vision.demo.R
import com.google.mlkit.vision.demo.databinding.FragmentMinistryOfDisabledWebViewBinding


class MinistryOfDisabledWebViewFragment : Fragment() {


    lateinit var binding:FragmentMinistryOfDisabledWebViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMinistryOfDisabledWebViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var myWebView = binding.webview

        myWebView.loadUrl("https://disabilityaffairs.gov.in//content/index.php")
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(viewx: WebView, urlx: String): Boolean {
                viewx.loadUrl(urlx)
                return false
            }
        }
    }


}