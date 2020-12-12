<%-- 
    Document   : listaDeCategorias
    Created on : Nov 20, 2020, 11:02:35 AM
    Author     : kevyn
--%>
<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO" %>
<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO" %>
<%@page import="java.util.List" %>
<%@page errorPage="error.jsp?de=listaDeCategorias.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de categorias</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        
    </head>
    <body>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>Clave categoria</th>
                        <th>Nombre categoria</th>
                        <th>Descripcion categoria</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CategoriaDAO dao = new CategoriaDAO();
                        List lista = dao.readAll();
                        if (lista != null) {
                            for (int i = 0; i < lista.size(); i++) {
                                CategoriaDTO dto = (CategoriaDTO) lista.get(i);
                    %>
                    <tr>
                        <td><%= dto.getEntidad().getIdCategoria()%></td>
                        <td><%= dto.getEntidad().getNombreCategoria()%></td>
                        <td><%= dto.getEntidad().getDescripcionCategoria()%></td>
                        <td><a href="eliminarCategoria.jsp?id=<% dto.getEntidad().getIdCategoria();%>">Eliminar</a></td>
                       
                    </tr>
                    <% 
                        }
                        }else{
                        out.println("no hay datos");
                        }
                    %>
                </tbody>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
    </body>
</html>
