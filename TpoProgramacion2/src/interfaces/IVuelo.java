package interfaces;

import modelo.Aeropuerto;

public interface IVuelo {
    Aeropuerto getOrigen();
    Aeropuerto getDestino();
    double getCosto();
    double getDuracion();
}