package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_tipo_movimiento;
import JAVA.CONFIG.GUI.pnl_datos_tipo_movimiento;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_tipo_movimiento {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_tipo_movimiento";

    public void activa_campos(int op, pnl_datos_tipo_movimiento OBJ_pdt, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pdt.TXT_codigo.setEnabled(valor);
                OBJ_pdt.TXT_nombre.setEnabled(valor);
                OBJ_pdt.CBX_tipo_movimiento.setEnabled(valor);
                OBJ_pdt.CBX_es_transferencia.setEnabled(valor);
                OBJ_pdt.CBX_almacen.setEnabled(valor);
                OBJ_pdt.CBX_tipo_almacen.setEnabled(valor);
                OBJ_pdt.CBX_estado.setEnabled(valor);
                OBJ_pdt.CBX_codigo_sunat.setEnabled(valor);
                OBJ_pdt.TXT_codigo.requestFocus();
                break;
            case 1:
                OBJ_pdt.TXT_codigo.setEnabled(false);
                OBJ_pdt.TXT_nombre.setEnabled(valor);
                OBJ_pdt.CBX_tipo_movimiento.setEnabled(valor);
                OBJ_pdt.CBX_es_transferencia.setEnabled(valor);
                OBJ_pdt.CBX_almacen.setEnabled(valor);
                OBJ_pdt.CBX_tipo_almacen.setEnabled(valor);
                OBJ_pdt.CBX_estado.setEnabled(valor);
                OBJ_pdt.CBX_codigo_sunat.setEnabled(valor);
                OBJ_pdt.TXT_nombre.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_tipo_movimiento OBJ_pdt) {
        OBJ_pdt.TXT_codigo.setText("");
        OBJ_pdt.TXT_nombre.setText("");
        OBJ_pdt.CBX_tipo_movimiento.setSelectedIndex(0);
        OBJ_pdt.CBX_es_transferencia.setSelectedIndex(0);
        OBJ_pdt.CBX_almacen.setSelectedIndex(0);
        OBJ_pdt.CBX_tipo_almacen.setSelectedIndex(0);
        OBJ_pdt.CBX_estado.setSelectedIndex(1);
        OBJ_pdt.CBX_codigo_sunat.setSelectedIndex(0);
    }

    public void muestra_datos(pnl_datos_tipo_movimiento OBJ_pdt, BEAN_tipo_movimiento OBJ_btm) {
        int tipo_almacen = Integer.parseInt(OBJ_btm.getTipo_almacen());
        if (tipo_almacen == 3) {
            tipo_almacen = tipo_almacen - 1;
        }

        OBJ_pdt.TXT_codigo.setText(OBJ_btm.getCodigo_movimiento());
        OBJ_pdt.TXT_nombre.setText(OBJ_btm.getDescripcion());
        OBJ_pdt.CBX_tipo_movimiento.setSelectedIndex(Integer.parseInt(OBJ_btm.getTipo_movimiento()));
        OBJ_pdt.CBX_es_transferencia.setSelectedIndex(Integer.parseInt(OBJ_btm.getEs_transferencia()));
        go_cbx_trato_datos.selecciona_valor(3, OBJ_btm.getCodigo_almacen_ref(), OBJ_pdt.CBX_almacen);
        OBJ_pdt.CBX_tipo_almacen.setSelectedIndex(tipo_almacen);
        OBJ_pdt.CBX_estado.setSelectedIndex(Integer.parseInt(OBJ_btm.getStatus()));
        go_cbx_trato_datos.selecciona_valor(4, OBJ_btm.getCodigo_sunat(), OBJ_pdt.CBX_codigo_sunat);
    }

    public boolean valida_campos(pnl_datos_tipo_movimiento OBJ_dpa) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_dpa.TXT_codigo) && go_fnc_operaciones_campos.campo_blanco(OBJ_dpa.TXT_codigo)) {
            OBJ_dpa.TXT_codigo.setText(go_fnc_operaciones_campos.completa_digitos(go_fnc_operaciones_campos.get_campo_str(OBJ_dpa.TXT_codigo), "0", 2));
            if (go_fnc_operaciones_campos.campo_blanco(OBJ_dpa.TXT_nombre) && go_fnc_operaciones_campos.cant_caracter(OBJ_dpa.TXT_nombre.getText().trim(), 1, 4)) {
                resp = true;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE");
                OBJ_dpa.TXT_nombre.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO");
            OBJ_dpa.TXT_codigo.requestFocus();
        }
        return resp;
    }

    public boolean verifica_cambios(BEAN_tipo_movimiento OBJ_btm, pnl_datos_tipo_movimiento OBJ_dtm, cbx_almacen cbx_almacen, cbx_tabla_sunat cbx_tabla_sunat) {
        boolean resp = false;
        int tipo_almacen = Integer.parseInt(OBJ_btm.getTipo_almacen());
        if (tipo_almacen == 3) {
            tipo_almacen = tipo_almacen - 1;
        }
        if (OBJ_btm.getDescripcion().equalsIgnoreCase(OBJ_dtm.TXT_nombre.getText().trim())) {
            if (OBJ_btm.getTipo_movimiento().equalsIgnoreCase(OBJ_dtm.CBX_tipo_movimiento.getSelectedIndex() + "")) {
                if (OBJ_btm.getEs_transferencia().equalsIgnoreCase(OBJ_dtm.CBX_es_transferencia.getSelectedIndex() + "")) {
                    if (OBJ_btm.getCodigo_almacen_ref().equalsIgnoreCase(cbx_almacen.getID())) {
                        if (tipo_almacen == OBJ_dtm.CBX_tipo_almacen.getSelectedIndex()) {
                            if (OBJ_btm.getStatus().equalsIgnoreCase(OBJ_dtm.CBX_estado.getSelectedIndex() + "")) {
                                if (OBJ_btm.getCodigo_sunat().equalsIgnoreCase(cbx_tabla_sunat.getID())) {
                                } else {
                                    resp = true;
                                    System.out.println("1");
                                }
                            } else {
                                resp = true;
                                System.out.println("2");
                            }
                        } else {
                            resp = true;
                            System.out.println("3");
                        }
                    } else {
                        resp = true;
                        System.out.println("4");
                    }
                } else {
                    resp = true;
                    System.out.println("5");
                }
            } else {
                resp = true;
                System.out.println("6");
            }
        } else {
            resp = true;
            System.out.println("7");
        }
        return resp;
    }

    public void setea_recupera(BEAN_tipo_movimiento OBJ_btm, ResultSet lq_rs) {
        try {
            OBJ_btm.setCodigo_movimiento(lq_rs.getString(1));
            OBJ_btm.setDescripcion(lq_rs.getString(2));
            OBJ_btm.setTipo_movimiento(lq_rs.getString(3));
            OBJ_btm.setEs_transferencia(lq_rs.getString(4));
            OBJ_btm.setCodigo_almacen_ref(lq_rs.getString(5));
            OBJ_btm.setTipo_almacen(lq_rs.getString(6));
            OBJ_btm.setStatus(lq_rs.getString(7));
            OBJ_btm.setCodigo_sunat(lq_rs.getString(8));
        } catch (Exception e) {
        }
    }

    public void setea_campos(BEAN_tipo_movimiento OBJ_btm, pnl_datos_tipo_movimiento OBJ_dtm, cbx_almacen cbx_almacen, cbx_tabla_sunat cbx_tabla_sunat) {
        int tipo_almacen = OBJ_dtm.CBX_tipo_almacen.getSelectedIndex();
        if (tipo_almacen == 2) {
            tipo_almacen = tipo_almacen + 1;
        }

        try {
            OBJ_btm.setCodigo_movimiento(go_fnc_operaciones_campos.get_campo_str(OBJ_dtm.TXT_codigo));
            OBJ_btm.setDescripcion(go_fnc_operaciones_campos.get_campo_str(OBJ_dtm.TXT_nombre));
            OBJ_btm.setTipo_movimiento(OBJ_dtm.CBX_tipo_movimiento.getSelectedIndex() + "");
            OBJ_btm.setEs_transferencia(OBJ_dtm.CBX_es_transferencia.getSelectedIndex() + "");
            OBJ_btm.setCodigo_almacen_ref(cbx_almacen.getID() + "");
            OBJ_btm.setTipo_almacen(tipo_almacen + "");
            OBJ_btm.setStatus(OBJ_dtm.CBX_estado.getSelectedIndex() + "");
            OBJ_btm.setCodigo_sunat(cbx_tabla_sunat.getID() + "");
        } catch (Exception e) {
        }
    }

    public KeyListener evento_press(pnl_datos_tipo_movimiento OBJ_pdt, KeyListener KeyEvnt) {
        OBJ_pdt.TXT_codigo.addKeyListener(KeyEvnt);
        OBJ_pdt.TXT_nombre.addKeyListener(KeyEvnt);
        OBJ_pdt.CBX_tipo_movimiento.addKeyListener(KeyEvnt);
        OBJ_pdt.CBX_es_transferencia.addKeyListener(KeyEvnt);
        OBJ_pdt.CBX_almacen.addKeyListener(KeyEvnt);
        OBJ_pdt.CBX_tipo_almacen.addKeyListener(KeyEvnt);
        OBJ_pdt.CBX_estado.addKeyListener(KeyEvnt);
        OBJ_pdt.CBX_codigo_sunat.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
