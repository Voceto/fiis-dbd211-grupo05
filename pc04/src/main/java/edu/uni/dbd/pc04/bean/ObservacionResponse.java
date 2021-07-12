package edu.uni.dbd.pc04.bean;

public class ObservacionResponse {
    private String id;
    private String hora_creacion;
    private String hora_levantamiento;
    private String fecha_creacion;
    private String fecha_levatamiento;
    private String estado;
    private String contenido;

    public ObservacionResponse(String id, String hora_creacion, String hora_levantamiento, String fecha_creacion, String fecha_levatamiento, String estado, String contenido) {
        this.id = id;
        this.hora_creacion = hora_creacion;
        this.hora_levantamiento = hora_levantamiento;
        this.fecha_creacion = fecha_creacion;
        this.fecha_levatamiento = fecha_levatamiento;
        this.estado = estado;
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHora_creacion() {
        return hora_creacion;
    }

    public void setHora_creacion(String hora_creacion) {
        this.hora_creacion = hora_creacion;
    }

    public String getHora_levantamiento() {
        return hora_levantamiento;
    }

    public void setHora_levantamiento(String hora_levantamiento) {
        this.hora_levantamiento = hora_levantamiento;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFecha_levatamiento() {
        return fecha_levatamiento;
    }

    public void setFecha_levatamiento(String fecha_levatamiento) {
        this.fecha_levatamiento = fecha_levatamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
