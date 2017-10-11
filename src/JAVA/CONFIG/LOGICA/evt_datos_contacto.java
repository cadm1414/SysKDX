package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_entidad_contacto;
import JAVA.CONFIG.GUI.pnl_datos_contacto;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class evt_datos_contacto {

    ResultSet lq_rs;
    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_contacto";

    public void activa_campos(int op, pnl_datos_contacto OBJ_pdd, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pdd.BTN_nuevo.setEnabled(valor);
                OBJ_pdd.BTN_editar.setEnabled(valor);
                OBJ_pdd.BTN_eliminar.setEnabled(valor);
                OBJ_pdd.TBL_contacto.setEnabled(valor);
                OBJ_pdd.TXT_nombre_contacto.setEnabled(false);
                OBJ_pdd.TXT_cargo.setEnabled(false);
                OBJ_pdd.TXT_telefono.setEnabled(false);
                OBJ_pdd.TXT_anexo.setEnabled(false);
                OBJ_pdd.TXT_celular.setEnabled(false);
                OBJ_pdd.TXT_email.setEnabled(false);
                OBJ_pdd.BTN_guardar.setEnabled(false);
                break;
            case 1:
                OBJ_pdd.TXT_nombre_contacto.setEnabled(valor);
                OBJ_pdd.TXT_cargo.setEnabled(valor);
                OBJ_pdd.TXT_telefono.setEnabled(valor);
                OBJ_pdd.TXT_anexo.setEnabled(valor);
                OBJ_pdd.TXT_celular.setEnabled(valor);
                OBJ_pdd.TXT_email.setEnabled(valor);
                OBJ_pdd.BTN_guardar.setEnabled(valor);
                OBJ_pdd.TXT_nombre_contacto.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_contacto OBJ_pdd) {
        OBJ_pdd.TXT_nombre_contacto.setText("");
        OBJ_pdd.TXT_cargo.setText("");
        OBJ_pdd.TXT_telefono.setText("");
        OBJ_pdd.TXT_anexo.setText("");
        OBJ_pdd.TXT_celular.setText("");
        OBJ_pdd.TXT_email.setText("");
    }

    public void limpia_tabla(pnl_datos_contacto OBJ_pdd) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pdd.TBL_contacto.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void datos_tabla(String codigo_entidad, pnl_datos_contacto OBJ_pdd) {
        int a = 0;
        limpia_tabla(OBJ_pdd);
        DefaultTableModel lm_modelo = (DefaultTableModel) OBJ_pdd.TBL_contacto.getModel();
        try {
            lq_rs = go_dao_entidad_contacto.SLT_grid_entidad_contacto(codigo_entidad);
            if (lq_rs != null) {
                do {
                    lm_modelo.addRow(new Object[]{""});
                    for (int x = 0; x < 3; x++) {
                        OBJ_pdd.TBL_contacto.setValueAt(lq_rs.getString(x + 1), a, x);
                    }
                    a++;
                } while (lq_rs.next());
            }
        } catch (Exception e) {
        }
    }

    public void setea_campos(BEAN_entidad_contacto OBJ_bet, pnl_datos_contacto obj_pdd) {
        try {
            OBJ_bet.setNombre_contacto(obj_pdd.TXT_nombre_contacto.getText().trim());
            OBJ_bet.setCargo(obj_pdd.TXT_cargo.getText().trim());
            OBJ_bet.setTelefono(obj_pdd.TXT_telefono.getText().trim());
            OBJ_bet.setAnexo(obj_pdd.TXT_anexo.getText().trim());
            OBJ_bet.setCelular(obj_pdd.TXT_celular.getText().trim());
            OBJ_bet.setEmail(obj_pdd.TXT_email.getText().trim() + "");
        } catch (Exception e) {
        }
    }

    public void muestra_datos(pnl_datos_contacto OBJ_pdd, BEAN_entidad_contacto OBJ_bal) {
        OBJ_pdd.TXT_nombre_contacto.setText(OBJ_bal.getNombre_contacto());
        OBJ_pdd.TXT_cargo.setText(OBJ_bal.getCargo());
        OBJ_pdd.TXT_telefono.setText(OBJ_bal.getTelefono());
        OBJ_pdd.TXT_anexo.setText(OBJ_bal.getAnexo());
        OBJ_pdd.TXT_celular.setText(OBJ_bal.getCelular());
        OBJ_pdd.TXT_email.setText(OBJ_bal.getEmail());
    }

    public void setea_recupera(BEAN_entidad_contacto OBJ_bet, ResultSet lq_rs) {
        try {
            OBJ_bet.setCodigo_entidad(lq_rs.getString(1));
            OBJ_bet.setCodigo_contacto(lq_rs.getString(2));
            OBJ_bet.setNombre_contacto(lq_rs.getString(3));
            OBJ_bet.setCargo(lq_rs.getString(4));
            OBJ_bet.setTelefono(lq_rs.getString(5));
            OBJ_bet.setAnexo(lq_rs.getString(6));
            OBJ_bet.setCelular(lq_rs.getString(7));
            OBJ_bet.setEmail(lq_rs.getString(8));
        } catch (Exception e) {
        }
    }

    public boolean valida_campos(pnl_datos_contacto OBJ_pdd) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.cant_caracter(OBJ_pdd.TXT_nombre_contacto.getText().trim(), 1, 3)) {
            if (go_fnc_operaciones_campos.cant_caracter(OBJ_pdd.TXT_cargo.getText().trim(), 1, 3)) {
                resp = true;
            } else {
                OBJ_pdd.TXT_cargo.requestFocus();
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CARGO");
            }
        } else {
            OBJ_pdd.TXT_nombre_contacto.requestFocus();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NOMBRE CONTACTO");
        }
        return resp;
    }
    
    public boolean verifica_cambios(BEAN_entidad_contacto OBJ_bal, pnl_datos_contacto OBJ_pdd) {
        boolean resp = false;
        if (OBJ_pdd.TXT_nombre_contacto.getText().trim().equalsIgnoreCase(OBJ_bal.getNombre_contacto()) && OBJ_pdd.TXT_cargo.getText().trim().equalsIgnoreCase(OBJ_bal.getCargo()) && OBJ_pdd.TXT_telefono.getText().trim().equalsIgnoreCase(OBJ_bal.getAnexo()) && OBJ_pdd.TXT_celular.getText().trim().equalsIgnoreCase(OBJ_bal.getEmail())) {
            
        } else {
            resp = true;
        }
        return resp;
    }

    public KeyListener evento_press(pnl_datos_contacto OBJ_pdd, KeyListener KeyEvnt) {
        OBJ_pdd.TXT_nombre_contacto.addKeyListener(KeyEvnt);
        OBJ_pdd.TXT_cargo.addKeyListener(KeyEvnt);
        OBJ_pdd.TXT_telefono.addKeyListener(KeyEvnt);
        OBJ_pdd.TXT_anexo.addKeyListener(KeyEvnt);
        OBJ_pdd.TXT_celular.addKeyListener(KeyEvnt);
        OBJ_pdd.TXT_email.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ActionListener evento_click(pnl_datos_contacto OBJ_pdd, ActionListener Listener) {
        OBJ_pdd.BTN_nuevo.addActionListener(Listener);
        OBJ_pdd.BTN_guardar.addActionListener(Listener);
        OBJ_pdd.BTN_eliminar.addActionListener(Listener);
        OBJ_pdd.BTN_editar.addActionListener(Listener);
        return Listener;
    }
}
