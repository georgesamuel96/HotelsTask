package com.example.georgesamuel.dubaihotels.presentation.features;

import android.app.Application;
import android.content.Context;

public class HotelsApplication extends Application {


    private static Context context;

    public void onCreate() {
        super.onCreate();
        HotelsApplication.context = getApplicationContext();

    }

    public static Context getAppContext() {
        return HotelsApplication.context;
    }

}
