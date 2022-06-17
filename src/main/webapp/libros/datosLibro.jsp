<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center text-white">Datos del Libro</h1>
            <div >
                <s:property value="libro.codigoLibro"/>
            </div>
            <s:property value="dto.entidad.codigoLibro"/>
            <div>
                <s:property value="libro.autorLibro"/>
            </div>
            <s:property value="dto.entidad.autorLibro" />
            <div>
                <s:property value="libro.tituloLibro"/>
            </div>
            <s:property value="dto.entidad.tituloLibro" />
            <div >
                <s:property value="libro.statusLibro"/>
            </div>
            <s:property value="dto.entidad.statusLibro" />
            <div >
                <s:property value="libro.generoLibro"/>
            </div>
            <s:property value="dto.entidad.generoLibro" />
            <div >
                <s:property value="libro.idSucursal"/>
            </div>
            <s:property value="dto.entidad.idSucursal" />
            <div >
                <s:property value="libro.codigoUnico"/>
            </div>
            <s:property value="dto.entidad.codigoUnico" />
            
            <br>
            <a href="<s:url action="listarLibros"/>" class="btn btn-outline-info">
                Lista
            </a>

        </div>
    </body>
</html>

