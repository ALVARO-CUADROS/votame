package Entidades;

public class EntUsuario {

    public static String NombreUsuario;
    public static String Clave;
    public static String TipoUsuario;
    
    public static String Nombres;
    public static String Apellidos;
    public static String Email;
    public static String Telefono;
    public static String Celular1;
    public static String Ciudad;
    public static String Estado;
    

    public EntUsuario() {
    }

    public String getNombreUsuario() {

        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {

        this.NombreUsuario = NombreUsuario;

    }

    public String getClave() {

        return Clave;
    }

    public void setClave(String Clave) {


        this.Clave = Clave;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {

        this.TipoUsuario = TipoUsuario;
    }


    public String getNombres() {

        return Nombres;
    }

    public void setNombres(String Nombres) {

        this.Nombres = Nombres;
    }

    public String getApellidos() {

        return Apellidos;
    }

    public void setApellidos(String Apellidos) {

        this.Apellidos = Apellidos;
    }
    public String getEmail() {

        return Email;
    }

    public void setEmail(String Email) {

        this.Email=Email;
    }
    public String getTelefono() {

        return Telefono;
    }

    public void setTelefono(String Telefono) {

        this.Telefono = Telefono;
    }

    public String getCelular1() {

        return Celular1;
    }

    public void setCelular1(String Celular1) {

        this.Celular1 = Celular1;
    }

    public String getCiudad() {

        return Ciudad;
    }

    public void setCiudad(String Ciudad) {

        this.Ciudad = Ciudad;
    }
    
        public String getEstado() {

        return Estado;
    }

    public void setEstado(String Estado) {

        this.Estado = Estado;
    }

    

}
