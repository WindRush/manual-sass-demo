package com.demo.contractdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tvLan)?.setOnClickListener {
            lan()
        }
    }


    private fun lan() {
        startActivity(Intent(this, ChangeLanguageActivity::class.java))
    }

}