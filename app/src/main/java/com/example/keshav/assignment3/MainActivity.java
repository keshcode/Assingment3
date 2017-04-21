package com.example.keshav.assignment3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.keshav.assignment3.constants.Constants;

/**
 * this is a splash screen
 */
public class MainActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ScreenBActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY);
    }

    @Override
    public Void init() {
        return null;
    }
}
