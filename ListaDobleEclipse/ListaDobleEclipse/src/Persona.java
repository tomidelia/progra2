public class Persona {
    private String nombre;
    private ILista vehiculos;

    public Persona(String nombre) {
        this.nombre = nombre;
        vehiculos = new Lista();
        vehiculos.inicializar();
    }

    public void agregarVehiculo(int patente) {
        vehiculos.agregar(patente);
    }

    public void eliminarVehiculo(int patente) {
        vehiculos.eliminar(patente);
    }

    public void mostrarVehiculos() {
        System.out.println("Vehículos de " + nombre + ":");
        vehiculos.imprimirDesdeInicio();
    }

    public void mostrarVehiculosDesdeFin() {
        System.out.println("Vehículos de " + nombre + " desde el final:");
        vehiculos.imprimirDesdeFin();
    }
}