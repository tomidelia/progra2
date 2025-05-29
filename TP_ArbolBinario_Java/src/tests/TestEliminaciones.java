package tests;

import modelo.ArbolBinario;
import modelo.Persona;

public class TestEliminaciones {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Persona[] personas = baseDeDatos.obtenerPersonas();

        for (Persona p : personas) {
            arbol.insertar(p, true);
        }
        
        //DNI A ELIMINAR
        arbol.eliminar(45678901); 
        arbol.eliminar(34567890); 
        arbol.eliminar(23456789); 

        //MOSTRAR RECORRIDOS DESPUES DE ELIMINAR
        arbol.inOrden();
        arbol.preOrden();
        arbol.postOrden();
    }
}
