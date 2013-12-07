<%-- 
    Document   : inicio
    Created on : 07-dic-2013, 8:17:18
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>.. Inicio ..</title>
        <link href="css/estilo.css" type="text/css" rel="stylesheet">
        <link href="estilome.css" type="text/css" rel="stylesheet">
        
        <!---->
        <link href="men/style.css" media="screen" rel="stylesheet" type="text/css" />
	<link href="men/iconic.css" media="screen" rel="stylesheet" type="text/css" />
	<script src="prefix-free.js"></script>
        
        <%
            if (session.getAttribute("usuario") == null) {
                response.sendRedirect("logine.jsp");
            }
        %>
    </head>
    <body>
        <%@include file="WEB-INF/menu.jspf" %>
    </body>
</html>
