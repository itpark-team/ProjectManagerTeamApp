package com.example.projectmanagerteamapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectmanagerteamapp.R;
import com.example.projectmanagerteamapp.controlllers.ControllerDetailsActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ControllerDetailsActivity controller = new ControllerDetailsActivity(this);
        controller.InitializeButtonsClick();
        controller.ShowEmployeeDetails();
    }
}