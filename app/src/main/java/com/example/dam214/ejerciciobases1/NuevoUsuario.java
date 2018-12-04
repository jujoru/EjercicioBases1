package com.example.dam214.ejerciciobases1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NuevoUsuario extends AppCompatActivity {
    EditText nombre, password, login, email;
    ActionBar bar;
    Spinner plataforma;
    CheckBox ch1,ch2,ch3,ch4;
    Button btnRegitrar;
    UsuarioDAOSQLite usrDAO;
    private APPVUELOS appv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Activar el botón de navegación atrás
        iniciarElementos();
        bar = getSupportActionBar();
        bar.setTitle(R.string.id+"Nuevo usuario");
    }

    private void iniciarElementos(){
        //iniciamos DAO
        this.usrDAO = new UsuarioDAOSQLite(this);
        nombre=(EditText)findViewById(R.id.editTextNombre);
        password=(EditText)findViewById(R.id.editTextContraseña);
        login=(EditText)findViewById(R.id.editTextLogin);
        email=(EditText)findViewById(R.id.editTextEmail);
        plataforma=(Spinner)findViewById(R.id.spinner);
        String[] datos = {"PC","Play Station","XBOX"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_expandable_list_item_1, datos);

        plataforma.setAdapter(adaptador);

        ch1 = (CheckBox) findViewById(R.id.checkBox);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        ch3 = (CheckBox) findViewById(R.id.checkBox3);
        ch4 = (CheckBox) findViewById(R.id.checkBox4);
        btnRegitrar = (Button) findViewById(R.id.btnRegitrar);
        btnRegitrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String nom = nombre.getText().toString();
                String pass = password.getText().toString();
                String log = login.getText().toString();
                String ema = email.getText().toString();
                String plat = plataforma.getSelectedItem().toString();
                String genero = "";
                boolean seleccionadoGenero=false;
                if(ch1.isChecked()){
                    genero +=ch1.getText().toString().concat(",");
                    seleccionadoGenero=true;
                }
                if(ch2.isChecked()){
                    genero +=ch2.getText().toString().concat(",");
                     seleccionadoGenero=true;
                }
                if(ch3.isChecked()){
                    genero +=ch3.getText().toString().concat(",");
                     seleccionadoGenero=true;
                }
                if(ch4.isChecked()){
                    genero +=ch4.getText().toString().concat(",");
                     seleccionadoGenero=true;
                }

                if(TextUtils.isEmpty(nom) || TextUtils.isEmpty(pass) ||TextUtils.isEmpty(log) ||TextUtils.isEmpty(ema)   || !seleccionadoGenero){
                    Toast.makeText(getApplicationContext(),"Debes de rellenar todos los campos", Toast.LENGTH_LONG).show();
                }else{
                    Usuario usr = new Usuario(nom, log, pass, ema,plat,genero);
                    boolean insercion = usrDAO.insertarUsuario(usr);
                    //Notificación de la inserción.
                    if (insercion)
                        Toast.makeText(getApplicationContext(), "16MSD-Nuevo usuario registrado.", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Error en el registro de usuario.", Toast.LENGTH_LONG).show();
                    //Ir a la ventana de inicio de sesión y finalizar la Activity.
                    //Intent intent = new Intent(this, MainActivity.class);
                    //startActivity(intent);
                    finish();
                }




            }
        });
    }
}
