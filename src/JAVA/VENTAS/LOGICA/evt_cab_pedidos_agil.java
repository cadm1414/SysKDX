package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.pnl_cab_pedidos_agil;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class evt_cab_pedidos_agil {

    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    DecimalFormat dFormat;
    ResultSet rs;
    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "evt_cab_pedidos";

    public void activa_campos(int op, pnl_cab_pedidos_agil OBJ_pcp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pcp.TXT_numero_doc.setEnabled(valor);
                OBJ_pcp.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcp.CBX_doc_ref.setEnabled(valor);
                OBJ_pcp.TXT_codigo_articulo.setEnabled(valor);
                OBJ_pcp.TXT_cantidad.setEnabled(valor);
                OBJ_pcp.TXT_codigo_entidad.setEnabled(valor);
                OBJ_pcp.CBX_direccion.setEnabled(valor);
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                OBJ_pcp.TXT_razon_social.setEnabled(valor);
                OBJ_pcp.TXT_doc_id.setEnabled(valor);
                OBJ_pcp.TXT_codigo_ubigeo.setEnabled(valor);
                OBJ_pcp.TXT_precio.setEnabled(valor);
                OBJ_pcp.CBX_sector.setEnabled(valor);
                OBJ_pcp.CBX_presentacion.setEnabled(valor);
                OBJ_pcp.BTN_agregar.setEnabled(valor);
                OBJ_pcp.TXT_numero_doc.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_cab_pedidos_agil OBJ_pcp) {
        OBJ_pcp.LBL_numero_doc.setText("0000000000");
        OBJ_pcp.TXT_numero_doc.setText("");
        OBJ_pcp.TXT_fecha_emision.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcp.CBX_doc_ref.setSelectedIndex(1);
        OBJ_pcp.CBX_presentacion.setSelectedIndex(0);
        OBJ_pcp.TXT_codigo_articulo.setText("");
        OBJ_pcp.TXT_nombre.setText("");
        OBJ_pcp.TXT_codigo_entidad.setText("");
        OBJ_pcp.TXT_razon_social.setText("");
        //OBJ_pcp.CBX_tipo_documento_id.setSelectedIndex(0);
        OBJ_pcp.TXT_doc_id.setText("");
        OBJ_pcp.CBX_direccion.removeAllItems();
        OBJ_pcp.TXT_codigo_ubigeo.setText("");
        OBJ_pcp.TXT_descripcion.setText("");
        OBJ_pcp.TXT_cantidad.setText("");
        OBJ_pcp.TXT_precio.setText("");
        OBJ_pcp.TXT_observacion.setText("");
        go_cbx_trato_datos.selecciona_valor(20, "999999", OBJ_pcp.CBX_sector);
        OBJ_pcp.JRD_domiciliado.setSelected(true);
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

    public ActionListener evento_click(pnl_cab_pedidos_agil OBJ_pcp, ActionListener Listener) {
        OBJ_pcp.BTN_agregar.addActionListener(Listener);
        return Listener;
    }

    public KeyListener evento_press(pnl_cab_pedidos_agil OBJ_pcp, KeyListener KeyEvnt) {
        OBJ_pcp.TXT_numero_doc.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_fecha_emision.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_doc_ref.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_presentacion.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_codigo_articulo.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_precio.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_cantidad.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_codigo_entidad.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_direccion.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_observacion.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_razon_social.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_doc_id.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_codigo_ubigeo.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_sector.addKeyListener(KeyEvnt);
        OBJ_pcp.BTN_agregar.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_cab_pedidos_agil OBJ_pcp, ItemListener ItemEvent) {
        OBJ_pcp.CBX_doc_ref.addItemListener(ItemEvent);
        OBJ_pcp.CBX_direccion.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
