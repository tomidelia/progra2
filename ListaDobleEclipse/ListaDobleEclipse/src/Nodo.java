public class Nodo implements INodo {
    private int info;
    private INodo siguiente;
    private INodo anterior;

    public Nodo(int info) {
        this.info = info;
        this.siguiente = null;
        this.anterior = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public INodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(INodo nodo) {
        this.siguiente = nodo;
    }

    public INodo getAnterior() {
        return anterior;
    }

    public void setAnterior(INodo nodo) {
        this.anterior = nodo;
    }
}