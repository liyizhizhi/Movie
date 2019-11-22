package com.bw.movie.presenter;

import com.bw.movie.model.bean.ErJiBean;
import com.bw.movie.model.bean.QvBean;
import com.bw.movie.model.models.EmailModel;
import com.bw.movie.model.models.ErJiModel;
import com.bw.movie.model.models.QvModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class ErJiPresenter<V extends IMainView.CallBackErji> extends BasePresenter<V> {
    public void ErJiPresenter(int regionId) {
       new ErJiModel().ErJiModel(regionId, new IMainView.CallBackErji() {
           @Override
           public void success(ErJiBean erJiBean) {
               getView().success(erJiBean);
           }
       });
    }
}
