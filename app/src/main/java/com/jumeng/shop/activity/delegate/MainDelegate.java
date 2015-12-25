package com.jumeng.shop.activity.delegate;

import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.jumeng.shop.R;
import com.jumeng.shop.interfaces.AppDelegate;
import com.jumeng.shop.view.CircleImageView;

import butterknife.Bind;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/10.
 * ============================================================
 */
public class MainDelegate extends AppDelegate {

    @Bind(R.id.open_menu)
    CircleImageView mOpenMenu;
    @Bind(R.id.main_tab)
    RadioGroup mMainTab;
    @Bind(R.id.menu_item1)
    CircleImageView mMenuItem1;
    @Bind(R.id.menu_item4)
    CircleImageView mMenuItem4;
    @Bind(R.id.menu_item2)
    CircleImageView mMenuItem2;
    @Bind(R.id.menu_item3)
    CircleImageView mMenuItem3;
    @Bind(R.id.close_menu)
    CircleImageView mCloseMenu;
    @Bind(R.id.main_menu)
    FrameLayout mMainMenu;

    @Override
    public int layoutResId() {
        return R.layout.activity_main;
    }

    public int getMainContainer() {
        return R.id.main_container;
    }

    public RadioGroup getMainTab() {
        return mMainTab;
    }

    public FrameLayout getMainMenu() {
        return mMainMenu;
    }

    public CircleImageView getOpenMenu() {
        return mOpenMenu;
    }

    public CircleImageView getCloseMenu() {
        return mCloseMenu;
    }

    public CircleImageView getMenuItem1() {
        return mMenuItem1;
    }

    public CircleImageView getMenuItem2() {
        return mMenuItem2;
    }

    public CircleImageView getMenuItem3() {
        return mMenuItem3;
    }

    public CircleImageView getMenuItem4() {
        return mMenuItem4;
    }
}
