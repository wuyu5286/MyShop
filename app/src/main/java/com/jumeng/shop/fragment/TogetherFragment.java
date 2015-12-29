package com.jumeng.shop.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jumeng.shop.R;
import com.jumeng.shop.adapter.TogetherAdapter;
import com.jumeng.shop.fragment.delegate.TogetherDelegate;
import com.jumeng.shop.utils.ToastUtils;
import com.jumeng.shop.utils.UIUtils;

/**
 * ============================================================
 * 描 述 : 一起买
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/15.
 * ============================================================
 */
public class TogetherFragment extends BaseFragment<TogetherDelegate> implements View.OnClickListener {
    @Override
    protected Class<TogetherDelegate> getDelegateClass() {
        return TogetherDelegate.class;
    }

    private RecyclerView mRecyclerView;
    String[] mStrings = {"一 月Jan.", "二 月Feb.", "三 月Mar.",
            "四 月Apr.", "五 月May.", "六 月Jun.",
            "七 月Jul.", "八 月Aug.", "九 月Sep.",
            "十 月Oct.", "十一月Nov.", "十二月Dec.",
            "一 月Jan.", "二 月Feb.", "三 月Mar.",
            "四 月Apr.", "五 月May.", "六 月Jun.",
            "七 月Jul.", "八 月Aug.", "九 月Sep.",
            "十 月Oct.", "十一月Nov.", "十二月Dec."
    };

    @Override
    protected void onBind() {
        super.onBind();
        view.getAvatar().setImageResource(R.mipmap.icon_add);
        view.getUsername().setText("苦情茶来一杯");
        view.getAssets().setText("538.90");
        view.getTimes().setText("53次");
        view.getMoney().setText("639.00");
        view.getNumber().setText("635人");

        mRecyclerView = view.getRecyclerView();
        mRecyclerView.setLayoutManager(new GridLayoutManager(UIUtils.getContext(), 2));
        mRecyclerView.setAdapter(new TogetherAdapter(UIUtils.getContext(), mStrings));

        view.getInfo().setOnClickListener(this);
        view.getFriends().setOnClickListener(this);
        view.getRanking().setOnClickListener(this);
        view.getQrCode().setOnClickListener(this);
        view.getShoppingCart().setOnClickListener(this);
        view.getNews().setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.together_info:
                ToastUtils.show("info");
                break;
            case R.id.together_friends:
                ToastUtils.show("friends");
                break;
            case R.id.together_ranking:
                ToastUtils.show("ranking");
                break;
            case R.id.together_qr_code:
                ToastUtils.show("qr_code");
                break;
            case R.id.together_shopping_cart:
                ToastUtils.show("shopping_cart");
                break;
            case R.id.together_news:
                ToastUtils.show("news");
                break;
        }
    }
}
