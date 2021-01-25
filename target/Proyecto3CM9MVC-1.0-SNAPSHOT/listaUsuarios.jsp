<%-- 
    Document   : listaUsuarios
    Created on : Dec 12, 2020, 2:32:43 PM
    Author     : kevyn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de usuarios</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
       
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
                        <a class="nav-link" href="UsuarioServlet?accion=listaDeUsuarios">Lista de usuarios</a>
                        <a class="nav-link" href="UsuarioServlet?accion=nuevo">Registrar usuario</a>
                        <a class="nav-link" href="CerrarSesionServlet">cerrar sesion</a>
                    </div>
                </div>
            </nav>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Clave usuario</th>
                        <th>Nombre</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Email</th>
                        <th>Nombre user</th>
                        <th>Clave user</th>
                        <th>Tipo de usuario</th>
                        <th>Eliminar</th>
                        <th>Actualizar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach 
                        var="usuarios" 
                        items="${listaDeUsuarios}">
                        <tr>
                            <td>
                                <a class="btn btn-primary btn-xs"
                                    href="UsuarioServlet?accion=ver&id=<c:out value="${usuarios.entidad.idUsuario}"/>">
                                    <c:out value="${usuarios.entidad.idUsuario}"/>
                                </a>
                            </td>
                            <td>
                                <c:out value="${usuarios.entidad.nombre}"/>
                            </td>
                             <td>
                                <c:out value="${usuarios.entidad.paterno}"/>
                            </td>
                            <td>
                                <c:out value="${usuarios.entidad.materno}"/>
                            </td>
                            <td>
                                <c:out value="${usuarios.entidad.email}"/>
                            </td>
                            <td>
                                <c:out value="${usuarios.entidad.nombreUsuario}"/>
                            </td>
                            <td>
                                <c:out value="${usuarios.entidad.claveUsuario}"/>
                            </td>
                            <td>
                                <c:out value="${usuarios.entidad.tipoUsuario}"/>
                            </td>
                            <td>
                                <a class="btn btn-danger btn-xs"
                                    href="UsuarioServlet?accion=eliminar&id=<c:out value="${usuarios.entidad.idUsuario}"/>">
                                Eliminar
                                </a>
                            </td>
                             <td>
                                <a class="btn btn-success btn-xs"
                                    href="UsuarioServlet?accion=actualizar&id=<c:out value="${usuarios.entidad.idUsuario}"/>">
                                Actualizar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
    </body>
</html>
