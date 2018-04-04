package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.LOGICA.cbx_sector_distribucion;
import JAVA.VENTAS.BEAN.BEAN_pedido;
import JAVA.VENTAS.GUI.pnl_cab_pedidos_agil;
import JAVA.VENTAS.GUI.pnl_grid_pedidos_agil;
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

    public boolean valida_campos(pnl_cab_pedidos_agil OBJ_pcp) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_numero_doc)) {
            OBJ_pcp.TXT_numero_doc.setText(go_fnc_operaciones_campos.completa_digitos(OBJ_pcp.TXT_numero_doc.getText().trim(), "0", 10));
            OBJ_pcp.LBL_numero_doc.setText(OBJ_pcp.TXT_numero_doc.getText());
            if (go_fnc_operaciones_campos.valida_fecha(OBJ_pcp.TXT_fecha_emision.getText())) {
                if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_entidad)) {
                    if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_razon_social)) {
                        if (valida_tipo_documento(OBJ_pcp.CBX_tipo_documento_id.getSelectedIndex(), OBJ_pcp.TXT_doc_id.getText().trim())) {
                            if (!OBJ_pcp.CBX_direccion.getSelectedItem().toString().trim().equalsIgnoreCase("")) {
                                if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_ubigeo)) {
                                    resp = true;
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

    public void setea_campos(BEAN_pedido OBJ_bpe, pnl_cab_pedidos_agil OBJ_pcp, cbx_sector_distribucion cbx_sector, pnl_grid_pedidos_agil OBJ_pgp) {
        try {
            OBJ_bpe.setPeriodo(gs_periodo);
            OBJ_bpe.setMes(OBJ_pcp.TXT_fecha_emision.getText().trim().substring(3, 5));
            OBJ_bpe.setCodigo_documento("OP");
            OBJ_bpe.setSerie_documento(OBJ_pcp.TXT_serie.getText().trim());
            OBJ_bpe.setNumero_documento(OBJ_pcp.TXT_numero_doc.getText().trim());
            OBJ_bpe.setFecha_emision(go_fnc_operaciones_campos.get_campo_str(OBJ_pcp.TXT_fecha_emision));
            OBJ_bpe.setCodigo_documento_ref((OBJ_pcp.CBX_doc_ref.getSelectedIndex() == 0) ? "01" : "03");
            OBJ_bpe.setCodigo_moneda("PEN");
            OBJ_bpe.setTipo_cambio(0.00);
            OBJ_bpe.setAfecto_igv("1");
            OBJ_bpe.setCodigo_igv("0001");
            OBJ_bpe.setCodigo_grupo("000");
            OBJ_bpe.setPorcentaje_detraccion(0.00);
            OBJ_bpe.setStatus("1");
            OBJ_bpe.setEs_facturado("0");
            OBJ_bpe.setEs_precio_igv("0");
            OBJ_bpe.setCodigo_entidad(OBJ_pcp.TXT_codigo_entidad.getText().trim());
            OBJ_bpe.setRazon_social(OBJ_pcp.TXT_razon_social.getText().trim());
            OBJ_bpe.setTipo_documento_id((OBJ_pcp.CBX_tipo_documento_id.getSelectedIndex() == 0) ? "6" : "1");
            OBJ_bpe.setNumero_documento_id(OBJ_pcp.TXT_doc_id.getText().trim());
            OBJ_bpe.setDireccion(OBJ_pcp.CBX_direccion.getSelectedItem().toString().toUpperCase());
            OBJ_bpe.setCodigo_ubigeo(OBJ_pcp.TXT_codigo_ubigeo.getText().trim());
            OBJ_bpe.setDescripcion_ubigeo(OBJ_pcp.TXT_descripcion.getText().trim());
            OBJ_bpe.setCodigo_sector(cbx_sector.getID());

            OBJ_bpe.setForma_pago((OBJ_pcp.CBX_forma_pago.getSelectedIndex() == 0) ? "EF" : "CR");
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
            OBJ_bpe.setImporte_detraccion(0.00);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
        OBJ_pcp.CBX_forma_pago.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_cab_pedidos_agil OBJ_pcp, ItemListener ItemEvent) {
        OBJ_pcp.CBX_doc_ref.addItemListener(ItemEvent);
        OBJ_pcp.CBX_direccion.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
