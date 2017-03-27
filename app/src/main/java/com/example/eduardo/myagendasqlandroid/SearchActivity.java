package com.example.eduardo.myagendasqlandroid;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eduardo.myagendasqlandroid.database.DBAgenda;

public class SearchActivity extends AppCompatActivity {

    private Cursor agenda;
    DBAgenda adp;
    Contacto contacto;

    //Función para crear alertas
    private void crearAlerta(String texto){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setMessage(texto);
        dialogo.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                dialogo.cancel();
            }
        });
        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                finish();
            }
        });
        dialogo.show();
    }

    //Función para mostrar textos emergentes
    private void mostrarTexto(String texto){
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchlinear);
    }

    public void cambiarActivityMain (View vi) {
        System.out.println("ACTIVITY-Search: Presionado el boton Volver");
        this.finish();
    }

    public void buscarEmail (View vi) {
        System.out.println("ACTIVITY-Search: Presionado el boton Buscar");

        //Recogemos el email a buscar en la base de datos
        EditText email = (EditText) findViewById(R.id.etEmailSearch);

        if(email.getText().length() > 0){

            //Creo un conector a la base de datos y buscamos el contacto
            adp = new DBAgenda(this);
            contacto = adp.recuperarContactoPorEmail(email.getText().toString());
            if (contacto.getNombre()==null){
                crearAlerta("No se ha encontrado el contacto solicitado " + "\n");
            } else {
                mostrarTexto("Los datos del contacto son: " +contacto.ContactoToString());
            }
        }
        else {
            mostrarTexto("Introduce el correo a buscar");
        }

    }
}
