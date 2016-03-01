package com.example.weezn.remember.Event;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Location_service
 *
 * @author: weezn
 * @time: 2016/3/1 23:29
 */
public class Location_service extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void location(){


    }
}
