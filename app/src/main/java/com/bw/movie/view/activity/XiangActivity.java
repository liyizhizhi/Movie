package com.bw.movie.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.XiangBean;
import com.bw.movie.presenter.XiangPresenter;
import com.bw.movie.view.fragment.xaingfragment.Film_reviewFragment;
import com.bw.movie.view.fragment.xaingfragment.IntroduceFragment;
import com.bw.movie.view.fragment.xaingfragment.NoticeFragment;
import com.bw.movie.view.fragment.xaingfragment.StillsFragment;
import com.bw.movie.view.interfaces.IMainView;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XiangActivity extends AppCompatActivity implements IMainView.CallBackXiang {
    private ArrayList<Fragment> list;
    private ImageView img;
    private TextView details_movietype;
    private TextView details_duration;
    private TextView details_releasetime;
    private TextView details_placeOrigin;
    private TextView details_name;
    private TextView details_score;
    private TextView details_commentnum;
    private TextView guanzhu;
    private ImageView details_tiao;
    private ImageView xin;
    private TabLayout tabLayout;
    private ViewPager details_vp;
    private Button film_review;
    private Button selection;
    private String imageUrl;
    private static final String TAG = "XiangActivity";
    private int userId;
    private String sessionId;
    private int movieId;
    private XiangBean.ResultBean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);

        img = (ImageView) findViewById(R.id.details_img);
        details_name = (TextView) findViewById(R.id.details_name);
        details_movietype = (TextView) findViewById(R.id.details_movietype);
        details_commentnum = (TextView) findViewById(R.id.details_commentnum);
        details_duration = (TextView) findViewById(R.id.details_duration);
        details_releasetime = (TextView) findViewById(R.id.details_releasetime);
        details_placeOrigin = (TextView) findViewById(R.id.details_placeOrigin);
        details_score = (TextView) findViewById(R.id.details_score);
        tabLayout = (TabLayout) findViewById(R.id.details_tablayout);
        details_vp = (ViewPager) findViewById(R.id.details_vp);
        selection = (Button) findViewById(R.id.selection);
        xin = (ImageView) findViewById(R.id.xin);
        guanzhu = (TextView) findViewById(R.id.guanzhu);
        details_tiao = (ImageView) findViewById(R.id.details_tiao);
        film_review = (Button) findViewById(R.id.film_review);
        details_tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XiangActivity.this, HomeActivity.class));
            }
        });
        Intent intent = getIntent();
        movieId = intent.getIntExtra("movieId", 0);
        userId = intent.getIntExtra("userId", 0);
        sessionId = intent.getStringExtra("sessionId");
        Log.d(TAG, "onCreate: "+ movieId);
        Log.d(TAG, "onCreate: "+ userId);
        Log.d(TAG, "onCreate: "+ sessionId);


        film_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = details_name.getText().toString();
                Intent intent = new Intent(XiangActivity.this,Add_commentsActivity.class);
                intent.putExtra("userId",userId);
                intent.putExtra("sessionId", sessionId);
                intent.putExtra("name",name);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }
        });



        selection.setOnClickListener(new View.OnClickListener() {

            private String name;
            private String imageUrl;
            private String videoUrl;

            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(XiangActivity.this,TheaterActivity.class);
                intent1.putExtra("details_duration",result.getDuration());
                intent1.putExtra("details_name",result.getName());
                intent1.putExtra("details_score",result.getScore());
                List<XiangBean.ResultBean.ShortFilmListBean> shortFilmList = result.getShortFilmList();
                for (int i = 0; i <shortFilmList.size() ; i++) {
                    videoUrl = shortFilmList.get(i).getVideoUrl();
                    imageUrl = shortFilmList.get(i).getImageUrl();
                }
                for (int i = 0; i < result.getMovieDirector().size(); i++) {
                    name = result.getMovieDirector().get(i).getName();
                }
                intent1.putExtra("videoUrl",videoUrl);
                intent1.putExtra("imageUrl",imageUrl);
                intent1.putExtra("name",name);
                intent1.putExtra("movieId",movieId);
                startActivity(intent1);
            }
        });

        XiangPresenter presenter = new XiangPresenter();
        presenter.XiangPresenter(movieId);
        presenter.ActachView(this);


        list = new ArrayList<>();
        list.add(new IntroduceFragment());
        list.add(new NoticeFragment());
        list.add(new StillsFragment());
        list.add(new Film_reviewFragment());
        details_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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

        tabLayout.setupWithViewPager(details_vp);
        tabLayout.getTabAt(0).setText("介绍");
        tabLayout.getTabAt(1).setText("预告");
        tabLayout.getTabAt(2).setText("剧照");
        tabLayout.getTabAt(3).setText("影评");

    }

    @Override
    public void success(XiangBean xiangBean) {
        result = xiangBean.getResult();
        imageUrl = result.getImageUrl();
        movieId = result.getMovieId();
        Glide.with(this).load(imageUrl).into(img);
        details_name.setText(result.getName());
        details_movietype.setText(result.getMovieType());
        details_duration.setText(result.getDuration());
        details_commentnum.setText("评论  "+ result.getCommentNum()+"万条");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long releaseTime = result.getReleaseTime();
        String format = simpleDateFormat.format(releaseTime);
        details_releasetime.setText(format);
        details_placeOrigin.setText(result.getPlaceOrigin()+"上映");
        details_score.setText("评分"+ result.getScore()+"分");
    }
}
