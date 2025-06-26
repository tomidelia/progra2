package modelo;

import java.util.*;

public class GrafoVuelos {
    private Map<String, Aeropuerto> aeropuertos = new HashMap<>();
    private Map<String, List<Vuelo>> adyacencias = new HashMap<>();

    public void agregarAeropuerto(Aeropuerto a) {
        aeropuertos.put(a.getCodigo(), a);
        adyacencias.putIfAbsent(a.getCodigo(), new ArrayList<>());
    }

    public void agregarVuelo(Vuelo v) {
        adyacencias.get(v.getOrigen().getCodigo()).add(v);
    }

    public List<Aeropuerto> dijkstra(String origen, String destino, TipoPeso criterio) {
        Map<String, Double> distancias = new HashMap<>();
        Map<String, String> predecesores = new HashMap<>();
        PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));

        for (String codigo : aeropuertos.keySet()) {
            distancias.put(codigo, Double.MAX_VALUE);
        }
        distancias.put(origen, 0.0);
        cola.add(origen);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            if (actual.equals(destino)) break;

            for (Vuelo v : adyacencias.get(actual)) {
                String vecino = v.getDestino().getCodigo();
                double peso = (criterio == TipoPeso.COSTO) ? v.getCosto() : v.getDuracion();
                double nuevaDist = distancias.get(actual) + peso;

                if (nuevaDist < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDist);
                    predecesores.put(vecino, actual);
                    cola.add(vecino);
                }
            }
        }

        List<Aeropuerto> camino = new LinkedList<>();
        for (String at = destino; at != null; at = predecesores.get(at)) {
            camino.add(0, aeropuertos.get(at));
        }
        return camino.isEmpty() || !camino.get(0).getCodigo().equals(origen) ? Collections.emptyList() : camino;
    }
}