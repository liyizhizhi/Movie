package com.bw.movie.presenter;

import com.bw.movie.model.bean.RegisterBean;
import com.bw.movie.model.models.RegisterlModel;
import com.bw.movie.view.interfaces.IMainView;

import java.util.HashMap;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/12<p>
 * <p>更改时间：2019/11/12<p>
 */
public class RegisterPresenter<V extends IMainView.CallBackRegister> extends BasePresenter<V> {
    public void RegisterPresenter( HashMap<String, Object> map) {
        new RegisterlModel().RegisterlModel(map, new IMainView.CallBackRegister() {
            @Override
            public void success(RegisterBean registerBean) {
                getView().success(registerBean);
            }
        });
    }
}
