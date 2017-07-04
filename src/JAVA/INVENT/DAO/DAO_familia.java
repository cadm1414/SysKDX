package JAVA.INVENT.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.BEAN.BEAN_familia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_familia {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "INVENT", ls_capa = "DAO", ls_clase = "DAO_familia";

    public ResultSet FNC_codigo_familia() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_codigo_familia() as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_codigo_familia", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_grid_familia() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_familia() "
                    + "as (codigo_familia character(4),nombre_familia character varying(60))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_familia", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_familia(String codigo_familia) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_familia('" + codigo_familia + "') "
                    + "as (codigo_familia character(4),nombre_familia character varying(60))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_familia", e.getMessage());
        }
        return null;
    }

    public boolean DLT_familia(String codigo_familia) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_familia('" + codigo_familia + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_familia", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_familia", e.getMessage());
        }
        return resp;
    }

    public boolean IST_familia(BEAN_familia OBJ_bfa) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_familia('" + OBJ_bfa.getCodigo_familia() + "','" + OBJ_bfa.getNombre_familia() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_familia", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_familia", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_familia(BEAN_familia OBJ_bfa) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_familia('" + OBJ_bfa.getCodigo_familia() + "','" + OBJ_bfa.getNombre_familia() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_familia", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_familia", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_cbx_familia() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cbx_familia() "
                    + "as (codigo_familia character(4),nombre_familia character varying(60))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cbx_familia", e.getMessage());
        }
        return null;
    }
}
