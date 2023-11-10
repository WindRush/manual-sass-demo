package com.demo.contractdemo

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.google.gson.Gson
import io.bibeex.contract.common.bean.GridDetailsBean
import io.bibeex.contract.common.bean.SharePositionEntity
import io.bibeex.contract.common.bean.all.BibeexUserUsableBalances
import io.bibeex.contract.sdk.tt.saas.SassLibSDK
import io.bibeex.contract.sdk.tt.saas.option.OnOptionBalanceChangeListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SassApplication : Application() {

    companion object {
        val host = "x.chimchim.top"
        val key = "xxOi"
        val jwtToken =
            "eyJhbGciOiJSUzI1NiJ9.eyJhcmVhIjoiODYiLCJ1aWQiOiI1MTkwNzI3NyIsIm1vYmlsZSI6IjE1MjM3MTI3NzUyIiwiaW52aXRlIjoiMzg0MjM3ODIiLCJlbWFpbCI6IjA0MDQxQHFxLmNvbSIsImV4cCI6MTcwMDgyMDc1MH0.plc_5h4FNDKdOkCfEcutT92Y6aHPFZZKeZAOulevwB5Llgx-rvhti3gWA1C42NS9IdHC8fJGnxsxpWOmxuHGNw6SkAAOeXz-NFCHBKLm1Ts7IJONGDhiWGUrumKqBjSs0dvZeXN9DVYUbl_Yp3Xgt4tqWta5AgTdREEiGkf9O31-iJr0WOEWpp4D55Om1oP_oO4F8sdvSDMRzpJr9mYc6h9X9vcVQ9HIJhc1vpS_LSB4kZrgVxh-cpbzanjQlDmPu4UKvhjDSyUAxLtYw2w3HNWx5WlTZLmPvLd8hgTsAIciOlZ0WKXlIGrnG4TF9ijXJ1P4WgCqKAOkI-TxWdPo3Q"
    }

    override fun onCreate() {
        super.onCreate()
        SassLibSDK.option = true
        SassLibSDK.init(
            this,
            key,
            host,
            BuildConfig.DEBUG,
            object : SassLibSDK.SassLibSdkCallBack() {
                override fun goLogin(context: Context) {
                    GlobalScope.launch(Dispatchers.Main) {
                        Toast.makeText(context,"go login", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun gotoWeb(
                    context: Context,
                    title: String,
                    url: String,
                    showTitle: Boolean
                ) {

                }

                override fun loginResult(success: Boolean) {
                    Toast.makeText(this@SassApplication,if (success) "登录成功" else "登录失败", Toast.LENGTH_SHORT).show()
                }

                override fun shareGridPosition(
                    context: Activity,
                    rootView: View,
                    item: GridDetailsBean
                ) {
                }

                override fun sharePosition(
                    context: Activity,
                    rootView: View,
                    item: BibeexUserUsableBalances.UserPositionsBean,
                    entity: SharePositionEntity
                ) {
                    Toast.makeText(this@SassApplication, Gson().toJson(item), Toast.LENGTH_SHORT).show()
                }

                /**
                 * @param status 0 normal 1 success 2 failed
                 */
                override fun stToast(msg: String, status: Int) {

                }

                override fun toast(msg: String, duration: Int) {
                    Toast.makeText(this@SassApplication,msg, Toast.LENGTH_SHORT).show()
                }
                override fun recharge(context: Context) {
                    Toast.makeText(context,"transfer go", Toast.LENGTH_SHORT).show()

                }

                override fun transferOption(
                    side: Int,
                    activity: Activity,
                    fragmentManager: FragmentManager,
                    listener: OnOptionBalanceChangeListener
                ) {
                    Toast.makeText(this@SassApplication,"请给期权充钱", Toast.LENGTH_SHORT).show()
                }
            })
    }
}






















