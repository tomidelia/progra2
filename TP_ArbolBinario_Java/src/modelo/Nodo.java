package modelo;

import interfaces.INodo;
import interfaces.IPersona;

public class Nodo implements INodo {
    private IPersona dato;
    private INodo izquierda;
    private INodo derecha;

    public Nodo(IPersona persona) {
        this.dato = persona;
    }

    @Override
    public IPersona getDato() {
        return dato;
    }

    @Override
    public void setDato(IPersona dato) {
        this.dato = dato;
    }

    @Override
    public INodo getIzquierda() {
        return izquierda;
    }

    @Override
    public void setIzquierda(INodo nodo) {
        this.izquierda = nodo;
    }

    @Override
    public INodo getDerecha() {
        return derecha;
    }

    @Override
    public void setDerecha(INodo nodo) {
        this.derecha = nodo;
    }
}
