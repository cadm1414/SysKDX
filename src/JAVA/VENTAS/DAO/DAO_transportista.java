package JAVA.VENTAS.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_transportista {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "VENTAS", ls_capa = "DAO", ls_clase = "DAO_transportista";

    public int SLT_cta_transportista() {
        int resp = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cta_transportista() "
                    + "as (cont bigint)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                resp = lq_rs.getInt(1);
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cta_transportista", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_datos_pl(String codigo_transportista) {

        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_pl('" + codigo_transportista + "') "
                    + "as (codigo_transportista character(4),nombre_transportista character varying(250),numero_licencia character varying(15),razon_social character varying(250),numero_doc_id character(11),codigo_vehiculo character(6),marca character varying(30),numero_civ character varying(30),codigo_vehiculo_2 character(6),marca_2 character varying(30),numero_civ_2 character varying(30))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_pl", e.getMessage());
        }
        return null;
    }
}
