package com.bw.movie.presenter;

import com.bw.movie.model.bean.EamalBean;
import com.bw.movie.model.models.EmailModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/12<p>
 * <p>更改时间：2019/11/12<p>
 */
public class EmailPresenter<V extends IMainView.CallBackEmail> extends BasePresenter<V> {
    public void EmailPresenter( String email) {
        new EmailModel().EmailModel(email, new IMainView.CallBackEmail() {
            @Override
            public void success(EamalBean eamalBean) {
                getView().success(eamalBean);
            }
        });
    }
}
