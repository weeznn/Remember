package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
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
    private String dataAndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);

        mouth=(Mynumpicker)findViewById(R.id.month);
        day=(Mynumpicker)findViewById(R.id.day);
        hour=(Mynumpicker)findViewById(R.id.hour);
        min=(Mynumpicker)findViewById(R.id.minute);


        //获取当前系统时间
        android.text.format.Time time=new android.text.format.Time();
        final int[] monthValue = {time.month};
        final int[] dayValue = {time.monthDay};
        final int[] minuteValue = {time.minute};
        final int[] hourValue = {time.hour};



        mouth.setBackgroundColor(Color.BLACK);
        mouth.setMinValue(1);
        mouth.setMaxValue(12);
        mouth.setValue(monthValue[0]);
        mouth.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                monthValue[0] = newVal;
            }
        });

        day.setBackgroundColor(Color.BLACK);
        day.setMinValue(1);
        day.setMaxValue(31);
        day.setValue(dayValue[0]);
        day.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                dayValue[0] = newVal;
            }
        });

        hour.setBackgroundColor(Color.BLACK);
        hour.setMinValue(1);
        hour.setMaxValue(23);
        hour.setValue(hourValue[0]);
        hour.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                hourValue[0] = newVal;
            }
        });

        min.setBackgroundColor(Color.BLACK);
        min.setMinValue(1);
        min.setMaxValue(59);
        min.setValue(minuteValue[0]);
        min.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minuteValue[0] =newVal;
            }
        });

        dataAndTime=monthValue[0]+getResources().getString(R.string.mouth)
                +dayValue[0]+getResources().getString(R.string.day)
                +hourValue[0]+getResources().getString(R.string.hour)
                +minuteValue[0]+getResources().getString(R.string.minute);


    }

    public String getDataAndTime() {
        return dataAndTime;
    }
}
