package com.jumeng.shop.fragment;

import android.support.v7.widget.DefaultItemAnimator;

import com.jumeng.shop.R;
import com.jumeng.shop.adapter.HomeAdapter;
import com.jumeng.shop.fragment.delegate.HomeDelegate;
import com.jumeng.shop.widget.recycler.RecyclerUtils;
import com.jumeng.shop.widget.recycler.WrapRecyclerView;

/**
 * ============================================================
 * 描 述 : 首页
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class HomeFragment extends BaseFragment<HomeDelegate> {
    @Override
    protected Class<HomeDelegate> getDelegateClass() {
        return HomeDelegate.class;
    }

    String[] mStrings = {"aaa", "ccc", "ll", "ddd"};

    @Override
    protected void onBind() {
        super.onBind();
        WrapRecyclerView recyclerView = viewDelegate.getRecyclerView();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addHeaderView(RecyclerUtils.getView(R.layout.home_header, true));
        recyclerView.setAdapter(new HomeAdapter(activity, mStrings));
    }
}
