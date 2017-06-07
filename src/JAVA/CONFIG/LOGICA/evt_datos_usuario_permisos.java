package JAVA.CONFIG.LOGICA;

import JAVA.CONFIG.BEAN.BEAN_usuario_permisos;
import JAVA.CONFIG.GUI.pnl_datos_usuario_permisos;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_usuario_permisos {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_sucursal";

    public void activa_campos(int op, pnl_datos_usuario_permisos OBJ_pup,boolean valor) {
        switch (op) {
            case 0:
                OBJ_pup.TXT_id_usuario.setEnabled(valor);
                OBJ_pup.TXT_id_usuario.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_usuario_permisos OBJ_pup) {
        OBJ_pup.TXT_id_usuario.setText("");
        OBJ_pup.TXT_usuario.setText("");
    }
    
    public void muestra_datos(BEAN_usuario_permisos OBJ_bup, pnl_datos_usuario_permisos OBJ_pdu) {
        OBJ_pdu.TXT_id_usuario.setText(OBJ_bup.getId_usuario()+"");
    }
    
    public void setea_recupera(BEAN_usuario_permisos OBJ_bup, ResultSet lq_rs) {
        try {
            OBJ_bup.setId_usuario(lq_rs.getInt(1));
        } catch (Exception e) {
        }
    }
    
    public KeyListener evento_press(pnl_datos_usuario_permisos OBJ_pdu, KeyListener KeyEvnt) {
        OBJ_pdu.TXT_id_usuario.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
