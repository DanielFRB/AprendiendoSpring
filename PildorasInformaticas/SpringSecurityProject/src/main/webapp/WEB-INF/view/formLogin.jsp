<%-- 
    Document   : formLogin
    Created on : Apr 8, 2023, 4:12:02 PM
    Author     : dfrb@ne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
    </head>
    <body>
        <h2>Inicio de Sesión</h2>
        <form:form action="${pageContext.request.contextPath}/userAuthentication" method="POST">
            <p>
                Usuario: <input type="text" name="username"/>
            </p>
            <p>
                Contraseña <input type="password" name="password"/>
            </p>
            <input type="submit" value="Login"/>
        </form:form>
    </body>
</html>
