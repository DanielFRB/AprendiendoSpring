package com.dfrb.spring;

/**
 * @author dfrb@ne
 */

public class DatosEmpleado {
    public DatosEmpleado() {
    }

    public DatosEmpleado(String domicilio, String ciudad, String codigo_postal, String pais, String fecha_alta) {
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
        this.pais = pais;
        this.fecha_alta = fecha_alta;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    @Override
    public String toString() {
        return "DatosEmpleado{" + "domicilio=" + domicilio + ", ciudad=" + ciudad + ", codigo_postal=" + codigo_postal + ", pais=" + pais + ", fecha_alta=" + fecha_alta + '}';
    }
    
    private String domicilio;
    private String ciudad;
    private String codigo_postal;
    private String pais;
    private String fecha_alta;
}
