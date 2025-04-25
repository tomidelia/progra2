public class Lista implements ILista {
    private INodo primero;
    private INodo ultimo;

    public void inicializar() {
        primero = null;
        ultimo = null;
    }

    public void agregar(int valor) {
        INodo nuevo = new Nodo(valor);
        if (ultimo == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    public void eliminar(int valor) {
        INodo actual = primero;
        while (actual != null) {
            if (actual.getInfo() == valor) {
                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                } else {
                    primero = actual.getSiguiente();
                }
                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                } else {
                    ultimo = actual.getAnterior();
                }
                break;
            }
            actual = actual.getSiguiente();
        }
    }

    public void imprimirDesdeInicio() {
        INodo actual = primero;
        while (actual != null) {
            System.out.print(actual.getInfo() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    public void imprimirDesdeFin() {
        INodo actual = ultimo;
        while (actual != null) {
            System.out.print(actual.getInfo() + " ");
            actual = actual.getAnterior();
        }
        System.out.println();
    }
}