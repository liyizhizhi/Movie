package com.bw.movie.presenter;


import com.bw.movie.model.bean.Loginbean;
import com.bw.movie.model.models.LoginModel;
import com.bw.movie.view.interfaces.IMainView;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/9/29<p>
 * <p>更改时间：2019/9/29<p>
 */
public class LoginPresenter<V extends IMainView.CallBackData> extends BasePresenter<V> {
    public void LoginPresenter(String email, String pass) {
        new LoginModel().LoginModel(email, pass, new IMainView.CallBackData() {
            @Override
            public void success(Loginbean loginbean) {
                getView().success(loginbean);
            }
        });
    }
}
