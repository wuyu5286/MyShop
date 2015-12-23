package com.jumeng.shop.fragment;

import com.jumeng.shop.fragment.delegate.SelfDelegate;

/**
 * ============================================================
 * 描 述 : 我的
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class SelfFragment extends BaseFragment<SelfDelegate> {
    @Override
    protected Class<SelfDelegate> getDelegateClass() {
        return SelfDelegate.class;
    }

    @Override
    protected void onBind() {
        super.onBind();
    }
}
