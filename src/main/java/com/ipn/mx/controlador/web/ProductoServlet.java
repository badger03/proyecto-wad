/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador.web;

import com.ipn.mx.modelo.dao.ProductoDAO;
import com.ipn.mx.modelo.dto.ProductoDTO;
import com.ipn.mx.utilerias.EnviarMail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevyn
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        if (accion.equals("listaDeProductos")) {
            listaDeProductos(request, response);
        } else {
            if (accion.equals("nuevo")) {
                agregarProducto(request, response);
            } else {
                if (accion.equals("eliminar")) {
                    eliminarProducto(request, response);
                } else {
                    if (accion.equals("actualizar")) {
                        actualizarProducto(request, response);
                    } else {
                        if (accion.equals("guardar")) {
                            almacenarProducto(request, response);
                        } else {
                            if (accion.equals("ver")) {
                                mostrarProducto(request, response);
                            }
                        }
                    }
                }
            }
        }
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
        processRequest(request, response);
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

    private void listaDeProductos(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO dao = new ProductoDAO();
        try {
            List lista = dao.readAll();
            request.setAttribute("listaDeProductos", lista);
            RequestDispatcher vista = request.getRequestDispatcher("listaProductos.jsp");
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("productoForm.jsp");

        try {
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();
        EnviarMail email=new EnviarMail();
        String destinatario="kevyn.proyectowad@gmail.com";
        String asunto,mensaje;
        dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));
        try {
            dao.delete(dto);
            asunto="Producto eliminado";
                mensaje="Se elimino el producto satisfactoriamente :D";
                email.enviarCorreo(destinatario, asunto, mensaje);
            listaDeProductos(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();
        dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));
        try {
            dto = dao.read(dto);
            request.setAttribute("dto", dto);
            RequestDispatcher rd = request.getRequestDispatcher("productoForm.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void almacenarProducto(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();
        EnviarMail email=new EnviarMail();
        String destinatario="kevyn.proyectowad@gmail.com";
        String asunto,mensaje;
        dto.getEntidad().setNombreProducto(request.getParameter("txtNombre"));
        dto.getEntidad().setDescripcionProducto(request.getParameter("txtDescripcion"));
        dto.getEntidad().setPrecio(Float.parseFloat(request.getParameter("txtPrecio")));
        dto.getEntidad().setExistencia(Integer.parseInt(request.getParameter("txtExistencia")));
        dto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("txtIdCategoria")));

        try {
            if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
                dao.create(dto);
                asunto="Registro de producto";
                mensaje="Se registro el nuevo producto satisfactoriamente :D";
                email.enviarCorreo(destinatario, asunto, mensaje);
                listaDeProductos(request, response);
            } else {
                dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));
                dao.update(dto);
                asunto="Actualizacion de producto";
                mensaje="Se actualizo el producto satisfactoriamente :D";
                email.enviarCorreo(destinatario, asunto, mensaje);
                listaDeProductos(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void mostrarProducto(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();
        dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher rd = request.getRequestDispatcher("verP.jsp");//cambiar este jsp
        try {
            dto = dao.read(dto);
            request.setAttribute("cat", dto);
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
