package com.bw.movie.presenter;

import com.bw.movie.model.bean.QvBean;
import com.bw.movie.model.bean.XiangBean;
import com.bw.movie.model.models.QvModel;
import com.bw.movie.model.models.XiangModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class XiangPresenter<V extends IMainView.CallBackXiang> extends BasePresenter<V> {
    public void XiangPresenter(int movieId) {
        new XiangModel().XiangModel(movieId, new IMainView.CallBackXiang() {
            @Override
            public void success(XiangBean xiangBean) {
                getView().success(xiangBean);
            }
        });
    }
}
