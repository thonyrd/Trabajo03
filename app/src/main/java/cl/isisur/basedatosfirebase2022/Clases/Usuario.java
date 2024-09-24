package cl.isisur.basedatosfirebase2022.Clases;

public class Usuario {
    private String idUsuario;
    private String nombre;
    private String email;


    public Usuario()
    {
        this.idUsuario="";
        this.nombre="";
        this.email="";
    }

    public Usuario( String idUsuario, String nombre, String estado )
    {
        this.idUsuario=idUsuario;
        this.nombre=nombre;
        this.email=email;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuqrio='" + idUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
