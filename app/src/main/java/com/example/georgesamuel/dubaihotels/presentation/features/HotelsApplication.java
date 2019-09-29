package com.example.georgesamuel.dubaihotels.presentation.features;

import android.app.Application;
import android.content.Context;

import com.example.georgesamuel.dubaihotels.usecases.network.ApplicationModule;
import com.example.georgesamuel.dubaihotels.usecases.network.DaggerApplicationComponent;
import com.example.georgesamuel.dubaihotels.usecases.network.DaggerNetworkComponent;
import com.example.georgesamuel.dubaihotels.usecases.network.NetworkComponent;
import com.example.georgesamuel.dubaihotels.usecases.network.NetworkModule;

public class HotelsApplication extends Application {

    private static Context context;
    private static NetworkComponent component;

    public void onCreate() {
        super.onCreate();
        HotelsApplication.context = getApplicationContext();

        component = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule())
                .applicationComponent(DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build()).build();
    }

    public static Context getAppContext() {
        return HotelsApplication.context;
    }

    public static NetworkComponent getNetComponent() {
        return component;
    }

}
