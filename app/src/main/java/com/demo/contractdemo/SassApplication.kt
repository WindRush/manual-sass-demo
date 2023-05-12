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

class SassApplication : Application() {

    companion object {
        //        val host = "x.chimchim.top"
        val host = "x.123kj.top"
        val key = "xxOi"
        val jwtToken = "eyJhbGciOiJSUzI1NiJ9.eyJ1aWQiOiI1MTkwNjEyOCIsImVtYWlsIjoic2oqKioqQHFxLmNvbSIsIm1vYmlsZSI6InNqKioqKkBxcS5jb20iLCJuaWNrbmFtZSI6InNqKioqKkBxcS5jb20iLCJhcmVhIjoibnVsbCIsImludml0ZSI6IiIsImV4cCI6MTY4NDExNzg0OH0.gNKBxcW3PpXWUUKNRsA8NoRB2XOguXFR8qe4nRHNOI218Rt2edpCqJRMheQCb5k0MhmYcKGDfxYnKh2TNhPpKkzjm52iLgDM_VoX-fzTYtqkqxoLjMRMTZTqsuoqUn1lqUh5qzDJzs29Z8pwNHcsi_DPZ_3x-jzigstUSnzki3DGNF76Iy7eA3reaBbKz2YVWvAMMokgZfqjbdq17mveS--q18sx4r0YgLl9C713TmDiYTwL7P6Qfc4-_K-IbRWDeLYpUdJM_CIfvsJG0dbrtz_KiuDs54S3iI_lwvXKhb8zmul7WpL-H_ER60_MGLfE3DPKVicZ2yNzRl8-RUqXHQ"
    }

    override fun onCreate() {
        super.onCreate()
        SassLibSDK.option = true
        SassLibSDK.init(
            this,
            key,
            host,
            BuildConfig.DEBUG,
            true,
            object : SassLibSDK.SassLibSdkCallBack() {
                override fun goLogin(context: Context) {
                    Toast.makeText(context,"go login", Toast.LENGTH_SHORT).show()
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
                    val price = entity.getCalOpenPrice()
                    Toast.makeText(this@SassApplication, Gson().toJson(item), Toast.LENGTH_SHORT).show()
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
                    fragmentManager: FragmentManager
                ) {
                    Toast.makeText(this@SassApplication,"请给期权充钱", Toast.LENGTH_SHORT).show()
                }
            })
//
//        SassLibSDK.login(jwtToken)
    }
}






















