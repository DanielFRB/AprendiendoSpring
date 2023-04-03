<%-- 
    Document   : lista_clientes
    Created on : Mar 30, 2023, 6:56:48 PM
    Author     : dfrb@ne
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Listado de Clientes</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
    </head>
    <body>
        <h1>Listado de Clientes</h1>
        <table>
            <thead>
                <tr>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Email</th>
                    <th>Modificar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${clientes}">
                    <c:url var="linkModificar" value="/cliente/modificaCliente">
                        <c:param name="id" value="${c.id}"></c:param>
                    </c:url>
                    <c:url var="linkEliminar" value="/cliente/eliminaCliente">
                        <c:param name="id" value="${c.id}"></c:param>
                    </c:url>
                    <tr>
                        <td>${c.nombre}</td>
                        <td>${c.apellido}</td>
                        <td>${c.email}</td>
                        <td>
                            <a href="${linkModificar}"><input type="button" value="Modificar"/></a>
                        </td>
                        <td>
                            <a href="${linkEliminar}"><input type="button" value="Eliminar" 
                                onclick="if (!(confirm('Está seguro de Eliminar el registro?'))) return false"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div id="buttonContainer">
            <button type="button" onclick="window.location.href='registroNuevoCliente'">Nuevo Cliente</button>
        </div>
    </body>
</html>