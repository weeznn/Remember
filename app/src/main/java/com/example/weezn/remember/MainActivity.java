package com.example.weezn.remember;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.weezn.remember.Event.AdressActivity;
import com.example.weezn.remember.Event.DataAndTimeActivity;
import com.example.weezn.remember.Event.ThingActivity;
import com.example.weezn.remember.NewEvent.NewEventActivity;

public class MainActivity extends AppCompatActivity  {

    public final static String TAG = "MainActivity";
    private ButtonView buttunView;

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

    private int mouthValue, dayValue, hourValue, minValue;//时间
    private double Latitude,Longitude;//经纬度

    private String dataAndTime = "";
    private String address = "";
    private String event = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, "oncreat");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //新建事件
        buttunView = (ButtonView) findViewById(R.id.touch_buttun);
        buttunView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewEventActivity.class);
                startActivityForResult(intent, 0);


            }
        });

        buttunView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Intent Thing = new Intent(MainActivity.this, ThingActivity.class);
                startActivityForResult(Thing, 3);

                Intent Address = new Intent(MainActivity.this, AdressActivity.class);
                startActivityForResult(Address, 2);

                Intent Data = new Intent(MainActivity.this, DataAndTimeActivity.class);
                startActivityForResult(Data, 1);

                return false;
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (resultCode){
            case 0:
                Bundle data = intent.getExtras();
                dataAndTime = data.getString("DataAndTime");
                address = data.getString("Address");
                event = data.getString("Event");
                mouthValue = data.getInt("Month");
                dayValue = data.getInt("Day");
                hourValue = data.getInt("Hour");
                minValue = data.getInt("Minute");
                show();
                break;
            case 1:
                Bundle time=intent.getExtras();
                dataAndTime = time.getString("DataAndTime");
                mouthValue=time.getInt("Month");
                dayValue=time.getInt("Day");
                hourValue=time.getInt("Hour");
                minValue=time.getInt("Minute");
                break;
            case 2:
                Bundle add=intent.getExtras();
                address=add.getString("Address");
                Latitude=add.getDouble("Latitude");
                Longitude=add.getDouble("Longitude");
                break;
            case 3:
                Bundle thing=intent.getExtras();
                event=thing.getString("Event");
                show();
                break;
        }


    }

    private void show() {
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

        int i;
        for (i = 0; i < 9; i++) {
            if (pageViews[i].isempty()) {
                pageViews[i].setAddressText(address);
                pageViews[i].setTimeText(dataAndTime);
                pageViews[i].setEventText(event);

                pageViews[i].setIsempty(false);//将该page置为有事件

                pageViews[i].invalidate();//刷新该page页面
            }
            break;
        }
        if (9 == i) {
            Log.d(TAG, "i==9");
        }
    }



}
