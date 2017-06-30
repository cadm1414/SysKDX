package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.GUI.pnl_cab_saldos_iniciales;
import java.awt.event.KeyListener;
import java.util.Calendar;

public class evt_cab_saldos_iniciales {

    String ls_modulo = "INVENT", ls_capa = "LOGICA", ls_clase = "evt_cab_saldos_iniciales";
    Calendar fecha = Calendar.getInstance();
    String mes = go_fnc_operaciones_campos.completa_digitos((fecha.get(Calendar.MONTH) + 1) + "", "0", 2);
    String dia = go_fnc_operaciones_campos.completa_digitos((fecha.get(Calendar.DAY_OF_MONTH)) + "", "0", 2);
    
    public void activa_campos(int op, pnl_cab_saldos_iniciales OBJ_pdc, boolean valor) {
        switch (op) {
            case 0:                
                OBJ_pdc.CBX_tipo_doc_ref.setEnabled(valor);
                OBJ_pdc.TXT_numero.setEnabled(valor);
                OBJ_pdc.TXT_numero_ref.setEnabled(valor);
                OBJ_pdc.TXT_fecha_emision.setEnabled(valor);
                OBJ_pdc.TXT_observacion.setEnabled(valor);
                OBJ_pdc.TXT_numero.requestFocus();
                break;
        }
    }
    
    public void limpia_datos(pnl_cab_saldos_iniciales OBJ_pdc) {
        OBJ_pdc.TXT_numero.setText("");
        OBJ_pdc.TXT_numero_ref.setText("");
        OBJ_pdc.TXT_numero.setText("");
        OBJ_pdc.TXT_fecha_emision.setText(dia+mes+gs_periodo);
        OBJ_pdc.TXT_observacion.setText("");
        OBJ_pdc.CBX_estado.setSelectedIndex(1);
    }
    
    public KeyListener evento_press(pnl_cab_saldos_iniciales OBJ_pdc, KeyListener KeyEvnt) {
        OBJ_pdc.TXT_numero.addKeyListener(KeyEvnt);
        OBJ_pdc.CBX_tipo_doc_ref.addKeyListener(KeyEvnt);
        OBJ_pdc.TXT_numero_ref.addKeyListener(KeyEvnt);
        OBJ_pdc.TXT_fecha_emision.addKeyListener(KeyEvnt);
        OBJ_pdc.TXT_observacion.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
