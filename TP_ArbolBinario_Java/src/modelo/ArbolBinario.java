package modelo;

import interfaces.IArbol;
import interfaces.INodo;
import interfaces.IPersona;

public class ArbolBinario implements IArbol {
    private INodo raiz;

    @Override
    public void insertar(IPersona persona, boolean porDni) {
        raiz = insertarRec(raiz, persona, porDni);
    }

    private INodo insertarRec(INodo actual, IPersona persona, boolean porDni) {
        if (actual == null) return new Nodo(persona);

        if (porDni) {
            if (persona.getDni() < actual.getDato().getDni()) {
                actual.setIzquierda(insertarRec(actual.getIzquierda(), persona, true));
            } else {
                actual.setDerecha(insertarRec(actual.getDerecha(), persona, true));
            }
        } else {
            if (persona.getNombre().compareToIgnoreCase(actual.getDato().getNombre()) < 0) {
                actual.setIzquierda(insertarRec(actual.getIzquierda(), persona, false));
            } else {
                actual.setDerecha(insertarRec(actual.getDerecha(), persona, false));
            }
        }

        return actual;
    }

    @Override
    public void inOrden() {
        System.out.println("InOrden:");
        inOrdenRec(raiz);
        System.out.println();
    }

    private void inOrdenRec(INodo nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.getIzquierda());
            System.out.print(nodo.getDato() + " | ");
            inOrdenRec(nodo.getDerecha());
        }
    }

    @Override
    public void preOrden() {
        System.out.println("PreOrden:");
        preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(INodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " | ");
            preOrdenRec(nodo.getIzquierda());
            preOrdenRec(nodo.getDerecha());
        }
    }

    @Override
    public void postOrden() {
        System.out.println("PostOrden:");
        postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(INodo nodo) {
        if (nodo != null) {
            postOrdenRec(nodo.getIzquierda());
            postOrdenRec(nodo.getDerecha());
            System.out.print(nodo.getDato() + " | ");
        }
    }

    @Override
    public void eliminar(int dni) {
        raiz = eliminarRec(raiz, dni);
    }

    private INodo eliminarRec(INodo actual, int dni) {
        if (actual == null) return null;

        if (dni < actual.getDato().getDni()) {
            actual.setIzquierda(eliminarRec(actual.getIzquierda(), dni));
        } else if (dni > actual.getDato().getDni()) {
            actual.setDerecha(eliminarRec(actual.getDerecha(), dni));
        } else {
            if (actual.getIzquierda() == null) return actual.getDerecha();
            if (actual.getDerecha() == null) return actual.getIzquierda();

            INodo sucesor = encontrarMinimo(actual.getDerecha());
            actual.setDato(sucesor.getDato());
            actual.setDerecha(eliminarRec(actual.getDerecha(), sucesor.getDato().getDni()));
        }

        return actual;
    }

    private INodo encontrarMinimo(INodo nodo) {
        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda();
        }
        return nodo;
    }

    @Override
    public boolean buscar(int dni) {
        return buscarRec(raiz, dni);
    }

    private boolean buscarRec(INodo nodo, int dni) {
        if (nodo == null) return false;

        if (dni == nodo.getDato().getDni()) return true;
        if (dni < nodo.getDato().getDni()) return buscarRec(nodo.getIzquierda(), dni);
        else return buscarRec(nodo.getDerecha(), dni);
    }
}
