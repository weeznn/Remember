//package com.example.weezn.remember.Event;
//
//import android.content.Intent;
//import android.os.Binder;
//import android.os.IBinder;
//import android.support.annotation.Nullable;
//import android.util.Log;
//
//import com.amap.api.location.AMapLocation;
//import com.amap.api.location.AMapLocationClient;
//import com.amap.api.location.AMapLocationClientOption;
//import com.amap.api.location.AMapLocationListener;
//import com.amap.api.maps2d.AMapOptions;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * Location_service
// *
// * @author: weezn
// * @time: 2016/3/1 23:29
// */
//public class Location_service extends com.amap.api.location.APSService {
//
//    private boolean quit=false;
//
//
//    private Date date;
//
//    private String cityName;
//    private String cityCode;
//
//    //service的运行状态
//    private int count;
//    private locationBinder binder=new locationBinder();
//
//    class locationBinder extends Binder{
//        public int getCount(){
//            return count;
//        }
//    }
//
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return binder;
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//       init();
//
//        //启动一条线程，动态修改count的值
//        new Thread(){
//            @Override
//            public void run() {
//                while (!quit){
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                count++;
//            }
//        }.start();
//
//
//
//
//
//
//
//
//
//
//
//    }
//
//    /**
//     * 初始化定位
//     */
//    private void init(){
//        //初始化定位
//        mLocationClient = new AMapLocationClient(getApplicationContext());
//
//        //初始化定位参数
//        mLocationOption = new AMapLocationClientOption();
//        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
//        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//        //设置是否返回地址信息（默认返回地址信息）
//        mLocationOption.setNeedAddress(true);
//        //设置是否只定位一次,默认为false
//        mLocationOption.setOnceLocation(true);
//        //设置是否强制刷新WIFI，默认为强制刷新
//        mLocationOption.setWifiActiveScan(true);
//        //设置是否允许模拟位置,默认为false，不允许模拟位置
//        mLocationOption.setMockEnable(false);
//        //设置定位间隔,单位毫秒,默认为2000ms
//        mLocationOption.setInterval(2000);
//        //给定位客户端对象设置定位参数
//        mLocationClient.setLocationOption(mLocationOption);
//        //启动定位
//        mLocationClient.startLocation();
//    }
//
//
//    @Override
//    public boolean onUnbind(Intent intent) {
//        return true;
//
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        this.quit=true;
//    }
//}
