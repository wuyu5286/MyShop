package com.jumeng.shop.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.view.View;

import com.jumeng.shop.R;
import com.jumeng.shop.adapter.HomeAdapter;
import com.jumeng.shop.fragment.delegate.HomeDelegate;
import com.jumeng.shop.utils.DateUtil;
import com.jumeng.shop.utils.ToastUtils;
import com.jumeng.shop.widget.recycler.WrapRecyclerView;

/**
 * ============================================================
 * 描 述 : 首页
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class HomeFragment extends BaseFragment<HomeDelegate> implements View.OnClickListener {

    @Override
    protected Class<HomeDelegate> getDelegateClass() {
        return HomeDelegate.class;
    }

    String[] mStrings = {"一 月Jan.", "二 月Feb.", "三 月Mar.", "四 月Apr.", "五 月May.", "六 月Jun.", "七 月Jul.", "八 月Aug.", "九 月Sep.", "十 月Oct.", "十一月Nov.", "十二月Dec."};

    @Override
    protected void onBind() {
        super.onBind();
        WrapRecyclerView recyclerView = view.getRecyclerView();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        View header = RecyclerUtils.getView(R.layout.home_header, true);
//        recyclerView.addHeaderView(header,true);
        recyclerView.setAdapter(new HomeAdapter(activity, mStrings));
        String[] date = DateUtil.getDate(System.currentTimeMillis());
        view.getYear().setText(date[0]);
        view.getMonth().setText(date[1]);
        view.getDay().setText(date[2]);
        view.getItem1().setOnClickListener(this);
        view.getItem2().setOnClickListener(this);
        view.getItem3().setOnClickListener(this);
        view.getItem4().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.header_item1:
                ToastUtils.show("1");
                break;
            case R.id.header_item2:
                ToastUtils.show("2");
                break;
            case R.id.header_item3:
                ToastUtils.show("3");
                break;
            case R.id.header_item4:
                ToastUtils.show("4");
                break;
        }
    }
}
