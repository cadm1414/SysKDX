package JAVA.INVENT.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.BEAN.BEAN_producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_producto {

    ResultSet lq_rs = null;
    Statement lq_stm = null;
    String ls_modulo = "INVENT", ls_capa = "DAO", ls_clase = "DAO_producto";

    public ResultSet FNC_codigo_producto() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_codigo_producto() as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_codigo_producto", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_grid_producto() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_producto() "
                    + "as (codigo_marca character(4),nombre_marca character varying(60),status text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_producto", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_producto(String codigo_producto) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_producto('" + codigo_producto + "') "
                    + "as (codigo_producto character(4),nombre_producto character varying(60),clase_producto character(1),dias_almacen character varying(3),codigo_arancel character varying(2),afecto_detraccion character(1),afecto_percepcion character(1),status character(1))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_producto", e.getMessage());
        }
        return null;
    }

    public boolean DLT_producto(String codigo_producto) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_producto('" + codigo_producto + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_producto", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_producto", e.getMessage());
        }
        return resp;
    }

    public boolean IST_producto(BEAN_producto OBJ_bpr) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_producto('" + OBJ_bpr.getCodigo_producto() + "',$$" + OBJ_bpr.getNombre_producto() + "$$,'" + OBJ_bpr.getClase_producto() + "','" + OBJ_bpr.getDias_almacen() + "','','" + OBJ_bpr.getStatus() + "','" + OBJ_bpr.getAfecto_detraccion() + "','" + OBJ_bpr.getAfecto_percepcion() + "')";
            System.out.println(SQL);
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_producto", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_producto", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_producto(BEAN_producto OBJ_bpr) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_producto('" + OBJ_bpr.getCodigo_producto() + "',$$" + OBJ_bpr.getNombre_producto() + "$$,'" + OBJ_bpr.getClase_producto() + "','" + OBJ_bpr.getDias_almacen() + "','','" + OBJ_bpr.getStatus() + "','" + OBJ_bpr.getAfecto_detraccion() + "','" + OBJ_bpr.getAfecto_percepcion() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_producto", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_producto", e.getMessage());
        }
        return resp;
    }
    
    public ResultSet SLT_cbx_producto(String estado) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cbx_producto('"+estado+"') "
                    + "as (codigo_producto character(4),nombre_producto character varying(60))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cbx_producto", e.getMessage());
        }
        return null;
    }
}
