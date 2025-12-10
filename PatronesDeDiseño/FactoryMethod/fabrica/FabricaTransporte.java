package FactoryMethod.fabrica;

import FactoryMethod.transporte.Transporte;

public abstract class FabricaTransporte {
    // Método fábrica abstracto: las subclases deciden qué crear
    public abstract Transporte crearTransporte(String carga);

    // Lógica común reutilizable
    public void planificarEntrega(String carga) {
        Transporte transporte = crearTransporte(carga);
        System.out.println("Preparando entrega con: " + transporte.obtenerTipo());
        transporte.entregar();
        System.out.println("Entrega finalizada.\n");
    }
}
