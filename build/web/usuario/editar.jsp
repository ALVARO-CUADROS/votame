<%-- 
    Document   : editar
    Created on : 03-nov-2013, 0:33:02
    Author     : carlos
--%>

<%@page import="Controlador.Conexion"%>
<%@page import="Entidades.EntUsuario"%>
<%@page import="com.sun.tools.ws.processor.model.ModelObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
        <link type="text/css" href="../css/estilo.css" rel="stylesheet">
        <link type="text/css" href="../css/estilofo.css" rel="stylesheet">
        <!--atra-->
        <link rel="stylesheet" href="../css/estilotabla.css"/>
        <link href="../css/estilo.css" type="text/css" rel="stylesheet">
        <link href="../estilome.css" type="text/css" rel="stylesheet">
        
        <!---->
        <link href="../men/style.css" media="screen" rel="stylesheet" type="text/css" />
	<link href="../men/iconic.css" media="screen" rel="stylesheet" type="text/css" />
	<script src="prefix-free.js"></script>
        <%@include file="../WEB-INF/menusec.jspf" %>
    </head>
    <body>
<%
    if (session.getAttribute("usuario")==null)
            {
                response.sendRedirect("../logine.jsp");
            }
    else
    {
        if (session.getAttribute("rol").toString().equals("Deportista"))
        {
            response.sendRedirect("../logine.jsp");
        }
    }
    
    Conexion co=new Conexion();
    co.crearConexion();
    co.ConsultarModificarU(request.getParameter("ID"));
    EntUsuario u=new EntUsuario();
            out.print("<div align='center' id='formularioRgegistrarUsuario'><form  method='post' action='guardarcambio.jsp?ID="+request.getParameter("ID")+"'><div><center>");
            out.print("<h1>Editar Usuario</h1><span></span></center></div>");
            out.print("<div class='content'><table><tr><td>Nombre Usuario</td>");
            out.print("<td><input readonly name='nombreusuario' id='nombreusuario' type='text' class='input username' required='' value='"+u.getNombreUsuario()+"'/></td>");
            out.print("</tr><tr><td>Clave </td>");
            out.print("<td><input maxlength='12' name='clave' id='clave' type='text' class='input username' required='' value='"+u.getClave()+"' onfocus='this.value=''' /></td>");

            out.print("</tr><tr><td>Tipo Usuario </td>");
            out.print("<td><select name='tipo'><option value='"+u.getTipoUsuario()+"' selected>"+u.getTipoUsuario()+"</option><option value='Administrador'>Administrador</option><option value='Deportista'>Deportista</option><option value='Profesional'>Profesional</option></select>");
            out.print("</td></tr><tr><td>Nombres: </td>");
            out.print("<td><input maxlength='40' name='nombres' id='nombres' type='text' class='input username' required='' value='"+u.getNombres()+"' onfocus='this.value=''' /></td></tr>");
            out.print("</tr><tr><td>Apellidos: </td>");
            out.print("<td><input maxlength='40' name='apellidos' id='apellidos' type='text' class='input username' required='' value='"+u.getApellidos()+"' onfocus='this.value=''' />");
            out.print("</td></tr><tr><td>Email: </td>");
            out.print("<td><input maxlength='40' name='email' id='email' type='email' class='input username' required='' value='"+u.getEmail()+"' onfocus='this.value=''' /></td></tr>");
            out.print("</tr><tr><td>Telefono: </td>");
            out.print("<td><input maxlength='12' name='telefono' id='telefono' type='text' class='input username' required='' value='"+u.getTelefono()+"' onfocus='this.value=''' />");           
            out.print("</tr><tr><td>Cecular 1: </td>");
            out.print("<td><input maxlength='12' name='celular' id='celular' type='text' class='input username' required='' value='"+u.getCelular1()+"' onfocus='this.value=''' />");
            out.print("</td></tr><tr><td>Ciudad: </td>");
            out.print("<td><input maxlength='12' name='ciudad' id='ciudad' type='text' class='input username' required='' value='"+u.getCiudad()+"' onfocus='this.value=''' /></td></tr>");
            
            out.print("</table></div><div class='footer'><input type='submit' name='editar' value='Guardar' class='button'/>");
            out.print("<input type='reset' name='atras' value='Cancelar' class='button' onclick=\"window.location.href='../gusuario.jsp'\"/></div>");
            out.print("</form></div><div class='gradient'></div></div> ");  
%>
    </body>
</html>
