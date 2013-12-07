<%-- 
    Document   : editar
    Created on : 03-nov-2013, 0:33:02
    Author     : carlos
--%>

<%@page import="Controlador.Conexion"%>
<%@page import="Entidades.seguimiento"%>
<%@page import="com.sun.tools.ws.processor.model.ModelObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Seguimiento</title>
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
    co.ConsultarModificarSeg(request.getParameter("ID"));
    seguimiento s=new seguimiento();
            out.print("<div align='center' id='formularioRgegistrarSeg'><form  method='post' action='guardarcambio.jsp?ID="+request.getParameter("ID")+"'><div><center>");
            out.print("<h1>Editar Seguimiento</h1><span></span></center></div>");
            
            out.print("<div class='content'><table><tr><td>Perfil ID: </td>");
            out.print("<td><input readonly name='perfilid' id='nombreusuario' type='text' class='input username' required='' value='"+request.getParameter("ID")+"'/></td>");
            
            out.print("</tr><tr><td>Numero Documento: </td>");
            out.print("<td><input readonly name='numerodocumento' id='clave' type='text' class='input username' required='' value='"+s.getNumeroDocumento()+"' onfocus='this.value=''' /></td>");

            out.print("</td></tr><tr><td>RutinaId: </td>");
            out.print("<td><input readonly name='rutinaid' id='nombres' type='text' class='input username' required='' value='"+s.getRutinaId()+"' onfocus='this.value=''' /></td></tr>");
            
            out.print("</td></tr><tr><td>FechaPerfil: </td>");
            out.print("<td><input readonly name='fechaperfil' id='nombres' type='date' class='input username' required='' value='"+s.getFechaPerfil()+"' onfocus='this.value=''' /></td></tr>");
            
            out.print("</tr><tr><td>Estatura: </td>");
            out.print("<td><input maxlength='12' name='estatura' id='apellidos' type='text' class='input username' required='' value='"+s.getEstatura()+"' onfocus='this.value=''' />");

            out.print("</td></tr><tr><td>Peso: </td>");
            out.print("<td><input maxlength='12' name='peso' id='email' type='text' class='input username' required='' value='"+s.getPeso()+"' onfocus='this.value=''' /></td></tr>");
            
            out.print("</tr><tr><td>Hombros Media </td>");
            out.print("<td><input maxlength='12' name='hombrosmedia' id='telefono' type='text' class='input username' required='' value='"+s.getHombrosMedida()+"' onfocus='this.value=''' />");           
            
            out.print("</tr><tr><td>Espalda Medida: </td>");
            out.print("<td><input maxlength='12' name='espaldamedia' id='celular' type='text' class='input username' required='' value='"+s.getEspaldaMedida()+"' onfocus='this.value=''' />");
            
            out.print("</td></tr><tr><td>Pechos Media: </td>");
            out.print("<td><input maxlength='12' name='pechosmedia' id='ciudad' type='text' class='input username' required='' value='"+s.getPechosMedida()+"' onfocus='this.value=''' /></td></tr>");
            
            /************/
            out.print("</td></tr><tr><td>Brazos Medida: </td>");
            out.print("<td><input maxlength='12' name='brazosmedia' id='nombres' type='text' class='input username' required='' value='"+s.getBrazosMedida()+"' onfocus='this.value=''' /></td></tr>");
            
            out.print("</tr><tr><td>Abdomen Medida: </td>");
            out.print("<td><input maxlength='12' name='abdomenmedia' id='apellidos' type='text' class='input username' required='' value='"+s.getAbdomenMedida()+"' onfocus='this.value=''' />");

            out.print("</td></tr><tr><td>Piernas Medida: </td>");
            out.print("<td><input maxlength='12' name='piernasmedia' id='email' type='text' class='input username' required='' value='"+s.getPiernasMedida()+"' onfocus='this.value=''' /></td></tr>");
            
            out.print("</tr><tr><td>Medida Pantorillas: </td>");
            out.print("<td><input maxlength='12' name='mediapantorillas' id='telefono' type='text' class='input username' required='' value='"+s.getMedidaPantorillas()+"' onfocus='this.value=''' />");           
            
            out.print("</tr><tr><td>Evaluacion Medica: </td>");
            out.print("<td><input maxlength='5' name='evuluacionmedica' id='celular' type='text' class='input username' required='' value='"+s.getEvaluacionMedica()+"' onfocus='this.value=''' />");
            
            out.print("</td></tr><tr><td>Porcentaje Grasa Corporal: </td>");
            out.print("<td><input maxlength='12' name='porcentajegrasa' id='ciudad' type='text' class='input username' required='' value='"+s.getPorcentajeGrasaCorporal()+"' onfocus='this.value=''' /></td></tr>");
            
            out.print("</td></tr><tr><td>Indice Masa Corporal: </td>");
            out.print("<td><input maxlength='12' name='indicemasacorporal' id='ciudad' type='text' class='input username' required='' value='"+s.getIndiceMasaCorporal()+"' onfocus='this.value=''' /></td></tr>");
            
            
            out.print("</table></div><div class='footer'><input type='submit' name='editar' value='Guardar' class='button'/>");
            out.print("<input type='reset' name='atras' value='Cancelar' class='button' onclick=\"window.location.href='../gseguimiento.jsp'\"/></div>");
            out.print("</form></div><div class='gradient'></div></div> ");  
%>
    </body>
    
</html>
