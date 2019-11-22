package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.DoorBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.LodingBean;
import com.bw.movie.presenter.BannerPresenter;
import com.bw.movie.view.activity.XiangActivity;
import com.bw.movie.view.adapter.BaseAdpaterA;
import com.bw.movie.view.adapter.BaseAdpaterB;
import com.bw.movie.view.adapter.BaseAdpaterC;
import com.bw.movie.view.interfaces.IMainView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;
import com.xuezj.cardbanner.CardBanner;
import com.xuezj.cardbanner.ImageData;
import com.xuezj.cardbanner.imageloader.CardImageLoader;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/10/10<p>
 * <p>更改时间：2019/10/10<p>
 */
public class MovieFragment extends Fragment implements IMainView.CallBackBanner {
    private XBanner ban;
    private BannerPresenter bannerPresenter;
    private RecyclerView rexyclerview1;
    private RecyclerView rexyclerview2;
    private RecyclerView recyclerview3;
    private ImageView popular_img;
    private static final String TAG = "MovieFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.moviefragment, container, false);
        popular_img = inflate.findViewById(R.id.popular_img);
        ban = inflate.findViewById(R.id.xbanner);
        rexyclerview1 = inflate.findViewById(R.id.rexyclerview1);
        rexyclerview2 = inflate.findViewById(R.id.rexyclerview2);
        recyclerview3 = inflate.findViewById(R.id.rexyclerview3);


        bannerPresenter = new BannerPresenter();
        bannerPresenter.BannerPresenter();
        bannerPresenter.ActachView(this);
        return inflate;
    }

    @Override
    public void success(BannerBean bannerBean) {
        List<BannerBean.ResultBean> result = bannerBean.getResult();
        ban.setBannerData(R.layout.image_fresco, new AbstractList<SimpleBannerInfo>() {
            @Override
            public SimpleBannerInfo get(int index) {
                return null;
            }

            @Override
            public int size() {
                return result.size();
            }
        });
ban.loadImage(new XBanner.XBannerAdapter() {
    @Override
    public void loadBanner(XBanner banner, Object model, View view, int position) {
        SimpleDraweeView image_fresco = view.findViewById(R.id.my_image_view);
        Uri parse = Uri.parse(result.get(position).getImageUrl());
        image_fresco.setImageURI(parse);
    }
});
    }

    @Override
    public void hotsuccess(HotMovieBean hotMovieBean) {
        final List<HotMovieBean.ResultBean> result = hotMovieBean.getResult();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rexyclerview1.setLayoutManager(manager);
        BaseAdpaterA baseAdpaterA = new BaseAdpaterA(result, getContext());
        rexyclerview1.setAdapter(baseAdpaterA);
        baseAdpaterA.setOnItemClickListener(new BaseAdpaterA.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = getActivity().getIntent();
                int userId = intent.getIntExtra("userId", 0);
                String sessionId = intent.getStringExtra("sessionId");
                int movieId = result.get(position).getMovieId();
                Intent intent1=new Intent(getContext(), XiangActivity.class);
                intent1.putExtra("movieId",movieId);
                intent1.putExtra("userId",userId);
                intent1.putExtra("sessionId",sessionId);
                getContext().startActivity(intent1);
            }
        });
    }

    @Override
    public void logingsuccess(LodingBean lodingBean) {
        final List<LodingBean.ResultBean> result = lodingBean.getResult();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rexyclerview2.setLayoutManager(manager);
        BaseAdpaterB baseAdpaterB = new BaseAdpaterB(result, getContext());
        rexyclerview2.setAdapter(baseAdpaterB);

baseAdpaterB.setOnItemClickListener(new BaseAdpaterB.OnItemClickListener() {
    @Override
    public void onItemClick(View view, int position) {
        Intent intent = getActivity().getIntent();
        int userId = intent.getIntExtra("userId", 0);
        String sessionId = intent.getStringExtra("sessionId");
        int movieId = result.get(position).getMovieId();
        Intent intent1=new Intent(getContext(), XiangActivity.class);
        intent1.putExtra("movieId",movieId);
        intent1.putExtra("userId",userId);
        intent1.putExtra("sessionId",sessionId);
        getContext().startActivity(intent1);
    }
});
    }


    @Override
    public void doorsuccess(DoorBean doorBean) {
        final List<DoorBean.ResultBean> result = doorBean.getResult();
        Glide.with(getContext()).load(result.get(0).getHorizontalImage()).into(popular_img);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview3.setLayoutManager(manager);
        BaseAdpaterC baseAdpaterc = new BaseAdpaterC(result, getContext());
        recyclerview3.setAdapter(baseAdpaterc);
        baseAdpaterc.setOnItemClickListener(new BaseAdpaterC.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = getActivity().getIntent();
                int userId = intent.getIntExtra("userId", 0);
                String sessionId = intent.getStringExtra("sessionId");
                int movieId = result.get(position).getMovieId();
                Intent intent1=new Intent(getContext(), XiangActivity.class);
                intent1.putExtra("movieId",movieId);
                intent1.putExtra("userId",userId);
                intent1.putExtra("sessionId",sessionId);
                getContext().startActivity(intent1);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bannerPresenter.DatachView();
    }
}
