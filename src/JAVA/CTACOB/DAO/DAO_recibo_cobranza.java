
package JAVA.CTACOB.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_recibo_cobranza {
    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CTACOB", ls_capa = "DAO", ls_clase = "DAO_recibo_cobranza";

    public ResultSet FNC_correlativo_recibo_cobranza(String codigo_documento, String serie_doc, String sucursal) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_correlativo_recibo_cobranza('" + codigo_documento + "','" + serie_doc + "','" + sucursal + "','" + gs_periodo + "') "
                    + "as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_correlativo_recibo_cobranza", e.getMessage());
        }
        return null;
    }
}
