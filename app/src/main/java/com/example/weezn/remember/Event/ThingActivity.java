package com.example.weezn.remember.Event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weezn.remember.MainActivity;
import com.example.weezn.remember.PageView;
import com.example.weezn.remember.R;

/**
 * ThingActivity
 *
 * @author: weezn
 * @time: 2016/2/19 0:14
 */
public class ThingActivity extends Activity {
    private static final String TAG="ThingActivity";
    final int FLIP_SPACE=100;

    private EditText editText;
    private Button button;

    private String thing="";

    private String dataandtime;
    private String adress;


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editText= (EditText) findViewById(R.id.new_thing_text);
        button= (Button) findViewById(R.id.new_thing_button);


        thing=editText.getText().toString();

        //得到数据
        Intent intent=getIntent();
        dataandtime=intent.getStringExtra("dataandtime");
        adress=intent.getStringExtra("address");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
                show();
                Intent intent =new Intent(ThingActivity.this, MainActivity.class);
                startActivity(intent);


                ThingActivity.this.finish();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x1=(int)event.getX();
        try {
            event.wait(event.getEventTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int x2=(int)event.getX();

        if(x2-x1>FLIP_SPACE){
            Toast.makeText(this, getResources().getString(R.string.change_new_event_to_left), Toast.LENGTH_SHORT).show();
        }else if(x1-x2>FLIP_SPACE){
            Intent intent =new Intent(ThingActivity.this,AdressActivity.class);
            startActivity(intent);

        }
        return super.onTouchEvent(event);
    }



    //page部分

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
                pageViews[i].setAddressText(adress);
                pageViews[i].setTimeText(dataandtime);
                pageViews[i].setEventText(thing);

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
