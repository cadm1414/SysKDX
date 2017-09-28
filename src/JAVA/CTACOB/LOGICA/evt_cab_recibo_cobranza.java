package JAVA.CTACOB.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.CTACOB.BEAN.BEAN_recibo_cobranza;
import JAVA.CTACOB.GUI.pnl_cab_recibo_cobranza;
import JAVA.CTACOB.GUI.pnl_grid_recibo_cobranza;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;

public class evt_cab_recibo_cobranza {

    DecimalFormat dFormat;
    ResultSet rs;
    String ls_modulo = "CTACOB", ls_capa = "LOGICA", ls_clase = "evt_cab_recibo_cobranza";

    public void activa_campos(int op, pnl_cab_recibo_cobranza OBJ_pcp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pcp.TXT_numero_doc.setEnabled(valor);
                OBJ_pcp.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcp.CBX_moneda.setEnabled(valor);
                OBJ_pcp.TXT_codigo_pagador.setEnabled(valor);
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                OBJ_pcp.CBX_forma_pago.setEnabled(valor);
                OBJ_pcp.TXT_tipo_cambio.setEnabled(false);
                OBJ_pcp.JRD_rendido.setEnabled(valor);
                OBJ_pcp.TXT_numero_doc.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_cab_recibo_cobranza OBJ_pcp) {
        OBJ_pcp.LBL_numero_doc.setText("0000000000");
        OBJ_pcp.TXT_numero_doc.setText("");
        OBJ_pcp.TXT_fecha_emision.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcp.CBX_moneda.setSelectedIndex(0);
        OBJ_pcp.TXT_codigo_pagador.setText("");
        OBJ_pcp.TXT_nombre_pagador.setText("");
        OBJ_pcp.TXT_tipo_cambio.setText("0.000");
        OBJ_pcp.TXT_codigo_pagador.setText("");
        OBJ_pcp.CBX_forma_pago.setSelectedIndex(0);
        OBJ_pcp.TXT_observacion.setText("");
        OBJ_pcp.CBX_status.setSelectedIndex(1);
        OBJ_pcp.LBL_fecha_registro.setText("");
        OBJ_pcp.CBX_forma_pago.setSelectedIndex(0);
        OBJ_pcp.CBX_banco.setSelectedIndex(0);
        OBJ_pcp.TXT_numero_op.setText("");
        OBJ_pcp.TXT_numero_op.setText("000000000000");
        OBJ_pcp.JRD_rendido.setSelected(true);
        OBJ_pcp.TXT_fecha_op.setText(gs_dia + gs_mes + gs_periodo);
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

    public boolean valida_campos(pnl_cab_recibo_cobranza OBJ_pcp, cbx_moneda cbx_moneda) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_numero_doc)) {
            if (go_fnc_operaciones_campos.valida_fecha(OBJ_pcp.TXT_fecha_emision.getText())) {
                if (valida_moneda(Double.parseDouble(OBJ_pcp.TXT_tipo_cambio.getText()), cbx_moneda.getID())) {
                    if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_pagador) && go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_nombre_pagador)) {
                        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_numero_op)) {
                            if (go_fnc_operaciones_campos.valida_fecha(OBJ_pcp.TXT_fecha_op.getText())) {
                                resp = true;
                            } else {
                                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FECHA DE OPERACION INVALIDA");
                                OBJ_pcp.TXT_fecha_op.setText("");
                                OBJ_pcp.TXT_fecha_op.requestFocus();
                            }
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO DE OPERACION");
                            OBJ_pcp.TXT_numero_op.setText("");
                            OBJ_pcp.TXT_numero_op.requestFocus();
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO CLIENTE");
                        OBJ_pcp.TXT_codigo_pagador.setText("");
                        OBJ_pcp.TXT_codigo_pagador.requestFocus();
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE TIPO DE CAMBIO");
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

    public void setea_campos(BEAN_recibo_cobranza OBJ_bpe, pnl_cab_recibo_cobranza OBJ_pcp, cbx_moneda cbx_moneda, cbx_banco cbx_banco, pnl_grid_recibo_cobranza OBJ_pgp) {
        try {
            OBJ_bpe.setCodigo_documento("RC");
            OBJ_bpe.setSerie_documento(OBJ_bpe.getCodigo_sucursal());
            OBJ_bpe.setNumero_documento(OBJ_pcp.TXT_numero_doc.getText().trim());
            OBJ_bpe.setFecha_emision(OBJ_pcp.TXT_fecha_emision.getText().trim());
            OBJ_bpe.setCodigo_pagador(OBJ_pcp.TXT_codigo_pagador.getText().trim());
            OBJ_bpe.setNombre_pagador(OBJ_pcp.TXT_nombre_pagador.getText().trim());
            OBJ_bpe.setCodigo_moneda(cbx_moneda.getID());
            OBJ_bpe.setTipo_cambio(Double.parseDouble(OBJ_pcp.TXT_tipo_cambio.getText().trim()));
            OBJ_bpe.setForma_pago(OBJ_pcp.CBX_forma_pago.getSelectedIndex() + "");
            OBJ_bpe.setCodigo_banco(cbx_banco.getID());
            OBJ_bpe.setNumero_operacion(OBJ_pcp.TXT_numero_op.getText().trim());
            OBJ_bpe.setFecha_comprobante(OBJ_pcp.TXT_fecha_op.getText().trim());
            OBJ_bpe.setObservacion(OBJ_pcp.TXT_observacion.getText().trim());
            OBJ_bpe.setEs_rendido(go_fnc_operaciones_campos.boolean_int(OBJ_pcp.JRD_rendido.isSelected()) + "");
            OBJ_bpe.setStatus(OBJ_pcp.CBX_status.getSelectedIndex() + "");
            OBJ_bpe.setMonto(Double.parseDouble(OBJ_pgp.LBL_total_pago.getText().replaceAll(",", "")));
            OBJ_bpe.setMonto_mn((cbx_moneda.getID().equalsIgnoreCase("PEN")) ? Double.parseDouble(OBJ_pgp.LBL_total_pago.getText().replaceAll(",", "")) : go_fnc_operaciones_campos.redondea(Double.parseDouble(OBJ_pgp.LBL_total_pago.getText().replaceAll(",", "")) * OBJ_bpe.getTipo_cambio(), 2));
        } catch (Exception e) {
        }
    }

    public KeyListener evento_press(pnl_cab_recibo_cobranza OBJ_pcp, KeyListener KeyEvnt) {
        OBJ_pcp.TXT_numero_doc.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_fecha_emision.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_moneda.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_tipo_cambio.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_codigo_pagador.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_forma_pago.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_banco.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_fecha_op.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_numero_op.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_observacion.addKeyListener(KeyEvnt);
        OBJ_pcp.JRD_rendido.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_cab_recibo_cobranza OBJ_pcp, ItemListener ItemEvent) {
        OBJ_pcp.CBX_moneda.addItemListener(ItemEvent);
        OBJ_pcp.CBX_forma_pago.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
