package edu.uni.dbd.pc04.bean;

public class InformeResponse {
    private String codigo;
    private String nombre;
    private String fecha;
    private String url_plano;
    private String resumen;
    private String norma_ref;
    private String empleado;

    public InformeResponse(String codigo, String nombre, String fecha, String url_plano, String resumen, String norma_ref, String empleado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.url_plano = url_plano;
        this.resumen = resumen;
        this.norma_ref = norma_ref;
        this.empleado = empleado;
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

    public String getUrl_plano() {
        return url_plano;
    }

    public void setUrl_plano(String url_plano) {
        this.url_plano = url_plano;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getNorma_ref() {
        return norma_ref;
    }

    public void setNorma_ref(String norma_ref) {
        this.norma_ref = norma_ref;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
}
