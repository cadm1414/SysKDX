package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.pnl_cab_factura;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class evt_cab_factura {

    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    DecimalFormat dFormat;
    ResultSet rs;
    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "evt_cab_factura";

    public void activa_campos(int op, pnl_cab_factura OBJ_pcf, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pcf.TXT_numero_doc.setEnabled(valor);
                OBJ_pcf.TXT_guiar.setEnabled(valor);
                OBJ_pcf.TXT_pedido.setEnabled(valor);
                OBJ_pcf.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcf.CBX_moneda.setEnabled(valor);
                OBJ_pcf.CBX_codigo_detraccion.setEnabled(valor);
                OBJ_pcf.JRD_precio_igv.setEnabled(valor);
                OBJ_pcf.TXT_codigo_entidad.setEnabled(valor);
                OBJ_pcf.CBX_direccion.setEnabled(valor);
                OBJ_pcf.TXT_codigo_vendedor.setEnabled(valor);
                OBJ_pcf.TXT_observacion.setEnabled(valor);
                OBJ_pcf.CBX_forma_pago.setEnabled(valor);
                OBJ_pcf.TXT_dias_credito.setEnabled(valor);
                OBJ_pcf.TXT_tipo_cambio.setEnabled(false);
                OBJ_pcf.TXT_numero_doc.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_cab_factura OBJ_pcf) {
        OBJ_pcf.LBL_numero_doc.setText("0000000000");
        OBJ_pcf.TXT_numero_doc.setText("");
        OBJ_pcf.TXT_fecha_emision.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcf.TXT_guiar.setText("0000000000");
        OBJ_pcf.TXT_pedido.setText("0000000000");
        OBJ_pcf.CBX_moneda.setSelectedIndex(0);
        OBJ_pcf.TXT_tipo_cambio.setText("0.000");
        OBJ_pcf.CBX_afecto_igv.setSelectedIndex(1);
        OBJ_pcf.CBX_codigo_detraccion.setSelectedIndex(0);
        OBJ_pcf.TXT_detraccion.setText("0.000");
        OBJ_pcf.TXT_codigo_entidad.setText("");
        OBJ_pcf.TXT_razon_social.setText("");
        OBJ_pcf.CBX_tipo_documento_id.setSelectedIndex(0);
        OBJ_pcf.TXT_numero_doc.setText("");
        OBJ_pcf.CBX_direccion.removeAllItems();
        OBJ_pcf.TXT_codigo_ubigeo.setText("");
        OBJ_pcf.TXT_descripcion.setText("");
        OBJ_pcf.TXT_codigo_pagador.setText("");
        OBJ_pcf.TXT_pagador.setText("");
        OBJ_pcf.TXT_codigo_vendedor.setText("");
        OBJ_pcf.TXT_nombre_vendedor.setText("");
        OBJ_pcf.CBX_forma_pago.setSelectedIndex(0);
        OBJ_pcf.TXT_dias_credito.setText("");
        OBJ_pcf.TXT_observacion.setText("");
        OBJ_pcf.CBX_status.setSelectedIndex(1);
        OBJ_pcf.LBL_fecha_registro.setText("");
        OBJ_pcf.LBL_fecha_vence.setText("__/__/__");
        OBJ_pcf.JRD_domiciliado.setSelected(true);
        OBJ_pcf.JRD_precio_igv.setSelected(false);
    }

    public KeyListener evento_press(pnl_cab_factura OBJ_pcf, KeyListener KeyEvnt) {
        OBJ_pcf.TXT_numero_doc.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_fecha_emision.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_guiar.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_pedido.addKeyListener(KeyEvnt);
        OBJ_pcf.CBX_moneda.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_tipo_cambio.addKeyListener(KeyEvnt);
        OBJ_pcf.CBX_codigo_detraccion.addKeyListener(KeyEvnt);
        OBJ_pcf.JRD_precio_igv.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_codigo_entidad.addKeyListener(KeyEvnt);
        OBJ_pcf.CBX_direccion.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_codigo_vendedor.addKeyListener(KeyEvnt);
        OBJ_pcf.CBX_forma_pago.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_observacion.addKeyListener(KeyEvnt);
        OBJ_pcf.TXT_dias_credito.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_cab_factura OBJ_pcf, ItemListener ItemEvent) {
        OBJ_pcf.CBX_moneda.addItemListener(ItemEvent);
        OBJ_pcf.CBX_codigo_detraccion.addItemListener(ItemEvent);
        OBJ_pcf.CBX_direccion.addItemListener(ItemEvent);
        OBJ_pcf.JRD_precio_igv.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
