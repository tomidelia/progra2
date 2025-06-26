package tests;

import modelo.*;

public class TestMinimaDuracion {
    public static void main(String[] args) {
        GrafoVuelos grafo = new GrafoVuelos();

        Aeropuerto a1 = new Aeropuerto("BUE", "Buenos Aires", "Argentina");
        Aeropuerto a2 = new Aeropuerto("SCL", "Santiago", "Chile");
        Aeropuerto a3 = new Aeropuerto("LIM", "Lima", "Perú");

        grafo.agregarAeropuerto(a1);
        grafo.agregarAeropuerto(a2);
        grafo.agregarAeropuerto(a3);

        grafo.agregarVuelo(new Vuelo(a1, a2, 300, 2));
        grafo.agregarVuelo(new Vuelo(a2, a3, 200, 2));
        grafo.agregarVuelo(new Vuelo(a1, a3, 700, 3));

        System.out.println("Camino mínimo por duración de BUE a LIM:");
        for (Aeropuerto a : grafo.dijkstra("BUE", "LIM", TipoPeso.DURACION)) {
            System.out.println(" -> " + a);
        }
    }
}