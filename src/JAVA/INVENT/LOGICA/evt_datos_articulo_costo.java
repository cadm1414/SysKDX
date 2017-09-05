package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.INVENT.BEAN.BEAN_articulo_costo;
import JAVA.INVENT.GUI.pnl_datos_articulo_costo;
import JAVA.VENTAS.LOGICA.cbx_igv;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_articulo_costo {

    String ls_modulo = "INVENT", ls_capa = "LOGICA", ls_clase = "evt_datos_articulo_costo";

    public void activa_campos(int op, pnl_datos_articulo_costo OBJ_pda, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pda.TXT_codigo_articulo.setEnabled(valor);
                OBJ_pda.CBX_procedencia.setEnabled(valor);
                OBJ_pda.CBX_tipo_procedencia.setEnabled(valor);
                OBJ_pda.TXT_numero.setEnabled(valor);
                OBJ_pda.TXT_periodo.setEnabled(valor);
                OBJ_pda.TXT_costo.setEnabled(valor);
                OBJ_pda.CBX_mes.setEnabled(valor);
                OBJ_pda.TXT_anio.setEnabled(valor);
                OBJ_pda.TXT_codigo_entidad.setEnabled(valor);
                OBJ_pda.TXT_fecha_ingreso.setEnabled(valor);
                OBJ_pda.TXT_fecha_produccion.setEnabled(valor);
                OBJ_pda.TXT_fecha_vencimiento.setEnabled(valor);
                OBJ_pda.CBX_moneda.setEnabled(valor);
                OBJ_pda.JRD_es_igv.setEnabled(valor);
                OBJ_pda.TXT_codigo_articulo.requestFocus();
                break;
            case 1:
                OBJ_pda.TXT_costo.setEnabled(valor);
                OBJ_pda.CBX_mes.setEnabled(valor);
                OBJ_pda.TXT_anio.setEnabled(valor);
                OBJ_pda.TXT_codigo_entidad.setEnabled(valor);
                OBJ_pda.TXT_fecha_ingreso.setEnabled(valor);
                OBJ_pda.TXT_fecha_produccion.setEnabled(valor);
                OBJ_pda.TXT_fecha_vencimiento.setEnabled(valor);
                OBJ_pda.CBX_moneda.setEnabled(valor);
                OBJ_pda.JRD_es_igv.setEnabled(valor);
                OBJ_pda.TXT_costo.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_articulo_costo OBJ_pda) {
        OBJ_pda.TXT_codigo_articulo.setText("");
        OBJ_pda.TXT_nombre.setText("");
        OBJ_pda.CBX_procedencia.setSelectedIndex(0);
        OBJ_pda.CBX_moneda.setSelectedIndex(0);
        OBJ_pda.TXT_tipo_cambio.setText("0.000");
        OBJ_pda.JRD_es_igv.setSelected(false);
        OBJ_pda.CBX_tipo_procedencia.removeAllItems();
        OBJ_pda.CBX_tipo_procedencia.addItem("NACIONAL");
        OBJ_pda.CBX_tipo_procedencia.addItem("IMPORTADA");

        OBJ_pda.CBX_tipo_procedencia.setSelectedIndex(0);
        OBJ_pda.TXT_numero.setText("");
        OBJ_pda.TXT_periodo.setText(gs_periodo);
        OBJ_pda.TXT_costo.setText("");
        OBJ_pda.CBX_mes.setSelectedIndex(0);
        OBJ_pda.TXT_anio.setText(gs_periodo);
        OBJ_pda.TXT_codigo_entidad.setText("999999");
        OBJ_pda.TXT_nombre_entidad.setText("....");
        OBJ_pda.TXT_fecha_ingreso.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pda.TXT_fecha_produccion.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pda.TXT_fecha_vencimiento.setText(gs_dia + gs_mes + gs_periodo);

    }

    public void muestra_datos(pnl_datos_articulo_costo OBJ_pda, BEAN_articulo_costo OBJ_bar) {
        OBJ_pda.TXT_codigo_articulo.setText(OBJ_bar.getCodigo_articulo());
        OBJ_pda.TXT_nombre.setText(OBJ_bar.getNombre_articulo());
        OBJ_pda.CBX_procedencia.setSelectedIndex(Integer.parseInt(OBJ_bar.getCodigo_procedencia()));

        OBJ_pda.CBX_tipo_procedencia.removeAllItems();
        switch (OBJ_pda.CBX_procedencia.getSelectedIndex()) {
            case 0:
                OBJ_pda.CBX_tipo_procedencia.addItem("NACIONAL");
                OBJ_pda.CBX_tipo_procedencia.addItem("IMPORTADA");
                break;
            case 1:
                OBJ_pda.CBX_tipo_procedencia.addItem("MEZCLA");
                break;
            case 2:
                OBJ_pda.CBX_tipo_procedencia.addItem("OTROS");
                break;
        }

        OBJ_pda.CBX_tipo_procedencia.setSelectedIndex(Integer.parseInt(OBJ_bar.getTipo_procedencia()));
        OBJ_pda.TXT_numero.setText(OBJ_bar.getNumero());
        OBJ_pda.TXT_periodo.setText(OBJ_bar.getPeriodo());
        OBJ_pda.TXT_costo.setText(OBJ_bar.getCosto() + "");
        OBJ_pda.CBX_mes.setSelectedIndex(Integer.parseInt(OBJ_bar.getPeriodo_produccion().substring(0, 2)));
        OBJ_pda.TXT_anio.setText(OBJ_bar.getPeriodo_produccion().substring(3, 7));
        OBJ_pda.TXT_codigo_entidad.setText(OBJ_bar.getCodigo_entidad());
        OBJ_pda.TXT_nombre_entidad.setText("....");
        OBJ_pda.TXT_fecha_ingreso.setText(OBJ_bar.getFecha_ingreso());
        OBJ_pda.TXT_fecha_produccion.setText(OBJ_bar.getFecha_produccion());
        OBJ_pda.TXT_fecha_vencimiento.setText(OBJ_bar.getFecha_vencimiento());
        go_cbx_trato_datos.selecciona_valor(0, OBJ_bar.getCodigo_moneda(), OBJ_pda.CBX_moneda);
        OBJ_pda.TXT_tipo_cambio.setText(OBJ_bar.getTipo_cambio() + "");
        go_cbx_trato_datos.selecciona_valor(15, OBJ_bar.getCodigo_igv(), OBJ_pda.CBX_igv);
        OBJ_pda.JRD_es_igv.setSelected(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bar.getEs_igv())));
    }

    public void setea_recupera(BEAN_articulo_costo OBJ_bar, ResultSet lq_rs) {
        try {
            OBJ_bar.setCodigo_orden(lq_rs.getString(1));
            OBJ_bar.setItem_orden(lq_rs.getString(2));
            OBJ_bar.setCodigo_articulo(lq_rs.getString(3));
            OBJ_bar.setNombre_articulo(lq_rs.getString(4));
            OBJ_bar.setCodigo_procedencia(lq_rs.getString(5));
            OBJ_bar.setTipo_procedencia(lq_rs.getString(6));
            OBJ_bar.setNumero(lq_rs.getString(7));
            OBJ_bar.setPeriodo(lq_rs.getString(8));
            OBJ_bar.setCosto(lq_rs.getDouble(9));
            OBJ_bar.setPeriodo_produccion(lq_rs.getString(10));
            OBJ_bar.setCodigo_entidad(lq_rs.getString(11));
            OBJ_bar.setFecha_ingreso(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(12)));
            OBJ_bar.setFecha_produccion(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(13)));
            OBJ_bar.setFecha_vencimiento(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(14)));
            OBJ_bar.setCodigo_moneda(lq_rs.getString(15));
            OBJ_bar.setTipo_cambio(lq_rs.getDouble(16));
            OBJ_bar.setCodigo_igv(lq_rs.getString(17));
            OBJ_bar.setEs_igv(lq_rs.getString(18));
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

    public boolean valida_campos(pnl_datos_articulo_costo OBJ_pda, cbx_moneda cbx_moneda) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.cant_caracter(OBJ_pda.TXT_codigo_articulo.getText().trim(), 1, 12) || go_fnc_operaciones_campos.cant_caracter(OBJ_pda.TXT_nombre.getText().trim(), 1, 3)) {
            if (go_fnc_operaciones_campos.cant_caracter(OBJ_pda.TXT_numero.getText().trim(), 1, 1)) {
                OBJ_pda.TXT_numero.setText(go_fnc_operaciones_campos.completa_digitos(OBJ_pda.TXT_numero.getText().trim(), "0", 4));
                if (go_fnc_operaciones_campos.cant_caracter(OBJ_pda.TXT_periodo.getText().trim(), 1, 4)) {
                    if (!go_fnc_operaciones_campos.campo_blanco(OBJ_pda.TXT_costo)) {
                        OBJ_pda.TXT_costo.setText("0.00000");
                    }
                    if (valida_moneda(Double.parseDouble(OBJ_pda.TXT_tipo_cambio.getText()), cbx_moneda.getID())) {
                        if (go_fnc_operaciones_campos.cant_caracter(OBJ_pda.TXT_codigo_entidad.getText().trim(), 1, 6)) {
                            if (go_fnc_operaciones_campos.valida_fecha(OBJ_pda.TXT_fecha_ingreso.getText())) {
                                if (go_fnc_operaciones_campos.valida_fecha(OBJ_pda.TXT_fecha_produccion.getText())) {
                                    if (go_fnc_operaciones_campos.valida_fecha(OBJ_pda.TXT_fecha_vencimiento.getText())) {
                                        if (OBJ_pda.CBX_procedencia.getSelectedIndex() == 1 && OBJ_pda.CBX_mes.getSelectedIndex() != 0) {
                                            resp = true;
                                        } else if (OBJ_pda.CBX_procedencia.getSelectedIndex() == 1) {
                                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE MES");
                                            OBJ_pda.CBX_mes.requestFocus();
                                        } else {
                                            resp = true;
                                        }
                                    } else {
                                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FECHA INVALIDA");
                                        OBJ_pda.TXT_fecha_vencimiento.requestFocus();
                                    }
                                } else {
                                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FECHA INVALIDA");
                                    OBJ_pda.TXT_fecha_produccion.requestFocus();
                                }
                            } else {
                                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FECHA INVALIDA");
                                OBJ_pda.TXT_fecha_ingreso.requestFocus();
                            }
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE ENTIDAD");
                            OBJ_pda.TXT_codigo_entidad.requestFocus();
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "TIPO DE CAMBIO NO PUEDE SER CERO");
                        OBJ_pda.TXT_fecha_ingreso.requestFocus();
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE PERIODO");
                    OBJ_pda.TXT_periodo.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NUMERO DE OC");
                OBJ_pda.TXT_numero.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO ARTICULO");
            OBJ_pda.TXT_codigo_articulo.requestFocus();
        }
        return resp;
    }

    public void setea_campos(BEAN_articulo_costo OBJ_bar, pnl_datos_articulo_costo OBJ_pda, cbx_moneda cbx_moneda, cbx_igv cbx_igv) {
        try {
            double costo_sigv = 0.0;
            double tipo_cambio = (cbx_moneda.getID().equalsIgnoreCase("PEN")) ? 1 : Double.parseDouble(OBJ_pda.TXT_tipo_cambio.getText());
            if (OBJ_pda.JRD_es_igv.isSelected()) {
                costo_sigv = Double.parseDouble(OBJ_pda.TXT_costo.getText().trim());
            } else {
                costo_sigv = go_fnc_operaciones_campos.redondea(Double.parseDouble(OBJ_pda.TXT_costo.getText().trim()) / ((Double.parseDouble(OBJ_pda.CBX_igv.getSelectedItem().toString()) / 100) + 1), 5);
            }
            OBJ_bar.setCodigo_articulo(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_codigo_articulo));
            OBJ_bar.setCodigo_procedencia(OBJ_pda.CBX_procedencia.getSelectedIndex() + "");
            OBJ_bar.setTipo_procedencia(OBJ_pda.CBX_tipo_procedencia.getSelectedIndex() + "");
            OBJ_bar.setPeriodo(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_periodo));
            OBJ_bar.setNumero(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_numero));
            OBJ_bar.setCodigo_entidad(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_codigo_entidad));
            OBJ_bar.setNombre_articulo(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_nombre));
            OBJ_bar.setFecha_ingreso(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_fecha_ingreso));
            OBJ_bar.setFecha_produccion(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_fecha_produccion));
            OBJ_bar.setFecha_vencimiento(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_fecha_vencimiento));
            OBJ_bar.setCosto(Double.parseDouble(OBJ_pda.TXT_costo.getText().trim()));
            OBJ_bar.setPeriodo_produccion(go_fnc_operaciones_campos.completa_digitos(OBJ_pda.CBX_mes.getSelectedIndex() + "", "0", 2) + "-" + OBJ_pda.TXT_anio.getText().trim());
            OBJ_bar.setCosto_sigv_mn(go_fnc_operaciones_campos.redondea((cbx_moneda.getID().equalsIgnoreCase("PEN")) ? costo_sigv : go_fnc_operaciones_campos.redondea(costo_sigv * tipo_cambio, 5), 5));
            OBJ_bar.setCodigo_moneda(cbx_moneda.getID());
            OBJ_bar.setTipo_cambio(Double.parseDouble(OBJ_pda.TXT_tipo_cambio.getText()));
            OBJ_bar.setCodigo_igv(cbx_igv.getID());
            OBJ_bar.setEs_igv(go_fnc_operaciones_campos.boolean_int(OBJ_pda.JRD_es_igv.isSelected()) + "");
        } catch (Exception e) {
        }
    }

    public boolean verifica_cambios(BEAN_articulo_costo OBJ_bar, pnl_datos_articulo_costo OBJ_pda) {
        boolean resp = false;
        if (OBJ_bar.getCosto() == Double.parseDouble(OBJ_pda.TXT_costo.getText().trim())) {
            if (OBJ_bar.getPeriodo_produccion().equalsIgnoreCase(go_fnc_operaciones_campos.completa_digitos(OBJ_pda.CBX_mes.getSelectedIndex() + "", "0", 2) + "-" + OBJ_pda.TXT_anio.getText().trim())) {
                if (OBJ_bar.getCodigo_entidad().equalsIgnoreCase(OBJ_pda.TXT_codigo_entidad.getText().trim())) {
                    if (OBJ_bar.getFecha_ingreso().equalsIgnoreCase(OBJ_pda.TXT_fecha_ingreso.getText().trim())) {
                        if (OBJ_bar.getFecha_produccion().equalsIgnoreCase(OBJ_pda.TXT_fecha_produccion.getText().trim())) {
                            if (OBJ_bar.getFecha_vencimiento().equalsIgnoreCase(OBJ_pda.TXT_fecha_vencimiento.getText().trim())) {
                                if (OBJ_bar.getTipo_cambio() == Double.parseDouble(OBJ_pda.TXT_tipo_cambio.getText())) {
                                    if (OBJ_bar.getEs_igv().equalsIgnoreCase(go_fnc_operaciones_campos.boolean_int(OBJ_pda.JRD_es_igv.isSelected())+"")) {

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

    public KeyListener evento_press(pnl_datos_articulo_costo OBJ_pda, KeyListener KeyEvnt) {
        OBJ_pda.TXT_codigo_articulo.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_procedencia.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_tipo_procedencia.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_numero.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_periodo.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_costo.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_mes.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_anio.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_codigo_entidad.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_fecha_ingreso.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_fecha_produccion.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_fecha_vencimiento.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_moneda.addKeyListener(KeyEvnt);
        OBJ_pda.JRD_es_igv.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_datos_articulo_costo obj_pda, ItemListener ItemEvent) {
        obj_pda.CBX_procedencia.addItemListener(ItemEvent);
        obj_pda.CBX_moneda.addItemListener(ItemEvent);
        return ItemEvent;
    }

    public FocusListener evento_focus(pnl_datos_articulo_costo obj_pda, FocusListener FocusEvent) {
        obj_pda.TXT_codigo_articulo.addFocusListener(FocusEvent);
        return FocusEvent;
    }
}
