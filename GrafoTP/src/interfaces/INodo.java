package interfaces;

public interface INodo<T> {
    T getDato();
    void setDato(T dato);
    String getId();
}