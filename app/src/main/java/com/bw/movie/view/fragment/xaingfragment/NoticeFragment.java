package com.bw.movie.view.fragment.xaingfragment;

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
import com.bw.movie.model.bean.XiangBean;
import com.bw.movie.presenter.XiangPresenter;
import com.bw.movie.view.adapter.VideoAdapter;
import com.bw.movie.view.interfaces.IMainView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/15<p>
 * <p>更改时间：2019/11/15<p>
 */
public class NoticeFragment extends Fragment implements IMainView.CallBackXiang {

    private RecyclerView noice_recy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.noicefragment, container, false);

        noice_recy = inflate.findViewById(R.id.noice_recy);

        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);

        XiangPresenter presenter = new XiangPresenter();
        presenter.XiangPresenter(movieId);
        presenter.ActachView(this);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        noice_recy.setLayoutManager(manager);
        return inflate;
    }

    @Override
    public void success(XiangBean xiangBean) {
        List<XiangBean.ResultBean.ShortFilmListBean> shortFilmList = xiangBean.getResult().getShortFilmList();
        VideoAdapter adapter = new VideoAdapter(shortFilmList, getContext());
        noice_recy.setAdapter(adapter);
    }
}

