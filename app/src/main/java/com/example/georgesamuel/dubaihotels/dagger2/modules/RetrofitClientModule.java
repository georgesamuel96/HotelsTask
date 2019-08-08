package com.example.georgesamuel.dubaihotels.dagger2.modules;

import android.content.Context;

import com.example.georgesamuel.dubaihotels.dagger2.ClientAPI;
import com.example.georgesamuel.dubaihotels.util.CheckNetwork;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitClientModule {

    private static final String BASE_URL = "https://webkeyztest.getsandbox.com";
    private static final long cacheSize = 5 * 1024 * 1024;
    private static final String CACHE_FILE_NAME = "someIdentifier";
    private static final String HEADER_PRAGMA = "Pragma";
    private static final String HEADER_CACHE_CONTROL = "Cache-Control";
    Context context;

    @Singleton
    @Provides
    public ClientAPI provideRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                //.cache(new Cache(new File(context.getCacheDir(), CACHE_FILE_NAME), cacheSize))
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(networkInterceptor())
                //.addInterceptor(offlineInterceptor(context))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ClientAPI.class);
    }


    Interceptor networkInterceptor() {
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

    private Interceptor offlineInterceptor(Context context) {
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
