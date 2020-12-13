<%-- 
    Document   : verU
    Created on : Dec 12, 2020, 4:52:14 PM
    Author     : kevyn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver usuario</title>
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
                        <a class="nav-link" href="UsuarioServlet?accion=listaDeUsuarios">Lista de usuarios</a>

                    </div>
                </div>
            </nav> 
            <div class="card bg-light">
                <div class="card-header">
                    Datos del usuario
                </div>
                <div class="card-body">
                    <ul class="list-group">
                        <li class="list-group-item"><c:out value="Clave del usuario: ${cat.entidad.idUsuario}"/></li>
                        <li class="list-group-item"><c:out value="Nombre: ${cat.entidad.nombre}"/></li>
                        <li class="list-group-item"><c:out value="Apellido paterno: ${cat.entidad.paterno}"/></li>
                        <li class="list-group-item"><c:out value="Apellido materno: ${cat.entidad.materno}"/></li>
                        <li class="list-group-item"><c:out value="Correo electronico: ${cat.entidad.email}"/></li>
                        <li class="list-group-item"><c:out value="Nombre de usuario: ${cat.entidad.nombreUsuario}"/></li>
                        <li class="list-group-item"><c:out value="Clave de usuario: ${cat.entidad.claveUsuario}"/></li>
                        <li class="list-group-item"><c:out value="Tipo de usuario: ${cat.entidad.tipoUsuario}"/></li>
                        
                    </ul>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
    </body>
</html>
