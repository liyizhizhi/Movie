package com.bw.movie.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.model.bean.FindCinemainfoBean;
import com.bw.movie.presenter.FindCinemainfoPresenter;
import com.bw.movie.view.fragment.findfragment.Info_EvaluationFragment;
import com.bw.movie.view.fragment.findfragment.Info_detailsFragment;
import com.bw.movie.view.interfaces.IMainView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FindCinemaInfoActivity extends AppCompatActivity implements IMainView.CallBackFindCinemainfo {
    private TextView name;
    private TextView lable;

    private String name1;
    private String label;
    private TabLayout tab;
    private int p = 0;
    private ImageView info_xin;
    private String message;
    private ViewPager vp;
    private int cinemaId;
    private Button btn_check_theater_schedules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_cinema_info);
        Intent intent = getIntent();
        cinemaId = intent.getIntExtra("cinemaId", 0);

        name = (TextView) findViewById(R.id.info_name);
        lable = (TextView) findViewById(R.id.info_lable);
        tab = (TabLayout) findViewById(R.id.info_tab);

        info_xin = (ImageView) findViewById(R.id.info_xin);
        vp = (ViewPager) findViewById(R.id.info_vp);
        btn_check_theater_schedules = findViewById(R.id.btn_check_theater_schedules);

        FindCinemainfoPresenter presenter = new FindCinemainfoPresenter();
        presenter.FindCinemainfoPresenter(cinemaId);
        presenter.ActachView(this);


        List<Fragment> list = new ArrayList<>();
        list.add(new Info_detailsFragment());
        list.add(new Info_EvaluationFragment());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        btn_check_theater_schedules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindCinemaInfoActivity.this, ScheduleActivity.class);
                intent.putExtra("cinemaId",cinemaId);
                startActivity(intent);
            }
        });

        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("影院详情");
        tab.getTabAt(1).setText("影院评价");
    }

    @Override
    public void FindCinemainfosuccess(FindCinemainfoBean findCinemainfoBean) {
        name1 = findCinemainfoBean.getResult().getName();
        label = findCinemainfoBean.getResult().getLabel();

        name.setText(name1);
        lable.setText(label);
    }
}
