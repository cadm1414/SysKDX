package JAVA.VENTAS.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_tipo_cambio {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "VENTAS", ls_capa = "DAO", ls_clase = "DAO_tipo_cambio";

    public double SLT_tipo_cambio_monto(String op, String codigo_moneda, String dia) {
        double resp = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_tipo_cambio_monto('" + op + "','" + codigo_moneda + "','" + dia + "') "
                    + "as (monto numeric(4,3))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                resp = lq_rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return resp;
    }
}
