package com.dfrb.spring.mvc;

import javax.validation.constraints.*;

import com.dfrb.spring.mvc.validations.CodPostalMadrid;

/**
 * @author dfrb@ne
 */

public class Alumno {
	public Alumno() {
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getOptativa() {
		return optativa;
	}

	public void setOptativa(String optativa) {
		this.optativa = optativa;
	}
	
	public String getCiudadEstudios() {
		return ciudadEstudios;
	}

	public void setCiudadEstudios(String ciudadEstudios) {
		this.ciudadEstudios = ciudadEstudios;
	}
	
	public String getIdiomasAlumno() {
		return idiomasAlumno;
	}

	public void setIdiomasAlumno(String idiomasAlumno) {
		this.idiomasAlumno = idiomasAlumno;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	// Validacion de Formularios en Spring
	@NotNull
	@Size(min = 2, message = "Campo Solicitado: No puede estar en blanco")
	private String nombre;
	
	private String apellido;
	private String optativa;
	private String ciudadEstudios;
	private String idiomasAlumno;
	
	// Validacion de Formularios en Spring
	@Min(value = 16, message = "Su Edad no deberia ser menor de 16 años")
    @Max(value = 110, message = "Su Edad no deberia ser mayor de 110 años")
    private int edad;

	// Validacion de Formularios en Spring
    @Email(message = "El Email debe ser valido")
    private String email;
    
    // Validacion de Formularios en Spring con Expresiones Regulares
    // @Pattern(regexp = "[0-9]{5}", message = "Solo 5 valores numericos")
    
    // Validacion CodigoPostal personalizada
    @CodPostalMadrid
    private String codigoPostal;
}
