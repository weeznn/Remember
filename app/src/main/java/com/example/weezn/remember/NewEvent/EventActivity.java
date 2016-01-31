package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.weezn.remember.R;

/**
 * EventActivity
 *
 * @author: weezn
 * @time: 2016/1/30 16:18
 */
public class EventActivity extends Activity {
    private EditText editText;
    private String event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editText=(EditText)findViewById(R.id.event_edittext);
        event=editText.getText().toString();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public String getEvent() {
        return event;
    }
}
