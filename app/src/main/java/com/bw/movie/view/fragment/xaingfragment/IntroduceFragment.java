package com.bw.movie.view.fragment.xaingfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.XiangBean;
import com.bw.movie.presenter.XiangPresenter;
import com.bw.movie.view.adapter.MovieActorAdapter;
import com.bw.movie.view.adapter.MovieDirectorAdapter;
import com.bw.movie.view.interfaces.IMainView;

import java.util.List;

/**
 * <p>文件描述：介绍<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/15<p>
 * <p>更改时间：2019/11/15<p>
 */
public class IntroduceFragment extends Fragment implements IMainView.CallBackXiang {
    private TextView introduce_summary;
    private TextView introduce_count;
    private TextView movieactor_performer;
    private RecyclerView moviedirector_recy;
    private RecyclerView movieactor_recy;
    private List<XiangBean.ResultBean.MovieActorBean> movieActor;
    private List<XiangBean.ResultBean.MovieDirectorBean> movieDirector;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.introducefragment, container, false);
        introduce_summary = inflate.findViewById(R.id.introduce_summary);
        introduce_count = inflate.findViewById(R.id.introduce_count);
        moviedirector_recy = inflate.findViewById(R.id.moviedirector_recy);
        movieactor_recy = inflate.findViewById(R.id.movieactor_recy);
        movieactor_performer = inflate.findViewById(R.id.movieactor_performer);
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        XiangPresenter presenter=new XiangPresenter();
        presenter.ActachView(this);
        presenter.XiangPresenter(movieId);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        moviedirector_recy.setLayoutManager(linearLayoutManager);

        GridLayoutManager linearLayoutManagertwo=new GridLayoutManager(getActivity(),3);
        linearLayoutManagertwo.setOrientation(GridLayoutManager.VERTICAL);
        movieactor_recy.setLayoutManager(linearLayoutManagertwo);

        return inflate;
    }

    @Override
    public void success(XiangBean xiangBean) {
        XiangBean.ResultBean result = xiangBean.getResult();
        movieDirector = result.getMovieDirector();
        movieActor = result.getMovieActor();
        introduce_summary.setText(result.getSummary());
        int size = result.getMovieDirector().size();
        introduce_count.setText("导演（"+size+"）");
        movieactor_performer.setText("演员("+movieActor.size()+")");

        MovieDirectorAdapter directorAdapter=new MovieDirectorAdapter(movieDirector,getContext());
        moviedirector_recy.setAdapter(directorAdapter);

        MovieActorAdapter actorAdapter=new MovieActorAdapter(movieActor,getContext());
        movieactor_recy.setAdapter(actorAdapter);
    }
}
