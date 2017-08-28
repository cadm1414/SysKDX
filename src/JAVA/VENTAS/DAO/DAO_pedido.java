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

    public boolean IST_pedido(BEAN_pedido OBJ_ped, JTable OBJ_pgp, double porcentaje_igv) throws SQLException {
        boolean resp = false;
        double precio_cigv = 0.0, importe_cigv = 0.0, precio_sigv = 0.0, importe_sigv = 0.0, percepcion = 0.0, tipo_cambio = 0.0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_pedido('" + OBJ_ped.getCodigo_operacion() + "','" + OBJ_ped.getCodigo_sucursal() + "','" + OBJ_ped.getPeriodo() + "','" + OBJ_ped.getMes() + "','OP','" + OBJ_ped.getSerie_documento() + "','" + OBJ_ped.getNumero_documento() + "','" + OBJ_ped.getFecha_emision() + "','" + OBJ_ped.getCodigo_documento_ref() + "','" + OBJ_ped.getCodigo_moneda() + "'," + OBJ_ped.getTipo_cambio() + ",'" + OBJ_ped.getAfecto_igv() + "','" + OBJ_ped.getCodigo_igv() + "','" + OBJ_ped.getCodigo_grupo() + "'," + OBJ_ped.getPorcentaje_detraccion() + ",'" + OBJ_ped.getStatus() + "','" + OBJ_ped.getEs_facturado() + "','" + OBJ_ped.getEs_precio_igv() + "','" + OBJ_ped.getCodigo_entidad() + "',$$ " + OBJ_ped.getRazon_social() + " $$,'" + OBJ_ped.getTipo_documento_id() + "','" + OBJ_ped.getNumero_documento_id() + "',$$ " + OBJ_ped.getDireccion() + " $$,'" + OBJ_ped.getCodigo_ubigeo() + "','" + OBJ_ped.getDescripcion_ubigeo() + "','" + OBJ_ped.getCodigo_pagador() + "',$$ " + OBJ_ped.getNombre_pagador() + " $$,'" + OBJ_ped.getCodigo_vendedor() + "',$$ " + OBJ_ped.getNombre_vendedor() + " "
                    + "$$,'" + OBJ_ped.getForma_pago() + "'," + OBJ_ped.getDias_credito() + ",'" + OBJ_ped.getObservacion() + "','" + OBJ_ped.getEs_domiciliado() + "'," + OBJ_ped.getInafecto() + "," + OBJ_ped.getBase() + "," + OBJ_ped.getIgv() + "," + OBJ_ped.getTotal() + "," + OBJ_ped.getPercepcion() + "," + OBJ_ped.getTotal_documento() + "," + OBJ_ped.getExonerado() + "," + OBJ_ped.getImporte_detraccion() + "," + OBJ_ped.getInafecto_mn() + "," + OBJ_ped.getBase_mn() + "," + OBJ_ped.getIgv_mn() + "," + OBJ_ped.getTotal_mn() + "," + OBJ_ped.getPercepcion_mn() + "," + OBJ_ped.getTotal_documento_mn() + "," + OBJ_ped.getExonerado_mn() + "," + OBJ_ped.getImporte_detraccion_mn() + ",'" + gs_periodo + "')";

            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                for (int i = 0; i < OBJ_pgp.getRowCount(); i++) {
                    tipo_cambio = (OBJ_ped.getCodigo_moneda().equalsIgnoreCase("PEN")) ? 1 : OBJ_ped.getTipo_cambio();
                    switch (OBJ_ped.getAfecto_igv()) {
                        case "0":
                            precio_cigv = 0.0;
                            importe_cigv = 0.0;
                            precio_sigv = (double) OBJ_pgp.getValueAt(i, 8);
                            importe_sigv = (double) OBJ_pgp.getValueAt(i, 11);
                            percepcion = 0.0;
                            break;
                        case "1":
                            if (!(boolean) OBJ_pgp.getValueAt(i, 6)) {
                                precio_cigv = 0.0;
                                importe_cigv = 0.0;
                                precio_sigv = (double) OBJ_pgp.getValueAt(i, 8);
                                importe_sigv = (double) OBJ_pgp.getValueAt(i, 11);
                                percepcion = (double) OBJ_pgp.getValueAt(i, 11) * (double) OBJ_pgp.getValueAt(i, 7) / 100;
                            } else {
                                precio_cigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("0")) ? (double) OBJ_pgp.getValueAt(i, 8) : (double) OBJ_pgp.getValueAt(i, 8) * (porcentaje_igv + 1);
                                importe_cigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("0")) ? (double) OBJ_pgp.getValueAt(i, 11) : (double) OBJ_pgp.getValueAt(i, 11) * (porcentaje_igv + 1);
                                precio_sigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("1")) ? (double) OBJ_pgp.getValueAt(i, 8) : (double) OBJ_pgp.getValueAt(i, 8) / (porcentaje_igv + 1);
                                importe_sigv = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("1")) ? (double) OBJ_pgp.getValueAt(i, 11) : (double) OBJ_pgp.getValueAt(i, 11) / (porcentaje_igv + 1);
                                percepcion = (OBJ_ped.getEs_precio_igv().equalsIgnoreCase("0")) ? (double) OBJ_pgp.getValueAt(i, 11) * ((double) OBJ_pgp.getValueAt(i, 7) / 100) : ((double) OBJ_pgp.getValueAt(i, 11) * (porcentaje_igv + 1)) * ((double) OBJ_pgp.getValueAt(i, 7) / 100);
                            }
                            break;
                    }

                    String SQL2 = "select * from ist_pedido_detalle('" + OBJ_ped.getCodigo_operacion() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 0).toString().trim() + "',"
                            + "'" + OBJ_pgp.getValueAt(i, 2).toString().trim() + "',"
                            + "$$" + OBJ_pgp.getValueAt(i, 3).toString().trim() + "$$,"
                            + "'" + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_pgp.getValueAt(i, 6)) + "',"
                            + (double) OBJ_pgp.getValueAt(i, 7) + ","
                            + (int) OBJ_pgp.getValueAt(i, 1) + ","
                            + (double) OBJ_pgp.getValueAt(i, 9) + ","
                            + (double) OBJ_pgp.getValueAt(i, 10) + ","
                            + precio_cigv + ","
                            + importe_cigv + ","
                            + precio_sigv + ","
                            + importe_sigv + ","
                            + percepcion + ","
                            + precio_cigv * tipo_cambio + ","
                            + importe_cigv * tipo_cambio + ","
                            + precio_sigv * tipo_cambio + ","
                            + importe_sigv * tipo_cambio + ","
                            + percepcion * tipo_cambio + ","
                            + "'" + gs_periodo + "')";
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
}
