package com.purestation.androidcodeexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class OnNewIntentActivity extends AppCompatActivity {
    private static final String TAG = "OnNewIntentTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v(TAG, "onCreate");

        setContentView(R.layout.activity_on_new_intent);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnNewIntentActivity.this, OnNewIntentActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.v(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v(TAG, "onResume");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.v(TAG, "onNewIntent");
    }
}
