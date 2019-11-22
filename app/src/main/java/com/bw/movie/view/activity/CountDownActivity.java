package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.bw.movie.R;

public class CountDownActivity extends AppCompatActivity {
    private int i = 5;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (i > 0) {
                i--;
                handler.sendEmptyMessageDelayed(0, 100);
            } else {
                Intent intent = new Intent(CountDownActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity_main);
        handler.sendEmptyMessageDelayed(0, 100);

    }

}
