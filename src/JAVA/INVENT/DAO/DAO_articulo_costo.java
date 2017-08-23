package JAVA.INVENT.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.BEAN.BEAN_articulo_costo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_articulo_costo {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "INVENT", ls_capa = "DAO", ls_clase = "DAO_articulo_costo";

    public int SLT_cta_articulo_costo_x_articulo(String codigo_articulo) {
        int resp = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cta_articulo_costo_x_articulo('" + codigo_articulo + "') as (cont bigint)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                resp = lq_rs.getInt(1);
                return resp;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "SLT_cta_articulo_costo_x_articulo", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_grid_articulo_costo() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_articulo_costo() "
                    + "as (codigo_articulo character(12),nombre_articulo character varying(150),simbolo_unidad character varying(3),tara numeric,oc text,periodo_produccion character(7))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_articulo_costo", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_articulo_costo(String codigo_orden, String codigo_articulo, String periodo_produccion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_articulo_costo('" + codigo_orden + "','" + codigo_articulo + "','" + periodo_produccion + "') "
                    + "as (codigo_orden character(10),item_orden character(3),codigo_articulo character(12),nombre_articulo character varying(150),codigo_procedencia character(1),tipo_procedencia character(1),numero character(4),periodo character(4),costo numeric(6,5),periodo_produccion character(7),codigo_entidad character(6),fecha_ingreso date,fecha_produccion date,fecha_vencimiento date)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_articulo_costo", e.getMessage());
        }
        return null;
    }

    public boolean DLT_articulo_costo(BEAN_articulo_costo OBJ_bar) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_articulo_costo('" + OBJ_bar.getCodigo_orden() + "','" + OBJ_bar.getItem_orden() + "','" + OBJ_bar.getCodigo_articulo() + "','" + OBJ_bar.getPeriodo_produccion() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_articulo_costo", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_articulo_costo", e.getMessage());
        }
        return resp;
    }

    public String FNC_genera_item_orden(String codigo_orden, String codigo_articulo, String periodo_produccion) {
        String resp = "";
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_genera_item_orden('" + codigo_orden + "','" + codigo_articulo + "','" + periodo_produccion + "') as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                resp = lq_rs.getString(1);
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_cgenera_item_orden", e.getMessage());
        }
        return resp;
    }

    public boolean IST_articulo_costo(BEAN_articulo_costo OBJ_bar) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_articulo_costo('" + OBJ_bar.getCodigo_orden() + "','" + OBJ_bar.getItem_orden() + "','" + OBJ_bar.getCodigo_articulo() + "','" + OBJ_bar.getCodigo_procedencia() + "','" + OBJ_bar.getTipo_procedencia() + "','" + OBJ_bar.getPeriodo() + "','" + OBJ_bar.getNumero() + "','" + OBJ_bar.getCodigo_entidad() + "',$$" + OBJ_bar.getNombre_articulo() + "$$,'" + OBJ_bar.getFecha_ingreso() + "','" + OBJ_bar.getFecha_produccion() + "','" + OBJ_bar.getFecha_vencimiento() + "'," + OBJ_bar.getCosto() + ",'" + OBJ_bar.getPeriodo_produccion() + "','0','0')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_articulo_costo", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_articulo_costo", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_articulo_costo(BEAN_articulo_costo OBJ_bar, String periodo_produccion) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_articulo_costo('" + OBJ_bar.getCodigo_orden() + "','" + OBJ_bar.getItem_orden() + "','" + OBJ_bar.getCodigo_articulo() + "','" + OBJ_bar.getCodigo_procedencia() + "','" + OBJ_bar.getTipo_procedencia() + "','" + OBJ_bar.getPeriodo() + "','" + OBJ_bar.getNumero() + "','" + OBJ_bar.getCodigo_entidad() + "',$$" + OBJ_bar.getNombre_articulo() + "$$,'" + OBJ_bar.getFecha_ingreso() + "','" + OBJ_bar.getFecha_produccion() + "','" + OBJ_bar.getFecha_vencimiento() + "'," + OBJ_bar.getCosto() + ",'" + OBJ_bar.getPeriodo_produccion() + "','0','0','" + periodo_produccion + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_articulo_costo", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_articulo_costo", e.getMessage());
        }
        return resp;
    }

}
