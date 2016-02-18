package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weezn.remember.R;

/**
 * EventActivity
 *
 * @author: weezn
 * @time: 2016/1/30 16:18
 */
public class EventActivity extends Activity {
    public final static String TAG = "EventActivity";
    private EditText editText;
    private String event_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.new_event);


        Log.i(TAG, "oncreat");
        super.onCreate(savedInstanceState);
        editText = (EditText) findViewById(R.id.event_edittext);

        if(" "==editText.getText().toString()){
            Toast.makeText(this, "事件栏不能为空", Toast.LENGTH_LONG);
        }else {
            finish();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public String getEvent_txt() {
        return event_txt;
    }

    /**
     * 结束本activity 并将数据传输到上级
     */
    public void finish(){
        event_txt = editText.getText().toString();


        Intent intent = getIntent();
        intent.putExtra("event_txt", event_txt);
        EventActivity.this.setResult(2, intent);

        Log.i(TAG, "事件是："+event_txt);
    }
}
