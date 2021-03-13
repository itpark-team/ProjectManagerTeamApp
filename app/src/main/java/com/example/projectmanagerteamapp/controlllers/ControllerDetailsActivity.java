package com.example.projectmanagerteamapp.controlllers;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectmanagerteamapp.R;
import com.example.projectmanagerteamapp.models.DataStorage;
import com.example.projectmanagerteamapp.models.DbManager;
import com.example.projectmanagerteamapp.models.entities.Employee;
import com.example.projectmanagerteamapp.views.DetailsActivity;
import com.example.projectmanagerteamapp.views.StaffActivity;

public class ControllerDetailsActivity
{
    private DetailsActivity detailsActivity;
    private DbManager db;

    public ControllerDetailsActivity(DetailsActivity detailsActivity)
    {
        this.detailsActivity = detailsActivity;
        this.db = DbManager.getInstance(this.detailsActivity.getApplicationContext());
    }

    public void InitializeButtonsClick()
    {
        Button buttonGoToStaff = detailsActivity.findViewById(R.id.buttonGoToStaff);
        buttonGoToStaff.setOnClickListener(buttonGoToStaff_OnClick);
    }

    private View.OnClickListener buttonGoToStaff_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            detailsActivity.finish();
        }
    };

    public void ShowEmployeeDetails()
    {
        Employee employee = (Employee) DataStorage.Get("employee");
        DataStorage.Delete("employee");

        ImageView employeeDetailsPhoto = detailsActivity.findViewById(R.id.employeeDetailsPhoto);
        TextView employeeDetailsName = detailsActivity.findViewById(R.id.employeeDetailsName);
        TextView employeeDetailsPosition = detailsActivity.findViewById(R.id.employeeDetailsPosition);
        TextView employeeDetailsAge = detailsActivity.findViewById(R.id.employeeDetailsAge);
        TextView employeeDetailsWorkExperience = detailsActivity.findViewById(R.id.employeeDetailsWorkExperience);
        TextView employeeDetailsDescription = detailsActivity.findViewById(R.id.employeeDetailsDescription);

        int photoId = detailsActivity.getResources().getIdentifier(employee.getPhoto(),"drawable", detailsActivity.getPackageName());
        employeeDetailsPhoto.setImageResource(photoId);

        employeeDetailsName.setText(employee.getName());
        employeeDetailsPosition.setText(employee.getPositionName());
        employeeDetailsAge.setText(employee.getAge()+" лет");
        employeeDetailsWorkExperience.setText(employee.getWorkExperience()+" лет");
        employeeDetailsDescription.setText(employee.getDescription());
    }
}
