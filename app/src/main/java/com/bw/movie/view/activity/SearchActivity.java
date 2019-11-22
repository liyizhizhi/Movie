package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.model.bean.SearchBean;
import com.bw.movie.presenter.SearchPresenter;
import com.bw.movie.view.adapter.SearchMovieAdapter;
import com.bw.movie.view.interfaces.IMainView;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements IMainView.CallBackSearch {

    private EditText etMovieThekeyword;
    private ImageView ivSearchMovie;
    private ImageView search_back;
    private RecyclerView recyclerThekeyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        etMovieThekeyword = (EditText) findViewById(R.id.et_movie_thekeyword);
        ivSearchMovie = (ImageView) findViewById(R.id.iv_search_movie);
        recyclerThekeyword = (RecyclerView) findViewById(R.id.recycler_thekeyword);
        search_back = (ImageView) findViewById(R.id.search_back);

        SearchPresenter presenter=new SearchPresenter();
        presenter.ActachView(this);

        ivSearchMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = etMovieThekeyword.getText().toString().trim();
                presenter.SearchPresenter(keyword , 1, 1);
            }
        });
        search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void searchsuccess(SearchBean searchBean) {
        if (searchBean.getMessage().equals("未查到相关电影")){
            Toast.makeText(this,searchBean.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }else {
            List<SearchBean.ResultBean> result = searchBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerThekeyword.setLayoutManager(linearLayoutManager);
            SearchMovieAdapter adapter = new SearchMovieAdapter(result, this);
            recyclerThekeyword.setAdapter(adapter);
        }
    }
}
