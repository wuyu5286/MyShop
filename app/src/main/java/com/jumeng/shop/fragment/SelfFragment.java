package com.jumeng.shop.fragment;

import android.view.View;

import com.jumeng.shop.R;
import com.jumeng.shop.fragment.delegate.SelfDelegate;
import com.jumeng.shop.utils.ToastUtils;
import com.jumeng.shop.utils.UIUtils;

/**
 * ============================================================
 * 描 述 : 我的
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class SelfFragment extends BaseFragment<SelfDelegate> implements View.OnClickListener {
    @Override
    protected Class<SelfDelegate> getDelegateClass() {
        return SelfDelegate.class;
    }

    private boolean isLogin = false;//默认已登录

    @Override
    protected void onBind() {
        super.onBind();

        if (isLogin) {
            view.getHeader2().setVisibility(View.GONE);
            view.getHeader1().setVisibility(View.VISIBLE);
            view.getIcon1().setImageResource(R.mipmap.icon_add);
            view.getName1().setText(R.string.app_name);
            view.getTvProduct().setText("124");
            view.getTvShop().setText("36");
            view.getTvHistory().setText("51");
        } else {
            view.getHeader1().setVisibility(View.GONE);
            view.getHeader2().setVisibility(View.VISIBLE);
            view.getIcon2().setImageResource(UIUtils.getColor(R.color.red));
            view.getName2().setText(R.string.login_or_register);
        }

        view.getIcon1().setOnClickListener(this);
        view.getName1().setOnClickListener(this);
        view.getBtnProduct1().setOnClickListener(this);
        view.getBtnShop1().setOnClickListener(this);
        view.getBtnHistory1().setOnClickListener(this);
        view.getIcon2().setOnClickListener(this);
        view.getName2().setOnClickListener(this);
        view.getBtnProduct2().setOnClickListener(this);
        view.getBtnShop2().setOnClickListener(this);
        view.getBtnHistory2().setOnClickListener(this);

        view.getOrder().setOnClickListener(this);
        view.getPayment().setOnClickListener(this);
        view.getUsed().setOnClickListener(this);
        view.getEvaluated().setOnClickListener(this);
        view.getReturn().setOnClickListener(this);
        view.getCoins().setOnClickListener(this);
        view.getTicket().setOnClickListener(this);
        view.getFriend().setOnClickListener(this);
        view.getFeedback().setOnClickListener(this);
        view.getSetting().setOnClickListener(this);
        view.getBusiness().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.self_header1_icon:
                ToastUtils.show("已登录");
                break;
            case R.id.self_header1_name:
                ToastUtils.show("已登录");
                break;
            case R.id.self_header1_btn_product:
                ToastUtils.show("已登录");
                break;
            case R.id.self_header1_btn_shop:
                ToastUtils.show("已登录");
                break;
            case R.id.self_header1_btn_history:
                ToastUtils.show("已登录");
                break;
            case R.id.self_header2_icon:
                ToastUtils.show("请先登陆");
                break;
            case R.id.self_header2_name:
                ToastUtils.show("请先登陆");
                break;
            case R.id.self_header2_btn_product:
                ToastUtils.show("请先登陆");
                break;
            case R.id.self_header2_btn_shop:
                ToastUtils.show("请先登陆");
                break;
            case R.id.self_header2_btn_history:
                ToastUtils.show("请先登陆");
                break;

            case R.id.self_order:
                if (isLogin) {
                    ToastUtils.show("icon");
                } else {
                    ToastUtils.show("请先登陆");
                }
                break;
            case R.id.self_payment:
                if (isLogin) {
                    ToastUtils.show("icon");
                } else {
                    ToastUtils.show("请先登陆");
                }
                break;
            case R.id.self_used:
                if (isLogin) {
                    ToastUtils.show("icon");
                } else {
                    ToastUtils.show("请先登陆");
                }
                break;
            case R.id.self_evaluated:
                if (isLogin) {
                    ToastUtils.show("icon");
                } else {
                    ToastUtils.show("请先登陆");
                }
                break;
            case R.id.self_return:
                if (isLogin) {
                    ToastUtils.show("icon");
                } else {
                    ToastUtils.show("请先登陆");
                }
                break;
            case R.id.self_coins:
                if (isLogin) {
                    ToastUtils.show("icon");
                } else {
                    ToastUtils.show("请先登陆");
                }
                break;
            case R.id.self_ticket:
                if (isLogin) {
                    ToastUtils.show("icon");
                } else {
                    ToastUtils.show("请先登陆");
                }
                break;
            case R.id.self_friend:
                if (isLogin) {
                    ToastUtils.show("icon");
                } else {
                    ToastUtils.show("请先登陆");
                }
                break;
            case R.id.self_feedback:
                if (isLogin) {
                    ToastUtils.show("icon");
                } else {
                    ToastUtils.show("请先登陆");
                }
                break;
            case R.id.self_setting:
                if (isLogin) {
                    ToastUtils.show("icon");
                } else {
                    ToastUtils.show("请先登陆");
                }
                break;
            case R.id.self_business:
                if (isLogin) {
                    ToastUtils.show("icon");
                } else {
                    ToastUtils.show("请先登陆");
                }
                break;
        }
    }
}
