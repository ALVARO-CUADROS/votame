<%-- 
    Document   : cerrarsesion
    Created on : 07-dic-2013, 6:09:05
    Author     : carlos
--%>

<%@page import="Entidades.conectadorol"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            conectadorol ro=new conectadorol();
            ro.setRol(null);
            session.invalidate();
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
