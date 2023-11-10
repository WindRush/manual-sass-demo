# mobile-sdk-android
TinyTrader Android合约SDK

## 最低版本
+ minSdkVersion 21
## 支持的语言
+ English(default)
+ 한국어
+ 简体中文

## 通过Maven引入
#### 1.把以下代码加入 `project -> build.gradle`:
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
        google()
        maven {
            url 'https://maven.aliyun.com/repository/public'
        }
        maven {
            credentials {
                username '632845ef0bdb33a273e25c1a'
                password 'OfRXphus7gPL'
            }
            url 'https://packages.aliyun.com/maven/repository/2269018-release-hMOQ2q/'
        }
       
    }
}
```

#### 2.引入 `project -> app -> build.gradle` :
```gradle
    android {
        dataBinding {
            enabled = true
        }
    }
    implementation 'io.bibeex.tiny.trader:contract:0.1.35'
```

## 快速开始
#### 1. 在你的application中初始化
```kotlin
    SassLibSDK.init(
    application, /* your application */
    host, /* host name*/
    k5fu3, /*channel id value*/
    BuildConfig.DEBUG, /*是否debug*/
    object : SassLibSDK.SassLibSdkCallBack {
        override fun goLogin(context: Context) {
            // 跳转去登录
        }
        override fun recharge(context: Context) {
            // 充币
        }
        override fun loginResult(success: Boolean) {
            // 登录后回调
        }
        override fun toast(msg: String, duration: Int) {
            // 吐司
        }
        /** 包含状态的吐司
         * @param status 0 normal 1 success 2 failed
         */
        override fun stToast(msg: String, status: Int) {

        }
        
        override fun gotoWeb(context: Context, title: String, url: String, showTitle: Boolean) { 
            // 跳转webview
        }
        /**
         * @param entity 分享实例，包含字段：
         *                  direction：”long” 做多，”short“ 做空
         *                  profitRate：盈亏率 > 0 盈利， < 0 亏损
         *                  instrument：合约类型，如BTC,ETH
         *                  openPrice：开仓价
         *                  targetPrice：当前价/平仓价
         */
        override fun sharePosition(
            context: Activity,
            rootView: View,
            item: BibeexUserUsableBalances.UserPositionsBean,
            entity: SharePositionEntity
        ) {
            // 合约仓位分享
        }
        override fun onHttpCodeError(code: String) {
            super.onHttpCodeError(code)
            if (code == HttpRequestResultStatus.REQ_TOKEN_LOSE
                || code == HttpRequestResultStatus.HTTP_ERROR_CODE) {
                // token过期回调 或者 返回错误码
            } 
        }

        // 期权划转
        override fun transferOption(side: Int, activity: Activity, fragmentManager: FragmentManager) {
            // 往期权划转
        }
    })
```
```kotlin
SassLibSDK.login(sfg6) /* 宿主APP登录后调用，@param sfg6 is your token*/
SassLibSDK.logout() /*宿主app退出登录后调用*/
```
#### 2. 把需要的功能Fragment嵌入你的activity，比如：
```kotlin
class SassMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)
        back_iv?.setOnClickListener { finish() }
        // 永续合约
        supportFragmentManager.beginTransaction()
            .add(R.id.fg_container, PermanentContractFragment.newInstance())
            .commitAllowingStateLoss()
        // 赠金模式
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fg_container, LightingFragment.newInstance())
//            .commitAllowingStateLoss()
        // 期权合约
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fg_container, OptionFragment.newInstance())
//            .commitAllowingStateLoss()
        // 秒合约
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fg_container, SecondsContractFragment.newInstance())
//            .commitAllowingStateLoss()
    }
}
```

#### 3. 修改主题色，在你的`colors.xml`里复写 `hyp_tiny_saas_main_theme` ：
```xml
    <color name="hyp_tiny_saas_main_theme">#D0A858</color>
```
#### 4. 修改SDK语言：
```kotlin
    SassLibSDK.changeLanguage(Locale.ENGLISH);
```
#### 5. 合约相关方法：
```kotlin
    // 获取赠金可划转余额
    SassLibSDK.requestCashProfit {
        Toast.makeText(this@StartActivity, "可划转余额：${it}", Toast.LENGTH_SHORT).show()
    }

    // 赠金余额划转，amount: 划转金额
    val amount = etAmount?.text?.toString()
    SassLibSDK.transferProfit(amount ?:return@setOnClickListener) { success, msg ->
        if (success) {
            Toast.makeText(this@StartActivity, "划转成功", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@StartActivity, msg, Toast.LENGTH_SHORT).show()
    
        }
    }
    // 获取永续合约资产数据
    SassLibSDK.requestPerpetualAssetDataWithCallback { available, freeze, unrealizeProfit, totalMargin ->
        val str = "余额:$available, 冻结:$freeze,未实现盈亏:$unrealizeProfit,保证金:$totalMargin"
        Toast.makeText(this@StartActivity, str, Toast.LENGTH_SHORT).show()
    }
```

建议:
### 开启相关页面之前链接socket：`connectSocket`,
### 页面关闭之后关闭socket： `disconnectSocket`.

















