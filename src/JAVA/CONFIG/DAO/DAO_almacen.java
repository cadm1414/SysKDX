package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public ResultSet SLT_datos_almacen(String codigo_almacen) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_almacen('" + codigo_almacen + "') "
                    + "as (codigo_almacen character(4),nombre_almacen character varying(100),direccion character varying(150),nota character varying(250),status character(1),codigo_ubigeo character(6),descripcion character varying(100),tipo_almacen character(1),codigo_sucursal character(4))";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_almacen", e.getMessage());
        }
        return null;
    }

    public boolean DLT_almacen(String codigo_almacen) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_almacen('" + codigo_almacen + "') as (resp integer)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                if (lq_rs.getInt(1) == 1) {
                    lq_stm.getConnection().commit();
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_almacen", "SE ACTUALIZO BASE DE DATOS");
                    resp = true;
                }
                else{
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_almacen", "ALMACEN VENTA NO PUEDE SER ELIMINADO");
                }
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_almacen", e.getMessage());
        }
        return resp;
    }
}
