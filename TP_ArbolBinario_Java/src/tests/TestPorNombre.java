package tests;

import modelo.ArbolBinario;
import modelo.Persona;

public class TestPorNombre {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Persona[] personas = baseDeDatos.obtenerPersonas();

        for (Persona p : personas) {
            arbol.insertar(p, false);
        }

        //MUESTRA RECORRIDOS POR NOMBRE
        arbol.inOrden();
        arbol.preOrden();
        arbol.postOrden();
    }
}
