package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.QvBean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class QvAdapter extends RecyclerView.Adapter {
    List<QvBean.ResultBean> list;
    private Context context;

    public QvAdapter(List<QvBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.qvadapter, null);
        MyHolder holder = new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyHolder holder1 = (MyHolder) holder;
        holder1.near_recyclerleft_text.setText(list.get(position).getRegionName());

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int regionId = list.get(position).getRegionId();
                mOnclicklister.onclick(regionId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final TextView near_recyclerleft_text;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            near_recyclerleft_text = itemView.findViewById(R.id.near_recyclerleft_text);
        }
    }

    private mOnclicklister mOnclicklister;

    public  void QvAdapter(QvAdapter.mOnclicklister mOnclicklister) {
        this.mOnclicklister = mOnclicklister;
    }

  public   interface mOnclicklister {
        void onclick(int regionId);
    }
}
