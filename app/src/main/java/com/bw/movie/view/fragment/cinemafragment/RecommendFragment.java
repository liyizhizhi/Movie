package com.bw.movie.view.fragment.cinemafragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.model.bean.RecommendBean;
import com.bw.movie.presenter.RecommendedPresenter;
import com.bw.movie.view.activity.FindCinemaInfoActivity;
import com.bw.movie.view.adapter.NearbyAdapter;
import com.bw.movie.view.adapter.RecommendAdapter;
import com.bw.movie.view.interfaces.IMainView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class RecommendFragment extends Fragment implements IMainView.CallBackTuijian {
    private int anInt = 1;
    private int count = 10;
    private XRecyclerView recommend_recyclerview;
    private RecommendedPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.recommendfragment, container, false);
        recommend_recyclerview = inflate.findViewById(R.id.recommend_recyclerview);

        presenter = new RecommendedPresenter();
        presenter.ActachView(this);
        presenter.RecommendedPresenter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recommend_recyclerview.setLayoutManager(linearLayoutManager);
        return inflate;
    }

    @Override
    public void success(RecommendBean recommendBean) {
        List<RecommendBean.ResultBean> recommendBeanResult = recommendBean.getResult();
        RecommendAdapter recommendAdapter = new RecommendAdapter(recommendBeanResult, getContext());
        recommend_recyclerview.setAdapter(recommendAdapter);
        recommendAdapter.onItemClickListener(new RecommendAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int cinemaId) {
                Intent intent=new Intent(getContext(), FindCinemaInfoActivity.class);
                intent.putExtra("cinemaId",cinemaId);
                startActivity(intent);
            }
        });
    }
}
