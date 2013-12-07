<%-- 
    Document   : registrar
    Created on : 03-nov-2013, 0:11:33
    Author     : carlos
--%>

<%@page import="java.math.MathContext"%>
<%@page import="Controlador.Conexion"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Seguimiento</title>
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
            
           if (request.getParameter("registre")!=null)
           {
               boolean reg;
               Conexion co=new Conexion();
               reg=co.RegistrarSeg(request.getParameter("ID"), request.getParameter("numerodocumento"), request.getParameter("rutinaid"), request.getParameter("fechaperfil"), request.getParameter("estatura"), request.getParameter("peso"), request.getParameter("hombrosmedia"), request.getParameter("espaldamedia"), request.getParameter("pechosmedia"), request.getParameter("brazosmedia"), request.getParameter("abdomenmedia"), request.getParameter("piernasmedia"), request.getParameter("mediapantorillas"), request.getParameter("evuluacionmedica"), request.getParameter("porcentajegrasa"), request.getParameter("indicemasacorporal"));
               if (reg==true)
               {
                   %>
                   <script>
                       alert('Se ha registrado con éxito!');
                   </script>
                   <META HTTP-EQUIV="REFRESH" CONTENT="0;URL=../gseguimiento.jsp">
                <%
               }
               else
               {
                   %>
                   <script>
                       alert('No se ha podido registrar');
                   </script>
                   <META HTTP-EQUIV="REFRESH" CONTENT="0;URL=../gseguimiento.jsp">
                <%
               }
           }
        %>
    </head>
    <body>
        <%
            Random sig=new Random();
            out.print("<div align='center' id='formularioRgegistrarSeg'><form  method='post' action='registrar.jsp?ID="+sig.nextInt(1000)+"'><div><center>");
            out.print("<h1>Registrar Seguimiento</h1><span></span></center></div>");
            
            out.print("<div class='content'><table>");
            
            out.print("</tr><tr><td>Numero Documento: </td>");
            out.print("<td><input maxlength='12' name='numerodocumento' id='clave' type='text' class='input username' required='' onfocus='this.value=''' /></td>");

            out.print("</td></tr><tr><td>RutinaId: </td>");
            out.print("<td><input maxlength='12' name='rutinaid' id='nombres' type='text' class='input username' required='' onfocus='this.value=''' /></td></tr>");
            
            out.print("</td></tr><tr><td>FechaPerfil: </td>");
            out.print("<td><input maxlength='12' name='fechaperfil' id='nombres' type='date' class='input username' required='' onfocus='this.value=''' /></td></tr>");
            
            out.print("</tr><tr><td>Estatura: </td>");
            out.print("<td><input maxlength='12' name='estatura' id='apellidos' type='text' class='input username' required='' onfocus='this.value=''' />");

            out.print("</td></tr><tr><td>Peso: </td>");
            out.print("<td><input maxlength='12' name='peso' id='email' type='text' class='input username' required='' onfocus='this.value=''' /></td></tr>");
            
            out.print("</tr><tr><td>Hombros Media </td>");
            out.print("<td><input maxlength='12' name='hombrosmedia' id='telefono' type='text' class='input username' required='' onfocus='this.value=''' />");           
            
            out.print("</tr><tr><td>Espalda Medida: </td>");
            out.print("<td><input maxlength='12' name='espaldamedia' id='celular' type='text' class='input username' required='' onfocus='this.value=''' />");
            
            out.print("</td></tr><tr><td>Pechos Media: </td>");
            out.print("<td><input maxlength='12' name='pechosmedia' id='ciudad' type='text' class='input username' required='' onfocus='this.value=''' /></td></tr>");
            
            /************/
            out.print("</td></tr><tr><td>Brazos Medida: </td>");
            out.print("<td><input maxlength='12' name='brazosmedia' id='nombres' type='text' class='input username' required='' onfocus='this.value=''' /></td></tr>");
            
            out.print("</tr><tr><td>Abdomen Medida: </td>");
            out.print("<td><input maxlength='12' name='abdomenmedia' id='apellidos' type='text' class='input username' required='' onfocus='this.value=''' />");

            out.print("</td></tr><tr><td>Piernas Medida: </td>");
            out.print("<td><input maxlength='12' name='piernasmedia' id='email' type='text' class='input username' required='' onfocus='this.value=''' /></td></tr>");
            
            out.print("</tr><tr><td>Medida Pantorillas: </td>");
            out.print("<td><input maxlength='12' name='mediapantorillas' id='telefono' type='text' class='input username' required='' onfocus='this.value=''' />");           
            
            out.print("</tr><tr><td>Evaluacion Medica: </td>");
            out.print("<td><input maxlength='5' name='evuluacionmedica' id='celular' type='text' class='input username' required='' onfocus='this.value=''' />");
            
            out.print("</td></tr><tr><td>Porcentaje Grasa Corporal: </td>");
            out.print("<td><input maxlength='12' name='porcentajegrasa' id='ciudad' type='text' class='input username' required='' onfocus='this.value=''' /></td></tr>");
            
            out.print("</td></tr><tr><td>Indice Masa Corporal: </td>");
            out.print("<td><input maxlength='12' name='indicemasacorporal' id='ciudad' type='text' class='input username' required='' onfocus='this.value=''' /></td></tr>");
            
            
            out.print("</table></div><div class='footer'><input type='submit' name='registre' value='Guardar' class='button'/>");
            out.print("<input type='reset' name='atras' value='Cancelar' class='button' onclick=\"window.location.href='../gseguimiento.jsp'\"/></div>");
            out.print("</form></div><div class='gradient'></div></div> "); 
        %>
        
        </body>
</html>
