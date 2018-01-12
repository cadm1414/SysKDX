package JAVA.DISTBR.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.BEAN.BEAN_liquidacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;

public class DAO_liquidacion {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "DISTBR", ls_capa = "DAO", ls_clase = "DAO_liquidacion";

    public ResultSet FNC_correlativo_liquidacion(String sucursal) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_correlativo_liquidacion('" + sucursal + "','" + gs_periodo + "') "
                    + "as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_correlativo_liquidacion", e.getMessage());
        }
        return null;
    }

    public boolean IST_liquidacion(BEAN_liquidacion OBJ_ped, JTable OBJ_pgp) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_liquidacion('" + OBJ_ped.getCodigo_operacion() + "','" + OBJ_ped.getCodigo_sucursal() + "','" + OBJ_ped.getFecha_emision() + "','" + OBJ_ped.getNumero_documento() + "','" + OBJ_ped.getCodigo_programacion() + "','" + OBJ_ped.getObservacion() + "','" + OBJ_ped.getStatus() + "'," + OBJ_ped.getDescuento() + "," + OBJ_ped.getTotal_credito() + "," + OBJ_ped.getTotal_efectivo() + ",'" + gs_periodo + "')";

            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                for (int i = 0; i < OBJ_pgp.getRowCount(); i++) {
                    String SQL2 = "select * from ist_liquidacion_detalle("
                            + "'" + OBJ_ped.getCodigo_operacion() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 1).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 2).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 3).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 4).toString().trim() + "',"
                            + OBJ_pgp.getValueAt(i, 5).toString().trim() + ","
                            + "'" + go_fnc_operaciones_campos.boolean_int((boolean)OBJ_pgp.getValueAt(i, 6)) + "',"
                            + "'" + go_fnc_operaciones_campos.boolean_int((boolean)OBJ_pgp.getValueAt(i, 7)) + "',"
                            + OBJ_pgp.getValueAt(i, 8).toString().trim() + ","
                            + OBJ_pgp.getValueAt(i, 9).toString().trim() + ","
                            + OBJ_pgp.getValueAt(i, 10).toString().trim() + ","
                            + "'" + gs_periodo + "')";                   
                    lq_rs = lq_stm.executeQuery(SQL2);
                }
                if (lq_rs.next()) {
                    lq_stm.getConnection().commit();
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_liquidacion", "SE ACTUALIZO BASE DE DATOS");
                    resp = true;
                    go_dao_auditoria.IST_auditoria(OBJ_ped.getCodigo_programacion(), SQL, ls_modulo, "1", "0052");
                }
            }
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_liquidacion", e.getMessage());
        }
        return resp;
    }

}
