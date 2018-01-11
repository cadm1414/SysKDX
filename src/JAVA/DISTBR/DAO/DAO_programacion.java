package JAVA.DISTBR.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.BEAN.BEAN_programacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;

public class DAO_programacion {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "VENTAS", ls_capa = "DAO", ls_clase = "DAO_guia_remision";

    public ResultSet FNC_correlativo_programacion(String sucursal) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_correlativo_programacion('" + sucursal + "','" + gs_periodo + "') "
                    + "as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_correlativo_programacion", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_grid_programacion(String codigo_sucursal, String fecha_ini, String fecha_fin, String es_liquidado) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_programacion('" + codigo_sucursal + "','" + fecha_ini + "','" + fecha_fin + "','"+es_liquidado+"','" + gs_periodo + "') "
                    + "as (codigo_programacion character(16),fecha date,numero character(10),liquidado text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_programacion", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_programacion(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_programacion('" + codigo_operacion + "','" + gs_periodo + "') "
                    + "as (codigo_programacion character(16) , codigo_sucursal character(4) ,    numero_documento character(10) ,    fecha_reparto date,    fecha_registro timestamp with time zone ,    codigo_transportista character(4) ,    nombre_transportista character varying(250) ,    numero_licencia character varying(15),    razon_social_trans character varying(250) ,    ruc_trans character(11) ,    codigo_vehiculo character(6) ,    marca character varying(30) ,    numero_civ character varying(30),    codigo_vehiculo_2 character(6) ,    marca_2 character varying(30),    numero_civ_2 character varying(30) ,    es_liquidado character(1) ,    status character(1) ,    observacion text ,fecha_preventa date)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_programacion", e.getMessage());
        }
        return null;
    }

    public boolean DLT_programacion(String codigo_operacion) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_programacion('" + codigo_operacion + "','" + gs_periodo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_programacion", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
                go_dao_auditoria.IST_auditoria(codigo_operacion, SQL, ls_modulo, "3", "0050");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_programacion", e.getMessage());
        }
        return resp;
    }

    public boolean IST_programacion(BEAN_programacion OBJ_ped, JTable OBJ_pgp) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_programacion('" + OBJ_ped.getCodigo_programacion() + "','" + OBJ_ped.getCodigo_sucursal() + "','" + OBJ_ped.getNumero_documento() + "','" + OBJ_ped.getFecha_reparto() + "','" + OBJ_ped.getCodigo_transportista() + "','" + OBJ_ped.getNombre_transportista() + "','" + OBJ_ped.getNumero_licencia() + "','" + OBJ_ped.getRazon_social_trans() + "','" + OBJ_ped.getRuc_trans() + "','" + OBJ_ped.getCodigo_vehiculo() + "','" + OBJ_ped.getMarca() + "','" + OBJ_ped.getNumero_civ() + "','" + OBJ_ped.getCodigo_vehiculo_2() + "','" + OBJ_ped.getMarca_2() + "','" + OBJ_ped.getNumero_civ_2() + "','" + OBJ_ped.getEs_liquidado() + "','" + OBJ_ped.getStatus() + "','" + OBJ_ped.getObservacion() + "','" + OBJ_ped.getFecha_preventa() + "','" + gs_periodo + "')";

            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                for (int i = 0; i < OBJ_pgp.getRowCount(); i++) {
                    String SQL2 = "select * from ist_programacion_detalle('" + OBJ_ped.getCodigo_programacion() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 1).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 0).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 2).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 3).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 4).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 5).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 6).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 7).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 8).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 9).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 10).toString().trim() + "',"
                            + "'" + gs_periodo + "')";
                    lq_rs = lq_stm.executeQuery(SQL2);
                }
                if (lq_rs.next()) {
                    lq_stm.getConnection().commit();
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_programacion", "SE ACTUALIZO BASE DE DATOS");
                    resp = true;
                    go_dao_auditoria.IST_auditoria(OBJ_ped.getCodigo_programacion(), SQL, ls_modulo, "1", "0050");
                }
            }
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_programacion", e.getMessage());
        }
        return resp;
    }
}
