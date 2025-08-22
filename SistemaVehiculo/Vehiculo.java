package SistemaVehiculo;

public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private int velocidad;

    public Vehiculo(String matricula, String marca, String modelo, int velocidad){
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }

    /************ Getter y Setter *************/

    /****/
    public String getMatrula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
            this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {    
        this.modelo = modelo;
    }

    public int getVelocidad(){
        return velocidad;
    }

    public void setVelocidad(int velocidad) {    
        this.velocidad = velocidad;
    }


    /****** Metodo para mostrar los datos *******/

    public void mostrarDatos(){
        System.out.println("Matricula: " + getMatrula());
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo() );
        System.out.println("Velocidad Inicial:"  + getVelocidad() + " km/h");
    }

    /****** Metodo para simular aceleración *******/

    public void acelerar(){
        if (velocidad + 50 < 200) {
        
            System.out.println("El vehículo acelero ...Nueva velocidad " + getVelocidad() + " km/h");
        }else{
            velocidad = 200;
            System.out.println("El vehículo ya alcanzó la velocidad máxima de 200 km/h.");
        }
    }
}


