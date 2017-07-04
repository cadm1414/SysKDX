package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_sucursal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_sucursal {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_sucursal";

    public ResultSet FNC_codigo_sucursal() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_codigo_sucursal() as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "fnc_codigo_sucursal", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_grid_sucursal() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_sucursal() "
                    + "as (codigo_sucursal character(4),nombre_sucursal character varying(100),status text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_sucursal", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_sucursal(String codigo_sucursal) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_sucursal('" + codigo_sucursal + "') "
                    + "as (codigo_sucursal character(4),nombre_sucursal character varying(100),direccion character varying(150),nota character varying(250),status character(1),codigo_ubigeo character(6),descripcion character varying(100))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_sucursal", e.getMessage());
        }
        return null;
    }

    public boolean DLT_sucursal(String codigo_sucursal) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_sucursal('" + codigo_sucursal + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_sucursal", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_sucursal", e.getMessage());
        }
        return resp;
    }

    public boolean IST_sucursal(BEAN_sucursal OBJ_bsu) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_sucursal('" + OBJ_bsu.getCodigo_sucursal() + "','" + OBJ_bsu.getNombre() + "','" + OBJ_bsu.getDireccion() + "','" + OBJ_bsu.getNota() + "','" + OBJ_bsu.getStatus() + "','" + OBJ_bsu.getUbigeo() + "','" + OBJ_bsu.getDescripcion() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_sucursal", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_sucursal", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_sucursal(BEAN_sucursal OBJ_bsu) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_sucursal('" + OBJ_bsu.getCodigo_sucursal() + "','" + OBJ_bsu.getNombre() + "','" + OBJ_bsu.getDireccion() + "','" + OBJ_bsu.getNota() + "','" + OBJ_bsu.getStatus() + "','" + OBJ_bsu.getUbigeo() + "','" + OBJ_bsu.getDescripcion() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_sucursal", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_sucursal", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_cbx_sucursal(String status) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cbx_sucursal('" + status + "') "
                    + "as (codigo_sucursal character(4),nombre_sucursal character varying(100))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cbx_sucursal", e.getMessage());
        }
        return null;
    }

}
