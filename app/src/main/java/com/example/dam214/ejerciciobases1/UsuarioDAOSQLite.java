package com.example.dam214.ejerciciobases1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class UsuarioDAOSQLite implements UsuarioDAO {
    private APPVUELOS appv;
    private Context context;

    UsuarioDAOSQLite(Context context){
        this.context=context;
        this.appv = new APPVUELOS(this.context);
    }


    public boolean insertarUsuario(Usuario usr) {
        boolean resultado = true;
        SQLiteDatabase sqlLiteDB = appv.getWritableDatabase();
        String sql = "INSERT INTO Usuario (nombre, login, password,email, plataforma,genero) VALUES (?, ?, ?,?,?,?)";
        SQLiteStatement statement = sqlLiteDB.compileStatement(sql);

        statement.bindString(1, usr.getNombre());
        statement.bindString(2, usr.getLogin());
        statement.bindString(3, usr.getPassword());
        statement.bindString(4, usr.getEmail());
        statement.bindString(5, usr.getPlataforma());
        statement.bindString(6, usr.getGenero());

        long rowId = statement.executeInsert();

        if (rowId != -1) {
            //Comprobación de la lista de usuarios.
            // El siguiente código tiene como finalidad
            //mostrar en el logcat el usuario que se acaba de insertar.
            String usuarios = "";
            Cursor cursor = sqlLiteDB.rawQuery("select * from Usuario", null);
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    usuarios += "\n" + cursor.getString(0) + " " + cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3)+ " " + cursor.getString(4)+ " " + cursor.getString(5)+ " " + cursor.getString(6);
                    cursor.moveToNext();
                }
            }
            Log.d("DEPURACIÓN", "Resultado inserción-16MSD: " + usuarios);
            Log.d("DEPURACIÓN", "Row ID: " + rowId);
        } else {
            resultado = false;
        }
        return resultado;
    }

    public Usuario getUsuario(String login, String password) {
        Usuario resultado = null;
        SQLiteDatabase sqlLiteDB = appv.getWritableDatabase();
        String[] param = {login, password};
        String consulta = "SELECT * FROM usuario WHERE login=? AND password=?";
        Cursor cursor = sqlLiteDB.rawQuery(consulta, param);
        this.depuracion(consulta, param);
        Log.d("DEPURACIÓN", String.valueOf(R.string.msg4 + cursor.getCount()));
        if (cursor.moveToFirst()) {
            resultado = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
        }
        return resultado;
    }
    void depuracion(String consulta, String[] param) {
        String texto = "Consulta: " + consulta + " Valores: ";
        for (String p : param) {
            texto += p + " ";
        }
        Log.d("DEPURACIÓN", texto);
    }



}
