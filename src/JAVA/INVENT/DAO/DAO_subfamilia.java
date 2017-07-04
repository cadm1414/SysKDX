package JAVA.INVENT.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.BEAN.BEAN_subfamilia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_subfamilia {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "INVENT", ls_capa = "DAO", ls_clase = "DAO_subfamilia";

    public ResultSet FNC_codigo_subfamilia() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_codigo_subfamilia() as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_codigo_subfamilia", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_grid_subfamilia() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_subfamilia() "
                    + "as (codigo_subfamilia character(4),nombre_subfamilia character varying(60))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());            
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_subfamilia", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_subfamilia(String codigo_familia) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_subfamilia('" + codigo_familia + "') "
                    + "as (codigo_subfamilia character(4),nombre_subfamilia character varying(60),codigo_familia character(4))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_subfamilia", e.getMessage());
        }
        return null;
    }

    public boolean DLT_subfamilia(String codigo_subfamilia) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_subfamilia('" + codigo_subfamilia + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_subfamilia", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_subfamilia", e.getMessage());
        }
        return resp;
    }

    public boolean IST_subfamilia(BEAN_subfamilia OBJ_bsf) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_subfamilia('" + OBJ_bsf.getCodigo_subfamilia() + "','" + OBJ_bsf.getNombre_subfamilia() + "','" + OBJ_bsf.getCodigo_familia() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_subfamilia", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_subfamilia", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_subfamilia(BEAN_subfamilia OBJ_bsf) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_subfamilia('" + OBJ_bsf.getCodigo_subfamilia() + "','" + OBJ_bsf.getNombre_subfamilia() + "','" + OBJ_bsf.getCodigo_familia() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_subfamilia", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_subfamilia", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_cbx_subfamilia_x_familia(String codigo) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cbx_subfamilia_x_familia('" + codigo + "') "
                    + "as (codigo_subfamilia character(4),nombre_subfamilia character varying(60))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cbx_subfamilia_x_familia", e.getMessage());
        }
        return null;
    }
}
