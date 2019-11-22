package com.bw.movie.presenter;

import com.bw.movie.model.bean.AttentionBean;
import com.bw.movie.model.models.AttCommentModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class AttCommentPresenter<V extends IMainView.CallBackAttention> extends BasePresenter<V> {
    public void AttCommentPresenter(int userId, String sessionId, int movieId,
                                    String commentContent, double score) {
        new AttCommentModel().AttCommentModel(userId, sessionId, movieId, commentContent, score, new IMainView.CallBackAttention() {
            @Override
            public void Attentionsuccess(AttentionBean attentionBean) {
                getView().Attentionsuccess(attentionBean);
            }
        });
    }
}
