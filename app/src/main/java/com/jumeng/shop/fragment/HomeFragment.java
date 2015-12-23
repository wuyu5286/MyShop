package com.jumeng.shop.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jumeng.shop.R;
import com.jumeng.shop.adapter.HomeAdapter;
import com.jumeng.shop.fragment.delegate.HomeDelegate;

/**
 * ============================================================
 * 描 述 : 首页
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class HomeFragment extends BaseFragment<HomeDelegate> {

    private View mView;
    private RecyclerView mRecyclerView;

    @Override
    protected Class<HomeDelegate> getDelegateClass() {
        return HomeDelegate.class;
    }

    String[] mStrings = {"aaa", "ccc", "cccaaa", "ddd"};


    @Override
    protected void onBind() {
        super.onBind();
        mView = viewDelegate.getView();
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.home_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(new HomeAdapter(activity, mStrings));
    }
}
