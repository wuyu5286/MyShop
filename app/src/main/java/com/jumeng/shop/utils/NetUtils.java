package com.jumeng.shop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/16.
 * ============================================================
 */
public class NetUtils {

    /**
     * 判断网络是否可用
     */
    public static boolean isAvailable() {
        NetworkInfo info = getNetworkInfo();
        if (null != info && info.isAvailable()) {
            return true;
        }
        return false;
    }

    /**
     * 判断网络是否连接
     */
    public static boolean isConnected() {
        NetworkInfo info = getNetworkInfo();
        if (null != info && info.isConnected()) {
            if (info.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    public static NetworkInfo getNetworkInfo() {
        ConnectivityManager connectivity = (ConnectivityManager) UIUtils.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != connectivity) {
            return connectivity.getActiveNetworkInfo();
        }
        return null;
    }

    /**
     * 获取网络类型
     */
    public static String getNetworkType() {
        ConnectivityManager connMgr = (ConnectivityManager) UIUtils.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null) {
            switch (networkInfo.getType()) {
                case ConnectivityManager.TYPE_MOBILE:
                    return "mobile";
                case ConnectivityManager.TYPE_WIFI:
                    return "wifi";
            }
        }
        return "none";
    }

    /**
     * 打开网络设置页面
     */
    public static void openNetSetting(Activity activity) {
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
        activity.startActivity(intent);
    }
}
