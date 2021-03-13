package com.example.projectmanagerteamapp.models.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper
{
    public DbHelper(Context context)
    {
        super(context,"app.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS \"roles\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"name\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS \"staff\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"login\"\tTEXT NOT NULL,\n" +
                "\t\"password\"\tTEXT NOT NULL,\n" +
                "\t\"name\"\tTEXT NOT NULL,\n" +
                "\t\"position_id\"\tINTEGER NOT NULL,\n" +
                "\t\"age\"\tINTEGER NOT NULL,\n" +
                "\t\"photo\"\tTEXT NOT NULL,\n" +
                "\t\"work_experience\"\tINTEGER NOT NULL,\n" +
                "\t\"description\"\tTEXT NOT NULL,\n" +
                "\t\"role_id\"\tINTEGER NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS \"positions\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL,\n" +
                "\t\"name\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");");


        db.execSQL("DELETE FROM roles");
        db.execSQL("DELETE FROM staff");
        db.execSQL("DELETE FROM positions");

        db.execSQL("INSERT INTO \"roles\" (\"id\",\"name\") VALUES (1,'Руководитель'),\n" +
                " (2,'Сотрудник');");

        db.execSQL("INSERT INTO \"staff\" (\"id\",\"login\",\"password\",\"name\",\"position_id\",\"age\",\"photo\",\"work_experience\",\"description\",\"role_id\") VALUES (1,'ann','123','Анна',1,21,'ann',3,'Имеет хорошие знания по своей специальности, достаточную эрудицию в других служебных вопросах. Может решать все вопросы, касавшиеся своей работы, совершенно самостоятельно, не ожидая чьей-либо подсказки или указания.',2),\n" +
                " (2,'ivan','123','Иван',4,41,'ivan',15,'За время своей работы продемонстрировал лидерские качества, отличные навыки планирования, умение оперативно решать сложные вопросы и работать на стратегическое развитие компании. ',1),\n" +
                " (3,'dima','123','Дмитрий',2,18,'dima',4,'К работе относится творчески, ответственно.  Всегда готов прийти на помощь и дать полезный совет.',2),\n" +
                " (4,'ilya','123','Илья',3,24,'ilya',5,'В отношениях с коллегами и деловыми партнёрами корректен, вежлив, приветлив. Отличается вниманием и умением слушать. Дискуссии ведёт спокойно и аргументированно.  ',2),\n" +
                " (5,'elena','123','Елена',5,18,'elena',3,'Трудолюбива, обладает высокой работоспособностью, всячески поддерживает работу компании в сложные моменты, в том числе и во внеурочное время.',2);");

        db.execSQL("INSERT INTO \"positions\" (\"id\",\"name\") VALUES (1,'Менеджер по продажам'),\n" +
                " (2,'Программист'),\n" +
                " (3,'Руководитель команды'),\n" +
                " (4,'Директор подразделения'),\n" +
                " (5,'Дизайнер');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
