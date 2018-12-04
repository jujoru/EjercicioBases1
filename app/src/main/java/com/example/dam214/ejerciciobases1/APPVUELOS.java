package com.example.dam214.ejerciciobases1;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class APPVUELOS extends SQLiteOpenHelper {
    public final static String NOME_BD = "appvuelos2.db";
    public final static int VERSION_BD = 2;

    public APPVUELOS(Context context) {
        super(context, NOME_BD, null, VERSION_BD);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
}

