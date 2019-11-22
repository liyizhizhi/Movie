package com.bw.movie.view.fragment.xaingfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.XiangBean;
import com.bw.movie.presenter.XiangPresenter;
import com.bw.movie.view.adapter.JvAdapter;
import com.bw.movie.view.interfaces.IMainView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/15<p>
 * <p>更改时间：2019/11/15<p>
 */
public class StillsFragment extends Fragment implements IMainView.CallBackXiang {
    private RecyclerView jv_recyclerview;
    private List<XiangBean.ResultBean.ShortFilmListBean> shortFilmList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.stillsfragment, container, false);
        jv_recyclerview = inflate.findViewById(R.id.jv_recyclerview);
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        XiangPresenter presenter = new XiangPresenter();
        presenter.XiangPresenter(movieId);
        presenter.ActachView(this);

        GridLayoutManager manager=new GridLayoutManager(getContext(),3);
        jv_recyclerview.setLayoutManager(manager);
        return inflate;
    }

    @Override
    public void success(XiangBean xiangBean) {
        shortFilmList = xiangBean.getResult().getShortFilmList();

        JvAdapter adapter= new JvAdapter(shortFilmList,getContext());
        jv_recyclerview.setAdapter(adapter);
    }
}
