package edu.uni.dbd.pc04.bean;

public class ComentarioResponse {
    private String username;
    private String contenido;
    private String orden;
    private String fecha;
    private String hora;

    public ComentarioResponse(String username, String contenido, String orden, String fecha, String hora) {
        this.username = username;
        this.contenido = contenido;
        this.orden = orden;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
