package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.GUI.pnl_cab_liquidacion;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

public class evt_cab_liquidacion {

    String ls_modulo = "DISTBR", ls_capa = "LOGICA", ls_clase = "evt_datos_programacion";

    public void activa_campos(int op, pnl_cab_liquidacion OBJ_pcp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pcp.TXT_numero.setEnabled(valor);
                OBJ_pcp.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcp.TXT_programacion.setEnabled(valor);
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                OBJ_pcp.TXT_numero.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_cab_liquidacion OBJ_pcp) {
        OBJ_pcp.TXT_numero.setText("0000000000");
        OBJ_pcp.TXT_fecha_emision.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcp.CBX_estado.setSelectedIndex(1);
        OBJ_pcp.TXT_observacion.setText("");
        OBJ_pcp.TXT_programacion.setText("");
        OBJ_pcp.LBL_fecha_registro.setText("");
        OBJ_pcp.LBL_numero_doc.setText("0000000000");
    }

    public KeyListener evento_press(pnl_cab_liquidacion OBJ_pcp, KeyListener KeyEvnt) {
        OBJ_pcp.TXT_numero.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_fecha_emision.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_observacion.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_programacion.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public FocusListener evento_focus(pnl_cab_liquidacion OBJ_pcp, FocusListener FocusEvent) {
        OBJ_pcp.TXT_numero.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_fecha_emision.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_observacion.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_programacion.addFocusListener(FocusEvent);
        return FocusEvent;
    }

}
