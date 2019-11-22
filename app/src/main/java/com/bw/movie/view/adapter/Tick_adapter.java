package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.BuyBean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/21<p>
 * <p>更改时间：2019/11/21<p>
 */
public class Tick_adapter extends RecyclerView.Adapter {
    List<BuyBean.ResultBean> result;
    private Context context;

    public Tick_adapter(List<BuyBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.ticker_item, null);
        MyHolders holders = new MyHolders(inflate);
        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolders holders = (MyHolders) holder;
        holders.ticket_ting.setText(result.get(position).getScreeningHall());
        holders.ticket_shijian1.setText(result.get(position).getBeginTime() + "----");
        holders.ticket_shijian2.setText(result.get(position).getEndTime());
        holders.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hallId = result.get(position).getHallId();
                itemClickListener.onItemClick(hallId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyHolders extends RecyclerView.ViewHolder {

        private final TextView ticket_ting;
        private final TextView ticket_shijian1;
        private final TextView ticket_shijian2;

        public MyHolders(@NonNull View itemView) {
            super(itemView);
            ticket_ting = itemView.findViewById(R.id.ticket_ting);
            ticket_shijian1 = itemView.findViewById(R.id.ticket_shijian1);
            ticket_shijian2 = itemView.findViewById(R.id.ticket_shijian2);
        }
    }

    public OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int id);
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
