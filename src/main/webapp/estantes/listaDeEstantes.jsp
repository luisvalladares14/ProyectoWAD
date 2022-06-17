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
            <div class="card text-primary border-info mb-3">
                <div class="card-header text-center">
                    <h1> 
                        <s:property value="titulo"/> 
                    </h1>
                </div>
                <div class="card-body table-responsive">
                    <h4 class="card-title">
                        <a href="<s:url action="agregarEstante"/>" class="btn btn-outline-info">
                            <s:property value="nuevo"/>
                        </a>
                    </h4>
                    <div class="mb-3"></div>
                    <table class="table table-responsive">
                        <tr>
                            <td>
                                <s:property value="codigoUnico"/>
                            </td>
                            <td>
                                <s:property value="numeroPiso"/>
                            </td>
                            <td>
                                Eliminar
                            </td>
                            <td>
                                Actualizar
                            </td>
                        </tr>
                        <s:iterator value="estantes">
                            <tr>
                                <td>
                                    <s:url action="verEstante" var="dto">
                                        <s:param name="dto.entidad.codigoUnico" value="%{entidad.codigoUnico}"/>
                                    </s:url>
                                    <s:a href="%{dto}" class="btn btn-outline-success">
                                        <s:property value="entidad.codigoUnico"/>
                                    </s:a>
                                </td>
                                <td>
                                    <s:property value="entidad.numeroPiso"/>
                                </td>
                                <td>
                                    <s:url action="eliminarEstante" var="dto">
                                        <s:param name="dto.entidad.codigoUnico" value="%{entidad.codigoUnico}"/>
                                    </s:url>
                                    <s:a href="%{dto}" class="btn btn-outline-danger">
                                        <s:property value="eliminar"/>
                                    </s:a>
                                </td>
                                <td>
                                    <s:url action="actualizarEstante" var="dto">
                                        <s:param name="dto.entidad.codigoUnico" value="%{entidad.codigoUnico}"/>
                                    </s:url>
                                    <s:a href="%{dto}" class="btn btn-outline-info">
                                        <s:property value="actualizar"/>
                                    </s:a>
                                </td>
                            </tr>
                        </s:iterator>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
