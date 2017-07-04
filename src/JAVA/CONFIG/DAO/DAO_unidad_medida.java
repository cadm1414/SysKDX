package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_unidad_medida;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_unidad_medida {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_unidad_medida";

    public ResultSet FNC_codigo_unidad_medida() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_codigo_unidad_medida() as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_codigo_unidad_medida", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_grid_unidad_medida() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_unidad() "
                    + "as (codigo_unidad character(4),nombre_unidad character varying(60),simbolo_unidad character varying(3))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_unidad_medida", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_unidad_medida(String codigo_unidad) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_unidad_medida('" + codigo_unidad + "') "
                    + "as (codigo_unidad character(4),nombre_unidad character varying(60),simbolo_unidad character varying(3),codigo_sunat character varying(20))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_unidad_medida", e.getMessage());
        }
        return null;
    }

    public boolean DLT_unidad_medida(String codigo_unidad) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_unidad_medida('" + codigo_unidad + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_unidad_medida", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_unidad_medida", e.getMessage());
        }
        return resp;
    }

    public boolean IST_unidad_medida(BEAN_unidad_medida OBJ_bum) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_unidad_medida('" + OBJ_bum.getCodigo_unidad() + "','" + OBJ_bum.getNombre_unidad() + "','" + OBJ_bum.getSimbolo_unidad() + "','006','" + OBJ_bum.getCodigo_sunat() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_unidad_medida", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_unidad_medida", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_unidad_medida(BEAN_unidad_medida OBJ_bum) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_unidad_medida('" + OBJ_bum.getCodigo_unidad() + "','" + OBJ_bum.getNombre_unidad() + "','" + OBJ_bum.getSimbolo_unidad() + "','006','" + OBJ_bum.getCodigo_sunat() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_unidad_medida", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_unidad_medida", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_cbx_unidad_medida() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cbx_unidad_medida() "
                    + "as (codigo_unidad character(4),nombre_unidad character varying(60))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cbx_unidad_medida", e.getMessage());
        }
        return null;
    }
}
