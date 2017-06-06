package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_usuario_permisos {

    ResultSet lq_rs = null;
    Statement lq_stm = null;
    private String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_usuario_permisos";

    public ResultSet SLT_grid_usuario_permisos() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_usuario_permisos() "
                    + "as (codigo character(4),nombre character varying(100),tipo_almacen text)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_usuario_permisos", e.getMessage());
        }
        return null;
    }
}
