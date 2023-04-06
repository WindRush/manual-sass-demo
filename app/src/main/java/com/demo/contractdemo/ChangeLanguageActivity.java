package com.demo.contractdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;

import com.sass.contract.SassLibSDK;
import com.sass.contract.base.BaseActivity;
import com.sass.contract.event.BizEvent;

import java.util.Locale;

/**
 * Created by Administrator on 2019/4/12 0012.
 */

public class ChangeLanguageActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout chinese_ll;
    LinearLayout english_ll;
    LinearLayout korea_ll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_change_language);
        chinese_ll = findViewById(R.id.chinese_ll);
        english_ll = findViewById(R.id.english_ll);
        chinese_ll.setOnClickListener(this);
        english_ll.setOnClickListener(this);
        korea_ll = findViewById(R.id.ko_ll);
        korea_ll.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.chinese_ll:
                SassLibSDK.INSTANCE.changeLanguage(Locale.CHINA);

                break;
            case R.id.english_ll:
                SassLibSDK.INSTANCE.changeLanguage(Locale.ENGLISH);
                break;
            case R.id.ko_ll:
                SassLibSDK.INSTANCE.changeLanguage(Locale.KOREA);

                break;
        }
    }

}
