package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.CONFIG.LOGICA.cbx_sector_distribucion;
import JAVA.CONFIG.LOGICA.cbx_tabla_ayuda;
import JAVA.INVENT.LOGICA.cbx_grupo_detraccion;
import JAVA.VENTAS.BEAN.BEAN_guia_remision;
import JAVA.VENTAS.GUI.pnl_cab_guiar;
import JAVA.VENTAS.GUI.pnl_grid_pedidos;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class evt_cab_guiar {

    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    DecimalFormat dFormat;
    ResultSet rs;
    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "evt_cab_guiar";

    public void activa_campos(int op, pnl_cab_guiar OBJ_pcp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pcp.TXT_numero_doc.setEnabled(valor);
                OBJ_pcp.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcp.CBX_doc_ref.setEnabled(valor);
                OBJ_pcp.CBX_moneda.setEnabled(valor);
                OBJ_pcp.CBX_es_pedido.setEnabled(valor);
                OBJ_pcp.CBX_codigo_detraccion.setEnabled(valor);
                OBJ_pcp.JRD_precio_igv.setEnabled(valor);
                OBJ_pcp.TXT_codigo_entidad.setEnabled(valor);
                OBJ_pcp.CBX_direccion.setEnabled(valor);
                OBJ_pcp.TXT_codigo_vendedor.setEnabled(valor);
                OBJ_pcp.TXT_transportista.setEnabled(valor);
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                OBJ_pcp.CBX_forma_pago.setEnabled(valor);
                OBJ_pcp.TXT_dias_credito.setEnabled(valor);
                OBJ_pcp.TXT_tipo_cambio.setEnabled(false);
                OBJ_pcp.TXT_pedido.setEnabled(false);
                OBJ_pcp.CBX_tipo_op.setEnabled(valor);
                OBJ_pcp.TXT_serie_doc_ref.setEnabled(valor);
                OBJ_pcp.TXT_doc_ref.setEnabled(valor);
                OBJ_pcp.CBX_sector.setEnabled(valor);
                OBJ_pcp.TXT_codigo_pagador.setEnabled(valor);
                OBJ_pcp.TXT_numero_doc.requestFocus();
                break;
            case 1:
                OBJ_pcp.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcp.CBX_doc_ref.setEnabled(valor);
                OBJ_pcp.CBX_moneda.setEnabled(valor);
                OBJ_pcp.CBX_codigo_detraccion.setEnabled(valor);
                OBJ_pcp.JRD_precio_igv.setEnabled(valor);
                OBJ_pcp.TXT_codigo_entidad.setEnabled(valor);
                OBJ_pcp.CBX_direccion.setEnabled(valor);
                OBJ_pcp.TXT_codigo_vendedor.setEnabled(valor);
                OBJ_pcp.TXT_transportista.setEnabled(valor);
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                OBJ_pcp.CBX_forma_pago.setEnabled(valor);
                OBJ_pcp.TXT_dias_credito.setEnabled(valor);
                OBJ_pcp.TXT_tipo_cambio.setEnabled(false);
                OBJ_pcp.TXT_pedido.setEnabled(valor);
                OBJ_pcp.TXT_serie_doc_ref.setEnabled(valor);
                OBJ_pcp.TXT_doc_ref.setEnabled(valor);
                OBJ_pcp.CBX_sector.setEnabled(valor);
                OBJ_pcp.TXT_fecha_emision.requestFocus();
                break;
            case 2:
                OBJ_pcp.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcp.TXT_serie_doc_ref.setEnabled(valor);
                OBJ_pcp.TXT_doc_ref.setEnabled(valor);
                OBJ_pcp.TXT_transportista.setEnabled(valor);
                OBJ_pcp.TXT_fecha_emision.requestFocus();
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                break;
        }
    }

    public void limpia_datos(pnl_cab_guiar OBJ_pcp) {
        OBJ_pcp.LBL_numero_doc.setText("0000000000");
        OBJ_pcp.TXT_numero_doc.setText("");
        OBJ_pcp.TXT_fecha_emision.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcp.CBX_doc_ref.setSelectedIndex(0);
        OBJ_pcp.CBX_tipo_op.setSelectedIndex(0);
        OBJ_pcp.CBX_moneda.setSelectedIndex(0);
        go_cbx_trato_datos.selecciona_valor(19, "01", OBJ_pcp.CBX_tipo_op);
        OBJ_pcp.TXT_tipo_cambio.setText("0.000");
        OBJ_pcp.CBX_es_pedido.setSelectedIndex(0);
        OBJ_pcp.TXT_pedido.setText("0000000000");
        OBJ_pcp.TXT_serie_doc_ref.setText("");
        OBJ_pcp.TXT_doc_ref.setText("");
        OBJ_pcp.TXT_transportista.setText("");
        OBJ_pcp.CBX_afecto_igv.setSelectedIndex(1);
        OBJ_pcp.CBX_codigo_detraccion.setSelectedIndex(0);
        OBJ_pcp.TXT_detraccion.setText("0.000");
        OBJ_pcp.TXT_codigo_entidad.setText("");
        OBJ_pcp.TXT_razon_social.setText("");
        OBJ_pcp.CBX_tipo_documento_id.setSelectedIndex(0);
        OBJ_pcp.TXT_doc_id.setText("");
        OBJ_pcp.CBX_direccion.removeAllItems();
        OBJ_pcp.TXT_codigo_ubigeo.setText("");
        OBJ_pcp.TXT_descripcion.setText("");
        OBJ_pcp.TXT_codigo_pagador.setText("");
        OBJ_pcp.TXT_pagador.setText("");
        OBJ_pcp.TXT_codigo_vendedor.setText("");
        OBJ_pcp.TXT_nombre_vendedor.setText("");
        OBJ_pcp.CBX_forma_pago.setSelectedIndex(0);
        OBJ_pcp.TXT_dias_credito.setText("");
        OBJ_pcp.TXT_observacion.setText("");
        OBJ_pcp.CBX_status.setSelectedIndex(1);
        OBJ_pcp.LBL_fecha_registro.setText("");
        go_cbx_trato_datos.selecciona_valor(20, "999999", OBJ_pcp.CBX_sector);
        OBJ_pcp.JRD_domiciliado.setSelected(true);
        OBJ_pcp.JRD_precio_igv.setSelected(false);
    }

    public void muestra_datos_ref(ResultSet rs, String codigo, pnl_cab_guiar OBJ_pnf, pnl_grid_pedidos OBJ_pgp) {
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        dFormat = new DecimalFormat("#,##0.00", simbolos);
        try {            
            OBJ_pnf.TXT_pedido.setText(codigo.substring(6));
            OBJ_pnf.CBX_doc_ref.setSelectedIndex((rs.getString(12).equalsIgnoreCase("6")) ? 0 : 1);
            go_cbx_trato_datos.selecciona_valor(0, rs.getString(3), OBJ_pnf.CBX_moneda);
            OBJ_pnf.CBX_afecto_igv.setSelectedIndex(rs.getInt(4));
            go_cbx_trato_datos.selecciona_valor(15, rs.getString(5), OBJ_pnf.CBX_igv);
            go_cbx_trato_datos.selecciona_valor(10, rs.getString(6), OBJ_pnf.CBX_codigo_detraccion);
            OBJ_pnf.TXT_detraccion.setText(rs.getString(7));
            OBJ_pnf.TXT_codigo_entidad.setText(rs.getString(8));
            OBJ_pnf.TXT_razon_social.setText(rs.getString(9));
            OBJ_pnf.TXT_doc_id.setText(rs.getString(10));
            OBJ_pnf.JRD_domiciliado.setSelected(go_fnc_operaciones_campos.int_boolean(rs.getInt(11)));
            
            try {
                if (!OBJ_pnf.TXT_codigo_entidad.getText().equalsIgnoreCase("999999")) {
                    ResultSet rs_a = go_dao_entidad.SLT_datos_entidad_x_facturacion(rs.getString(8), rs.getString(12));
                    go_cbx_trato_datos.recupera_valor(16, rs_a, OBJ_pnf.CBX_direccion);
                    go_cbx_trato_datos.selecciona_valor(16, rs_a.getString(13), OBJ_pnf.CBX_direccion);
                } else {
                    OBJ_pnf.CBX_direccion.addItem(rs.getString(13));
                }

            } catch (Exception e) {
            }
            OBJ_pnf.TXT_codigo_ubigeo.setText(rs.getString(14));
            OBJ_pnf.TXT_descripcion.setText(rs.getString(15));
            OBJ_pnf.TXT_codigo_pagador.setText(rs.getString(16));
            OBJ_pnf.TXT_pagador.setText(rs.getString(17));
            OBJ_pnf.TXT_codigo_vendedor.setText(rs.getString(18));
            OBJ_pnf.TXT_nombre_vendedor.setText(rs.getString(19));
            OBJ_pnf.CBX_forma_pago.setSelectedIndex((rs.getString(20).equalsIgnoreCase("EF")) ? 0 : 1);
            OBJ_pnf.TXT_dias_credito.setText(rs.getInt(21) + "");
            OBJ_pgp.LBL_inafecto.setText(dFormat.format(rs.getDouble(22)) + "");
            OBJ_pgp.LBL_afecto.setText(dFormat.format(rs.getDouble(23)) + "");
            OBJ_pgp.LBL_igv.setText(dFormat.format(rs.getDouble(24)) + "");
            OBJ_pgp.LBL_total.setText(dFormat.format(rs.getDouble(25)) + "");
            OBJ_pgp.LBL_percepcion.setText(dFormat.format(rs.getDouble(26)) + "");
            OBJ_pgp.LBL_importe.setText(dFormat.format(rs.getDouble(27)) + "");
            OBJ_pnf.JRD_precio_igv.setSelected(go_fnc_operaciones_campos.int_boolean(rs.getInt(28)));
            go_cbx_trato_datos.selecciona_valor(20, rs.getString(29), OBJ_pnf.CBX_sector);
        } catch (Exception e) {
        }

    }

    public boolean valida_moneda(double tc, String codigo_moneda) {
        boolean resp = false;
        if (codigo_moneda.equalsIgnoreCase("PEN")) {
            resp = true;
        } else if (tc > 0) {
            resp = true;
        }
        return resp;
    }

    public boolean valida_tipo_documento(int td, String numero_doc) {
        boolean resp = false;
        switch (td) {
            case 0:
                if (go_fnc_operaciones_campos.valida_ruc(numero_doc)) {
                    resp = true;
                }
                break;
            case 1:
                if (go_fnc_operaciones_campos.cant_caracter(numero_doc, 4, 8)) {
                    resp = true;
                }
                break;
        }
        return resp;
    }

    public boolean valida_campos(pnl_cab_guiar OBJ_pcp, cbx_moneda cbx_moneda, String codigo_transportista, String codigo_direccion) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_numero_doc)) {
            OBJ_pcp.TXT_numero_doc.setText(go_fnc_operaciones_campos.completa_digitos(OBJ_pcp.TXT_numero_doc.getText().trim(), "0", 10));
            OBJ_pcp.LBL_numero_doc.setText(OBJ_pcp.TXT_numero_doc.getText());
            if (go_fnc_operaciones_campos.valida_fecha(OBJ_pcp.TXT_fecha_emision.getText())) {
                if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_tipo_cambio)) {
                    if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_entidad)) {
                        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_razon_social)) {
                            if (valida_tipo_documento(OBJ_pcp.CBX_tipo_documento_id.getSelectedIndex(), OBJ_pcp.TXT_doc_id.getText().trim())) {
                                if (!OBJ_pcp.CBX_direccion.getSelectedItem().toString().trim().equalsIgnoreCase("")) {
                                    if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_ubigeo)) {
                                        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_pagador)) {
                                            if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_vendedor)) {
                                                if (!codigo_direccion.equalsIgnoreCase("") && !codigo_transportista.equalsIgnoreCase("")) {
                                                    if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_serie_doc_ref)) {
                                                        OBJ_pcp.TXT_serie_doc_ref.setText(go_fnc_operaciones_campos.completa_digitos(OBJ_pcp.TXT_serie_doc_ref.getText().trim(), "0", 4));
                                                        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_doc_ref)) {
                                                            OBJ_pcp.TXT_doc_ref.setText(go_fnc_operaciones_campos.completa_digitos(OBJ_pcp.TXT_doc_ref.getText().trim(), "0", 10));
                                                            resp = true;
                                                            if (!go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_dias_credito)) {
                                                                OBJ_pcp.TXT_dias_credito.setText("0");
                                                            }
                                                        } else {
                                                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NUMERO DOCUMENTO REFERENCIA");
                                                            OBJ_pcp.TXT_doc_ref.requestFocus();
                                                        }
                                                    } else {
                                                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE SERIE DOCUMENTO REFERENCIA");
                                                        OBJ_pcp.TXT_serie_doc_ref.requestFocus();
                                                    }
                                                } else {
                                                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE TRANSPORTISTA y/o PUNTO DE LLEGADA");
                                                    OBJ_pcp.TXT_transportista.requestFocus();
                                                }
                                            } else {
                                                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO VENDEDOR");
                                                OBJ_pcp.TXT_codigo_vendedor.requestFocus();
                                            }
                                        } else {
                                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO PAGADOR");
                                            OBJ_pcp.TXT_codigo_pagador.requestFocus();
                                        }
                                    } else {
                                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO UBIGEO");
                                        OBJ_pcp.TXT_codigo_ubigeo.requestFocus();
                                    }
                                } else {
                                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE DIRECCION");
                                    OBJ_pcp.CBX_direccion.requestFocus();
                                }
                            } else {
                                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE N° DOCUMENTO CORRECTO");
                                OBJ_pcp.TXT_doc_id.requestFocus();
                            }
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "RAZON SOCIAL");
                            OBJ_pcp.TXT_razon_social.requestFocus();
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE ENTIDAD");
                        OBJ_pcp.TXT_codigo_entidad.requestFocus();
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE TIPO DE CAMBIO");
                    OBJ_pcp.TXT_tipo_cambio.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FECHA INVALIDA");
                OBJ_pcp.TXT_fecha_emision.setText("");
                OBJ_pcp.TXT_fecha_emision.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NUMERO DOCUMENTO");
            OBJ_pcp.TXT_numero_doc.requestFocus();
        }
        return resp;
    }

    public void setea_campos(BEAN_guia_remision OBJ_bpe, pnl_cab_guiar OBJ_pcp, cbx_grupo_detraccion cbx_grupo_detraccion, cbx_moneda cbx_moneda, cbx_igv cbx_igv, cbx_tabla_ayuda cbx_tabla_ayuda, cbx_sector_distribucion cbx_sector, pnl_grid_pedidos OBJ_pgp, double monto_min) {
        try {
            OBJ_bpe.setPeriodo(gs_periodo);
            OBJ_bpe.setMes(OBJ_pcp.TXT_fecha_emision.getText().trim().substring(3, 5));
            OBJ_bpe.setCodigo_documento("09");
            OBJ_bpe.setSerie_documento(OBJ_pcp.TXT_serie.getText().trim());
            OBJ_bpe.setNumero_documento(OBJ_pcp.TXT_numero_doc.getText().trim());
            OBJ_bpe.setFecha_emision(go_fnc_operaciones_campos.get_campo_str(OBJ_pcp.TXT_fecha_emision));
            OBJ_bpe.setEs_pedido(OBJ_pcp.CBX_es_pedido.getSelectedIndex() + "");
            OBJ_bpe.setCodigo_documento_ref((OBJ_pcp.CBX_doc_ref.getSelectedIndex() == 0) ? "01" : "03");
            OBJ_bpe.setSerie_documento_ref(OBJ_pcp.TXT_serie_doc_ref.getText().trim());
            OBJ_bpe.setNumero_documento_ref(OBJ_pcp.TXT_doc_ref.getText().trim());
            OBJ_bpe.setTipo_operacion(cbx_tabla_ayuda.getID());
            OBJ_bpe.setCodigo_moneda(cbx_moneda.getID());
            OBJ_bpe.setTipo_cambio(Double.parseDouble(OBJ_pcp.TXT_tipo_cambio.getText()));
            OBJ_bpe.setAfecto_igv(OBJ_pcp.CBX_afecto_igv.getSelectedIndex() + "");
            OBJ_bpe.setCodigo_igv(cbx_igv.getID());
            OBJ_bpe.setCodigo_grupo(cbx_grupo_detraccion.getID());
            OBJ_bpe.setPorcentaje_detraccion(Double.parseDouble(OBJ_pcp.TXT_detraccion.getText()));
            OBJ_bpe.setStatus(OBJ_pcp.CBX_status.getSelectedIndex() + "");
            OBJ_bpe.setEs_facturado("0");
            OBJ_bpe.setEs_precio_igv(go_fnc_operaciones_campos.boolean_int(OBJ_pcp.JRD_precio_igv.isSelected()) + "");
            OBJ_bpe.setCodigo_entidad(OBJ_pcp.TXT_codigo_entidad.getText().trim());
            OBJ_bpe.setRazon_social(OBJ_pcp.TXT_razon_social.getText().trim());
            OBJ_bpe.setTipo_documento_id((OBJ_pcp.CBX_tipo_documento_id.getSelectedIndex() == 0) ? "6" : "1");
            OBJ_bpe.setNumero_documento_id(OBJ_pcp.TXT_doc_id.getText().trim());
            OBJ_bpe.setDireccion(OBJ_pcp.CBX_direccion.getSelectedItem().toString().toUpperCase());
            OBJ_bpe.setCodigo_ubigeo(OBJ_pcp.TXT_codigo_ubigeo.getText().trim());
            OBJ_bpe.setDescripcion_ubigeo(OBJ_pcp.TXT_descripcion.getText().trim());
            OBJ_bpe.setCodigo_sector(cbx_sector.getID());
            OBJ_bpe.setCodigo_pagador(OBJ_pcp.TXT_codigo_pagador.getText().trim());
            OBJ_bpe.setNombre_pagador(OBJ_pcp.TXT_pagador.getText().trim());
            OBJ_bpe.setCodigo_vendedor(OBJ_pcp.TXT_codigo_vendedor.getText().trim());
            OBJ_bpe.setNombre_vendedor(OBJ_pcp.TXT_nombre_vendedor.getText().trim());
            OBJ_bpe.setForma_pago((OBJ_pcp.CBX_forma_pago.getSelectedIndex() == 0) ? "EF" : "CR");
            OBJ_bpe.setDias_credito(Integer.parseInt(OBJ_pcp.TXT_dias_credito.getText()));
            OBJ_bpe.setObservacion(OBJ_pcp.TXT_observacion.getText().trim());
            OBJ_bpe.setEs_domiciliado(go_fnc_operaciones_campos.boolean_int(OBJ_pcp.JRD_domiciliado.isSelected()) + "");
            OBJ_bpe.setInafecto(Double.parseDouble(OBJ_pgp.LBL_inafecto.getText().replaceAll(",", "")));
            OBJ_bpe.setBase(Double.parseDouble(OBJ_pgp.LBL_afecto.getText().replaceAll(",", "")));
            OBJ_bpe.setIgv(Double.parseDouble(OBJ_pgp.LBL_igv.getText().replaceAll(",", "")));
            OBJ_bpe.setTotal(Double.parseDouble(OBJ_pgp.LBL_total.getText().replaceAll(",", "")));
            OBJ_bpe.setPercepcion(Double.parseDouble(OBJ_pgp.LBL_percepcion.getText().replaceAll(",", "")));
            OBJ_bpe.setTotal_documento(Double.parseDouble(OBJ_pgp.LBL_importe.getText().replaceAll(",", "")));
            OBJ_bpe.setExonerado((OBJ_pcp.JRD_domiciliado.isSelected() == false) ? Double.parseDouble(OBJ_pgp.LBL_importe.getText().replaceAll(",", "")) : 0.00);
            OBJ_bpe.setImporte_detraccion((Double.parseDouble(OBJ_pgp.LBL_total.getText().replaceAll(",", "")) >= monto_min) ? Double.parseDouble(OBJ_pgp.LBL_total.getText().replaceAll(",", "")) * Double.parseDouble(OBJ_pcp.TXT_detraccion.getText()) : 0.00);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setea_recupera(BEAN_guia_remision OBJ_bpe, ResultSet lq_rs) {
        try {
            OBJ_bpe.setCodigo_operacion(lq_rs.getString(1));
            OBJ_bpe.setCodigo_sucursal(lq_rs.getString(2));
            OBJ_bpe.setPeriodo(lq_rs.getString(3));
            OBJ_bpe.setMes(lq_rs.getString(4));
            OBJ_bpe.setCodigo_documento(lq_rs.getString(5));
            OBJ_bpe.setSerie_documento(lq_rs.getString(6));
            OBJ_bpe.setNumero_documento(lq_rs.getString(7));
            OBJ_bpe.setFecha_emision(go_fnc_operaciones_campos.recupera_fecha_formato((lq_rs.getString(8))));
            OBJ_bpe.setFecha_registro(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(9).substring(0, 10)) + " " + lq_rs.getString(9).substring(11));
            OBJ_bpe.setTipo_operacion(lq_rs.getString(10));
            OBJ_bpe.setEs_pedido(lq_rs.getString(11));
            OBJ_bpe.setCodigo_pedido(lq_rs.getString(12));
            OBJ_bpe.setCodigo_documento_ref(lq_rs.getString(13));
            OBJ_bpe.setSerie_documento_ref(lq_rs.getString(14));
            OBJ_bpe.setNumero_documento_ref(lq_rs.getString(15));
            OBJ_bpe.setCodigo_moneda(lq_rs.getString(16));
            OBJ_bpe.setTipo_cambio(lq_rs.getDouble(17));
            OBJ_bpe.setAfecto_igv(lq_rs.getString(18));
            OBJ_bpe.setCodigo_igv(lq_rs.getString(19));
            OBJ_bpe.setCodigo_grupo(lq_rs.getString(20));
            OBJ_bpe.setPorcentaje_detraccion(lq_rs.getDouble(21));
            OBJ_bpe.setStatus(lq_rs.getString(22));
            OBJ_bpe.setEs_facturado(lq_rs.getString(23));
            OBJ_bpe.setEs_precio_igv(lq_rs.getString(24));
            OBJ_bpe.setCodigo_entidad(lq_rs.getString(25));
            OBJ_bpe.setRazon_social(lq_rs.getString(26));
            OBJ_bpe.setTipo_documento_id(lq_rs.getString(27));
            OBJ_bpe.setNumero_documento_id(lq_rs.getString(28));
            OBJ_bpe.setDireccion(lq_rs.getString(29));
            OBJ_bpe.setCodigo_ubigeo(lq_rs.getString(30));
            OBJ_bpe.setDescripcion_ubigeo(lq_rs.getString(31));
            OBJ_bpe.setCodigo_sector(lq_rs.getString(64));
            OBJ_bpe.setCodigo_pagador(lq_rs.getString(32));
            OBJ_bpe.setNombre_pagador(lq_rs.getString(33));
            OBJ_bpe.setCodigo_vendedor(lq_rs.getString(34));
            OBJ_bpe.setNombre_vendedor(lq_rs.getString(35));
            OBJ_bpe.setForma_pago(lq_rs.getString(36));
            OBJ_bpe.setDias_credito(lq_rs.getInt(37));
            OBJ_bpe.setObservacion(lq_rs.getString(38));
            OBJ_bpe.setEs_domiciliado(lq_rs.getString(39));
            OBJ_bpe.setCodigo_transportista(lq_rs.getString(40));
            OBJ_bpe.setNombre_transportista(lq_rs.getString(41));
            OBJ_bpe.setNumero_licencia(lq_rs.getString(42));
            OBJ_bpe.setRazon_social_trans(lq_rs.getString(43));
            OBJ_bpe.setRuc_trans(lq_rs.getString(44));
            OBJ_bpe.setCodigo_vehiculo(lq_rs.getString(45));
            OBJ_bpe.setMarca(lq_rs.getString(46));
            OBJ_bpe.setNumero_civ(lq_rs.getString(47));
            OBJ_bpe.setCodigo_vehiculo_2(lq_rs.getString(48));
            OBJ_bpe.setMarca_2(lq_rs.getString(49));
            OBJ_bpe.setNumero_civ_2(lq_rs.getString(50));
            OBJ_bpe.setCodigo_direccion_pl(lq_rs.getString(51));
            OBJ_bpe.setNombre_direccion_pl(lq_rs.getString(52));
            OBJ_bpe.setPunto_llegada(lq_rs.getString(53));
            OBJ_bpe.setCodigo_ubigeo_pl(lq_rs.getString(54));
            OBJ_bpe.setDescripcion_ubigeo_pl(lq_rs.getString(55));
            OBJ_bpe.setInafecto(lq_rs.getDouble(56));
            OBJ_bpe.setBase(lq_rs.getDouble(57));
            OBJ_bpe.setIgv(lq_rs.getDouble(58));
            OBJ_bpe.setTotal(lq_rs.getDouble(59));
            OBJ_bpe.setPercepcion(lq_rs.getDouble(60));
            OBJ_bpe.setTotal_documento(lq_rs.getDouble(61));
            OBJ_bpe.setExonerado(lq_rs.getDouble(62));
            OBJ_bpe.setImporte_detraccion(lq_rs.getDouble(63));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void muestra_datos(pnl_cab_guiar OBJ_pdp, BEAN_guia_remision OBJ_bpe, pnl_grid_pedidos OBJ_pgp) {
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        dFormat = new DecimalFormat("#,##0.00", simbolos);
        OBJ_pdp.CBX_es_pedido.setSelectedIndex(Integer.parseInt(OBJ_bpe.getEs_pedido()));
        OBJ_pdp.TXT_numero_doc.setText(OBJ_bpe.getNumero_documento());
        OBJ_pdp.LBL_numero_doc.setText(OBJ_bpe.getNumero_documento());
        OBJ_pdp.TXT_fecha_emision.setText(OBJ_bpe.getFecha_emision());
        OBJ_pdp.LBL_fecha_registro.setText(OBJ_bpe.getFecha_registro());
        go_cbx_trato_datos.selecciona_valor(19, OBJ_bpe.getTipo_operacion(), OBJ_pdp.CBX_tipo_op);
        OBJ_pdp.TXT_pedido.setText((OBJ_bpe.getEs_pedido().equalsIgnoreCase("1")) ? OBJ_bpe.getCodigo_pedido().substring(6) : "0000000000");
        OBJ_pdp.CBX_doc_ref.setSelectedIndex((OBJ_bpe.getCodigo_documento_ref().equalsIgnoreCase("01")) ? 0 : 1);
        OBJ_pdp.TXT_serie_doc_ref.setText(OBJ_bpe.getSerie_documento_ref());
        OBJ_pdp.TXT_doc_ref.setText(OBJ_bpe.getNumero_documento_ref());
        go_cbx_trato_datos.selecciona_valor(0, OBJ_bpe.getCodigo_moneda(), OBJ_pdp.CBX_moneda);
        OBJ_pdp.TXT_tipo_cambio.setText(OBJ_bpe.getTipo_cambio() + "");
        OBJ_pdp.CBX_afecto_igv.setSelectedIndex(Integer.parseInt(OBJ_bpe.getAfecto_igv()));
        go_cbx_trato_datos.selecciona_valor(15, OBJ_bpe.getCodigo_igv(), OBJ_pdp.CBX_igv);
        go_cbx_trato_datos.selecciona_valor(10, OBJ_bpe.getCodigo_grupo(), OBJ_pdp.CBX_codigo_detraccion);
        OBJ_pdp.TXT_detraccion.setText(OBJ_bpe.getPorcentaje_detraccion() + "");
        OBJ_pdp.CBX_status.setSelectedIndex(Integer.parseInt(OBJ_bpe.getStatus()));
        OBJ_pdp.JRD_precio_igv.setSelected(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bpe.getEs_precio_igv())));
        OBJ_pdp.TXT_codigo_entidad.setText(OBJ_bpe.getCodigo_entidad());
        OBJ_pdp.TXT_razon_social.setText(OBJ_bpe.getRazon_social());
        OBJ_pdp.CBX_tipo_documento_id.setSelectedIndex((OBJ_bpe.getTipo_documento_id().equalsIgnoreCase("6")) ? 0 : 1);
        OBJ_pdp.TXT_doc_id.setText(OBJ_bpe.getNumero_documento_id());
        OBJ_pdp.JRD_domiciliado.setSelected(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bpe.getEs_domiciliado())));
        try {
            if (!OBJ_bpe.getCodigo_entidad().equalsIgnoreCase("999999")) {
                rs = go_dao_entidad.SLT_datos_entidad_x_facturacion(OBJ_bpe.getCodigo_entidad(), OBJ_bpe.getTipo_documento_id());
                go_cbx_trato_datos.recupera_valor(16, rs, OBJ_pdp.CBX_direccion);
                go_cbx_trato_datos.selecciona_valor(16, OBJ_bpe.getDireccion(), OBJ_pdp.CBX_direccion);
            } else {
                OBJ_pdp.CBX_direccion.addItem(OBJ_bpe.getDireccion());
            }
        } catch (Exception e) {
        }
        go_cbx_trato_datos.selecciona_valor(20, OBJ_bpe.getCodigo_sector(), OBJ_pdp.CBX_sector);
        OBJ_pdp.TXT_codigo_ubigeo.setText(OBJ_bpe.getCodigo_ubigeo());
        OBJ_pdp.TXT_descripcion.setText(OBJ_bpe.getDescripcion_ubigeo());
        OBJ_pdp.TXT_codigo_pagador.setText(OBJ_bpe.getCodigo_pagador());
        OBJ_pdp.TXT_pagador.setText(OBJ_bpe.getNombre_pagador());
        OBJ_pdp.TXT_codigo_vendedor.setText(OBJ_bpe.getCodigo_vendedor());
        OBJ_pdp.TXT_nombre_vendedor.setText(OBJ_bpe.getNombre_vendedor());
        OBJ_pdp.CBX_forma_pago.setSelectedIndex((OBJ_bpe.getForma_pago().equalsIgnoreCase("EF")) ? 0 : 1);
        OBJ_pdp.TXT_dias_credito.setText(OBJ_bpe.getDias_credito() + "");
        OBJ_pdp.TXT_observacion.setText(OBJ_bpe.getObservacion());
        OBJ_pdp.TXT_transportista.setText(OBJ_bpe.getCodigo_transportista());
        OBJ_pgp.LBL_inafecto.setText(dFormat.format(OBJ_bpe.getInafecto()) + "");
        OBJ_pgp.LBL_afecto.setText(dFormat.format(OBJ_bpe.getBase()) + "");
        OBJ_pgp.LBL_igv.setText(dFormat.format(OBJ_bpe.getIgv()) + "");
        OBJ_pgp.LBL_total.setText(dFormat.format(OBJ_bpe.getTotal()) + "");
        OBJ_pgp.LBL_percepcion.setText(dFormat.format(OBJ_bpe.getPercepcion()) + "");
        OBJ_pgp.LBL_importe.setText(dFormat.format(OBJ_bpe.getTotal_documento()) + "");
    }

    public boolean verifica_cambios(BEAN_guia_remision OBJ_bpe, pnl_cab_guiar OBJ_pcp, cbx_grupo_detraccion cbx_grupo_detraccion, cbx_moneda cbx_moneda, cbx_igv cbx_igv, cbx_sector_distribucion cbx_sector) {
        boolean resp = false;
        if (OBJ_bpe.getFecha_emision().equalsIgnoreCase(OBJ_pcp.TXT_fecha_emision.getText().trim())) {
            if (((OBJ_bpe.getCodigo_documento_ref().equalsIgnoreCase("01")) ? 0 : 1) == OBJ_pcp.CBX_doc_ref.getSelectedIndex()) {
                if (OBJ_bpe.getCodigo_moneda().equalsIgnoreCase(cbx_moneda.getID())) {
                    if (OBJ_bpe.getTipo_cambio() == Double.parseDouble(OBJ_pcp.TXT_tipo_cambio.getText().trim())) {
                        if (Integer.parseInt(OBJ_bpe.getAfecto_igv()) == OBJ_pcp.CBX_afecto_igv.getSelectedIndex()) {
                            if (OBJ_bpe.getCodigo_grupo().equalsIgnoreCase(cbx_grupo_detraccion.getID())) {
                                if (go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bpe.getEs_precio_igv())) == OBJ_pcp.JRD_precio_igv.isSelected()) {
                                    if (OBJ_bpe.getCodigo_entidad().equalsIgnoreCase(OBJ_pcp.TXT_codigo_entidad.getText().trim())) {
                                        if (OBJ_bpe.getRazon_social().equalsIgnoreCase(OBJ_pcp.TXT_razon_social.getText().trim())) {
                                            if (OBJ_bpe.getNumero_documento_id().equalsIgnoreCase(OBJ_pcp.TXT_doc_id.getText().trim())) {
                                                if (OBJ_bpe.getDireccion().equalsIgnoreCase(OBJ_pcp.CBX_direccion.getSelectedItem().toString().trim())) {
                                                    if (OBJ_bpe.getCodigo_ubigeo().equalsIgnoreCase(OBJ_pcp.TXT_codigo_ubigeo.getText().trim())) {
                                                        if (OBJ_bpe.getCodigo_vendedor().equalsIgnoreCase(OBJ_pcp.TXT_codigo_vendedor.getText().trim())) {
                                                            if (OBJ_bpe.getDias_credito() == Integer.parseInt(OBJ_pcp.TXT_dias_credito.getText().trim())) {
                                                                if (OBJ_bpe.getObservacion().equalsIgnoreCase(OBJ_pcp.TXT_observacion.getText().trim())) {
                                                                    if (((OBJ_bpe.getForma_pago().equalsIgnoreCase("EF")) ? 0 : 1) == OBJ_pcp.CBX_forma_pago.getSelectedIndex()) {
                                                                        if (OBJ_bpe.getCodigo_pedido().substring(6).equalsIgnoreCase(OBJ_pcp.TXT_pedido.getText().trim())) {
                                                                            if (OBJ_bpe.getSerie_documento_ref().equalsIgnoreCase(OBJ_pcp.TXT_serie_doc_ref.getText().trim())) {
                                                                                if (OBJ_bpe.getNumero_documento_ref().equalsIgnoreCase(OBJ_pcp.TXT_doc_ref.getText().trim())) {
                                                                                    if (OBJ_bpe.getCodigo_transportista().equalsIgnoreCase(OBJ_pcp.TXT_transportista.getText().trim())) {
                                                                                        if (OBJ_bpe.getCodigo_sector().equalsIgnoreCase(cbx_sector.getID())) {

                                                                                        } else {
                                                                                            resp = true;
                                                                                        }
                                                                                    } else {
                                                                                        resp = true;
                                                                                    }
                                                                                } else {
                                                                                    resp = true;
                                                                                }
                                                                            } else {
                                                                                resp = true;
                                                                            }
                                                                        } else {
                                                                            resp = true;
                                                                        }
                                                                    } else {
                                                                        resp = true;
                                                                    }
                                                                } else {
                                                                    resp = true;
                                                                }
                                                            } else {
                                                                resp = true;
                                                            }
                                                        } else {
                                                            resp = true;
                                                        }
                                                    } else {
                                                        resp = true;
                                                    }
                                                } else {
                                                    resp = true;
                                                }
                                            } else {
                                                resp = true;
                                            }
                                        } else {
                                            resp = true;
                                        }
                                    } else {
                                        resp = true;
                                    }
                                } else {
                                    resp = true;
                                }
                            } else {
                                resp = true;
                            }
                        } else {
                            resp = true;
                        }
                    } else {
                        resp = true;
                    }
                } else {
                    resp = true;
                }
            } else {
                resp = true;
            }
        } else {
            resp = true;
        }
        return resp;
    }

    public KeyListener evento_press(pnl_cab_guiar OBJ_pcp, KeyListener KeyEvnt) {
        OBJ_pcp.TXT_numero_doc.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_fecha_emision.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_doc_ref.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_moneda.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_tipo_cambio.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_codigo_detraccion.addKeyListener(KeyEvnt);
        OBJ_pcp.JRD_precio_igv.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_codigo_entidad.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_direccion.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_codigo_vendedor.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_forma_pago.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_observacion.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_dias_credito.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_tipo_op.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_serie_doc_ref.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_doc_ref.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_pedido.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_transportista.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_codigo_pagador.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_razon_social.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_doc_id.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_codigo_ubigeo.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_es_pedido.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_sector.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_cab_guiar OBJ_pcp, ItemListener ItemEvent) {
        OBJ_pcp.CBX_moneda.addItemListener(ItemEvent);
        OBJ_pcp.CBX_doc_ref.addItemListener(ItemEvent);
        OBJ_pcp.CBX_codigo_detraccion.addItemListener(ItemEvent);
        OBJ_pcp.CBX_direccion.addItemListener(ItemEvent);
        OBJ_pcp.JRD_precio_igv.addItemListener(ItemEvent);
        OBJ_pcp.CBX_forma_pago.addItemListener(ItemEvent);
        OBJ_pcp.CBX_es_pedido.addItemListener(ItemEvent);
        OBJ_pcp.CBX_tipo_op.addItemListener(ItemEvent);
        return ItemEvent;
    }

    public FocusListener evento_focus(pnl_cab_guiar OBJ_pcp, FocusListener FocusEvent) {
        OBJ_pcp.TXT_numero_doc.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_fecha_emision.addFocusListener(FocusEvent);
        OBJ_pcp.CBX_doc_ref.addFocusListener(FocusEvent);
        OBJ_pcp.CBX_moneda.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_tipo_cambio.addFocusListener(FocusEvent);
        OBJ_pcp.CBX_codigo_detraccion.addFocusListener(FocusEvent);
        OBJ_pcp.JRD_precio_igv.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_codigo_entidad.addFocusListener(FocusEvent);
        OBJ_pcp.CBX_direccion.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_codigo_vendedor.addFocusListener(FocusEvent);
        OBJ_pcp.CBX_forma_pago.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_observacion.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_dias_credito.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_codigo_pagador.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_razon_social.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_doc_id.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_codigo_ubigeo.addFocusListener(FocusEvent);
        OBJ_pcp.CBX_sector.addFocusListener(FocusEvent);
        OBJ_pcp.CBX_tipo_op.addFocusListener(FocusEvent);
        OBJ_pcp.CBX_es_pedido.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_serie_doc_ref.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_doc_ref.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_transportista.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_pedido.addFocusListener(FocusEvent);
        return FocusEvent;
    }
}
