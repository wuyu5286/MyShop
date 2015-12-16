package com.jumeng.shop.fragment;

import android.view.View;

import com.jumeng.shop.R;
import com.jumeng.shop.fragment.delegate.HomeDelegate;
import com.jumeng.shop.view.PopupView;

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

    @Override
    protected void onBind() {
        super.onBind();

        viewDelegate.getHomeText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupView bv = new PopupView(activity, R.style.PopupViewTheme_Default, R.layout.bottom_view);
                bv.setAnimation(R.style.PopupViewBottomAnimation);
                bv.setIsTop(true);
                bv.showBottomView(true);
            }
        });
    }
}
