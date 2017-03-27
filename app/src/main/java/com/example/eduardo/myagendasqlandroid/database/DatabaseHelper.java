package com.example.eduardo.myagendasqlandroid.database;

/**
 * Created by Edu on 27/03/2017.
 * DatabaseHelper defeniría la base de datos, tablas que tiene, etc... Ejecutaremos Alter tables...
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME="DBagenda";
    private static final int DATABASE_VERSION=1;

    //sql de creación de tabla
    private static final String DATABASE_CREATE_AGENDA=
     "create table if not exists agenda (_id integer primary key autoincrement,"+
            "nombre text not null, email text not null, edad int not null)";

    //sql eliminación de tabla
    private static final String DATABASE_DELETE_AGENDA=
         "drop table if exists agenda";
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Se llama al crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        //creamos las tablas
        System.out.println("ACTIVITY DB-HELPER: Llamando a crear tabla agenda");
        createTables(db);
    }
    //este método es llamado si a la hora de crear el DataBaseHelper
    //se pasa una versión superior a la ya existente
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        //reconstruimos la tabla
        deleteTables(db);
        createTables(db);
    }
    private void createTables(SQLiteDatabase db) {
        System.out.println("ACTIVITY DB-HELPER: Ejecutando para crear tabla agenda");
        db.execSQL(DATABASE_CREATE_AGENDA);
    }
    private void deleteTables(SQLiteDatabase db) {
        System.out.println("ACTIVITY DB-HELPER: Ejecutando para borrar tabla agenda");
        db.execSQL(DATABASE_DELETE_AGENDA);
    }
}
