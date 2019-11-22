package com.bw.movie.view.fragment.cinemafragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.PaiQiBean;
import com.bw.movie.presenter.PaiQiPresenter;
import com.bw.movie.view.activity.SelectionActivity;
import com.bw.movie.view.adapter.PaiQiAdapter;
import com.bw.movie.view.interfaces.IMainView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class TimeFragment extends Fragment implements IMainView.CallBackPaiqi {


    private int cinemaId;
    private RecyclerView time_recycler;
    private List<PaiQiBean.ResultBean> result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.timefragment, null);
        time_recycler = inflate.findViewById(R.id.time_recycler);
        Intent intent = getActivity().getIntent();
        cinemaId = intent.getIntExtra("cinemaId", 0);
        Log.d("LiL", "onCreateView: " + cinemaId);

        PaiQiPresenter paiQiPresenter = new PaiQiPresenter();
        paiQiPresenter.PaiQiPresenter(cinemaId);
        paiQiPresenter.ActachView(this);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        time_recycler.setLayoutManager(manager);


        return inflate;
    }

    @Override
    public void Paiqisuccess(PaiQiBean qiBean) {
        result = qiBean.getResult();
        PaiQiAdapter adapter = new PaiQiAdapter(result, getContext());
        time_recycler.setAdapter(adapter);


        adapter.setOnItemClickListener(new PaiQiAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String imageUrl = result.get(position).getImageUrl();
                int movieId = result.get(position).getMovieId();
                String trailerUrl = result.get(position).getTrailerUrl();
                String name = result.get(position).getName();

                Intent intent = new Intent(getContext(), SelectionActivity.class);
                intent.putExtra("trailerUrl", trailerUrl);
                intent.putExtra("movieId", movieId);
                intent.putExtra("cinemaId", cinemaId);
                intent.putExtra("name", name);
                intent.putExtra("imageUrl", imageUrl);
                getActivity().startActivity(intent);
            }
        });
    }
}
