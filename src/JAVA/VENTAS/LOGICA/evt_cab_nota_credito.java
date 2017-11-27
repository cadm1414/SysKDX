package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.CONFIG.LOGICA.cbx_tabla_ayuda;
import JAVA.INVENT.LOGICA.cbx_grupo_detraccion;
import JAVA.VENTAS.BEAN.BEAN_registro_ventas;
import JAVA.VENTAS.GUI.pnl_cab_nota_credito;
import JAVA.VENTAS.GUI.pnl_grid_pedidos;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class evt_cab_nota_credito {

    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    DecimalFormat dFormat;
    ResultSet rs;
    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "evt_cab_factura";

    public void activa_campos(int op, pnl_cab_nota_credito OBJ_pcf, boolean valor, String codigo_documento) {
        switch (op) {
            case 0:
                OBJ_pcf.TXT_numero_doc.setEnabled(valor);
                OBJ_pcf.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcf.CBX_moneda.setEnabled(valor);
                OBJ_pcf.CBX_codigo_detraccion.setEnabled((codigo_documento.equalsIgnoreCase("01")) ? valor : false);
                OBJ_pcf.TXT_numero_ref.setEnabled(valor);
                OBJ_pcf.JRD_precio_igv.setEnabled(valor);
                OBJ_pcf.TXT_observacion.setEnabled(valor);
                OBJ_pcf.TXT_tipo_cambio.setEnabled(false);
                OBJ_pcf.CBX_concepto.setEnabled(valor);
                OBJ_pcf.CBX_direccion.setEnabled(valor);
                OBJ_pcf.CBX_registra_item.setEnabled(valor);
                OBJ_pcf.TXT_numero_doc.requestFocus();
                break;
            case 1:
                OBJ_pcf.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcf.TXT_observacion.setEnabled(valor);
                OBJ_pcf.TXT_fecha_emision.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_cab_nota_credito OBJ_pcf, String tipo_documento) {
        OBJ_pcf.LBL_numero_doc.setText("0000000000");
        OBJ_pcf.TXT_numero_doc.setText("");
        OBJ_pcf.TXT_serie_ref.setText("0000");
        OBJ_pcf.TXT_numero_ref.setText("");
        OBJ_pcf.TXT_fecha_emision.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcf.CBX_moneda.setSelectedIndex(0);
        OBJ_pcf.TXT_tipo_cambio.setText("0.000");
        OBJ_pcf.CBX_afecto_igv.setSelectedIndex(1);
        OBJ_pcf.CBX_codigo_detraccion.setSelectedIndex(0);
        OBJ_pcf.TXT_detraccion.setText("0.000");
        OBJ_pcf.TXT_codigo_entidad.setText("");
        OBJ_pcf.TXT_razon_social.setText("");
        OBJ_pcf.CBX_tipo_documento_id.setSelectedIndex(0);
        OBJ_pcf.TXT_doc_id.setText("");
        OBJ_pcf.CBX_direccion.removeAllItems();
        OBJ_pcf.TXT_codigo_ubigeo.setText("");
        OBJ_pcf.TXT_descripcion.setText("");
        OBJ_pcf.TXT_codigo_pagador.setText("");
        OBJ_pcf.TXT_pagador.setText("");
        OBJ_pcf.TXT_codigo_vendedor.setText("");
        OBJ_pcf.TXT_nombre_vendedor.setText("");
        OBJ_pcf.TXT_observacion.setText("");
        OBJ_pcf.CBX_status.setSelectedIndex(1);
        OBJ_pcf.LBL_fecha_registro.setText("");
        OBJ_pcf.TXT_total.setText("0.00");
        OBJ_pcf.JRD_domiciliado.setSelected(true);
        OBJ_pcf.JRD_precio_igv.setSelected(false);
        OBJ_pcf.CBX_registra_item.setSelectedIndex(1);
    }

    public void muestra_datos_ref(int op, ResultSet rs, pnl_cab_nota_credito OBJ_pnf) {
        try {
            OBJ_pnf.TXT_serie_ref.setText(rs.getString(2));
            OBJ_pnf.TXT_numero_ref.setText(rs.getString(3));
            OBJ_pnf.CBX_afecto_igv.setSelectedIndex(rs.getInt(5));
            go_cbx_trato_datos.selecciona_valor(15, rs.getString(6), OBJ_pnf.CBX_igv);
            go_cbx_trato_datos.selecciona_valor(10, rs.getString(7), OBJ_pnf.CBX_codigo_detraccion);
            OBJ_pnf.TXT_detraccion.setText(rs.getString(8));
            OBJ_pnf.TXT_codigo_entidad.setText(rs.getString(9));
            OBJ_pnf.TXT_razon_social.setText(rs.getString(10));
            OBJ_pnf.TXT_doc_id.setText(rs.getString(11));
            OBJ_pnf.JRD_domiciliado.setSelected(go_fnc_operaciones_campos.int_boolean(rs.getInt(12)));

            OBJ_pnf.CBX_tipo_documento_id.setSelectedIndex((rs.getString(13).equalsIgnoreCase("6")) ? 0 : 1);

            try {
                ResultSet rs_a = go_dao_entidad.SLT_datos_entidad_x_facturacion(rs.getString(9), rs.getString(13));
                go_cbx_trato_datos.recupera_valor(16, rs_a, OBJ_pnf.CBX_direccion);
                go_cbx_trato_datos.selecciona_valor(16, rs_a.getString(14), OBJ_pnf.CBX_direccion);
            } catch (Exception e) {
            }
            OBJ_pnf.TXT_codigo_ubigeo.setText(rs.getString(15));
            OBJ_pnf.TXT_descripcion.setText(rs.getString(16));
            OBJ_pnf.TXT_codigo_pagador.setText(rs.getString(17));
            OBJ_pnf.TXT_pagador.setText(rs.getString(18));
            OBJ_pnf.TXT_codigo_vendedor.setText(rs.getString(19));
            OBJ_pnf.TXT_nombre_vendedor.setText(rs.getString(20));
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

    public boolean valida_monto(String total, int op) {
        boolean resp = false;
        switch (op) {
            case 0:
                if (!total.equalsIgnoreCase("")) {
                    if (Double.parseDouble(total.replaceAll(",", "")) > 0.0) {
                        resp = true;
                    }
                }
                break;
            case 1:
                resp = true;
                break;
        }
        return resp;
    }

    public boolean valida_campos(pnl_cab_nota_credito OBJ_pcp, cbx_moneda cbx_moneda) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_numero_doc)) {
            OBJ_pcp.TXT_numero_doc.setText(go_fnc_operaciones_campos.completa_digitos(OBJ_pcp.TXT_numero_doc.getText().trim(), "0", 10));
            OBJ_pcp.LBL_numero_doc.setText(OBJ_pcp.TXT_numero_doc.getText());
            if (go_fnc_operaciones_campos.valida_fecha(OBJ_pcp.TXT_fecha_emision.getText())) {
                if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_tipo_cambio)) {
                    if (valida_moneda(Double.parseDouble(OBJ_pcp.TXT_tipo_cambio.getText()), cbx_moneda.getID())) {
                        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_entidad)) {
                            if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_razon_social)) {
                                if (!OBJ_pcp.CBX_direccion.getSelectedItem().toString().trim().equalsIgnoreCase("")) {
                                    if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_ubigeo)) {
                                        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_pagador)) {
                                            if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_vendedor)) {
                                                if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_serie_ref) || go_fnc_operaciones_campos.cant_caracter(OBJ_pcp.TXT_numero_ref.getText(), 4, 10)) {
                                                    if (valida_monto(OBJ_pcp.TXT_total.getText().trim(), OBJ_pcp.CBX_registra_item.getSelectedIndex())) {
                                                        resp = true;
                                                    } else {
                                                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE TOTAL DOCUMENTO");
                                                        OBJ_pcp.TXT_total.requestFocus();
                                                    }
                                                } else {
                                                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE DOCUMENTO REFERENCIA");
                                                    OBJ_pcp.TXT_serie_ref.requestFocus();
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
                                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "RAZON SOCIAL");
                                OBJ_pcp.TXT_razon_social.requestFocus();
                            }
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE ENTIDAD");
                            OBJ_pcp.TXT_codigo_entidad.requestFocus();
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE TIPO DE CAMBIO");
                        OBJ_pcp.TXT_tipo_cambio.setText("");
                        OBJ_pcp.TXT_tipo_cambio.requestFocus();
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

    public void setea_campos(BEAN_registro_ventas OBJ_bpe, pnl_cab_nota_credito OBJ_pcp, cbx_grupo_detraccion cbx_grupo_detraccion, cbx_moneda cbx_moneda, cbx_igv cbx_igv, cbx_tabla_ayuda cbx_tabla_ayuda, pnl_grid_pedidos OBJ_pgp, double monto_min) {
        try {
            double tipo_cambio = (cbx_moneda.getID().equalsIgnoreCase("PEN")) ? 1 : Double.parseDouble(OBJ_pcp.TXT_tipo_cambio.getText());
            OBJ_bpe.setPeriodo(gs_periodo);
            OBJ_bpe.setMes(OBJ_pcp.TXT_fecha_emision.getText().trim().substring(3, 5));
            OBJ_bpe.setCodigo_documento(OBJ_bpe.getCodigo_operacion().substring(0, 2));
            OBJ_bpe.setSerie_documento(OBJ_pcp.TXT_serie.getText().trim());
            OBJ_bpe.setNumero_documento(OBJ_pcp.TXT_numero_doc.getText().trim());
            OBJ_bpe.setFecha_emision(go_fnc_operaciones_campos.get_campo_str(OBJ_pcp.TXT_fecha_emision));
            OBJ_bpe.setFecha_vencimiento(go_fnc_operaciones_campos.get_campo_str(OBJ_pcp.TXT_fecha_emision));
            OBJ_bpe.setCodigo_moneda(cbx_moneda.getID());
            OBJ_bpe.setEs_pedido("0");
            OBJ_bpe.setEs_guiar("0");
            OBJ_bpe.setTipo_cambio(Double.parseDouble(OBJ_pcp.TXT_tipo_cambio.getText()));
            OBJ_bpe.setAfecto_igv(OBJ_pcp.CBX_afecto_igv.getSelectedIndex() + "");
            OBJ_bpe.setCodigo_igv(cbx_igv.getID());
            OBJ_bpe.setCodigo_grupo(cbx_grupo_detraccion.getID());
            OBJ_bpe.setPorcentaje_detraccion(Double.parseDouble(OBJ_pcp.TXT_detraccion.getText()));
            OBJ_bpe.setStatus(OBJ_pcp.CBX_status.getSelectedIndex() + "");
            OBJ_bpe.setEs_facturado("1");
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
            OBJ_bpe.setForma_pago("EF");
            OBJ_bpe.setDias_credito(0);
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
            OBJ_bpe.setInafecto_mn(OBJ_bpe.getInafecto() * tipo_cambio);
            OBJ_bpe.setBase_mn(OBJ_bpe.getBase() * tipo_cambio);
            OBJ_bpe.setIgv_mn(OBJ_bpe.getIgv() * tipo_cambio);
            OBJ_bpe.setTotal_mn(OBJ_bpe.getTotal() * tipo_cambio);
            OBJ_bpe.setPercepcion_mn(OBJ_bpe.getPercepcion() * tipo_cambio);
            OBJ_bpe.setTotal_documento_mn(OBJ_bpe.getTotal_documento() * tipo_cambio);
            OBJ_bpe.setExonerado_mn(OBJ_bpe.getExonerado() * tipo_cambio);
            OBJ_bpe.setImporte_detraccion_mn(OBJ_bpe.getImporte_detraccion() * tipo_cambio);
            OBJ_bpe.setCodigo_pedido("OP00000000000000");
            OBJ_bpe.setCodigo_guiar("GR00000000000000");
            OBJ_bpe.setSerie_doc_ref(OBJ_pcp.TXT_serie_ref.getText().trim());
            OBJ_bpe.setNumero_doc_ref(OBJ_pcp.TXT_numero_ref.getText().trim());
            OBJ_bpe.setRegistra_item(OBJ_pcp.CBX_registra_item.getSelectedIndex() + "");
            OBJ_bpe.setConcepto_doc_ref(cbx_tabla_ayuda.getID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setea_recupera(BEAN_registro_ventas OBJ_bpe, ResultSet lq_rs) {
        try {
            OBJ_bpe.setCodigo_operacion(lq_rs.getString(1));
            OBJ_bpe.setCodigo_sucursal(lq_rs.getString(2));
            OBJ_bpe.setPeriodo(lq_rs.getString(3));
            OBJ_bpe.setMes(lq_rs.getString(4));
            OBJ_bpe.setCodigo_documento(lq_rs.getString(5));
            OBJ_bpe.setSerie_documento(lq_rs.getString(6));
            OBJ_bpe.setNumero_documento(lq_rs.getString(7));
            OBJ_bpe.setFecha_emision(go_fnc_operaciones_campos.recupera_fecha_formato((lq_rs.getString(8))));
            OBJ_bpe.setFecha_vencimiento(go_fnc_operaciones_campos.recupera_fecha_formato((lq_rs.getString(9))));
            OBJ_bpe.setFecha_registro(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(10).substring(0, 10)) + " " + lq_rs.getString(10).substring(11));
            OBJ_bpe.setCodigo_moneda(lq_rs.getString(11));
            OBJ_bpe.setTipo_cambio(lq_rs.getDouble(12));
            OBJ_bpe.setAfecto_igv(lq_rs.getString(13));
            OBJ_bpe.setCodigo_igv(lq_rs.getString(14));
            OBJ_bpe.setCodigo_grupo(lq_rs.getString(15));
            OBJ_bpe.setPorcentaje_detraccion(lq_rs.getDouble(16));
            OBJ_bpe.setStatus(lq_rs.getString(17));
            OBJ_bpe.setEs_facturado(lq_rs.getString(18));
            OBJ_bpe.setEs_precio_igv(lq_rs.getString(19));
            OBJ_bpe.setCodigo_entidad(lq_rs.getString(20));
            OBJ_bpe.setRazon_social(lq_rs.getString(21));
            OBJ_bpe.setTipo_documento_id(lq_rs.getString(22));
            OBJ_bpe.setNumero_documento_id(lq_rs.getString(23));
            OBJ_bpe.setDireccion(lq_rs.getString(24));
            OBJ_bpe.setCodigo_ubigeo(lq_rs.getString(25));
            OBJ_bpe.setDescripcion_ubigeo(lq_rs.getString(26));
            OBJ_bpe.setCodigo_pagador(lq_rs.getString(27));
            OBJ_bpe.setNombre_pagador(lq_rs.getString(28));
            OBJ_bpe.setCodigo_vendedor(lq_rs.getString(29));
            OBJ_bpe.setNombre_vendedor(lq_rs.getString(30));
            OBJ_bpe.setForma_pago(lq_rs.getString(31));
            OBJ_bpe.setDias_credito(lq_rs.getInt(32));
            OBJ_bpe.setObservacion(lq_rs.getString(33));
            OBJ_bpe.setEs_domiciliado(lq_rs.getString(34));
            OBJ_bpe.setInafecto(lq_rs.getDouble(35));
            OBJ_bpe.setBase(lq_rs.getDouble(36));
            OBJ_bpe.setIgv(lq_rs.getDouble(37));
            OBJ_bpe.setTotal(lq_rs.getDouble(38));
            OBJ_bpe.setPercepcion(lq_rs.getDouble(39));
            OBJ_bpe.setTotal_documento(lq_rs.getDouble(40));
            OBJ_bpe.setExonerado(lq_rs.getDouble(41));
            OBJ_bpe.setImporte_detraccion(lq_rs.getDouble(42));
            OBJ_bpe.setInafecto_mn(lq_rs.getDouble(43));
            OBJ_bpe.setBase_mn(lq_rs.getDouble(44));
            OBJ_bpe.setIgv_mn(lq_rs.getDouble(45));
            OBJ_bpe.setTotal_mn(lq_rs.getDouble(46));
            OBJ_bpe.setPercepcion_mn(lq_rs.getDouble(47));
            OBJ_bpe.setTotal_documento_mn(lq_rs.getDouble(48));
            OBJ_bpe.setExonerado_mn(lq_rs.getDouble(49));
            OBJ_bpe.setImporte_detraccion_mn(lq_rs.getDouble(50));
            OBJ_bpe.setEs_guiar(lq_rs.getString(51));
            OBJ_bpe.setCodigo_guiar(lq_rs.getString(52));
            OBJ_bpe.setEs_pedido(lq_rs.getString(53));
            OBJ_bpe.setCodigo_pedido(lq_rs.getString(54));
            OBJ_bpe.setFecha_doc_ref(lq_rs.getString(55));
            OBJ_bpe.setCodigo_tipo_doc_ref(lq_rs.getString(56));
            OBJ_bpe.setSerie_doc_ref(lq_rs.getString(57));
            OBJ_bpe.setNumero_doc_ref(lq_rs.getString(58));
            OBJ_bpe.setRegistra_item(lq_rs.getString(59));
            OBJ_bpe.setConcepto_doc_ref(lq_rs.getString(60));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void muestra_datos(pnl_cab_nota_credito OBJ_pdp, BEAN_registro_ventas OBJ_bpe, pnl_grid_pedidos OBJ_pgp) {
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        dFormat = new DecimalFormat("#,##0.00", simbolos);
        OBJ_pdp.TXT_numero_doc.setText(OBJ_bpe.getNumero_documento());
        OBJ_pdp.LBL_numero_doc.setText(OBJ_bpe.getNumero_documento());
        OBJ_pdp.TXT_fecha_emision.setText(OBJ_bpe.getFecha_emision());
        OBJ_pdp.LBL_fecha_registro.setText(OBJ_bpe.getFecha_registro());
        go_cbx_trato_datos.selecciona_valor(0, OBJ_bpe.getCodigo_moneda(), OBJ_pdp.CBX_moneda);
        go_cbx_trato_datos.selecciona_valor(19, OBJ_bpe.getConcepto_doc_ref(), OBJ_pdp.CBX_concepto);
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
            rs = go_dao_entidad.SLT_datos_entidad_x_facturacion(OBJ_bpe.getCodigo_entidad(), OBJ_bpe.getTipo_documento_id());
            go_cbx_trato_datos.recupera_valor(16, rs, OBJ_pdp.CBX_direccion);
            go_cbx_trato_datos.selecciona_valor(16, OBJ_bpe.getDireccion(), OBJ_pdp.CBX_direccion);
        } catch (Exception e) {
        }
        OBJ_pdp.TXT_codigo_ubigeo.setText(OBJ_bpe.getCodigo_ubigeo());
        OBJ_pdp.TXT_descripcion.setText(OBJ_bpe.getDescripcion_ubigeo());
        OBJ_pdp.TXT_codigo_pagador.setText(OBJ_bpe.getCodigo_pagador());
        OBJ_pdp.TXT_pagador.setText(OBJ_bpe.getNombre_pagador());
        OBJ_pdp.TXT_codigo_vendedor.setText(OBJ_bpe.getCodigo_vendedor());
        OBJ_pdp.TXT_nombre_vendedor.setText(OBJ_bpe.getNombre_vendedor());
        OBJ_pdp.TXT_observacion.setText(OBJ_bpe.getObservacion());
        OBJ_pdp.TXT_serie_ref.setText(OBJ_bpe.getSerie_doc_ref());
        OBJ_pdp.TXT_numero_ref.setText(OBJ_bpe.getNumero_doc_ref());
        OBJ_pdp.CBX_registra_item.setSelectedIndex(Integer.parseInt(OBJ_bpe.getRegistra_item()));

        OBJ_pgp.LBL_inafecto.setText(dFormat.format(OBJ_bpe.getInafecto()) + "");
        OBJ_pgp.LBL_afecto.setText(dFormat.format(OBJ_bpe.getBase()) + "");
        OBJ_pgp.LBL_igv.setText(dFormat.format(OBJ_bpe.getIgv()) + "");
        OBJ_pgp.LBL_total.setText(dFormat.format(OBJ_bpe.getTotal()) + "");
        OBJ_pgp.LBL_percepcion.setText(dFormat.format(OBJ_bpe.getPercepcion()) + "");
        OBJ_pgp.LBL_importe.setText(dFormat.format(OBJ_bpe.getTotal_documento()) + "");

        if (OBJ_bpe.getRegistra_item().equalsIgnoreCase("0")) {
            OBJ_pdp.TXT_total.setText(OBJ_bpe.getTotal_documento() + "");
        }
    }

    public KeyListener evento_press(pnl_cab_nota_credito OBJ_pcf, KeyListener KeyEvnt) {
        OBJ_pcf.TXT_numero_doc.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_fecha_emision.addKeyListener(KeyEvnt);
        OBJ_pcf.CBX_moneda.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_tipo_cambio.addKeyListener(KeyEvnt);
        OBJ_pcf.CBX_codigo_detraccion.addKeyListener(KeyEvnt);
        OBJ_pcf.JRD_precio_igv.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_codigo_entidad.addKeyListener(KeyEvnt);
        OBJ_pcf.CBX_direccion.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_codigo_vendedor.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_observacion.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_numero_ref.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_codigo_pagador.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_razon_social.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_doc_id.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_codigo_ubigeo.addKeyListener(KeyEvnt);
        OBJ_pcf.CBX_concepto.addKeyListener(KeyEvnt);
        OBJ_pcf.CBX_registra_item.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_total.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_cab_nota_credito OBJ_pcf, ItemListener ItemEvent) {
        OBJ_pcf.CBX_moneda.addItemListener(ItemEvent);
        OBJ_pcf.CBX_direccion.addItemListener(ItemEvent);
        OBJ_pcf.JRD_precio_igv.addItemListener(ItemEvent);
        OBJ_pcf.CBX_registra_item.addItemListener(ItemEvent);
        OBJ_pcf.CBX_concepto.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
