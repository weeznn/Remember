package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.weezn.remember.R;

/**
 * NewEventActivity
 *
 * @author: weezn
 * @time: 2016/1/29 16:07
 */
public class NewEventActivity extends Activity {

    private DataActivity dataActivity;//新建事件的日期和时间
    private AddressActivity addressActivity;//新建时间的地址
    private EventActivity eventActivity;//新建事件的内容



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);

//        新建事件
        dataActivity=new DataActivity();
        addressActivity=new AddressActivity();
        eventActivity=new EventActivity();

    }


    @Override
    protected void onStart() {
        super.onStart();
        returndata();
    }



    /**
     * 得到新提醒的时间，地点，内容并传给MainAvtivity
     */
    public void returndata(){
        Intent intent=getIntent();
        intent.putExtra("dataandtime",dataActivity.getDataAndTime());
        intent.putExtra("mouth",dataActivity.getMouthValue());
        intent.putExtra("day",dataActivity.getDayValue());
        intent.putExtra("hour",dataActivity.getHourValue());
        intent.putExtra("minute",dataActivity.getMinValue());
        intent.putExtra("address",addressActivity.getAddress());
        intent.putExtra("event",eventActivity.getEvent());
        NewEventActivity.this.setResult(0,intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
