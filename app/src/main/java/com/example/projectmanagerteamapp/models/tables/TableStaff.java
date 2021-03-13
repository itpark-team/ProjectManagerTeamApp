package com.example.projectmanagerteamapp.models.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projectmanagerteamapp.models.entities.Employee;
import com.example.projectmanagerteamapp.models.tools.DbHelper;

import java.util.ArrayList;

public class TableStaff
{
    private DbHelper dbHelper;

    public TableStaff(DbHelper dbHelper)
    {
        this.dbHelper = dbHelper;
    }

    public Employee AuthAsManagerByLoginAndPassword(String login, String password)
    {
        String sqlCommandTemplate = "SELECT * FROM staff AS s\n" +
                "JOIN roles AS r on s.role_id=r.id\n" +
                "JOIN positions AS p on s.position_id=p.id\n" +
                "WHERE login='%s' AND password='%s' AND s.role_id=1";

        String sqlCommand = String.format(sqlCommandTemplate, login, password);

        Employee employee = null;

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery(sqlCommand,null);

        while (cursor.moveToNext() == true)
        {
            employee = new Employee(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(13),
                    cursor.getInt(5),
                    cursor.getString(6),
                    cursor.getInt(7),
                    cursor.getString(8),
                    cursor.getInt(9),
                    cursor.getString(11)
                    );
        }

        cursor.close();
        dbHelper.close();

        return employee;
    }

    public ArrayList<Employee> GetAllEmployees()
    {
        String sqlCommand = "SELECT * FROM staff AS s\n" +
                "JOIN roles AS r on s.role_id=r.id\n" +
                "JOIN positions AS p on s.position_id=p.id\n" +
                "WHERE s.role_id=2";

        ArrayList<Employee> employees = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery(sqlCommand,null);

        while (cursor.moveToNext() == true)
        {
            Employee employee = new Employee(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(13),
                    cursor.getInt(5),
                    cursor.getString(6),
                    cursor.getInt(7),
                    cursor.getString(8),
                    cursor.getInt(9),
                    cursor.getString(11)
            );

            employees.add(employee);
        }

        cursor.close();
        dbHelper.close();

        return employees;
    }
}
