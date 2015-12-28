package com.jumeng.shop.utils;

import android.graphics.Typeface;
import android.widget.TextView;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/28.
 * ============================================================
 */
public class TTFUtils {
    public static void setTTF(TextView view) {
        Typeface typeface = Typeface.createFromAsset(UIUtils.getContext().getAssets(), "iconfont.ttf");
        view.setTypeface(typeface);
    }
}
