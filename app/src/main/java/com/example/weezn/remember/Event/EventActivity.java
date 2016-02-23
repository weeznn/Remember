//package com.example.weezn.remember.Event;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//
//import com.example.weezn.remember.NewEvent.AddressActivity;
//import com.example.weezn.remember.NewEvent.DataActivity;
//
///**
// * EventActivity
// *
// * @author: weezn
// * @time: 2016/2/19 0:12
// */
//public class EventActivity extends Activity {
//    private static final String TAG="EventActivity";
//
//    private String dataAndTime;
//    private String address;
//    private String event;
//    private int mouth, day, hour, minute;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        Intent intentTimeAndData = new Intent(EventActivity.this, DataActivity.class);
//        startActivityForResult(intentTimeAndData, 0);
//
//        Intent intentAddress = new Intent(EventActivity.this, AddressActivity.class);
//        startActivityForResult(intentAddress, 1);
//
//        Intent intentEvent = new Intent(EventActivity.this, com.example.weezn.remember.NewEvent.EventActivity.class);
//        startActivityForResult(intentEvent, 2);
//    }
//
//
//    /**
//     * 获取时间地点事件
//     *
//     * @param requestCode
//     * @param resultCode
//     * @param data
//     */
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        Log.i(TAG, "onActivityResult");
//        super.onActivityResult(requestCode, resultCode, data);
//        Bundle bundle = data.getExtras();
//
//        switch (requestCode) {
//            case 0:
//                dataAndTime = bundle.getString("dataandtime");
//
//                mouth = bundle.getInt("mouth");
//                day = bundle.getInt("day");
//                hour = bundle.getInt("hour");
//                minute = bundle.getInt("minute");
//                break;
//            case 1:
//                address = bundle.getString("address");
//                break;
//            case 2:
//                event = bundle.getString("event");
//                break;
//        }
//    }
//
//
//}
