package JAVA.CONFIG.BEAN;

public class BEAN_usuario_permisos {

    int id_usuario;
    String tipo_almacen, sucursal_almacen;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTipo_almacen() {
        return tipo_almacen;
    }

    public void setTipo_almacen(String tipo_almacen) {
        this.tipo_almacen = tipo_almacen;
    }

    public String getSucursal_almacen() {
        return sucursal_almacen;
    }

    public void setSucursal_almacen(String sucursal_almacen) {
        this.sucursal_almacen = sucursal_almacen;
    }
}
