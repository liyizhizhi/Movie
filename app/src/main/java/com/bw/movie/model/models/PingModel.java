package com.bw.movie.model.models;

import com.bw.movie.model.bean.PingBean;
import com.bw.movie.model.http.ApiHttp;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IMainView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PingModel {
    public void PingModel(int movieId,int page,int count, final IMainView.CallBackPing callBackPing) {
        OkHttpUtils.getInstance().create(ApiHttp.class)
                .pingbean(movieId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PingBean pingBean) {
                        callBackPing.success(pingBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
