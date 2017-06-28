package JAVA.ANCESTRO.LOGICA;

import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class evt_aceptar_cancelar {
    public ActionListener evento_click(pnl_aceptar_cancelar OBJ_pac, ActionListener Listener) {
        OBJ_pac.BTN_cancelar.addActionListener(Listener);
        OBJ_pac.BTN_aceptar.addActionListener(Listener);
        return Listener;
    }

    public KeyListener evento_press(pnl_aceptar_cancelar OBJ_pac, KeyListener KeyEvnt) {
        OBJ_pac.BTN_cancelar.addKeyListener(KeyEvnt);
        OBJ_pac.BTN_aceptar.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
