package com.bw.movie.view.fragment.findfragment;

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
import com.bw.movie.model.bean.FindCommentBean;
import com.bw.movie.presenter.FindCommentPresenter;
import com.bw.movie.view.adapter.Info_EvaluationAdapter;
import com.bw.movie.view.interfaces.IMainView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class Info_EvaluationFragment extends Fragment implements IMainView.CallBackFindComment {
    private RecyclerView info_recy;
    private List<FindCommentBean.ResultBean> result;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.info_evaluation, null);
        info_recy = inflate.findViewById(R.id.info_recy);
        Intent intent = getActivity().getIntent();
        int cinemaId = intent.getIntExtra("cinemaId", 0);

        FindCommentPresenter presenter = new FindCommentPresenter();
        presenter.FindCommentPresenter(cinemaId);
        presenter.ActachView(this);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        info_recy.setLayoutManager(linearLayoutManager);
        return inflate;
    }

    @Override
    public void FindFindCommentsuccess(FindCommentBean findCommentBean) {
        result = findCommentBean.getResult();
        Info_EvaluationAdapter info_evaluationAdapter = new Info_EvaluationAdapter(result,getContext());
        info_recy.setAdapter(info_evaluationAdapter);
    }
}
