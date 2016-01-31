package com.example.weezn.remember.NewEvent;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.format.Time;
import android.widget.NumberPicker;

import com.example.weezn.remember.R;

/**
 * DataActivity
 *
 * @author: weezn
 * @time: 2016/1/30 13:10
 */
public class DataActivity extends Activity{

    private Mynumpicker mouth,day,hour,min;
    private int mouthValue,dayValue,hourValue,minValue;
    private String dataAndTime;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);

        mouth=(Mynumpicker)findViewById(R.id.month);
        day=(Mynumpicker)findViewById(R.id.day);
        hour=(Mynumpicker)findViewById(R.id.hour);
        min=(Mynumpicker)findViewById(R.id.minute);


        //获取当前系统时间
        Time time=new Time();
        mouthValue=time.month;
        dayValue=time.monthDay;
        minValue=time.minute;
        hourValue=time.hour;




        mouth.setBackgroundColor(Color.BLACK);
        mouth.setMinValue(1);
        mouth.setMaxValue(12);
        mouth.setValue(mouthValue);
        mouth.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mouthValue = newVal;
            }
        });

        day.setBackgroundColor(Color.BLACK);
        day.setMinValue(1);
        day.setMaxValue(31);
        day.setValue(dayValue);
        day.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                dayValue = newVal;
            }
        });

        hour.setBackgroundColor(Color.BLACK);
        hour.setMinValue(1);
        hour.setMaxValue(23);
        hour.setValue(hourValue);
        hour.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                hourValue = newVal;
            }
        });

        min.setBackgroundColor(Color.BLACK);
        min.setMinValue(1);
        min.setMaxValue(59);
        min.setValue(minValue);
        min.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minValue =newVal;
            }
        });

        dataAndTime=mouthValue+getResources().getString(R.string.mouth)
                +dayValue+getResources().getString(R.string.day)
                +hourValue+getResources().getString(R.string.hour)
                +minValue+getResources().getString(R.string.minute);


    }

    public String getDataAndTime() {
        return dataAndTime;
    }

    public int getDayValue() {
        return dayValue;
    }

    public int getHourValue() {
        return hourValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMouthValue() {
        return mouthValue;
    }
}

