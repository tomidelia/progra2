package modelo;

import interfaces.IPersona;

public class Persona implements IPersona {
    private int dni;
    private String nombre;

    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    @Override
    public int getDni() {
        return dni;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ")";
    }
}
