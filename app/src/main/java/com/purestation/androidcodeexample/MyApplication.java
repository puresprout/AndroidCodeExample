package com.purestation.androidcodeexample;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by sunghyun on 2017. 3. 17..
 */

public class MyApplication extends Application {
    private static final String TAG = "TestApplication";

    private LocalService mService;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.v(TAG, "onServiceConnected");

            LocalService.LocalBinder binder = (LocalService.LocalBinder) service;
            mService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.v(TAG, "onServiceDisconnected");
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void bindLocalService() {
        Intent intent = new Intent(this, LocalService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    public void unbindLocalService() {
        unbindService(mConnection);
    }
}
