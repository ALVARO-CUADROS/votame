<%-- 
    Document   : rutina
    Created on : 07-dic-2013, 7:13:22
    Author     : carlos
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <link rel="stylesheet" href="css/estilotabla.css"/>
        <%@include file="WEB-INF/menu.jspf" %>
        
        <link href="css/estilo.css" type="text/css" rel="stylesheet">
        <link href="estilome.css" type="text/css" rel="stylesheet">
        
        <!---->
        <link href="men/style.css" media="screen" rel="stylesheet" type="text/css" />
	<link href="men/iconic.css" media="screen" rel="stylesheet" type="text/css" />
	<script src="prefix-free.js"></script>
        
        <script language="javascript" type="text/javascript">
            function Eliminar(usu)
            {
            var usua=usu.toString();
            var elim=confirm("¿Deseas eliminar el Usuario "+usua+"?");
            if (elim)
                {
                      
                }
                else
                    {
                        cancelFormSubmission();
                    }
            }
        </script>
        
        <%
            if (session.getAttribute("usuario")==null)
            {
                response.sendRedirect("logine.jsp");
            }
            
                Connection conex = null;
                ResultSet rs= null;
                Statement stat=null;
                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    String user="alvaro";
                                    String pass="alvaro";
                                    conex=DriverManager.getConnection("jdbc:mysql://localhost:3306/gimnasiod",user ,pass);
                                    stat=conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                    ResultSet.CONCUR_UPDATABLE);
                                    } catch(java.lang.ClassNotFoundException e){
                                        System.out.println(e.getMessage());
                                    } catch(SQLException e) {
                                        System.out.println(e.getMessage());
                                    };
                                    try 
                                    { 
                                        rs=stat.executeQuery("select * from usuarios where Estado='Activo'");
                                        out.println("<div align='center'>Agregar Usuario<br><input name='agreg' title='Agregar Usuario' value='Agregar' alt=' conton agregar ' src='imageness/agregar.png' type='image' onclick=\"window.location.href='usuario/registrar.jsp'\" height='40px'><br></div><br>");
                                        out.println("<form action='' method='post'>");
                                        out.println("<TABLE id='tabla' class=bordered align='center'><TR><thead>");
                                        out.println("<TH>Nombre_Usuario</TH><TH>Clave</TH><TH>Tipo_Usuario</TH><TH>Nombres</TH><TH>Apellidos</TH><TH>Email</TH><TH>Telefono</TH><TH>Celular1</TH><TH>Ciudad</TH><TH>Estado</TH><TH>Edi</TH><TH>Eli</TH></TR></thead>");
                                            while(rs.next()) 
                                            {
                                                out.println("<TR>");
                                                out.println("<TD>"+rs.getString(1)+"</TD>");
                                                out.println("<TD>"+rs.getString(2)+"</TD>");
                                                out.println("<TD>"+rs.getString(3)+"</TD>");
                                                out.println("<TD>"+rs.getString(4)+"</TD>");
                                                out.println("<TD>"+rs.getString(5)+"</TD>");
                                                out.println("<TD>"+rs.getString(6)+"</TD>");
                                                out.println("<TD>"+rs.getString(7)+"</TD>");
                                                out.println("<TD>"+rs.getString(8)+"</TD>");
                                                out.println("<TD>"+rs.getString(9)+"</TD>");
                                                out.println("<TD>"+rs.getString(10)+"</TD>");
                                                out.println("<TD><input title='Editar' value='Edit' alt=' conton editar ' src='images/editar.png' type='image' onclick=\"this.form.action='usuario/editar.jsp?ID="+rs.getString(1)+"'\" id='"+rs.getString(1)+"'></TD>");
                                                out.println("<TD><input title='Eliminar' value='Elim' alt=' conton eliminar ' src='images/eliminar.png' type='image' onclick=\"Eliminar(id);this.form.action='usuario/eliminarusuario.jsp?ID="+rs.getString(1)+"'\" id='"+rs.getString(1)+"'></TD>");
                                                out.println("</TR>"); 
                                            };
                                        out.println("</TABLE><br><input name='eliminar' id='txteliminar' type='hidden' value=''><input name='editar' id='txteditar' type='hidden' value=''></form>");/*pongo los inputs de tipo hidden a los que les envio el valor del username desde el javascript*/
                                        rs.close(); stat.close();conex.close();
                                    }
                                    catch(SQLException e) {
                                    System.out.println(e.getMessage());
                                    };
            
        %>
    </head>
    <body>
        <div align="center">
        <footer>
            
           Votemos 2013
        </footer></div>
    </body>
</html>
