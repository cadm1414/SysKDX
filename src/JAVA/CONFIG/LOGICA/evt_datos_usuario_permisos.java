package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_usuario_permisos;
import JAVA.CONFIG.GUI.pnl_datos_usuario_permisos;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_usuario_permisos {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_sucursal";

    public void activa_campos(int op, pnl_datos_usuario_permisos OBJ_pup, boolean valor) {
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
        OBJ_pdu.TXT_id_usuario.setText(OBJ_bup.getId_usuario() + "");
        OBJ_pdu.TXT_usuario.setText(OBJ_bup.getNombre_usuario());
    }

    public void setea_campos(BEAN_usuario_permisos OBJ_bup, pnl_datos_usuario_permisos OBJ_pup) {
        try {
            OBJ_bup.setId_usuario(Integer.parseInt(OBJ_pup.TXT_id_usuario.getText()));
            OBJ_bup.setNombre_usuario(go_fnc_operaciones_campos.get_campo_str(OBJ_pup.TXT_usuario));

        } catch (Exception e) {
        }
    }

    public void setea_recupera(BEAN_usuario_permisos OBJ_bup, ResultSet lq_rs) {
        try {
            OBJ_bup.setId_usuario(lq_rs.getInt(1));
            OBJ_bup.setNombre_usuario(lq_rs.getString(2));
        } catch (Exception e) {
        }
    }

    public boolean valida_campos(pnl_datos_usuario_permisos OBJ_dup) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_dup.TXT_id_usuario)) {
            if (go_fnc_operaciones_campos.campo_blanco(OBJ_dup.TXT_usuario)) {
                resp = true;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE USUARIO");
                OBJ_dup.TXT_id_usuario.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE USUARIO");
            OBJ_dup.TXT_id_usuario.requestFocus();
        }
        return resp;
    }

    public KeyListener evento_press(pnl_datos_usuario_permisos OBJ_pdu, KeyListener KeyEvnt) {
        OBJ_pdu.TXT_id_usuario.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
