package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;

public class MySettingActivity extends AppCompatActivity {
    private ImageView setting_back;
    private ImageView gengxin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_setting);
        setting_back = findViewById(R.id.setting_back);
        gengxin = findViewById(R.id.gengxin);
        setting_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        gengxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MySettingActivity.this, UpDateActivity.class));
            }
        });
    }
}
