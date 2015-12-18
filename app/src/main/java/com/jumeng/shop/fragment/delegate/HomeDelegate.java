package com.jumeng.shop.fragment.delegate;

import android.widget.Button;

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


    @Bind(R.id.save)
    Button mSave;
    @Bind(R.id.query)
    Button mQuery;

    @Override
    public int layoutResId() {
        return R.layout.fragment_home;
    }

    public Button getSave() {
        return mSave;
    }

    public Button getQuery() {
        return mQuery;
    }
}
