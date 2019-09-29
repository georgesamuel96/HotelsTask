package com.example.georgesamuel.dubaihotels.usecases.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.georgesamuel.dubaihotels.presentation.features.HotelsApplication;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient;

    public static Retrofit getClient() {

        String BASE_URL = "https://webkeyztest.getsandbox.com/";
        if (okHttpClient == null)
            initOkHttp();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public static boolean isOnline() {
        ConnectivityManager connMgr = (ConnectivityManager)
                HotelsApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    private static void initOkHttp() {
        int REQUEST_TIMEOUT = 60;
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(HotelsApplication.getAppContext().getCacheDir(), cacheSize);
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(interceptor);

         httpClient.addInterceptor(offlineInterceptor()).addNetworkInterceptor(onlineInterceptor()).cache(cache);
        okHttpClient = httpClient.build();

    }
    static Interceptor onlineInterceptor () {
       return chain -> {
           okhttp3.Response response = chain.proceed(chain.request());
           int maxAge = 60; // read from cache for 60 seconds even if there is internet connection
           return response.newBuilder()
                   .header("Cache-Control", "public, max-age=" + maxAge)
                   .removeHeader("Pragma")
                   .build();
       };

    }

    static Interceptor offlineInterceptor(){

        return chain -> {
            Request request = chain.request();
            if (!isOnline()) {
                int maxStale = 60 * 60 * 24 * 7; // Offline cache available for 7 days
                request = request.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build();
            }
            return chain.proceed(request);
        };
    }

}
