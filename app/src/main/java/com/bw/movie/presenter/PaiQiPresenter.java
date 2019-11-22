package com.bw.movie.presenter;

import com.bw.movie.model.bean.PaiQiBean;
import com.bw.movie.model.models.PaiQiModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/21<p>
 * <p>更改时间：2019/11/21<p>
 */
public class PaiQiPresenter<V extends IMainView.CallBackPaiqi> extends BasePresenter<V> {
    public void PaiQiPresenter(int cinemaId) {
        new PaiQiModel().PaiQiModel(cinemaId, 1, 10, new IMainView.CallBackPaiqi() {
            @Override
            public void Paiqisuccess(PaiQiBean qiBean) {
                getView().Paiqisuccess(qiBean);
            }
        });
    }
}
