package com.example.weezn.remember.Event;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.example.weezn.remember.R;

/**
 * AdressActivity
 *
 * @author: weezn
 * @time: 2016/2/19 0:14
 */
public class AdressActivity extends Activity implements GeocodeSearch.OnGeocodeSearchListener {
    private static final String TAG="AdressActivity";

    private MapView mapView= (MapView) findViewById(R.id.map);
    private AMap aMap;

    private EditText editText= (EditText) findViewById(R.id.new_address_edit_text);
    private Button button= (Button) findViewById(R.id.location);

    private int radiu=80;//地图圆形区域半径
    private LatLonPoint point;//地址的经纬度对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //必须回掉mapview的oncreat方法
        mapView.onCreate(savedInstanceState);
        init();

        //设置使用普通地图
        aMap.setMapType(AMap.MAP_TYPE_NORMAL);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.equals("")){
                    Toast.makeText(AdressActivity.this,getResources().getString(R.string.location_edit_empty),Toast.LENGTH_LONG).show();
                }else{
                    GeocodeSearch geocodeSearch=new GeocodeSearch(AdressActivity.this);
                    geocodeSearch.setOnGeocodeSearchListener(AdressActivity.this);
                    GeocodeQuery query=new GeocodeQuery(editText.getText().toString(),"010");
                    //将中文转换为地址编码
                    geocodeSearch.getFromLocationNameAsyn(query);
                }
            }
        });

    }

    /**
     * 初始化amap对象
     */
    private void init(){
        if(null==aMap){
            aMap=mapView.getMap();
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
        GeocodeAddress geocodeAddress=geocodeResult.getGeocodeAddressList().get(0);
        //获取解析得到的经纬度
        point= geocodeAddress.getLatLonPoint();
        LatLng latLng = new LatLng(point.getLatitude(),point.getLongitude());
        //创见一个设置经纬度的cameraupdata
        CameraUpdate cameraUpdate= CameraUpdateFactory.changeLatLng(latLng);
        //更新地图的显示区域
        aMap.moveCamera(cameraUpdate);
        //创建一个圆形区域
        CircleOptions circleOptions=new CircleOptions()
                .center(latLng)//圆心
                .fillColor(0X80ffff00)//填充颜色
                .radius(radiu)    //半径
                .strokeWidth(1)   //线条宽度
                .strokeColor(Color.RED);//线条颜色
        aMap.addCircle(circleOptions);
    }

    private void GroundOverlayoOption(){}

    public void setRadiu(int radiu) {
        this.radiu = radiu;
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
}
