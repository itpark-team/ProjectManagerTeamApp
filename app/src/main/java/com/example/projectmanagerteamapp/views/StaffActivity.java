package com.example.projectmanagerteamapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectmanagerteamapp.R;
import com.example.projectmanagerteamapp.controlllers.ControllerStaffActivity;

public class StaffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        ControllerStaffActivity controller = new ControllerStaffActivity(this);
        controller.InitializeButtonsClick();
        controller.ShowAllEmployees();
    }
}