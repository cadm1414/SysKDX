package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.pnl_cab_pedidos;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;

public class evt_cab_pedidos {

    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "evt_cab_pedidos";

    public void activa_campos(int op, pnl_cab_pedidos OBJ_pcp, boolean valor) {
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
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                OBJ_pcp.TXT_numero_doc.requestFocus();               
                break;
        }
    }

    public void limpia_datos(pnl_cab_pedidos OBJ_pcp) {
        OBJ_pcp.LBL_numero_doc.setText("0000000000");
        OBJ_pcp.TXT_numero_doc.setText("");
        OBJ_pcp.TXT_fecha_emision.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcp.CBX_doc_ref.setSelectedIndex(0);
        OBJ_pcp.CBX_moneda.setSelectedIndex(0);
        OBJ_pcp.TXT_tipo_cambio.setText("0.000");
        OBJ_pcp.CBX_afecto_igv.setSelectedIndex(1);
        OBJ_pcp.CBX_codigo_detraccion.setSelectedIndex(0);
        OBJ_pcp.TXT_detraccion.setText("0.000");
        OBJ_pcp.TXT_codigo_entidad.setText("");
        OBJ_pcp.TXT_razon_social.setText("");
        OBJ_pcp.CBX_tipo_documento_id.setSelectedIndex(0);
        OBJ_pcp.TXT_numero_doc.setText("");
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
    }

    public KeyListener evento_press(pnl_cab_pedidos OBJ_pcp, KeyListener KeyEvnt) {
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
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_cab_pedidos OBJ_pcp, ItemListener ItemEvent) {
        OBJ_pcp.CBX_moneda.addItemListener(ItemEvent);
        OBJ_pcp.CBX_doc_ref.addItemListener(ItemEvent);
        OBJ_pcp.CBX_codigo_detraccion.addItemListener(ItemEvent);
        OBJ_pcp.CBX_direccion.addItemListener(ItemEvent);
        OBJ_pcp.JRD_precio_igv.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
