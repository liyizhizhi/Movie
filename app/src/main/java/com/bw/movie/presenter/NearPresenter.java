package com.bw.movie.presenter;

import com.bw.movie.model.bean.NearBean;
import com.bw.movie.model.bean.RecommendBean;
import com.bw.movie.model.models.NearModel;
import com.bw.movie.model.models.RecommendedModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class NearPresenter<V extends IMainView.CallBackNear> extends BasePresenter<V> {
    public void NearPresenter() {
        new NearModel().NearModel(new IMainView.CallBackNear() {
            @Override
            public void success(NearBean nearBean) {
                getView().success(nearBean);
            }
        });
    }
}
