package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_entidad_direccion;
import JAVA.CONFIG.GUI.pnl_datos_direccion;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class evt_datos_direccion {

    ResultSet lq_rs;
    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_contacto";

    public void activa_campos(int op, pnl_datos_direccion OBJ_pdd, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pdd.BTN_nuevo.setEnabled(valor);
                OBJ_pdd.BTN_editar.setEnabled(valor);
                OBJ_pdd.BTN_eliminar.setEnabled(valor);
                OBJ_pdd.TBL_direccion.setEnabled(valor);
                OBJ_pdd.TXT_nombre_direccion.setEnabled(false);
                OBJ_pdd.TXT_direccion.setEnabled(false);
                OBJ_pdd.TXT_codigo_ubigeo.setEnabled(false);
                OBJ_pdd.TXT_referencia.setEnabled(false);
                OBJ_pdd.CBX_tipo_direccion.setEnabled(false);
                OBJ_pdd.BTN_guardar.setEnabled(false);
                break;
            case 1:
                OBJ_pdd.TXT_nombre_direccion.setEnabled(valor);
                OBJ_pdd.TXT_direccion.setEnabled(valor);
                OBJ_pdd.TXT_codigo_ubigeo.setEnabled(valor);
                OBJ_pdd.TXT_referencia.setEnabled(valor);
                OBJ_pdd.CBX_tipo_direccion.setEnabled(valor);
                OBJ_pdd.BTN_guardar.setEnabled(valor);
                OBJ_pdd.TXT_nombre_direccion.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_direccion OBJ_pdd) {
        OBJ_pdd.TXT_nombre_direccion.setText("");
        OBJ_pdd.TXT_direccion.setText("");
        OBJ_pdd.TXT_codigo_ubigeo.setText("");
        OBJ_pdd.TXT_descripcion_ubigeo.setText("");
        OBJ_pdd.TXT_referencia.setText("");
        OBJ_pdd.CBX_tipo_direccion.setSelectedIndex(0);
    }

    public void limpia_tabla(pnl_datos_direccion OBJ_pdd) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pdd.TBL_direccion.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void datos_tabla(String codigo_entidad, pnl_datos_direccion OBJ_pdd) {
        int a = 0;
        limpia_tabla(OBJ_pdd);
        DefaultTableModel lm_modelo = (DefaultTableModel) OBJ_pdd.TBL_direccion.getModel();
        try {
            lq_rs = go_dao_entidad_direccion.SLT_grid_entidad_direccion(codigo_entidad);
            if (lq_rs != null) {
                do {
                    lm_modelo.addRow(new Object[]{""});
                    for (int x = 0; x < 4; x++) {
                        OBJ_pdd.TBL_direccion.setValueAt(lq_rs.getString(x + 1), a, x);
                    }
                    a++;
                } while (lq_rs.next());
            }
        } catch (Exception e) {
        }
    }

    public boolean valida_campos(pnl_datos_direccion OBJ_pdd) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.cant_caracter(OBJ_pdd.TXT_nombre_direccion.getText().trim(), 1, 3)) {
            if (go_fnc_operaciones_campos.cant_caracter(OBJ_pdd.TXT_direccion.getText().trim(), 1, 3)) {
                if (go_fnc_operaciones_campos.cant_caracter(OBJ_pdd.TXT_descripcion_ubigeo.getText().trim(), 1, 3) && go_fnc_operaciones_campos.cant_caracter(OBJ_pdd.TXT_codigo_ubigeo.getText().trim(), 1, 6)) {
                    resp = true;
                } else {
                    OBJ_pdd.TXT_codigo_ubigeo.requestFocus();
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE UBIGEO");
                }
            } else {
                OBJ_pdd.TXT_direccion.requestFocus();
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE DIRECCION");
            }
        } else {
            OBJ_pdd.TXT_nombre_direccion.requestFocus();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE DIRECCION");
        }
        return resp;
    }

    public boolean verifica_cambios(BEAN_entidad_direccion OBJ_bal, pnl_datos_direccion OBJ_pdd) {
        boolean resp = false;
        if (OBJ_pdd.TXT_nombre_direccion.getText().trim().equalsIgnoreCase(OBJ_bal.getNombre_direccion()) && OBJ_pdd.TXT_direccion.getText().trim().equalsIgnoreCase(OBJ_bal.getDireccion()) && OBJ_pdd.TXT_codigo_ubigeo.getText().trim().equalsIgnoreCase(OBJ_bal.getCodigo_ubigeo()) && OBJ_pdd.TXT_referencia.getText().trim().equalsIgnoreCase(OBJ_bal.getReferencia())) {
            if (OBJ_pdd.CBX_tipo_direccion.getSelectedIndex() == Integer.parseInt(OBJ_bal.getTipo_direccion())) {

            } else {
                resp = true;
            }
        } else {
            resp = true;
        }
        return resp;
    }

    public void setea_campos(BEAN_entidad_direccion OBJ_bet, pnl_datos_direccion obj_pdd) {
        try {
            OBJ_bet.setNombre_direccion(obj_pdd.TXT_nombre_direccion.getText().trim());
            OBJ_bet.setDireccion(obj_pdd.TXT_direccion.getText().trim());
            OBJ_bet.setCodigo_ubigeo(obj_pdd.TXT_codigo_ubigeo.getText().trim());
            OBJ_bet.setDescripcion_ubigeo(obj_pdd.TXT_descripcion_ubigeo.getText().trim());
            OBJ_bet.setReferencia(obj_pdd.TXT_referencia.getText().trim());
            OBJ_bet.setTipo_direccion(obj_pdd.CBX_tipo_direccion.getSelectedIndex() + "");
        } catch (Exception e) {
        }
    }

    public void muestra_datos(pnl_datos_direccion OBJ_pdd, BEAN_entidad_direccion OBJ_bal) {
        OBJ_pdd.TXT_nombre_direccion.setText(OBJ_bal.getNombre_direccion());
        OBJ_pdd.TXT_direccion.setText(OBJ_bal.getDireccion());
        OBJ_pdd.TXT_codigo_ubigeo.setText(OBJ_bal.getCodigo_ubigeo());
        OBJ_pdd.TXT_descripcion_ubigeo.setText(OBJ_bal.getDescripcion_ubigeo());
        OBJ_pdd.TXT_referencia.setText(OBJ_bal.getReferencia());
        OBJ_pdd.CBX_tipo_direccion.setSelectedIndex(Integer.parseInt(OBJ_bal.getTipo_direccion()));
    }

    public void setea_recupera(BEAN_entidad_direccion OBJ_bet, ResultSet lq_rs) {
        try {
            OBJ_bet.setCodigo_entidad(lq_rs.getString(1));
            OBJ_bet.setCodigo_direccion(lq_rs.getString(2));
            OBJ_bet.setNombre_direccion(lq_rs.getString(3));
            OBJ_bet.setDireccion(lq_rs.getString(4));
            OBJ_bet.setCodigo_ubigeo(lq_rs.getString(5));
            OBJ_bet.setDescripcion_ubigeo(lq_rs.getString(6));
            OBJ_bet.setReferencia(lq_rs.getString(7));
            OBJ_bet.setTipo_direccion(lq_rs.getString(8));
        } catch (Exception e) {
        }
    }

    public KeyListener evento_press(pnl_datos_direccion OBJ_pdd, KeyListener KeyEvnt) {
        OBJ_pdd.TXT_nombre_direccion.addKeyListener(KeyEvnt);
        OBJ_pdd.TXT_direccion.addKeyListener(KeyEvnt);
        OBJ_pdd.TXT_codigo_ubigeo.addKeyListener(KeyEvnt);
        OBJ_pdd.TXT_descripcion_ubigeo.addKeyListener(KeyEvnt);
        OBJ_pdd.TXT_referencia.addKeyListener(KeyEvnt);
        OBJ_pdd.CBX_tipo_direccion.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ActionListener evento_click(pnl_datos_direccion OBJ_pdd, ActionListener Listener) {
        OBJ_pdd.BTN_nuevo.addActionListener(Listener);
        OBJ_pdd.BTN_guardar.addActionListener(Listener);
        OBJ_pdd.BTN_eliminar.addActionListener(Listener);
        OBJ_pdd.BTN_editar.addActionListener(Listener);
        return Listener;
    }

}
