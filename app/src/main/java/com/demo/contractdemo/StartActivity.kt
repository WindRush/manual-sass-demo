package com.demo.contractdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import io.bibeex.contract.common.utlis.SpUtils
import io.bibeex.contract.sdk.tt.saas.SassLibSDK
import io.bibeex.contract.sdk.tt.saas.SassMainActivity
import io.bibeex.contract.sdk.tt.saas.ui.activity.contract_trade.PermanentContractFragment

class StartActivity : AppCompatActivity() {
    val editText: EditText? by lazy {
        findViewById(R.id.etToken)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val night = if (SpUtils.getBoolean("MODE_DAY_NIGHT")) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        AppCompatDelegate.setDefaultNightMode(night)
        findViewById<Button>(R.id.setting)?.setOnClickListener {
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
        }

        findViewById<ImageView>(R.id.ivClear)?.setOnClickListener {
            editText?.setText("")
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
        findViewById<View>(R.id.btnOption)?.setOnClickListener {
            startActivity(Intent(this@StartActivity, OptionActivity::class.java))
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

        editText?.setText(SassApplication.jwtToken)


    }



}