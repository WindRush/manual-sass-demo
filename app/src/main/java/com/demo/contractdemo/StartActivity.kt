package com.demo.contractdemo

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sass.contract.SassLibSDK
import com.sass.contract.SassMainActivity
import com.sass.contract.base.BaseActivity
import com.sass.contract.module.trade.PermanentContractFragment

class StartActivity : BaseActivity() {
    val editText: EditText? by lazy {
        findViewById(R.id.et)
    }

//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onCreate(savedInstanceState, persistentState)
//        setContentView(R.layout.activity_start)
//        initViewsAndEvents()
//    }

    override fun getContentViewId(): Int {
        return R.layout.activity_start
    }

    override fun injectDagger() {
    }

    override fun initViewsAndEvents() {
        findViewById<Button>(R.id.setting)?.setOnClickListener {
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
        }

        findViewById<View>(R.id.btnGo)?.setOnClickListener {
            val token = editText?.text?.toString()?.trim()
            if (token.isNullOrEmpty()) {
                Toast.makeText(this@StartActivity, "token 不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            SassLibSDK.login(token)
            startActivity(Intent(this@StartActivity, SassMainActivity::class.java))
        }

        if (SassLibSDK.isLogin()) startActivity(Intent(this@StartActivity, SassMainActivity::class.java))
    }

}