<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center text-white">Datos de la Persona</h1>
            <div >
                <s:property value="estante.codigoUnico"/>
            </div>
            <s:property value="dto.entidad.codigoUnico"/>
            <div>
                <s:property value="estante.numeroPiso" />
            </div>
            <s:property value="dto.entidad.numeroPiso" />
            <div>
                <s:property value="estante.numeroPasillo" />
            </div>
            <s:property value="dto.entidad.numeroPasillo" />
            <div >
                <s:property value="estante.numeroSeccion" />
            </div>
            <s:property value="dto.entidad.numeroSeccion" />
            <div >
                <s:property value="estante.idSucursal" />
            </div>
            <s:property value="dto.entidad.idSucursal" />
            <br>
            <a href="<s:url action="listarEstante"/>" class="btn btn-outline-info">
                Lista
            </a>

        </div>
    </body>
</html>

