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
import com.bw.movie.model.bean.DoorBean;
import com.bw.movie.view.activity.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/12<p>
 * <p>更改时间：2019/11/12<p>
 */
public class BaseAdpaterC extends RecyclerView.Adapter {
    List<DoorBean.ResultBean> result;
    private Context context;

    public BaseAdpaterC(List<DoorBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dooradapter, null);
        MyHolder holder = new MyHolder(inflate);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        MyHolder holder = (MyHolder) viewHolder;
        holder.recy3_text1.setText(result.get(i).getScore()+ "");
        holder.recy3_text2.setText(result.get(i).getName());
        String url = result.get(i).getImageUrl();
        Uri parse = Uri.parse(url);
        holder.recy3_image2.setImageURI(parse);
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

        private final TextView recy3_text1,recy3_text2;
        private final SimpleDraweeView recy3_image2;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            recy3_image2 = itemView.findViewById(R.id.recy3_image2);
            recy3_text1 = itemView.findViewById(R.id.recy3_text1);
            recy3_text2 = itemView.findViewById(R.id.recy3_text2);
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

