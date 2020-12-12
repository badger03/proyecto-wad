<%-- 
    Document   : eliminarCategoria
    Created on : Nov 20, 2020, 11:28:40 AM
    Author     : kevyn
--%>

<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            out.println();
            CategoriaDAO dao = new CategoriaDAO();
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoria(id);
            dao.delete(dto);
            %>
    </body>
</html>
