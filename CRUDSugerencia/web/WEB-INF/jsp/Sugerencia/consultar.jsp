<%-- 
    Document   : consultar
    Created on : 22/09/2017, 05:16:01 PM
    Author     : SALDARRIAGA VILLADA
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Sugerencias</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Lista Sugerencias</h1>
                <p>
                    <a href="<c:url value="add.htm" />" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Nombre Sugerencia</th>
                            <th>Descripcion Sugerencia</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sugerencias}" var="sug">
                            <tr>
                                <td><c:out value="${sug.nombreSugerencia}" /></td>
                                <td><c:out value="${sug.descripcionSugerencia}" /></td>
                                <td>
                                    <a href="<c:url value="editar.htm?codigo=${sug.identificadorSugerencia}" />"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="<c:url value="eliminar.htm?codigo=${sug.identificadorSugerencia}" />"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
        </div>
    </body>
</html>

