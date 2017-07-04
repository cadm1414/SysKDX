
package JAVA.INVENT.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_kardex {
    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "INVENT", ls_capa = "DAO", ls_clase = "DAO_kardex";
    
    public ResultSet FNC_correlativo_guia_almacen(String codigo_documento,String serie_doc,String tipo_movimiento,String almacen) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_correlativo_guia_almacen('"+codigo_documento+"','"+serie_doc+"','"+tipo_movimiento+"','"+almacen+"') "
                    + "as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs != null) {
                return lq_rs;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs,lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_correlativo_guia_almacen", e.getMessage());
        }
        return null;
    }
    
    public ResultSet SLT_grid_kardex(String codigo_almacen,String fecha_ini,String fecha_fin,String codigo_movimiento,String tipo_movimiento,String es_transferencia) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_kardex('"+codigo_almacen+"','"+fecha_ini+"','"+fecha_fin+"','"+codigo_movimiento+"','"+tipo_movimiento+"','"+es_transferencia+"') "
                    + "as (fecha_emision date,numero_documento text,status text)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs, lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_kardex", e.getMessage());
        }
        return null;
    }
}
