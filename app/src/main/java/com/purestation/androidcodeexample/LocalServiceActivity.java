package com.purestation.androidcodeexample;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class LocalServiceActivity extends AppCompatActivity {
    public static final String TAG = "LocalServiceTestActivity";

    private LocalService mService;
    private boolean mBound = false;

    @SuppressLint("LongLogTag")
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.v(TAG, "onServiceConnected");

            LocalService.LocalBinder binder = (LocalService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.v(TAG, "onServiceDisconnected");

            mBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_service);

        findViewById(R.id.buttonBind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LocalServiceActivity.this, LocalService.class);
                bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.buttonUnbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(mConnection);
            }
        });

        findViewById(R.id.buttonApplicationBind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyApplication) getApplication()).bindLocalService();
            }
        });

        findViewById(R.id.buttonApplicationUnbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyApplication) getApplication()).unbindLocalService();
            }
        });
    }
}
