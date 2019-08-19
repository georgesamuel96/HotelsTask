package com.example.georgesamuel.dubaihotels.workManager.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.workManager.NotificationWorker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WorkManagerActivity extends AppCompatActivity {
    public static final String MESSAGE_STATUS = "message_status";
    @BindView(R.id.textView)
    TextView tvStatus;
    @BindView(R.id.button)
    Button button;
    private WorkManager mWorkManager;
    private OneTimeWorkRequest mRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);
        ButterKnife.bind(this);

        mWorkManager = WorkManager.getInstance();
        mRequest = new OneTimeWorkRequest.Builder(NotificationWorker.class).build();
        mWorkManager.getWorkInfoByIdLiveData(mRequest.getId()).observe(this, workInfo -> {
            if (workInfo != null) {
                WorkInfo.State state = workInfo.getState();
                tvStatus.append(state.toString() + "\n");

            }
        });
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        mWorkManager.enqueue(mRequest);
    }
}
