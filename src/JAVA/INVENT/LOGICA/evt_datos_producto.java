package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.BEAN.BEAN_producto;
import JAVA.INVENT.GUI.pnl_datos_producto;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_producto {

    String ls_modulo = "INVENT", ls_capa = "LOGICA", ls_clase = "evt_datos_marca";

    public void activa_campos(int op, pnl_datos_producto OBJ_pdp, boolean valor) {
        switch (op) {
            case 0:
                //OBJ_pdp.TXT_codigo.setEnabled(valor);
                OBJ_pdp.TXT_nombre.setEnabled(valor);
                OBJ_pdp.CBX_clase.setEnabled(valor);
                OBJ_pdp.TXT_dias.setEnabled(valor);
                //OBJ_pdp.CBX_arancel.setEnabled(valor);
                OBJ_pdp.CBX_detraccion.setEnabled(valor);
                OBJ_pdp.CBX_percepcion.setEnabled(valor);
                OBJ_pdp.CBX_estado.setEnabled(valor);
                OBJ_pdp.TXT_nombre.requestFocus();
                break;
            case 1:
                OBJ_pdp.TXT_dias.setEnabled(valor);
                OBJ_pdp.CBX_estado.setEnabled(valor);
                OBJ_pdp.TXT_dias.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_producto OBJ_pdp) {
        OBJ_pdp.TXT_codigo.setText("");
        OBJ_pdp.TXT_nombre.setText("");
        OBJ_pdp.CBX_clase.setSelectedIndex(0);
        OBJ_pdp.TXT_dias.setText("");
        //OBJ_pdp.CBX_arancel.setSelectedIndex(0);
        OBJ_pdp.CBX_detraccion.setSelectedIndex(0);
        OBJ_pdp.CBX_percepcion.setSelectedIndex(0);
        OBJ_pdp.CBX_estado.setSelectedIndex(1);
    }

    public void muestra_datos(pnl_datos_producto OBJ_pdp, BEAN_producto OBJ_bpr) {
        OBJ_pdp.TXT_codigo.setText(OBJ_bpr.getCodigo_producto());
        OBJ_pdp.TXT_nombre.setText(OBJ_bpr.getNombre_producto());
        OBJ_pdp.CBX_clase.setSelectedIndex(Integer.parseInt(OBJ_bpr.getClase_producto()));
        OBJ_pdp.TXT_dias.setText(OBJ_bpr.getDias_almacen());
        //OBJ_pdp.CBX_arancel.setSelectedIndex(Integer.parseInt(OBJ_bpr.getCodigo_arancel()));
        OBJ_pdp.CBX_detraccion.setSelectedIndex(Integer.parseInt(OBJ_bpr.getAfecto_detraccion()));
        OBJ_pdp.CBX_percepcion.setSelectedIndex(Integer.parseInt(OBJ_bpr.getAfecto_percepcion()));
        OBJ_pdp.CBX_estado.setSelectedIndex(Integer.parseInt(OBJ_bpr.getStatus()));
    }

    public boolean verifica_cambios(BEAN_producto OBJ_bpr, pnl_datos_producto OBJ_pdp) {
        boolean resp = false;
        if (OBJ_bpr.getNombre_producto().equalsIgnoreCase(OBJ_pdp.TXT_nombre.getText().trim())) {
            if (OBJ_bpr.getClase_producto().equalsIgnoreCase(OBJ_pdp.CBX_clase.getSelectedIndex() + "")) {
                if (OBJ_bpr.getDias_almacen().equalsIgnoreCase(OBJ_pdp.TXT_dias.getText().trim())) {
                    if (OBJ_bpr.getStatus().equalsIgnoreCase(OBJ_pdp.CBX_estado.getSelectedIndex() + "")) {
                        if (OBJ_bpr.getAfecto_detraccion().equalsIgnoreCase(OBJ_pdp.CBX_detraccion.getSelectedIndex() + "")) {
                            if (OBJ_bpr.getAfecto_percepcion().equalsIgnoreCase(OBJ_pdp.CBX_percepcion.getSelectedIndex() + "")) {
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

    public boolean valida_campos(pnl_datos_producto OBJ_pdp) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pdp.TXT_nombre) && go_fnc_operaciones_campos.cant_caracter(OBJ_pdp.TXT_nombre.getText().trim(), 1, 3)) {
            resp = true;
            if (!go_fnc_operaciones_campos.campo_blanco(OBJ_pdp.TXT_dias)) {
                OBJ_pdp.TXT_dias.setText("0");
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE PRODUCTO");
            OBJ_pdp.TXT_nombre.requestFocus();
        }
        return resp;
    }

    public void setea_campos(BEAN_producto OBJ_bpr, pnl_datos_producto OBJ_pdp) {
        try {
            OBJ_bpr.setCodigo_producto(go_fnc_operaciones_campos.get_campo_str(OBJ_pdp.TXT_codigo));
            OBJ_bpr.setNombre_producto(go_fnc_operaciones_campos.get_campo_str(OBJ_pdp.TXT_nombre));
            OBJ_bpr.setClase_producto(OBJ_pdp.CBX_clase.getSelectedIndex() + "");
            OBJ_bpr.setDias_almacen(go_fnc_operaciones_campos.get_campo_str(OBJ_pdp.TXT_dias));
            //OBJ_bpr.setCodigo_arancel(OBJ_pdp.CBX_arancel.getSelectedIndex()+"");
            OBJ_bpr.setAfecto_detraccion(OBJ_pdp.CBX_detraccion.getSelectedIndex() + "");
            OBJ_bpr.setAfecto_percepcion(OBJ_pdp.CBX_percepcion.getSelectedIndex() + "");
            OBJ_bpr.setStatus(OBJ_pdp.CBX_estado.getSelectedIndex() + "");
        } catch (Exception e) {
        }
    }

    public void setea_recupera(BEAN_producto OBJ_bpr, ResultSet lq_rs) {
        try {
            OBJ_bpr.setCodigo_producto(lq_rs.getString(1));
            OBJ_bpr.setNombre_producto(lq_rs.getString(2));
            OBJ_bpr.setClase_producto(lq_rs.getString(3));
            OBJ_bpr.setDias_almacen(lq_rs.getString(4));
            //OBJ_bpr.setCodigo_arancel(lq_rs.getString(5));
            OBJ_bpr.setAfecto_detraccion(lq_rs.getString(6));
            OBJ_bpr.setAfecto_percepcion(lq_rs.getString(7));
            OBJ_bpr.setStatus(lq_rs.getString(8));
        } catch (Exception e) {
        }
    }

    public KeyListener evento_press(pnl_datos_producto OBJ_pdp, KeyListener KeyEvnt) {
        OBJ_pdp.TXT_codigo.addKeyListener(KeyEvnt);
        OBJ_pdp.TXT_nombre.addKeyListener(KeyEvnt);
        OBJ_pdp.CBX_clase.addKeyListener(KeyEvnt);
        OBJ_pdp.TXT_dias.addKeyListener(KeyEvnt);
        OBJ_pdp.CBX_arancel.addKeyListener(KeyEvnt);
        OBJ_pdp.CBX_detraccion.addKeyListener(KeyEvnt);
        OBJ_pdp.CBX_percepcion.addKeyListener(KeyEvnt);
        OBJ_pdp.CBX_estado.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
