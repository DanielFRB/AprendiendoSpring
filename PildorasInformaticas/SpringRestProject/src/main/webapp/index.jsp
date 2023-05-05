<%-- 
    Document   : index.jsps
    Created on : May 3, 2023, 6:55:49 PM
    Author     : dfrb@ne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aplicacion Spring REST</title>
    </head>
    <body>
        <h1 style="text-align: center">Hello World!!!, this is a Spring REST Application</h1>
        <br/>
        <a href="${pageContext.request.contextPath}/prueba/saludo">Ir a Saludo</a>
    </body>
</html>
