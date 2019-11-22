package com.bw.movie.model.models;

import com.bw.movie.model.bean.SearchBean;
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
 * <p>创建时间：2019/11/21<p>
 * <p>更改时间：2019/11/21<p>
 */
public class SearchModel {
    public void SearchModel(String keyword, int page, int count, final IMainView.CallBackSearch callBackSearch) {
        OkHttpUtils.getInstance().create(ApiHttp.class)
                .searchbean(keyword, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchBean searchBean) {
                        callBackSearch.searchsuccess(searchBean);
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
