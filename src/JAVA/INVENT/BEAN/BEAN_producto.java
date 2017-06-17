package JAVA.INVENT.BEAN;

public class BEAN_producto {

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getClase_producto() {
        return clase_producto;
    }

    public void setClase_producto(String clase_producto) {
        this.clase_producto = clase_producto;
    }

    public String getDias_almacen() {
        return dias_almacen;
    }

    public void setDias_almacen(String dias_almacen) {
        this.dias_almacen = dias_almacen;
    }

    public String getCodigo_arancel() {
        return codigo_arancel;
    }

    public void setCodigo_arancel(String codigo_arancel) {
        this.codigo_arancel = codigo_arancel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAfecto_detraccion() {
        return afecto_detraccion;
    }

    public void setAfecto_detraccion(String afecto_detraccion) {
        this.afecto_detraccion = afecto_detraccion;
    }

    public String getAfecto_percepcion() {
        return afecto_percepcion;
    }

    public void setAfecto_percepcion(String afecto_percepcion) {
        this.afecto_percepcion = afecto_percepcion;
    }

    String codigo_producto, nombre_producto, clase_producto, dias_almacen, codigo_arancel, status, afecto_detraccion, afecto_percepcion;

}
