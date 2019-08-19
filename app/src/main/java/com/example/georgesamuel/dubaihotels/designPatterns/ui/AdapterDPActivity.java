package com.example.georgesamuel.dubaihotels.designPatterns.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.designPatterns.model.AudioPlayer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdapterDPActivity extends AppCompatActivity {

    @BindView(R.id.et_type)
    EditText etType;
    @BindView(R.id.btn_play)
    AppCompatButton btnPlay;
    @BindView(R.id.tv_type)
    TextView tvType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_dp);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_play)
    public void onBtnPlayClicked() {
        /*
            Format is : MP3 || MP || VLC
         */
        final String type = etType.getText().toString().trim();
        AudioPlayer audioPlayer = new AudioPlayer();
        tvType.setText(audioPlayer.play(type));
    }
}
