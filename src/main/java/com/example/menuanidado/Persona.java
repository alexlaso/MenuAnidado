package com.example.menuanidado;

import javafx.scene.image.Image;

public class Persona {
    private String nombre, correo;
    private Image icono;
    private int edad;

    public Persona(String nombre, String correo, Image icono, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.icono = icono;
        this.edad = edad;
    }

    public Persona (){
    }
}
