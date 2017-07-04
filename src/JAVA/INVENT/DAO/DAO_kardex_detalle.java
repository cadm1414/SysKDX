
package JAVA.INVENT.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_kardex_detalle {
    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "INVENT", ls_capa = "DAO", ls_clase = "DAO_kardex_detalle";
    
    public ResultSet SLT_datos_kardex_detalle(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_kardex_detalle('"+codigo_operacion+"') "
                    + "as (item character(3),lote character(6),codigo_articulo character(12),nombre_articulo character varying(150),simbolo_unidad character varying(3),numero_compra text,periodo_produccion character(7),bulto integer,peso_bruto numeric(12,5),tara numeric(6,3),peso_neto numeric(12,5))";	
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_kardex_detalle", e.getMessage());
        }
        return null;
    }
}
