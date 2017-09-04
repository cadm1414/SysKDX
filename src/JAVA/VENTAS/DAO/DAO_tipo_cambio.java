package JAVA.VENTAS.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;

public class DAO_tipo_cambio {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "VENTAS", ls_capa = "DAO", ls_clase = "DAO_tipo_cambio";

    public double SLT_tipo_cambio_monto(String op, String codigo_moneda, String dia) {
        double resp = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_tipo_cambio_monto('" + op + "','" + codigo_moneda + "','" + dia + "') "
                    + "as (monto numeric(4,3))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                resp = lq_rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return resp;
    }

    public ResultSet SLT_grid_tipo_cambio(int mes, String codigo_moneda) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_tipo_cambio(" + mes + ",'" + codigo_moneda + "','" + gs_periodo + "') "
                    + "as (codigo_moneda character(3),dia date,compra numeric(4,3),venta numeric(4,3))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean UPD_tipo_cambio(JTable TBL_tipo_cambio, String moneda) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            for (int i = 0; i < TBL_tipo_cambio.getRowCount(); i++) {
                String SQL = "select * from upd_tipo_cambio('" + moneda + "',"
                        + "'" + TBL_tipo_cambio.getValueAt(i, 0).toString().trim() + "',"
                        + "'" + (double) TBL_tipo_cambio.getValueAt(i, 1) + "',"
                        + "'" + (double) TBL_tipo_cambio.getValueAt(i, 2) + "')";
                lq_rs = lq_stm.executeQuery(SQL);
            }
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_tipo_cambio", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_tipo_cambio", e.getMessage());
        }
        return resp;
    }
}
