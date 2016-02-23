package com.example.weezn.remember.Event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.CalendarView;
import android.widget.TimePicker;
import android.widget.Toast;

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


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG,"touchevent");
        int x1=(int)event.getX();
        try {
            event.wait(event.getEventTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int x2=(int)event.getX();

        if(x2-x1>FLIP_SPACE){
            Intent intent =new Intent(DataAndTimeActivity.this,AdressActivity.class);
            intent.putExtra("dataAndtime",monthValue+getResources().getString(R.string.mouth)
                                            +dayValue+getResources().getString(R.string.day)
                                            +hourValue+getResources().getString(R.string.hour)
                                            +minuteValue+getResources().getString(R.string.minute));
            startActivity(intent);
        }else if(x1-x2>FLIP_SPACE){
            Toast.makeText(this,getResources().getString(R.string.change_new_event_to_right),Toast.LENGTH_SHORT).show();
        }


        DataAndTimeActivity.this.finish();
        return super.onTouchEvent(event);
    }


}





