package com.example.weezn.remember.Event;

import android.app.Activity;
import android.os.Bundle;
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

    private TimePicker timePicker = (TimePicker) findViewById(R.id.timepicker);
    private CalendarView calendarView = (CalendarView) findViewById(R.id.calender);

    private int yearValue, monthValue, dayValue, hourValue, minuteValue;

    private int point1X, point2X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dataandtime);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                yearValue = year;
                monthValue = month;
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

    }

}

