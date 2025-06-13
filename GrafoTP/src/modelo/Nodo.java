package modelo;

import interfaces.INodo;

public class Nodo<T> implements INodo<T> {
    private T dato;
    private String id;

    public Nodo(String id, T dato) {
        this.id = id;
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}