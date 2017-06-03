package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_rol;
import JAVA.CONFIG.GUI.pnl_datos_rol_menu;
import JAVA.CONFIG.GUI.pnl_grid_rol_menu;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_rol_menu {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_rol_menu";

    /*  SWITCH PRINCIPAL 
        0 = NUEVO
     */
    public void activa_campos(int op, pnl_datos_rol_menu OBJ_prm, pnl_grid_rol_menu OBJ_pgr, boolean valor) {
        switch (op) {
            case 0:
                OBJ_prm.TXT_nombre_rol.setEnabled(valor);
                OBJ_pgr.TBL_rol_menu.setEnabled(valor);
                OBJ_prm.TXT_nombre_rol.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_rol_menu OBJ_prm) {
        OBJ_prm.TXT_nombre_rol.setText("");
    }

    public boolean valida_campos(pnl_datos_rol_menu OBJ_prm) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_prm.TXT_nombre_rol) && go_fnc_operaciones_campos.cant_caracter(OBJ_prm.TXT_nombre_rol.getText().trim(), 1, 4)) {
            resp = true;
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE ROL CORRECTO");
            OBJ_prm.TXT_nombre_rol.requestFocus();
        }
        return resp;
    }

    public KeyListener evento_press(pnl_datos_rol_menu OBJ_prm, KeyListener KeyEvnt) {
        OBJ_prm.TXT_nombre_rol.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public void setea_recupera(BEAN_rol OBJ_rol, ResultSet lq_rs) {
        try {
            OBJ_rol.setId_rol(lq_rs.getInt(1));
            OBJ_rol.setNombre_rol(lq_rs.getString(2));
        } catch (Exception e) {
        }
    }

    public void setea_campos(BEAN_rol OBJ_rol, pnl_datos_rol_menu OBJ_drm) {
        try {
            OBJ_rol.setNombre_rol(go_fnc_operaciones_campos.get_campo_str(OBJ_drm.TXT_nombre_rol));
        } catch (Exception e) {
        }

    }

    public void muestra_datos(BEAN_rol OBJ_rol, pnl_datos_rol_menu OBJ_drm) {
        OBJ_drm.TXT_nombre_rol.setText(OBJ_rol.getNombre_rol());
    }

}
