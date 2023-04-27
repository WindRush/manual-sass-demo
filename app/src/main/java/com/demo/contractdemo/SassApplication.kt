package com.demo.contractdemo

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import io.bibeex.contract.common.bean.GridDetailsBean
import io.bibeex.contract.common.bean.all.BibeexUserUsableBalances
import io.bibeex.contract.sdk.tt.saas.SassLibSDK

class SassApplication : Application() {
    companion object {
        val host = "x.chimchim.top"
        val key = "xxOi"
        val jwtToken = "eyJhbGciOiJSUzI1NiJ9.eyJ1aWQiOiI1MTkwNjEyMyIsImVtYWlsIjoiLS0iLCJtb2JpbGUiOiIxMzEqKioqMDAwMSIsIm5pY2tuYW1lIjoiMTMxKioqKjAwMDEiLCJhcmVhIjoibnVsbCIsImludml0ZSI6IjMwMzk3Nzg0IiwiZXhwIjoxNjgzMTkzMzk2fQ.QH52up_c9cTi4P366GeIHu8RdfNumcmY5G9UaJVNJko_yJz05ft7zBWkqJoM7acb1OHx2r4MjyRnxyJI3zawaLbq7mXgliUPS8lcZMKVZ3YtrJLWNtKM6M4hYAE4gfE0U-aIVBwiO3Jh-u6aXjH4hgYmex1W7yciviAsjFLqE0DHrB6GhdtkOfE5V667seQWz8ZE6Ylmug7B6j-bk8uFrRw-SCAu5FjQzCsyGT70zcq4dsWwA_b8Ltwl1mSVVlO6_cUwbe625Fyvl0_Q-tW-4hMQVJj6P6Q5_XpLih9Dly4LQhsxSHhSQ8aiYxk8XWXKweIOBQn4t_iW8tEdoEfriA"

    }

    override fun onCreate() {
        super.onCreate()
        SassLibSDK.init(
            this,
            key,
            host,
            jwtToken,
            BuildConfig.DEBUG,
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
                    fromH5: Boolean,
                    isPermanent: Boolean
                ) {
                    Toast.makeText(this@SassApplication, Gson().toJson(item), Toast.LENGTH_SHORT).show()
                }

                override fun toast(msg: String, duration: Int) {
                    Toast.makeText(this@SassApplication,msg, Toast.LENGTH_SHORT).show()
                }
                override fun transfer(context: Context) {
                    Toast.makeText(context,"transfer go", Toast.LENGTH_SHORT).show()

                }
            })
    }
}






















