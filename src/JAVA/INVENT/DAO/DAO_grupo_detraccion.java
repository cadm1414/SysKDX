package JAVA.INVENT.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_grupo_detraccion {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "INVENT", ls_capa = "DAO", ls_clase = "DAO_grupo_detraccion";

    public ResultSet SLT_cbx_grupo_detraccion(String status) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cbx_grupo_detraccion('" + status + "') "
                    + "as (codigo_grupo character(3),concepto character varying(60))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cbx_grupo_detraccion", e.getMessage());
        }
        return null;
    }
}
