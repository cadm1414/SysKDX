
package JAVA.INVENT.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.BEAN.BEAN_kardex;
import JAVA.INVENT.GUI.pnl_grid_saldos_iniciales;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }            
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
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_kardex", e.getMessage());
        }
        return null;
    }
    
    public ResultSet SLT_datos_kardex(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_kardex('"+codigo_operacion+"') "
                    + "as (codigo_operacion character(16),fecha_registro timestamp with time zone,codigo_almacen character(4),fecha_emision date,codigo_movimiento character(2),codigo_documento character(2),serie_documento character varying(4),numero_documento character(10),codigo_documento_ref character(2),serie_documento_ref character varying(4),numero_docuemento_ref character(10),tipo_movimiento character(1),es_transferencia character(1),codigo_almacen_origen character varying(4),observacion character varying(250),status character(1))";	
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_kardex", e.getMessage());
        }
        return null;
    }
    
    public boolean DLT_kardex(String codigo_operacio) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_kardex('" + codigo_operacio + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_kardex", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_kardex", e.getMessage());
        }
        return resp;
    }
    
    public boolean IST_kardex(BEAN_kardex OBJ_kar, pnl_grid_saldos_iniciales OBJ_pgs) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_kardex('"+OBJ_kar.getCodigo_operacion()+"','"+OBJ_kar.getCodigo_almacen()+"','"+OBJ_kar.getFecha_emision()+"','"+OBJ_kar.getCodigo_movimiento()+"','"+OBJ_kar.getCodigo_documento()+"','"+OBJ_kar.getSerie_documento()+"','"+OBJ_kar.getNumero_documento()+"','"+OBJ_kar.getCodigo_documento_ref()+"','"+OBJ_kar.getSerie_documento_ref()+"','"+OBJ_kar.getNumero_documento_ref()+"','"+OBJ_kar.getTipo_movimiento()+"','"+OBJ_kar.getEs_transferencia()+"','"+OBJ_kar.getCodigo_almacen_origen()+"','"+OBJ_kar.getObservacion()+"','"+OBJ_kar.getStatus()+"')";
            
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                for (int i = 0; i < OBJ_pgs.TBL_saldos_iniciales.getRowCount(); i++) {
                    lq_rs = go_dao_articulo.SLT_datos_articulo_x_articulo(OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 2).toString().trim());
                    SQL = "select * from ist_kardex_detalle('"+OBJ_kar.getCodigo_operacion()+"',"
                            + "'"+OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 0).toString().trim()+"',"
                            + "'"+OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 5).toString().trim().substring(8, 12)+OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 5).toString().trim().substring(0,2)+OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 5).toString().trim().substring(3, 7)+"',"
                            + "'"+OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 2).toString().trim()+"',"
                            + "'"+OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 6).toString().trim()+"',"
                            + "'"+OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 3).toString().trim()+"',"
                            + "'"+lq_rs.getString(4)+"',"
                            + "'"+OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 1).toString().trim()+"',"
                            + (double) OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 8)+","
                            + (double) OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 10)+","
                            + (int) OBJ_pgs.TBL_saldos_iniciales.getValueAt(i, 7)+")";
                    lq_rs = lq_stm.executeQuery(SQL);
                }
                if (lq_rs.next()) {
                    lq_stm.getConnection().commit();
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_kardex", "SE ACTUALIZO BASE DE DATOS");
                    resp = true;
                }
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();            
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_kardex", e.getMessage());
        }
        return resp;
    }
}
