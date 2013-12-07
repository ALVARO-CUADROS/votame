package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidades.conectadorol;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/menu.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Inicio</title>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"div_sesion\" align=\"right\">\n");
      out.write("    ");

        conectadorol n = new conectadorol();
        if (session.getAttribute("usuario") != null) 
        {
            session.setAttribute("rol", n.getRol());
            out.println("Conectado: " + session.getAttribute("usuario"));
    
      out.write("\n");
      out.write("    /<b>");
out.println(session.getAttribute("rol"));
      out.write("</b> - <a href=\"cerrarsesion.jsp\">Cerrar Sesión</a></div>\n");
      out.write("<br>\n");

        if (session.getAttribute("rol").equals("Administrador")) {
            out.println("<div class='wrap'><nav><ul class='menu'><li><a href='Gimnasio.jsp'><span class='iconic home'></span> Gimnasio</a></li><li><a><span class='iconic plus-alt'></span> Público</a><ul><li><a href='Maquinas.jsp'><span class='iconic plus-alt'></span> Máquinas</a></li><li><a href='Profesional.jsp'><span class='iconic map-pin'></span> Profesionales</a></li><li><a href='Ejercicios.jsp'><span class='iconic mail'></span> Ejercicios</a></li><li><a href='Acerca_de.jsp'><span class='iconic mail'></span> Acerca de</a></li></ul></li><li><a href='gdeportista.jsp'><span class='iconic map-pin'></span> Deportistas</a><ul><li><a href='gdeportista.jsp'>Gestionar</a></li><li><a href='deportista/registrar.jsp'>Registrar</a></li></ul></li> <li><a href='rutina.jsp'><span class='iconic map-pin'></span> Rutina</a><ul><li><a href='rutina.jsp'>Gestionar</a></li><li><a href='rutina/registrar.jsp'>Registrar</a></li></ul></li><li><a href='gseguimiento.jsp'><span class='iconic plus-alt'></span> Seguimiento</a><ul><li><a href='gseguimiento.jsp'>Gestionar</a></li><li><a href='seguimiento/registrar.jsp'>Registrar</a></li></ul></li><li><a href='gusuario.jsp'><span class='iconic plus-alt'></span> Usuarios</a><ul><li><a href='gusuario.jsp'>Gestionar</a></li><li><a href='usuario/registrar.jsp'>Registrar</a></li></ul></li></ul><div class='clearfix'></div></nav></div>");
        }
        if (session.getAttribute("rol").equals("Deportista")) {
            out.println("<div class='wrap'><nav><ul class='menu'><li><a href='Gimnasio.jsp'><span class='iconic home'></span> Gimnasio</a></li><li><a href='Maquinas.jsp'><span class='iconic plus-alt'></span> Máquinas</a><ul><li></ul></li><li><a href='Ejercicios.jsp'><span class='iconic mail'></span> Ejercicios</a><ul></ul></li><li><a href='Acerca_de.jsp'><span class='iconic mail'></span> Acerca de</a></li><li><a href='rutinad.jsp'><span class='iconic mail'></span> Consultar Rutinas</a></li></ul><div class='clearfix'></div></nav></div>");
        }
        if (session.getAttribute("rol").equals("Profesional")) {
            out.println("<div class='wrap'><nav><ul class='menu'><li><a href='Gimnasio.jsp'><span class='iconic home'></span> Gimnasio</a></li><li><a><span class='iconic plus-alt'></span> Público</a><ul><li><a href='Maquinas.jsp'><span class='iconic plus-alt'></span> Máquinas</a></li><li><a href='Profesional.jsp'><span class='iconic map-pin'></span> Profesionales</a></li><li><a href='Ejercicios.jsp'><span class='iconic mail'></span> Ejercicios</a></li><li><a href='Acerca_de.jsp'><span class='iconic mail'></span> Acerca de</a></li></ul></li><li><a href='gdeportista.jsp'><span class='iconic map-pin'></span> Deportistas</a><ul><li><a href='gdeportista.jsp'>Gestionar</a></li><li><a href='deportista/registrar.jsp'>Registrar</a></li></ul></li> <li><a href='rutina.jsp'><span class='iconic map-pin'></span> Rutina</a><ul><li><a href='rutina.jsp'>Gestionar</a></li><li><a href='rutina/registrar.jsp'>Registrar</a></li></ul></li><li><a href='gseguimiento.jsp'><span class='iconic plus-alt'></span> Seguimiento</a><ul><li><a href='gseguimiento.jsp'>Gestionar</a></li><li><a href='seguimiento/registrar.jsp'>Registrar</a></li></ul></li><li><a href='gusuario.jsp'><span class='iconic plus-alt'></span> Usuarios</a><ul><li><a href='gusuario.jsp'>Gestionar</a></li><li><a href='usuario/registrar.jsp'>Registrar</a></li></ul></li></ul><div class='clearfix'></div></nav></div>");
        }
    } else {
        out.println("<div class='wrap'><nav><ul class='menu'><li><a href='Gimnasio.jsp'><span class='iconic home'></span> Gimnasio</a></li>"
                + "<li><a href='Maquinas.jsp'><span class='iconic plus-alt'></span> Máquinas</a></li>"
                + "<li><a href='Ejercicios.jsp'><span class='iconic mail'></span> Ejercicios</a></li>"
                + "<li><a href='Acerca_de.jsp'><span class='iconic mail'></span> Acerca de</a></li>"
                + "<li><a href='login.jsp'><span class='iconic map-pin'></span> Inicio Sesión</a></li>"
                + "</ul><div class='clearfix'></div></nav></div>");
    }

      out.write("\n");
      out.write("\n");
      out.write("       \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <link href=\"css/estilo.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"estilome.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("        \n");
      out.write("        <!---->\n");
      out.write("        <link href=\"men/style.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\t<link href=\"men/iconic.css\" media=\"screen\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("\t<script src=\"prefix-free.js\"></script>\n");
      out.write("        \n");
      out.write("        ");

            
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("         <div class=\"cont\" align=\"center\">\n");
      out.write("        <section>\n");
      out.write("          <article> \n");
      out.write("              <p><br>Somos la cadena líder de los mejores gimnasios a nivel de Colombia. <br>\n");
      out.write("                  Nuestro objetivo es mejorar la calidad de vida de la comunidad a través <br>\n");
      out.write("                  de la práctica del ejercicio físico con productos y servicios saludables <br>\n");
      out.write("                  que le permitan desempeñarse, verse y sentirse mejor. </p> <br>\n");
      out.write("     <img src=\"IMAGENES/96.jpg\" width=\"500px\" heigh=\"500px\"> \n");
      out.write("          </article>\n");
      out.write("          </section>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("           <footer>\n");
      out.write("            \n");
      out.write("           <br>Votemos\n");
      out.write("        </footer>\n");
      out.write("       </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
