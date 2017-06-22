package JAVA.INVENT.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_grupo_percepcion {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "INVENT", ls_capa = "DAO", ls_clase = "DAO_grupo_percepcion";

    public ResultSet SLT_cbx_grupo_percepcion(String status) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cbx_grupo_percepcion('" + status + "') "
                    + "as (codigo_grupo character(2),concepto character varying(60))";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs,lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cbx_grupo_percepcion", e.getMessage());
        }
        return null;
    }
}
