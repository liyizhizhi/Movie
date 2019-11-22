package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.NearBean;
import com.bw.movie.model.bean.RecommendBean;

import java.util.List;

import retrofit2.http.POST;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/14<p>
 * <p>更改时间：2019/11/14<p>
 */
public class NearbyAdapter extends RecyclerView.Adapter {
    private List<NearBean.ResultBean> list;
    private Context context;

    public NearbyAdapter(List<NearBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.recommend_item, null);
        Viewholder1 viewholder1 = new Viewholder1(inflate);
        return viewholder1;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        Viewholder1 viewholder1 = (Viewholder1) viewHolder;
        viewholder1.tv.setText(list.get(i).getName());
        viewholder1.tv2.setText(list.get(i).getAddress());
        Glide.with(context).load(list.get(i).getLogo()).into(viewholder1.img);
        viewholder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(i, list.get(i).getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {
        private final TextView tv2;
        private final TextView tv;
        private final ImageView img;

        public Viewholder1(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.tjyy_image);
            tv = itemView.findViewById(R.id.tjyy_name);
            tv2 = itemView.findViewById(R.id.tjyy_price);

        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, int cinemaId);
    }
}
