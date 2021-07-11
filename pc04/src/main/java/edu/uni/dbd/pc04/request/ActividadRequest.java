package edu.uni.dbd.pc04.request;

public class ActividadRequest {
    String codigo;
    String codigo_tipo;

    public ActividadRequest(String codigo, String codigo_tipo) {
        this.codigo = codigo;
        this.codigo_tipo = codigo_tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_tipo() {
        return codigo_tipo;
    }

    public void setCodigo_tipo(String codigo_tipo) {
        this.codigo_tipo = codigo_tipo;
    }
}
