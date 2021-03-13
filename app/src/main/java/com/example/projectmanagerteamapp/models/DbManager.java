package com.example.projectmanagerteamapp.models;

import android.content.Context;

import com.example.projectmanagerteamapp.models.tables.TablePositions;
import com.example.projectmanagerteamapp.models.tables.TableRoles;
import com.example.projectmanagerteamapp.models.tables.TableStaff;
import com.example.projectmanagerteamapp.models.tools.DbHelper;

public class DbManager
{
    private static DbManager instance = null;

    public static DbManager getInstance(Context context)
    {
        if (instance==null)
        {
            instance = new DbManager(context);
        }
        return instance;
    }

    private TablePositions tablePositions;
    private TableRoles tableRoles;
    private TableStaff tableStaff;

    private DbManager(Context context)
    {
        DbHelper dbHelper = new DbHelper(context);

        tablePositions = new TablePositions(dbHelper);
        tableRoles = new TableRoles(dbHelper);
        tableStaff = new TableStaff(dbHelper);
    }

    public TablePositions getTablePositions() {
        return tablePositions;
    }

    public TableRoles getTableRoles() {
        return tableRoles;
    }

    public TableStaff getTableStaff() {
        return tableStaff;
    }
}
