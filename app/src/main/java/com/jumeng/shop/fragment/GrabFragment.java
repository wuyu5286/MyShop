package com.jumeng.shop.fragment;

import com.jumeng.shop.fragment.delegate.GrabDelegate;

/**
 * ============================================================
 * 描 述 : 九点抢
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class GrabFragment extends BaseFragment<GrabDelegate> {
    @Override
    protected Class<GrabDelegate> getDelegateClass() {
        return GrabDelegate.class;
    }

    @Override
    protected void onBind() {
        super.onBind();
    }
}
