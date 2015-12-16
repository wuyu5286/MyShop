package com.jumeng.shop.fragment.delegate;

import android.widget.TextView;

import com.jumeng.shop.R;
import com.jumeng.shop.interfaces.AppDelegate;

import butterknife.Bind;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class HomeDelegate extends AppDelegate {

    @Bind(R.id.home_text)
    TextView mHomeText;

    @Override
    public int layoutResId() {
        return R.layout.fragment_home;
    }

    public TextView getHomeText() {
        return mHomeText;
    }
}
