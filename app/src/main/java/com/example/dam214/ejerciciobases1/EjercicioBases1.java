package com.example.dam214.ejerciciobases1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class EjercicioBases1 extends AppCompatActivity {
    private APPVUELOS appv;
    public final static String NOMBRE = "nombre";
    public final static String ID = "id";
    public final static String PASSWORD = "password";
    public final static String LOGIN = "login";
    UsuarioDAOSQLite usrDAO;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio_bases1);
        copiarBD();
        this.usrDAO = new UsuarioDAOSQLite(this);
        xestionarEventos();
        bar = getSupportActionBar();
        bar.setTitle(R.string.id);
    }


    private void copiarBD() {
        String bddestino = "/data/data/" + getPackageName() + "/databases/"
                + APPVUELOS.NOME_BD;
        File file = new File(bddestino);
        Log.d("DEPURACIÓN", R.string.msg + bddestino);
        if (file.exists()) {
            Toast.makeText(getApplicationContext(), R.string.msg, Toast.LENGTH_LONG).show();
            return; // XA EXISTE A BASE DE DATOS
        }


        String pathbd = "/data/data/" + getPackageName()
                + "/databases/";
        File filepathdb = new File(pathbd);
        filepathdb.mkdirs();


        InputStream inputstream;
        try {
            inputstream = getAssets().open(APPVUELOS.NOME_BD);
            OutputStream outputstream = new FileOutputStream(bddestino);


            int tamread;
            byte[] buffer = new byte[2048];


            while ((tamread = inputstream.read(buffer)) > 0) {
                outputstream.write(buffer, 0, tamread);
            }


            inputstream.close();
            outputstream.flush();
            outputstream.close();
            Toast.makeText(getApplicationContext(), R.string.txt, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    private void xestionarEventos() {
        Button btnAbrirBD = (Button) findViewById(R.id.button);
        btnAbrirBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                iniciarSesion();
            }
        });
        Button btnRegistro = (Button)findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NuevoUsuario.class);
                startActivity(i);
            }
        });
    }

    void iniciarSesion() {
        String login = ((EditText) findViewById(R.id.editText)).getText().toString();
        String password = ((EditText) findViewById(R.id.editText2)).getText().toString();
        Usuario usr = this.usrDAO.getUsuario(login, password);

        if (usr != null) {
            Log.d("DEPURACIÓN", R.string.msg3 + usr.getNombre());
            Toast.makeText(getApplicationContext(), R.string.txt2, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, BusquedaVuelos.class);
            intent.putExtra(this.NOMBRE, usr.getNombre());
            intent.putExtra(this.LOGIN, usr.getLogin());
            intent.putExtra(this.PASSWORD, usr.getPassword());
            intent.putExtra(this.ID, usr.getId());


            startActivity(intent);
            finish();

        } else {
            //Toast.makeText(getApplicationContext(), "Error de autentificación.", Toast.LENGTH_LONG).show();
            MensajeDialogo d= new MensajeDialogo();
            d.setCancelable(false);
            FragmentManager fm= this.getSupportFragmentManager();
            d.show(fm,"errorLogin");
        }
    }
}

