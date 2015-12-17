package com.jumeng.shop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * ============================================================
 * 描 述 : 依附于RecyclerView的view
 * 作 者 : 鸿浩
 * 时 间 : 2015/12/17.
 * ============================================================
 */
public class RecyclerAttachView extends RelativeLayout {
    private RecyclerView mRecyclerView;
    private int mDownScroll;
    private int mCurrentScroll;
    private boolean mReversed;//是否反转
    private boolean mAlreadyAligned;//是否对齐
    private boolean mRecyclerWantsTouchEvent;

    public RecyclerAttachView(Context context) {
        super(context);
    }

    public RecyclerAttachView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerAttachView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static RecyclerAttachView fromXml(Context context, @LayoutRes int layoutResID) {
        RecyclerAttachView view = new RecyclerAttachView(context);
        View.inflate(context, layoutResID, view);
        return view;
    }

    public void attachTo(RecyclerView recyclerView) {
        attachTo(recyclerView, false);
    }

    public void attachTo(RecyclerView recyclerView, boolean alreadyAligned) {
        validateRecycler(recyclerView, alreadyAligned);

        mRecyclerView = recyclerView;
        mAlreadyAligned = alreadyAligned;
        mReversed = isLayoutManagerReversed(recyclerView);

        setUpAlignment(recyclerView);
        setUpAttach(recyclerView);
    }

    private boolean isLayoutManagerReversed(RecyclerView recyclerView) {
        boolean reversed = false;
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof LinearLayoutManager) {
            reversed = ((LinearLayoutManager) manager).getReverseLayout();
        } else if (manager instanceof StaggeredGridLayoutManager) {
            reversed = ((StaggeredGridLayoutManager) manager).getReverseLayout();
        }
        return reversed;
    }

    private void setUpAlignment(RecyclerView recyclerView) {
        if (!mAlreadyAligned) {
            //设置attachView对齐
            ViewGroup.LayoutParams currentParams = getLayoutParams();
            FrameLayout.LayoutParams newParams;
            int width = ViewGroup.LayoutParams.WRAP_CONTENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            int gravity = (mReversed ? Gravity.BOTTOM : Gravity.TOP) | Gravity.CENTER_HORIZONTAL;
            if (currentParams != null) {
                newParams = new FrameLayout.LayoutParams(getLayoutParams());
                newParams.width = width;
                newParams.height = height;
                newParams.gravity = gravity;
            } else {
                newParams = new FrameLayout.LayoutParams(width, height, gravity);
            }
            RecyclerAttachView.this.setLayoutParams(newParams);

            //设置RecyclerView对齐
            FrameLayout newRootParent = new FrameLayout(recyclerView.getContext());
            newRootParent.setLayoutParams(recyclerView.getLayoutParams());
            ViewParent currentParent = recyclerView.getParent();
            if (currentParent instanceof ViewGroup) {
                int indexParent = ((ViewGroup) currentParent).indexOfChild(recyclerView);

                ((ViewGroup) currentParent).removeViewAt(indexParent);
                recyclerView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                newRootParent.addView(recyclerView);
                newRootParent.addView(RecyclerAttachView.this);
                ((ViewGroup) currentParent).addView(newRootParent, indexParent);
            }
        }
    }

    private void setUpAttach(final RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mCurrentScroll += dy;
                RecyclerAttachView.this.setTranslationY(-mCurrentScroll);
            }
        });

        RecyclerAttachView.this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int height = RecyclerAttachView.this.getHeight();
                if (height > 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        RecyclerAttachView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        //noinspection deprecation
                        RecyclerAttachView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }

                    if (mAlreadyAligned) {
                        MarginLayoutParams params = (MarginLayoutParams) getLayoutParams();
                        height += params.topMargin;
                        height += params.bottomMargin;
                    }

                    recyclerView.addItemDecoration(new AttachItemDecoration(recyclerView.getLayoutManager(), height), 0);
                }
            }
        });
    }

    private void validateRecycler(RecyclerView recyclerView, boolean alreadyAligned) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new IllegalStateException("RecyclerView必须设置LayoutManager");
        } else if (layoutManager.getClass() != LinearLayoutManager.class
                && layoutManager.getClass() != GridLayoutManager.class
                && !(layoutManager instanceof StaggeredGridLayoutManager)) {
            throw new IllegalArgumentException("目前只适用于默认的三种LayoutManager");
        }

        if (layoutManager instanceof LinearLayoutManager) {
            if (((LinearLayoutManager) layoutManager).getOrientation() != LinearLayoutManager.VERTICAL) {
                throw new IllegalArgumentException("目前只适用于垂直方向");
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() != StaggeredGridLayoutManager.VERTICAL) {
                throw new IllegalArgumentException("目前只适用于垂直方向");
            }
        }

        if (!alreadyAligned) {
            ViewParent parent = recyclerView.getParent();
            if (parent != null &&
                    !(parent instanceof LinearLayout) &&
                    !(parent instanceof FrameLayout) &&
                    !(parent instanceof RelativeLayout)) {
                throw new IllegalStateException("RecyclerAttachView的父布局只能是LinearLayout,FrameLayout,RelativeLayout三者之一,其他的不适用");
            }
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        mRecyclerWantsTouchEvent = mRecyclerView.onInterceptTouchEvent(ev);
        if (mRecyclerWantsTouchEvent && ev.getAction() == MotionEvent.ACTION_DOWN) {
            mDownScroll = mCurrentScroll;
        }
        return mRecyclerWantsTouchEvent || super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mRecyclerWantsTouchEvent) {
            int scrollDiff = mCurrentScroll - mDownScroll;
            MotionEvent recyclerEvent = MotionEvent.obtain(event.getDownTime(), event.getEventTime(), event.getAction(), event.getX(), event.getY() - scrollDiff, event.getMetaState());
            mRecyclerView.onTouchEvent(recyclerEvent);
            return false;
        }
        return super.onTouchEvent(event);
    }

    private class AttachItemDecoration extends RecyclerView.ItemDecoration {
        private int attachHeight;
        private int childrenCount;

        public AttachItemDecoration(RecyclerView.LayoutManager layoutManager, int height) {
            if (layoutManager.getClass() == LinearLayoutManager.class) {
                childrenCount = 1;
            } else if (layoutManager.getClass() == GridLayoutManager.class) {
                childrenCount = ((GridLayoutManager) layoutManager).getSpanCount();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                childrenCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
            }
            attachHeight = height;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int value = (parent.getChildLayoutPosition(view) < childrenCount) ? attachHeight : 0;
            if (mReversed) {
                outRect.bottom = value;
            } else {
                outRect.top = value;
            }
        }
    }
}
