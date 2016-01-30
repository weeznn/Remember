package com.example.weezn.remember.NewEvent;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

/**
 * Mynumpicker
 *
 * @author: weezn
 * @time: 2016/1/30 13:40
 */
public class Mynumpicker extends NumberPicker {
    public Mynumpicker(Context context) {
        super(context);
    }

    public Mynumpicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Mynumpicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        updateView(child);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        updateView(child);
    }

    @Override
    public void addView(View child, int index) {
        super.addView(child, index);
        updateView(child);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        updateView(child);
    }

    @Override
    public void addView(View child, int width, int height) {
        super.addView(child, width, height);
        updateView(child);
    }

    public void updateView(View view) {
        if (view instanceof EditText) {
            //这里修改字体的属性
            ((EditText) view).setTextColor(Color.parseColor("#FF0000"));
        }
    }

    public void setNumberPickerDividerColor(NumberPicker numberPicker){

    }

}
