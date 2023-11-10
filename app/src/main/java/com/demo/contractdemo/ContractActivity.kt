package com.demo.contractdemo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.bibeex.contract.sdk.tt.saas.SassLibSDK
import io.bibeex.contract.sdk.tt.saas.ui.activity.contract_trade.PermanentContractFragment


class ContractActivity : AppCompatActivity() {

    lateinit var permanentContractFragment: PermanentContractFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lighting)
        SassLibSDK.connectSocket()
        permanentContractFragment = PermanentContractFragment.newInstance() as PermanentContractFragment
        supportFragmentManager.beginTransaction()
            .add(R.id.flContent, permanentContractFragment)
            .commitAllowingStateLoss()
    }

    override fun onDestroy() {
        super.onDestroy()
        SassLibSDK.disconnectSocket()
    }

}