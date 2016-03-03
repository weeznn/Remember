package com.example.weezn.remember;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.util.Log;

/**
 * FenceReceive
 *
 * @author: weezn
 * @time: 2016/3/2 19:07
 */
public class FenceReceive extends BroadcastReceiver {

    public final static String TAG="FenceReceive";
    @Override
    public void onReceive(Context context, Intent intent) {
//        Intent Tintent = new Intent(context, FenceService.class);
//        context.startService(Tintent);
        boolean isEnter=intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING,false);
        if(isEnter){
            //系统震动服务
            Log.i(TAG,"待完善");
        }else{

        }
    }

}
