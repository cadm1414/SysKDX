package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_unidad_medida;
import JAVA.CONFIG.GUI.pnl_datos_unidad_medida;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_unidad_medida {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_unidad_medida";

    public void activa_campos(int op, pnl_datos_unidad_medida OBJ_pdu, boolean valor) {
        switch (op) {
            case 0:
                //OBJ_pdu.TXT_codigo.setEnabled(valor);
                OBJ_pdu.TXT_nombre.setEnabled(valor);
                OBJ_pdu.TXT_simbolo.setEnabled(valor);
                OBJ_pdu.CBX_codigo_sunat.setEnabled(valor);
                OBJ_pdu.TXT_nombre.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_unidad_medida OBJ_pdu) {
        OBJ_pdu.TXT_codigo.setText("");
        OBJ_pdu.TXT_nombre.setText("");
        OBJ_pdu.TXT_simbolo.setText("");
        OBJ_pdu.CBX_codigo_sunat.setSelectedIndex(0);
    }

    public void setea_recupera(BEAN_unidad_medida OBJ_bum, ResultSet lq_rs) {
        try {
            OBJ_bum.setCodigo_unidad(lq_rs.getString(1));
            OBJ_bum.setNombre_unidad(lq_rs.getString(2));
            OBJ_bum.setSimbolo_unidad(lq_rs.getString(3));
            OBJ_bum.setCodigo_sunat(lq_rs.getString(4));
        } catch (Exception e) {
        }
    }

    public void muestra_datos(pnl_datos_unidad_medida OBJ_pds, BEAN_unidad_medida OBJ_bum) {
        OBJ_pds.TXT_codigo.setText(OBJ_bum.getCodigo_unidad());
        OBJ_pds.TXT_nombre.setText(OBJ_bum.getNombre_unidad());
        OBJ_pds.TXT_simbolo.setText(OBJ_bum.getSimbolo_unidad());
        go_cbx_trato_datos.selecciona_valor(4, OBJ_bum.getCodigo_sunat(), OBJ_pds.CBX_codigo_sunat);
    }

    public boolean valida_campos(pnl_datos_unidad_medida OBJ_pdu) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pdu.TXT_nombre) && go_fnc_operaciones_campos.cant_caracter(OBJ_pdu.TXT_nombre.getText().trim(), 1, 3)) {
            if (go_fnc_operaciones_campos.campo_blanco(OBJ_pdu.TXT_simbolo) && go_fnc_operaciones_campos.cant_caracter(OBJ_pdu.TXT_simbolo.getText().trim(), 1, 1)) {
                resp = true;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE SIMBOLO");
                OBJ_pdu.TXT_simbolo.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE UNIDAD");
            OBJ_pdu.TXT_nombre.requestFocus();
        }
        return resp;
    }

    public boolean verifica_cambios(BEAN_unidad_medida OBJ_bum, pnl_datos_unidad_medida OBJ_pdu, cbx_tabla_sunat cbx_tabla_sunat) {
        boolean resp = false;
        if (OBJ_bum.getNombre_unidad().equalsIgnoreCase(OBJ_pdu.TXT_nombre.getText().trim())) {
            if (OBJ_bum.getSimbolo_unidad().equalsIgnoreCase(OBJ_pdu.TXT_simbolo.getText().trim())) {
                if (OBJ_bum.getCodigo_sunat().equalsIgnoreCase(cbx_tabla_sunat.getID())) {
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

    public void setea_campos(BEAN_unidad_medida OBJ_bum, pnl_datos_unidad_medida OBJ_pdu, cbx_tabla_sunat cbx_tabla_sunat) {
        try {
            OBJ_bum.setCodigo_unidad(go_fnc_operaciones_campos.get_campo_str(OBJ_pdu.TXT_codigo));
            OBJ_bum.setNombre_unidad(go_fnc_operaciones_campos.get_campo_str(OBJ_pdu.TXT_nombre));
            OBJ_bum.setSimbolo_unidad(go_fnc_operaciones_campos.get_campo_str(OBJ_pdu.TXT_simbolo));
            OBJ_bum.setCodigo_sunat(cbx_tabla_sunat.getID());
        } catch (Exception e) {
        }
    }

    public KeyListener evento_press(pnl_datos_unidad_medida OBJ_pdu, KeyListener KeyEvnt) {
        OBJ_pdu.TXT_codigo.addKeyListener(KeyEvnt);
        OBJ_pdu.TXT_nombre.addKeyListener(KeyEvnt);
        OBJ_pdu.TXT_simbolo.addKeyListener(KeyEvnt);
        OBJ_pdu.CBX_codigo_sunat.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
