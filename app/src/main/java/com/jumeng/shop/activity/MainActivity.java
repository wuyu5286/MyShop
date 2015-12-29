package com.jumeng.shop.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.jumeng.shop.R;
import com.jumeng.shop.activity.delegate.MainDelegate;
import com.jumeng.shop.constant.ConstantValue;
import com.jumeng.shop.fragment.FragmentFactory;
import com.jumeng.shop.fragment.GrabFragment;
import com.jumeng.shop.fragment.HomeFragment;
import com.jumeng.shop.fragment.SelfFragment;
import com.jumeng.shop.fragment.TogetherFragment;
import com.jumeng.shop.utils.AnimatorUtils;
import com.jumeng.shop.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * 描 述 : 主页
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/10.
 * ============================================================
 */
public class MainActivity extends BaseActivity<MainDelegate> implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private int index = 0;
    private HomeFragment mHomeFragment;
    private TogetherFragment mTogetherFragment;
    private GrabFragment mGrabFragment;
    private SelfFragment mSelfFragment;
    private FragmentManager mFragmentManager;
    private boolean isOpen = false;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected Class<MainDelegate> getDelegateClass() {
        return MainDelegate.class;
    }

    @Override
    protected void onBind() {
        super.onBind();
        mFragmentManager = getFragmentManager();
        onTabSelected(0);
        view.getMainMenu().setOnClickListener(this);
        view.getOpenMenu().setOnClickListener(this);
        view.getCloseMenu().setOnClickListener(this);
        view.getMainMenu().setOnClickListener(this);
        view.getMenuItem1().setOnClickListener(this);
        view.getMenuItem2().setOnClickListener(this);
        view.getMenuItem3().setOnClickListener(this);
        view.getMenuItem4().setOnClickListener(this);
        view.getMainTab().setOnCheckedChangeListener(this);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        int position = intent.getIntExtra(ConstantValue.MAIN_INDEX, 0);
        onTabSelected(position);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open_menu:
                showMenu();
                break;
            case R.id.close_menu:
                hideMenu();
                break;
            case R.id.main_menu:
                hideMenu();
                break;
            case R.id.menu_item1:
                ToastUtils.show("1");
                hideMenu();
                break;
            case R.id.menu_item2:
                ToastUtils.show("2");
                hideMenu();
                break;
            case R.id.menu_item3:
                ToastUtils.show("3");
                hideMenu();
                break;
            case R.id.menu_item4:
                ToastUtils.show("4");
                hideMenu();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_home:
                onTabSelected(0);
                break;
            case R.id.main_together:
                onTabSelected(1);
                break;
            case R.id.main_grab:
                onTabSelected(2);
                break;
            case R.id.main_self:
                onTabSelected(3);
                break;
        }
    }

    private void onTabSelected(int position) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();//必须放在这里,每次调用都要实例化
        hideFragment(transaction);
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        transaction.setCustomAnimations(R.anim.fragment_slide_in_left,R.anim.fragment_slide_out_right);
//        transaction.setCustomAnimations(R.anim.fragment_slide_left_in, R.anim.fragment_slide_left_out, R.anim.fragment_slide_right_in, R.anim.fragment_slide_right_out);
        switch (position) {
            case 0:
                if (null == mHomeFragment) {
                    mHomeFragment = (HomeFragment) FragmentFactory.getFragment(0);
                    transaction.add(view.getMainContainer(), mHomeFragment);
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
            case 1:
                if (null == mTogetherFragment) {
                    mTogetherFragment = (TogetherFragment) FragmentFactory.getFragment(1);
                    transaction.add(view.getMainContainer(), mTogetherFragment);
                } else {
                    transaction.show(mTogetherFragment);
                }
                break;
            case 2:
                if (null == mGrabFragment) {
                    mGrabFragment = (GrabFragment) FragmentFactory.getFragment(2);
                    transaction.add(view.getMainContainer(), mGrabFragment);
                } else {
                    transaction.show(mGrabFragment);
                }
                break;
            case 3:
                if (null == mSelfFragment) {
                    mSelfFragment = (SelfFragment) FragmentFactory.getFragment(3);
                    transaction.add(view.getMainContainer(), mSelfFragment);
                } else {
                    transaction.show(mSelfFragment);
                }
                break;
        }
        index = position;
        transaction.commitAllowingStateLoss();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mTogetherFragment != null) {
            transaction.hide(mTogetherFragment);
        }
        if (mGrabFragment != null) {
            transaction.hide(mGrabFragment);
        }
        if (mSelfFragment != null) {
            transaction.hide(mSelfFragment);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(ConstantValue.MAIN_INDEX, index);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        index = savedInstanceState.getInt(ConstantValue.MAIN_INDEX);
    }

    //点击退出时记录时间
    private long firstTime = 0;

    @Override
    public boolean handleBackPressed() {
        if (!isOpen) {
            hideMenu();
            return true;
        }
        long secondTime = System.currentTimeMillis();
        //如果两次按键的时间间隔大于1000毫秒,则不退出
        if (secondTime - firstTime > 1000) {
            ToastUtils.show("再按一次退出客户端");
            firstTime = secondTime;//更新firstTime
        } else {
            exitApp();
        }
        return true;
    }


    private void showMenu() {
        isOpen = false;
        view.getMainMenu().setVisibility(View.VISIBLE);
        List<Animator> animList = new ArrayList<>();
        Animator anim = ObjectAnimator.ofPropertyValuesHolder(view.getCloseMenu(), AnimatorUtils.rotation(0f, 225f));
        animList.add(anim);
        animList.add(showItemAnimator(view.getMenuItem1()));
        animList.add(showItemAnimator(view.getMenuItem2()));
        animList.add(showItemAnimator(view.getMenuItem3()));
        animList.add(showItemAnimator(view.getMenuItem4()));
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(400);
//        animSet.setInterpolator(new OvershootInterpolator());
        animSet.playTogether(animList);
        animSet.start();
    }

    private void hideMenu() {
        isOpen = true;
        List<Animator> animList = new ArrayList<>();
        Animator anim = ObjectAnimator.ofPropertyValuesHolder(view.getCloseMenu(), AnimatorUtils.rotation(225f, 0f));
        animList.add(anim);
        animList.add(hideItemAnimator(view.getMenuItem1()));
        animList.add(hideItemAnimator(view.getMenuItem2()));
        animList.add(hideItemAnimator(view.getMenuItem3()));
        animList.add(hideItemAnimator(view.getMenuItem4()));
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(400);
//        animSet.setInterpolator(new AnticipateInterpolator());
        animSet.playTogether(animList);
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.getMainMenu().setVisibility(View.GONE);
            }
        });
        animSet.start();
    }

    private Animator showItemAnimator(View item) {
        float dx = view.getCloseMenu().getX() - item.getX();
        float dy = view.getCloseMenu().getY() - item.getY();
        item.setRotation(0f);
        item.setTranslationX(dx);
        item.setTranslationY(dy);
        Animator anim = ObjectAnimator.ofPropertyValuesHolder(item,
                AnimatorUtils.rotation(0f, 720f),
                AnimatorUtils.translationX(dx, 0f),
                AnimatorUtils.translationY(dy, 0f)
        );
        return anim;
    }

    private Animator hideItemAnimator(final View item) {
        float dx = view.getCloseMenu().getX() - item.getX();
        float dy = view.getCloseMenu().getY() - item.getY();
        Animator anim = ObjectAnimator.ofPropertyValuesHolder(item,
                AnimatorUtils.rotation(720f, 0f),
                AnimatorUtils.translationX(0f, dx),
                AnimatorUtils.translationY(0f, dy)
        );
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                item.setTranslationX(0f);
                item.setTranslationY(0f);
            }
        });
        return anim;
    }
}
