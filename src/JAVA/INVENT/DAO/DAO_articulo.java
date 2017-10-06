package JAVA.INVENT.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.BEAN.BEAN_articulo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_articulo {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "INVENT", ls_capa = "DAO", ls_clase = "DAO_articulo";

    public ResultSet FNC_correlativo_articulo(String codigo_producto, String codigo_marca) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_correlativo_articulo('" + codigo_producto + "','" + codigo_marca + "') "
                    + "as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_correlativo_articulo", e.getMessage());
        }
        return null;
    }

    public ResultSet FNC_activa_campos_articulo(String codigo_producto) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_activa_campos_articulo('" + codigo_producto + "') "
                    + "as (afecto_detraccion character(1),afecto_percepcion character(1),clase_producto character(1))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_activa_campos_articulo", e.getMessage());
        }
        return null;
    }

    public int SLT_cta_articulo_x_producto(String codigo_producto) {
        int resp = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cta_articulo_x_producto('" + codigo_producto + "') as (cont bigint)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                resp = lq_rs.getInt(1);
                return resp;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "SLT_cta_articulo_x_producto", e.getMessage());
        }
        return resp;
    }

    public int SLT_cta_articulo_x_marca(String codigo_marca) {
        int resp = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cta_articulo_x_marca('" + codigo_marca + "') as (cont bigint)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                resp = lq_rs.getInt(1);
                return resp;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "SLT_cta_articulo_x_marca", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_grid_articulo() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_articulo() "
                    + "as (codigo_articulo character(12),nombre_articulo character varying(150),status text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_articulo", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_articulo(String codigo_articulo) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_articulo('" + codigo_articulo + "') "
                    + "as (codigo_articulo character(12),nombre_articulo character varying(150),codigo_producto character(4),codigo_marca character(4),clase_producto character(1),caracteristica character varying(60),codigo_unidad character(4),bulto_um character(4),tara numeric(6,3),status character(1),afecto_igv character(1),codigo_sunat character varying(20),afecto_detraccion character(1),codigo_detraccion character(3),afecto_percepcion character(1),codigo_percepcion character(2),tipo_operacion character(1),codigo_barra character varying(20),codigo_familia character(4),codigo_subfamilia character(4),observacion character varying(250),serie character varying(30),presentacion numeric)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_articulo", e.getMessage());
        }
        return null;
    }

    public boolean DLT_articulo(String codigo_articulo) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_articulo('" + codigo_articulo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_articulo", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_articulo", e.getMessage());
        }
        return resp;
    }

    public boolean IST_articulo(BEAN_articulo OBJ_bar) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_articulo('" + OBJ_bar.getCodigo_articulo() + "',$$" + OBJ_bar.getNombre_articulo() + "$$,$$" + OBJ_bar.getCaracteristica() + "$$," + OBJ_bar.getTara() + ",'" + OBJ_bar.getClase_producto() + "','" + OBJ_bar.getCodigo_barra() + "','" + OBJ_bar.getCodigo_producto() + "','" + OBJ_bar.getCodigo_marca() + "','" + OBJ_bar.getCodigo_familia() + "','" + OBJ_bar.getCodigo_subfamilia() + "','" + OBJ_bar.getCodigo_unidad() + "','" + OBJ_bar.getTipo_operacion() + "','" + OBJ_bar.getStatus() + "','" + OBJ_bar.getObservacion() + "','" + OBJ_bar.getCodigo_percepcion() + "','" + OBJ_bar.getCodigo_detraccion() + "','" + OBJ_bar.getAfecto_igv() + "','" + OBJ_bar.getAfecto_detraccion() + "','" + OBJ_bar.getAfecto_percepcion() + "','" + OBJ_bar.getBulto_um() + "','005','" + OBJ_bar.getCodigo_sunat() + "','" + OBJ_bar.getSerie() + "',"+OBJ_bar.getPresentacion()+")";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_articulo", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_articulo", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_articulo(BEAN_articulo OBJ_bar) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_articulo('" + OBJ_bar.getCodigo_articulo() + "',$$" + OBJ_bar.getNombre_articulo() + "$$,$$" + OBJ_bar.getCaracteristica() + "$$," + OBJ_bar.getTara() + ",'" + OBJ_bar.getClase_producto() + "','" + OBJ_bar.getCodigo_barra() + "','" + OBJ_bar.getCodigo_producto() + "','" + OBJ_bar.getCodigo_marca() + "','" + OBJ_bar.getCodigo_familia() + "','" + OBJ_bar.getCodigo_subfamilia() + "','" + OBJ_bar.getCodigo_unidad() + "','" + OBJ_bar.getTipo_operacion() + "','" + OBJ_bar.getStatus() + "','" + OBJ_bar.getObservacion() + "','" + OBJ_bar.getCodigo_percepcion() + "','" + OBJ_bar.getCodigo_detraccion() + "','" + OBJ_bar.getAfecto_igv() + "','" + OBJ_bar.getAfecto_detraccion() + "','" + OBJ_bar.getAfecto_percepcion() + "','" + OBJ_bar.getBulto_um() + "','005','" + OBJ_bar.getCodigo_sunat() + "','" + OBJ_bar.getSerie() + "',"+OBJ_bar.getPresentacion()+")";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_articulo", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_articulo", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_datos_articulo_x_articulo(String codigo_articulo) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_articulo_x_articulo('" + codigo_articulo + "') "
                    + "as (nombre_articulo character varying(150),simbolo_unidad character varying,tara numeric(6,3),codigo_unidad character(4))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_articulo_x_articulo", e.getMessage());
        }
        return null;
    }
}
