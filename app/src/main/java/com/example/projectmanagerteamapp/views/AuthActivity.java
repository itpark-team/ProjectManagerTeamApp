package com.example.projectmanagerteamapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectmanagerteamapp.R;
import com.example.projectmanagerteamapp.controlllers.ControllerAuthActivity;
import com.example.projectmanagerteamapp.models.DataStorage;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        ControllerAuthActivity controller = new ControllerAuthActivity(this);
        controller.InitializeButtonsClick();
    }
}