/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.*;
import javax.swing.JFormattedTextField.*;
import java.io.*;
import java.sql.*;
import Entidades.EntUsuario;
import Negocio.*;
import Utilidades.Conexion;

/**
 *
 * @author AFDM
 */
public class MaestroUsuario extends HttpServlet {

    int i = 0;
    int nfilas = 0;
    Connection c;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        EntUsuario Usuario = new EntUsuario();
        Usuario.setNombreUsuario(request.getParameter("NombreUsuario"));
        Usuario.setClave(request.getParameter("Clave"));
        Usuario.setTipoUsuario(request.getParameter("TipoUsuario"));
        Usuario.setEmail(request.getParameter("Email"));
        Usuario.setNombres(request.getParameter("Nombres"));
        Usuario.setApellidos(request.getParameter("Apellidos"));
        Usuario.setTelefono(request.getParameter("Telefono"));
        Usuario.setCelular1(request.getParameter("Celular1"));
        Usuario.setCiudad(request.getParameter("Ciudad"));
        Usuario.setEstado(request.getParameter("Estado"));
        String accion = (request.getParameter("action"));
        System.out.print(Usuario);
        String NombreUsuario = request.getParameter("NombreUsuario");
        String Clave = request.getParameter("Clave");
        String TipoUsuario = request.getParameter("TipoUsuario");
        String Email = request.getParameter("Email");
        String Nombres = request.getParameter("Nombres");
        String Apellidos = request.getParameter("Apellidos");
        String Telefono = request.getParameter("Telefono");
        String Celular1 = request.getParameter("Celular1");
        String Ciudad = request.getParameter("Ciudad");
        String Estado = request.getParameter("Estado");

        String User = request.getParameter("Registro");

        EntUsuario cl = new EntUsuario();

        if ("Listar".equals(request.getParameter("Lista"))) {
            NUsuario negocioC = new NUsuario();
            try {
                List<EntUsuario> ListaCliente = negocioC.ListadoUsuario();
                request.setAttribute("ListaUsuario", ListaCliente);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(MaestroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            }
        }

        if ("limpiar".equals(request.getParameter("action"))) {
            response.sendRedirect("Usuario.jsp");
        }

        if ("crear".equals(request.getParameter("action"))) {

            Conexion Connection = new Conexion();
            try {
                ResultSet r = Connection.getCon().prepareStatement("Select NombreUsuario from usuarios").executeQuery();
                while (r.next()) {
                    if (NombreUsuario.equals(r.getString(1))) {
                        JOptionPane.showMessageDialog(null, "Este registro ya existe, por favor verifique el nombre de usuario", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                        request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
                    }
                }
            } catch (Exception e) {
            }

            if (NombreUsuario.equals("") && Clave.equals("") && TipoUsuario.equals("") && Email.equals("") && Nombres.equals("") && Apellidos.equals("") && Telefono.equals("") && Celular1.equals("") && Ciudad.equals("") &&Estado.equals("")) {
                JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos.", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            } else if (NombreUsuario.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de usuario.", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            } else if (Clave.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre la contraseña.", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            } else if (TipoUsuario.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el tipo de usuario.", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            } else if (Nombres.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese los nombres.", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            } else if (Apellidos.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese los apellidos.", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            } else if (Email.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el e-mail.", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            }else {
                int resultado = new NUsuario().crear(Usuario);
                try {
                    response.sendRedirect("Usuario.jsp");
                    JOptionPane.showMessageDialog(null, "Se guardó correctamente", "Cinosargo Soft 1.0", JOptionPane.INFORMATION_MESSAGE);
                    request.setAttribute("cli", resultado);
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            }
        }
        if ("modificar".equals(request.getParameter("action"))) {

            if (NombreUsuario.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de usuario.", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            } else if (NombreUsuario.equals("") || Clave.equals("") || TipoUsuario.equals("") || Email.equals("") || Nombres.equals("") || Apellidos.equals("") || Telefono.equals("") || Celular1.equals("") || Ciudad.equals("") || Estado.equals("")) {
                JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos.", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            } else if (NombreUsuario != null) {
                Conexion Connection = new Conexion();
                try {
                    ResultSet r = Connection.getCon().prepareStatement("Select NombreUsuario from usuarios").executeQuery();
                    while (r.next()) {
                        if (NombreUsuario.equals(r.getString(1))) {

                            int resultadoModificar = new NUsuario().modificar(Usuario);
                            request.setAttribute("cli", resultadoModificar);
                            JOptionPane.showMessageDialog(null, "Se modificó correctamente", "Cinosargo Soft 1.0", JOptionPane.INFORMATION_MESSAGE);
                            response.sendRedirect("Usuario.jsp");

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            Conexion Connection = new Conexion();
            try {
                ResultSet r1 = Connection.getCon().prepareStatement("Select NombreUsuario from usuarios").executeQuery();
                while (r1.next()) {
                    if (!NombreUsuario.equals(r1.getString(1)) && (!NombreUsuario.equals(""))) {
                        request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
                        JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique el nombre de usuario", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception e) {
            }

        }

        if ("eliminar".equals(request.getParameter("action"))) {

            if (NombreUsuario.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de usuario.", "Advertencia - Travel & Propierty Soft 1.0", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            }

            Conexion Connection = new Conexion();
            try {
                ResultSet r = Connection.getCon().prepareStatement("Select NombreUsuario from usuarios").executeQuery();
                while (r.next()) {
                    if (NombreUsuario.equals(r.getString(1))) {

                        int confirma = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la información de este usuario?");

                        if (confirma == JOptionPane.YES_OPTION) {
                            int resultadoEliminar = new NUsuario().eliminar(Usuario);
                            request.setAttribute("cli", resultadoEliminar);
                            JOptionPane.showMessageDialog(null, "Se eliminó correctamente", "Cinosargo Soft 1.0", JOptionPane.INFORMATION_MESSAGE);
                            response.sendRedirect("Usuario.jsp");
                        } else if (confirma == JOptionPane.NO_OPTION) {
                            request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
                        } else if (confirma == JOptionPane.CLOSED_OPTION) {
                            request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
                        } else if (confirma == JOptionPane.CANCEL_OPTION) {
                            request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
                        }
                    }
                }
            } catch (Exception e) {
            }

            try {
                ResultSet r1 = Connection.getCon().prepareStatement("Select NombreUsuario from usuarios").executeQuery();
                while (r1.next()) {
                    if (!NombreUsuario.equals(r1.getString(1)) && (!NombreUsuario.equals(""))) {
                        request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
                        JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique el nombre de usuario", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception e) {
            }

        }

        if ("consultar".equals(accion)) {

            if (NombreUsuario != null && NombreUsuario.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de usuario.", "Advertencia - Cinosargo Soft 1.0", JOptionPane.WARNING_MESSAGE);
                request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
            } else {

                NUsuario negocioC = new NUsuario();
                try {
                    EntUsuario cli = negocioC.Buscar(NombreUsuario);
                    request.setAttribute("cli", cli);
                    request.setAttribute("mensaje", "El usuario fue encontrado con exito");
                    request.getRequestDispatcher("./Usuario.jsp").forward(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(MaestroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("mensaje", ex.getMessage());
                }
            }
        }


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
