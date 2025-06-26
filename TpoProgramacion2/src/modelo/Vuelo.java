package modelo;

public class Vuelo {
    private Aeropuerto origen;
    private Aeropuerto destino;
    private double costo;
    private double duracion;

    public Vuelo(Aeropuerto origen, Aeropuerto destino, double costo, double duracion) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
        this.duracion = duracion;
    }

    public Aeropuerto getOrigen() { return origen; }
    public Aeropuerto getDestino() { return destino; }
    public double getCosto() { return costo; }
    public double getDuracion() { return duracion; }
}