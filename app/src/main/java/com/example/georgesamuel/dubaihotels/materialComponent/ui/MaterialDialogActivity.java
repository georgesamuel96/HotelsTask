package com.example.georgesamuel.dubaihotels.materialComponent.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.materialComponent.model.User;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MaterialDialogActivity extends AppCompatActivity {

    @BindView(R.id.alertDialog)
    AppCompatButton alertDialog;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.simpleAlertDialog)
    AppCompatButton simpleAlertDialog;
    @BindView(R.id.confirmationAlertDialog)
    AppCompatButton confirmationAlertDialog;
    private ListAdapter adapter;
    private List<User> userList = new ArrayList<>();
    private static final String TAG = MaterialDialogActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_dialog);
        ButterKnife.bind(this);

        initToolbar();
        initItems();
    }

    @OnClick(R.id.alertDialog)
    public void onAlertDialogClicked() {
        new MaterialAlertDialogBuilder(MaterialDialogActivity.this)
                .setTitle(getString(R.string.title))
                .setMessage(getString(R.string.message))
                .setPositiveButton(getString(R.string.ok), null)
                .show();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.alert_dialog));
    }

    @OnClick(R.id.simpleAlertDialog)
    public void onSimpleAlertClicked() {
        new MaterialAlertDialogBuilder(MaterialDialogActivity.this, R.style.MaterialAlertDialogTheme)
                .setTitle(getString(R.string.title))
                .setAdapter(adapter, (dialogInterface, position) ->
                        Toast.makeText(MaterialDialogActivity.this,
                                "Clicked " + userList.get(position).getUserName(),
                                Toast.LENGTH_SHORT).show())
                .show();
    }

    private void initItems() {
        userList.add(new User(R.mipmap.ic_launcher, "George Samuel"));
        userList.add(new User(R.mipmap.ic_launcher, "Al Shaymaa"));
        adapter = new ArrayAdapter<User>(
                this,
                R.layout.user_alert_dialog_item,
                R.id.name,
                userList
        ) {
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ImageView img = v.findViewById(R.id.image);
                img.setImageResource(userList.get(position).getUserImage());
                TextView tv = v.findViewById(R.id.name);
                tv.setText(userList.get(position).getUserName());
                return v;
            }
        };

    }

    @OnClick(R.id.confirmationAlertDialog)
    public void onConfirmationAlertClicked() {
        String[] choices = {"Choice1", "Choice2"};
        boolean[] checked = {false, true};
        new MaterialAlertDialogBuilder(MaterialDialogActivity.this, R.style.MaterialAlertDialogTheme)
                .setTitle(getString(R.string.title))
                .setMultiChoiceItems(choices, checked, (dialogInterface, position, isCheckd) -> {
                    checked[position] = isCheckd;
                })
                .setPositiveButton(getString(R.string.ok), (dialogInterface, position) -> {
                    for(int i = 0; i < 2; i++){
                        Log.d(TAG, "onConfirmationAlertClicked: " + checked[i]);
                    }
                })
                .setNegativeButton(getString(R.string.cancel), null)
                .show();
    }
}
