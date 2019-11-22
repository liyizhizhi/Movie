package com.bw.movie.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.model.bean.Timebean;
import com.bw.movie.presenter.TimePresenter;
import com.bw.movie.view.fragment.cinemafragment.TimeFragment;
import com.bw.movie.view.interfaces.IMainView;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ScheduleActivity extends AppCompatActivity implements IMainView.CallBackTime {

    private TimePresenter presenter;
    private List<String> result;
    private TabLayout schedule_tablayout;
    private ViewPager schedule_viewpager;
    private int cinemaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Intent intent = getIntent();
        cinemaId = intent.getIntExtra("cinemaId", 0);
        presenter = new TimePresenter();
        presenter.TimePresenter();
        presenter.ActachView(this);

        schedule_tablayout = findViewById(R.id.schedule_tablayout);
        schedule_viewpager = findViewById(R.id.schedule_viewpager);


    }

    @Override
    public void Timesuccess(Timebean timebean) {
        result = timebean.getResult();
        schedule_viewpager.setAdapter(new MyAapter(getSupportFragmentManager()));
        schedule_tablayout.setupWithViewPager(schedule_viewpager);

    }


    class MyAapter extends FragmentPagerAdapter {
        public MyAapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            TimeFragment t=new TimeFragment();
            return t;
        }

        @Override
        public int getCount() {
            return result.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return result.get(position);
        }
    }
}
