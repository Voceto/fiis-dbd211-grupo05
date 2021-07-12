package edu.uni.dbd.pc04.request;

public class ComentarioRequest {
    private String contenido;
    private String username;
    private String id_observacion;

    public ComentarioRequest(String contenido, String username, String id_observacion) {

        this.contenido = contenido;
        this.username = username;
        this.id_observacion = id_observacion;
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

    public String getId_observacion() {
        return id_observacion;
    }

    public void setId_observacion(String id_observacion) {
        this.id_observacion = id_observacion;
    }
}
