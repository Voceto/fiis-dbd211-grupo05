package edu.uni.dbd.pc04.request;

public class ActividadFechaRequest {
    String codigo;
    String codigo_tipo;
    String fmin;
    String fmax;

    public ActividadFechaRequest(String codigo, String codigo_tipo, String fmin, String fmax) {
        this.codigo = codigo;
        this.codigo_tipo = codigo_tipo;
        this.fmin = fmin;
        this.fmax = fmax;
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

    public String getFmin() {
        return fmin;
    }

    public void setFmin(String fmin) {
        this.fmin = fmin;
    }

    public String getFmax() {
        return fmax;
    }

    public void setFmax(String fmax) {
        this.fmax = fmax;
    }
}
