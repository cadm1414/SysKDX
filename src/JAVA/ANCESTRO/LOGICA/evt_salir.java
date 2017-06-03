package JAVA.ANCESTRO.LOGICA;

import JAVA.ANCESTRO.GUI.pnl_salir;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class evt_salir {

    public void ejecuta(JFrame frm_principal, JFrame frm_auxiliar) {
        int resp = go_fnc_mensaje.get_respuesta(0, "DESEA CERRAR EL FORMULARIO");

        if (resp == 0) {
            frm_auxiliar.dispose();
            frm_principal.setVisible(true);
        }

    }
    
    public ActionListener evento_click(pnl_salir OBJ_psl, ActionListener Listener) {
        OBJ_psl.BTN_salir.addActionListener(Listener);
        return Listener;
    }
    
    public KeyListener evento_press(pnl_salir OBJ_psl, KeyListener KeyEvnt) {
        OBJ_psl.BTN_salir.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

}
