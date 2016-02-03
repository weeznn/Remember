//package com.example.weezn.remember.NewEvent;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.IBinder;
//import android.support.annotation.Nullable;
//
//import com.example.weezn.remember.PageView;
//
///**
// * PageService
// *
// * @author: weezn
// * @time: 2016/2/1 13:10
// */
//public class PageService extends Service {
//
//    private PageView pageView_1_1;
//    private PageView pageView_1_2;
//    private PageView pageView_1_3;
//
//    private PageView pageView_2_1;
//    private PageView pageView_2_2;
//    private PageView pageView_2_3;
//
//    private PageView pageView_3_1;
//    private PageView pageView_3_2;
//    private PageView pageView_3_3;
//
//    private PageView[] pageViews={pageView_1_1,pageView_1_2,pageView_1_3,
//            pageView_2_1,pageView_2_2,pageView_2_3,
//            pageView_3_1,pageView_3_2,pageView_3_3};
//
//
//    private String timeText;//时间
//    private String addressText;//地点
//    private String eventText;//事件
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////
////        init();
////
////        //找位置 显示
////        int i;
////        for( i=0;i<9;i++){
////            if(pageViews[i].isempty()){
////                getPageView(pageViews[i]);
////                pageViews[i].setIsempty(false);
////            }break;
////        }
////        if(9==i){
////
////        }
////
////
////    }
////
////    private void init(){
////        pageView_1_1=(PageView)findViewById(R.id.page_1_1);
////        pageView_1_2=(PageView)findViewById(R.id.page_1_2);
////        pageView_1_3=(PageView)findViewById(R.id.page_1_3);
////
////        pageView_2_1=(PageView)findViewById(R.id.page_2_1);
////        pageView_2_2=(PageView)findViewById(R.id.page_2_2);
////        pageView_2_3=(PageView)findViewById(R.id.page_2_3);
////
////        pageView_3_1=(PageView)findViewById(R.id.page_3_1);
////        pageView_3_2=(PageView)findViewById(R.id.page_3_2);
////        pageView_3_3=(PageView)findViewById(R.id.page_3_3);
////
////
////    }
//
//    public PageView getPageView(PageView pageView){
//        return pageView;
//    }
//
////    private void setdata(PageView pageView,String timetext,String addresstext,String eventtext){
////        pageView.setAddressText(addresstext);
////        pageView.setEventText(eventtext);
////        pageView.setTimeText(timetext);
////
////    }
//
//
//
//    public void setTimeText(String timeText) {
//        this.timeText = timeText;
//    }
//
//    public void setAddressText(String addressText) {
//        this.addressText = addressText;
//    }
//
//    public void setEventText(String eventText) {
//        this.eventText = eventText;
//    }
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
////        pageView_1_1=(PageView)findViewById(R.id.page_1_1);
////        pageView_1_2=(PageView)findViewById(R.id.page_1_2);
////        pageView_1_3=(PageView)findViewById(R.id.page_1_3);
////
////        pageView_2_1=(PageView)findViewById(R.id.page_2_1);
////        pageView_2_2=(PageView)findViewById(R.id.page_2_2);
////        pageView_2_3=(PageView)findViewById(R.id.page_2_3);
////
////        pageView_3_1=(PageView)findViewById(R.id.page_3_1);
////        pageView_3_2=(PageView)findViewById(R.id.page_3_2);
////        pageView_3_3=(PageView)findViewById(R.id.page_3_3);
//    }
//}
