package JAVA.DISTBR.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_programacion_detalle {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "VENTAS", ls_capa = "DAO", ls_clase = "DAO_programacion_detalle";

    public ResultSet SLT_datos_programacion_detalle(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_programacion_detalle('" + codigo_operacion + "','" + gs_periodo + "') "
                    + "as (codigo_programacion character(16) ,  item character(3) ,   codigo_operacion character(16),  codigo_sucursal character(4) ,    fecha_emision date ,    codigo_documento character(2) ,    serie_documento character(4) ,    numero_documento character(10) ,    razon_social character varying(250) ,    forma_pago character(2) ,    nombre_vendedor character varying(250) ,    sector character varying(100) ,    periodo character(4))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_programacion_detalle", e.getMessage());
        }
        return null;
    }

    public boolean DLT_programacion_detalle(String codigo_operacion) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_programacion_detalle('" + codigo_operacion + "','" + gs_periodo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                //go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_kardex_detalle", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_programacion_detalle", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_grid_programacion_gui(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_programacion_gui('" + codigo_operacion + "','" + gs_periodo + "') "
                    + "as (item text,codigo_articulo character(12),nombre_articulo character varying(150),bulto bigint,peso_bruto numeric,peso_neto numeric)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_programacion_gui", e.getMessage());
        }
        return null;
    }
    
    public ResultSet SLT_datos_pr_detalle_x_item(String codigo_operacion, String items) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_pr_detalle_x_item('" + codigo_operacion + "',$$" + items + "$$,'" + gs_periodo + "') "
                    + "as (item text,es_presentacion character(1),bulto bigint,codigo_articulo character(12),nombre_articulo character varying(150),tara numeric(6,3),simbolo_unidad character varying(3),afecto_igv character(1),porcentaje_percepcion numeric(5,3),precio_cigv numeric,peso_bruto numeric,peso_neto numeric,presentacion numeric,precio_min numeric,codigo_op_ref character(16),item_ref text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "slt_datos_pr_detalle_x_item", e.getMessage());
        }
        return null;
    }

}
