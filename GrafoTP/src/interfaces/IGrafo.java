package interfaces;
import java.util.List;

public interface IGrafo<T> {
    void agregarNodo(T dato);
    void agregarArista(T origen, T destino);
    void agregarArista(T origen, T destino, int peso);
    void eliminarNodo(T dato);
    void eliminarArista(T origen, T destino);
    List<T> recorridoDFS(T inicio);
    List<T> recorridoBFS(T inicio);
    int[][] matrizAdyacencia();
    boolean esDirigido();
}