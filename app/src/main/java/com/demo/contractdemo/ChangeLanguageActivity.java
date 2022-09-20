//package com.demo.contractdemo;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//
//import org.greenrobot.eventbus.EventBus;
//
//import com.sass.contract.base.BaseActivity;
//import com.sass.contract.common.http.utils.DLog;
//import com.sass.contract.event.BizEvent;
//import com.sass.contract.manager.AppManager;
//import com.sass.contract.util.Constant;
//import com.sass.contract.util.ExchangeConstant;
//import com.sass.contract.util.config.ConfigurationUtils;
//import com.sass.contract.utlis.SpUtils;
//
///**
// * Created by Administrator on 2019/4/12 0012.
// */
//
//public class ChangeLanguageActivity extends BaseActivity implements View.OnClickListener {
//
//    LinearLayout chinese_ll;
//    LinearLayout english_ll;
//    LinearLayout korea_ll;
//
//    String currentLang = null;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        chinese_ll = findViewById(R.id.chinese_ll);
//        english_ll = findViewById(R.id.english_ll);
//        chinese_ll.setOnClickListener(this);
//        english_ll.setOnClickListener(this);
//        korea_ll = findViewById(R.id.ko_ll);
//        korea_ll.setOnClickListener(this);
//    }
//
//    @Override
//    protected int getContentViewId() {
//        return R.layout.activity_change_language;
//    }
//
//    @Override
//    protected void injectDagger() {
//
//    }
//
//    @Override
//    protected void initViewsAndEvents() {
//        int id = 0;
//        String currentLang = ConfigurationUtils.getCurrentLangPath(this);
//        switch (currentLang){
//            case "zh-CN":
//                id = R.id.ch_check;
//                break;
//            case "en-US":
//                id = R.id.eng_check;
//                break;
//            case "ko-KR":
//                id= R.id.ko_check;
//                break;
//            default:
//                id = R.id.ch_check;
//                break;
//        }
//        findViewById(id).setVisibility(View.VISIBLE);
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        currentLang = ConfigurationUtils.getCurrentLangPath(this);
//        switch (v.getId()) {
//
//            case R.id.chinese_ll:
//                if (currentLang.equals("zh-CN")){
//                    finish();
//                    return;
//                }
//                currentLang = "zh-CN";
//                changeLang("zh");
//
//                break;
//            case R.id.english_ll:
//                if (currentLang.equals("en-US")) {
//                    finish();
//                    return;
//                }
//                currentLang = "en-US";
//                changeLang("en");
//
//                break;
//            case R.id.ko_ll:
//                if (currentLang.equals("ko-KR")) {
//                    finish();
//                    return;
//                }
//                currentLang = "ko-KR";
//                changeLang("ko");
//
//                break;
//        }
//    }
//    private void changeLang(String lang){
//        SpUtils.putString(Constant.KEY_LANG,lang);
//        setLang(lang);
//    }
//
//
//    public void setLang(String lang){
//        DLog.getInstance().e("lang="+lang);
//        SpUtils.putString(Constant.KEY_LANG,lang);
//        ConfigurationUtils.updateActivity(this);
//        EventBus.getDefault().post(new BizEvent.InitPositionEvent());
//        finish();
//
//    }
//
//}
