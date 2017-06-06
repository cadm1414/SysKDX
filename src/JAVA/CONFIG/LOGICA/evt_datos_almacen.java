package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_almacen;
import JAVA.CONFIG.GUI.pnl_datos_almacen;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_almacen {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_almacen";

    public void activa_campos(int op, pnl_datos_almacen OBJ_pda, boolean valor) {
        switch (op) {
            case 0:
                //OBJ_pds.TXT_codigo.setEnabled(valor);
                OBJ_pda.TXT_nombre_almacen.setEnabled(valor);
                OBJ_pda.TXT_direccion_almacen.setEnabled(valor);
                OBJ_pda.CBX_estado.setEnabled(valor);
                OBJ_pda.CBX_tipo_almacen.setEnabled(valor);
                OBJ_pda.CBX_sucursal.setEnabled(valor);
                OBJ_pda.TXT_ubigeo.setEnabled(valor);
                OBJ_pda.TXT_nota.setEnabled(valor);
                OBJ_pda.TXT_nombre_almacen.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_almacen OBJ_pda) {
        OBJ_pda.TXT_codigo_almacen.setText("");
        OBJ_pda.TXT_nombre_almacen.setText("");
        OBJ_pda.TXT_direccion_almacen.setText("");
        OBJ_pda.TXT_ubigeo.setText("");
        OBJ_pda.TXT_descripcion.setText("");
        OBJ_pda.TXT_nota.setText("");
    }

    public void muestra_datos(pnl_datos_almacen OBJ_pda, BEAN_almacen OBJ_bal) {
        OBJ_pda.TXT_codigo_almacen.setText(OBJ_bal.getCodigo_almacen());
        OBJ_pda.TXT_nombre_almacen.setText(OBJ_bal.getNombre());
        OBJ_pda.TXT_direccion_almacen.setText(OBJ_bal.getDireccion());
        OBJ_pda.CBX_estado.setSelectedIndex(Integer.parseInt(OBJ_bal.getStatus()));
        OBJ_pda.TXT_ubigeo.setText(OBJ_bal.getUbigeo());
        OBJ_pda.TXT_descripcion.setText(OBJ_bal.getDescripcion());
        OBJ_pda.TXT_nota.setText(OBJ_bal.getNota());
        go_cbx_trato_datos.selecciona_valor(2, OBJ_bal.getCodigo_sucursal(), OBJ_pda.CBX_sucursal);
    }

    public void setea_recupera(BEAN_almacen OBJ_bal, ResultSet lq_rs) {
        try {
            OBJ_bal.setCodigo_almacen(lq_rs.getString(1));
            OBJ_bal.setNombre(lq_rs.getString(2));
            OBJ_bal.setDireccion(lq_rs.getString(3));
            OBJ_bal.setNota(lq_rs.getString(4));
            OBJ_bal.setStatus(lq_rs.getString(5));
            OBJ_bal.setUbigeo(lq_rs.getString(6));
            OBJ_bal.setDescripcion(lq_rs.getString(7));
            OBJ_bal.setTipo_almacen(lq_rs.getString(8));
            OBJ_bal.setCodigo_sucursal(lq_rs.getString(9));
        } catch (Exception e) {
        }
    }

    public void setea_campos(BEAN_almacen OBJ_bal, pnl_datos_almacen OBJ_pda, cbx_sucursal cbx_sucursal) {
        try {
            OBJ_bal.setCodigo_almacen(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_codigo_almacen));
            OBJ_bal.setNombre(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_nombre_almacen));
            OBJ_bal.setDireccion(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_direccion_almacen));
            OBJ_bal.setNota(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_nota));
            OBJ_bal.setStatus(OBJ_pda.CBX_estado.getSelectedIndex() + "");
            OBJ_bal.setTipo_almacen(OBJ_pda.CBX_tipo_almacen.getSelectedIndex() + "");
            OBJ_bal.setCodigo_sucursal(cbx_sucursal.getID());
            OBJ_bal.setUbigeo(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_ubigeo));
            OBJ_bal.setDescripcion(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_descripcion));
        } catch (Exception e) {
        }
    }

    public boolean valida_campos(pnl_datos_almacen OBJ_dpa) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_dpa.TXT_nombre_almacen) && go_fnc_operaciones_campos.cant_caracter(OBJ_dpa.TXT_nombre_almacen.getText().trim(), 1, 4)) {
            if (go_fnc_operaciones_campos.campo_blanco(OBJ_dpa.TXT_direccion_almacen) && go_fnc_operaciones_campos.cant_caracter(OBJ_dpa.TXT_direccion_almacen.getText().trim(), 1, 4)) {
                if (go_dao_ubigeo.SLT_cta_ubigeo_x_codigo(OBJ_dpa.TXT_ubigeo.getText().trim()) != 0) {
                    if (go_fnc_operaciones_campos.campo_blanco(OBJ_dpa.TXT_descripcion)) {
                        resp = true;
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO UBIGEO");
                        OBJ_dpa.TXT_ubigeo.requestFocus();
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "CODIGO UBIGEO NO EXISTE");
                    OBJ_dpa.TXT_ubigeo.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE DIRECCION");
                OBJ_dpa.TXT_direccion_almacen.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DE ALMACEN");
            OBJ_dpa.TXT_nombre_almacen.requestFocus();
        }
        return resp;
    }

    public boolean verifica_cambios(BEAN_almacen OBJ_bal, pnl_datos_almacen OBJ_pda, cbx_sucursal cbx_sucursal) {
        boolean resp = false;
        if (OBJ_bal.getNombre().equalsIgnoreCase(OBJ_pda.TXT_nombre_almacen.getText().trim())) {
            if (OBJ_bal.getDireccion().equalsIgnoreCase(OBJ_pda.TXT_direccion_almacen.getText().trim())) {
                if (OBJ_bal.getNota().equalsIgnoreCase(OBJ_pda.TXT_nota.getText().trim())) {
                    if (OBJ_bal.getStatus().equalsIgnoreCase(OBJ_pda.CBX_estado.getSelectedIndex() + "")) {
                        if (OBJ_bal.getUbigeo().equalsIgnoreCase(OBJ_pda.TXT_ubigeo.getText().trim())) {
                            if (OBJ_bal.getDescripcion().equalsIgnoreCase(OBJ_pda.TXT_descripcion.getText().trim())) {
                                if (OBJ_bal.getTipo_almacen().equalsIgnoreCase(OBJ_pda.CBX_tipo_almacen.getSelectedIndex() + "")) {
                                    if (OBJ_bal.getCodigo_sucursal().equalsIgnoreCase(cbx_sucursal.getID())) {
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
            } else {
                resp = true;
            }
        } else {
            resp = true;
        }
        return resp;
    }

    public KeyListener evento_press(pnl_datos_almacen OBJ_pda, KeyListener KeyEvnt) {
        OBJ_pda.TXT_codigo_almacen.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_nombre_almacen.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_direccion_almacen.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_estado.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_tipo_almacen.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_sucursal.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_ubigeo.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_nota.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
