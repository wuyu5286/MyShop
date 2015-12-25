package com.jumeng.shop.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jumeng.shop.interfaces.IDelegate;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * ============================================================
 * 描 述 : Activity基础类
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/4.
 * ============================================================
 */
public abstract class BaseActivity<T extends IDelegate> extends AppCompatActivity {
    protected T view;
    private static Activity activity;
    private static List<BaseActivity> activityList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        synchronized (activityList) {
            activityList.add(this);
        }
        try {
            view = getDelegateClass().newInstance();
            view.init(getLayoutInflater(), null, savedInstanceState);
            setContentView(view.getView());
            onBind();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected abstract Class<T> getDelegateClass();

    /**
     * 数据绑定
     */
    protected void onBind() {
    }

    @Override
    protected final void onPause() {
        beforePause();
        super.onPause();
        activity = null;
    }


    @Override
    protected final void onResume() {
        super.onResume();
        afterResume();
        activity = this;
    }

    @Override
    protected void onDestroy() {
        view = null;
        onDestroyDelegate();
        super.onDestroy();
        synchronized (activityList) {
            activityList.remove(this);
        }
    }

    @Override
    public void onBackPressed() {
        if (!handleBackPressed()) {
            super.onBackPressed();
        }
        //关闭窗体动画显示
        overridePendingTransition(0, android.R.anim.fade_out);
    }

    protected void beforePause() {
    }

    protected void afterResume() {
    }

    protected void onDestroyDelegate() {
    }

    public static Activity getActivity() {
        return activity;
    }

    public static void exitApp() {
        ListIterator<BaseActivity> iterator = activityList.listIterator();
        while (iterator.hasNext()) {
            Activity next = iterator.next();
            next.finish();
        }
    }

    public boolean handleBackPressed() {
        return false;
    }
}
