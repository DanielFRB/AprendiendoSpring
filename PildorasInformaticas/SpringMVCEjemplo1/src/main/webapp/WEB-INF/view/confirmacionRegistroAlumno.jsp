<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Confirmacion de Registro</title>
	</head>
	<body>
		<p>El alumno ${miAlumno.nombre} ${miAlumno.apellido}, edad: ${miAlumno.edad}. Se ha registrado con exito.</p>
		<p>Se ha enviado una notificacion a su correo electronico ${miAlumno.email}.</p>
		<p>La asignatura escogida es: ${miAlumno.optativa}</p>
		<p>La Ciudad donde iniciara los estudios el alumno es: ${miAlumno.ciudadEstudios}</p>
		<p>Los Idiomas a estudiar por el alumno son: ${miAlumno.idiomasAlumno}</p>
	</body>
</html>