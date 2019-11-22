package com.bw.movie.model.models;

import com.bw.movie.model.bean.FindCommentBean;
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
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class FindCommendModel {
    public void FindCommendModel(int cinemaId, int page, int count, final IMainView.CallBackFindComment callBackFindComment) {
        OkHttpUtils.getInstance().create(ApiHttp.class)
                .findcommentbean(cinemaId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindCommentBean findCommentBean) {
                        callBackFindComment.FindFindCommentsuccess(findCommentBean);
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
