package com.bw.movie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.PaiQiBean;
import com.bw.movie.view.activity.SelectionActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/21<p>
 * <p>更改时间：2019/11/21<p>
 */
public class PaiQiAdapter extends RecyclerView.Adapter {
    List<PaiQiBean.ResultBean> result;
    private Context context;

    public PaiQiAdapter(List<PaiQiBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.paiqi_item, null);
        MyHolders holders = new MyHolders(inflate);
        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolders holders = (MyHolders) holder;
        holders.times_text1.setText(result.get(position).getName());
        holders.times_text2.setText(result.get(position).getDirector());
        holders.times_text3.setText(result.get(position).getStarring());
        holders.times_text4.setText(result.get(position).getScore() + "");
        String imageUrl = result.get(position).getImageUrl();
        Uri parse = Uri.parse(imageUrl);
        holders.times_image.setImageURI(parse);
        holders.times_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               itemClickListener.onItemClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyHolders extends RecyclerView.ViewHolder {

        private final Button times_but;
        private final SimpleDraweeView times_image;
        private final TextView times_text1;
        private final TextView times_text2;
        private final TextView times_text3;
        private final TextView times_text4;

        public MyHolders(@NonNull View itemView) {
            super(itemView);
            times_but = itemView.findViewById(R.id.times_but);
            times_image = itemView.findViewById(R.id.times_image);
            times_text1 = itemView.findViewById(R.id.times_text1);
            times_text2 = itemView.findViewById(R.id.times_text2);
            times_text3 = itemView.findViewById(R.id.times_text3);
            times_text4 = itemView.findViewById(R.id.times_text4);


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
