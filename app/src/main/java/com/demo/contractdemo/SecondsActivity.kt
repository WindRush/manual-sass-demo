package com.demo.contractdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.bibeex.contract.sdk.tt.saas.SassLibSDK
import io.bibeex.contract.sdk.tt.saas.ui.activity.contract_trade.seconds.SecondsContractFragment

class SecondsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lighting)
        SassLibSDK.connectSocket()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContent, SecondsContractFragment.newInstance())
            .commitAllowingStateLoss()
    }

    override fun onDestroy() {
        super.onDestroy()
        SassLibSDK.disconnectSocket()
    }
}