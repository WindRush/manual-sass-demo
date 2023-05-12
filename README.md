# mobile-sdk-android
Perpetual futures SDK for Android

## Requirements
+ minSdkVersion 21
## Supported languages
+ English(default)
+ 한국어
+ 简体中文

## Installation Via Maven
#### 1.Add the following lines to `project -> build.gradle`:
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

#### 2.Add the following lines to `project -> app -> build.gradle` :
```gradle
    implementation 'io.bibeex.tiny.trader:contract:0.1.26'
```

## Quick Tutorial
#### 1. Setup the SDK on App startup
```kotlin
    SassLibSDK.init(
    application, /* your application */
    host, /* host name*/
    k5fu3, /*channel id value*/
    BuildConfig.DEBUG, /*is debug mode, print the log if true*/
    object : SassLibSDK.SassLibSdkCallBack {
        override fun goLogin(context: Context) {
            // jump to login
        }
        override fun recharge(context: Context) {
            // jump to recharge
        }
        override fun loginResult(success: Boolean) {
            // login callback 
        }
        override fun toast(msg: String, duration: Int) {
            // you should showToast with msg
        }
        
        override fun gotoWeb(context: Context, title: String, url: String, showTitle: Boolean) { 
            // jump to webview
        }

        /**
         * @param entity inside constant：
         *                  direction：”long” ，”short“ 
         *                  profitRate： > 0 profit， < 0 loss
         *                  instrument：contract name, BTC,ETH
         *                  openPrice：
         *                  targetPrice：currentPrice/closePrice
         */
        override fun sharePosition(
            context: Activity,
            rootView: View,
            item: BibeexUserUsableBalances.UserPositionsBean,
            entity: SharePositionEntity
        ) {
            // share position
        }
        override fun onHttpCodeError(code: String) {
            super.onHttpCodeError(code)
            if (code == HttpRequestResultStatus.REQ_TOKEN_LOSE
                || code == HttpRequestResultStatus.HTTP_ERROR_CODE) {
                // token Expired or http error
            } 
        }

        // 期权划转
        override fun transferOption(side: Int, activity: Activity, fragmentManager: FragmentManager) {
            // transfer into option
        }
    })
```
```kotlin
SassLibSDK.login(sfg6) /* call after login，@param sfg6 is your token*/
SassLibSDK.logout() /*call after logout*/
```
#### 2. you should nested the Saas Fragment into your Activity like this:
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
##### contract is ```PermanentContractFragment.newInstance()```
##### infinite contract is ```LightingFragment()```
##### option contract is ```OptionFragment()```


#### 3. change the theme color, override the `hyp_tiny_saas_main_theme` in your `colors.xml`，like this:
```xml
    <color name="hyp_tiny_saas_main_theme">#D0A858</color>
```
#### 4. change language:
```kotlin
    SassLibSDK.changeLanguage(Locale.ENGLISH);
```

Tips:
### before launch the SDK's Contract Fragment, you need to call `connectSocket`,
### after finish the Contract Fragment, you need to call `disconnectSocket`.

















