package com.example.weezn.remember;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.weezn.remember.NewEvent.NewEventActivity;

public class MainActivity extends AppCompatActivity {

    private ButtonView buttunView;


    //新建提醒的时间，地点，内容
    private String dataAndTime;
    private String address;
    private String event;
    private int mouth,day,hour,minute;
    private PageView pageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //新建事件
        buttunView=(ButtonView)findViewById(R.id.touch_buttun);
        buttunView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewEventActivity.class);
                //startActivityForResult(intent, 0);
                startActivity(intent);
            }
        });

    }

    /**
     * 获取新建提醒的数据
     * @param requestCode
     * @param resultCode
     * @param data
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==0&&requestCode==0){
            Bundle bundle=data.getExtras();
            dataAndTime=bundle.getString("dataandtime");
            address=bundle.getString("address");
            event=bundle.getString("event");

            mouth=bundle.getInt("mouth");
            day=bundle.getInt("day");
            hour=bundle.getInt("hour");
            minute=bundle.getInt("minute");

        }
    }





}
