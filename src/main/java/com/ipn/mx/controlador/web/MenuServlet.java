package com.ipn.mx.controlador.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.ipn.mx.modelo.dto.UsuarioDTO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "MenuServlet", urlPatterns = { "/MenuServlet" })
public class MenuServlet extends HttpServlet
{
    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        final HttpSession sesion = request.getSession();
        final UsuarioDTO dto = (UsuarioDTO)sesion.getAttribute("usuario");
        if (dto == null) {
            final RequestDispatcher vista = request.getRequestDispatcher("error.jsp");
            vista.forward((ServletRequest)request, (ServletResponse)response);
        }
        else {
            final RequestDispatcher rd = request.getRequestDispatcher("principal.jsp");
            rd.forward((ServletRequest)request, (ServletResponse)response);
        }
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }
    
    public String getServletInfo() {
        return "Short description";
    }
}