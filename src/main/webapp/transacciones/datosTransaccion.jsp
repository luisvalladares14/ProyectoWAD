<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaccion</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center text-white">Datos del Libro</h1>
            <div >
                <s:property value="transaccion.numeroTransaccion"/>
            </div>
            <s:property value="dto.entidad.numeroTransaccion"/>
            <div>
                <s:property value="transaccion.fechaTransaccion"/>
            </div>
            <s:property value="dto.entidad.fechaTransaccion" />
            <div>
                <s:property value="transaccion.horaTransaccion"/>
            </div>
            <s:property value="dto.entidad.horaTransaccion" />
            <div >
                <s:property value="transaccion.codigoLibro"/>
            </div>
            <s:property value="dto.entidad.codigoLibro" />
            <div >
                <s:property value="transaccion.idPersona"/>
            </div>
            <s:property value="dto.entidad.idPersona" />
            
            <br>
            <a href="<s:url action="listarSucursales"/>" class="btn btn-outline-info">
                Lista
            </a>

        </div>
    </body>
</html>

