package tests;

import modelo.ArbolBinario;
import modelo.Persona;

public class TestBusquedas {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Persona[] personas = baseDeDatos.obtenerPersonas();

        for (Persona p : personas) {
            arbol.insertar(p, true);
        }

        //DNI A BUSCAR
        System.out.println("Buscando DNI 90123456: " + arbol.buscar(90123455));
        System.out.println("Buscando DNI 55667788: " + arbol.buscar(55667788));

        //MUESTRA RECORRIDOS DESPUES DE BUSCAR
        arbol.inOrden();
        arbol.preOrden();
        arbol.postOrden();
    }
}
