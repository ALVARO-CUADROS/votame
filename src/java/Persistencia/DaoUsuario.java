package Persistencia;


import Entidades.EntUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Usuario
 */
public class DaoUsuario {
   public String autenticar(Connection Cone,EntUsuario usuarios){
       String sql=UsuarioSqlHelper.Autenticar();
       
       String resultado =null;
       try{
       PreparedStatement st=Cone.prepareStatement(sql);
       ResultSet rs = null; //para guardar el resultado
       st.setString(1,usuarios.getNombreUsuario());
       st.setString(2,usuarios.getClave());
       rs=st.executeQuery(); //es la que me va a guardar el resultado.. se ejecuta la sentencia sql
       
       if(rs.next()){
           resultado="1";
       }else{
           resultado="0";
           
           
            }
        }catch(SQLException ex){
        Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE,null,ex);   
        }finally{
           try{
               Cone.close();
           }catch(SQLException ex){
        Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE,null,ex);
           }
       }
       return resultado;
   }
   
   public int crear(Connection c, EntUsuario pro) {
        String sql = UsuarioSqlHelper.Crear();
        int resultadoCrear = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, pro.getNombreUsuario());
            st.setString(2, pro.getClave());
            st.setString(3, pro.getTipoUsuario());
            st.setString(4, pro.getNombres());
            st.setString(5, pro.getApellidos());
             st.setString(6, pro.getEmail());
            st.setString(7, pro.getTelefono());
            st.setString(8, pro.getCelular1());
            st.setString(9, pro.getCiudad());
            st.setString(10, pro.getEstado());

            resultadoCrear = st.executeUpdate();

        } catch (SQLException ex) {

            
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoCrear;
    }

    public List<EntUsuario> ListarUsuario(Connection con) {
        //usuario,clave, perfil, estado
        List<EntUsuario> resul = new ArrayList<EntUsuario>();
        //    c.setNombreUsuario("no existe");
        try {
            PreparedStatement p = con.prepareStatement(UsuarioSqlHelper.getUsuarios());
            ResultSet r = p.executeQuery();
            while (r.next()) {
                EntUsuario c = new EntUsuario();
                c.setNombreUsuario(r.getString(1));
                c.setClave(r.getString(2));
                c.setTipoUsuario(r.getString(3));
                c.setEmail(r.getString(4));
                c.setNombres(r.getString(5));
                c.setApellidos(r.getString(6));
                c.setTelefono(r.getString(7));
                c.setCelular1(r.getString(8));
                c.setCiudad(r.getString(9));
                c.setEstado(r.getString(10));


                resul.add(c);

            }
        } catch (Exception e) {
            e.printStackTrace();
            //    return c;

        } finally {
            try {
                con.close();
            } catch (Exception ex) {
            }

        }
        return resul;
    }

    public int modificar(Connection c, EntUsuario pro) {
        String sql = UsuarioSqlHelper.Modificar();
        int resultadoModificar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);


            
            st.setString(1, pro.getClave());
            st.setString(2, pro.getTipoUsuario());
            st.setString(4, pro.getNombres());
            st.setString(5, pro.getApellidos());
             st.setString(3, pro.getEmail());
            st.setString(6, pro.getTelefono());
            st.setString(7, pro.getCelular1());
            st.setString(8, pro.getCiudad());
            st.setString(9, pro.getEstado());
            st.setString(10, pro.getNombreUsuario());

            System.out.println("entro daos");
            st.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoModificar;
    }
    
    public int eliminar(Connection c, EntUsuario pro) {
        String sql = UsuarioSqlHelper.Eliminar();
        int resultadoEliminar = 0;
        try {
            PreparedStatement st = c.prepareStatement(sql);

            st.setString(1, pro.getNombreUsuario());

            resultadoEliminar = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultadoEliminar;
    }
    
    public EntUsuario Buscar(Connection con, String NombreUsuario) {
        EntUsuario c = new EntUsuario();
        c.setNombreUsuario("Este usuario no existe");
        try {
            PreparedStatement cl = con.prepareStatement(UsuarioSqlHelper.Buscar(NombreUsuario));
            ResultSet r = cl.executeQuery();
            while (r.next()) {
                c.setNombreUsuario(r.getString(1));
                c.setClave(r.getString(2));
                c.setTipoUsuario(r.getString(3));
                c.setEmail(r.getString(4));
                c.setNombres(r.getString(5));
                c.setApellidos(r.getString(6));
                c.setTelefono(r.getString(7));
                c.setCelular1(r.getString(8));
                c.setCiudad(r.getString(9));
                c.setEstado(r.getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return c;

        } finally {
            try {
                con.close();
            } catch (Exception ex) {
            }

        }
        return c;
    }
}
