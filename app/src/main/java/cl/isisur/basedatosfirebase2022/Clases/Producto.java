package cl.isisur.basedatosfirebase2022.Clases;

public class Producto {
    private String idProducto;
    private String nombre;
    private String precio;


    public Producto() {
        this.idProducto="";
        this.nombre="";
        this.precio="";
    }


    public Producto(String idProducto, String nombre, String precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }


    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}

