package com.jumeng.shop.holder;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jumeng.shop.R;
import com.jumeng.shop.utils.TTFUtils;

import butterknife.Bind;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/23.
 * ============================================================
 */
public class TogetherHolder extends BaseViewHolder<String> {

    @Bind(R.id.item_together_icon)
    ImageView mIcon;
    @Bind(R.id.item_together_name)
    TextView mName;
    @Bind(R.id.item_together_beans)
    TextView mBeans;
    @Bind(R.id.item_together_icon_money)
    TextView mIconMoney;
    @Bind(R.id.item_together_money)
    TextView mMoney;
    @Bind(R.id.item_together_icon_number)
    TextView mIconNumber;
    @Bind(R.id.item_together_number)
    TextView mNumber;

    public TogetherHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
    }


    @Override
    protected void refreshView(String s) {
        mName.setText(s);
        mBeans.setText("123");
        mMoney.setText("128");
        mNumber.setText("89");
        TTFUtils.setTTF(mIconMoney);
        TTFUtils.setTTF(mIconNumber);

    }
}
