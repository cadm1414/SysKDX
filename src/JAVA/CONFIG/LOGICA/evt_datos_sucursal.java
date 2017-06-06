package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_sucursal;
import JAVA.CONFIG.GUI.pnl_datos_sucursal;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_sucursal {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_sucursal";

    public void activa_campos(int op, pnl_datos_sucursal OBJ_pds, boolean valor) {
        switch (op) {
            case 0:
                //OBJ_pds.TXT_codigo.setEnabled(valor);
                OBJ_pds.TXT_nombre.setEnabled(valor);
                OBJ_pds.TXT_direccion.setEnabled(valor);
                OBJ_pds.CBX_estado.setEnabled(valor);
                OBJ_pds.TXT_ubigeo.setEnabled(valor);
                OBJ_pds.TXT_nota.setEnabled(valor);
                OBJ_pds.TXT_nombre.requestFocus();
                break;
        }
    }

    public void muestra_datos(pnl_datos_sucursal OBJ_dsu, BEAN_sucursal OBJ_bsu) {
        OBJ_dsu.TXT_codigo.setText(OBJ_bsu.getCodigo_sucursal());
        OBJ_dsu.TXT_nombre.setText(OBJ_bsu.getNombre());
        OBJ_dsu.TXT_direccion.setText(OBJ_bsu.getDireccion());
        OBJ_dsu.CBX_estado.setSelectedIndex(Integer.parseInt(OBJ_bsu.getStatus()));
        OBJ_dsu.TXT_ubigeo.setText(OBJ_bsu.getUbigeo());
        OBJ_dsu.TXT_descripcion.setText(OBJ_bsu.getDescripcion());
        OBJ_dsu.TXT_nota.setText(OBJ_bsu.getNota());
    }

    public void setea_recupera(BEAN_sucursal OBJ_bsu, ResultSet lq_rs) {
        try {
            OBJ_bsu.setCodigo_sucursal(lq_rs.getString(1));
            OBJ_bsu.setNombre(lq_rs.getString(2));
            OBJ_bsu.setDireccion(lq_rs.getString(3));
            OBJ_bsu.setNota(lq_rs.getString(4));
            OBJ_bsu.setStatus(lq_rs.getString(5));
            OBJ_bsu.setUbigeo(lq_rs.getString(6));
            OBJ_bsu.setDescripcion(lq_rs.getString(7));
        } catch (Exception e) {
        }
    }

    public void setea_campos(BEAN_sucursal OBJ_bsu, pnl_datos_sucursal OBJ_pds) {
        try {
            OBJ_bsu.setCodigo_sucursal(go_fnc_operaciones_campos.get_campo_str(OBJ_pds.TXT_codigo));
            OBJ_bsu.setNombre(go_fnc_operaciones_campos.get_campo_str(OBJ_pds.TXT_nombre));
            OBJ_bsu.setDireccion(go_fnc_operaciones_campos.get_campo_str(OBJ_pds.TXT_direccion));
            OBJ_bsu.setNota(go_fnc_operaciones_campos.get_campo_str(OBJ_pds.TXT_nota));
            OBJ_bsu.setStatus(OBJ_pds.CBX_estado.getSelectedIndex() + "");
            OBJ_bsu.setUbigeo(go_fnc_operaciones_campos.get_campo_str(OBJ_pds.TXT_ubigeo));
            OBJ_bsu.setDescripcion(go_fnc_operaciones_campos.get_campo_str(OBJ_pds.TXT_descripcion));
        } catch (Exception e) {
        }
    }

    public void limpia_datos(pnl_datos_sucursal OBJ_pds) {
        OBJ_pds.TXT_codigo.setText("");
        OBJ_pds.TXT_nombre.setText("");
        OBJ_pds.TXT_direccion.setText("");
        OBJ_pds.TXT_ubigeo.setText("");
        OBJ_pds.TXT_descripcion.setText("");
        OBJ_pds.TXT_nota.setText("");
    }

    public boolean valida_campos(pnl_datos_sucursal OBJ_pds) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pds.TXT_nombre) && go_fnc_operaciones_campos.cant_caracter(OBJ_pds.TXT_nombre.getText().trim(), 1, 4)) {
            if (go_fnc_operaciones_campos.campo_blanco(OBJ_pds.TXT_direccion) && go_fnc_operaciones_campos.cant_caracter(OBJ_pds.TXT_direccion.getText().trim(), 1, 4)) {
                if (go_dao_ubigeo.SLT_cta_ubigeo_x_codigo(OBJ_pds.TXT_ubigeo.getText().trim()) != 0) {
                    if (go_fnc_operaciones_campos.campo_blanco(OBJ_pds.TXT_descripcion)) {
                        resp = true;
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO UBIGEO");
                        OBJ_pds.TXT_ubigeo.requestFocus();
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "CODIGO UBIGEO NO EXISTE");
                    OBJ_pds.TXT_ubigeo.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE DIRECCION");
                OBJ_pds.TXT_direccion.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE SUCURSAL");
            OBJ_pds.TXT_nombre.requestFocus();
        }
        return resp;
    }

    public boolean verifica_cambios(BEAN_sucursal OBJ_bsu, pnl_datos_sucursal OBJ_pds) {
        boolean resp = false;
        if (OBJ_bsu.getNombre().equalsIgnoreCase(OBJ_pds.TXT_nombre.getText().trim())) {
            if (OBJ_bsu.getDireccion().equalsIgnoreCase(OBJ_pds.TXT_direccion.getText().trim())) {
                if (OBJ_bsu.getNota().equalsIgnoreCase(OBJ_pds.TXT_nota.getText().trim())) {
                    if (OBJ_bsu.getStatus().equalsIgnoreCase(OBJ_pds.CBX_estado.getSelectedIndex() + "")) {
                        if (OBJ_bsu.getUbigeo().equalsIgnoreCase(OBJ_pds.TXT_ubigeo.getText().trim())) {
                            if (OBJ_bsu.getDescripcion().equalsIgnoreCase(OBJ_pds.TXT_descripcion.getText().trim())) {
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
        } else {
            resp = true;
        }
        return resp;
    }

    public KeyListener evento_press(pnl_datos_sucursal OBJ_pds, KeyListener KeyEvnt) {
        OBJ_pds.TXT_codigo.addKeyListener(KeyEvnt);
        OBJ_pds.TXT_nombre.addKeyListener(KeyEvnt);
        OBJ_pds.TXT_direccion.addKeyListener(KeyEvnt);
        OBJ_pds.CBX_estado.addKeyListener(KeyEvnt);
        OBJ_pds.TXT_ubigeo.addKeyListener(KeyEvnt);
        OBJ_pds.TXT_nota.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
