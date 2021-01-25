<%-- 
    Document   : usuarioForm
    Created on : Dec 12, 2020, 3:29:32 PM
    Author     : kevyn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario form</title>
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
            <div class="card-header bg-primary">
                <h1>Datos del usuario</h1>
            </div>
            <div class="card-body">
                <form 
                    action="UsuarioServlet?accion=guardar"
                    method="post"
                    name="frmUsuarioForm"
                    id="frmUsuarioForm"
                    > 
                    <input type="hidden" name="id" id="id"
                           value="<c:out value="${dto.entidad.idUsuario}"/>"/>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">Nombre</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtNombre" id="txtNombre"
                                   maxlenght="50" required="required"
                                   placeholder="nombre del usuario"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.nombre}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">apellido paterno</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtPaterno" id="txtPaterno"
                                   maxlenght="150" required="required"
                                   placeholder="apellido paterno"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.paterno}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">apellido materno</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtMaterno" id="txtMaterno"
                                   maxlenght="150" required="required"
                                   placeholder="apellido materno"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.materno}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">email</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtEmail" id="txtEmail"
                                   maxlenght="150" required="required"
                                   placeholder="ingresar email"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.email}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">Nombre user</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtNombreUser" id="txtNombreUser"
                                   maxlenght="150" required="required"
                                   placeholder="nombre user"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.nombreUsuario}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">Clave user</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtClaveUser" id="txtClaveUser"
                                   maxlenght="150" required="required"
                                   placeholder="clave user"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.claveUsuario}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">tipo usuario</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtTipoUsuario" id="txtTipoUsuario"
                                   maxlenght="150" required="required"
                                   placeholder="tipo user"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.tipoUsuario}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <input type="submit" value="Registrar usuario"
                                   class="btn btn-primary"/>
                        </div>

                    </div>

                </form>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" ></script>
    </body>
</html>
