package edu.uni.dbd.pc04.bean;

public class ProyectoUltResponse {
    private String nombre;
    private String codigo;
    private String estado;
    private String jefe_area;
    private String fecha_inicio_real;
    private String fecha_fin_estimada;
    private String fecha_fin_real;

    public ProyectoUltResponse(String nombre, String codigo, String estado, String jefe_area, String fecha_inicio_real, String fecha_fin_estimada, String fecha_fin_real) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.jefe_area = jefe_area;
        this.fecha_inicio_real = fecha_inicio_real;
        this.fecha_fin_estimada = fecha_fin_estimada;
        this.fecha_fin_real = fecha_fin_real;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getJefe_area() {
        return jefe_area;
    }

    public void setJefe_area(String jefe_area) {
        this.jefe_area = jefe_area;
    }

    public String getFecha_inicio_real() {
        return fecha_inicio_real;
    }

    public void setFecha_inicio_real(String fecha_inicio_real) {
        this.fecha_inicio_real = fecha_inicio_real;
    }

    public String getFecha_fin_estimada() {
        return fecha_fin_estimada;
    }

    public void setFecha_fin_estimada(String fecha_fin_estimada) {
        this.fecha_fin_estimada = fecha_fin_estimada;
    }

    public String getFecha_fin_real() {
        return fecha_fin_real;
    }

    public void setFecha_fin_real(String fecha_fin_real) {
        this.fecha_fin_real = fecha_fin_real;
    }
}
