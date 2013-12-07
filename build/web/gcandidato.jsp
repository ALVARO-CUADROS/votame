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
            function Eliminar(seg)
            {
            var segui=seg.toString();
            var elim=confirm("¿Deseas eliminar el Seguimiento "+segui+"?");
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
                                        rs=stat.executeQuery("select * from seguimiento where Estado='1'");
                                        out.println("<div align='center'>Agregar Seguimiento<br><input name='agreg' title='Agregar Seguimiento' value='Agregar' alt=' conton agregar ' src='imageness/agregar.png' type='image' onclick=\"window.location.href='seguimiento/registrar.jsp'\" height='40px'><br></div><br>");
                                        out.println("<form action='' method='post'>");
                                        out.println("<TABLE id='tabla' class=bordered align='center'><TR><thead>");
                                        out.println("<TH>PerfilId</TH><TH>NumeroDocumento</TH><TH>RutinaId</TH><TH>Fecha_Perfil</TH><TH>Estatura</TH>"
                                                + "<TH>Peso</TH><TH>HombrosMedida</TH><TH>EspaldaMedida</TH><TH>PechosMedida</TH>"
                                                + "<TH>BrazosMedida</TH><TH>AbdomenMedida</TH><TH>PiernasMedida</TH><TH>MedidaPantorillas</TH>"
                                                + "<TH>EvaluacionMedica</TH><TH>PorcentajeGrasaCorporal</TH><TH>IndiceMasaCorporal</TH><TH>Estado</TH>"
                                                + "<TH>Edi</TH><TH>Eli</TH></TR></thead>");
                                        
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
                                                out.println("<TD>"+rs.getString(11)+"</TD>");
                                                out.println("<TD>"+rs.getString(12)+"</TD>");
                                                out.println("<TD>"+rs.getString(13)+"</TD>");
                                                out.println("<TD>"+rs.getString(14)+"</TD>");
                                                out.println("<TD>"+rs.getString(15)+"</TD>");
                                                out.println("<TD>"+rs.getString(16)+"</TD>");
                                                out.println("<TD>"+rs.getString(17)+"</TD>");
                                                out.println("<TD><input title='Editar' value='Edit' alt=' conton editar ' src='images/editar.png' type='image' onclick=\"this.form.action='candidato/editar.jsp?ID="+rs.getString(1)+"'\" id='"+rs.getString(1)+"'></TD>");
                                                out.println("<TD><input title='Eliminar' value='Elim' alt=' conton eliminar ' src='images/eliminar.png' type='image' onclick=\"Eliminar(id);this.form.action='candidato/eliminarseg.jsp?ID="+rs.getString(1)+"'\" id='"+rs.getString(1)+"'></TD>");
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
