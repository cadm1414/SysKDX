package JAVA.ANCESTRO.LOGICA;

import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class evt_opciones_3 {

    /*  SWITCH PRINCIPAL 
        0 = INICIA FRAME
        1 = EVT_NUEVO
        2 = EVT_BUSCAR
        3 = EVT_EDITAR
        4 = EVT_ELIMINAR
        5 = EVT_GUARDAR
        6 = EVT_ANULAR
        7 = EVT_IMPRIMIR
        8 = EVT_CANCELAR
     */
 /*  VALOR ResultSET
        0 = NUEVO
        1 = BUSCAR
        2 = EDITAR
        3 = ELIMINAR
        4 = ANULAR
        5 = GUARDAR
        6 = IMPRIMIR
        7 = REPORTE
     */

    public void activa_btn_opciones(int op, pnl_opciones_3 OBJ_pop, boolean valor_op[]) {

        switch (op) {
            case 0:
                OBJ_pop.BTN_nuevo.setEnabled(valor_op[0]);
                OBJ_pop.BTN_buscar.setEnabled(valor_op[1]);
                OBJ_pop.BTN_editar.setEnabled(false);
                OBJ_pop.BTN_eliminar.setEnabled(false);
                OBJ_pop.BTN_guardar.setEnabled(false);
                OBJ_pop.BTN_anular.setEnabled(valor_op[4]);
                OBJ_pop.BTN_imprimir.setEnabled(false);
                OBJ_pop.BTN_cancelar.setEnabled(false);
                OBJ_pop.BTN_nuevo.requestFocus();
                break;
            case 1:
                OBJ_pop.BTN_nuevo.setEnabled(false);
                OBJ_pop.BTN_buscar.setEnabled(false);
                OBJ_pop.BTN_editar.setEnabled(false);
                OBJ_pop.BTN_eliminar.setEnabled(false);
                OBJ_pop.BTN_guardar.setEnabled(valor_op[5]);
                OBJ_pop.BTN_anular.setEnabled(false);
                OBJ_pop.BTN_imprimir.setEnabled(false);
                OBJ_pop.BTN_cancelar.setEnabled(true);
                break;
        }
    }
    
    public ActionListener evento_click(pnl_opciones_3 OBJ_pop, ActionListener Listener) {
        OBJ_pop.BTN_cancelar.addActionListener(Listener);
        OBJ_pop.BTN_nuevo.addActionListener(Listener);
        OBJ_pop.BTN_buscar.addActionListener(Listener);
        OBJ_pop.BTN_editar.addActionListener(Listener);
        OBJ_pop.BTN_guardar.addActionListener(Listener);
        OBJ_pop.BTN_eliminar.addActionListener(Listener);
        OBJ_pop.BTN_imprimir.addActionListener(Listener);
        OBJ_pop.BTN_anular.addActionListener(Listener);
        return Listener;
    }

    public KeyListener evento_press(pnl_opciones_3 OBJ_pop, KeyListener KeyEvnt) {
        OBJ_pop.BTN_cancelar.addKeyListener(KeyEvnt);
        OBJ_pop.BTN_nuevo.addKeyListener(KeyEvnt);
        OBJ_pop.BTN_buscar.addKeyListener(KeyEvnt);
        OBJ_pop.BTN_editar.addKeyListener(KeyEvnt);
        OBJ_pop.BTN_guardar.addKeyListener(KeyEvnt);
        OBJ_pop.BTN_eliminar.addKeyListener(KeyEvnt);
        OBJ_pop.BTN_imprimir.addKeyListener(KeyEvnt);
        OBJ_pop.BTN_anular.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
