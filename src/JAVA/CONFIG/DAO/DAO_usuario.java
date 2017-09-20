package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_usuario {

    private Statement lq_stm = null;
    private ResultSet lq_rs = null;
    private String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_usuario";

    public ResultSet SLT_login_usuario(BEAN_usuario OBJ_bus) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_usuario_sesion('" + OBJ_bus.getNombre_usuario() + "','" + OBJ_bus.getClave_usuario() + "') "
                    + "as (resp integer,id_usuario integer,nombre_usuario character varying(20),datos_usuario character varying(150),id_rol integer,status character(1),nombre_rol character varying(30),tipo_comercio character(1),codigo_entidad character(6),codigo_vendedor character(4))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "SLT_login_usuario", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_grid_usuario() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_usuario() "
                    + "as (id_usuario integer,nombre_usuario character varying(20),nombre_rol character varying(30))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_usuario", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_usuario(int id_usuario) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_usuario(" + id_usuario + ") "
                    + "as (id_usuario integer,nombre_usuario character varying(20),clave_usuario character varying(150),datos_usuario character varying(150),id_rol integer,status character(1))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_usuario", e.getMessage());
        }
        return null;
    }

    public boolean DLT_usuario(int id_usuario) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_usuario(" + id_usuario + ")";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_usuario", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_usuario", e.getMessage());
        }
        return resp;
    }

    public boolean IST_usuario(BEAN_usuario OBJ_bus) throws SQLException {
        boolean resp = false;
        OBJ_bus.setId_usuario(SLT_ultimo_registro());
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_usuario(" + OBJ_bus.getId_usuario() + ",'" + OBJ_bus.getNombre_usuario() + "','" + OBJ_bus.getClave_usuario() + "','" + OBJ_bus.getDatos_usuario() + "'," + OBJ_bus.getId_rol() + ",'" + OBJ_bus.getStatus() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_usuario", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            SLT_reinicia_registro(OBJ_bus.getId_usuario());
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_usuario", e.getMessage());
        }
        return resp;
    }

    public int SLT_ultimo_registro() {
        int resp = 0;
        try {
            String SQL = "SELECT nextval('usuario_id'::regclass)";
            lq_stm = go_conexion_db.crearStatement();
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                resp = lq_rs.getInt(1);
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
        }
        return resp;
    }

    public void SLT_reinicia_registro(int numero) {
        try {
            String SQL = "ALTER SEQUENCE usuario_id restart " + numero;
            lq_stm = go_conexion_db.crearStatement();
            lq_stm.executeUpdate(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
        }
    }

    public boolean UPD_usuario(BEAN_usuario OBJ_bus, int id_usuario) throws SQLException{
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_usuario(" + id_usuario + ",'" + OBJ_bus.getNombre_usuario() + "','" + OBJ_bus.getClave_usuario() + "','" + OBJ_bus.getDatos_usuario() + "'," + OBJ_bus.getId_rol() + ",'" + OBJ_bus.getStatus() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_usuario", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_usuario", e.getMessage());
        }
        return resp;
    }
}
