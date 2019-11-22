package com.bw.movie.presenter;

import com.bw.movie.model.bean.VersionBean;
import com.bw.movie.model.models.VersionModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/12<p>
 * <p>更改时间：2019/11/12<p>
 */
public class VersionPresenter<V extends IMainView.CallBackVersion> extends BasePresenter<V> {
    public void VersionPresenter() {
        new VersionModel().VersionModel("0110010010000", new IMainView.CallBackVersion() {
            @Override
            public void success(VersionBean versionBean) {
                getView().success(versionBean);
            }
        });
    }
}
