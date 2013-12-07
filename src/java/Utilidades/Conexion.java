package Utilidades;

import Persistencia.UsuarioSqlHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    private Connection Con;//esta clase solo se puede usar en esta

    public Connection getCon(){//captura la conexion
        ConexionDB();
        return Con;//devuelve la conexion
    }
    public void setCon(Connection Con){//muestra la conexion
        this.Con = Con;
    }
    public Conexion(){
    }
    static{//son las instrucciones que se ejuctan primero
        try{//busca y muestra los errores
            Class.forName("com.mysql.jdbc.Driver").newInstance();//para dar el nombre del protocolo en la nueva instancia
        }
        catch(ClassNotFoundException e1)//no se encuentra la clase
        {
            System.out.println("ClassNotFoundException"+e1.getMessage());//imprime un mensaje
        }
        catch (InstantiationException e2)//cuando la bd esta vacia
        {
            System.out.println("InstantiationException"+e2.getMessage());//imprime un mensaje
        }
        catch(IllegalAccessException e3)// acceso ilegal
        {
            System.out.println("IllegalAccessException"+e3.getMessage());//imprime un mensaje
        }catch(Exception e){//cuando no se da ninguna de las anteriores
            System.out.println("Exception"+e.getMessage());//imprime un mensaje
        }
    }
    public void ConexionDB(){// parametros de conexion

    try{//busca y muestra los errores
        setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/GimnasioD","root","alvaro"));//asigna la conexion con el driver capturando el protocolo, el puerto, nombre de la BD , el usuario pricipal con su respectiva clave si la tiene
    }
    catch(SQLException e4){////permite capturar las excepciones de la BD
        System.out.println("SQLException"+e4.getMessage());//imprime un mensaje
    }
    catch (Exception e5){//desconocimiento del origen del error
        System.out.println("otra"+e5.getMessage());//imprime un mensaje
    }
    }
    public static void main(String param[]){//que ejecute primero para devolver parametros
        Conexion conecction= new Conexion();//d nombre de la conexion
        try{//busca y muestra los errores
            ResultSet r = conecction.getCon().prepareStatement("select * from usuarios").executeQuery();//muestra el resultado de los parametros que ejecutemos
            if(r.next()){//si la respuesta siguiente
                System.out.println("employee_id: "+r.getString(1));//imprime la respuesta de la ejecucion
                while(r.next()){//mientras la respuesta siguiente
                    System.out.println("first_name: "+r.getString(2));//imprime la respuesta de la ejecucion
                }
            }else{//sino
                System.out.println("no hay datos");//imprime un mensaje
            }
        }catch(Exception e){//desconocimiento del origen del error
            System.out.println("Exception"+e.getMessage());//imprime un mensaje
        }
    }
}