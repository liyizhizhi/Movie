package com.bw.movie.presenter;

import com.bw.movie.model.bean.FindCommentBean;
import com.bw.movie.model.models.FindCinemainfoModel;
import com.bw.movie.model.models.FindCommendModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class FindCommentPresenter<V extends IMainView.CallBackFindComment> extends BasePresenter<V> {
    public void FindCommentPresenter(int cinemaId) {
        new FindCommendModel().FindCommendModel(cinemaId, 1, 10, new IMainView.CallBackFindComment() {
            @Override
            public void FindFindCommentsuccess(FindCommentBean findCommentBean) {
                getView().FindFindCommentsuccess(findCommentBean);
            }
        });
    }
}
