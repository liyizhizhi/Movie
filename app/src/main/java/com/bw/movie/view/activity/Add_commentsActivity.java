package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.bean.AttentionBean;
import com.bw.movie.presenter.AttCommentPresenter;
import com.bw.movie.view.interfaces.IMainView;

public class Add_commentsActivity extends AppCompatActivity implements IMainView.CallBackAttention {
    private static final String TAG = "Add_commentsActivity";
    private ImageView addcomments_tiao;
    private TextView addcomments_name;
    private TextView addcomments_score;
    private RatingBar addcomments_ratingbar;
    private EditText addcomments_shu;
    private Button addcomments_btn;
    private int progress;
    private AttCommentPresenter commentPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comments);
        addcomments_tiao = (ImageView) findViewById(R.id.addcomments_tiao);
        addcomments_name = (TextView) findViewById(R.id.addcomments_name);
        addcomments_score = (TextView) findViewById(R.id.addcomments_score);
        addcomments_ratingbar = (RatingBar) findViewById(R.id.addcomments_ratingbar);
        addcomments_shu = (EditText) findViewById(R.id.addcomments_shu);
        addcomments_btn = (Button) findViewById(R.id.addcomments_btn);

        commentPresenter = new AttCommentPresenter();
        commentPresenter.ActachView(this);

        Intent intent = getIntent();
        int movieId= intent.getIntExtra("movieId",0);
        String name = intent.getStringExtra("name");
        String sessionId = intent.getStringExtra("sessionId");
        int userId = intent.getIntExtra("userId", 0);
        Log.d(TAG, "onCreate: "+movieId);
        Log.d(TAG, "onCreate: "+name);
        Log.d(TAG, "onCreate: "+sessionId);
        Log.d(TAG, "onCreate: "+userId);
        addcomments_tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        addcomments_name.setText(name);
        addcomments_ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                progress = addcomments_ratingbar.getProgress();
                addcomments_score.setText("我的评分("+ progress +")");
            }
        });
        addcomments_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shu = addcomments_shu.getText().toString().trim();
             commentPresenter.AttCommentPresenter(userId,sessionId,movieId,shu,progress);
            }
        });

    }

    @Override
    public void Attentionsuccess(AttentionBean attentionBean) {
        String message = attentionBean.getMessage();
        if (attentionBean.getStatus().equals("0000")){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        }
    }
}
