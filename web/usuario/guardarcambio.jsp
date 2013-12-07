<%-- 
    Document   : guardarcambio
    Created on : 03-nov-2013, 0:56:16
    Author     : carlos
--%>

<%@page import="Controlador.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            boolean modi;
            Conexion co=new Conexion();
            co.crearConexion();
            modi=co.ModificarUsuario(request.getParameter("ID"), request.getParameter("clave"), request.getParameter("tipo"), request.getParameter("nombres"), request.getParameter("apellidos"), request.getParameter("email"), request.getParameter("telefono"), request.getParameter("celular"), request.getParameter("ciudad"));
            if (modi==true)
            {
                %>
                   <script>
                       alert('Se ha modificado con éxito!');
                   </script>
                   <META HTTP-EQUIV="REFRESH" CONTENT="0;URL=../gusuario.jsp">
                <%
            }
            else
            {
                %>
                   <script>
                       alert('No se pudo modificar');
                   </script>
                   <META HTTP-EQUIV="REFRESH" CONTENT="0;URL=../gusuario.jsp">
                <%
                
            }
        %>
    </body>
</html>
