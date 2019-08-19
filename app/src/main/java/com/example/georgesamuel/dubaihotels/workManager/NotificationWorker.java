package com.example.georgesamuel.dubaihotels.workManager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class NotificationWorker extends Worker {
    private static final String WORK_RESULT = "work_result";

    public NotificationWorker(Context context, WorkerParameters workerParameters){
        super(context, workerParameters);
    }

    @NonNull
    @Override
    public Result doWork() {
        return null;
    }
}
