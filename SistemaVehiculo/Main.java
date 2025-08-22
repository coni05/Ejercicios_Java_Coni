package SistemaVehiculo;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        ArrayList<Vehiculo> ListaVehiculo= new ArrayList<>();

        /**** Obejeto clase base ****/
        Vehiculo vehiculo = new Vehiculo("BUN107", "Toyota", "Corolla Cross (SUV)", 100);
        
        /**** Obejetos subclases ****/
        Moto moto = new Moto("BDD17E", "AKT", "Dynamic", 80);
        Auto auto = new Auto("ACD87U0", "Lamborghini", "SUV Urus",150);

        /**** Se guardan los onjetos en la lista tipo de clase base ****/
        ListaVehiculo.add(vehiculo);
        ListaVehiculo.add(moto);
        ListaVehiculo.add(auto);

        /**** Se recorre la lista y se llama el método acelerar. ****/ 
        for (Vehiculo v : ListaVehiculo) {
            v.acelerar(); 
            System.out.println("-----------------");
        }
    }
   
    

   
}
