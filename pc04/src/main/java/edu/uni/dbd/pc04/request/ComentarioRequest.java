package edu.uni.dbd.pc04.request;

public class ComentarioRequest {
    private int orden;
    private String contenido;
    private String username;
    private int id_observacion;

    public ComentarioRequest(int orden, String contenido, String username, int id_observacion) {
        this.orden = orden;
        this.contenido = contenido;
        this.username = username;
        this.id_observacion = id_observacion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_observacion() {
        return id_observacion;
    }

    public void setId_observacion(int id_observacion) {
        this.id_observacion = id_observacion;
    }
}
