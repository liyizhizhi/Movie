package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.XiangBean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/15<p>
 * <p>更改时间：2019/11/15<p>
 */
public class MovieDirectorAdapter extends RecyclerView.Adapter {
    private List<XiangBean.ResultBean.MovieDirectorBean> movieDirector;
    private Context context;

    public MovieDirectorAdapter(List<XiangBean.ResultBean.MovieDirectorBean> movieDirector, Context context) {
        this.movieDirector = movieDirector;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.moviedirector, null);
        MyHolder holder = new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder holder1 = (MyHolder) holder;
        holder1.introduce_name.setText(movieDirector.get(position).getName());
        String photo = movieDirector.get(position).getPhoto();
        Glide.with(context).load(photo).into(holder1.introduce_photo);
    }

    @Override
    public int getItemCount() {
        return movieDirector.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView introduce_photo;
        private final TextView introduce_name;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            introduce_photo = itemView.findViewById(R.id.introduce_photo);
            introduce_name = itemView.findViewById(R.id.introduce_name);
        }
    }
}
