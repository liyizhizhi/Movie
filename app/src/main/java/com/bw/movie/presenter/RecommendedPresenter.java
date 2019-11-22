package com.bw.movie.presenter;

import com.bw.movie.model.bean.QvBean;
import com.bw.movie.model.bean.RecommendBean;
import com.bw.movie.model.models.QvModel;
import com.bw.movie.model.models.RecommendedModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class RecommendedPresenter<V extends IMainView.CallBackTuijian> extends BasePresenter<V> {
    public void RecommendedPresenter() {
        new RecommendedModel().RecommendedModel(new IMainView.CallBackTuijian() {
            @Override
            public void success(RecommendBean recommendBean) {
                getView().success(recommendBean);
            }
        });
    }
}
