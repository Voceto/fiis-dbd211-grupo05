package edu.uni.dbd.pc04.bean;

public class ProyectoLResponse {
    private String cod;
    private String nombre;
    private String f_inicio;
    private String estado;

    public ProyectoLResponse(String cod, String nombre, String f_inicio, String estado) {
        this.cod = cod;
        this.nombre = nombre;
        this.f_inicio = f_inicio;
        this.estado = estado;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(String f_inicio) {
        this.f_inicio = f_inicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}