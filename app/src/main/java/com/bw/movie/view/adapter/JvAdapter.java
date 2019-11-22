package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.XiangBean;

import java.util.List;

import retrofit2.http.PartMap;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/18<p>
 * <p>更改时间：2019/11/18<p>
 */
public class JvAdapter extends RecyclerView.Adapter {
    private List<XiangBean.ResultBean.ShortFilmListBean> shortFilmList;
    private Context context;

    public JvAdapter(List<XiangBean.ResultBean.ShortFilmListBean> shortFilmList, Context context) {
        this.shortFilmList = shortFilmList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.stills_item, null);
        MyHolders holders = new MyHolders(inflate);
        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolders holders = (MyHolders) holder;
        String imageUrl = shortFilmList.get(position).getImageUrl();
        Glide.with(context).load(imageUrl).into(holders.stills_image);
    }

    @Override
    public int getItemCount() {
        return shortFilmList.size();
    }

    class MyHolders extends RecyclerView.ViewHolder {

        private final ImageView stills_image;

        public MyHolders(@NonNull View itemView) {
            super(itemView);

            stills_image = itemView.findViewById(R.id.stills_image);
        }
    }
}
