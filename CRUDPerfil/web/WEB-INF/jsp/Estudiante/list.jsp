<%-- 
    Document   : list
    Created on : 21-sep-2017, 22:53:06
    Author     : Juan
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Estudiantes</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Lista Estudiantes</h1>
                <p>
                    <a href="<c:url value="add.htm" />" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Email</th>
                            <th>Programa</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${estudiantes}" var="est">
                            <tr>
                                <td><c:out value="${est.codigo}" /></td>
                                <td><c:out value="${est.nombre}" /></td>
                                <td><c:out value="${est.apellido}" /></td>
                                <td><c:out value="${est.email}" /></td>
                                <td><c:out value="${est.programa}" /></td>
                                <td>
                                    <a href="<c:url value="edit.htm?codigo=${est.codigo}" />"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="<c:url value="delete.htm?codigo=${est.codigo}" />"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
        </div>
    </body>
</html>
