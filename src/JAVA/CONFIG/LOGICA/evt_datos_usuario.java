package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_usuario;
import JAVA.CONFIG.GUI.pnl_datos_usuario;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_usuario {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_usuario";

    public void activa_campos(int op, pnl_datos_usuario OBJ_pdu, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pdu.TXT_datos.setEnabled(valor);
                OBJ_pdu.TXT_usuario.setEnabled(valor);
                OBJ_pdu.TXT_pass.setEnabled(valor);
                OBJ_pdu.CBX_rol.setEnabled(valor);
                OBJ_pdu.CBX_estado.setEnabled(valor);
                OBJ_pdu.TXT_datos.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_usuario OBJ_pdu) {
        OBJ_pdu.TXT_datos.setText("");
        OBJ_pdu.TXT_usuario.setText("");
        OBJ_pdu.TXT_pass.setText("");
    }

    public void setea_campos(BEAN_usuario OBJ_bus, pnl_datos_usuario OBJ_usu, cbx_rol cbx_rol) {
        try {
            OBJ_bus.setDatos_usuario(go_fnc_operaciones_campos.get_campo_str(OBJ_usu.TXT_datos));
            OBJ_bus.setNombre_usuario(go_fnc_operaciones_campos.get_campo_str(OBJ_usu.TXT_usuario));
            OBJ_bus.setClave_usuario(go_fnc_operaciones_campos.encriptar(go_fnc_operaciones_campos.get_campo_str(OBJ_usu.TXT_pass)));
            OBJ_bus.setStatus(OBJ_usu.CBX_estado.getSelectedIndex() + "");
            OBJ_bus.setId_rol(cbx_rol.getID());
        } catch (Exception e) {
        }
    }

    public void setea_recupera(BEAN_usuario OBJ_usu, ResultSet lq_rs) {
        try {
            OBJ_usu.setId_usuario(lq_rs.getInt(1));
            OBJ_usu.setNombre_usuario(lq_rs.getString(2));
            OBJ_usu.setClave_usuario(lq_rs.getString(3));
            OBJ_usu.setDatos_usuario(lq_rs.getString(4));
            OBJ_usu.setId_rol(lq_rs.getInt(5));
            OBJ_usu.setStatus(lq_rs.getString(6));
        } catch (Exception e) {
        }
    }

    public void muestra_datos(pnl_datos_usuario OBJ_usu, BEAN_usuario OBJ_bus) {
        OBJ_usu.TXT_datos.setText(OBJ_bus.getDatos_usuario());
        OBJ_usu.TXT_usuario.setText(OBJ_bus.getNombre_usuario());
        OBJ_usu.TXT_pass.setText(go_fnc_operaciones_campos.desencriptar(OBJ_bus.getClave_usuario()));
        OBJ_usu.CBX_estado.setSelectedIndex(Integer.parseInt(OBJ_bus.getStatus()));
        go_cbx_trato_datos.selecciona_valor(1, OBJ_bus.getId_rol() + "", OBJ_usu.CBX_rol);
    }

    public boolean valida_campos(pnl_datos_usuario OBJ_usu) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_usu.TXT_datos) && go_fnc_operaciones_campos.cant_caracter(OBJ_usu.TXT_datos.getText().trim(), 1, 4)) {
            if (go_fnc_operaciones_campos.campo_blanco(OBJ_usu.TXT_usuario) && go_fnc_operaciones_campos.cant_caracter(OBJ_usu.TXT_usuario.getText().trim(), 1, 4)) {
                if (go_fnc_operaciones_campos.campo_blanco(OBJ_usu.TXT_pass) && go_fnc_operaciones_campos.cant_caracter(OBJ_usu.TXT_pass.getText().trim(), 1, 4)) {
                    resp = true;
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CONTRASEÑA");
                    OBJ_usu.TXT_pass.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE USUARIO");
                OBJ_usu.TXT_usuario.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE DATOS DEL USUARIO");
            OBJ_usu.TXT_datos.requestFocus();
        }
        return resp;
    }

    public boolean verifica_cambios(BEAN_usuario OBJ_bus, pnl_datos_usuario OBJ_usu, cbx_rol cbx_rol) {
        boolean resp = false;

        if (OBJ_bus.getDatos_usuario().equalsIgnoreCase(OBJ_usu.TXT_datos.getText().trim())) {
            if (OBJ_bus.getNombre_usuario().equalsIgnoreCase(OBJ_usu.TXT_usuario.getText().trim())) {
                if (OBJ_bus.getClave_usuario().equalsIgnoreCase(go_fnc_operaciones_campos.encriptar(OBJ_usu.TXT_pass.getText().trim()))) {
                    if (OBJ_bus.getStatus().equalsIgnoreCase(OBJ_usu.CBX_estado.getSelectedIndex() + "")) {
                        if (OBJ_bus.getId_rol() == cbx_rol.getID()) {
                        } else {
                            resp = true;
                        }
                    } else {
                        resp = true;
                    }
                } else {
                    resp = true;
                }
            } else {
                resp = true;
            }
        } else {
            resp = true;
        }
        return resp;
    }

    public KeyListener evento_press(pnl_datos_usuario OBJ_pdu, KeyListener KeyEvnt) {
        OBJ_pdu.TXT_datos.addKeyListener(KeyEvnt);
        OBJ_pdu.TXT_pass.addKeyListener(KeyEvnt);
        OBJ_pdu.TXT_usuario.addKeyListener(KeyEvnt);
        OBJ_pdu.CBX_rol.addKeyListener(KeyEvnt);
        OBJ_pdu.CBX_estado.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

}
