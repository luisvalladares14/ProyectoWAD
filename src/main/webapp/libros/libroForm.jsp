
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Agregar Registro</h1>
            <s:form action="almacenarLibro">
                <s:hidden name="dto.entidad.codigoLibro"/>
                <div>
                    <s:textfield name="dto.entidad.autorLibro" 
                                 key="libro.autorLibro"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.tituloLibro" 
                                 key="libro.tituloLibro"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.statusLibro" 
                                 key="libro.statusLibro"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.generoLibro" 
                                 key="libro.generoLibro"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.idSucursal" 
                                 key="libro.idSucursal"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.codigoUnico" 
                                 key="libro.codigoUnico"
                                 required="required"/>
                </div>
                    <s:submit key="libro.boton.guardar" class="btn btn-success"/>  
            </s:form>
        </div>
    </body>
</html>
