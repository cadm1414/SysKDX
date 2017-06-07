package JAVA.CONFIG.LOGICA;

import JAVA.CONFIG.GUI.pnl_datos_usuario_permisos;
import JAVA.CONFIG.GUI.pnl_grid_usuario_permisos;
import java.awt.event.KeyListener;

public class evt_datos_usuario_permisos {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_sucursal";

    public void activa_campos(int op, pnl_datos_usuario_permisos OBJ_pup, pnl_grid_usuario_permisos OBJ_pgu, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pup.TXT_id_usuario.setEnabled(valor);
                OBJ_pgu.TBL_usuario_permisos.setEnabled(valor);
                OBJ_pup.TXT_id_usuario.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_usuario_permisos OBJ_pup) {
        OBJ_pup.TXT_id_usuario.setText("");
        OBJ_pup.TXT_usuario.setText("");
    }
    
    public KeyListener evento_press(pnl_datos_usuario_permisos OBJ_pdu, KeyListener KeyEvnt) {
        OBJ_pdu.TXT_id_usuario.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
