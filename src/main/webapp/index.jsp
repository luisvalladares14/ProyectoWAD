
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <a href="<s:url action="listarEstantes"/>" class="btn btn-outline-info">
            Lista de Estantes
        </a>
        <a href="<s:url action="listarLibros"/>" class="btn btn-outline-info">
            Lista de Libros
        </a>
        <a href="<s:url action="listarPersonas"/>" class="btn btn-outline-info">
            Lista de Personas
        </a>
        <a href="<s:url action="listarSucursales"/>" class="btn btn-outline-info">
            Lista de Sucursales
        </a>
        <a href="<s:url action="listarTransaciiones"/>" class="btn btn-outline-info">
            Lista de Transacciones
        </a>
    </body>
</html>
