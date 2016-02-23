package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.weezn.remember.PageView;
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

    private PageView pageView_1_1;
    private PageView pageView_1_2;
    private PageView pageView_1_3;

    private PageView pageView_2_1;
    private PageView pageView_2_2;
    private PageView pageView_2_3;

    private PageView pageView_3_1;
    private PageView pageView_3_2;
    private PageView pageView_3_3;

    private PageView[] pageViews;


    private NumberPicker mouth, day, hour, min;
    private int mouthValue, dayValue, hourValue, minValue;
    private String dataAndTime="";


    private EditText editText_address;
    private String address="";

    private EditText editText_thing;
    private String event_txt="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);
        Log.i(TAG, "oncreat");
        data();
        address();
        thing();

        button = (Button) findViewById(R.id.new_event_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                init();
                //将新建事件显示在主页
                show();

                //结束本activity
                NewEventActivity.this.finish();
            }
        });

    }



    @Override
    protected void onStart() {
        Log.i(TAG, "onstart");
        super.onStart();
    }


    private void init() {
        pageView_1_1 = (PageView) findViewById(R.id.page_1_1);
        pageView_1_2 = (PageView) findViewById(R.id.page_1_2);
        pageView_1_3 = (PageView) findViewById(R.id.page_1_3);

        pageView_2_1 = (PageView) findViewById(R.id.page_2_1);
        pageView_2_2 = (PageView) findViewById(R.id.page_2_2);
        pageView_2_3 = (PageView) findViewById(R.id.page_2_3);

        pageView_3_1 = (PageView) findViewById(R.id.page_3_1);
        pageView_3_2 = (PageView) findViewById(R.id.page_3_2);
        pageView_3_3 = (PageView) findViewById(R.id.page_3_3);

        pageViews = new PageView[]{pageView_1_1, pageView_1_2, pageView_1_3,
                pageView_2_1, pageView_2_2, pageView_2_3,
                pageView_3_1, pageView_3_2, pageView_3_3};
        Log.i(TAG, "init");


    }

    private void show() {
        Log.i(TAG,"show");
        int i;
        for ( i = 0; i < 9; i++) {
            if (pageViews[i].isempty()) {
                pageViews[i].setAddressText(String.format(address));
                pageViews[i].setTimeText(String.format(dataAndTime));
                pageViews[i].setEventText(String.format(event_txt));

                pageViews[i].setIsempty(false);//将该page置为有事件

                pageViews[i].invalidate();//刷新该page页面
            }
            break;
        }
        if (9 == i) {
            Log.d(TAG, "i==9");
        }
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void data(){
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
                Log.i(TAG,"shijian  yue:"+mouthValue);
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
                Log.i(TAG,"shijian  day:"+dayValue);
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

                Log.i(TAG,"shijian hour:"+hourValue);
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
                Log.i(TAG,"shijian  min:"+minValue);
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
    }

    private void showSelectedTimeAndData() {


        Toast.makeText(this, this.getResources().getString(R.string.new_event_data__and_time_show_text) +
                mouthValue + this.getResources().getString(R.string.mouth) +
                dayValue + this.getResources().getString(R.string.day) +
                hourValue + this.getResources().getString(R.string.hour)
                + minValue + this.getResources().getString(R.string.minute), Toast.LENGTH_SHORT).show();
    }

    //adress 部分

    private void address(){

        editText_address = (EditText) findViewById(R.id.address_edittext);

        if(" "== editText_address.getText().toString()){
            Toast.makeText(this,"地址栏不能为空",Toast.LENGTH_LONG).show();
        }else {
            address=editText_address.getText().toString();
        }
    }


    //事件部分
    private  void thing(){
        editText_thing = (EditText) findViewById(R.id.event_edittext);

        if(" "== editText_thing.getText().toString()){
            Toast.makeText(this, "事件栏不能为空", Toast.LENGTH_LONG);
        }else {
            event_txt=editText_thing.getText().toString();
        }
    }




}
