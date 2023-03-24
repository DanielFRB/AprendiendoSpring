<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="ISO-8859-1">
	<title>Respuesta Hola Alumnos</title>
	<link rel="stylesheet" type="text/css" 
	  href="${pageContext.request.contextPath}/resources/css/styles.css">
  </head>
  <body>
  	<h1>Bienvenido a Spring MVC</h1>
  	<p>Hola ${param.nombreAlumno}, aqui aprenderas Spring</p>
  	<br>
  	<h3>Respuesta del Controlador</h3>
  	<p>${mensajeClaro}</p>
  	<br>
	<img alt="foto" width="700px" height="450px"
	  src="${pageContext.request.contextPath}/resources/images/ecoExamenYaneth.jpg">
  </body>
</html>