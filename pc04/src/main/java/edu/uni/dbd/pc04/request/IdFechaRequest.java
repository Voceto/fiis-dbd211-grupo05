package edu.uni.dbd.pc04.request;

public class IdFechaRequest {
    private String id;
    private String fmin;
    private String fmax;

    public IdFechaRequest(String id, String fmin, String fmax) {
        this.id = id;
        this.fmin = fmin;
        this.fmax = fmax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
