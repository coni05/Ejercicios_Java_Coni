package SistemaVehiculo;
public class Moto extends Vehiculo {
    
    public Moto(String matricula, String marca, String modelo, int velocidad){
        super(matricula, marca, modelo, velocidad);
    }

    @Override
    public void acelerar(){
        if (getVelocidad() + 80 <= 200) {
            
            System.out.println("El vehículo acelero ...Nueva velocidad " + getVelocidad() + " km/h");
        }else{
            System.out.println("El vehículo No puede sobrepasar los 200 km/h");
        }
    }
}
