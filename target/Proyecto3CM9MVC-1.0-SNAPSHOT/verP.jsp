<%-- 
    Document   : verP
    Created on : Dec 11, 2020, 10:13:27 PM
    Author     : kevyn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver productos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="estilos.css">
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <!-- Image and text -->
                <nav class="navbar navbar-light bg-light">
                    <a class="navbar-brand" href="index.jsp">
                        <img src="imagenes/imagen.jpg" width="40" height="40" class="d-inline-block align-top" alt="" loading="lazy">
                       Proyecto base MVC
                    </a>
                </nav>
                
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link active" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                        <a class="nav-link" href="ProductoServlet?accion=listaDeProductos">Lista de productos</a>

                    </div>
                </div>
            </nav> 
            <div class="card bg-light">
                <div class="card-header">
                    Datos del producto
                </div>
                <div class="card-body">
                    <ul class="list-group">
                        <li class="list-group-item"><c:out value="Clave del producto: ${cat.entidad.idProducto}"/></li>
                        <li class="list-group-item"><c:out value="Nombre del producto: ${cat.entidad.nombreProducto}"/></li>
                        <li class="list-group-item"><c:out value="Descripcion del producto: ${cat.entidad.descripcionProducto}"/></li>
                        <li class="list-group-item"><c:out value="Precio del producto: ${cat.entidad.precio}"/></li>
                        <li class="list-group-item"><c:out value="Existencia del producto: ${cat.entidad.existencia}"/></li>
                        <li class="list-group-item"><c:out value="Clave de la categoria: ${cat.entidad.idCategoria}"/></li>
                        
                    </ul>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
    </body>
</html>