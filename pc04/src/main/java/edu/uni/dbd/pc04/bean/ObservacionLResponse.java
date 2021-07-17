package edu.uni.dbd.pc04.bean;

public class ObservacionLResponse {
    private String id;
    private String asunto;
    private String hora_creacion;
    private String fecha_creacion;
    private String estado;

    public ObservacionLResponse(String id, String asunto, String hora_creacion, String fecha_creacion, String estado) {
        this.id = id;
        this.asunto = asunto;
        this.hora_creacion = hora_creacion;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getHora_creacion() {
        return hora_creacion;
    }

    public void setHora_creacion(String hora_creacion) {
        this.hora_creacion = hora_creacion;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
