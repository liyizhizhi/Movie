package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.XiangBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/16<p>
 * <p>更改时间：2019/11/16<p>
 */
public class VideoAdapter extends RecyclerView.Adapter {
    List<XiangBean.ResultBean.ShortFilmListBean> list;
    private Context context;

    public VideoAdapter(List<XiangBean.ResultBean.ShortFilmListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.video_item, null);
        MyHolder holder = new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder holder1 = (MyHolder) holder;
        String videoUrl = list.get(position).getVideoUrl();
        holder1.videoplayer.setUp(videoUrl, "");
        Glide.with(context).load(list.get(position).getImageUrl()).into(holder1.videoplayer.ivThumb);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final JCVideoPlayer videoplayer;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            videoplayer = itemView.findViewById(R.id.videoplayer);
        }
    }
}
