package interfaces;

public interface INodo {
    IPersona getDato();
    void setDato(IPersona dato);

    INodo getIzquierda();
    void setIzquierda(INodo nodo);

    INodo getDerecha();
    void setDerecha(INodo nodo);
}

