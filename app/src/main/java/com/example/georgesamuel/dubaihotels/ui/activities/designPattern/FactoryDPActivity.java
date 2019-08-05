package com.example.georgesamuel.dubaihotels.ui.activities.designPattern;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.model.designPattern.Wheel;
import com.example.georgesamuel.dubaihotels.model.designPattern.WheelFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FactoryDPActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    AppCompatButton btn;
    @BindView(R.id.tv)
    TextView tv;
    private boolean isCar = true;
    private Wheel carWheel, bikeWheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_dp);
        ButterKnife.bind(this);

        carWheel = WheelFactory.getWheel("Carwheel", 15, 215);
        bikeWheel = WheelFactory.getWheel("Bikewheel", 18, 245);

        getCar();
    }

    @OnClick(R.id.btn)
    public void onBtnClicked() {
        if(isCar){
           getBike();
        }
        else{
           getCar();
        }
    }

    private void getCar(){
        btn.setText("Bike");
        isCar = true;
        tv.setText("Car wheel\n" + bikeWheel.toString());
    }

    private void getBike(){
        btn.setText("Car");
        isCar = false;
        tv.setText("Bike wheel\n" + bikeWheel.toString());
    }
}
