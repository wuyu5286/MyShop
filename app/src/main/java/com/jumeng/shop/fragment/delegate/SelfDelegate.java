package com.jumeng.shop.fragment.delegate;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jumeng.shop.R;
import com.jumeng.shop.interfaces.AppDelegate;
import com.jumeng.shop.view.CircleImageView;
import com.jumeng.shop.view.ItemView;

import butterknife.Bind;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class SelfDelegate extends AppDelegate {


    @Bind(R.id.self_header1)
    FrameLayout mHeader1;//已登录头部
    @Bind(R.id.self_header2)
    FrameLayout mHeader2;//未登陆头部

    @Bind(R.id.self_header1_icon)
    CircleImageView mIcon1;
    @Bind(R.id.self_header1_name)
    TextView mName1;
    @Bind(R.id.self_header2_icon)
    CircleImageView mIcon2;
    @Bind(R.id.self_header2_name)
    TextView mName2;

    @Bind(R.id.self_header1_tv_product)
    TextView mTvProduct;
    @Bind(R.id.self_header1_tv_shop)
    TextView mTvShop;
    @Bind(R.id.self_header1_tv_history)
    TextView mTvHistory;

    @Bind(R.id.self_header1_btn_product)
    LinearLayout mBtnProduct1;
    @Bind(R.id.self_header1_btn_shop)
    LinearLayout mBtnShop1;
    @Bind(R.id.self_header1_btn_history)
    LinearLayout mBtnHistory1;

    @Bind(R.id.self_header2_btn_product)
    LinearLayout mBtnProduct2;
    @Bind(R.id.self_header2_btn_shop)
    LinearLayout mBtnShop2;
    @Bind(R.id.self_header2_btn_history)
    LinearLayout mBtnHistory2;

    @Bind(R.id.self_order)
    ItemView mOrder;//商家后台
    @Bind(R.id.self_payment)
    TextView mPayment;//待付款
    @Bind(R.id.self_used)
    TextView mUsed;//待使用
    @Bind(R.id.self_evaluated)
    TextView mEvaluated;//待评价
    @Bind(R.id.self_return)
    TextView mReturn;//退货
    @Bind(R.id.self_coins)
    ItemView mCoins;//我的豆币
    @Bind(R.id.self_ticket)
    ItemView mTicket;//我的票券
    @Bind(R.id.self_friend)
    ItemView mFriend;//我的好友
    @Bind(R.id.self_feedback)
    ItemView mFeedback;//意见反馈
    @Bind(R.id.self_setting)
    ItemView mSetting;//设置
    @Bind(R.id.self_business)
    ItemView mBusiness;//商家后台

    @Override
    public int layoutResId() {
        return R.layout.fragment_self;
    }

    public FrameLayout getHeader1() {
        return mHeader1;
    }

    public FrameLayout getHeader2() {
        return mHeader2;
    }

    public CircleImageView getIcon1() {
        return mIcon1;
    }

    public TextView getName1() {
        return mName1;
    }

    public CircleImageView getIcon2() {
        return mIcon2;
    }

    public TextView getName2() {
        return mName2;
    }

    public TextView getTvProduct() {
        return mTvProduct;
    }

    public TextView getTvShop() {
        return mTvShop;
    }

    public TextView getTvHistory() {
        return mTvHistory;
    }

    public LinearLayout getBtnProduct1() {
        return mBtnProduct1;
    }

    public LinearLayout getBtnShop1() {
        return mBtnShop1;
    }

    public LinearLayout getBtnHistory1() {
        return mBtnHistory1;
    }

    public LinearLayout getBtnProduct2() {
        return mBtnProduct2;
    }

    public LinearLayout getBtnShop2() {
        return mBtnShop2;
    }

    public LinearLayout getBtnHistory2() {
        return mBtnHistory2;
    }

    public ItemView getOrder() {
        return mOrder;
    }

    public TextView getPayment() {
        return mPayment;
    }

    public TextView getUsed() {
        return mUsed;
    }

    public TextView getEvaluated() {
        return mEvaluated;
    }

    public TextView getReturn() {
        return mReturn;
    }

    public ItemView getCoins() {
        return mCoins;
    }

    public ItemView getTicket() {
        return mTicket;
    }

    public ItemView getFriend() {
        return mFriend;
    }

    public ItemView getFeedback() {
        return mFeedback;
    }

    public ItemView getSetting() {
        return mSetting;
    }

    public ItemView getBusiness() {
        return mBusiness;
    }
}
