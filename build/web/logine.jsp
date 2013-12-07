<%-- 
    Document   : login
    Created on : 07-dic-2013, 8:06:45
    Author     : carlos
--%>

<%@page import="Controlador.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Inicio Sesión</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/estilolo.css">
        <%
            Conexion con = new Conexion();
            if (request.getParameter("Ingresar") != null) {
                con.crearConexion();
                int cotn = con.InicioSesion(request.getParameter("user"), request.getParameter("pass"));
                if (cotn == 1) {
                    response.sendRedirect("inicio.jsp");
                    session.setAttribute("usuario", request.getParameter("user"));
                } else {
        %>
        <script>
            alert('Datos incorrectos!');
        </script>
        <%                            }

            }
        %>
    </head>
    <body>
        <div align="center"><font color="red"><b>Debe Iniciar Sesion para acceder a este contenido</b></font></div>
        <div id="container">
            <form method="POST" action="login.jsp">
            <div align="center"><h2>Iniciar Sesión</h2></div>
            <label for="name">Usuario: </label><br>
            <input type="text" name="user" required="" maxlength="40" >
            <label for="username">Contraseña: </label><br>
            <input type="password" name="pass" required="" maxlength="40">
            <div id="lower">
                <input type="submit" name="Ingresar" value="Entrar"><input type="button" name="Cancelar" value="Cancelar" onclick="window.location.href='index.jsp'">
            </div>
        </form>
    </div>
    </body>
</html>
