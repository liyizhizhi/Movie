package com.bw.movie.presenter;

import com.bw.movie.model.bean.FindCinemainfoBean;
import com.bw.movie.model.models.FindCinemainfoModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class FindCinemainfoPresenter<V extends IMainView.CallBackFindCinemainfo> extends BasePresenter<V> {
    public void FindCinemainfoPresenter(int cinemaId) {
        new FindCinemainfoModel().FindCinemainfoModel(cinemaId, new IMainView.CallBackFindCinemainfo() {
            @Override
            public void FindCinemainfosuccess(FindCinemainfoBean findCinemainfoBean) {
                getView().FindCinemainfosuccess(findCinemainfoBean);
            }
        });
    }
}
