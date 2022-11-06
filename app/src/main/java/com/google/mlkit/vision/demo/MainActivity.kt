package com.google.mlkit.vision.demo

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import com.google.mlkit.vision.demo.java.CameraXLivePreviewActivity
import com.google.mlkit.vision.demo.kotlin.CameraXSourceDemoActivity

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val btn = findViewById<Button>(R.id.opendetection)
//        btn.setOnClickListener {
//            val i = Intent(this,CameraXSourceDemoActivity::class.java)
//            startActivity(i)
//        }
    }
}