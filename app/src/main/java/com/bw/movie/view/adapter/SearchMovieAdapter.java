package com.bw.movie.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.model.bean.SearchBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/21<p>
 * <p>更改时间：2019/11/21<p>
 */
public class SearchMovieAdapter extends RecyclerView.Adapter {
    private List<SearchBean.ResultBean> list;
    private Context context;

    public SearchMovieAdapter(List<SearchBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.search_item, null);
        Handel handel = new Handel(inflate);
        return handel;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Handel handel = (Handel) holder;
        handel.tv_name.setText(list.get(position).getName());
        handel.tv_title.setText(list.get(position).getStarring());
        String imageUrl = list.get(position).getImageUrl();
        Uri parse = Uri.parse(imageUrl);
        handel.ivImage.setImageURI(parse);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Handel extends RecyclerView.ViewHolder {

        private final SimpleDraweeView ivImage;
        private final TextView tv_name;
        private final TextView tv_title;

        public Handel(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
