package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.BEAN.BEAN_marca;
import JAVA.INVENT.GUI.pnl_datos_marca;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_marca {

    String ls_modulo = "INVENT", ls_capa = "LOGICA", ls_clase = "evt_datos_marca";

    public void activa_campos(int op, pnl_datos_marca OBJ_pdm, boolean valor) {
        switch (op) {
            case 0:
                //OBJ_pdm.TXT_codigo.setEnabled(valor);
                OBJ_pdm.TXT_nombre.setEnabled(valor);
                OBJ_pdm.CBX_estado.setEnabled(valor);
                OBJ_pdm.TXT_nombre.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_marca OBJ_pdm) {
        OBJ_pdm.TXT_codigo.setText("");
        OBJ_pdm.TXT_nombre.setText("");
        OBJ_pdm.CBX_estado.setSelectedIndex(1);
    }

    public void muestra_datos(pnl_datos_marca OBJ_pdm, BEAN_marca OBJ_bma) {
        OBJ_pdm.TXT_codigo.setText(OBJ_bma.getCodigo_marca());
        OBJ_pdm.TXT_nombre.setText(OBJ_bma.getNombre_marca());
        OBJ_pdm.CBX_estado.setSelectedIndex(Integer.parseInt(OBJ_bma.getStatus()));
    }

    public void setea_recupera(BEAN_marca OBJ_bma, ResultSet lq_rs) {
        try {
            OBJ_bma.setCodigo_marca(lq_rs.getString(1));
            OBJ_bma.setNombre_marca(lq_rs.getString(2));
            OBJ_bma.setStatus(lq_rs.getString(3));
        } catch (Exception e) {
        }
    }

    public boolean valida_campos(pnl_datos_marca OBJ_pdm) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pdm.TXT_nombre) && go_fnc_operaciones_campos.cant_caracter(OBJ_pdm.TXT_nombre.getText().trim(), 1, 3)) {
            resp = true;
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE MARCA");
            OBJ_pdm.TXT_nombre.requestFocus();
        }
        return resp;
    }

    public boolean verifica_cambios(BEAN_marca OBJ_bma, pnl_datos_marca OBJ_pdm) {
        boolean resp = false;
        if (OBJ_bma.getNombre_marca().equalsIgnoreCase(OBJ_pdm.TXT_nombre.getText().trim())) {
            if (OBJ_bma.getStatus().equalsIgnoreCase(OBJ_pdm.CBX_estado.getSelectedIndex() + "")) {
            } else {
                resp = true;
            }
        } else {
            resp = true;
        }
        return resp;
    }

    public void setea_campos(BEAN_marca OBJ_bma, pnl_datos_marca OBJ_pdm) {
        try {
            OBJ_bma.setCodigo_marca(go_fnc_operaciones_campos.get_campo_str(OBJ_pdm.TXT_codigo));
            OBJ_bma.setNombre_marca(go_fnc_operaciones_campos.get_campo_str(OBJ_pdm.TXT_nombre));
            OBJ_bma.setStatus(OBJ_pdm.CBX_estado.getSelectedIndex() + "");
        } catch (Exception e) {
        }
    }

    public KeyListener evento_press(pnl_datos_marca OBJ_pds, KeyListener KeyEvnt) {
        OBJ_pds.TXT_codigo.addKeyListener(KeyEvnt);
        OBJ_pds.TXT_nombre.addKeyListener(KeyEvnt);
        OBJ_pds.CBX_estado.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
