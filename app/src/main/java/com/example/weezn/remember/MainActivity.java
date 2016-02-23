package com.example.weezn.remember;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.weezn.remember.Event.AdressActivity;
import com.example.weezn.remember.Event.DataAndTimeActivity;
import com.example.weezn.remember.NewEvent.NewEventActivity;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "MainActivity";
    private ButtonView buttunView;

    private int mouth, day, hour, minute; //新建提醒的时间


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG,"oncreat");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //新建事件
        buttunView = (ButtonView) findViewById(R.id.touch_buttun);
        buttunView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewEventActivity.class);
                Intent intent1=new Intent(MainActivity.this, DataAndTimeActivity.class);
                Intent intent2=new Intent(MainActivity.this, AdressActivity.class);
                startActivity(intent2);
            }
        });

    }



}
