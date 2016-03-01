package com.example.weezn.remember.Event;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.example.weezn.remember.R;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * AdressActivity
 *
 * @author: weezn
 * @time: 2016/2/19 0:14
 */
public class AdressActivity extends Activity implements GeocodeSearch.OnGeocodeSearchListener, AMap.OnMapScreenShotListener {
    private static final String TAG = "AdressActivity";
    final int FLIP_SPACE = 100;

    private TextView textView;

    private MapView mapView;
    private AMap aMap;

    private EditText editText;
    private Button button;
    private Button next;

    private int radiu = 70;//地图圆形区域半径
    private LatLonPoint point;//地址的经纬度对象

    private String address;

    private boolean b;//地图截取成功与否

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "oncreat");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address);

        textView = (TextView) findViewById(R.id.city);
        mapView = (MapView) findViewById(R.id.map);
        editText = (EditText) findViewById(R.id.new_address_edit_text);
        button = (Button) findViewById(R.id.location);
        next = (Button) findViewById(R.id.address_next);


        //必须回掉mapview的oncreat方法
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        init();

        //设置使用普通地图
        aMap.setMapType(AMap.MAP_TYPE_NORMAL);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = editText.getText().toString();
                if (0 == location.length()) {
                    locationfail();
                }
                GeocodeSearch geocodeSearch = new GeocodeSearch(AdressActivity.this);
                geocodeSearch.setOnGeocodeSearchListener(AdressActivity.this);
                GeocodeQuery query = new GeocodeQuery(editText.getText().toString(), "010");
                //将中文转换为地址编码
                geocodeSearch.getFromLocationNameAsyn(query);

            }
        });




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //截取地图窗口
                getMapScreenShot(mapView);

                Intent intent = getIntent();
                intent.putExtra("Latitude", point.getLatitude());
                intent.putExtra("Longitude", point.getLongitude());
                intent.putExtra("Address", address);
                setResult(2);
                AdressActivity.this.finish();
            }
        });

        Log.i(TAG, "oncreat over");
    }


    /**
     * 对地图进行截屏
     */
    public void getMapScreenShot(View v) {
        aMap.getMapScreenShot(this);
        aMap.invalidate();// 刷新地图
    }


    /**
     * 初始化amap对象
     */
    private void init() {
        if (null == aMap) {
            aMap = mapView.getMap();

            //创建一个设置放大级别的CameraUpData
            CameraUpdate cameraUpdate = CameraUpdateFactory.zoomBy(10);
            //设置地图的默认放大级别
            aMap.moveCamera(cameraUpdate);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //必须回掉mapview的onresume方法
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //必须回掉mapview的onpause方法
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //必须回掉mapview的ondestroy方法
        mapView.onDestroy();
    }

    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {

    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
        //获取解析得到的第一个地址
        GeocodeAddress geocodeAddress = geocodeResult.getGeocodeAddressList().get(0);
        //获取解析得到的经纬度
        point = geocodeAddress.getLatLonPoint();
        //获取得到的地址详细信息
        address = editText.getText().toString();
        LatLng latLng = new LatLng(point.getLatitude(), point.getLongitude());
        //创见一个设置经纬度的cameraupdata
        CameraUpdate cameraUpdate = CameraUpdateFactory.changeLatLng(latLng);
        CameraUpdate cameraUpdate1 = CameraUpdateFactory.newLatLngZoom(latLng, 17);
        //更新地图的显示区域
        aMap.moveCamera(cameraUpdate1);
        //创建一个GroundOverlayOptions (用于包装图片)
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory
                        .fromResource(R.mipmap.pic))
                .position(latLng, 64);
        //创建一个圆形区域
        CircleOptions circleOptions = new CircleOptions()
                .center(latLng)//圆心
                        //                .fillColor(0X80ffff00)//填充颜色
                .radius(radiu)    //半径
                .strokeWidth(3)   //线条宽度
                .strokeColor(Color.BLUE);//
        aMap.addGroundOverlay(groundOverlayOptions);
        aMap.addCircle(circleOptions);
    }

    private void GroundOverlayoOption() {
    }

    /**
     * 设置半径
     *
     * @param radiu
     */
    public void setRadiu(int radiu) {
        this.radiu = radiu;
    }

    @Override
    public void onMapScreenShot(Bitmap bitmap) {
        //格式化时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        //得到sd根目录的路径
//        File sdCard = Environment.getExternalStorageDirectory();
        try {
            //将图片保存到sd根目录
            FileOutputStream fos = new FileOutputStream(Environment.getExternalStorageDirectory() + "/Remember_"
                    + simpleDateFormat.format(new Date()) + ".png");
            b = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            //强制将缓冲区的数据发送，避免读不倒数据的情况
            fos.flush();
            //关闭流
            fos.close();
            picSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    //实例化定位客户端
    //    AMapLocationClient mlocationClient = null;
    //    mlocationClient = new AMapLocationClient(getApplicationContext());
    //
    //    //注册Receiver，设置过滤器
    //    IntentFilter fliter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
    //    fliter.addAction(GEOFENCE_BROADCAST_ACTION);
    //    //mGeoFenceReceiver为自定义的广播接收器
    //    registerReceiver(mGeoFenceReceiver, fliter);
    //
    //    //声明对应的intent对象
    //    Intent intent = new Intent(GEOFENCE_BROADCAST_ACTION);
    //    //创建PendingIntent对象
    //    PendingIntent mPendingIntent = null;
    //    mPendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0,intent, 0);
    //
    //    //添加地理围栏
    //    mlocationClient.addGeoFenceAlert(fenceId, latLng.latitude,latLng.longitude, 1000, 1000 * 60 * 30, mPendingIntent);
    //
    //    //自定义广播接收器
    //    private BroadcastReceiver mGeoFenceReceiver = new BroadcastReceiver() {
    //        @Override
    //        public void onReceive(Context context, Intent intent) {
    //            // 接收广播内容，处理进出的具体操作。
    //        }
    //    };
    //    //启动定位
    //    mlocationClient.startLocation();


    /**
     * 提示地图截取
     */
    private void picSave() {
        if (b) {
            Toast.makeText(this, getResources().getString(R.string.pic_save_right), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getResources().getString(R.string.pic_save_wrong), Toast.LENGTH_SHORT).show();

        }
    }

    /**
     * 提示关键字不合理
     */
    private void locationfail() {
        Toast.makeText(this, getResources().getString(R.string.location_edit_empty), Toast.LENGTH_LONG).show();
    }



}
