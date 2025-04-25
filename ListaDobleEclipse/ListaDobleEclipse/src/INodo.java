public interface INodo {
    int getInfo();
    void setInfo(int info);
    INodo getSiguiente();
    void setSiguiente(INodo nodo);
    INodo getAnterior();
    void setAnterior(INodo nodo);
}