package com.jumeng.shop.holder;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jumeng.shop.R;

import butterknife.Bind;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/23.
 * ============================================================
 */
public class HomeHolder extends BaseViewHolder<String> {

    @Bind(R.id.item_home_iv)
    ImageView mItemHomeIv;
    @Bind(R.id.item_home_tv)
    TextView mItemHomeTv;

    public HomeHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
    }


    @Override
    protected void refreshView(String s) {
        mItemHomeTv.setText(s);
    }
}
