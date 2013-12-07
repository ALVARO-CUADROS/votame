<%-- 
    Document   : Registro
    Created on : 07-dic/2013, 06:32:04 PM
    Author     : Usuario
--%>

<%@page import="Entidades.EntUsuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Old Stairwell 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20130313

-->
<%
        String mensaje = (String) request.getAttribute("mensaje");
        String NombreUsuario = request.getParameter("NombreUsuario");
        String Clave = request.getParameter("Clave");
        String TipoUsuario = request.getParameter("TipoUsuario");
        String Email = request.getParameter("Email");
        String Nombres = request.getParameter("Nombres");
        String Apellidos = request.getParameter("Apellidos");
        String Telefono = request.getParameter("Telefono");
        String Celular1 = request.getParameter("Celular1");
        String Ciudad = request.getParameter("Ciudad");
        String Estado = request.getParameter("Estado");

        EntUsuario x = request.getAttribute("cli") != null ? (EntUsuario) request.getAttribute("cli") : null;
// nombre del atributo cuando lo subo  // operador ternario condicional
        if (x != null) {
            NombreUsuario = x.getNombreUsuario();
            Clave = x.getClave();
            TipoUsuario = x.getTipoUsuario();
            Email = x.getEmail();
            Nombres = x.getNombres();
            Apellidos = x.getApellidos();
            Telefono = x.getTelefono();
            Celular1= x.getCelular1();
            Ciudad = x.getCiudad();
            Estado = x.getEstado();
        }

        List<EntUsuario> LU = request.getAttribute("ListaUsuario") != null ? (List<EntUsuario>) request.getAttribute("ListaUsuario") : null;
        

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="inicio" action="./MaestroUsuario" method="get" >    
                <p><font face="Comic Sans" size="5">Usuarios</font></p>  
                <div id="content">
                    
                
                   <table>
                       <p><strong>Ingrese todos los campos para guardar la información</strong></p>
                        <tr><td>Nombre de usuario:</td><td><input type="text" name="NombreUsuario" onkeypress="return validar(event)" value="<%=NombreUsuario != null ? NombreUsuario : ""%>"/></td></tr>
                        <tr><td>Contraseña:</td><td><input type="password" name="Clave" value="<%=Clave != null ? Clave : ""%>"/></td></tr>
                        <tr><td>Tipo usuario:</td><td><select type="text" name="TipoUsuario"><option>Seleccione tipo usuario</option>
                                                                                 <option <%if ("Administrador".equals(Estado)) {%>selected<%}%>>Administrador</option> 
                                                                                 <option <%if ("Deportista".equals(Estado)) {%>selected<%}%>>Deportista</option>
                                                                                 <option <%if ("Profesional".equals(Estado)) {%>selected<%}%>>Profesional</option>
                                                </select></td></tr>
                         <tr><td>Estado:</td><td><select type="text" name="Estado"><option>--Seleccione estado:--</option>
                                                                                 <option <%if ("Activo".equals(Estado)) {%>selected<%}%>>Activo</option> 
                                                                                 <option <%if ("Inactivo".equals(Estado)) {%>selected<%}%>>Inactivo</option>
                        </select></td></tr>                                                                      
                        <tr><td>Nombres:</td><td><input type="text" name="Nombres" value="<%=Nombres != null ? Nombres : ""%>"></td></tr> 
                        <tr><td>Apellidos:</td><td><input type="text" name="Apellidos" value="<%=Apellidos != null ? Apellidos : ""%>"></td></tr> 
                         <tr><td>Teléfono:</td><td><input type="text" name="Telefono" value="<%=Telefono != null ? Telefono : ""%>"/></td></tr> 
                        <tr><td>Celular:</td><td><input type="text" name="Celular1" value="<%=Celular1 != null ? Celular1 : ""%>"/></td></tr> 
                        <tr><td>Ciudad:</td><td><input type="text" name="Ciudad" value="<%=Ciudad != null ? Ciudad : ""%>"/></td></tr> 
                         <tr><td>Correo: </td><td><input type="text" name="Email" placeholder="ejemplo@mail.com" value="<%=Email != null ? Email : ""%>"/></td></tr>                                                                 
                       <tr><td><button  value="crear" id="crear" name="action" style="height: 50px; width: 180px;">Registrarse</button></td></tr>
                   </table>
                                      
                        
                        </div>
                <div id="sidebar">
                    
                    
                </div>
               </form>  
    </body>
</html>
