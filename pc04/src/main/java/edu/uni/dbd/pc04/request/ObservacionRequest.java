package edu.uni.dbd.pc04.request;

public class ObservacionRequest {
    private int id;
    private String codigo_inf;

    public ObservacionRequest(int id, String codigo_inf) {
        this.id = id;
        this.codigo_inf = codigo_inf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_inf() {
        return codigo_inf;
    }

    public void setCodigo_inf(String codigo_inf) {
        this.codigo_inf = codigo_inf;
    }
}
