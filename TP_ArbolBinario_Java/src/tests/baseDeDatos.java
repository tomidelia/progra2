package tests;

import modelo.Persona;

public class baseDeDatos {
    public static Persona[] obtenerPersonas() {
        return new Persona[]{
            new Persona(12345678, "Ana"),
            new Persona(23456789, "Luis"),
            new Persona(34567890, "María"),
            new Persona(45678901, "Carlos"),
            new Persona(56789012, "Sofía"),
            new Persona(67890123, "Miguel"),
            new Persona(78901234, "Lucía"),
            new Persona(89012345, "Javier"),
            new Persona(90123456, "Valentina"),
            new Persona(11223344, "Pedro"),
            new Persona(22334455, "Martina"),
            new Persona(33445566, "Facundo"),
            new Persona(44556677, "Elena"),
            new Persona(55667788, "Tomás"),
            new Persona(66778899, "Camila")
        };
    }

	
}
