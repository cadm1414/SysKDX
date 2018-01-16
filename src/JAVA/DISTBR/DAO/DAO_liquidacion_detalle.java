package JAVA.DISTBR.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_liquidacion_detalle {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "VENTAS", ls_capa = "DAO", ls_clase = "DAO_liquidacion_detalle";

    public ResultSet SLT_datos_liquidacion_detalle(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_liquidacion_detalle('" + codigo_operacion + "','" + gs_periodo + "') "
                    + "as (codigo_operacion character(16) ,  item character(3) ,   codigo_operacion_ref character(16),  numero_documento_ref character(10) ,    razon_social character varying(250) ,    total numeric ,   es_efectivo character(1),es_deposito character(1),monto numeric,descuento numeric,importe numeric,  periodo character(4))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_liquidacion_detalle", e.getMessage());
        }
        return null;
    }
    
    public boolean DLT_liquidacion_detalle(String codigo_operacion) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_liquidacion_detalle('" + codigo_operacion + "','" + gs_periodo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                //go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_kardex_detalle", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_liquidacion_detalle", e.getMessage());
        }
        return resp;
    }
}
