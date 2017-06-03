package JAVA.ANCESTRO.LOGICA;

import JAVA.ANCESTRO.GUI.pnl_opciones_1;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class evt_opciones_1 {

    /*  SWITCH PRINCIPAL 
        0 = INICIA FRAME
        1 = EVT_EDITAR
        2 = EVT_GUARDAR
        3 = EVT_CANCELAR
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
    public void activa_btn_opciones(int op, pnl_opciones_1 OBJ_pop, boolean valor_op[]) {

        switch (op) {
            case 0:
                OBJ_pop.BTN_editar.setEnabled(valor_op[2]);
                OBJ_pop.BTN_guardar.setEnabled(false);
                OBJ_pop.BTN_cancelar.setEnabled(false);
                OBJ_pop.BTN_editar.requestFocus();
                break;
            case 1:
                OBJ_pop.BTN_guardar.setEnabled(valor_op[5]);
                OBJ_pop.BTN_editar.setEnabled(false);
                OBJ_pop.BTN_cancelar.setEnabled(true);
                break;
        }

    }
    
    public ActionListener evento_click(pnl_opciones_1 OBJ_pop, ActionListener Listener) {
        OBJ_pop.BTN_cancelar.addActionListener(Listener);
        OBJ_pop.BTN_editar.addActionListener(Listener);
        OBJ_pop.BTN_guardar.addActionListener(Listener);
        return Listener;
    }
    
    public KeyListener evento_press(pnl_opciones_1 OBJ_pop, KeyListener KeyEvnt) {
        OBJ_pop.BTN_cancelar.addKeyListener(KeyEvnt);
        OBJ_pop.BTN_editar.addKeyListener(KeyEvnt);
        OBJ_pop.BTN_guardar.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
