
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estante</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Agregar Registro</h1>
            <s:form action="almacenarEstante">
                <s:hidden name="dto.entidad.codigoUnico"/>
                <div>
                    <s:textfield name="dto.entidad.numeroPiso" 
                                 key="estante.numeroPiso"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.numeroPasillo" 
                                 key="estante.numeroPasillo"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.numeroSeccion" 
                                 key="estante.numeroSeccion"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.idSucursal" 
                                 key="estante.idSucursal"
                                 required="required"/>
                </div>
                    <s:submit key="estante.boton.guardar" class="btn btn-success"/>  
            </s:form>
        </div>
    </body>
</html>
