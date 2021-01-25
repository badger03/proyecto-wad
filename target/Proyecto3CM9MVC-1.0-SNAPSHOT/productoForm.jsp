<%-- 
    Document   : productoForm
    Created on : Dec 11, 2020, 9:58:03 PM
    Author     : kevyn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>producto form</title>
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
                        <a class="nav-link" href="ProductoServlet?accion=listaDeProductos">Lista de productos</a>
                        <a class="nav-link" href="ProductoServlet?accion=nuevo">Registrar producto</a>
                        <a class="nav-link" href="CerrarSesionServlet">cerrar sesion</a>
                    </div>
                </div>
            </nav>
            <div class="card-header bg-primary">
                <h1>Datos del producto</h1>
            </div>
            <div class="card-body">
                <form 
                    action="ProductoServlet?accion=guardar"
                    method="post"
                    name="frmProductoForm"
                    id="frmProductoForm"
                    > 
                    <input type="hidden" name="id" id="id"
                           value="<c:out value="${dto.entidad.idProducto}"/>"/>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">Nombre</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtNombre" id="txtNombre"
                                   maxlenght="50" required="required"
                                   placeholder="nombre del producto"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.nombreProducto}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">Descripcion producto</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtDescripcion" id="txtDescripcion"
                                   maxlenght="150" required="required"
                                   placeholder="descripcion del producto"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.descripcionProducto}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">Precio producto</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtPrecio" id="txtPrecio"
                                   maxlenght="150" required="required"
                                   placeholder="precio del producto"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.precio}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">Existencia producto</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtExistencia" id="txtExistencia"
                                   maxlenght="150" required="required"
                                   placeholder="existencia del producto"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.existencia}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label class="col-sm-2 col-form-label">Clave categoria</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" name="txtIdCategoria" id="txtIdCategoria"
                                   maxlenght="150" required="required"
                                   placeholder="clave de la categoria"
                                   class="form-control"
                                   value="<c:out value="${dto.entidad.idCategoria}"/>"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <input type="submit" value="Registrar producto"
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
