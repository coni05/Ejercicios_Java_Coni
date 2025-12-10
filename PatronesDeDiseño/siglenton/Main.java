package siglenton;

public class Main {
    public static void main(String[] args) {
        // Obtenemos la instancia única (varias veces)
        ConfiguracionApp config1 = ConfiguracionApp.obtenerInstancia();
        ConfiguracionApp config2 = ConfiguracionApp.obtenerInstancia();

        System.out.println("¿Son la misma instancia? " + (config1 == config2)); // true

        config1.establecerIdioma("en-US");
        config1.establecerTema("claro");

        // Ambas referencias apuntan al mismo objeto
        System.out.println("Config2 idioma: " + config2.obtenerIdioma()); // en-US
        System.out.println("Config2 tema: " + config2.obtenerTema());       // claro
    } 
}
