package com.jumeng.shop.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jumeng.shop.R;
import com.jumeng.shop.holder.BaseViewHolder;
import com.jumeng.shop.holder.HomeHolder;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/23.
 * ============================================================
 */
public class HomeAdapter extends DefaultAdapter<String> {

    public HomeAdapter(Context context, String[] strings) {
        super(context, strings);
    }

    @Override
    protected BaseViewHolder onCreate(ViewGroup parent, int viewType) {
        return new HomeHolder(parent, R.layout.item_home);
    }
}

