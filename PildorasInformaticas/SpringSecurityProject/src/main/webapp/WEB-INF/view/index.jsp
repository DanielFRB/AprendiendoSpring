<%-- 
    Document   : index
    Created on : Apr 7, 2023, 11:49:36 AM
    Author     : dfrb@ne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenidos</title>
    </head>
    <body>
        <h1>Hello my dear World!</h1>
        <p>Usuario: <security:authentication property="principal.username"/></p>
        <p>Su Rol es: <security:authentication property="principal.authorities"/></p>
        <p><a href="${pageContext.request.contextPath}/admin">Zona de Administrador</a></p>
        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="Cerrar Sesión"/>
        </form:form>
    </body>
</html>
