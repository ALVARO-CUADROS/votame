<%-- 
    Document   : InicioSesion
    Created on : 07/12/2013, 07:24:38 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <title> Inicio </title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <header>Bienvenidos</header>
        <br>
    <p> Votemos
    </p>
        
          
             
          <form action="./Autenticacion" method="post"> 
                            <fieldset class="Ingresar">
                                <legend><font face="Bradley Hand ITC" size="5" >Ingresar</font></legend>
                                <table> 
                                    <tr><td>Usuario:</td><td><input type="text" name="user" id="user"></input></td></tr>
                                    <tr><td>Contraseña:</td><td><input type="password" name="pass" id="pass"></input></td></tr>
                                    <tr><td height="26" colspan="2"><div align="center">
                                    <input type="hidden" name="valor" id="accion" value="0"/>
                                    <button class="button-style" name="Ingresar" id="login" >Ingresar</button>
                                     </div></td></tr>
                               </table>
                            </fieldset> 
                            
                        </form>
 
            
          
  
   
    </body>
</html>