package Persistencia;



public class UsuarioSqlHelper {


    
    
    public static String Autenticar() {
        return "SELECT * FROM usuarios where NombreUsuario = ? and Clave = ?";
    }
    
    public static String Crear() {
        return "insert into usuarios (NombreUsuario, Clave, TipoUsuario, Nombres, Apellidos, Email,Telefono, Celular1, Ciudad, Estado) values(?,?,?,?,?,?,?,?,?,?)";
    }

     public static String Modificar() {
        return "update usuarios set Clave=?, TipoUsuario=?, Nombres=?, Apellidos=?,Email=?, Telefono=?, Celular1=?, Ciudad=?, Estado=? where NombreUsuario=? ";
    }


     public static String Buscar(String NombreUsuario) {
        return "select * from usuarios where NombreUsuario='"+NombreUsuario+"'";
    }

    public static String Eliminar() {
     return "delete from usuarios where  NombreUsuario= ?";
   
    }
    
    public static String getUsuarios(){
		return "  Select NombreUsuario, Clave, TipoUsuario, Email, Nombres, Apellidos, Telefono, Celular1, Ciudad, Estado From usuarios order by  NombreUsuario";
	}
}