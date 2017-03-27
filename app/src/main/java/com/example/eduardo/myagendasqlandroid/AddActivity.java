package com.example.eduardo.myagendasqlandroid;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.eduardo.myagendasqlandroid.database.DBAgenda;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        System.out.println("ACTIVITY-ADD: OnCreate");

    }

    //Función para crear alertas
    private void crearAlerta(String texto){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setMessage(texto);
        dialogo.setPositiveButton("Reintentar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                dialogo.cancel();
            }
        });
        dialogo.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                finish();
            }
        });
        dialogo.show();
    }

    public void guardarContacto(View vi){

        System.out.println("ACTIVITY-ADD: guardando Contacto");

        //Abrimos la base de datos
        DBAgenda adp = new DBAgenda(this);

        EditText nombre = (EditText) findViewById(R.id.etNombre);
        EditText edad = (EditText) findViewById(R.id.etEdad);
        EditText email = (EditText) findViewById(R.id.etEmail);

        System.out.println("ACTIVITY-ADD: Nombre " +nombre.getText().toString() +" Edad " +edad.getText().toString());

        if (nombre.getText().toString().equals("") || edad.getText().toString().equals("") || email.getText().toString().equals("")) {
            crearAlerta("Alguno de los campos está vacío");
        } else {
            //Contacto contacto = new Contacto(nombre.getText().toString(), Integer.parseInt(edad.getText().toString()), email.getText().toString());
            adp.altaContacto(nombre.getText().toString(), email.getText().toString(), Integer.parseInt(edad.getText().toString()));
            adp.close();

            this.finish();
        }

    }
}
