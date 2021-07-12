package edu.uni.dbd.pc04.bean;

public class ProyectoResponse {
    private String nombre;
    private String cod;
    private String estado;
    private String finicio_prog;
    private String finicio_real;
    private String fentrega_prog;
    private String fentrega_real;
    private String jefe;

    public ProyectoResponse(String nombre, String cod, String estado, String finicio_prog, String finicio_real, String fentrega_prog, String fentrega_real, String jefe) {
        this.nombre = nombre;
        this.cod = cod;
        this.estado = estado;
        this.finicio_prog = finicio_prog;
        this.finicio_real = finicio_real;
        this.fentrega_prog = fentrega_prog;
        this.fentrega_real = fentrega_real;
        this.jefe = jefe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFinicio_prog() {
        return finicio_prog;
    }

    public void setFinicio_prog(String finicio_prog) {
        this.finicio_prog = finicio_prog;
    }

    public String getFinicio_real() {
        return finicio_real;
    }

    public void setFinicio_real(String finicio_real) {
        this.finicio_real = finicio_real;
    }

    public String getFentrega_prog() {
        return fentrega_prog;
    }

    public void setFentrega_prog(String fentrega_prog) {
        this.fentrega_prog = fentrega_prog;
    }

    public String getFentrega_real() {
        return fentrega_real;
    }

    public void setFentrega_real(String fentrega_real) {
        this.fentrega_real = fentrega_real;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }
}
