package JAVA.VENTAS.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.BEAN.BEAN_pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;

public class DAO_pedido {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "VENTAS", ls_capa = "DAO", ls_clase = "DAO_pedido";

    public ResultSet FNC_correlativo_pedido(String codigo_documento, String serie_doc, String sucursal) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_correlativo_pedido('" + codigo_documento + "','" + serie_doc + "','" + sucursal + "','" + gs_periodo + "') "
                    + "as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_correlativo_pedido", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_grid_pedido(String codigo_sucursal, String fecha_ini, String fecha_fin, String serie, String es_facturado, String codigo_doc_ref, String codigo_entidad, String codigo_vendedor) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_pedido('" + codigo_sucursal + "','" + fecha_ini + "','" + fecha_fin + "','" + serie + "','" + es_facturado + "','" + codigo_doc_ref + "','" + codigo_entidad + "','" + codigo_vendedor + "','" + gs_periodo + "') "
                    + "as (fecha_emision date,numero_documento text,status text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_pedido", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_pedido(String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_pedido('" + codigo_operacion + "','" + gs_periodo + "') "
                    + "as (codigo_operacion character(16),codigo_sucursal character(4),periodo character(4),mes character(2),codigo_ducumento character(2),serie_documento character(4),numero_documento character(10),fecha_emision date,fecha_registro timestamp with time zone,codigo_documento_ref character(2),codigo_moneda character(3),tipo_cambio numeric(6,3),afecto_igv character(1),codigo_igv character(4),codigo_grupo character(3),porcentaje_detraccion numeric(5,3),status character(1),es_facturado character(1),es_precio_igv character(1),codigo_entidad character(6),razon_social character varying(250),tipo_documento_id character(1),numero_documento_id character varying(15),direccion character varying(250),codigo_ubigeo character(6),descripcion_ubigeo character varying(100),codigo_pagador character(6),nombre_pagador character varying(250),codigo_vendedor character(4),nombre_vendedor character varying(250),forma_pago character(2),dias_credito integer,observacion text,es_domiciliado character(1),inafecto numeric(14,2),base numeric(14,2),igv numeric(14,2),total numeric(14,2),percepcion numeric(14,2),total_documento numeric(14,2),exonerado numeric(14,2),importe_detraccion numeric(16,2))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_pedido", e.getMessage());
        }
        return null;
    }

    public boolean DLT_pedido(String codigo_operacion) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_pedido('" + codigo_operacion + "','" + gs_periodo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_pedido", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
                go_dao_auditoria.IST_auditoria(codigo_operacion, SQL, ls_modulo, "3", "0036");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_pedido", e.getMessage());
        }
        return resp;
    }

    public boolean IST_pedido(BEAN_pedido OBJ_ped, JTable OBJ_pgp, double porcentaje_igv) throws SQLException {
        boolean resp = false;
        double precio_cigv = 0.0, importe_cigv = 0.0, precio_sigv = 0.0, importe_sigv = 0.0, percepcion = 0.0, tipo_cambio = 0.0, precio_cigv_und = 0.0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_pedido('" + OBJ_ped.getCodigo_operacion() + "','" + OBJ_ped.getCodigo_sucursal() + "','" + OBJ_ped.getPeriodo() + "','" + OBJ_ped.getMes() + "','" + OBJ_ped.getCodigo_documento() + "','" + OBJ_ped.getSerie_documento() + "','" + OBJ_ped.getNumero_documento() + "','" + OBJ_ped.getFecha_emision() + "','" + OBJ_ped.getCodigo_documento_ref() + "','" + OBJ_ped.getCodigo_moneda() + "'," + OBJ_ped.getTipo_cambio() + ",'" + OBJ_ped.getAfecto_igv() + "','" + OBJ_ped.getCodigo_igv() + "','" + OBJ_ped.getCodigo_grupo() + "'," + OBJ_ped.getPorcentaje_detraccion() + ",'" + OBJ_ped.getStatus() + "','" + OBJ_ped.getEs_facturado() + "','" + OBJ_ped.getEs_precio_igv() + "','" + OBJ_ped.getCodigo_entidad() + "',$$" + OBJ_ped.getRazon_social() + "$$,'" + OBJ_ped.getTipo_documento_id() + "','" + OBJ_ped.getNumero_documento_id() + "',$$" + OBJ_ped.getDireccion() + "$$,'" + OBJ_ped.getCodigo_ubigeo() + "','" + OBJ_ped.getDescripcion_ubigeo() + "','" + OBJ_ped.getCodigo_pagador() + "',$$" + OBJ_ped.getNombre_pagador() + "$$,'" + OBJ_ped.getCodigo_vendedor() + "',$$" + OBJ_ped.getNombre_vendedor() + "$$,'" + OBJ_ped.getForma_pago() + "'," + OBJ_ped.getDias_credito() + ",'" + OBJ_ped.getObservacion() + "','" + OBJ_ped.getEs_domiciliado() + "'," + OBJ_ped.getInafecto() + "," + OBJ_ped.getBase() + "," + OBJ_ped.getIgv() + "," + OBJ_ped.getTotal() + "," + OBJ_ped.getPercepcion() + "," + OBJ_ped.getTotal_documento() + "," + OBJ_ped.getExonerado() + "," + OBJ_ped.getImporte_detraccion() + ",'" + gs_periodo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                for (int i = 0; i < OBJ_pgp.getRowCount(); i++) {
                    switch (OBJ_ped.getAfecto_igv()) {
                        case "0":
                            precio_cigv = 0.0;
                            precio_cigv_und = 0.00;
                            importe_cigv = 0.0;
                            precio_sigv = ((boolean) OBJ_pgp.getValueAt(i, 1))?go_fnc_operaciones_campos.redondea((double) OBJ_pgp.getValueAt(i, 9)/(double) OBJ_pgp.getValueAt(i, 15),5):(double) OBJ_pgp.getValueAt(i, 9);
                            importe_sigv = (double) OBJ_pgp.getValueAt(i, 12);
                            percepcion = 0.0;
                            break;
                        case "1":
                            if (!(boolean) OBJ_pgp.getValueAt(i, 7)) {
                                precio_cigv = 0.0;
                                precio_cigv_und = 0.00;
                                importe_cigv = 0.0;
                                precio_sigv = ((boolean) OBJ_pgp.getValueAt(i, 1))?go_fnc_operaciones_campos.redondea((double) OBJ_pgp.getValueAt(i, 9)/(double) OBJ_pgp.getValueAt(i, 15),5):(double) OBJ_pgp.getValueAt(i, 9);
                                importe_sigv = (double) OBJ_pgp.getValueAt(i, 12);
                                percepcion = (double) OBJ_pgp.getValueAt(i, 12) * (double) OBJ_pgp.getValueAt(i, 8) / 100;
                            } else {
                                precio_cigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("0")) ? (double) OBJ_pgp.getValueAt(i, 9) : (double) OBJ_pgp.getValueAt(i, 9) * (porcentaje_igv + 1);
                                precio_cigv_und = ((boolean) OBJ_pgp.getValueAt(i, 1)) ? go_fnc_operaciones_campos.redondea(precio_cigv / (double) OBJ_pgp.getValueAt(i, 15), 5) : precio_cigv;
                                importe_cigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("0")) ? (double) OBJ_pgp.getValueAt(i, 12) : (double) OBJ_pgp.getValueAt(i, 12) * (porcentaje_igv + 1);
                                precio_sigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("1")) ? precio_cigv_und : precio_cigv_und / (porcentaje_igv + 1);
                                importe_sigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("1")) ? (double) OBJ_pgp.getValueAt(i, 12) : (double) OBJ_pgp.getValueAt(i, 12) / (porcentaje_igv + 1);
                                percepcion = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("0")) ? (double) OBJ_pgp.getValueAt(i, 12) * ((double) OBJ_pgp.getValueAt(i, 8) / 100) : ((double) OBJ_pgp.getValueAt(i, 12) * (porcentaje_igv + 1)) * ((double) OBJ_pgp.getValueAt(i, 8) / 100);
                            }
                            break;
                    }

                    String SQL2 = "select * from ist_pedido_detalle('" + OBJ_ped.getCodigo_operacion() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 0).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 3).toString().trim() + "',"
                            + "$$" + OBJ_pgp.getValueAt(i, 4).toString().trim() + "$$,"
                            + "'" + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_pgp.getValueAt(i, 7)) + "',"
                            + (double) OBJ_pgp.getValueAt(i, 8) + ","
                            + (int) OBJ_pgp.getValueAt(i, 2) + ","
                            + (double) OBJ_pgp.getValueAt(i, 10) + ","
                            + (double) OBJ_pgp.getValueAt(i, 11) + ","
                            + precio_cigv_und + ","
                            + importe_cigv + ","
                            + precio_sigv + ","
                            + importe_sigv + ","
                            + percepcion + ","
                            + "'" + gs_periodo + "',"
                            + (double) OBJ_pgp.getValueAt(i, 13) + ","
                            + "'" + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_pgp.getValueAt(i, 1)) + "',"
                            + precio_cigv + ")";
                    lq_rs = lq_stm.executeQuery(SQL2);
                }
                if (lq_rs.next()) {
                    lq_stm.getConnection().commit();
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_pedido", "SE ACTUALIZO BASE DE DATOS");
                    resp = true;
                    go_dao_auditoria.IST_auditoria(OBJ_ped.getCodigo_operacion(), SQL, ls_modulo, "1", "0036");
                }
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_pedido", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_pedido(BEAN_pedido OBJ_ped, JTable OBJ_pgp, double porcentaje_igv) throws SQLException {
        boolean resp = false;
        double precio_cigv = 0.0, importe_cigv = 0.0, precio_sigv = 0.0, importe_sigv = 0.0, percepcion = 0.0, tipo_cambio = 0.0,precio_cigv_und = 0.0;;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_pedido('" + OBJ_ped.getCodigo_operacion() + "','" + OBJ_ped.getCodigo_sucursal() + "','" + OBJ_ped.getPeriodo() + "','" + OBJ_ped.getMes() + "','" + OBJ_ped.getCodigo_documento() + "','" + OBJ_ped.getSerie_documento() + "','" + OBJ_ped.getNumero_documento() + "','" + OBJ_ped.getFecha_emision() + "','" + OBJ_ped.getCodigo_documento_ref() + "','" + OBJ_ped.getCodigo_moneda() + "'," + OBJ_ped.getTipo_cambio() + ",'" + OBJ_ped.getAfecto_igv() + "','" + OBJ_ped.getCodigo_igv() + "','" + OBJ_ped.getCodigo_grupo() + "'," + OBJ_ped.getPorcentaje_detraccion() + ",'" + OBJ_ped.getStatus() + "','" + OBJ_ped.getEs_facturado() + "','" + OBJ_ped.getEs_precio_igv() + "','" + OBJ_ped.getCodigo_entidad() + "',$$" + OBJ_ped.getRazon_social() + "$$,'" + OBJ_ped.getTipo_documento_id() + "','" + OBJ_ped.getNumero_documento_id() + "',$$" + OBJ_ped.getDireccion() + "$$,'" + OBJ_ped.getCodigo_ubigeo() + "','" + OBJ_ped.getDescripcion_ubigeo() + "','" + OBJ_ped.getCodigo_pagador() + "',$$" + OBJ_ped.getNombre_pagador() + "$$,'" + OBJ_ped.getCodigo_vendedor() + "',$$" + OBJ_ped.getNombre_vendedor() + "$$,'" + OBJ_ped.getForma_pago() + "'," + OBJ_ped.getDias_credito() + ",'" + OBJ_ped.getObservacion() + "','" + OBJ_ped.getEs_domiciliado() + "'," + OBJ_ped.getInafecto() + "," + OBJ_ped.getBase() + "," + OBJ_ped.getIgv() + "," + OBJ_ped.getTotal() + "," + OBJ_ped.getPercepcion() + "," + OBJ_ped.getTotal_documento() + "," + OBJ_ped.getExonerado() + "," + OBJ_ped.getImporte_detraccion() + ",'" + gs_periodo + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                for (int i = 0; i < OBJ_pgp.getRowCount(); i++) {
                    switch (OBJ_ped.getAfecto_igv()) {
                        case "0":
                            precio_cigv = 0.0;
                            precio_cigv_und = 0.00;
                            importe_cigv = 0.0;
                            precio_sigv = ((boolean) OBJ_pgp.getValueAt(i, 1))?go_fnc_operaciones_campos.redondea((double) OBJ_pgp.getValueAt(i, 9)/(double) OBJ_pgp.getValueAt(i, 15),5):(double) OBJ_pgp.getValueAt(i, 9);
                            importe_sigv = (double) OBJ_pgp.getValueAt(i, 12);
                            percepcion = 0.0;
                            break;
                        case "1":
                            if (!(boolean) OBJ_pgp.getValueAt(i, 7)) {
                                precio_cigv = 0.0;
                                precio_cigv_und = 0.00;
                                importe_cigv = 0.0;
                                precio_sigv = ((boolean) OBJ_pgp.getValueAt(i, 1))?go_fnc_operaciones_campos.redondea((double) OBJ_pgp.getValueAt(i, 9)/(double) OBJ_pgp.getValueAt(i, 15),5):(double) OBJ_pgp.getValueAt(i, 9);
                                importe_sigv = (double) OBJ_pgp.getValueAt(i, 12);
                                percepcion = (double) OBJ_pgp.getValueAt(i, 12) * (double) OBJ_pgp.getValueAt(i, 8) / 100;
                            } else {
                                precio_cigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("0")) ? (double) OBJ_pgp.getValueAt(i, 9) : (double) OBJ_pgp.getValueAt(i, 9) * (porcentaje_igv + 1);
                                precio_cigv_und = ((boolean) OBJ_pgp.getValueAt(i, 1)) ? go_fnc_operaciones_campos.redondea(precio_cigv / (double) OBJ_pgp.getValueAt(i, 15), 5) : precio_cigv;
                                importe_cigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("0")) ? (double) OBJ_pgp.getValueAt(i, 12) : (double) OBJ_pgp.getValueAt(i, 12) * (porcentaje_igv + 1);
                                precio_sigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("1")) ? precio_cigv_und : precio_cigv_und / (porcentaje_igv + 1);
                                importe_sigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("1")) ? (double) OBJ_pgp.getValueAt(i, 12) : (double) OBJ_pgp.getValueAt(i, 12) / (porcentaje_igv + 1);
                                percepcion = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("0")) ? (double) OBJ_pgp.getValueAt(i, 12) * ((double) OBJ_pgp.getValueAt(i, 8) / 100) : ((double) OBJ_pgp.getValueAt(i, 12) * (porcentaje_igv + 1)) * ((double) OBJ_pgp.getValueAt(i, 8) / 100);
                            }
                            break;
                    }

                    String SQL2 = "select * from ist_pedido_detalle('" + OBJ_ped.getCodigo_operacion() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 0).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 3).toString().trim() + "',"
                            + "$$" + OBJ_pgp.getValueAt(i, 4).toString().trim() + "$$,"
                            + "'" + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_pgp.getValueAt(i, 7)) + "',"
                            + (double) OBJ_pgp.getValueAt(i, 8) + ","
                            + (int) OBJ_pgp.getValueAt(i, 2) + ","
                            + (double) OBJ_pgp.getValueAt(i, 10) + ","
                            + (double) OBJ_pgp.getValueAt(i, 11) + ","
                            + precio_cigv_und + ","
                            + importe_cigv + ","
                            + precio_sigv + ","
                            + importe_sigv + ","
                            + percepcion + ","
                            + "'" + gs_periodo + "',"
                            + (double) OBJ_pgp.getValueAt(i, 13) + ","
                            + "'" + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_pgp.getValueAt(i, 1)) + "',"
                            + precio_cigv + ")";
                    lq_rs = lq_stm.executeQuery(SQL2);
                }
                if (lq_rs.next()) {
                    lq_stm.getConnection().commit();
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_pedido", "SE ACTUALIZO BASE DE DATOS");
                    resp = true;
                    go_dao_auditoria.IST_auditoria(OBJ_ped.getCodigo_operacion(), SQL, ls_modulo, "2", "0036");
                }
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_pedido", e.getMessage());
        }
        return resp;
    }
    
    public ResultSet SLT_datos_ref_factura(int op, String codigo_operacion) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_ref_factura(" + op + ",'" + codigo_operacion + "','" + gs_periodo + "') "
                    + "as (codigo_operacion character(16),numero character(10),codigo_moneda character(3),afecto_igv character(1),codigo_igv character(4),codigo_grupo character(3),porcentaje_detraccion numeric(5,3),codigo_entidad character(6),razon_social character varying(250),numero_documento_id character varying(15),es_domiciliado character(1),tipo_documento_id character(1),direccion character varying(250),codigo_ubigeo character(6),descripcion_ubigeo character varying(100),codigo_pagador character(6),nombre_pagador character varying(250),codigo_vendedor character(4),nombre_vendedor character varying(250),forma_pago character(2),dias_credito integer,inafecto numeric(14,2),base numeric(14,2),igv numeric(14,2),total numeric(14,2),percepcion numeric(14,2),total_documento numeric(14,2),es_precio_igv character(1))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_ref_factura", e.getMessage());
        }
        return null;
    }

    public int SLT_cta_pedido_parametros(String codigo_sucursal, String serie, String numero) {
        int resp = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cta_pedido_parametros('" + codigo_sucursal + "','" + serie + "','" + numero + "','" + gs_entidad_usuario + "','" + gs_vendedor_usuario + "','" + gs_periodo + "') "
                    + "as (cont bigint)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                resp = lq_rs.getInt(1);
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_ref_factura", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_grid_cierre_pedidos(String codigo_sucursal, String serie) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_cierre_pedidos('" + codigo_sucursal + "','" + serie + "','" + gs_periodo + "') "
                    + "as (codigo_operacion character(16),numero_documento character(10),fecha_emision date,codigo_entidad character(6),razon_social character varying(250))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_cierre_pedidos", e.getMessage());
        }
        return null;
    }
}
