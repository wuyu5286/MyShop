package com.jumeng.shop.fragment.delegate;

import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jumeng.shop.R;
import com.jumeng.shop.interfaces.AppDelegate;
import com.jumeng.shop.view.CircleImageView;

import butterknife.Bind;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class TogetherDelegate extends AppDelegate {

    @Bind(R.id.together_avatar)
    CircleImageView mAvatar;//头像
    @Bind(R.id.together_username)
    TextView mUsername;//用户名
    @Bind(R.id.together_assets)
    TextView mAssets;//当前资产
    @Bind(R.id.together_info)
    RelativeLayout mInfo;
    @Bind(R.id.together_times)
    TextView mTimes;//加入次数
    @Bind(R.id.together_money)
    TextView mMoney;
    @Bind(R.id.together_number)
    TextView mNumber;//人数
    @Bind(R.id.together_friends)
    TextView mFriends;
    @Bind(R.id.together_ranking)
    TextView mRanking;
    @Bind(R.id.together_qr_code)
    TextView mQrCode;
    @Bind(R.id.together_shopping_cart)
    TextView mShoppingCart;
    @Bind(R.id.together_news)
    TextView mNews;
    @Bind(R.id.together_recycler_view)
    RecyclerView mRecyclerView;

    @Override
    public int layoutResId() {
        return R.layout.fragment_together;
    }

    @Override
    protected void onBind() {
        super.onBind();
    }

    public CircleImageView getAvatar() {
        return mAvatar;
    }

    public TextView getUsername() {
        return mUsername;
    }

    public TextView getAssets() {
        return mAssets;
    }

    public RelativeLayout getInfo() {
        return mInfo;
    }

    public TextView getTimes() {
        return mTimes;
    }

    public TextView getMoney() {
        return mMoney;
    }

    public TextView getNumber() {
        return mNumber;
    }

    public TextView getFriends() {
        return mFriends;
    }

    public TextView getRanking() {
        return mRanking;
    }

    public TextView getQrCode() {
        return mQrCode;
    }

    public TextView getShoppingCart() {
        return mShoppingCart;
    }

    public TextView getNews() {
        return mNews;
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }
}
