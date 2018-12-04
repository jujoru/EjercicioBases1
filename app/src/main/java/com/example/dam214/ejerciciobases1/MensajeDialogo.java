package com.example.dam214.ejerciciobases1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class MensajeDialogo extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.titulo).setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(R.string.mensaje)
                .setPositiveButton(R.string.aceptar, new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Código asociado al botón Aceptar. Por ejemplo:
                        //Toast.makeText(getActivity(), "PULSADA OPCION BOA", Toast.LENGTH_LONG).show();
                    }
                });
        return builder.create();
    }
}

