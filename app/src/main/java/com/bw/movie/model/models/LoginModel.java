package com.bw.movie.model.models;
import com.bw.movie.model.bean.Loginbean;
import com.bw.movie.model.http.ApiHttp;
import com.bw.movie.model.http.OkHttpUtils;
import com.bw.movie.view.interfaces.IMainView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/9/29<p>
 * <p>更改时间：2019/9/29<p>
 */
public class LoginModel {
    public void LoginModel(String email, String pass, final IMainView.CallBackData callBackData) {
        OkHttpUtils.getInstance().create(ApiHttp.class)
                .loginbean(email, pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Loginbean>() {
                    @Override
                    public void accept(Loginbean loginbean) throws Exception {
                        callBackData.success(loginbean);
                    }
                });
    }
}
