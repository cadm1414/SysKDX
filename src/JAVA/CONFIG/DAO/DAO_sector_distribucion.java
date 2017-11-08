package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_sector_distribucion {

    ResultSet lq_rs = null;
    Statement lq_stm = null;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_sector_distribucion";

    public ResultSet SLT_cbx_sector_distribucion() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cbx_sector_distribucion() "
                    + "as (codigo_sector character(6),descripcion character varying(250))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cbx_sector_distribucion", e.getMessage());
        }
        return null;
    }
}
