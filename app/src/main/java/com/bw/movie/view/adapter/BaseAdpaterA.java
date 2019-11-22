package com.bw.movie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.view.activity.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/12<p>
 * <p>更改时间：2019/11/12<p>
 */
public class BaseAdpaterA extends RecyclerView.Adapter {
    List<HotMovieBean.ResultBean> result;
    private Context context;

    public BaseAdpaterA(List<HotMovieBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recyclea, null);
        MyHolder holder = new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        final MyHolder holder = (MyHolder) viewHolder;
        holder.recy_text1.setText(result.get(i).getScore() + "");
        holder.recy_text2.setText(result.get(i).getName());
        String url = result.get(i).getImageUrl();
        Uri uri=Uri.parse(url);
        holder.recy_image.setImageURI(uri);
        int movieId = result.get(i).getMovieId();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               itemClickListener.onItemClick(v,i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final TextView recy_text1;
        private final TextView recy_text2;
        private final Button recy_but;
        private final SimpleDraweeView recy_image;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            recy_text1 = itemView.findViewById(R.id.recy_text1);
            recy_text2 = itemView.findViewById(R.id.recy_text2);
            recy_but = itemView.findViewById(R.id.recy_but);
            recy_image = itemView.findViewById(R.id.recy_image);
        }
    }
    public OnItemClickListener itemClickListener;

    public interface  OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}

