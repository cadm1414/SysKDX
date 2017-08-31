package JAVA.VENTAS.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_pedido_detalle {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "VENTAS", ls_capa = "DAO", ls_clase = "DAO_pedido_detalle";
    
    public ResultSet SLT_datos_pedido_detalle(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_pedido_detalle('" + codigo_operacion + "','"+gs_periodo+"') "
                    + "as (item character(3),bulto integer,codigo_articulo character(12),nombre_articulo character varying(150),tara numeric(6,3),simbolo_unidad character varying(3),afecto_igv character(1),porcentaje_percepcion numeric(5,3),precio_cigv numeric(11,5),precio_sigv numeric(11,5),peso_bruto numeric(12,5),peso_neto numeric(12,5),importe_cigv numeric(11,2),importe_sigv numeric(11,2))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_pedido_detalle", e.getMessage());
        }
        return null;
    }
    
    public boolean DLT_pedido_detalle(String codigo_operacion) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_pedido_detalle('" + codigo_operacion + "','"+gs_periodo+"')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                //go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_kardex_detalle", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_pedido_detalle", e.getMessage());
        }
        return resp;
    }
    
}
