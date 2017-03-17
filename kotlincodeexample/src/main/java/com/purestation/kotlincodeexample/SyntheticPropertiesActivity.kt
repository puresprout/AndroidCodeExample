package com.purestation.kotlincodeexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_synthetic_properties.*

class SyntheticPropertiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_synthetic_properties)

        button.setText("Synthetic Properties");
    }
}
