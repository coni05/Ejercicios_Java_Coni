package model;

public class Marca {
    private Long id_marca;
    private String nombre;
    private String pais_origen;
    private String descripcion;

    public Marca(String nombre,String pais_origen, String descripcion){
        this.nombre = nombre;
        this.pais_origen = pais_origen;
        this.descripcion = descripcion;
    }

    public Marca(Long id_marca, String nombre,String pais_origen, String descripcion){
        this.id_marca = id_marca;
        this.nombre = nombre;
        this.pais_origen = pais_origen;
        this.descripcion = descripcion;
    }

    public Long getId_Marca(){
        return id_marca;
    }

    public String getNombre(){
        return nombre;
    }

    public String getPais_Origen(){
        return pais_origen;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setId_Marca(Long id_marca){
        this.id_marca = id_marca;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPais_Origen(String pais_origen){
        this.pais_origen = pais_origen;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

     @Override
    public String toString() {
        return "Marca{" +
                "idMarca=" + id_marca +
                ", nombre='" + nombre + '\'' +
                ", paisOrigen='" + pais_origen + '\'' +
                ", descripcion='" + descripcion + '\''  +
                '}';
    }
}
