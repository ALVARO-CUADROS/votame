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
        String Clave= request.getParameter("Clave");
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
            Celular1 = x.getCelular1();
            Ciudad = x.getCiudad();
            Estado = x.getEstado();
        }

        List<EntUsuario> LU = request.getAttribute("ListaUsuario") != null ? (List<EntUsuario>) request.getAttribute("ListaUsuario") : null;
        

%>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>ConfeccionArte</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700" rel="stylesheet" type="text/css">
            <link href="Estilos/default.css" rel="stylesheet" type="text/css" media="all" />
            <!--[if IE 6]>
            <link href="default_ie6.css" rel="stylesheet" type="text/css" />
            <![endif]-->
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <h1><a href="http://localhost:8080/ConfeccionArte/">ConfeccionArte</a></h1>
                </div>
                <div id="menu">
                    <ul>
                        <li><a href="http://localhost:8084/ConfeccionArte/MenuAdmin.jsp" accesskey="1" title="">Inicio</a></li>
                        <li><a href="http://localhost:8084/ConfeccionArte/Usuario.jsp" accesskey="2" title="">Usuarios</a></li>
                        <li><a href="http://localhost:8084/ConfeccionArte/Proveedores.jsp" accesskey="3" title="">Proveedores</a></li>
                        <li><a href="http://localhost:8084/ConfeccionArte/MateriaPrima.jsp" accesskey="4" title="">Materia Prima</a></li>
                        <li><a href="http://localhost:8084/ConfeccionArte/OrdenCompra.jsp" accesskey="5" title="">Orden de compra</a></li>
                </div>
            </div>
            <div id="page">
                <form name="inicio" action="./MaestroUsuario" method="get" >    
                <p><font face="Comic Sans" size="5">Usuarios</font></p>  
                <div id="content">
                    
                
                   <table>
                       <p><strong>Ingrese todos los campos para guardar la información</strong></p>
                        <tr><td>Nombre de usuario:</td><td><input type="text" name="NombreUsuario" onkeypress="return validar(event)" value="<%=NombreUsuario != null ? NombreUsuario : ""%>"/></td></tr>
                        <tr><td>Contraseña:</td><td><input type="text" name="Clave" value="<%=Clave != null ?Clave : ""%>"/></td></tr>
                        <tr><td>Tipo usuario:</td><td><select type="text" name="TipoUsuario"><option>Seleccione tipo usuario</option>
                                                                                 <option <%if ("Administrador".equals(Estado)) {%>selected<%}%>>Administrador</option> 
                                                                                 <option <%if ("Supervisor".equals(Estado)) {%>selected<%}%>>Supervisor</option>
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
                      
                   </table>
                                      
                        
                        </div>
                <div id="sidebar">
                     <button class="button-style" value="crear" name="action" style="height: 50px; width: 180px;">Crear</button>
                     <button class="button-style" value="consultar" name="action" style="height: 50px; width: 180px;">Buscar</button>
                    <button class="button-style" name="action" value="modificar" style="height: 50px; width: 180px;">Modificar</button>
                    <button class="button-style" value="eliminar" name="action" style="height: 50px; width: 180px;">Eliminar</button>
                    <button class="button-style" value="limpiar" name="action" style="height: 50px; width: 180px;">Limpiar</button>
                    <button class="button-style" value="Listar" name="Lista" style="height: 50px; width: 180px;">Listar</button>
                    
                </div>
               </form>  
                        <form action="./MaestroUsuario" method="post">
                    <%if (LU == null) {%>
                    <%} else {%> <br>

                    <table table border="1">
                        <tr><td>Nombre Usuario</td>
                            <td>Clave</td>
                            <td>Tipo usuario</td>
                            <td>Correo</td>
                            <td>Nombres</td>
                            <td>Apellidos</td>
                            <td>Teléfono</td>
                            <td>Celular</td>
                            <td>Ciudad</td>
                            <td>Estado</td>

                        </tr>
                        <%for (EntUsuario user : LU) {%>
                        <tr>
                            <td><%=user.getNombreUsuario()%></td>
                            <td><%=user.getClave()%></td>
                            <td><%=user.getTipoUsuario()%></td>
                            <td><%=user.getEmail()%></td>
                            <td><%=user.getNombres()%></td>
                            <td><%=user.getApellidos()%></td>
                            <td><%=user.getTelefono()%></td>
                            <td><%=user.getCelular1()%></td>
                            <td><%=user.getCiudad()%></td>
                            <td><%=user.getEstado()%></td>
                        </tr>
                        <%}%>
                    </table>
                </form>
                <%}%>  
                
            </div>
            
            <div id="footer" style="border-top: 1px solid #E5E5E5;">
                <p>(c)2013, ConfeccionArte.</p>

                <div style="float: right; width: 750px">
                    Contactos: <br>
                        Teléfono: 255 25 55. <br>
                            Correo: confecciones@gmail.com.<br>
                                Medellín-Antioquia.<br>
                                    Calle 36 #45 A 56.     


                </div>
            </div>
        </div>
    </body>
</html>

