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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bw.movie.R;
import com.bw.movie.model.bean.FindCommentBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class Info_EvaluationAdapter  extends RecyclerView.Adapter {
    private List<FindCommentBean.ResultBean> result;
    private Context context;

    public Info_EvaluationAdapter(List<FindCommentBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_find_all_cinema_comment, viewGroup,false);
        Viewholder1 viewholder1=new Viewholder1(inflate);
        return viewholder1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Viewholder1 viewholder1= (Viewholder1) viewHolder;
        Glide.with(context).load(result.get(i).getCommentHeadPic()).transform(new CircleCrop()).into(viewholder1.iv_commentHeadPic);
        viewholder1.tv_commentContent.setText(result.get(i).getCommentContent());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(result.get(i).getCommentTime());
        viewholder1.tv_commentTime.setText(format);
        viewholder1.tv_commentUserName.setText(result.get(i).getCommentUserName());
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {

        private final ImageView iv_commentHeadPic;
        private final TextView tv_commentUserName;
        private final TextView tv_commentTime;
        private final TextView tv_commentContent;

        public Viewholder1(@NonNull View itemView) {
            super(itemView);
            iv_commentHeadPic = itemView.findViewById(R.id.iv_commentHeadPic);
            tv_commentUserName = itemView.findViewById(R.id.tv_commentUserName);
            tv_commentTime = itemView.findViewById(R.id.tv_commentTime);
            tv_commentContent = itemView.findViewById(R.id.tv_commentContent);
        }
    }
}

