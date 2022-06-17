
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
            <s:form action="almacenarTransaccion">
                <s:hidden name="dto.entidad.numeroTransaccion"/>
                <div>
                    <s:textfield name="dto.entidad.fechaTransaccion" 
                                 key="transaccion.fechaTransaccion"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.fechaTransaccion" 
                                 key="transaccion.fechaTransaccion"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.codigoLibro" 
                                 key="transaccion.codigoLibro"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.idPersona" 
                                 key="transaccion.idPersona"
                                 required="required"/>
                </div>
                <s:submit key="sucursal.boton.guardar" class="btn btn-success"/>  
            </s:form>
        </div>
    </body>
</html>
