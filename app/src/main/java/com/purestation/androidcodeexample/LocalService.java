package com.purestation.androidcodeexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class LocalService extends Service {
    private static final String TAG = "LocalService";

    private final IBinder mBinder = new LocalBinder();

    public LocalService() {
    }

    public class LocalBinder extends Binder {
        LocalService getService() {
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "onBind");

        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(TAG, "onUnbind");

        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        Log.v(TAG, "onCreate");

        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.v(TAG, "onDestroy");

        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG, "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }
}
