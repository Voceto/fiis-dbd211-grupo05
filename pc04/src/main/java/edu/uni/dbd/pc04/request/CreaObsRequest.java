package edu.uni.dbd.pc04.request;

public class CreaObsRequest {
    private String comentario;
    private String inf_id;

    public CreaObsRequest(String comentario, String inf_id) {
        this.comentario = comentario;
        this.inf_id = inf_id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getInf_id() {
        return inf_id;
    }

    public void setInf_id(String inf_id) {
        this.inf_id = inf_id;
    }
}
