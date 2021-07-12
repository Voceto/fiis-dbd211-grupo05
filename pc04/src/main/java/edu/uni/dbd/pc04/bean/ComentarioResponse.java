package edu.uni.dbd.pc04.bean;

public class ComentarioResponse {
    private String contenido;

    public ComentarioResponse(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
