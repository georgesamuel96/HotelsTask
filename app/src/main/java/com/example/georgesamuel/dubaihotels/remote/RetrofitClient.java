package com.example.georgesamuel.dubaihotels.remote;

import android.content.Context;

import com.example.georgesamuel.dubaihotels.util.CheckNetwork;
import com.example.georgesamuel.dubaihotels.util.Constants;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.georgesamuel.dubaihotels.util.Constants.HEADER_CACHE_CONTROL;
import static com.example.georgesamuel.dubaihotels.util.Constants.HEADER_PRAGMA;

public class RetrofitClient {

    private static final String BASE_URL = "https://webkeyztest.getsandbox.com";
    private static ClientAPI clientAPI = null;
    private static final long cacheSize = 5 * 1024 * 1024;

    private RetrofitClient(){

    }

    public static ClientAPI getInstance(Context context){
        if(clientAPI == null){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .cache(new Cache(new File(context.getCacheDir(), Constants.CACHE_FILE_NAME), cacheSize))
                    .addInterceptor(loggingInterceptor)
                    .addNetworkInterceptor(networkInterceptor())
                    .addInterceptor(offlineInterceptor(context))
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            clientAPI = retrofit.create(ClientAPI.class);
        }
        return clientAPI;
    }

    private static Interceptor networkInterceptor(){
        return chain -> {

            Response response = chain.proceed(chain.request());

            CacheControl cacheControl = new CacheControl.Builder()
                    .maxAge(5, TimeUnit.SECONDS)
                    .build();

            return response.newBuilder()
                    .removeHeader(HEADER_PRAGMA)
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                    .build();
        };
    }

    private static Interceptor offlineInterceptor(Context context) {
        return chain -> {
            Request request = chain.request();

            if (!CheckNetwork.hasNetwork(context)) {
                CacheControl cacheControl = new CacheControl.Builder()
                        .maxStale(7, TimeUnit.DAYS)
                        .build();

                request = request.newBuilder()
                        .removeHeader(HEADER_PRAGMA)
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .cacheControl(cacheControl)
                        .build();
            }

            return chain.proceed(request);
        };
    }
}
