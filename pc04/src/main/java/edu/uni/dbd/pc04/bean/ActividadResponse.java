package edu.uni.dbd.pc04.bean;

public class ActividadResponse {
    private String codigo;
    private String fecha_inic_prog;
    private String fecha_fin_prog;
    private String estado;
    private String codigo_tipo;
    private String descripcion;
    private String nombre;
    private String frec_ins;
    private String doc_ref;
    private String tip_ver;
    private String tipo_ins;
    private String pto_ins;

    public ActividadResponse(String codigo, String fecha_inic_prog, String fecha_fin_prog, String estado, String codigo_tipo, String descripcion, String nombre, String frec_ins, String doc_ref, String tip_ver, String tipo_ins, String pto_ins) {
        this.codigo = codigo;
        this.fecha_inic_prog = fecha_inic_prog;
        this.fecha_fin_prog = fecha_fin_prog;
        this.estado = estado;
        this.codigo_tipo = codigo_tipo;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.frec_ins = frec_ins;
        this.doc_ref = doc_ref;
        this.tip_ver = tip_ver;
        this.tipo_ins = tipo_ins;
        this.pto_ins = pto_ins;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha_inic_prog() {
        return fecha_inic_prog;
    }

    public void setFecha_inic_prog(String fecha_inic_prog) {
        this.fecha_inic_prog = fecha_inic_prog;
    }

    public String getFecha_fin_prog() {
        return fecha_fin_prog;
    }

    public void setFecha_fin_prog(String fecha_fin_prog) {
        this.fecha_fin_prog = fecha_fin_prog;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo_tipo() {
        return codigo_tipo;
    }

    public void setCodigo_tipo(String codigo_tipo) {
        this.codigo_tipo = codigo_tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFrec_ins() {
        return frec_ins;
    }

    public void setFrec_ins(String frec_ins) {
        this.frec_ins = frec_ins;
    }

    public String getDoc_ref() {
        return doc_ref;
    }

    public void setDoc_ref(String doc_ref) {
        this.doc_ref = doc_ref;
    }

    public String getTip_ver() {
        return tip_ver;
    }

    public void setTip_ver(String tip_ver) {
        this.tip_ver = tip_ver;
    }

    public String getTipo_ins() {
        return tipo_ins;
    }

    public void setTipo_ins(String tipo_ins) {
        this.tipo_ins = tipo_ins;
    }

    public String getPto_ins() {
        return pto_ins;
    }

    public void setPto_ins(String pto_ins) {
        this.pto_ins = pto_ins;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
