package edu.uni.dbd.pc04.bean;

public class InformeResponse {
    private String codigo;
    private String nombre;
    private String fecha;
    private String url_pdf;
    private String codigo_act;
    private String codigo_tipo_act;
    private String dni_empleado;

    public InformeResponse(String codigo, String nombre, String fecha, String url_pdf) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.url_pdf = url_pdf;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrl_pdf() {
        return url_pdf;
    }

    public void setUrl_pdf(String url_pdf) {
        this.url_pdf = url_pdf;
    }


}
