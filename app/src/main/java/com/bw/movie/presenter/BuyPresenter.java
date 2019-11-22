package com.bw.movie.presenter;

import com.bw.movie.model.bean.BuyBean;
import com.bw.movie.model.models.BuyModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/21<p>
 * <p>更改时间：2019/11/21<p>
 */
public class BuyPresenter<V extends IMainView.CallBackBuy> extends BasePresenter<V> {
    public void BuyPresenter(int cinemaId, int movieId) {
        new BuyModel().BuyModel(cinemaId, movieId, new IMainView.CallBackBuy() {
            @Override
            public void buysuccess(BuyBean buyBean) {
                getView().buysuccess(buyBean);
            }
        });
    }
}
