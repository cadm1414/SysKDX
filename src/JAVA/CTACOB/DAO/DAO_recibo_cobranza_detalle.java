package JAVA.CTACOB.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_recibo_cobranza_detalle {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CTACOB", ls_capa = "DAO", ls_clase = "DAO_recibo_cobranza_detalle";

    public ResultSet SLT_datos_recibo_cobranza_detalle(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_recibo_cobranza_detalle('" + codigo_operacion + "','" + gs_periodo + "') "
                    + "as (codigo_rv character(16),codigo_vendedor character(4),item character(3),tipo_documento_ref character(2),serie_documento_ref character(4),numero_documento_ref character(10),fecha_emision_ref date,codigo_moneda character(3),monto_origen_saldo numeric,pago numeric ,saldo numeric)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_recibo_cobranza_detalle", e.getMessage());
        }
        return null;
    }
    
    public boolean DLT_recibo_cobranza_detalle(String codigo_operacion) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_recibo_cobranza_detalle('" + codigo_operacion + "','"+gs_periodo+"')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                //go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_kardex_detalle", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_recibo_cobranza_detalle", e.getMessage());
        }
        return resp;
    }
}
