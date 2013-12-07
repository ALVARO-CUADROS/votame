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
            modi=co.ModificarSeg(request.getParameter("ID"), request.getParameter("numerodocumento"), request.getParameter("rutinaid"), request.getParameter("fechaperfil"), request.getParameter("estatura"), request.getParameter("peso"), request.getParameter("hombrosmedia"), request.getParameter("espaldamedia"), request.getParameter("pechosmedia"), request.getParameter("brazosmedia"), request.getParameter("abdomenmedia"), request.getParameter("piernasmedia"), request.getParameter("mediapantorillas"), request.getParameter("evuluacionmedica"), request.getParameter("porcentajegrasa"), request.getParameter("indicemasacorporal"));
            if (modi==true)
            {
                %>
                   <script>
                       alert('Se ha modificado con éxito!');
                   </script>
                   <META HTTP-EQUIV="REFRESH" CONTENT="0;URL=../gseguimiento.jsp">
                <%
            }
            else
            {
                %>
                   <script>
                       alert('No se pudo modificar');
                   </script>
                   <META HTTP-EQUIV="REFRESH" CONTENT="0;URL=../gseguimiento.jsp">
                <%
                
            }
        %>
    </body>
</html>
