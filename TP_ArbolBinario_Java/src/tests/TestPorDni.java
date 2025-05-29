package tests;

import modelo.ArbolBinario;
import modelo.Persona;

public class TestPorDni {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Persona[] personas = baseDeDatos.obtenerPersonas();

        for (Persona p : personas) {
            arbol.insertar(p, true);
        }

        //MUESTRA RECORRIDOS POR DNI
        arbol.inOrden();
        arbol.preOrden();
        arbol.postOrden();
    }
}
