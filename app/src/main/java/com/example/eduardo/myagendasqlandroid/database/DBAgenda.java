package com.example.eduardo.myagendasqlandroid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eduardo.myagendasqlandroid.Contacto;

/**
 * Created by Edu on 27/03/2017.
 * DBAgenda tendremos las sentencias que queremos ejecutar sobre la Base de Datos, querys, inserts, etc...
 */

public class DBAgenda {
    private static final String TABLA="agenda";

    //Atributos
    private SQLiteDatabase db=null;
    private DatabaseHelper dbhelper=null;
    //Contexto
    Context context;

    //Constructor
    public DBAgenda(Context ctx){
        this.context=ctx;
        //crea una instancia del helper
        dbhelper=new DatabaseHelper(context);
        //crea un objeto SQLiteDatabase para operar contra la base de datos
        db=dbhelper.getWritableDatabase();
        System.out.println("ACTIVITY DB-AGENDA: Constructor");
    }

    public void close(){
        dbhelper.close();
    }

    public long altaContacto(String nombre, String email, int edad){
        //crea el contentvalues y añade una entrada por cada dato del contacto a guardar
        ContentValues initialValues=new ContentValues();
        initialValues.put("nombre", nombre);
        initialValues.put("email", email);
        initialValues.put("edad", edad);
        return db.insert(TABLA, null, initialValues);
    }

    public boolean borrarContacto(int id){
        //elimina el contacto a partir del id
        return db.delete(TABLA, "_id="+id, null)>0;
    }

    public Contacto recuperarContactoPorEmail(String email){
        Contacto contacto=null;
        Cursor c=db.query(TABLA, new String[]{"_id",
                "nombre","edad"},"email=?", new String[]{email},
                null,null,null);
        //el curso apunta a la posición anterior al primer registro debe desplazarlo al siguiente registro para apuntar al primero
        if(c.moveToNext()){
            contacto=new Contacto(c.getString(1),c.getInt(2),email);
        }
        return contacto;
    }
    public Cursor recuperarContactos(){
        //aunque no se utilice, se debe recuperar también el campo _id
        return db.query(TABLA, new String[]{"_id","nombre","email","edad"},null, null, null,null,null);
    }

}
