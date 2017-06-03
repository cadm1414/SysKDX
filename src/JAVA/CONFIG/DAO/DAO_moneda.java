package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_moneda {
    
    ResultSet lq_rs = null;
    Statement lq_stm = null;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_moneda";
    
    public ResultSet SLT_moneda_x_visible(String visible) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_moneda_x_visible('" + visible + "') "
                    + "as (codigo_moneda character(3),nombre_comun character varying(60),simbolo_moneda character(4))	";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_moneda_x_visible", "NO EXISTEN MONEDAS REGISTRADAS");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_moneda_x_visible", e.getMessage());
        }
        return null;
    }
    
}
