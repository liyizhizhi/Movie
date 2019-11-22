package com.bw.movie.presenter;

import com.bw.movie.view.interfaces.IBaseView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/11<p>
 * <p>更改时间：2019/11/11<p>
 */
public class BasePresenter  <T extends IBaseView> {
    private T view;

    public void ActachView(T baseview) {
        this.view = baseview;
    }
    public void DatachView() {
        this.view = null;
    }

    public T getView() {
        return view;
    }
}

