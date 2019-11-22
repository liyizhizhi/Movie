package com.bw.movie.model.models;

import android.util.Log;

import com.bw.movie.model.bean.ErJiBean;
import com.bw.movie.model.bean.QvBean;
import com.bw.movie.model.http.ApiHttp;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IMainView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class ErJiModel {
    public static final String TAG="ErJiModel";
    public void ErJiModel(int regionId,final IMainView.CallBackErji callBackErji) {
        Log.d(TAG, "ErJiModel: "+regionId);
        OkHttpUtils.getInstance().create(ApiHttp.class)
                .erjibean(regionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ErJiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ErJiBean erJiBean) {
                        Log.d(TAG, "onNext: "+erJiBean.getMessage());
                        callBackErji.success(erJiBean);
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
