package com.bw.movie.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bw.movie.R;
import com.bw.movie.model.bean.PingBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/19<p>
 * <p>更改时间：2019/11/19<p>
 */
public class FilmdAdapter extends RecyclerView.Adapter {
    List<PingBean.ResultBean> result;
    private Context context;

    public FilmdAdapter(List<PingBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.film_item, null);
        MyHolders holders = new MyHolders(inflate);
        return holders;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(result!=null){
        MyHolders holders = (MyHolders) holder;
        Glide.with(context).load(result.get(position).getCommentHeadPic()).transform(new CircleCrop()).into(holders.filmreview_head);
        holders.filmreview_name.setText(result.get(position).getCommentUserName());
        holders.filmreview_content.setText(result.get(position).getCommentContent());
        holders.filmreview_score.setText(result.get(position).getScore() + "分");
        holders.filmreview_replynum.setText("等" + result.get(position).getReplyNum() + "人进行了回复");
        float score = (float) result.get(position).getScore();
        holders.filmreview_rating.setRating(score);

        LayerDrawable progressDrawable = (LayerDrawable) holders.filmreview_rating.getProgressDrawable();
        progressDrawable.getDrawable(2).setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        Glide.with(context).load(result.get(position).getReplyHeadPic()).into(holders.filmreview_header);
        //日期z
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long commentTime = result.get(position).getCommentTime();
        String format = simpleDateFormat.format(commentTime);
        holders.filmreview_time.setText(format);
}
    }

    @Override
    public int getItemCount() {
        Log.d("PLPL", "getItemCount: "+result);
        return result.size();
    }

    class MyHolders extends RecyclerView.ViewHolder {
        private final ImageView filmreview_head;
        private final ImageView filmreview_header;
        private final ImageView dianzan;
        private final TextView filmreview_name;
        private final RatingBar filmreview_rating;
        private final TextView filmreview_time;
        private final TextView filmreview_score;
        private final TextView filmreview_content;
        private final TextView filmreview_replynum;

        public MyHolders(@NonNull View itemView) {
            super(itemView);

            filmreview_head = itemView.findViewById(R.id.filmreview_head);
            filmreview_name = itemView.findViewById(R.id.filmreview_name);
            filmreview_rating = itemView.findViewById(R.id.filmreview_rating);
            filmreview_time = itemView.findViewById(R.id.filmreview_time);
            filmreview_score = itemView.findViewById(R.id.filmreview_score);
            filmreview_content = itemView.findViewById(R.id.filmreview_content);
            filmreview_header = itemView.findViewById(R.id.filmreview_header);
            filmreview_replynum = itemView.findViewById(R.id.filmreview_replynum);
            dianzan = itemView.findViewById(R.id.dianzan);

        }
    }
}
