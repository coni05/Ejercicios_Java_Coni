package model;

public class Bicicleta {
    private Long id_bicicleta;
    private String modelo;
    private String tipo;
    private String talla;
    private String color;
    private String descripcion;
    private Double precio;
    private Long cantidad_stock;
    private Long stock_minimo;
    private Long id_marca;

    public Bicicleta(String modelo, String tipo, String talla, String color, String descripcion, 
    Double precio, Long cantidad_stock, Long stock_minimo, Long id_marca){

        this.modelo = modelo;
        this.tipo = tipo;
        this.talla = talla;
        this.color = color;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad_stock = cantidad_stock;
        this.stock_minimo = stock_minimo;
        this.id_marca = id_marca;
    }

    public Bicicleta(Long id_bicicleta, String modelo, String tipo, String talla, String color, String descripcion, 
    Double precio, Long cantidad_stock, Long stock_minimo, Long id_marca){

        this.id_bicicleta = id_bicicleta;
        this.modelo = modelo;
        this.tipo = tipo;
        this.talla = talla;
        this.color = color;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad_stock = cantidad_stock;
        this.stock_minimo = stock_minimo;
        this.id_marca = id_marca;
    }

    public Long getId_Bicicleta(){
        return id_bicicleta;
    }

    public String getModelo(){
        return modelo;
    }

    public String getTipo(){
        return tipo;
    }

    public String getTalla(){
        return talla;
    }

    public String getColor(){
        return color;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public Double getPrecio(){
        return precio;
    }

    public Long getCantidad_Stock(){
        return cantidad_stock;
    }

    public Long getStock_Minimo(){
        return stock_minimo;
    }

    public Long getId_Marca(){
        return id_marca;
    }

    public void setId_Bicicleta(Long id_bicicleta){
        this.id_bicicleta = id_bicicleta;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setTalla(String talla){
        this.talla = talla;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public void setCantidad_Stock(Long cantidad_stock ){
        this.cantidad_stock = cantidad_stock;
    }

    public void setStock_Minimo(Long stock_minimo){
        this.stock_minimo = stock_minimo;
    }

    public void setId_Marca(Long id_marca){
        this.id_marca = id_marca;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "idBicicleta=" + id_bicicleta +
                ", modelo='" + modelo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", talla='" + talla + '\'' +
                ", color='" + color + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidadStock=" + cantidad_stock +
                ", stockMinimo=" + stock_minimo +
                ", idMarca=" + id_marca +
                '}';
    }

}
