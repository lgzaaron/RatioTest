package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lgztestlibrary.LgzTestUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity  {
    private Class<?> mClass;
    private Method mFields;
    private Person mPerson;

//    private Toolbar toolbar;
//    private MyTextView mytextview;
//    private FloatingActionButton fab;
//    private static final String TAG = "ceshi--MainActivity";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        this.fab = (FloatingActionButton) findViewById(R.id.fab);
//        this.mytextview = (MyTextView) findViewById(R.id.my_text_view);
//        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
//        mytextview.setOnClickListener(this);
//        mytextview.setOnTouchListener(this);
//    }
//
//
//    @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        switch (motionEvent.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Log.e(TAG, "MyTextView onTouch: ACTION_DOWN" );
//                break;
////            case MotionEvent.ACTION_MOVE:
////                Log.e(TAG, "MyTextView onTouch: ACTION_MOVE" );
////                break;
//            case MotionEvent.ACTION_UP:
//                Log.e(TAG, "MyTextView onTouch: ACTION_UP" );
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                Log.e(TAG, "MyTextView onTouch: ACTION_CANCEL" );
//                break;
//            default:
//                break;
//        }
//        return false;
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.my_text_view:
//                Log.e(TAG, "MyTextView  onClick: " );
//                Log.e(TAG, "toString: "+ new  Person.Builder().setAge("18").setName("haha").setSex("女").build().toString() );
//                break;
//            default:
//                break;
//        }
//    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Log.e(TAG, "dispatchTouchEvent: ACTION_DOWN" );
//                break;
////            case MotionEvent.ACTION_MOVE:
////                Log.e(TAG, "dispatchTouchEvent: ACTION_MOVE" );
////                break;
//            case MotionEvent.ACTION_UP:
//                Log.e(TAG, "dispatchTouchEvent: ACTION_UP" );
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                Log.e(TAG, "dispatchTouchEvent: ACTION_CANCEL" );
//                break;
//            default:
//                break;
//        }
//        return super.dispatchTouchEvent(ev);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Log.e(TAG, "onTouchEvent: ACTION_DOWN" );
//                break;
////            case MotionEvent.ACTION_MOVE:
////                Log.e(TAG, "onTouchEvent: ACTION_MOVE" );
////                break;
//            case MotionEvent.ACTION_UP:
//                Log.e(TAG, "onTouchEvent: ACTION_UP" );
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                Log.e(TAG, "onTouchEvent: ACTION_CANCEL" );
//                break;
//            default:
//                break;
//        }
//        return false;
//    }

//    private MyViewGroup myView;
//    private RadioGroup rg;
//    private android.widget.TextView tvname;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
////        initView();
//    }
//
//    private void initView() {
//        myView = findViewById(R.id.myView);
//        rg = findViewById(R.id.rg);
//        this.tvname = (TextView) findViewById(R.id.tv_name);
//        View view1 = LayoutInflater.from(this).inflate(R.layout.view1, null);
//        View view2 = LayoutInflater.from(this).inflate(R.layout.view2, null);
//        View view3 = LayoutInflater.from(this).inflate(R.layout.view3, null);
//        myView.addView(view1);
//        myView.addView(view2);
//        myView.addView(view3);
//        for (int i = 0; i < 3; i++) {
//            RadioButton radioButton = new RadioButton(this);
//            if (i == 0) {
//                radioButton.setChecked(true);
//            }
//            radioButton.setId(i);
//            rg.addView(radioButton);
//        }
//        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                myView.scrollPage(checkedId);
//                if (checkedId==2){
//                    tvname.setText(LgzTestUtil.getInstance().getTime());
//                }else {
//                    tvname.setText(checkedId+"");
//                }
//            }
//        });
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewById = findViewById(R.id.tv_name);
        try {
            mClass = Class.forName("com.example.administrator.myapplication.Person");
            mPerson = (Person) mClass.getConstructor(String.class).newInstance("chaozhou");
            mFields = mClass.getMethod("getArea",String.class,int.class);
             mFields.invoke(mPerson,"1111",22);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


}
