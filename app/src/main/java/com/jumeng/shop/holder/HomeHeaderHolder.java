package com.jumeng.shop.holder;

import android.widget.TextView;

import com.jumeng.shop.R;
import com.jumeng.shop.utils.DateUtil;

import butterknife.Bind;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/25.
 * ============================================================
 */
public class HomeHeaderHolder extends BaseHolder<Long> {
    @Bind(R.id.header_month)
    TextView mMonth;
    @Bind(R.id.header_day)
    TextView mDay;
    @Bind(R.id.header_year)
    TextView mYear;

    @Override
    protected int layoutResID() {
        return R.layout.home_header;
    }

    @Override
    protected void refreshView(Long aLong) {
        String[] date = DateUtil.getDate(aLong);
        mYear.setText(date[0]);
        mMonth.setText(date[1]);
        mDay.setText(date[2]);
    }
}
