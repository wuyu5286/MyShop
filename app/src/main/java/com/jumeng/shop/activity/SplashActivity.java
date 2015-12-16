package com.jumeng.shop.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.AlertDialogWrapper;
import com.jumeng.shop.R;
import com.jumeng.shop.constant.PreferencesKey;
import com.jumeng.shop.utils.NetUtils;
import com.jumeng.shop.utils.PreferencesUtils;
import com.jumeng.shop.utils.UIUtils;

public class SplashActivity extends AppCompatActivity {

    private PreferencesUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (!NetUtils.isConnected()) {//没有网络
            openNetSetting();
        } else {
            utils = PreferencesUtils.instance();
            boolean isFirst = utils.getBoolean(PreferencesKey.IS_FIRST);
            if (isFirst) {
                toGuide();
            } else {
                if (!checkVersion()) {//没有新版本
                    delayToMain();
                } else {//处理更新

                }
            }
        }
    }

    private void openNetSetting() {
        new AlertDialogWrapper.Builder(this).setTitle("提示").setMessage("是否开启网络?").setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NetUtils.openNetSetting(SplashActivity.this);
                dialog.dismiss();
                finish();
            }
        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.launch(SplashActivity.this);
                dialog.dismiss();
                finish();
            }
        }).create().show();
    }

    private boolean checkVersion() {
        return false;
    }

    private void delayToMain() {
        UIUtils.postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.launch(SplashActivity.this);
                finish();
            }
        }, 500);
    }

    private void toGuide() {

    }
}
