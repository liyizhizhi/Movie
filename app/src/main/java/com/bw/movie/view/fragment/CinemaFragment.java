package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.view.fragment.cinemafragment.HaidianFragment;
import com.bw.movie.view.fragment.cinemafragment.NearbyFragment;
import com.bw.movie.view.fragment.cinemafragment.RecommendFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/10/10<p>
 * <p>更改时间：2019/10/10<p>
 */
public class CinemaFragment extends Fragment {

    private ArrayList<Fragment> list;
    private ViewPager cinema_vp;
    private TabLayout cinema_tablayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.cinemafragment, container, false);
        cinema_vp = inflate.findViewById(R.id.cinema_vp);
        cinema_tablayout = inflate.findViewById(R.id.cinema_tablayout);
        list = new ArrayList<>();
        list.add(new RecommendFragment());
        list.add(new NearbyFragment());
        list.add(new HaidianFragment());

        cinema_vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        cinema_tablayout.setupWithViewPager(cinema_vp);
        cinema_tablayout.getTabAt(0).setText("推荐影院");
        cinema_tablayout.getTabAt(1).setText("附近影院");
        cinema_tablayout.getTabAt(2).setText("海淀区▼");

        return inflate;
    }


}
