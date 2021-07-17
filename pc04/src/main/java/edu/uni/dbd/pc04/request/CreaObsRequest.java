package edu.uni.dbd.pc04.request;

public class CreaObsRequest {
    private String asunto;
    private String contenido;
    private String inf_id;

    public CreaObsRequest(String asunto, String contenido, String inf_id) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.inf_id = inf_id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getInf_id() {
        return inf_id;
    }

    public void setInf_id(String inf_id) {
        this.inf_id = inf_id;
    }
}
