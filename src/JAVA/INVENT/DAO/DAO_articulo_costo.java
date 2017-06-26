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
            String SQL = "select * from slt_cta_articulo_costo_x_articulo('"+codigo_articulo+"') as (cont bigint)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                resp = lq_rs.getInt(1);
                return resp;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs,lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "SLT_cta_articulo_costo_x_articulo", e.getMessage());
        }
        return resp;
    }
    
    public ResultSet SLT_grid_articulo_costo() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_articulo_costo() "
                    + "as (codigo_articulo character(12),nombre_articulo character varying(150),oc text,numero character(4),periodo_produccion character(7))";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs, lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_articulo_costo", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_articulo_costo(String codigo_orden, String codigo_articulo, String periodo_produccion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_articulo_costo('"+codigo_orden+"','" + codigo_articulo + "','"+periodo_produccion+"') "
                    + "as (codigo_orden character(10),item_orden character(3),codigo_articulo character(12),nombre_articulo character varying(150),codigo_procedencia character(1),tipo_procedencia character(1),numero character(4),periodo character(4),costo numeric(6,5),periodo_produccion character(7),codigo_entidad character(6),fecha_ingreso date,fecha_produccion date,fecha_vencimiento date)";	
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs, lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_articulo_costo", e.getMessage());
        }
        return null;
    }
    
    public boolean DLT_articulo_costo(BEAN_articulo_costo OBJ_bar) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_articulo_costo('" + OBJ_bar.getCodigo_orden() + "','"+OBJ_bar.getItem_orden()+"','"+OBJ_bar.getCodigo_articulo()+"','"+OBJ_bar.getPeriodo_produccion()+"')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_articulo_costo", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs,lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_articulo_costo", e.getMessage());
        }
        return resp;
    }
    
    public ResultSet FNC_genera_item_orden() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_genera_item_orden() as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs != null) {
                return lq_rs;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs,lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_cgenera_item_orden", e.getMessage());
        }
        return null;
    }    
    
}
