package com.bw.movie.presenter;

import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.DoorBean;
import com.bw.movie.model.bean.HotMovieBean;
import com.bw.movie.model.bean.LodingBean;
import com.bw.movie.model.models.BannerModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/12<p>
 * <p>更改时间：2019/11/12<p>
 */
public class BannerPresenter<V extends IMainView.CallBackBanner> extends BasePresenter<V> {
    public void BannerPresenter() {
        new BannerModel().BannerModel(new IMainView.CallBackBanner() {
            @Override
            public void success(BannerBean bannerBean) {
                getView().success(bannerBean);
            }

            @Override
            public void hotsuccess(HotMovieBean hotMovieBean) {
                getView().hotsuccess(hotMovieBean);
            }

            @Override
            public void logingsuccess(LodingBean lodingBean) {
                getView().logingsuccess(lodingBean);
            }
            @Override
            public void doorsuccess(DoorBean doorBean) {
                getView().doorsuccess(doorBean);
            }


        });
    }
}
