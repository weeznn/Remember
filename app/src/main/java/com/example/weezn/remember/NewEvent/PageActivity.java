package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.os.Bundle;

import com.example.weezn.remember.PageView;
import com.example.weezn.remember.R;

/**
 * PageActivity
 *
 * @author: weezn
 * @time: 2016/2/1 13:10
 */
public class PageActivity extends Activity {

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


    private String timeText;//时间
    private String addressText;//地点
    private String eventText;//事件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        //找位置 显示
        int i;
        for( i=0;i<9;i++){
            if(pageViews[i].isempty()){
                setdata(pageViews[i],timeText,addressText,eventText);
            }break;
        }
        if(9==i){

        }


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

    private void setdata(PageView pageView,String timetext,String addresstext,String eventtext){
        pageView.setAddressText(addresstext);
        pageView.setEventText(eventtext);
        pageView.setTimeText(timetext);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void setTimeText(String timeText) {
        this.timeText = timeText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }
}
