package FactoryMethod.transporte;

public class Camion implements Transporte{
    private final String carga;

    public Camion(String carga) {
        this.carga = carga;
    }

    @Override
    public void entregar() {
        System.out.println("Entregando '" + carga + "' por carretera (vía camión).");
    }

    @Override
    public String obtenerTipo() {
        return "Camión";
    }
}
