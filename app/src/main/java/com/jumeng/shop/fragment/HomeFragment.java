package com.jumeng.shop.fragment;

import com.jumeng.shop.fragment.delegate.HomeDelegate;

/**
 * ============================================================
 * 描 述 : 首页
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class HomeFragment extends BaseFragment<HomeDelegate>  {
    @Override
    protected Class<HomeDelegate> getDelegateClass() {
        return HomeDelegate.class;
    }

    @Override
    protected void onBind() {
        super.onBind();
    }
}
