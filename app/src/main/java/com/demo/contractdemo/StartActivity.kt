package com.demo.contractdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.sass.contract.SassLibSDK
import com.sass.contract.SassMainActivity

class StartActivity : AppCompatActivity() {
    val editText: EditText? by lazy {
        findViewById(R.id.et)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        findViewById<Button>(R.id.setting)?.setOnClickListener {
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
        }

        findViewById<View>(R.id.btnGo)?.setOnClickListener {
            val token = editText?.text?.toString()?.trim()
            if (!token.isNullOrEmpty()) SassLibSDK.login(token)
            startActivity(Intent(this@StartActivity, SassMainActivity::class.java))
        }

        if (SassLibSDK.isLogin()) startActivity(Intent(this@StartActivity, SassMainActivity::class.java))
    }


}