package com.example.eduardo.myagendasqlandroid;

import java.io.Serializable;

/**
 * Created by edu on 22/03/2017.
 */

public class Contacto implements Serializable{
    private String nombre;
    private int edad;
    private String email;

    public Contacto(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    public String ContactoToString() {
        return "Nombre= " +getNombre() +", Edad= " +getEdad() +", Email= " +getEmail();
    }

    public String ContactoToFichero() {
        return getNombre() +"," +getEdad() +"," +getEmail();
    }
}
