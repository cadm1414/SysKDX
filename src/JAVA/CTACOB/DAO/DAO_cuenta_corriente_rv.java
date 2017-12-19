package JAVA.CTACOB.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_cuenta_corriente_rv {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CTACOB", ls_capa = "DAO", ls_clase = "DAO_cuenta_corriente_rv";

    public ResultSet SLT_saldo_rc(String codigo_sucursal, String fecha_ini, String fecha_fin, String codigo_pagador) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_saldo_rc('" + codigo_sucursal + "','" + fecha_ini + "','" + fecha_fin + "','" + codigo_pagador + "','" + gs_periodo + "') "
                    + "as (codigo_operacion character(16),codigo_vendedor character(4),codigo_documento character(2),serie character(4),numero character(10),fecha_emision date, codigo_moneda character(3),deuda numeric)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_saldo_rc", e.getMessage());
        }
        return null;
    }

    public String SLT_codigo_operacion_nc(String codigo_documento, String serie_documento, String numero_documento) {
        String resp = "";
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_codigo_operacion_nc('" + codigo_documento + "','" + serie_documento + "','" + numero_documento + "','" + gs_periodo + "') "
                    + "as (codigo_operacion character(16))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                resp = lq_rs.getString(1);
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_codigo_operacion_nc", e.getMessage());
        }
        return resp;
    }
}
