package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.BuyBean;
import com.bw.movie.model.bean.ZuoBean;
import com.bw.movie.presenter.BuyPresenter;
import com.bw.movie.presenter.ZuoPresenter;
import com.bw.movie.view.adapter.Tick_adapter;
import com.bw.movie.view.fragment.cinemafragment.TimeFragment;
import com.bw.movie.view.interfaces.IMainView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class SelectionActivity extends AppCompatActivity implements IMainView.CallBackBuy, IMainView.CallBackZuo {
    private static final String TAG = "SelectionActivity";
    private JCVideoPlayer ticket_shipin;
    private TextView ticket_name;
    private RecyclerView ticket_recy;
    private int hallId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        Intent intent = getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        int cinemaId = intent.getIntExtra("cinemaId", 0);
        String trailerUrl = intent.getStringExtra("trailerUrl");
        String name = intent.getStringExtra("name");
        String imageUrl = intent.getStringExtra("imageUrl");

        ticket_name = (TextView) findViewById(R.id.ticket_name);
        ticket_shipin = (JCVideoPlayer) findViewById(R.id.ticket_shipin);
        ticket_recy = findViewById(R.id.ticket_recy);
        ticket_name.setText(name);
        ticket_shipin.setUp(trailerUrl, "");
        Glide.with(this).load(imageUrl).into(ticket_shipin.ivThumb);


        ZuoPresenter zuoPresenter = new ZuoPresenter();
        zuoPresenter.ActachView(this);
        zuoPresenter.ZuoPresenter(hallId);


        BuyPresenter presenter = new BuyPresenter();
        presenter.BuyPresenter(cinemaId, movieId);
        presenter.ActachView(this);

    }

    @Override
    public void buysuccess(BuyBean buyBean) {
        List<BuyBean.ResultBean> result = buyBean.getResult();
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        ticket_recy.setLayoutManager(manager);

        Tick_adapter adapter = new Tick_adapter(result, this);
        ticket_recy.setAdapter(adapter);

        adapter.setOnItemClickListener(new Tick_adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int id) {
                hallId = id;

            }
        });

    }

    @Override
    public void zuosuccess(ZuoBean zuoBean) {
        List<ZuoBean.ResultBean> result = zuoBean.getResult();


    }
}
