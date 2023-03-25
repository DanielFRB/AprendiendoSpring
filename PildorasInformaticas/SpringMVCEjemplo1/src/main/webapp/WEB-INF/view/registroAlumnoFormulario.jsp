<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Formulario de Registro de Alumnos</title>
	</head>
	<body>
		<form:form action="procesarFormulario" modelAttribute="miAlumno">
			<form:label path="nombre">Nombre: </form:label>
			<form:input path="nombre"/>
			<br/><br/>
			<form:label path="apellido">Apellido: </form:label>
			<form:input path="apellido"/>
			<br/><br/>
			<p>Asignaturas Optativas:</p>
			<form:select path="optativa" multiple="true">
				<form:option value="Diseño" label="Diseño"></form:option>
				<form:option value="Deportes" label="Deportes"></form:option>
				<form:option value="Comercio" label="Comercio"></form:option>
				<form:option value="Danzas" label="Danzas"></form:option>
			</form:select>
			<br/><br/>
			<p>Ciudades Disponibles:</p>
			<form:label path="ciudadEstudios">Barcelona: </form:label>
			<form:radiobutton path="ciudadEstudios" value="Barcelona"/>
			<form:label path="ciudadEstudios">Madrid: </form:label>
			<form:radiobutton path="ciudadEstudios" value="Madrid"/>
			<form:label path="ciudadEstudios">Valencia: </form:label>
			<form:radiobutton path="ciudadEstudios" value="Valencia"/>
			<form:label path="ciudadEstudios">Bilvao: </form:label>
			<form:radiobutton path="ciudadEstudios" value="Bilvao"/>
			<br/><br/>
			<p>Idiomas Disponibles:</p>
			<form:label path="idiomasAlumno">Inglés: </form:label>
			<form:checkbox path="idiomasAlumno" value="Inglés"/>
			<form:label path="idiomasAlumno">Alemán: </form:label>
			<form:checkbox path="idiomasAlumno" value="Alemán"/>
			<form:label path="idiomasAlumno">Francés: </form:label>
			<form:checkbox path="idiomasAlumno" value="Francés"/>
			<form:label path="idiomasAlumno">Chino: </form:label>
			<form:checkbox path="idiomasAlumno" value="Chino"/>
			<br/><br/>
			<form:button>Enviar</form:button>
		</form:form>
	</body>
</html>