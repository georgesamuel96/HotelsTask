package com.example.georgesamuel.dubaihotels.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.georgesamuel.dubaihotels.model.alertDialog.User;

public class AlertDialogAdapter extends ArrayAdapter<User> {

    public AlertDialogAdapter(Context context, int resource) {
        super(context, resource);
    }
}
