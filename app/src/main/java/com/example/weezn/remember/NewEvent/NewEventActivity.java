package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.weezn.remember.MainActivity;
import com.example.weezn.remember.PageView;
import com.example.weezn.remember.R;

/**
 * NewEventActivity
 *
 * @author: weezn
 * @time: 2016/1/29 16:07
 */
public class NewEventActivity extends Activity {

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

    private PageView[] pageViews={pageView_1_1,pageView_1_2,pageView_1_3,
            pageView_2_1,pageView_2_2,pageView_2_3,
            pageView_3_1,pageView_3_2,pageView_3_3};

    private DataActivity dataActivity;//新建事件的日期和时间
    private AddressActivity addressActivity;//新建事件的地址
    private EventActivity eventActivity;//新建事件的内容

    //private PageService pageService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);


        //初始化
        init();

        button=(Button)findViewById(R.id.new_event_button);


//        新建事件的三要素

        dataActivity=new DataActivity();
        addressActivity=new AddressActivity();
        eventActivity=new EventActivity();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(NewEventActivity.this, MainActivity.class);
                intent.putExtra("mouth",dataActivity.getMouthValue());
                intent.putExtra("day",dataActivity.getDayValue());
                intent.putExtra("hour",dataActivity.getHourValue());
                intent.putExtra("minute",dataActivity.getMinValue());
                startActivity(intent);

                //将新建事件显示在主页
                show();
                //returndata();
            }
        });


    }




    @Override
    protected void onStart() {
        super.onStart();
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
        intent.putExtra("event", eventActivity.getEvent());
        NewEventActivity.this.setResult(0, intent);

        NewEventActivity.this.onDestroy();
    }




    private void init(){
        pageView_1_1=(PageView)findViewById(R.id.page_1_1);
        pageView_1_2=(PageView)findViewById(R.id.page_1_2);
        pageView_1_3=(PageView)findViewById(R.id.page_1_3);

        pageView_2_1=(PageView)findViewById(R.id.page_2_1);
        pageView_2_2=(PageView)findViewById(R.id.page_2_2);
        pageView_2_3=(PageView)findViewById(R.id.page_2_3);

        pageView_3_1=(PageView)findViewById(R.id.page_3_1);
        pageView_3_2=(PageView)findViewById(R.id.page_3_2);
        pageView_3_3=(PageView)findViewById(R.id.page_3_3);


    }

    private void show(){
        int i;
        for( i=0;i<9;i++){
            if(pageViews[i].isempty()){
                pageView_3_3.setAddressText("hahahha");
                pageViews[i].setAddressText(addressActivity.getAddress());
                pageViews[i].setTimeText(dataActivity.getDataAndTime());
                pageViews[i].setEventText(eventActivity.getEvent());
                pageViews[i].setIsempty(false);
            }break;
        }
        if(9==i){

        }
    }
}
