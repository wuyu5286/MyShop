package com.jumeng.shop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jumeng.shop.R;
import com.jumeng.shop.utils.UIUtils;

/**
 * ============================================================
 * 描 述 :
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/29.
 * ============================================================
 */
public class ItemView extends RelativeLayout {
    private ImageView mIcon;
    private ImageView mArrow;
    private TextView mLeftText;
    private TextView mRightText;

    public ItemView(Context context) {
        this(context, null);
    }

    public ItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.item_view, this);
        mIcon = (ImageView) view.findViewById(R.id.item_view_icon);
        mArrow = (ImageView) view.findViewById(R.id.item_view_arrow);
        mLeftText = (TextView) view.findViewById(R.id.item_view_left_text);
        mRightText = (TextView) view.findViewById(R.id.item_view_right_text);
        if (attrs == null) return;

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ItemView);
        int icon = a.getResourceId(R.styleable.ItemView_item_icon, 0);
        int arrow = a.getResourceId(R.styleable.ItemView_item_arrow, 0);
//        int index = a.getIndex(R.styleable.ItemView_item_arrow_visibility);

        String leftText = a.getString(R.styleable.ItemView_item_left_text);
        String rightText = a.getString(R.styleable.ItemView_item_right_text);
        int leftColor = a.getColor(R.styleable.ItemView_item_left_color, UIUtils.getColor(R.color.gray_dark));
        int rightColor = a.getColor(R.styleable.ItemView_item_right_color, UIUtils.getColor(R.color.gray_dark));
        int leftSize = a.getDimensionPixelSize(R.styleable.ItemView_item_left_size, 14);
        int rightSize = a.getDimensionPixelSize(R.styleable.ItemView_item_right_size, 14);
        a.recycle();

        mIcon.setImageResource(icon);
        mArrow.setImageResource(arrow);
//        switch (index) {
//            case 0:
//                mArrow.setVisibility(VISIBLE);
//                break;
//            case 1:
//                mArrow.setVisibility(GONE);
//                break;
//            case 2:
//                mArrow.setVisibility(INVISIBLE);
//                break;
//            default:
//                mArrow.setVisibility(VISIBLE);
//                break;
//        }
        mLeftText.setText(leftText);
        mLeftText.setTextColor(leftColor);
        mLeftText.setTextSize(TypedValue.COMPLEX_UNIT_SP, leftSize);

        mRightText.setText(rightText);
        mRightText.setTextColor(rightColor);
        mRightText.setTextSize(TypedValue.COMPLEX_UNIT_SP, rightSize);
    }

    public void setIcon(int resId) {
        mIcon.setImageResource(resId);
    }

    public void setArrow(int resId) {
        mArrow.setImageResource(resId);
    }

    public void setLeftText(int resId) {
        mLeftText.setText(resId);
    }

    public void setLeftText(String text) {
        mLeftText.setText(text);
    }

    public void setLeftTextColor(int resId) {
        mLeftText.setTextColor(UIUtils.getColor(resId));
    }

    public void setLeftTextColor(String color) {
        mLeftText.setTextColor(Color.parseColor(color));
    }

    public void setLeftTextSize(int size) {
        mLeftText.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }


    public void setRightText(int resId) {
        mRightText.setText(resId);
    }

    public void setRightText(String text) {
        mRightText.setText(text);
    }

    public void setRightTextColor(int resId) {
        mRightText.setTextColor(UIUtils.getColor(resId));
    }

    public void setRightTextColor(String color) {
        mRightText.setTextColor(Color.parseColor(color));
    }

    public void setRightTextSize(int size) {
        mRightText.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }
}
