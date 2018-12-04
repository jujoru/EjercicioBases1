package com.example.dam214.ejerciciobases1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class BusquedaVuelos extends AppCompatActivity {
    private TextView textView8, textView9, textView10, textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        Intent intent = getIntent();
        String nuevoTitulo=getResources().getText(R.string.app_name)
                +": "+intent.getExtras().getString(EjercicioBases1.NOMBRE);
        setTitle(nuevoTitulo);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);

        textView8.setText(intent.getExtras().getString(EjercicioBases1.NOMBRE));
        textView9.setText(intent.getExtras().getString(EjercicioBases1.LOGIN));
        textView10.setText(intent.getExtras().getString(EjercicioBases1.PASSWORD));
        textView11.setText(""+intent.getExtras().getInt(EjercicioBases1.ID));
    }



}

