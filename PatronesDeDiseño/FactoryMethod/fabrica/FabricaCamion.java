package FactoryMethod.fabrica;

import FactoryMethod.transporte.Camion;
import FactoryMethod.transporte.Transporte;

public class FabricaCamion extends FabricaTransporte{
     @Override
    public Transporte crearTransporte(String carga) {
        return new Camion(carga);  // Decide crear un Camión
    }
}
