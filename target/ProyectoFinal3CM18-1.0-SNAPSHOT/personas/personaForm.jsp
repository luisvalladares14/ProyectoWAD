
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Agregar Personas</h1>
            <s:form action="almacenarPersona">
                <s:hidden name="dto.entidad.idPersona"/>
                <div>
                    <s:textfield name="dto.entidad.nombrePersona" 
                                 key="persona.nombrePersona"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.correoPersona" 
                                 key="persona.correoPersona"
                                 required="required"/>
                </div>
                <div>
                    <s:textfield name="dto.entidad.numeroPersona" 
                                 key="persona.numeroPersona"
                                 required="required"/>
                </div>
                    <s:submit key="persona.boton.guardar" class="btn btn-success"/>  
            </s:form>
        </div>
    </body>
</html>
