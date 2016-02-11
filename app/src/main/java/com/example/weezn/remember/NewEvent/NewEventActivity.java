package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

    //    private DataActivity dataActivity;//新建事件的日期和时间
    //    private AddressActivity addressActivity;//新建事件的地址
    //    private EventActivity eventActivity;//新建事件的内容

    private String dataAndTime;
    private String address;
    private String event;
    private int mouth, day, hour, minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);
        Log.i(TAG, "oncreat");

        //初始化
        init();

        Intent intentTimeAndData = new Intent(NewEventActivity.this, DataActivity.class);
        startActivityForResult(intentTimeAndData, 0);

        Intent intentAddress = new Intent(NewEventActivity.this, AddressActivity.class);
        startActivityForResult(intentAddress, 1);

        Intent intentEvent = new Intent(NewEventActivity.this, EventActivity.class);
        startActivityForResult(intentEvent, 2);


        button = (Button) findViewById(R.id.new_event_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("mouth", mouth);
                intent.putExtra("day", day);
                intent.putExtra("hour", hour);
                intent.putExtra("minute", minute);
//                startActivity(intent);

                //将新建事件显示在主页
                show();

                finishActivity(0);
                finishActivity(1);
                finishActivity(2);

            }
        });

        finish();

    }


    @Override
    protected void onStart() {
        Log.i(TAG, "onstart");
        super.onStart();
    }


    //    /**
    //     * 得到新提醒的时间，地点，内容并传给MainAvtivity
    //     */
    //    public void returndata(){
    //        Intent intent=getIntent();
    //            intent.putExtra("dataandtime",dataActivity.getDataAndTime());
    //            intent.putExtra("mouth",dataActivity.getMouthValue());
    //            intent.putExtra("day",dataActivity.getDayValue());
    //            intent.putExtra("hour",dataActivity.getHourValue());
    //            intent.putExtra("minute",dataActivity.getMinValue());
    //        intent.putExtra("address",addressActivity.getAddress());
    //        intent.putExtra("event", eventActivity.getEvent());
    //        NewEventActivity.this.setResult(0, intent);
    //
    //        NewEventActivity.this.onDestroy();
    //    }


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
        int i;
        for (i = 0; i < 9; i++) {
            if (pageViews[i].isempty()) {
                pageViews[i].setAddressText(String.format(address));
                pageViews[i].setTimeText(String.format(dataAndTime));
                pageViews[i].setEventText(String.format(event));
                pageViews[i].setIsempty(false);//将该page置为有事件
            }
            break;
        }
        if (9 == i) {
            Log.d(TAG, "i==9");
        }
    }


    /**
     * 获取时间地点事件
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();

        switch (requestCode) {
            case 0:
                dataAndTime = bundle.getString("dataandtime");

                mouth = bundle.getInt("mouth");
                day = bundle.getInt("day");
                hour = bundle.getInt("hour");
                minute = bundle.getInt("minute");
                break;
            case 1:
                address = bundle.getString("address");
                break;
            case 2:
                event = bundle.getString("event");
                break;
        }
    }


}
