package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.BEAN.BEAN_subfamilia;
import JAVA.INVENT.GUI.pnl_datos_subfamilia;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_subfamilia {

    String ls_modulo = "INVENT", ls_capa = "LOGICA", ls_clase = "evt_datos_subfamilia";

    public void activa_campos(int op, pnl_datos_subfamilia OBJ_pds, boolean valor) {
        switch (op) {
            case 0:
                //OBJ_pdf.TXT_codigo.setEnabled(valor);
                OBJ_pds.TXT_nombre.setEnabled(valor);
                OBJ_pds.CBX_familia.setEnabled(valor);
                OBJ_pds.TXT_nombre.requestFocus();
                break;
        }
    }
    
    public void limpia_datos(pnl_datos_subfamilia OBJ_pds) {
        OBJ_pds.TXT_codigo.setText("");
        OBJ_pds.TXT_nombre.setText("");
        OBJ_pds.CBX_familia.setSelectedIndex(0);
    }

    public void muestra_datos(pnl_datos_subfamilia OBJ_pds, BEAN_subfamilia OBJ_bsf) {
        OBJ_pds.TXT_codigo.setText(OBJ_bsf.getCodigo_subfamilia());
        OBJ_pds.TXT_nombre.setText(OBJ_bsf.getNombre_subfamilia());
        go_cbx_trato_datos.selecciona_valor(5, OBJ_bsf.getCodigo_familia(), OBJ_pds.CBX_familia);
    }

    public void setea_recupera(BEAN_subfamilia OBJ_bsf, ResultSet lq_rs) {
        try {
            OBJ_bsf.setCodigo_subfamilia(lq_rs.getString(1));
            OBJ_bsf.setNombre_subfamilia(lq_rs.getString(2));
            OBJ_bsf.setCodigo_familia(lq_rs.getString(3));
        } catch (Exception e) {
        }
    }   

    public boolean valida_campos(pnl_datos_subfamilia OBJ_pds) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pds.TXT_nombre) && go_fnc_operaciones_campos.cant_caracter(OBJ_pds.TXT_nombre.getText().trim(), 1, 3)) {
            resp = true;
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE SUBFAMILIA");
            OBJ_pds.TXT_nombre.requestFocus();
        }
        return resp;
    }

    public boolean verifica_cambios(BEAN_subfamilia OBJ_bsf, pnl_datos_subfamilia OBJ_pds, cbx_familia cbx_familia) {
        boolean resp = false;
        if (OBJ_bsf.getNombre_subfamilia().equalsIgnoreCase(OBJ_pds.TXT_nombre.getText().trim())) {
            if (OBJ_bsf.getCodigo_familia().equalsIgnoreCase(cbx_familia.getID())) {
            } else {
                resp = true;
            }
        } else {
            resp = true;
        }
        return resp;
    }

    public void setea_campos(BEAN_subfamilia OBJ_bsf, pnl_datos_subfamilia OBJ_pds, cbx_familia cbx_familia) {
        try {
            OBJ_bsf.setCodigo_subfamilia(go_fnc_operaciones_campos.get_campo_str(OBJ_pds.TXT_codigo));
            OBJ_bsf.setNombre_subfamilia(go_fnc_operaciones_campos.get_campo_str(OBJ_pds.TXT_nombre));
            OBJ_bsf.setCodigo_familia(cbx_familia.getID());
        } catch (Exception e) {
        }
    }

    public KeyListener evento_press(pnl_datos_subfamilia OBJ_pds, KeyListener KeyEvnt) {
        OBJ_pds.TXT_codigo.addKeyListener(KeyEvnt);
        OBJ_pds.TXT_nombre.addKeyListener(KeyEvnt);
        OBJ_pds.CBX_familia.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
