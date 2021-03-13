package com.example.projectmanagerteamapp.controlllers;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectmanagerteamapp.R;
import com.example.projectmanagerteamapp.models.DataStorage;
import com.example.projectmanagerteamapp.models.DbManager;
import com.example.projectmanagerteamapp.models.entities.Employee;
import com.example.projectmanagerteamapp.views.AuthActivity;
import com.example.projectmanagerteamapp.views.StaffActivity;

public class ControllerAuthActivity
{
    private AuthActivity authActivity;
    private DbManager db;

    public ControllerAuthActivity(AuthActivity authActivity)
    {
        this.authActivity = authActivity;
        this.db = DbManager.getInstance(this.authActivity.getApplicationContext());
    }

    public void InitializeButtonsClick()
    {
        Button buttonAuthSignIn = authActivity.findViewById(R.id.buttonAuthSignIn);
        buttonAuthSignIn.setOnClickListener(buttonAuthSignIn_OnClick);
    }

    private View.OnClickListener buttonAuthSignIn_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SignIn();
        }
    };

    private void SignIn()
    {
        EditText editTextAuthLogin = authActivity.findViewById(R.id.editTextAuthLogin);

        EditText editTextAuthPassword = authActivity.findViewById(R.id.editTextAuthPassword);

        String login = editTextAuthLogin.getText().toString();
        String password = editTextAuthPassword.getText().toString();

        Employee employee = db.getTableStaff().AuthAsManagerByLoginAndPassword(login, password);

        if(employee==null)
        {
            Toast.makeText(authActivity.getApplicationContext(),"Ошибка: Пользователь с таким логином и паролем не найден!",Toast.LENGTH_SHORT).show();
            return;
        }

        DataStorage.Add("manager",employee);

        editTextAuthLogin.getText().clear();
        editTextAuthPassword.getText().clear();

        Intent intent = new Intent(authActivity, StaffActivity.class);
        authActivity.startActivity(intent);
    }
}
