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
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.NearBean;
import com.bw.movie.presenter.NearPresenter;
import com.bw.movie.view.activity.FindCinemaInfoActivity;
import com.bw.movie.view.adapter.NearbyAdapter;
import com.bw.movie.view.interfaces.IMainView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class NearbyFragment extends Fragment implements IMainView.CallBackNear {


    private XRecyclerView near_recyclerview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.nearbyfragment, container, false);
        near_recyclerview = inflate.findViewById(R.id.near_recyclerview);
        NearPresenter presenter=new NearPresenter();
        presenter.NearPresenter();
        presenter.ActachView(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        near_recyclerview.setLayoutManager(linearLayoutManager);
        return inflate;
    }

    @Override
    public void success(NearBean nearBean) {

        List<NearBean.ResultBean> result = nearBean.getResult();
        NearbyAdapter nearbyAdapter = new NearbyAdapter(result,getContext());
        near_recyclerview.setAdapter(nearbyAdapter);
        nearbyAdapter.onItemClickListener(new NearbyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int cinemaId) {
                Intent intent=new Intent(getContext(), FindCinemaInfoActivity.class);
                intent.putExtra("cinemaId",cinemaId);
                startActivity(intent);
            }
        });
    }
}
