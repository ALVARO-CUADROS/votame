<%-- 
    Document   : eliminarrutina
    Created on : 02-nov-2013, 23:52:09
    Author     : carlos
--%>
<%@page import="Controlador.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Rutina</title>
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
            boolean eliminar;
            Conexion con=new Conexion();
            String ID=request.getParameter("ID");
            System.out.println ("Este Seguimiento se eliminará: "+ID);
            eliminar=con.EliminarSeg(ID);
            if (eliminar==true)
            {
                %>
                   <script>
                       alert('Se ha eliminado correctamente!');
                   </script>
                   <META HTTP-EQUIV="REFRESH" CONTENT="0;URL=../gseguimiento.jsp">
                <%
            }
            else if (eliminar==false)
            {
                %>
                   <script>
                       alert('El Usuario no se ha podido eliminar');
                   </script>
                   <META HTTP-EQUIV="REFRESH" CONTENT="0;URL=../gseguimiento.jsp">
                <%
            }
        %>
    </head>
    <body>
        
    </body>
</html>
