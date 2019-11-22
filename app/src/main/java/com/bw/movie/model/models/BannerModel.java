package com.bw.movie.model.models;

import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.DoorBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.LodingBean;
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
 * <p>创建时间：2019/11/12<p>
 * <p>更改时间：2019/11/12<p>
 */
public class BannerModel {
    public void BannerModel(final IMainView.CallBackBanner callBackBanner) {
        OkHttpUtils.getInstance().create(ApiHttp.class)
                .bannerbean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        callBackBanner.success(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        OkHttpUtils.getInstance().create(ApiHttp.class)
                .hotmoviebean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotMovieBean hotMovieBean) {
                        callBackBanner.hotsuccess(hotMovieBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        OkHttpUtils.getInstance().create(ApiHttp.class)
                .lodingbean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LodingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LodingBean lodingBean) {
                        callBackBanner.logingsuccess(lodingBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        OkHttpUtils.getInstance().create(ApiHttp.class)
                .doorbean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DoorBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DoorBean doorBean) {
                        callBackBanner.doorsuccess(doorBean);
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
