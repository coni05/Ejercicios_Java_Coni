package FactoryMethod;

import FactoryMethod.fabrica.FabricaBarco;
import FactoryMethod.fabrica.FabricaCamion;

public class Main {
    public static void main(String[] args) {
        // Usamos fábricas concretas (sin depender de clases específicas)
        FabricaCamion fabricaCamion = new FabricaCamion();
        FabricaBarco fabricaBarco = new FabricaBarco();

        fabricaCamion.planificarEntrega("Electrodomésticos");
        fabricaBarco.planificarEntrega("Contenedores industriales");
    }
}
