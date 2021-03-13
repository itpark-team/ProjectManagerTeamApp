package com.example.projectmanagerteamapp.controlllers;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectmanagerteamapp.R;
import com.example.projectmanagerteamapp.models.DataStorage;
import com.example.projectmanagerteamapp.models.entities.Employee;
import com.example.projectmanagerteamapp.views.DetailsActivity;
import com.example.projectmanagerteamapp.views.StaffActivity;

import java.util.ArrayList;

public class RvAdapterStaffActivity extends RecyclerView.Adapter<RvAdapterStaffActivity.EmployeeViewHolder>
{
    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        public ImageView employeePhoto;
        public TextView employeeName;
        public TextView employeePosition;
        public TextView employeeAge;
        public Button buttonGoToEmployeeDetails;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            employeePhoto = itemView.findViewById(R.id.employeePhoto);
            employeeName = itemView.findViewById(R.id.employeeName);
            employeePosition = itemView.findViewById(R.id.employeePosition);
            employeeAge = itemView.findViewById(R.id.employeeAge);
            buttonGoToEmployeeDetails = itemView.findViewById(R.id.buttonGoToEmployeeDetails);
        }
    }

    private ArrayList<Employee> employees;
    private StaffActivity staffActivity;

    public RvAdapterStaffActivity(ArrayList<Employee> employees, StaffActivity staffActivity)
    {
        this.employees = employees;
        this.staffActivity = staffActivity;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.employee_view, viewGroup, false);
        EmployeeViewHolder evh = new EmployeeViewHolder(v);
        return evh;
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder employeeViewHolder, int i)
    {
        Employee employee = employees.get(i);

        int photoId = staffActivity.getResources().getIdentifier(employee.getPhoto(),"drawable", staffActivity.getPackageName());

        employeeViewHolder.employeePhoto.setImageResource(photoId);
        employeeViewHolder.employeeName.setText(employee.getName());
        employeeViewHolder.employeePosition.setText(employee.getPositionName());
        employeeViewHolder.employeeAge.setText(employee.getAge()+" лет");

        employeeViewHolder.buttonGoToEmployeeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                DataStorage.Add("employee", employee);
                Intent intent = new Intent(staffActivity, DetailsActivity.class);
                staffActivity.startActivity(intent);
            }
        });
    }


}
