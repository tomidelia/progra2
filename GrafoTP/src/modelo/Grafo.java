package modelo;

import interfaces.IGrafo;
import java.util.*;

public class Grafo<T> implements IGrafo<T> {
    private Map<String, Nodo<T>> nodos;
    private Map<String, List<String>> adyacencias;
    private boolean dirigido;

    public Grafo(boolean dirigido) {
        this.dirigido = dirigido;
        this.nodos = new HashMap<>();
        this.adyacencias = new HashMap<>();
    }

    public void agregarNodo(T dato) {
        String id = UUID.randomUUID().toString();
        Nodo<T> nodo = new Nodo<>(id, dato);
        nodos.put(id, nodo);
        adyacencias.put(id, new ArrayList<>());
    }

    public void agregarArista(T origen, T destino) {
        agregarArista(origen, destino, 1);
    }

    public void agregarArista(T origen, T destino, int peso) {
        String idOrigen = obtenerId(origen);
        String idDestino = obtenerId(destino);
        if (idOrigen != null && idDestino != null) {
            adyacencias.get(idOrigen).add(idDestino);
            if (!dirigido) {
                adyacencias.get(idDestino).add(idOrigen);
            }
        }
    }

    public void eliminarNodo(T dato) {
        String id = obtenerId(dato);
        if (id != null) {
            nodos.remove(id);
            adyacencias.remove(id);
            for (List<String> vecinos : adyacencias.values()) {
                vecinos.remove(id);
            }
        }
    }

    public void eliminarArista(T origen, T destino) {
        String idOrigen = obtenerId(origen);
        String idDestino = obtenerId(destino);
        if (idOrigen != null && idDestino != null) {
            adyacencias.get(idOrigen).remove(idDestino);
            if (!dirigido) {
                adyacencias.get(idDestino).remove(idOrigen);
            }
        }
    }

    public List<T> recorridoDFS(T inicio) {
        List<T> resultado = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        String idInicio = obtenerId(inicio);
        if (idInicio != null) dfs(idInicio, visitados, resultado);
        return resultado;
    }

    private void dfs(String id, Set<String> visitados, List<T> resultado) {
        visitados.add(id);
        resultado.add(nodos.get(id).getDato());
        for (String vecino : adyacencias.get(id)) {
            if (!visitados.contains(vecino)) {
                dfs(vecino, visitados, resultado);
            }
        }
    }

    public List<T> recorridoBFS(T inicio) {
        List<T> resultado = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();
        String idInicio = obtenerId(inicio);
        if (idInicio == null) return resultado;

        cola.add(idInicio);
        visitados.add(idInicio);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            resultado.add(nodos.get(actual).getDato());
            for (String vecino : adyacencias.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        return resultado;
    }

    public int[][] matrizAdyacencia() {
        int n = nodos.size();
        int[][] matriz = new int[n][n];
        List<String> ids = new ArrayList<>(nodos.keySet());

        for (int i = 0; i < n; i++) {
            List<String> vecinos = adyacencias.get(ids.get(i));
            for (int j = 0; j < n; j++) {
                if (vecinos.contains(ids.get(j))) {
                    matriz[i][j] = 1;
                }
            }
        }
        return matriz;
    }

    public boolean esDirigido() {
        return dirigido;
    }

    private String obtenerId(T dato) {
        for (Map.Entry<String, Nodo<T>> entry : nodos.entrySet()) {
            if (entry.getValue().getDato().equals(dato)) {
                return entry.getKey();
            }
        }
        return null;
    }
}