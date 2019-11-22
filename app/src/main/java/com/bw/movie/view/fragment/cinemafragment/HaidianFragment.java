package com.bw.movie.view.fragment.cinemafragment;

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
import com.bw.movie.model.bean.ErJiBean;
import com.bw.movie.model.bean.QvBean;
import com.bw.movie.presenter.ErJiPresenter;
import com.bw.movie.presenter.QvPresenter;
import com.bw.movie.view.adapter.ErJiAdapter;
import com.bw.movie.view.adapter.QvAdapter;
import com.bw.movie.view.interfaces.IMainView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class HaidianFragment extends Fragment implements IMainView.CallBackQv, IMainView.CallBackErji {
    private RecyclerView near_recycler_left;
    private RecyclerView near_recycler_right;
    private ErJiPresenter erJiPresenter;
    public static final String TAG="HaidianFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.haidianfragment, container, false);
        near_recycler_left = inflate.findViewById(R.id.near_recycler_left);
        near_recycler_right = inflate.findViewById(R.id.near_recycler_right);

        QvPresenter qvPresenter = new QvPresenter();
        qvPresenter.QvPresenter();
        qvPresenter.ActachView(this);

        erJiPresenter = new ErJiPresenter();
        erJiPresenter.ActachView(this);
        return inflate;
    }

    @Override
    public void success(QvBean qvBean) {
        List<QvBean.ResultBean> result = qvBean.getResult();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        near_recycler_left.setLayoutManager(manager);

        QvAdapter adapter = new QvAdapter(result, getContext());
        near_recycler_left.setAdapter(adapter);
        adapter.QvAdapter(new QvAdapter.mOnclicklister() {
            @Override
            public void onclick(int regionId) {
                erJiPresenter.ErJiPresenter(regionId);
                Log.e("LL", "onclick: "+regionId );
            }
        });
    }

    @Override
    public void success(ErJiBean erJiBean) {
        List<ErJiBean.ResultBean> result = erJiBean.getResult();
        Log.d(TAG, "success: "+result);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        near_recycler_right.setLayoutManager(manager);

        ErJiAdapter adapter=new ErJiAdapter(result,getContext());
        near_recycler_right.setAdapter(adapter);

    }
}
