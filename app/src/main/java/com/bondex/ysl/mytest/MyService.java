package com.bondex.ysl.mytest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
/**
 * date: 2018/11/12
 * Author: ysl
 * description:
 */
public class MyService extends Service {
    @Override
    public IBinder onBind(Intent intent) {

        Log.i(Constant.TAG,"bind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(Constant.TAG,"start");

        return super.onStartCommand(intent, flags, startId);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(Constant.TAG,"stop");
    }

}
