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
public class MovieActorAdapter extends RecyclerView.Adapter {
    private List<XiangBean.ResultBean.MovieActorBean> movieActor;
    private Context context;

    public MovieActorAdapter(List<XiangBean.ResultBean.MovieActorBean> movieActor, Context context) {
        this.movieActor = movieActor;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.movieactor, null);
        MyHolder holder = new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder holder1 = (MyHolder) holder;
        holder1.movieactor_name.setText(movieActor.get(position).getName());
        String photo = movieActor.get(position).getPhoto();
        Glide.with(context).load(photo).into(holder1.movieactor_photo);
    }

    @Override
    public int getItemCount() {
        return movieActor.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView movieactor_photo;
        private final TextView movieactor_name;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            movieactor_photo = itemView.findViewById(R.id.movieactor_photo);
            movieactor_name = itemView.findViewById(R.id.movieactor_name);

        }
    }
}
