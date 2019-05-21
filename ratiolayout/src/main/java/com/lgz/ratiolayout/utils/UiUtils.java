package com.lgz.ratiolayout;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * The type Ui utils.
 */
public class UiUtils {
    private static final String DIME_CLASS = "com.android.internal.R$dimen";
    Context context;
    //标准值  默认值
    public static final float STANDARD_WIDTH = 1080f;
    public static final float STANDARD_HEIGHT = 1920f;
    //    实际值
    public static float displayMetricsWidth;
    public static float displayMetricsHeiht;
    private static  UiUtils instance;

    /**
     * Instantiates a new Ui utils.
     *  在这里把设备的相关信息进行初始化
     * @param context the context
     */
    public UiUtils(Context context) {
        this.context=context;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.displayMetricsWidth==0.0f||this.displayMetricsHeiht==0.0f){
            //这里得到设备的真实屏幕宽高
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            //得到状态框的高度
            int systemBarHeight= getSystemBarHeihgt(context);
            if (displayMetrics.widthPixels>displayMetrics.heightPixels){
                //横屏
                this.displayMetricsWidth=(float) displayMetrics.heightPixels;
                this.displayMetricsHeiht=(float) displayMetrics.widthPixels-systemBarHeight;
            }else {
                //竖屏
                this.displayMetricsWidth=(float) displayMetrics.widthPixels;
                this.displayMetricsHeiht=(float) displayMetrics.heightPixels-systemBarHeight;
            }

        }
    }

    private int getSystemBarHeihgt(Context context) {
        return getValue(context,DIME_CLASS,"system_bar_height",48);
    }

    private int getValue(Context context, String dimeClass, String system_bar_height, int i) {
        try {
            Class<?> clazz = Class.forName(dimeClass);
            Object object = clazz.newInstance();
            Field field = clazz.getField(system_bar_height);
            int id = Integer.parseInt(field.get(object).toString());
            return context.getResources().getDimensionPixelSize(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static UiUtils getInstance(Context context){
        if (instance==null){
            instance=new UiUtils(context);
        }
        return instance;
    }

    public float getHorizontalScaleValue(){
        return ((float)(this.displayMetricsWidth))/STANDARD_WIDTH;
    }
    public float getVerticalScaleValue(){
        return ((float)(this.displayMetricsHeiht))/(STANDARD_HEIGHT-getSystemBarHeihgt(context));
    }
}
