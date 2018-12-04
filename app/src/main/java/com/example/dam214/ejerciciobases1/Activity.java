package com.example.dam214.ejerciciobases1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity extends AppCompatActivity {
    ActionBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        bar = getSupportActionBar();
        bar.setTitle(R.string.nombre);
    }
}
