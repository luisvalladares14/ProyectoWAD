
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucursal</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Agregar Registro</h1>
            <s:form action="almacenarSucursal">
                <s:hidden name="dto.entidad.idSucursal"/>
                <div>
                    <s:textfield name="dto.entidad.direccionSucursal" 
                                 key="sucursal.direccionSucursal"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.codigoPostal" 
                                 key="sucursal.codigoPostal"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.numeroTelefono" 
                                 key="sucursal.numeroTelefono"
                                 required="required"/>
                </div>
                <s:submit key="sucursal.boton.guardar" class="btn btn-success"/>  
            </s:form>
        </div>
    </body>
</html>
