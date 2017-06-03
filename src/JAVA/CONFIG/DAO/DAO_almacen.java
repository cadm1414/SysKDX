package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_almacen {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_almacen";

    public ResultSet FNC_codigo_almacen() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_codigo_almacen() as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs != null) {
                return lq_rs;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_codigo_almacen", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_grid_almacen() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_almacen() "
                    + "as (codigo_alnacen character(4),nombre_almacen character varying(100),status text)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_almacen", e.getMessage());
        }
        return null;
    }
}
