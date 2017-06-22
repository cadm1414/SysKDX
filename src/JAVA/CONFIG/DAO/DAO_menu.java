package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_menu {

    Statement lq_stm = null;
    ResultSet lq_rs = null;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_menu";

    public ResultSet SLT_datos_menu() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_menu() "
                    + "as (codigo_modulo character(6),codigo_orden character varying(30),nombre_opcion character varying(100))";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_menu", "NO SE ENCONTRARON DATOS REGISTRADOS");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs,lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_menu", e.getMessage());
        }
        return null;
    }
}
