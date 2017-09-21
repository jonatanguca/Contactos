package com.example.usuario.contactos;

/**
 * Created by Jonatan on 21/09/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Contacto> lista;
    public static final int ALTA = 100;
    public static final int BAJA = 200;
    public static final int LISTAR = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAlta = (Button) findViewById(R.id.alta);
        btnAlta.setOnClickListener(this);
        Button btnBaja = (Button) findViewById(R.id.baja);
        btnBaja.setOnClickListener(this);
        Button btnLista = (Button) findViewById(R.id.lista);
        btnLista.setOnClickListener(this);
        lista = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alta:
                Intent intent = new Intent(this, AltaContacto.class);
                startActivityForResult(intent, ALTA);
                break;
            case R.id.baja:
                Intent intent2 = new Intent(this, BajaContacto.class);
                startActivityForResult(intent2, BAJA);
                break;
            case R.id.lista:
                Intent intent3 = new Intent(this, ListarContacto.class);
                //intent3.putExtra("lista", lista);
                startActivityForResult(intent3, LISTAR);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ALTA) {
            if (resultCode == Activity.RESULT_OK) {
                if (data.hasExtra("contacto")) {
                    lista.add((Contacto) data.getParcelableExtra("contacto"));
                }
            }
        }
        if (requestCode == BAJA){
            if (resultCode == Activity.RESULT_OK) {
                if (data.hasExtra("contacto")) {
                    lista.remove((Contacto) data.getParcelableExtra("contacto"));
                }
            }        }
    }
}
