package com.example.weezn.remember.Event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.weezn.remember.R;

/**
 * ThingActivity
 *
 * @author: weezn
 * @time: 2016/2/19 0:14
 */
public class ThingActivity extends Activity  {
    private static final String TAG="ThingActivity";


    private EditText editText;
    private Button button;

    private String thing="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newthing);
        editText= (EditText) findViewById(R.id.new_thing_text);
        button= (Button) findViewById(R.id.new_thing_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thing=editText.getText().toString();
                Intent intent =getIntent();
                intent.putExtra("Event",thing);
                Log.i(TAG,thing);
                setResult(3, intent);

                ThingActivity.this.finish();
            }
        });

    }



}
