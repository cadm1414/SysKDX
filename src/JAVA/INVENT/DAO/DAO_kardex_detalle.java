package JAVA.INVENT.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_kardex_detalle {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "INVENT", ls_capa = "DAO", ls_clase = "DAO_kardex_detalle";

    public ResultSet SLT_datos_kardex_detalle(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_kardex_detalle('" + codigo_operacion + "','"+gs_periodo+"') "
                    + "as (item character(3),lote character(6),codigo_articulo character(12),nombre_articulo character varying(150),simbolo_unidad character varying(3),numero_compra text,periodo_produccion character(7),bulto integer,peso_bruto numeric(12,5),tara numeric(6,3),peso_neto numeric(12,5))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_kardex_detalle", e.getMessage());
        }
        return null;
    }

    public boolean DLT_kardex_detalle(String codigo_operacion) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_kardex_detalle('" + codigo_operacion + "','"+gs_periodo+"')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                //go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_kardex_detalle", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_kardex_detalle", e.getMessage());
        }
        return resp;
    }
    
    public int FNC_verifica_lote(String codigo_almacen,String lote) {
        int cont = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_verifica_lote('" + codigo_almacen + "','"+lote+"','"+gs_periodo+"') "
                    + "as (correlativo integer)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                cont = lq_rs.getInt(1);
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_kardex_detalle", e.getMessage());
        }
        return cont;
    }
    
    public ResultSet SLT_stock_x_lote(String codigo_almacen,String lote) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_stock_x_lote('" + codigo_almacen + "','"+lote+"','"+gs_periodo+"') "
                    + "as (codigo_articulo character(12),nombre_articulo character varying(150),simbolo_unidad character varying(3),tara numeric(6,3),oc text,periodo_produccion character(7),bultos bigint ,peso_bruto numeric,peso_neto numeric)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_stock_x_lote", e.getMessage());
        }
        return null;
    }
    
}
