public class Test {
    public static void main(String[] args) {
        Persona persona = new Persona("Lucía");

        persona.agregarVehiculo(1001);
        persona.agregarVehiculo(1002);
        persona.agregarVehiculo(1003);

        persona.mostrarVehiculos();
        persona.mostrarVehiculosDesdeFin();

        persona.eliminarVehiculo(1002);

        persona.mostrarVehiculos();
    }
}