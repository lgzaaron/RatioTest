package com.example.administrator.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MyLinelayout extends LinearLayout {
    private static final String TAG = "ceshi--MyLinelayout";

    public MyLinelayout(Context context) {
        super(context);
    }

    public MyLinelayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent: ACTION_DOWN" );
                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.e(TAG, "dispatchTouchEvent: ACTION_MOVE" );
//                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent: ACTION_UP" );
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "dispatchTouchEvent: ACTION_CANCEL" );
                break;
                default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouchEvent: ACTION_DOWN" );
                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.e(TAG, "dispatchTouchEvent: ACTION_MOVE" );
//                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onInterceptTouchEvent: ACTION_UP" );
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "onInterceptTouchEvent: ACTION_CANCEL" );
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent: ACTION_DOWN" );
                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.e(TAG, "onTouchEvent: ACTION_MOVE" );
//                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent: ACTION_UP" );
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "onTouchEvent: ACTION_CANCEL" );
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
