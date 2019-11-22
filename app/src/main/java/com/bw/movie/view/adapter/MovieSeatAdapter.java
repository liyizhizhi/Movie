package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.ZuoBean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/22<p>
 * <p>更改时间：2019/11/22<p>
 */
public class MovieSeatAdapter extends RecyclerView.Adapter {
    List<ZuoBean.ResultBean> list;
    private Context context;

    public MovieSeatAdapter(List<ZuoBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.set_item, null);
        MyHolders holders=new MyHolders(inflate);
        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolders extends RecyclerView.ViewHolder {

        private final CheckBox che_box;

        public MyHolders(@NonNull View itemView) {
            super(itemView);
            che_box = itemView.findViewById(R.id.che_box);

        }
    }
}
