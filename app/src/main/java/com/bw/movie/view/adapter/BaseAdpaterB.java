package com.bw.movie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.LodingBean;
import com.bw.movie.view.activity.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/12<p>
 * <p>更改时间：2019/11/12<p>
 */
public class BaseAdpaterB extends RecyclerView.Adapter {
    List<LodingBean.ResultBean> result;
    private Context context;

    public BaseAdpaterB(List<LodingBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recycler_loding, null);
        MyHolder holder = new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        MyHolder holder = (MyHolder) viewHolder;
        holder.recy2_text1.setText(result.get(i).getName() );
        holder.recy2_text2.setText(result.get(i).getReleaseTime()+"");
        holder.recy2_text3.setText(result.get(i).getWantSeeNum()+"");
        String url = result.get(i).getImageUrl();
        Uri parse = Uri.parse(url);
        holder.recy2_image.setImageURI(parse);
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

        private final TextView recy2_text1,recy2_text2,recy2_text3;
        private final SimpleDraweeView recy2_image;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            recy2_image = itemView.findViewById(R.id.recy2_image);
            recy2_text1 = itemView.findViewById(R.id.recy2_text1);
            recy2_text2 = itemView.findViewById(R.id.recy2_text2);
            recy2_text3 = itemView.findViewById(R.id.recy2_text3);
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
