package com.jumeng.shop.fragment.delegate;

import android.widget.TextView;

import com.jumeng.shop.R;
import com.jumeng.shop.interfaces.AppDelegate;
import com.jumeng.shop.view.CircleImageView;
import com.jumeng.shop.widget.recycler.WrapRecyclerView;

import butterknife.Bind;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class HomeDelegate extends AppDelegate {

    @Bind(R.id.home_recycler_view)
    WrapRecyclerView mRecyclerView;
    @Bind(R.id.header_month)
    TextView mMonth;
    @Bind(R.id.header_day)
    TextView mDay;
    @Bind(R.id.header_year)
    TextView mYear;
    @Bind(R.id.header_item1)
    CircleImageView mItem1;
    @Bind(R.id.header_item2)
    CircleImageView mItem2;
    @Bind(R.id.header_item3)
    CircleImageView mItem3;
    @Bind(R.id.header_item4)
    CircleImageView mItem4;

    @Override
    public int layoutResId() {
        return R.layout.fragment_home;
    }

    public WrapRecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public TextView getMonth() {
        return mMonth;
    }

    public TextView getDay() {
        return mDay;
    }

    public TextView getYear() {
        return mYear;
    }

    public CircleImageView getItem1() {
        return mItem1;
    }

    public CircleImageView getItem2() {
        return mItem2;
    }

    public CircleImageView getItem3() {
        return mItem3;
    }

    public CircleImageView getItem4() {
        return mItem4;
    }
}
