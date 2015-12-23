package com.jumeng.shop.adapter;

import android.content.Context;
import android.view.View;
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

    private static final int RIGHT_ITEM_TYPE = 0;
    private static final int LEFT_ITEM_TYPE = 1;

    public HomeAdapter(Context context, String[] strings) {
        super(context, strings);
    }

    @Override
    protected BaseViewHolder onCreate(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case RIGHT_ITEM_TYPE:
                view = View.inflate(parent.getContext(), R.layout.item_home_right, null);
                break;
            case LEFT_ITEM_TYPE:
                view = View.inflate(parent.getContext(), R.layout.item_home_left, null);
                break;
        }
        if (view != null) {
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
        }
        return new HomeHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return RIGHT_ITEM_TYPE;
        } else {
            return LEFT_ITEM_TYPE;
        }
    }
}

