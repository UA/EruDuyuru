package com.ua.eruduyuru.utils;

import com.github.florent37.retrojsoup.RetroJsoup;

import okhttp3.OkHttpClient;

public class ServiceGenerator {

    private static OkHttpClient httpClient = new OkHttpClient();
    public static <S> S createService(Class<S> serviceClass, String url) {
        return new RetroJsoup.Builder()
                .client(httpClient)
                .url(url)
                .build().create(serviceClass);
    }

}
