package com.bw.movie.model.models;

import com.bw.movie.model.bean.VersionBean;
import com.bw.movie.model.http.ApiHttp;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IMainView;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/12<p>
 * <p>更改时间：2019/11/12<p>
 */
public class VersionModel {
    private HashMap<String, Object> map1;

    public void VersionModel(String ak, final IMainView.CallBackVersion callBackVersion) {
        OkHttpUtils.getInstance().create(ApiHttp.class)
                .version(map1, ak)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VersionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VersionBean versionBean) {
                        callBackVersion.success(versionBean);
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
