package JAVA.VENTAS.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_guia_remision_detalle {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "VENTAS", ls_capa = "DAO", ls_clase = "DAO_pedido_detalle";

    public ResultSet SLT_datos_guia_remision_detalle(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from SLT_datos_guia_remision_detalle('" + codigo_operacion + "','" + gs_periodo + "') "
                    + "as (item character(3),es_presentacion character(1),bulto integer,codigo_articulo character(12),nombre_articulo character varying(150),tara numeric(6,3),simbolo_unidad character varying(3),afecto_igv character(1),porcentaje_percepcion numeric(5,3),precio_cigv numeric(11,5),precio_presentacion numeric,precio_sigv numeric(11,5),peso_bruto numeric(12,5),peso_neto numeric(12,5),importe_cigv numeric(11,2),importe_sigv numeric(11,2),porcentaje_utilidad numeric(11,2),presentacion numeric,precio_min numeric,codigo_op_origen character varying(16),item_origen character(3))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_guia_remision_detalle", e.getMessage());
        }
        return null;
    }

    public boolean DLT_guia_remision_detalle(String codigo_operacion) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_guia_remision_detalle('" + codigo_operacion + "','" + gs_periodo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                //go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_kardex_detalle", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_guia_remision_detalle", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_grid_guia_pendiente(String codigo_operacion, String codigo_documento_ref) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_guia_pendiente('" + codigo_operacion + "','" + codigo_documento_ref + "','" + gs_periodo + "') "
                    + "as (numero_doc_ref text,codigo_operacion character(16),item character(3),codigo_articulo character(12),nombre_articulo character varying(150),bulto integer,peso_bruto numeric(12,5),peso_neto numeric(12,5),es_facturado character(1))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_guia_pendiente", e.getMessage());
        }
        return null;
    }
    
    public ResultSet SLT_datos_guia_remision_detalle_x_item(String codigo_operacion,String item) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_guia_remision_detalle_x_item('" + codigo_operacion + "','"+item+"','" + gs_periodo + "') "
                    + "as (item character(3),bulto integer,codigo_articulo character(12),nombre_articulo character varying(150),tara numeric(6,3),simbolo_unidad character varying(3),afecto_igv character(1),porcentaje_percepcion numeric(5,3),precio_cigv numeric(11,5),precio_sigv numeric(11,5),peso_bruto numeric(12,5),peso_neto numeric(12,5),importe_cigv numeric(11,2),importe_sigv numeric(11,2),porcentaje_utilidad numeric(11,2))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "slt_datos_guia_remision_detalle_x_item", e.getMessage());
        }
        return null;
    }
    
    public int FNC_verifica_guia_facturado(String codigo_operacion) {
        int resp = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_verifica_guia_facturado('" + codigo_operacion + "','" + gs_periodo + "') "
                    + "as (es_facturado integer)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                resp = lq_rs.getInt(1);
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_verifica_guia_facturado", e.getMessage());
        }
        return resp;
    }
}
