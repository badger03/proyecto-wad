<%-- 
    Document   : index
    Created on : Nov 20, 2020, 10:47:01 AM
    Author     : kevyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="estilos.css">
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <!-- Image and text -->
                <nav class="navbar navbar-light bg-light">
                    <a class="navbar-brand" href="principal.jsp">
                        <img src="imagenes/imagen.jpg" width="40" height="40" class="d-inline-block align-top" alt="" loading="lazy">
                        Mi almacén
                    </a>
                </nav>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link active" href="principal.jsp">Home <span class="sr-only">(current)</span></a>
                        <a class="nav-link" href="CategoriaServlet?accion=listaDeCategorias">Lista de categorias</a>
                        <a class="nav-link" href="ProductoServlet?accion=listaDeProductos">Lista de productos</a>
                        <a class="nav-link" href="UsuarioServlet?accion=listaDeUsuarios">Lista de Usuarios</a>
                        <a class="nav-link" href="CategoriaServlet?accion=verPDF" target="_blank">Reporte</a>
                        <a class="nav-link" href="CategoriaServlet?accion=graficar" target="_blank">Grafica</a>
                        <a class="nav-link" href="CerrarSesionServlet">cerrar sesion</a>
                    </div>
                </div>
            </nav>
            <br><br><br><br><br><br><br>
            <div class="card mb-3" >
                <div class="row no-gutters">
                    <div class="col-md-5">
                        <img src="imagenes/imagen.jpg" class="card-img" alt=""width="450" height="450">
                    </div>
                    <div class="col-md-7">
                        <div class="card-body">
                            <h1 class="card-title">Gestion de las categorias de los productos existentes</h1>
                            <br>
                            <p class="card-text">-Esta aplicacion web nos permite gestionar las categorias de los productos existentes en una tienda, los productos y los usuarios.</p>
                            <p class="card-text">-Se utilizaron los patrones de diseño DTO, DAO y MVC.</p>
                            <p class="card-text">-Se utilizo para la web GUI el framework bootstrap.</p>
                            <p class="card-text">-Se diseño una base de datos que nos permite gestionar las categorias, los productos y los usuarios</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
    </body>
</html>