package com.bw.movie.presenter;

import com.bw.movie.model.bean.ZuoBean;
import com.bw.movie.model.models.ZuoModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/21<p>
 * <p>更改时间：2019/11/21<p>
 */
public class ZuoPresenter<V extends IMainView.CallBackZuo> extends BasePresenter<V> {
    public void ZuoPresenter(int hallId) {
        new ZuoModel().ZuoModel(hallId, new IMainView.CallBackZuo() {
            @Override
            public void zuosuccess(ZuoBean zuoBean) {
                getView().zuosuccess(zuoBean);
            }
        });
    }
}
