package com.bw.movie.presenter;

import com.bw.movie.model.bean.Timebean;
import com.bw.movie.model.models.TimeModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class TimePresenter<V extends IMainView.CallBackTime> extends BasePresenter<V> {
    public void TimePresenter() {
        new TimeModel().TimeModel(new IMainView.CallBackTime() {
            @Override
            public void Timesuccess(Timebean timebean) {
                getView().Timesuccess(timebean);
            }
        });
    }
}
