package com.example.eduardo.myagendasqlandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.eduardo.myagendasqlandroid.database.DBAgenda;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> agenda;
    DBAgenda adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("ACTIVITY-MAIN: Estamos en MAIN onCreate");
        adp = new DBAgenda(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ACTIVITY-MAIN: Estamos en MAIN onStart");

    }

    public void cambiarActivityAñadir (View vi) {
        System.out.println("ACTIVITY-MAIN: Presionado el boton 1");
        //setActivityForResult(AddActivity.class, 0);
        setActivity(AddActivity.class);
    }

    public void cambiarActivityBuscar (View vi) {
        System.out.println("ACTIVITY-MAIN: Presionado el boton 2");
        setActivity(SearchActivity.class);
    }

    public void cambiarActivityVerTodos (View vi) {
        System.out.println("ACTIVITY-MAIN: Presionado el boton 3");
        setActivity(ViewAllActivity.class);
    }

    private void setActivity(Class clase){
        Intent intent = new Intent(this,clase);
        //intent.putExtra("Agenda", agenda);
        startActivity(intent);
    }

    public void borrarAgenda (View vi){
        System.out.println("ACTIVITY-MAIN: Presionado el boton Borrar Agenda");
        //adp.borrarAgenda();

    }

}
