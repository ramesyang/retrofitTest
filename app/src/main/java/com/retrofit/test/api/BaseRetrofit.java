package com.retrofit.test.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rames on 2016/4/25.
 * yangju1@staff.weibo.com
 */
public class BaseRetrofit {
    private static final String ENDPOINT = "http://ip.taobao.com/";

    private BaseRetrofit(){ }

    public static Retrofit getInstance(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(40000, TimeUnit.SECONDS);
        httpClient.addInterceptor(logging);
        // 以上为打印log的配置

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        return retrofit;
    }
}
