package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.weezn.remember.R;

/**
 * EventActivity
 *
 * @author: weezn
 * @time: 2016/1/30 16:18
 */
public class EventActivity extends Activity {
    public final static String TAG="EventActivity";
    private EditText editText;
    private String event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"oncreat");
        super.onCreate(savedInstanceState);
        editText=(EditText)findViewById(R.id.event_edittext);
        event=editText.getText().toString();

        Intent intent=getIntent();
        intent.putExtra("event", event);
        EventActivity.this.setResult(2, intent);

        Log.i(TAG, event);
//        EventActivity.this.finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public String getEvent() {
        return event;
    }
}
