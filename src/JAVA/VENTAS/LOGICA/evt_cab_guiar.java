package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.INVENT.LOGICA.cbx_entidad_ubigeo;
import JAVA.INVENT.LOGICA.cbx_grupo_detraccion;
import JAVA.VENTAS.BEAN.BEAN_guia_remision;
import JAVA.VENTAS.GUI.pnl_cab_guiar;
import JAVA.VENTAS.GUI.pnl_grid_pedidos;
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
                OBJ_pcp.CBX_tipo_op.setEnabled(valor);
                OBJ_pcp.TXT_pedido.setEnabled(valor);
                OBJ_pcp.TXT_serie_doc_ref.setEnabled(valor);
                OBJ_pcp.TXT_doc_ref.setEnabled(valor);
                OBJ_pcp.TXT_numero_doc.requestFocus();
                break;
            case 1:
                OBJ_pcp.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcp.CBX_doc_ref.setEnabled(valor);
                OBJ_pcp.CBX_moneda.setEnabled(valor);
                OBJ_pcp.CBX_codigo_detraccion.setEnabled(valor);
                OBJ_pcp.JRD_precio_igv.setEnabled(valor);
                OBJ_pcp.CBX_direccion.setEnabled(valor);
                OBJ_pcp.TXT_codigo_entidad.setEnabled(valor);
                OBJ_pcp.TXT_codigo_vendedor.setEnabled(valor);
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                OBJ_pcp.TXT_tipo_cambio.setEnabled((Double.parseDouble(OBJ_pcp.TXT_tipo_cambio.getText()) != 0) ? true : false);
                
                if (OBJ_pcp.CBX_forma_pago.getSelectedIndex() == 1) {
                    OBJ_pcp.CBX_forma_pago.setEnabled(valor);
                    OBJ_pcp.TXT_dias_credito.setEnabled(valor);
                }
                
                OBJ_pcp.TXT_fecha_emision.requestFocus();
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
        OBJ_pcp.TXT_tipo_cambio.setText("0.000");
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
        OBJ_pcp.JRD_domiciliado.setSelected(true);
        OBJ_pcp.JRD_precio_igv.setSelected(false);
    }
    
    public void muestra_datos_ref(int op, ResultSet rs, String codigo, pnl_cab_guiar OBJ_pnf, pnl_grid_pedidos OBJ_pgp) {
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        dFormat = new DecimalFormat("#,##0.00", simbolos);
        try {
            OBJ_pnf.CBX_tipo_op.setSelectedIndex(0);
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
                ResultSet rs_a = go_dao_entidad.SLT_datos_entidad_x_facturacion(rs.getString(8), rs.getString(12));
                go_cbx_trato_datos.recupera_valor(16, rs_a, OBJ_pnf.CBX_direccion);
                go_cbx_trato_datos.selecciona_valor(16, rs_a.getString(13), OBJ_pnf.CBX_direccion);
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
    
    public void setea_campos(BEAN_guia_remision OBJ_bpe, pnl_cab_guiar OBJ_pcp, cbx_entidad_ubigeo cbx_entidad_ubigeo, cbx_grupo_detraccion cbx_grupo_detraccion, cbx_moneda cbx_moneda, cbx_igv cbx_igv, pnl_grid_pedidos OBJ_pgp, double monto_min) {
        try {
            OBJ_bpe.setPeriodo(gs_periodo);
            OBJ_bpe.setMes(OBJ_pcp.TXT_fecha_emision.getText().trim().substring(3, 5));
            OBJ_bpe.setCodigo_documento("09");
            OBJ_bpe.setSerie_documento(OBJ_pcp.TXT_serie.getText().trim());
            OBJ_bpe.setNumero_documento(OBJ_pcp.TXT_numero_doc.getText().trim());
            OBJ_bpe.setFecha_emision(go_fnc_operaciones_campos.get_campo_str(OBJ_pcp.TXT_fecha_emision));
            OBJ_bpe.setCodigo_documento_ref((OBJ_pcp.CBX_doc_ref.getSelectedIndex() == 0) ? "01" : "03");
            OBJ_bpe.setSerie_documento_ref(OBJ_pcp.TXT_serie_doc_ref.getText().trim());
            OBJ_bpe.setNumero_documento_ref(OBJ_pcp.TXT_doc_ref.getText().trim());
            OBJ_bpe.setTipo_operacion(OBJ_pcp.CBX_tipo_op.getSelectedIndex() + "");            
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
            OBJ_bpe.setDireccion(OBJ_pcp.CBX_direccion.getSelectedItem().toString());
            OBJ_bpe.setCodigo_ubigeo(OBJ_pcp.TXT_codigo_ubigeo.getText().trim());
            OBJ_bpe.setDescripcion_ubigeo(OBJ_pcp.TXT_descripcion.getText().trim());
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
        return KeyEvnt;
    }
    
    public ItemListener evento_item(pnl_cab_guiar OBJ_pcp, ItemListener ItemEvent) {
        OBJ_pcp.CBX_moneda.addItemListener(ItemEvent);
        OBJ_pcp.CBX_doc_ref.addItemListener(ItemEvent);
        OBJ_pcp.CBX_codigo_detraccion.addItemListener(ItemEvent);
        OBJ_pcp.CBX_direccion.addItemListener(ItemEvent);
        OBJ_pcp.JRD_precio_igv.addItemListener(ItemEvent);
        OBJ_pcp.CBX_forma_pago.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
