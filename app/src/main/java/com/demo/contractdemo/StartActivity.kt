package com.demo.contractdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.bibeex.contract.sdk.tt.saas.SassLibSDK
import io.bibeex.contract.sdk.tt.saas.SassMainActivity

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

        findViewById<View>(R.id.btnCashProfit)?.setOnClickListener {
            SassLibSDK.requestCashProfit {
                Toast.makeText(this@StartActivity, "可划转余额：${it}", Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<View>(R.id.btnTransfer)?.setOnClickListener {
            val etAmount = findViewById<EditText>(R.id.etAmount)
            val amount = etAmount?.text?.toString()

            SassLibSDK.transferProfit(amount ?:return@setOnClickListener) { success, msg ->
                if (success) {
                    Toast.makeText(this@StartActivity, "划转成功", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@StartActivity, msg, Toast.LENGTH_SHORT).show()

                }
            }
        }


//        PermanentContractFragment()
//        LightingFragment2
    }


}