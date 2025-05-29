package interfaces;

public interface IArbol {
    void insertar(IPersona persona, boolean porDni);
    void inOrden();
    void preOrden();
    void postOrden();

    void eliminar(int dni);
    public boolean buscar(int dni);
}
