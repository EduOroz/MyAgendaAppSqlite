package com.example.eduardo.myagendasqlandroid;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.eduardo.myagendasqlandroid.database.DBAgenda;

public class ViewAllActivity extends AppCompatActivity {

    private ListView lvViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        System.out.println("ACTIVITY-ViewAll: OnCreate");

        //Abrimos la Base de datos y recuperamos un cursor con los contactos de la agenda
        DBAgenda adp=new DBAgenda(this);
        Cursor c=adp.recuperarContactos();

        //Montamos las columnas que vamos a visualizar en el Adapter
        String [] columns=new String[]{"nombre","edad","email"};
        int[] views=new int[]{R.id.nombre,R.id.edad,R.id.email};

        SimpleCursorAdapter sc= new SimpleCursorAdapter(
                this,
                R.layout.elemento,
                c,
                columns,
                views,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        //Recuperamos el ListView del layout y le dotamos de contenido con el Adapter
        ListView lista=(ListView)findViewById(R.id.lvViewAll);
        lista.setAdapter(sc);
        adp.close();

        /*Creamos un listener para cuando hagamos click en un contacto nos muestre en un toast sus datos
        lvViewAll.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent,
                                            View view, int position, long id) {
                        Toast.makeText(ViewAllActivity.this,
                                agenda.get(position).ContactoToString(),
                                Toast.LENGTH_LONG).show();
                    }
                });
         */
    }

    public void cambiarActivityMain (View vi) {
        System.out.println("ACTIVITY-ViewAll: Presionado el boton Volver");
        this.finish();
    }

}
