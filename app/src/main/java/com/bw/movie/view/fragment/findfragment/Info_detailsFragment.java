package com.bw.movie.view.fragment.findfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.movie.R;
import com.bw.movie.model.bean.FindCinemainfoBean;
import com.bw.movie.presenter.FindCinemainfoPresenter;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class Info_detailsFragment extends Fragment implements IMainView.CallBackFindCinemainfo {

    private TextView info_address;
    private TextView info_phone;
    private TextView info_vehicleRoute;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.info_details, null);
        info_address = inflate.findViewById(R.id.info_address);
        info_phone = inflate.findViewById(R.id.info_phone);
        info_vehicleRoute = inflate.findViewById(R.id.info_vehicleRoute);


        Intent intent = getActivity().getIntent();
        int cinemaId = intent.getIntExtra("cinemaId", 0);

        FindCinemainfoPresenter presenter=new FindCinemainfoPresenter();
        presenter.ActachView(this);
        presenter.FindCinemainfoPresenter(cinemaId);
        return inflate;
    }

    @Override
    public void FindCinemainfosuccess(FindCinemainfoBean findCinemainfoBean) {
        String address = findCinemainfoBean.getResult().getAddress();
        String phone = findCinemainfoBean.getResult().getPhone();
        String vehicleRoute = findCinemainfoBean.getResult().getVehicleRoute();

        info_address.setText(address);
        info_phone.setText(phone);
        info_vehicleRoute.setText(vehicleRoute);
    }
}
