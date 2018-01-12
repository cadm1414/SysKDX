package JAVA.DISTBR.BEAN;

public class BEAN_liquidacion {

    String codigo_operacion, codigo_sucursal, fecha_emision, fecha_registro, numero_documento, codigo_programacion, observacion, status;
    double descuento, total_credito, total_efectivo;

    public String getCodigo_operacion() {
        return codigo_operacion;
    }

    public void setCodigo_operacion(String codigo_operacion) {
        this.codigo_operacion = codigo_operacion;
    }

    public String getCodigo_sucursal() {
        return codigo_sucursal;
    }

    public void setCodigo_sucursal(String codigo_sucursal) {
        this.codigo_sucursal = codigo_sucursal;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getCodigo_programacion() {
        return codigo_programacion;
    }

    public void setCodigo_programacion(String codigo_programacion) {
        this.codigo_programacion = codigo_programacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal_credito() {
        return total_credito;
    }

    public void setTotal_credito(double total_credito) {
        this.total_credito = total_credito;
    }

    public double getTotal_efectivo() {
        return total_efectivo;
    }

    public void setTotal_efectivo(double total_efectivo) {
        this.total_efectivo = total_efectivo;
    }

}
