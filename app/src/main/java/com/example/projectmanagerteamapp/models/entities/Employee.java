package com.example.projectmanagerteamapp.models.entities;

public class Employee
{
    private int id;
    private String login;
    private String name;
    private String password;

    private int positionId;
    private String positionName;

    private int age;
    private String photo;
    private int workExperience;

    private String description;

    private int roleId;
    private String roleName;

    public Employee(int id, String login,String password, String name,  int positionId, String positionName, int age, String photo, int workExperience, String description, int roleId, String roleName) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.password = password;
        this.positionId = positionId;
        this.positionName = positionName;
        this.age = age;
        this.photo = photo;
        this.workExperience = workExperience;
        this.description = description;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getPositionId() {
        return positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoto() {
        return photo;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public String getDescription() {
        return description;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }
}
