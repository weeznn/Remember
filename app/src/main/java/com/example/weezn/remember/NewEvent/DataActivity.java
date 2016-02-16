package com.example.weezn.remember.NewEvent;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.weezn.remember.R;

/**
 * DataActivity
 *
 * @author: weezn
 * @time: 2016/1/30 13:10
 */
public class DataActivity extends Activity {

    public final static String TAG="DataActivity";
    private NumberPicker mouth, day, hour, min;
    private int mouthValue, dayValue, hourValue, minValue;
    private String dataAndTime;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG,"onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);

        mouth = (NumberPicker) findViewById(R.id.month);
        day = (NumberPicker) findViewById(R.id.day);
        hour = (NumberPicker) findViewById(R.id.hour);
        min = (NumberPicker) findViewById(R.id.minute);


        //获取当前系统时间
        Time time = new Time();
        time.setToNow();
        mouthValue = time.month+1;//系统月份为0~11
        dayValue = time.monthDay;
        minValue = time.minute;
        hourValue = time.hour;


        //设置数值选择器  月份
        mouth.setBackgroundColor(getResources().getColor(R.color.Grey));
        mouth.setMinValue(1);
        mouth.setMaxValue(12);
        mouth.setValue(mouthValue);
        mouth.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                mouthValue = newVal;
                //                showSelectedTimeAndData();
            }
        });



        //设置数值选择器  天
        day.setBackgroundColor(getResources().getColor(R.color.Grey));
        day.setMinValue(1);
        day.setMaxValue(31);
        day.setValue(dayValue);
        day.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                dayValue = newVal;
                //                showSelectedTimeAndData();
            }
        });


        //设置数值选择器  时
        hour.setBackgroundColor(getResources().getColor(R.color.Grey));
        hour.setMinValue(1);
        hour.setMaxValue(23);
        hour.setValue(hourValue);
        hour.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                hourValue = newVal;
                //                showSelectedTimeAndData();
            }
        });




        //设置数值选择器  分
        min.setBackgroundColor(getResources().getColor(R.color.Grey));
        min.setMinValue(1);
        min.setMaxValue(59);
        min.setValue(minValue);
        min.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minValue = newVal;
                //                showSelectedTimeAndData();
            }
        });





        dataAndTime = mouthValue + getResources().getString(R.string.mouth)
                + dayValue + getResources().getString(R.string.day)
                + hourValue + getResources().getString(R.string.hour)
                + minValue + getResources().getString(R.string.minute);
        result();

//        //返回时间和日期
//        Intent intent=getIntent();
//        intent.putExtra("dataandtime",dataAndTime);
//        intent.putExtra("mouth", mouthValue);
//        intent.putExtra("day", dayValue);
//        intent.putExtra("hour", hourValue);
//        intent.putExtra("minute", minValue);
//        DataActivity.this.setResult(0, intent);
//
//        Log.i(TAG, dataAndTime);
//        DataActivity.this.finish();
    }

    private void result(){
        //返回时间和日期
        Intent intent=getIntent();
        intent.putExtra("dataandtime",dataAndTime);
        intent.putExtra("mouth", mouthValue);
        intent.putExtra("day", dayValue);
        intent.putExtra("hour", hourValue);
        intent.putExtra("minute", minValue);
        DataActivity.this.setResult(0, intent);

        Log.i(TAG, dataAndTime);
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

    private void showSelectedTimeAndData() {


        Toast.makeText(this, this.getResources().getString(R.string.new_event_data__and_time_show_text) +
                mouthValue + this.getResources().getString(R.string.mouth) +
                dayValue + this.getResources().getString(R.string.day) +
                hourValue + this.getResources().getString(R.string.hour)
                + minValue + this.getResources().getString(R.string.minute), Toast.LENGTH_SHORT).show();
    }
}

