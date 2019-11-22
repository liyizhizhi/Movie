package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.movie.R;
import com.bw.movie.view.activity.MySettingActivity;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/10/10<p>
 * <p>更改时间：2019/10/10<p>
 */
public class MyFragment extends Fragment {

    private ImageView my_shezhi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.myfragment, container, false);
        my_shezhi = inflate.findViewById(R.id.my_shezhi);
        my_shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MySettingActivity.class));
            }
        });
        return inflate;
    }
}
