<%-- 
    Document   : agregar
    Created on : 22/09/2017, 04:22:19 PM
    Author     : SALDARRIAGA VILLADA
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Agregar Sugerencia</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/home.htm" />">Lista de estudiantes</a></li>
                <li class="active">Agregar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario</div>
                <div class="panel-body">
                   
                        <form:form method="post" commandName="sugerencia">
                            <h1>Crear Sugerencia</h1>
                            
                            <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            <p>
                                <form:label path="nombreSugerencia">Nombre Sugerencia:</form:label>
                                <form:input path="nombreSugerencia" cssClass="form-control" />
                                
                            </p>
                            
                            <p>
                                <form:label path="descripcionSugerencia">Descripción Sugerencia:</form:label>
                                <form:input path="descripcionSugerencia" cssClass="form-control" />
                                
                            </p>
                            <hr />
                            <input type="submit" value="Enviar" class="btn btn-danger" />
                        </form:form>
                </div>
            </div>
        </div>
    </body>
</html>

