package com.bw.movie.model.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p>文件描述：<p>
 * <p>作者：黎怡志<p>
 * <p>创建时间：2019/11/11<p>
 * <p>更改时间：2019/11/11<p>
 */
public class OkHttpUtils {
    private static final OkHttpUtils getInstance = new OkHttpUtils();
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;

    public static OkHttpUtils getInstance() {
        return getInstance;
    }

    private OkHttpUtils() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(50,TimeUnit.SECONDS)
                .writeTimeout(50,TimeUnit.SECONDS)
                .connectTimeout(50, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(InterJie.BASE_JIE)
                .build();

    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}

