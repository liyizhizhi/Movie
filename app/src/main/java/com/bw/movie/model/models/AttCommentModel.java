package com.bw.movie.model.models;

import com.bw.movie.model.bean.AttentionBean;
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
public class AttCommentModel {
    public void AttCommentModel(int userId, String sessionId, int movieId,
                                String commentContent, double score, final IMainView.CallBackAttention callBackAttention) {
        OkHttpUtils.getInstance().create(ApiHttp.class).attentbean(userId, sessionId, movieId, commentContent, score)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AttentionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AttentionBean attentionBean) {
                        callBackAttention.Attentionsuccess(attentionBean);
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
