# mobile-sdk-android
TinyTrader 合约SDK

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
    implementation 'io.bibeex.tiny.trader:contract:0.1.18'
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
        
        override fun gotoWeb(context: Context, title: String, url: String, showTitle: Boolean) { 
            // 跳转webview
        }
        override fun sharePosition(
            context: Activity,
            rootView: View,
            item: BibeexUserUsableBalances.UserPositionsBean,
            fromH5: Boolean = false,
            isPermanent: Boolean
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
        supportFragmentManager.beginTransaction()
            .add(R.id.fg_container, PermanentContractFragment.newInstance())
            .commitAllowingStateLoss()
    }
}
```
##### 永续合约 ```PermanentContractFragment.newInstance()```
##### 赠金合约 ```LightingFragment()```
##### 期权合约 ```OptionFragment()```


#### 3. 修改主题色，在你的`colors.xml`里复写 `hyp_tiny_saas_main_theme` ：
```xml
    <color name="hyp_tiny_saas_main_theme">#D0A858</color>
```
#### 4. 修改SDK语言：
```kotlin
    SassLibSDK.changeLanguage(Locale.ENGLISH);
```

建议:
### 开启相关页面之前链接socket：`connectSocket`,
### 页面关闭之后关闭socket： `disconnectSocket`.

















