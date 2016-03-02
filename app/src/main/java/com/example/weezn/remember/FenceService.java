//package com.example.weezn.remember;
//
//import android.app.PendingIntent;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.net.ConnectivityManager;
//import android.os.IBinder;
//
//import com.amap.api.location.AMapLocationClient;
//
///**
// * FenceService
// *
// * @author: weezn
// * @time: 2016/3/2 19:48
// */
//public class FenceService extends com.amap.api.location.APSService {
//    //实例化定位客户端
//    AMapLocationClient mlocationClient = null;
//
//
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        mlocationClient=new AMapLocationClient(getApplicationContext());
//
//        //注册Receiver，设置过滤器
//        IntentFilter fliter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//        fliter.addAction(GEOFENCE_BROADCAST_ACTION);
//
//        //mGeoFenceReceiver为自定义的广播接收器
//        registerReceiver(mGeoFenceReceiver, fliter);
//
//        //声明对应的intent对象
//        Intent intent = new Intent(GEOFENCE_BROADCAST_ACTION);
//        //创建PendingIntent对象
//        PendingIntent mPendingIntent = null;
//        mPendingIntent=PendingIntent.getBroadcast(
//
//                getApplicationContext(),
//
//                0,intent,0);
//
//        //添加地理围栏
//        mlocationClient.addGeoFenceAlert(fenceId,latLng.latitude,latLng.longitude,1000,1000*60*30,mPendingIntent);
//
//        //自定义广播接收器
//        private BroadcastReceiver mGeoFenceReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                // 接收广播内容，处理进出的具体操作。
//            }
//        };
//        //启动定位
//        mlocationClient.startLocation();
//    }
//
//    @Override
//    public IBinder onBind(Intent intent) {
//
//        return null;
//    }
//
//}
