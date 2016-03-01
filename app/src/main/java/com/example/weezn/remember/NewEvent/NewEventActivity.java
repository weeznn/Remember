package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.weezn.remember.R;

/**
 * NewEventActivity
 *
 * @author: weezn
 * @time: 2016/1/29 16:07
 */
public class NewEventActivity extends Activity {

    public final static String TAG = "NewEventActivity";
    private Button button;     //确认新建事件按钮




    private NumberPicker mouth, day, hour, min;
    private int monthValue, dayValue, hourValue, minValue;
    private String dataAndTime = "";


    private EditText editText_address;
    private String address = "";

    private EditText editText_thing;
    private String event_txt = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);

        editText_thing = (EditText) findViewById(R.id.event_edittext);
        editText_address = (EditText) findViewById(R.id.address_edittext);

        Log.i(TAG, "oncreat");

        data();

        button = (Button) findViewById(R.id.new_event_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dataAndTime = monthValue + getResources().getString(R.string.mouth) +
                        dayValue + getResources().getString(R.string.day) +
                        hourValue + getResources().getString(R.string.hour)
                        + minValue + getResources().getString(R.string.minute);
                Log.i(TAG, dataAndTime);

                address = editText_address.getText().toString();
                Log.i(TAG, address);

                event_txt = editText_thing.getText().toString();
                Log.i(TAG, event_txt);

                Intent intent=getIntent();
                intent.putExtra("DataAndTime",dataAndTime);
                intent.putExtra("Event",event_txt);
                intent.putExtra("Address",address);
                intent.putExtra("Month", monthValue);
                intent.putExtra("Day",dayValue);
                intent.putExtra("Hour",hourValue);
                intent.putExtra("Minute",minValue);
                setResult(0,intent);
                //结束本activity
                NewEventActivity.this.finish();

            }
        });
        Log.i(TAG, "oncreat结束");

    }


    @Override
    protected void onStart() {
        Log.i(TAG, "onstart");
        super.onStart();

        Log.i(TAG, "onstart结束");
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void data() {
        Log.i(TAG, "data");
        mouth = (NumberPicker) findViewById(R.id.month);
        day = (NumberPicker) findViewById(R.id.day);
        hour = (NumberPicker) findViewById(R.id.hour);
        min = (NumberPicker) findViewById(R.id.minute);

        //获取当前系统时间
        Time time = new Time();
        time.setToNow();
        monthValue = time.month + 1;//系统月份为0~11
        dayValue = time.monthDay;
        minValue = time.minute;
        hourValue = time.hour;


        //设置数值选择器  月份
        mouth.setBackgroundColor(getResources().getColor(R.color.Grey));
        mouth.setMinValue(1);
        mouth.setMaxValue(12);
        mouth.setValue(monthValue);
        mouth.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                monthValue = newVal;
                dataAndTime = monthValue + getResources().getString(R.string.mouth) +
                        dayValue + getResources().getString(R.string.day) +
                        hourValue + getResources().getString(R.string.hour)
                        + minValue + getResources().getString(R.string.minute);
                Log.i(TAG, "mouth" + dataAndTime);
                Log.i(TAG, "shijian  yue:" + monthValue);
            }
        });
        mouth.setOnScrollListener(new NumberPicker.OnScrollListener() {

            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_FLING:
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        break;
                    case SCROLL_STATE_IDLE:
                        showSelectedTimeAndData();
                        break;
                }
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
                dataAndTime = monthValue + getResources().getString(R.string.mouth) +
                        dayValue + getResources().getString(R.string.day) +
                        hourValue + getResources().getString(R.string.hour)
                        + minValue + getResources().getString(R.string.minute);
                Log.i(TAG, "day" + dataAndTime);
                Log.i(TAG, "shijian  day:" + dayValue);
            }
        });

        day.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_FLING:
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        break;
                    case SCROLL_STATE_IDLE:
                        showSelectedTimeAndData();
                        break;
                }
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
                dataAndTime = monthValue + getResources().getString(R.string.mouth) +
                        dayValue + getResources().getString(R.string.day) +
                        hourValue + getResources().getString(R.string.hour)
                        + minValue + getResources().getString(R.string.minute);
                Log.i(TAG, "hour" + dataAndTime);
                Log.i(TAG, "shijian hour:" + hourValue);
            }
        });

        hour.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_FLING:
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        break;
                    case SCROLL_STATE_IDLE:
                        showSelectedTimeAndData();
                        break;
                }
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
                dataAndTime = monthValue + getResources().getString(R.string.mouth) +
                        dayValue + getResources().getString(R.string.day) +
                        hourValue + getResources().getString(R.string.hour)
                        + minValue + getResources().getString(R.string.minute);
                Log.i(TAG, "minute" + dataAndTime);
                Log.i(TAG, "shijian  min:" + minValue);
            }
        });

        min.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_FLING:
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        break;
                    case SCROLL_STATE_IDLE:
                        showSelectedTimeAndData();
                        break;
                }
            }
        });


        Log.i(TAG, "data over");
    }

    private void showSelectedTimeAndData() {


        Toast.makeText(this, this.getResources().getString(R.string.new_event_data__and_time_show_text) +
                monthValue + this.getResources().getString(R.string.mouth) +
                dayValue + this.getResources().getString(R.string.day) +
                hourValue + this.getResources().getString(R.string.hour)
                + minValue + this.getResources().getString(R.string.minute), Toast.LENGTH_SHORT).show();
    }




}
