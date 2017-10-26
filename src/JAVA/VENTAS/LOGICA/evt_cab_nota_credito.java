package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.pnl_cab_nota_credito;
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
        OBJ_pcf.CBX_tipo_documento_id.setSelectedIndex((tipo_documento.equalsIgnoreCase("01")) ? 0 : 1);
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
