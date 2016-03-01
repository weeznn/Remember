package com.example.weezn.remember.Event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.CalendarView;
import android.widget.TimePicker;

import com.example.weezn.remember.R;

/**
 * DataAndTimeActivity
 *
 * @author: weezn
 * @time: 2016/2/19 0:13
 */
public class DataAndTimeActivity extends Activity {
    private static final String TAG = "DataAndTimeActivity";
    final int FLIP_SPACE = 100;


    private TimePicker timePicker;
    private CalendarView calendarView;

    private int yearValue, monthValue, dayValue, hourValue, minuteValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"oncreat");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dataandtime);
        timePicker = (TimePicker) findViewById(R.id.timepicker);
        calendarView = (CalendarView) findViewById(R.id.calender);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                yearValue = year;
                monthValue = month+1;
                dayValue = dayOfMonth;
            }
        });


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                hourValue = hourOfDay;
                minuteValue = minute;
            }
        });
        Log.i(TAG,"oncreat over");
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "touchevent");


        Intent intent=getIntent();
        intent.putExtra("DataAndTime",monthValue+getResources().getString(R.string.mouth)
                +dayValue+getResources().getString(R.string.day)
                +hourValue+getResources().getString(R.string.hour)
                +minuteValue+getResources().getString(R.string.minute));
        intent.putExtra("Month", monthValue);
        intent.putExtra("Day",dayValue);
        intent.putExtra("Hour",hourValue);
        intent.putExtra("Minute",minuteValue);
        Log.i(TAG,""+monthValue+dayValue+hourValue+minuteValue);
        setResult(1, intent);


        DataAndTimeActivity.this.finish();
        Log.i(TAG,"touchevent over");
        return super.onTouchEvent(event);
    }


}





