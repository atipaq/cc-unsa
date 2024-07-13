package com.example.cc_unsa.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cc_unsa.view.customview.MainSketchView

class MainMapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainSketchView = MainSketchView(this)
        setContentView(mainSketchView)
    }
}