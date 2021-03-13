package com.example.projectmanagerteamapp.controlllers;

import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmanagerteamapp.R;
import com.example.projectmanagerteamapp.models.DataStorage;
import com.example.projectmanagerteamapp.models.DbManager;
import com.example.projectmanagerteamapp.models.entities.Employee;
import com.example.projectmanagerteamapp.views.AuthActivity;
import com.example.projectmanagerteamapp.views.StaffActivity;

import java.util.ArrayList;

public class ControllerStaffActivity
{
    private StaffActivity staffActivity;
    private DbManager db;

    public ControllerStaffActivity(StaffActivity staffActivity)
    {
        this.staffActivity = staffActivity;
        this.db = DbManager.getInstance(this.staffActivity.getApplicationContext());
    }

    public void InitializeButtonsClick()
    {
        Button buttonAuthSignOut = staffActivity.findViewById(R.id.buttonAuthSignOut);
        buttonAuthSignOut.setOnClickListener(buttonAuthSignOut_OnClick);
    }

    private View.OnClickListener buttonAuthSignOut_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SignOut();
        }
    };

    private void SignOut()
    {
        DataStorage.Delete("manager");
        staffActivity.finish();
    }



    public void ShowAllEmployees()
    {
        ArrayList<Employee> employees = db.getTableStaff().GetAllEmployees();

        RecyclerView recyclerViewStaff = staffActivity.findViewById(R.id.recyclerViewStaff);
        LinearLayoutManager llm = new LinearLayoutManager(staffActivity.getApplicationContext());
        recyclerViewStaff.setLayoutManager(llm);

        RvAdapterStaffActivity adapter = new RvAdapterStaffActivity(employees, staffActivity);
        recyclerViewStaff.setAdapter(adapter);
    }
}
