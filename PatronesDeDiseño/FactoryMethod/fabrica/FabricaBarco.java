package FactoryMethod.fabrica;

import FactoryMethod.transporte.Barco;
import FactoryMethod.transporte.Transporte;

public class FabricaBarco extends FabricaTransporte{
   @Override
    public Transporte crearTransporte(String carga) {
        return new Barco(carga);   // Decide crear un Barco
    } 
}
