package com.demo.contractdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import io.bibeex.contract.sdk.tt.saas.SassLibSDK
import io.bibeex.contract.sdk.tt.saas.SassMainActivity
import io.bibeex.contract.sdk.tt.saas.ui.activity.contract_trade.LightingFragment2
import io.bibeex.contract.sdk.tt.saas.ui.activity.contract_trade.PermanentContractFragment

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

        findViewById<View>(R.id.btnLogin)?.setOnClickListener {
            val token = editText?.text?.toString()?.trim()
            if (!token.isNullOrEmpty())
                SassLibSDK.login(token)
        }

        findViewById<View>(R.id.btnContract)?.setOnClickListener {
            startActivity(Intent(this@StartActivity, SassMainActivity::class.java))
        }

        findViewById<View>(R.id.btnLighting)?.setOnClickListener {
            startActivity(Intent(this@StartActivity, LightingActivity::class.java))
        }


//        PermanentContractFragment()
//        LightingFragment2
    }


}