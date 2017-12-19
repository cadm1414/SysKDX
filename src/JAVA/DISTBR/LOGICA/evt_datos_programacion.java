package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.GUI.pnl_datos_programacion;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

public class evt_datos_programacion {

    String ls_modulo = "DISTBR", ls_capa = "LOGICA", ls_clase = "evt_datos_programacion";

    public void activa_campos(int op, pnl_datos_programacion OBJ_pcp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pcp.TXT_numero.setEnabled(valor);
                OBJ_pcp.TXT_fecha_reparto.setEnabled(valor);
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                OBJ_pcp.TXT_codigo_transportista.setEnabled(valor);
                OBJ_pcp.TXT_numero.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_programacion OBJ_pcp) {
        OBJ_pcp.TXT_numero.setText("0000000000");
        OBJ_pcp.TXT_fecha_reparto.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcp.CBX_estado.setSelectedIndex(1);
        OBJ_pcp.TXT_observacion.setText("");
        OBJ_pcp.TXT_codigo_transportista.setText("");
        OBJ_pcp.TXT_nombre_transportista.setText("");
        OBJ_pcp.TXT_licencia.setText("");
        OBJ_pcp.TXT_empresa.setText("");
        OBJ_pcp.TXT_ruc_empresa.setText("");
        OBJ_pcp.TXT_codigo_vehiculo.setText("");
        OBJ_pcp.TXT_marca.setText("");
        OBJ_pcp.TXT_civ.setText("");
        OBJ_pcp.TXT_codigo_vehiculo_v2.setText("");
        OBJ_pcp.TXT_marca_v2.setText("");
        OBJ_pcp.TXT_civ_v2.setText("");
    }

    public KeyListener evento_press(pnl_datos_programacion OBJ_pcp, KeyListener KeyEvnt) {
        OBJ_pcp.TXT_numero.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_fecha_reparto.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_observacion.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_codigo_transportista.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public FocusListener evento_focus(pnl_datos_programacion OBJ_pcp, FocusListener FocusEvent) {
        OBJ_pcp.TXT_numero.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_fecha_reparto.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_observacion.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_codigo_transportista.addFocusListener(FocusEvent);
        return FocusEvent;
    }
}
