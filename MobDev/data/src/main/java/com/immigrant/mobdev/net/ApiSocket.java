package com.immigrant.mobdev.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.immigrant.mobdev.data.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andres on 31/03/2018.
 */

public class ApiSocket {

    private OkHttpClient getOkHttpInstance() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // Debug ONLY
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            builder.addInterceptor(interceptor);
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return builder.build();
    }

    private String getUrl() {
        return BuildConfig.SERVER_BASE;

    }

    private Gson generateGson() {
        return new GsonBuilder().create();
    }

    public SocketInterface generateConnector() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttpInstance())
                .addConverterFactory(GsonConverterFactory.create(generateGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(getUrl()).build();
        return retrofit.create(SocketInterface.class);
    }
}
