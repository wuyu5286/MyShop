package com.jumeng.shop.fragment.delegate;

import com.jumeng.shop.R;
import com.jumeng.shop.interfaces.AppDelegate;
import com.jumeng.shop.widget.recycler.WrapRecyclerView;

import butterknife.Bind;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class HomeDelegate extends AppDelegate {

    @Bind(R.id.home_recycler_view)
    WrapRecyclerView mRecyclerView;

    @Override
    public int layoutResId() {
        return R.layout.fragment_home;
    }

    public WrapRecyclerView getRecyclerView() {
        return mRecyclerView;
    }
}
