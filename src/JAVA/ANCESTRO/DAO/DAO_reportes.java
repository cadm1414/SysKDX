package JAVA.ANCESTRO.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_reportes {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "ANCESTRO", ls_capa = "DAO", ls_clase = "DAO_reportes";

    public double RPT_utilidad_ponderada(String codigo_sucursal, String codigo_producto, double precio,String codigo_moneda) {
        double resp = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from rpt_utilidad_ponderada('" + codigo_sucursal + "','" + codigo_producto + "'," + precio + ",'"+codigo_moneda+"','" + gs_periodo + "') "
                    + "as (porcentaje numeric)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                resp = lq_rs.getDouble(1);
                return resp;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "RPT_utilidad_ponderada", e.getMessage());
        }
        return resp;
    }

}
