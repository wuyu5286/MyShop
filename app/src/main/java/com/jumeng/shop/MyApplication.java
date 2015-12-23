package com.jumeng.shop;

import android.app.Application;
import android.os.Handler;

import com.jumeng.shop.db.util.DbCore;
import com.jumeng.shop.utils.PreferencesUtils;
import com.socks.library.KLog;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/16.
 * ============================================================
 */
public class MyApplication extends Application {

    private static MyApplication instance;
    private static long mainThreadId;
    private static Handler mainHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mainThreadId = android.os.Process.myTid();
        mainHandler = new Handler();
<<<<<<< HEAD
        KLog.init(BuildConfig.LOG_DEBUG);//debug打印
        PreferencesUtils.instance().init(this);//数据存储
=======
        KLog.init(BuildConfig.LOG_DEBUG);
        PreferencesUtils.instance().init(this);
>>>>>>> 00eb8f4861eb752da35b7257d832484522cf2d2f
        DbCore.init(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public static long getMainThreadId() {
        return mainThreadId;
    }

    public static Handler getMainHandler() {
        return mainHandler;
    }
}
