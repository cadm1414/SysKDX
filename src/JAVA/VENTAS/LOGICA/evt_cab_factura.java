package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.BEAN.BEAN_registro_ventas;
import JAVA.VENTAS.GUI.pnl_cab_factura;
import JAVA.VENTAS.GUI.pnl_grid_pedidos;
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
       
    public void muestra_datos(pnl_cab_factura OBJ_pdp, BEAN_registro_ventas OBJ_bpe, pnl_grid_pedidos OBJ_pgp) {
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        dFormat = new DecimalFormat("#,##0.00", simbolos);
        OBJ_pdp.TXT_numero_doc.setText(OBJ_bpe.getNumero_documento());
        OBJ_pdp.TXT_fecha_emision.setText(OBJ_bpe.getFecha_emision());
        OBJ_pdp.LBL_fecha_vence.setText(OBJ_bpe.getFecha_vencimiento());
        OBJ_pdp.LBL_fecha_registro.setText(OBJ_bpe.getFecha_registro());
        OBJ_pdp.TXT_guiar.setText(OBJ_bpe.getCodigo_guiar().substring(6));
        OBJ_pdp.TXT_pedido.setText(OBJ_bpe.getCodigo_pedido().substring(6));
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
        OBJ_pdp.CBX_tipo_documento_id.setSelectedItem((OBJ_bpe.getTipo_documento_id().equalsIgnoreCase("6")) ? 0 : 1);
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
        OBJ_pdp.CBX_forma_pago.setSelectedIndex((OBJ_bpe.getForma_pago().equalsIgnoreCase("EF")) ? 0 : 1);
        OBJ_pdp.TXT_dias_credito.setText(OBJ_bpe.getDias_credito() + "");
        OBJ_pdp.TXT_observacion.setText(OBJ_bpe.getObservacion());
        OBJ_pgp.LBL_inafecto.setText(dFormat.format(OBJ_bpe.getInafecto()) + "");
        OBJ_pgp.LBL_afecto.setText(dFormat.format(OBJ_bpe.getBase()) + "");
        OBJ_pgp.LBL_igv.setText(dFormat.format(OBJ_bpe.getIgv()) + "");
        OBJ_pgp.LBL_total.setText(dFormat.format(OBJ_bpe.getTotal()) + "");
        OBJ_pgp.LBL_percepcion.setText(dFormat.format(OBJ_bpe.getPercepcion()) + "");
        OBJ_pgp.LBL_importe.setText(dFormat.format(OBJ_bpe.getTotal_documento()) + "");
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
