package com.jumeng.shop.activity.delegate;

import android.widget.RadioGroup;

import com.jumeng.shop.R;
import com.jumeng.shop.interfaces.AppDelegate;
import com.jumeng.shop.view.CircleImageView;
import com.jumeng.shop.view.MenuFrameLayout;

import butterknife.Bind;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/10.
 * ============================================================
 */
public class MainDelegate extends AppDelegate {

    @Bind(R.id.main_more)
    CircleImageView mMainMore;
    @Bind(R.id.main_tab)
    RadioGroup mMainTab;
    @Bind(R.id.main_menu)
    MenuFrameLayout mMainMenu;
    @Bind(R.id.main_menu_item)
    CircleImageView mMainMenuItem;
    @Bind(R.id.main_menu_item1)
    CircleImageView mMainMenuItem1;
    @Bind(R.id.main_menu_item2)
    CircleImageView mMainMenuItem2;
    @Bind(R.id.main_menu_item3)
    CircleImageView mMainMenuItem3;
    @Bind(R.id.main_menu_item4)
    CircleImageView mMainMenuItem4;

    @Override
    public int layoutResId() {
        return R.layout.activity_main;
    }

    public int getMainContainer() {
        return R.id.main_container;
    }

    public CircleImageView getMainMore() {
        return mMainMore;
    }

    public RadioGroup getMainTab() {
        return mMainTab;
    }

    public MenuFrameLayout getMainMenu() {
        return mMainMenu;
    }

    public CircleImageView getMainMenuItem() {
        return mMainMenuItem;
    }

    public CircleImageView getMainMenuItem1() {
        return mMainMenuItem1;
    }

    public CircleImageView getMainMenuItem2() {
        return mMainMenuItem2;
    }

    public CircleImageView getMainMenuItem3() {
        return mMainMenuItem3;
    }

    public CircleImageView getMainMenuItem4() {
        return mMainMenuItem4;
    }
}
