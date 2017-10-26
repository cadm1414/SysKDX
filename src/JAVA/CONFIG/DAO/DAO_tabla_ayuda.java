package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_tabla_ayuda {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_taba_sunat";

    public ResultSet SLT_cbx_tabla_ayuda(String categoria) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cbx_tabla_ayuda('" + categoria + "') "
                    + "as (codigo character varying(20),descripcion character varying(250))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cbx_tabla_ayuda", e.getMessage());
        }
        return null;
    }

}
