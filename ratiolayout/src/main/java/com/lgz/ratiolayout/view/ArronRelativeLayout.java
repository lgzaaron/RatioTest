package com.lgz.ratiolayout.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.lgz.ratiolayout.UiUtils;

/**
 * The type Arron relative layout.
 */
public class ArronRelativeLayout extends RelativeLayout {
    private boolean flag = true;

    /**
     * Instantiates a new Arron relative layout.
     *
     * @param context the context
     */
    public ArronRelativeLayout(Context context) {
        this(context,null);
    }

    /**
     * Instantiates a new Arron relative layout.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public ArronRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    /**
     * Instantiates a new Arron relative layout.
     *
     * @param context      the context
     * @param attrs        the attrs
     * @param defStyleAttr the def style attr
     */
    public ArronRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (flag) {
            float scaleX = UiUtils.getInstance(getContext()).getHorizontalScaleValue();
            float scaleY = UiUtils.getInstance(getContext()).getVerticalScaleValue();
            int childCount = this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = this.getChildAt(i);
                LayoutParams layoutParams = (LayoutParams) child.getLayoutParams();
                layoutParams.width = (int) (layoutParams.width * scaleX+0.5f);
                layoutParams.height = (int) (layoutParams.height * scaleY+0.5f);
                layoutParams.leftMargin = (int) (layoutParams.leftMargin * scaleX+0.5f);
                layoutParams.rightMargin = (int) (layoutParams.rightMargin * scaleX+0.5f);
                layoutParams.topMargin = (int) (layoutParams.topMargin * scaleY+0.5f);
                layoutParams.bottomMargin = (int) (layoutParams.bottomMargin * scaleY+0.5f);
                int paddingLeft = (int) (child.getPaddingLeft() * scaleX+0.5f);
                int paddintRight = (int) (child.getPaddingRight() * scaleX+0.5f);
                int paddingTop = (int) (child.getPaddingTop() * scaleY+0.5f);
                int paddingBotton = (int) (child.getPaddingBottom() * scaleY+0.5f);
                child.setPadding(paddingLeft, paddingTop, paddintRight, paddingBotton);
            }
            flag = false;
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

//    /**
//     * 通过new构造函数可在这里加入自定义属性
//     *
//     * @param attrs
//     * @return
//     */
//    @Override
//    public LayoutParams generateLayoutParams(AttributeSet attrs) {
//        return super.generateLayoutParams(attrs);
//    }
}
