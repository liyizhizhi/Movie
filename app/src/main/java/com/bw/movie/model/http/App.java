package com.bw.movie.model.http;

import android.app.Application;

import androidx.multidex.MultiDex;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.greenrobot.eventbus.EventBus;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/13<p>
 * <p>更改时间：2019/11/13<p>
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        MultiDex.install(this);
    }
}
