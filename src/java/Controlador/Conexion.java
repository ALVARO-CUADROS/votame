package Controlador;
import Controlador.*;
import Entidades.*;
import java.sql.*;
import javax.jms.Session;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Conexion {   
    Connection conn= null;
    Statement stmt= null;
    Statement stmtdos= null;
    ResultSet rs= null;
    
    Entidades.rutina rut=new rutina();
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    DefaultTableModel dtm;
    

  public boolean crearConexion()
    {
     try{
         Class.forName("com.mysql.jdbc.Driver");
         String user="alvaro";
         String pass="alvaro";
         conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gimnasiod",user ,pass);
         if (conn!=null)
         {
             System.out.println("conecto");
         }
         else
         {
             System.out.println("No conecto");
         }
     }catch(SQLException ex){
        ex.printStackTrace();
        return false;
     }
     catch(ClassNotFoundException ex){
         ex.printStackTrace();
         return false;
     }
     return true;
    }

    public void Rutina()
    {    
    try{
       crearConexion();
       stmt=conn.createStatement();
       String consulta;
       consulta="SELECT * FROM rutina";
       System.out.println(consulta);
       Statement query = conn.createStatement();
       ResultSet rs=query.executeQuery(consulta);

       while (rs.next()) 
       {
           contador++;
           System.out.println(rs.getString("RutinaID"));
           System.out.println(rs.getString("FechaInicio"));
           System.out.println(rs.getString("Duracion"));
           System.out.println(rs.getString("Regularidad"));
           System.out.println(rs.getString("NumeroSeries"));
           System.out.println(rs.getString("Distancia"));
           System.out.println(rs.getString("Velocidad"));
           System.out.println(rs.getString("Ponderacion"));
       }

       if (contador>0)
       {
            System.out.println("datos!");
        }
       else if (contador==0)
       {
            System.out.println("no datos");

        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
    }

    public boolean RegistrarRutina(String id, String fecha, String dura, String reg, String nseries, String dista, String velo, String ponde)
    {    
    try{
        
        int cantafe;
        crearConexion();
        stmt=conn.createStatement();
        String regis="INSERT INTO rutina (RutinaId, FechaInicio, Duracion, Regularidad, NumeroSeries, Distancia, Velocidad , Ponderacion, Estado) VALUES('"+id+"','"+fecha+"','"+dura+"','"+reg+"','"+nseries+"','"+dista+"','"+velo+"','"+ponde+"', 1)";
        System.out.println(regis);
        
        stmt.executeUpdate(regis);
        cantafe=stmt.getUpdateCount();

        if (cantafe>0)
        {
            System.out.println("Registrado con éxito!");
            return true;
        }
        else if(cantafe==0)
        {
            System.out.println("No se ha podido Registrar");
            return false;
        }
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
        return false;
    }
  
    public boolean RegistrarUsuario(String NombreUsuario, String Clave, String Tipo, String Nombres, String Apellidos, String Email, String Telefono, String Celular, String Ciudad)
    {    
    try{
        
        int cantafe;
        crearConexion();
        stmt=conn.createStatement();
        String regis="INSERT INTO usuarios (NombreUsuario, Clave, TipoUsuario, Nombres, Apellidos, Email, Telefono , Celular1, Ciudad, Estado) VALUES('"+NombreUsuario+"','"+Clave+"','"+Tipo+"','"+Nombres+"','"+Apellidos+"','"+Email+"','"+Telefono+"','"+Celular+"','"+Ciudad+"', 'Activo')";
        System.out.println(regis);
        
        stmt.executeUpdate(regis);
        cantafe=stmt.getUpdateCount();

        if (cantafe>0)
        {
            System.out.println("Registrado con éxito!");
            return true;
        }
        else if(cantafe==0)
        {
            System.out.println("No se ha podido Registrar");
            return false;
        }
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
        return false;
    }
  
    public boolean RegistrarSeg(String PerfilId, String NumeroDocumento, String RutinaId, String FechaPerfil, String Estatura, String Peso, String HombrosMedida, String EspaldaMedida, String PechosMedida, String BrazosMedida, String AbdomenMedida, String PiernasMedida, String MedidaPantorillas, String EvaluacionMedica, String PorcentajeGrasaCorporal, String IndiceMasaCorporal)
    {    
    try{
        
        int cantafe;
        crearConexion();
        stmt=conn.createStatement();
        String regis="INSERT INTO seguimiento (PerfilId, NumeroDocumento, RutinaId, FechaPerfil, Estatura, Peso, HombrosMedida, EspaldaMedida, PechosMedida, BrazosMedida, AbdomenMedida, PiernasMedida, MedidaPantorillas, EvaluacionMedica, PorcentajeGrasaCorporal, IndiceMasaCorporal, Estado) VALUES('"+PerfilId+"','"+NumeroDocumento+"','"+RutinaId+"','"+FechaPerfil+"','"+Estatura+"','"+Peso+"','"+HombrosMedida+"','"+EspaldaMedida+"','"+PechosMedida+"', '"+BrazosMedida+"', '"+AbdomenMedida+"', '"+PiernasMedida+"', '"+MedidaPantorillas+"', '"+EvaluacionMedica+"', '"+PorcentajeGrasaCorporal+"', '"+IndiceMasaCorporal+"','1')";
        System.out.println(regis);
        
        stmt.executeUpdate(regis);
        cantafe=stmt.getUpdateCount();

        if (cantafe>0)
        {
            System.out.println("Registrado con éxito!");
            return true;
        }
        else if(cantafe==0)
        {
            System.out.println("No se ha podido Registrar");
            return false;
        }
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
        return false;
    }
  
    public boolean RegistrarD(Deportista dep, String ID){    
    try{
        
        int cantafe;
        crearConexion();
        stmt=conn.createStatement();
        String regis="INSERT INTO deportista (TipoDocumento, NumeroDocumento, Nombres, Apellidos, NombreUsuario, Contrasena, Telefono, Celular, email, Direccion, Barrio, Genero, Estado, FechaNacimiento, FechaIngreso, Ocupacion) "
                + "VALUES('"+dep.getTipoDocumento()+"','"+dep.getNumeroDocumento()+"','"+dep.getNombres()+"','"+dep.getApellidos()+"','"+dep.getNombreUsuario()+"','"+dep.getContrasena()+"','"+dep.getTelefono()+"','"+dep.getCelular()+"','"+dep.getEmail()+"', '"+dep.getDireccion()+"', '"+dep.getBarrio()+"', '"+dep.getGenero()+"', '1', '"+dep.getFechaNacimiento()+"', '"+dep.getFechaIngreso()+"', '"+dep.getOcupacion()+"')";
        System.out.println(regis);
        
        stmt.executeUpdate(regis);
        cantafe=stmt.getUpdateCount();

        if (cantafe>0)
        {
            System.out.println("Registrado con éxito!");
            return true;
        }
        else if(cantafe==0)
        {
            System.out.println("No se ha podido Registrar");
            return false;
        }
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
        return false;
    }
  
  int contador = 0;
  public int InicioSesion(String user, String pas)
    {    
    try{
       stmt=conn.createStatement();
       String consulta;
       consulta="SELECT * FROM usuarios WHERE NombreUsuario='"+user+"' and Clave='"+pas+"'";
       System.out.println(consulta);
       String tipo = null;
       Statement query = conn.createStatement();
       ResultSet rs=query.executeQuery(consulta);
       
       while (rs.next()) 
       {
       contador++;
       tipo=rs.getString("TipoUsuario");
       }
       System.out.println(tipo);
       conectadorol ro=new conectadorol();
       
       ro.setRol(tipo);
       if (contador>0)
       {
            System.out.println("El usuario SI existe!");
            return contador;
        }
       else if (contador==0)
       {
            System.out.println("El usuario NO existe");
            return contador;
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
        return contador;
    }
  
    public boolean EliminarRutina(String id)
    {
        try{
            crearConexion();
            int cantidadafectadas;
            stmt=conn.createStatement();
            String consultaelimina="UPDATE rutina SET Estado=0 WHERE RutinaId='"+id+"'";
            System.out.println(consultaelimina); 
            stmt.executeUpdate(consultaelimina);
            cantidadafectadas=stmt.getUpdateCount();
            if (cantidadafectadas==0)
            {
               System.out.println("No se ha podido eliminar");
               return false;
            }
            else 
            {
               System.out.println("Se ha eliminado con éxito!");
               return true;
            }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        return false;
    }
    
    public boolean EliminarUsuario(String id)
    {
        try{
            crearConexion();
            int cantidadafectadas;
            stmt=conn.createStatement();
            String consultaelimina="UPDATE usuarios SET Estado='Inactivo' WHERE NombreUsuario='"+id+"'";
            System.out.println(consultaelimina); 
            stmt.executeUpdate(consultaelimina);
            cantidadafectadas=stmt.getUpdateCount();
            if (cantidadafectadas==0)
            {
               System.out.println("No se ha podido eliminar");
               return false;
            }
            else 
            {
               System.out.println("Se ha eliminado con éxito!");
               return true;
            }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        return false;
    }
    
    public boolean EliminarSeg(String id)
    {
        try{
            crearConexion();
            int cantidadafectadas;
            stmt=conn.createStatement();
            String consultaelimina="UPDATE seguimiento SET Estado='0' WHERE PerfilId='"+id+"'";
            System.out.println(consultaelimina); 
            stmt.executeUpdate(consultaelimina);
            cantidadafectadas=stmt.getUpdateCount();
            if (cantidadafectadas==0)
            {
               System.out.println("No se ha podido eliminar");
               return false;
            }
            else 
            {
               System.out.println("Se ha eliminado con éxito!");
               return true;
            }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        return false;
    }
    
    public boolean EliminarD(String id)
    {
        try{
            crearConexion();
            int cantidadafectadas;
            stmt=conn.createStatement();
            String consultaelimina="UPDATE deportista SET Estado='0' WHERE NumeroDocumento='"+id+"'";
            System.out.println(consultaelimina); 
            stmt.executeUpdate(consultaelimina);
            cantidadafectadas=stmt.getUpdateCount();
            if (cantidadafectadas==0)
            {
               System.out.println("No se ha podido eliminar");
               return false;
            }
            else 
            {
               System.out.println("Se ha eliminado con éxito!");
               return true;
            }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        return false;
    }

    public boolean ConsultarModificar(String id)
    {
        String FechaInicio = null;
        String Duracion = null;
        String Regularidad= null;
        String NumeroSeries= null;
        String Distancia= null;
        String Velocidad= null;
        String Ponderacion= null;
        try{  
            crearConexion();
            stmt=conn.createStatement();
            String pregunta="SELECT * FROM rutina WHERE RutinaId='"+id+"'";
            System.out.println(pregunta); 
 
            Statement query = conn.createStatement();
            ResultSet rs=query.executeQuery(pregunta);
            while(rs.next())
            {
                FechaInicio=rs.getString("FechaInicio");
                Duracion=rs.getString("Duracion");
                Regularidad=rs.getString("Regularidad");
                NumeroSeries=rs.getString("NumeroSeries");
                Distancia=rs.getString("Distancia");
                Velocidad=rs.getString("Velocidad");
                Ponderacion=rs.getString("Ponderacion");
                                            
            }
            
            rutina rut=new rutina();
            rut.setId(id);
            rut.setFecha(FechaInicio);
            rut.setDur(Duracion);
            rut.setRegu(Regularidad);
            rut.setNseries(NumeroSeries);
            rut.setDista(Distancia);
            rut.setVelo(Velocidad);
            rut.setPode(Ponderacion);
 
        }catch(SQLException e){
        System.out.println("SQl Exception :"+ e.getMessage() );
    }finally {
        try{
            if(stmt !=null){stmt.close();}
        }catch(SQLException e){};
    }
        
        return true;
    }
    
    public boolean ConsultarModificarU(String id)
    {
        String NombreUsuario = null;
        String Clave = null;
        String TipoUsuario= null;
        String Nombres= null;
        String Apellidos= null;
        String Email= null;
        String Telefono= null;
        String Celular= null;
        String Ciudad= null;
        try{  
            crearConexion();
            stmt=conn.createStatement();
            String pregunta="SELECT * FROM usuarios WHERE NombreUsuario='"+id+"'";
            System.out.println(pregunta); 
 
            Statement query = conn.createStatement();
            ResultSet rs=query.executeQuery(pregunta);
            while(rs.next())
            {
                NombreUsuario=rs.getString("NombreUsuario");
                Clave=rs.getString("Clave");
                TipoUsuario=rs.getString("TipoUsuario");
                Nombres=rs.getString("Nombres");
                Apellidos=rs.getString("Apellidos");
                Email=rs.getString("Email");
                Telefono=rs.getString("Telefono");
                Celular=rs.getString("Celular1");
                Ciudad=rs.getString("Ciudad");
            }
            
            EntUsuario u=new EntUsuario();
            u.setNombreUsuario(NombreUsuario);
            u.setClave(Clave);
            u.setTipoUsuario(TipoUsuario);
            u.setNombres(Nombres);
            u.setApellidos(Apellidos);
            u.setEmail(Email);
            u.setTelefono(Telefono);
            u.setCelular1(Celular);
            u.setCiudad(Ciudad);
 
        }catch(SQLException e){
        System.out.println("SQl Exception :"+ e.getMessage() );
    }finally {
        try{
            if(stmt !=null){stmt.close();}
        }catch(SQLException e){};
    }
        
        return true;
    }
    
    public boolean ConsultarModificarSeg(String id)
    {
        String NumeroDocumento=null;
        String RutinaId=null;
        String FechaPerfil=null;
        String Estatura=null;
        String Peso=null;
        String HombrosMedida=null;
        String EspaldaMedida=null;
        String PechosMedida=null;
        String BrazosMedida=null;
        String AbdomenMedida=null;
        String PiernasMedida=null;
        String MedidaPantorillas=null;
        String EvaluacionMedica=null;
        String PorcentajeGrasaCorporal=null;
        String IndiceMasaCorporal=null;
        String Estado=null;
        
        try{  
            crearConexion();
            stmt=conn.createStatement();
            String pregunta="SELECT * FROM seguimiento WHERE PerfilId='"+id+"'";
            System.out.println(pregunta); 
 
            Statement query = conn.createStatement();
            ResultSet rs=query.executeQuery(pregunta);
            while(rs.next())
            {
                NumeroDocumento=rs.getString("NumeroDocumento");
                RutinaId=rs.getString("RutinaId");
                FechaPerfil=rs.getString("FechaPerfil");
                Estatura=rs.getString("Estatura");
                Peso=rs.getString("Peso");
                HombrosMedida=rs.getString("HombrosMedida");
                EspaldaMedida=rs.getString("EspaldaMedida");
                PechosMedida=rs.getString("PechosMedida");
                BrazosMedida=rs.getString("BrazosMedida");
                /*llega*/
                AbdomenMedida=rs.getString("AbdomenMedida");
                PiernasMedida=rs.getString("PiernasMedida");
                MedidaPantorillas=rs.getString("MedidaPantorillas");
                EvaluacionMedica=rs.getString("EvaluacionMedica");
                PorcentajeGrasaCorporal=rs.getString("PorcentajeGrasaCorporal");
                IndiceMasaCorporal=rs.getString("IndiceMasaCorporal");
                Estado=rs.getString("Estado");
            }
                seguimiento segui=new seguimiento();
                
                segui.setNumeroDocumento(NumeroDocumento);
                segui.setRutinaId(RutinaId);
                segui.setFechaPerfil(FechaPerfil);
                segui.setEstatura(Estatura);
                segui.setPeso(Peso);
                segui.setHombrosMedida(HombrosMedida);
                segui.setEspaldaMedida(EspaldaMedida);
                segui.setPechosMedida(PechosMedida);
                segui.setBrazosMedida(BrazosMedida);
                segui.setAbdomenMedida(AbdomenMedida);

                segui.setPiernasMedida(PiernasMedida);
                segui.setMedidaPantorillas(MedidaPantorillas);
                segui.setEvaluacionMedica(EvaluacionMedica);
                segui.setPorcentajeGrasaCorporal(PorcentajeGrasaCorporal);
                segui.setIndiceMasaCorporal(IndiceMasaCorporal);
                segui.setEstado(Estado);
 
        }catch(SQLException e){
        System.out.println("SQl Exception :"+ e.getMessage() );
    }finally {
        try{
            if(stmt !=null){stmt.close();}
        }catch(SQLException e){};
    }
        
        return true;
    }
    
    public boolean ConsultarModificarD(String id)
    {
        String TipoDocumento=null;
        String NumeroDocumento=null;
        String Nombres=null;
        String Apellidos=null;
        
        String NombreUsuario=null;
        String Contrasena=null;
        String Telefono=null;
        String Celular=null;
        
        String email=null;
        String Direccion=null;
        String Barrio=null;
        String Genero=null;
        
        String Estado=null;
        String FechaNacimiento=null;
        String FechaIngreso=null;
        String Ocupacion=null;
        
        try{  
            crearConexion();
            stmt=conn.createStatement();
            String pregunta="SELECT * FROM deportista WHERE NumeroDocumento='"+id+"'";
            System.out.println(pregunta); 
 
            Statement query = conn.createStatement();
            ResultSet rs=query.executeQuery(pregunta);
            while(rs.next())
            {
                TipoDocumento=rs.getString("TipoDocumento");
                NumeroDocumento=rs.getString("NumeroDocumento");
                Nombres=rs.getString("Nombres");
                Apellidos=rs.getString("Apellidos");
                
                NombreUsuario=rs.getString("NombreUsuario");
                Contrasena=rs.getString("Contrasena");
                Telefono=rs.getString("Telefono");
                Celular=rs.getString("Celular");
                
                email=rs.getString("email");
                Direccion=rs.getString("Direccion");
                Barrio=rs.getString("Barrio");
                Genero=rs.getString("Genero");
                
                Estado=rs.getString("Estado");
                FechaNacimiento=rs.getString("FechaNacimiento");
                FechaIngreso=rs.getString("FechaIngreso");
                Ocupacion=rs.getString("Ocupacion");
            }
                Deportista d=new Deportista();
                
                d.setTipoDocumento(TipoDocumento);
                d.setNumeroDocumento(NumeroDocumento);
                d.setNombres(Nombres);
                d.setApellidos(Apellidos);
                
                d.setNombreUsuario(NombreUsuario);
                d.setContrasena(Contrasena);
                d.setTelefono(Telefono);d.setCelular(Celular);
                d.setEmail(email);
                
                d.setDireccion(Direccion);
                d.setBarrio(Barrio);
                d.setGenero(Genero);
                d.setEstado(Estado);
                
                d.setFechaNacimiento(FechaNacimiento);
                d.setFechaIngreso(FechaIngreso);
                d.setOcupacion(Ocupacion);
                
 
        }catch(SQLException e){
        System.out.println("SQl Exception :"+ e.getMessage() );
    }finally {
        try{
            if(stmt !=null){stmt.close();}
        }catch(SQLException e){};
    }
        
        return true;
    }
    
    public boolean ModificarRutina(String id, String fecha, String dura, String reg, String nseries, String dista, String velo, String ponde)
    {    
    try{
        
        int cantafe;
        crearConexion();
        stmt=conn.createStatement();
        String cadenita;
        String actualizar="UPDATE rutina SET FechaInicio='"+fecha+"',Duracion='"+dura+"', Regularidad='"+reg+"', NumeroSeries='"+nseries+"' ,Distancia='"+dista+"' ,Velocidad='"+velo+"' ,Ponderacion='"+ponde+"' WHERE RutinaId='"+id+"'";
        System.out.println(actualizar);
        
        stmt.executeUpdate(actualizar);
        cantafe=stmt.getUpdateCount();
        
        if (cantafe>0)
        {
            System.out.println("Modificado con éxito!");
            return true;
        }
        else if(cantafe==0)
        {
            System.out.println("No se ha podido modificar");
            return false;
        }
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
        return false;
    }
    
    public boolean ModificarUsuario(String NombreUsuario, String Clave, String Tipo, String Nombres, String Apellidos, String Email, String Telefono, String Celular, String Ciudad)
    {    
    try{
        
        int cantafe;
        crearConexion();
        stmt=conn.createStatement();
        String cadenita;
        String actualizar="UPDATE usuarios SET NombreUsuario='"+NombreUsuario+"', Clave='"+Clave+"', TipoUsuario='"+Tipo+"', Nombres='"+Nombres+"', Apellidos='"+Apellidos+"', Email='"+Email+"', Telefono='"+Telefono+"', Celular1='"+Celular+"', Ciudad='"+Ciudad+"' WHERE NombreUsuario='"+NombreUsuario+"'";
        System.out.println(actualizar);
        
        stmt.executeUpdate(actualizar);
        cantafe=stmt.getUpdateCount();
        
        if (cantafe>0)
        {
            System.out.println("Modificado con éxito!");
            return true;
        }
        else if(cantafe==0)
        {
            System.out.println("No se ha podido modificar");
            return false;
        }
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
        return false;
    }
    
    public boolean ModificarSeg(String PerfilId, String NumeroDocumento, String RutinaId, String FechaPerfil, String Estatura, String Peso, String HombrosMedida, String EspaldaMedida, String PechosMedida, String BrazosMedida, String AbdomenMedida, String PiernasMedida, String MedidaPantorillas, String EvaluacionMedica, String PorcentajeGrasaCorporal, String IndiceMasaCorporal)
    {    
    try{
        
        int cantafe;
        crearConexion();
        stmt=conn.createStatement();
        String cadenita;
        String actualizar="UPDATE seguimiento SET NumeroDocumento='"+NumeroDocumento+"', RutinaId='"+RutinaId+"', FechaPerfil='"+FechaPerfil+"', Estatura='"+Estatura+"', Peso='"+Peso+"', HombrosMedida='"+HombrosMedida+"', EspaldaMedida='"+EspaldaMedida+"', PechosMedida='"+PechosMedida+"', BrazosMedida='"+BrazosMedida+"', AbdomenMedida='"+AbdomenMedida+"', PiernasMedida='"+PiernasMedida+"', MedidaPantorillas='"+MedidaPantorillas+"', EvaluacionMedica='"+EvaluacionMedica+"', PorcentajeGrasaCorporal='"+PorcentajeGrasaCorporal+"', IndiceMasaCorporal='"+IndiceMasaCorporal+"' WHERE PerfilId='"+PerfilId+"'";
        System.out.println(actualizar);
        
        stmt.executeUpdate(actualizar);
        cantafe=stmt.getUpdateCount();
        
        if (cantafe>0)
        {
            System.out.println("Modificado con éxito!");
            return true;
        }
        else if(cantafe==0)
        {
            System.out.println("No se ha podido modificar");
            return false;
        }
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
        return false;
    }
    
    public boolean ModificarD(Deportista dep, String ID)
    {    
    try{
        
        int cantafe;
        crearConexion();
        stmt=conn.createStatement();
        String cadenita;
        String actualizar="UPDATE deportista SET TipoDocumento='"+dep.getTipoDocumento()+"', Nombres='"+dep.getNombres()+"', Apellidos='"+dep.getApellidos()+"', NombreUsuario='"+dep.getNombreUsuario()+"', Contrasena='"+dep.getContrasena()+"', Telefono='"+dep.getTelefono()+"', Celular='"+dep.getCelular()+"', email='"+dep.getEmail()+"', Direccion='"+dep.getDireccion()+"', Barrio='"+dep.getBarrio()+"', Genero='"+dep.getGenero()+"', FechaNacimiento='"+dep.getFechaNacimiento()+"', FechaIngreso='"+dep.getFechaIngreso()+"', Ocupacion='"+dep.getOcupacion()+"' WHERE NumeroDocumento='"+ID+"'";
        System.out.println(actualizar);
        
        stmt.executeUpdate(actualizar);
        cantafe=stmt.getUpdateCount();
        
        if (cantafe>0)
        {
            System.out.println("Modificado con éxito!");
            return true;
        }
        else if(cantafe==0)
        {
            System.out.println("No se ha podido modificar");
            return false;
        }
        
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
        return false;
    }

}
