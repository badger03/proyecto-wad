/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador.web;

import com.ipn.mx.modelo.dao.UsuarioDAO;
import com.ipn.mx.modelo.dto.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jesus
 */
@WebServlet(name = "SesionServlet", urlPatterns = {"/SesionServlet"})
public class SesionServlet extends HttpServlet {

    int resultado;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String action = "action";

        if (action.equals("registrar")) {

            almacenarUsuario(request, response);

        } else {
            UsuarioDAO dao = new UsuarioDAO();
            UsuarioDTO dto = new UsuarioDTO();

            dto.getEntidad().setNombreUsuario(request.getParameter("txtNombreUsuario"));
            dto.getEntidad().setClaveUsuario(request.getParameter("txtClaveUsuario"));
            try {

                resultado = dao.readUsuario(dto);
                

                if (resultado == 1) {
                    HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("usuario", dto);
                    RequestDispatcher vista = request.getRequestDispatcher("MenuServlet");
                    vista.forward(request, response);
                } else {
                    RequestDispatcher vista = request.getRequestDispatcher("index.jsp");
                    vista.forward(request, response);
                }
            } catch (SQLException | ServletException | IOException ex) {
                Logger.getLogger(SesionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void almacenarUsuario(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SesionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
