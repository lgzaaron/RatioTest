package com.example.administrator.myapplication;


import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context) {
        super(context,null);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            childView.layout(i * getWidth(), t, (i + 1) * getWidth(), b);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View view=getChildAt(i);
            view.measure(widthMeasureSpec, heightMeasureSpec);
        }
    }



    /**
     * 切换页面
     */
    public void scrollPage(int index) {
        scrollTo(index * getWidth(), 0);
    }

}
