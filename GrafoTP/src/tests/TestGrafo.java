package tests;

import modelo.*;

public class TestGrafo {
    public static void main(String[] args) {
        Grafo<Persona> grafo = new Grafo<>(false);

        Persona a = new Persona("Ana", 25);
        Persona b = new Persona("Bruno", 30);
        Persona c = new Persona("Carla", 28);

        grafo.agregarNodo(a);
        grafo.agregarNodo(b);
        grafo.agregarNodo(c);

        grafo.agregarArista(a, b);
        grafo.agregarArista(b, c);

        System.out.println("DFS:");
        for (Persona p : grafo.recorridoDFS(a)) {
            System.out.println(p);
        }

        System.out.println("\nBFS:");
        for (Persona p : grafo.recorridoBFS(a)) {
            System.out.println(p);
        }

        System.out.println("\nMatriz de adyacencia:");
        int[][] matriz = grafo.matrizAdyacencia();
        for (int[] fila : matriz) {
            for (int val : fila) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}