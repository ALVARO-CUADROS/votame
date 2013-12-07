/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidades.EntUsuario;
import Persistencia.DaoUsuario;
import Utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

   
    

/**
 *
 * @author Usuario
 */
public class NUsuario {
     DaoUsuario daoUsuario; //verde va a recibir todo del otro solo se renombra
    Connection c;
    
    public String autenticar(EntUsuario usuario){ //crear el metodo 'autenticar' que va a guardar los get y set de EntUsuario
        daoUsuario=new DaoUsuario(); 
        c= new Conexion().getCon();
        String resultado = daoUsuario.autenticar(c, usuario);//en una variable resultado se guarda todo de daoUsuario con el metodo auntenticar llamando la conexion y 
                return resultado; //devuelvaa resultado
                
    }
    
    public int crear(EntUsuario pro) {
        daoUsuario = new DaoUsuario();
        c = new Conexion().getCon();
        int resultadoCrear = daoUsuario.crear(c, pro);
        return resultadoCrear;
    }

    public List<EntUsuario> ListadoUsuario() {
        daoUsuario = new DaoUsuario();
        c = new Conexion().getCon();
        return daoUsuario.ListarUsuario(c);
    }

    public int modificar(EntUsuario pro) {
        daoUsuario = new DaoUsuario();
        c = new Conexion().getCon();
        int resultadoModificar = daoUsuario.modificar(c, pro);
        return resultadoModificar;
    }

    public int eliminar(EntUsuario pro) {
        daoUsuario = new DaoUsuario();
        c = new Conexion().getCon();
        int resultadoEliminar = daoUsuario.eliminar(c, pro);
        return resultadoEliminar;
    }

    public EntUsuario Buscar(String NombreUsuario) {
        daoUsuario = new DaoUsuario();
        c = new Conexion().getCon();
        EntUsuario resultadoBuscar = daoUsuario.Buscar(c, NombreUsuario);
        return resultadoBuscar;
    }

}
