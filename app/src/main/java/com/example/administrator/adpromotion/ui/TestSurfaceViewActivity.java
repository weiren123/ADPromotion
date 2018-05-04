package com.example.administrator.adpromotion.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.adpromotion.widget.AutoSufaceView;

public class TestSurfaceViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AutoSufaceView autoSufaceView = new AutoSufaceView(this);
//        LayoutInflater.from(this).inflate()
        setContentView(autoSufaceView);
    }
}
