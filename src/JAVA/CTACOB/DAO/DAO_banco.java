
package JAVA.CTACOB.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_banco {
    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CTACOB", ls_capa = "DAO", ls_clase = "DAO_banco";
    
    public ResultSet SLT_cbx_moneda() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cbx_banco() "
                    + "as (codigo_banco character(4),nombre_banco character varying(250))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cbx_moneda", e.getMessage());
        }
        return null;
    }
}
