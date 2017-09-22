package com.example.usuario.contactos;

/**
 * Created by Jonatan on 21/09/2017.
 */

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BajaContacto extends AppCompatActivity implements View.OnClickListener {
    private AlertDialog ventana;
    private Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baja_contacto);
        Button btnBaja = (Button) findViewById(R.id.btnBaja);
        btnBaja.setOnClickListener(this);
        Button btnCancelar = (Button) findViewById(R.id.btnCancelarBaja);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBaja:
                bajaContacto(view);
                if (contacto != null) {
                    Intent intent = new Intent();
                    intent.putExtra("contacto", contacto);
                    setResult(Activity.RESULT_OK, intent);
                }
                finish();
                break;
            case R.id.btnCancelarBaja:
                if (ventana == null) {
                    ventana = mostrarDialogo();
                }
                ventana.show();
                break;
        }
    }

    public void bajaContacto(View view) {
        EditText edtNombre = (EditText) findViewById(R.id.nombreBaja);
        EditText edtEmail = (EditText) findViewById(R.id.emailBaja);
        EditText edtEdad = (EditText) findViewById(R.id.edadBaja);
        String nombre = edtNombre.getText().toString();
        String email = edtEmail.getText().toString();
        Integer edad = Integer.parseInt(edtEdad.getText().toString());
        contacto = new Contacto(nombre, email, edad);
    }

    public AlertDialog mostrarDialogo() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("¿Quieres seguir?");
        alerta.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                BajaContacto.this.finish();
            }
        });
        alerta.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {

            }
        });
        return alerta.create();
    }
}
