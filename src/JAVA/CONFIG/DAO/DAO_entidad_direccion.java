package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_entidad_direccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_entidad_direccion {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_entidad_direccion";

    public ResultSet SLT_grid_entidad_direccion(String codigo_entidad) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_entidad_direccion('" + codigo_entidad + "') "
                    + "as (codigo_direccion character(3),nombre_direccion character varying(150),direccion character varying(250),tipo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_entidad_direccion", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_entidad_direccion(String codigo_entidad, String codigo_direccion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_entidad_direccion('" + codigo_entidad + "','" + codigo_direccion + "') "
                    + "as (codigo_entidad character(6),codigo_direccion character(3),nombre_direccion character varying(150),direccion character varying(250),codigo_ubigeo character(6),descripcion_ubigeo character varying(100),referencia character varying(250),tipo_direccion character(1))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_entidad_direccion", e.getMessage());
        }
        return null;
    }

    public boolean DLT_entidad_direccion(String codigo_entidad, String codigo_direccion) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_entidad_direccion('" + codigo_entidad + "','" + codigo_direccion + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_entidad_direccion", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_entidad_direccion", e.getMessage());
        }
        return resp;
    }

    public boolean IST_entidad_direccion(BEAN_entidad_direccion OBJ_bet) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_entidad_direccion('" + OBJ_bet.getCodigo_entidad() + "','" + OBJ_bet.getNombre_direccion() + "','" + OBJ_bet.getDireccion() + "','" + OBJ_bet.getCodigo_ubigeo() + "','" + OBJ_bet.getDescripcion_ubigeo() + "','" + OBJ_bet.getReferencia() + "','" + OBJ_bet.getTipo_direccion() + "')";

            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_entidad_direccion", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_entidad_direccion", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_entidad_direccion(BEAN_entidad_direccion OBJ_bet) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_entidad_direccion('" + OBJ_bet.getCodigo_entidad() + "','" + OBJ_bet.getCodigo_direccion() + "','" + OBJ_bet.getNombre_direccion() + "','" + OBJ_bet.getDireccion() + "','" + OBJ_bet.getCodigo_ubigeo() + "','" + OBJ_bet.getDescripcion_ubigeo() + "','" + OBJ_bet.getReferencia() + "','" + OBJ_bet.getTipo_direccion() + "')";

            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_entidad_direccion", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_entidad_direccion", e.getMessage());
        }
        return resp;
    }
}
