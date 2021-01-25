<%-- 
    Document   : categoriaForm
    Created on : Nov 24, 2020, 11:12:06 AM
    Author     : kevyn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categoria form</title>
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
                        <a class="nav-link" href="CategoriaServlet?accion=listaDeCategorias">Lista de categorias</a>
                        <a class="nav-link" href="CategoriaServlet?accion=nuevo">Registrar categoria</a>
                        <a class="nav-link" href="CerrarSesionServlet">cerrar sesion</a>
                    </div>
                </div>
            </nav>
            <div class="card-header bg-primary">
                <h1>Datos de la categoria</h1>
            </div>
            <div class="card-body">
                <form 
                    action="CategoriaServlet?accion=guardar"
                    method="post"
                    name="frmCategoriaForm"
                    id="frmCategoriaForm"
                    > 
                    <input type="hidden" name="id" id="id"
                           value="<c:out value="${dto.entidad.idCategoria}"/>"/>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label col-form-label-lg">Nombre</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtNombre" id="txtNombre"
                                   maxlenght="50" required="required"
                                   placeholder="nombre de la categoria"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.nombreCategoria}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-6 col-form-label col-form-label-lg">Descripcion categoria</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtDescripcion" id="txtDescripcion"
                                   maxlenght="150" required="required"
                                   placeholder="descripcion de la categoria"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.descripcionCategoria}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <input type="submit" value="Registrar categoria"
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
