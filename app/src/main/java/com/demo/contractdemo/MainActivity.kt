package com.demo.contractdemo

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import io.bibeex.contract.common.utlis.SpUtils

class MainActivity : AppCompatActivity() {
    val ivNight: ImageView by lazy {
        findViewById<ImageView>(R.id.ivNight)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tvLan)?.setOnClickListener {
            lan()
        }
        ivNight.setOnClickListener {
            setNight()
        }
        if (SpUtils.getBoolean("MODE_DAY_NIGHT")) {
            ivNight.setImageResource(R.drawable.hyp_tiny_saas_ic_sun)
        } else {
            ivNight.setImageResource(R.drawable.hyp_tiny_saas_ic_night)
        }
    }

    private fun setNight() {
        val currentNightMode =
            getResources().getConfiguration().uiMode.and(Configuration.UI_MODE_NIGHT_MASK)
        //  设置全局静态变量
        val isNight = currentNightMode == Configuration.UI_MODE_NIGHT_NO
        //  切换模式
        AppCompatDelegate.setDefaultNightMode(
            if (isNight) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )
        //  将是否为夜间模式保存到SharedPreferences
        SpUtils.putBoolean("MODE_DAY_NIGHT", isNight)

        if (isNight) {
            ivNight.setImageResource(R.drawable.hyp_tiny_saas_ic_sun)
        } else {
            ivNight.setImageResource(R.drawable.hyp_tiny_saas_ic_night)
        }
    }


    private fun lan() {
        startActivity(Intent(this, ChangeLanguageActivity::class.java))
    }

}