<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hola Alumnos</title>
</head>
<body>
  <h1>Este es un Ejemplo de Formulario</h1>
  <form action="procesarFormulario" method="GET">
    <label>Ingrese su Nombre:</label>
	<input type="text" name="nombreAlumno" />
	<input type="submit" value="Enviar Formulario">
  </form>
</body>
</html>