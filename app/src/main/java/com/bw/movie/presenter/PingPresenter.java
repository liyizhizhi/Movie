package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.model.bean.PingBean;
import com.bw.movie.model.models.PingModel;
import com.bw.movie.view.interfaces.IMainView;


public class PingPresenter<V extends IMainView.CallBackPing> extends BasePresenter<V> {
    public void PingPresenter(int movieId) {
        new PingModel().PingModel(movieId,1,5, new IMainView.CallBackPing() {
            @Override
            public void success(PingBean pingBean) {
                getView().success(pingBean);
                Log.e("TFG", "success: " + pingBean);
            }
        });
    }
}
