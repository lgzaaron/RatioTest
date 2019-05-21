package com.example.mylib;

import android.util.Log;


public class LgzTestUtils {
    private LgzTestUtils() {
    }
    private static LgzTestUtils util;
    private static LgzTestUtils getInstance(){
        if (util==null){
            synchronized (LgzTestUtils.class){
                if (util==null){
                    util=new LgzTestUtils();
                }
            }
        }
        return util;
    }

    public long  getTime(){
        return  System.currentTimeMillis();
    }
}
