package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.BEAN.BEAN_familia;
import JAVA.INVENT.GUI.pnl_datos_familia;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_familia {

    String ls_modulo = "INVENT", ls_capa = "LOGICA", ls_clase = "evt_datos_familia";

    public void activa_campos(int op, pnl_datos_familia OBJ_pdf, boolean valor) {
        switch (op) {
            case 0:
                //OBJ_pdf.TXT_codigo.setEnabled(valor);
                OBJ_pdf.TXT_nombre.setEnabled(valor);
                OBJ_pdf.TXT_nombre.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_familia OBJ_pdf) {
        OBJ_pdf.TXT_codigo.setText("");
        OBJ_pdf.TXT_nombre.setText("");
    }

    public void muestra_datos(pnl_datos_familia OBJ_pdf, BEAN_familia OBJ_bfa) {
        OBJ_pdf.TXT_codigo.setText(OBJ_bfa.getCodigo_familia());
        OBJ_pdf.TXT_nombre.setText(OBJ_bfa.getNombre_familia());
    }

    public void setea_recupera(BEAN_familia OBJ_bfa, ResultSet lq_rs) {
        try {
            OBJ_bfa.setCodigo_familia(lq_rs.getString(1));
            OBJ_bfa.setNombre_familia(lq_rs.getString(2));
        } catch (Exception e) {
        }
    }

    public boolean valida_campos(pnl_datos_familia OBJ_pdf) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pdf.TXT_nombre) && go_fnc_operaciones_campos.cant_caracter(OBJ_pdf.TXT_nombre.getText().trim(), 1, 3)) {
            resp = true;
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE FAMILIA");
            OBJ_pdf.TXT_nombre.requestFocus();
        }
        return resp;
    }

    public boolean verifica_cambios(BEAN_familia OBJ_bfa, pnl_datos_familia OBJ_pdf) {
        boolean resp = false;
        if (OBJ_bfa.getNombre_familia().equalsIgnoreCase(OBJ_pdf.TXT_nombre.getText().trim())) {            
        } else {
            resp = true;
        }
        return resp;
    }

    public void setea_campos(BEAN_familia OBJ_bfa, pnl_datos_familia OBJ_pdf) {
        try {
            OBJ_bfa.setCodigo_familia(go_fnc_operaciones_campos.get_campo_str(OBJ_pdf.TXT_codigo));
            OBJ_bfa.setNombre_familia(go_fnc_operaciones_campos.get_campo_str(OBJ_pdf.TXT_nombre));
        } catch (Exception e) {
        }
    }
    
    public KeyListener evento_press(pnl_datos_familia OBJ_pdf, KeyListener KeyEvnt) {
        OBJ_pdf.TXT_codigo.addKeyListener(KeyEvnt);
        OBJ_pdf.TXT_nombre.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
