package com.example.georgesamuel.dubaihotels.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckNetwork {

    private static boolean connected = false;

    public static boolean hasNetwork(Context context){

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        connected = (activeNetwork != null && activeNetwork.isConnectedOrConnecting());

        return connected;
    }
}
