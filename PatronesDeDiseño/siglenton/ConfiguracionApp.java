package siglenton;

public class ConfiguracionApp {
    // 1. Atributo estático privado que contiene la única instancia
    private static volatile ConfiguracionApp instanciaUnica;

    // 2. Atributos privados (encapsulamiento)
    private String idioma;
    private String tema;
    private int versionActual;

    // 3. Constructor privado (evita instanciación externa)
    private ConfiguracionApp() {
        // Valores por defecto
        this.idioma = "es-ES";
        this.tema = "oscuro";
        this.versionActual = 1;
    }

    // 4. Método público estático para obtener la única instancia (con doble revisión para seguridad en hilos)
    public static ConfiguracionApp obtenerInstancia() {
        if (instanciaUnica == null) {
            synchronized (ConfiguracionApp.class) {
                if (instanciaUnica == null) {
                    instanciaUnica = new ConfiguracionApp();
                }
            }
        }
        return instanciaUnica;
    }

    // 5. Métodos públicos para leer/modificar (con control)
    public String obtenerIdioma() {
        return idioma;
    }

    public void establecerIdioma(String idioma) {
        if (idioma != null && !idioma.trim().isEmpty()) {
            this.idioma = idioma;
        }
    }

    public String obtenerTema() {
        return tema;
    }

    public void establecerTema(String tema) {
        if ("claro".equals(tema) || "oscuro".equals(tema)) {
            this.tema = tema;
        }
    }

    public int obtenerVersionActual() {
        return versionActual;
    }

}

