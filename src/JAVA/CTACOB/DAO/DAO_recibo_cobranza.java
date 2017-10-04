package JAVA.CTACOB.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CTACOB.BEAN.BEAN_recibo_cobranza;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;

public class DAO_recibo_cobranza {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CTACOB", ls_capa = "DAO", ls_clase = "DAO_recibo_cobranza";

    public ResultSet FNC_correlativo_recibo_cobranza(String codigo_documento, String serie_doc, String sucursal) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_correlativo_recibo_cobranza('" + codigo_documento + "','" + serie_doc + "','" + sucursal + "','" + gs_periodo + "') "
                    + "as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_correlativo_recibo_cobranza", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_grid_recibo_cobranza(String codigo_sucursal, String fecha_ini, String fecha_fin) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_recibo_cobranza('" + codigo_sucursal + "','" + fecha_ini + "','" + fecha_fin + "','" + gs_periodo + "') "
                    + "as (fecha_emision date,numero_documento text,status text,codigo_operacion character(16))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_recibo_cobranza", e.getMessage());
        }
        return null;
    }
    
    public ResultSet SLT_datos_recibo_cobranza(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_recibo_cobranza('" + codigo_operacion + "','" + gs_periodo + "') "
                    + "as (codigo_operacion character(16),codigo_sucursal character(4),codigo_documento character(2),serie_documento character(4),numero_documento character(10), fecha_emision date,fecha_registro timestamp with time zone,codigo_pagador character(6),nombre_pagador character varying(250),codigo_moneda character(3),tipo_cambio numeric,forma_pago character(1),codigo_banco character(4),numero_operacion character(12),fecha_comprobante date,observacion text,es_rendido character(1),status character(1),monto numeric,monto_mn numeric)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_recibo_cobranza", e.getMessage());
        }
        return null;
    }

    public boolean DLT_recibo_cobranza(String codigo_operacion) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_recibo_cobranza('" + codigo_operacion + "','" + gs_periodo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_recibo_cobranza", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
                go_dao_auditoria.IST_auditoria(codigo_operacion, SQL, ls_modulo, "3", "0045");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_recibo_cobranza", e.getMessage());
        }
        return resp;
    }
    
    public boolean IST_recibo_cobranza(BEAN_recibo_cobranza OBJ_ped, JTable OBJ_pgp) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_recibo_cobranza('" + OBJ_ped.getCodigo_operacion() + "','" + OBJ_ped.getCodigo_sucursal() + "','" + OBJ_ped.getCodigo_documento() + "','" + OBJ_ped.getSerie_documento() + "','" + OBJ_ped.getNumero_documento() + "','" + OBJ_ped.getFecha_emision() + "','" + OBJ_ped.getCodigo_pagador() + "','" + OBJ_ped.getNombre_pagador() + "','" + OBJ_ped.getCodigo_moneda() + "'," + OBJ_ped.getTipo_cambio() + ",'" + OBJ_ped.getForma_pago() + "','" + OBJ_ped.getCodigo_banco() + "','" + OBJ_ped.getNumero_operacion() + "','" + OBJ_ped.getFecha_comprobante() + "','" + OBJ_ped.getObservacion() + "','" + OBJ_ped.getEs_rendido() + "','" + OBJ_ped.getStatus() + "'," + OBJ_ped.getMonto() + "," + OBJ_ped.getMonto_mn() + ",'" + gs_periodo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                for (int i = 0; i < OBJ_pgp.getRowCount(); i++) {
                    String SQL2 = "select * from ist_recibo_cobranza_detalle('" + OBJ_ped.getCodigo_operacion() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 2).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 0).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 1).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 3).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 4).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 5).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 6).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 7).toString().trim() + "',"
                            + Double.parseDouble(OBJ_pgp.getValueAt(i, 8).toString().trim()) + ","
                            + Double.parseDouble(OBJ_pgp.getValueAt(i, 9).toString().trim()) + ","
                            + ((OBJ_ped.getCodigo_moneda().equalsIgnoreCase("PEN")) ? Double.parseDouble(OBJ_pgp.getValueAt(i, 9).toString().trim()) : Double.parseDouble(OBJ_pgp.getValueAt(i, 9).toString().trim()) * OBJ_ped.getTipo_cambio()) + ","
                            + Double.parseDouble(OBJ_pgp.getValueAt(i, 10).toString().trim()) + ","
                            + ((OBJ_pgp.getValueAt(i, 7).toString().trim().equalsIgnoreCase("PEN")) ? Double.parseDouble(OBJ_pgp.getValueAt(i, 10).toString().trim()) : Double.parseDouble(OBJ_pgp.getValueAt(i, 10).toString().trim()) * OBJ_ped.getTipo_cambio()) + ","
                            + "'" + gs_periodo + "')";
                    lq_rs = lq_stm.executeQuery(SQL2);
                }
                if (lq_rs.next()) {
                    lq_stm.getConnection().commit();
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_recibo_cobranza", "SE ACTUALIZO BASE DE DATOS");
                    resp = true;
                    go_dao_auditoria.IST_auditoria(OBJ_ped.getCodigo_operacion(), SQL, ls_modulo, "1", "0045");
                }
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_recibo_cobranza", e.getMessage());
        }
        return resp;
    }
    
    public boolean UPD_recibo_cobranza(BEAN_recibo_cobranza OBJ_ped, JTable OBJ_pgp) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from UPD_recibo_cobranza('" + OBJ_ped.getCodigo_operacion() + "','" + OBJ_ped.getCodigo_sucursal() + "','" + OBJ_ped.getCodigo_documento() + "','" + OBJ_ped.getSerie_documento() + "','" + OBJ_ped.getNumero_documento() + "','" + OBJ_ped.getFecha_emision() + "','" + OBJ_ped.getCodigo_pagador() + "','" + OBJ_ped.getNombre_pagador() + "','" + OBJ_ped.getCodigo_moneda() + "'," + OBJ_ped.getTipo_cambio() + ",'" + OBJ_ped.getForma_pago() + "','" + OBJ_ped.getCodigo_banco() + "','" + OBJ_ped.getNumero_operacion() + "','" + OBJ_ped.getFecha_comprobante() + "','" + OBJ_ped.getObservacion() + "','" + OBJ_ped.getEs_rendido() + "','" + OBJ_ped.getStatus() + "'," + OBJ_ped.getMonto() + "," + OBJ_ped.getMonto_mn() + ",'" + gs_periodo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                for (int i = 0; i < OBJ_pgp.getRowCount(); i++) {
                    String SQL2 = "select * from ist_recibo_cobranza_detalle('" + OBJ_ped.getCodigo_operacion() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 2).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 0).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 1).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 3).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 4).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 5).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 6).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 7).toString().trim() + "',"
                            + Double.parseDouble(OBJ_pgp.getValueAt(i, 8).toString().trim()) + ","
                            + Double.parseDouble(OBJ_pgp.getValueAt(i, 9).toString().trim()) + ","
                            + ((OBJ_ped.getCodigo_moneda().equalsIgnoreCase("PEN")) ? Double.parseDouble(OBJ_pgp.getValueAt(i, 9).toString().trim()) : Double.parseDouble(OBJ_pgp.getValueAt(i, 9).toString().trim()) * OBJ_ped.getTipo_cambio()) + ","
                            + Double.parseDouble(OBJ_pgp.getValueAt(i, 10).toString().trim()) + ","
                            + ((OBJ_pgp.getValueAt(i, 7).toString().trim().equalsIgnoreCase("PEN")) ? Double.parseDouble(OBJ_pgp.getValueAt(i, 10).toString().trim()) : Double.parseDouble(OBJ_pgp.getValueAt(i, 10).toString().trim()) * OBJ_ped.getTipo_cambio()) + ","
                            + "'" + gs_periodo + "')";
                    lq_rs = lq_stm.executeQuery(SQL2);
                }
                if (lq_rs.next()) {
                    lq_stm.getConnection().commit();
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_recibo_cobranza", "SE ACTUALIZO BASE DE DATOS");
                    resp = true;
                    go_dao_auditoria.IST_auditoria(OBJ_ped.getCodigo_operacion(), SQL, ls_modulo, "2", "0045");
                }
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_recibo_cobranza", e.getMessage());
        }
        return resp;
    }
}
