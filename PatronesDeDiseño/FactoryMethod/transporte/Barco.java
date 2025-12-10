package FactoryMethod.transporte;

public class Barco implements Transporte{
   private final String carga;

    public Barco(String carga) {
        this.carga = carga;
    }

    @Override
    public void entregar() {
        System.out.println("Entregando '" + carga + "' por mar (vía barco).");
    }

    @Override
    public String obtenerTipo() {
        return "Barco";
    } 
}
