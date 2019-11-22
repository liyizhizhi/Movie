package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class TheaterActivity extends AppCompatActivity {
    private JCVideoPlayer theater_shipin;
    private TextView buyMovieTicket_director;
    private RecyclerView rv_movieTicketItem;
    private String videoUrl;
    private String imageUrl;
    private int movieId;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);
        Intent intent = getIntent();
        String details_duration = intent.getStringExtra("details_duration");
        String details_name = intent.getStringExtra("details_name");
        double details_score = intent.getDoubleExtra("details_score", 0);
        videoUrl = intent.getStringExtra("videoUrl");
        imageUrl = intent.getStringExtra("imageUrl");
        movieId = intent.getIntExtra("movieId", 0);
        name = intent.getStringExtra("name");

        TextView buyMovieTicket_name_two = (TextView) findViewById(R.id.buyMovieTicket_name_two);
        TextView buyMovieTicket_time = (TextView) findViewById(R.id.buyMovieTicket_time);
        TextView buyMovieTicket_score = (TextView) findViewById(R.id.buyMovieTicket_score);
        theater_shipin = (JCVideoPlayer) findViewById(R.id.theater_shipin);
        buyMovieTicket_director = (TextView) findViewById(R.id.buyMovieTicket_director);
        rv_movieTicketItem = (RecyclerView) findViewById(R.id.rv_movieTicketItem);
        buyMovieTicket_name_two.setText(details_name);
        buyMovieTicket_time.setText(details_duration);
        buyMovieTicket_score.setText(details_score+"");
        buyMovieTicket_director.setText(name);
        theater_shipin.setUp(videoUrl,"");
        Glide.with(this).load(imageUrl).into(theater_shipin.ivThumb);

    }
}
