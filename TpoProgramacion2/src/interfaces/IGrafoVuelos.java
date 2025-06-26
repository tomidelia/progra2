package interfaces;

import modelo.Aeropuerto;
import modelo.TipoPeso;
import java.util.List;

public interface IGrafoVuelos {
    void agregarAeropuerto(Aeropuerto a);
    void agregarVuelo(modelo.Vuelo v);
    List<Aeropuerto> dijkstra(String origen, String destino, TipoPeso criterio);
}