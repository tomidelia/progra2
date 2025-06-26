package modelo;

public class Aeropuerto {
    private String codigo;
    private String nombre;
    private String pais;

    public Aeropuerto(String codigo, String nombre, String pais) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getPais() { return pais; }

    @Override
    public String toString() {
        return nombre + " (" + codigo + "), " + pais;
    }
}