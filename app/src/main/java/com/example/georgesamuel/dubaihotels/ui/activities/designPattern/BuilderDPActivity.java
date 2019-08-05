package com.example.georgesamuel.dubaihotels.ui.activities.designPattern;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.model.designPattern.User;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuilderDPActivity extends AppCompatActivity {

    @BindView(R.id.et_fName)
    EditText etFName;
    @BindView(R.id.et_lName)
    EditText etLName;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.btnOK)
    AppCompatButton btnOK;
    @BindView(R.id.tvFirstName)
    TextView tvFirstName;
    @BindView(R.id.tvLastName)
    TextView tvLastName;
    @BindView(R.id.tvAge)
    TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder_dp);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnOK)
    public void onBtnClicked() {
        final String fName = etFName.getText().toString().trim();
        final String lName = etLName.getText().toString().trim();
        final String age = etAge.getText().toString().trim();

        try{
            User user  = new User.Builder()
                    .setFirstName(fName)
                    .setLastName(lName)
                    .setAge(age)
                    .create();
            tvFirstName.setText(user.getFirstName());
            tvLastName.setText(user.getLastName());
            tvAge.setText(user.getAge());
        }
        catch (Exception e){
            Toast.makeText(BuilderDPActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }



    }
}
