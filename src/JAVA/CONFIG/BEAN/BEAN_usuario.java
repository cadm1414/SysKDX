package JAVA.CONFIG.BEAN;

public class BEAN_usuario {
    int id_usuario,id_rol ;
    String nombre_usuario,clave_usuario,datos_usuario,status;

    public int getId_usuario() {
        return id_usuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getClave_usuario() {
        return clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }

    public String getDatos_usuario() {
        return datos_usuario;
    }

    public void setDatos_usuario(String datos_usuario) {
        this.datos_usuario = datos_usuario;
    }
}
