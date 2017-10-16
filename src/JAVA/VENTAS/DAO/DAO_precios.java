package JAVA.VENTAS.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_precios {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "VENTAS", ls_capa = "DAO", ls_clase = "DAO_precios";

    public ResultSet SLT_datos_precio_x_articulo(String codigo_articulo,String es_presentacion,String tipo_comercio) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_precio_x_articulo('" + codigo_articulo + "','"+es_presentacion+"','"+tipo_comercio+"') "
                    + "as (codigo_articulo character(12),nombre_articulo character varying(150),tara numeric,simbolo_unidad character varying(3),afecto_igv character(1),percepcion numeric,presentacion numeric,precio numeric,precio_min numeric)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_precio_x_articulo", e.getMessage());
        }
        return null;
    }
}
