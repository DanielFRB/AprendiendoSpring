<%-- 
    Document   : NuevoCliente
    Created on : Apr 1, 2023, 5:44:59 PM
    Author     : dfrb@ne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
        <title>Modulo de Clientes</title>
    </head>
    <body>
        <div class="regisform">
            <form:form cssClass="form" action="insertaCliente" modelAttribute="cliente" method="POST">
                <form:hidden path="id"/>
                <h1 class="titulo">Clientes</h1>
                <div class="inputCont">
                    <form:label cssClass="label" path="nombre">Nombre: </form:label>
                    <form:input cssClass="input" path="nombre"/>
                </div>
                <br/><br/>
                <div class="inputCont">
                    <form:label cssClass="label" path="apellido">Apellido: </form:label>
                    <form:input cssClass="input" path="apellido"/>
                </div>
                <br/><br/>
                <div class="inputCont">
                    <form:label cssClass="label" path="email">Email: </form:label>
                    <form:input cssClass="input" path="email"/>
                </div>
                <br/><br/>
                <input type="submit" class="submitBtn" value="Guardar"/>
            </form:form>
        </div>
    </body>
</html>
