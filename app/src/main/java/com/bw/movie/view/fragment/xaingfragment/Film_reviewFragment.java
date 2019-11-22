package com.bw.movie.view.fragment.xaingfragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.PingBean;
import com.bw.movie.presenter.PingPresenter;
import com.bw.movie.view.adapter.FilmdAdapter;
import com.bw.movie.view.interfaces.IMainView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/15<p>
 * <p>更改时间：2019/11/15<p>
 */
public class Film_reviewFragment  extends Fragment implements IMainView.CallBackPing {

    private RecyclerView film_recycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.film_reviewfragment, container, false);
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        Log.d("PPPPP", "onCreateView: "+movieId);
        PingPresenter pingPresenter=new PingPresenter();
        pingPresenter.PingPresenter(movieId);
        pingPresenter.ActachView(this);

        film_recycler = inflate.findViewById(R.id.film_recycler);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        film_recycler.setLayoutManager(manager);

        return inflate;
    }


    @Override
    public void success(PingBean pingBean) {
        List<PingBean.ResultBean> result = pingBean.getResult();
        FilmdAdapter adapter=new FilmdAdapter(result,getContext());
        film_recycler.setAdapter(adapter);

    }
}

