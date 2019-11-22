package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.ErJiBean;
import com.bw.movie.model.bean.QvBean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class ErJiAdapter extends RecyclerView.Adapter {
    List<ErJiBean.ResultBean> list;
    private Context context;

    public ErJiAdapter(List<ErJiBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.erjiyouadapter, null);
        MyHolder holder = new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyHolder holder1 = (MyHolder) holder;
        holder1.near_recyclerright_text.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final TextView near_recyclerright_text;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            near_recyclerright_text = itemView.findViewById(R.id.near_recyclerright_text);
        }
    }


}
