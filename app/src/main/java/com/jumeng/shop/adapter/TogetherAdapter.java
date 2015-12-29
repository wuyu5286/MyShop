package com.jumeng.shop.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jumeng.shop.R;
import com.jumeng.shop.holder.BaseViewHolder;
import com.jumeng.shop.holder.TogetherHolder;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/28.
 * ============================================================
 */
public class TogetherAdapter extends DefaultAdapter<String> {
    public TogetherAdapter(Context context, String[] strings) {
        super(context, strings);
    }

    @Override
    protected BaseViewHolder onCreate(ViewGroup parent, int viewType) {
        return new TogetherHolder(parent, R.layout.item_together);
    }
}
