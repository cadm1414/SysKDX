package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
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
                OBJ_pdd.BTN_agregar.setEnabled(false);
                break;
            case 1:
                OBJ_pdd.TXT_nombre_direccion.setEnabled(valor);
                OBJ_pdd.TXT_direccion.setEnabled(valor);
                OBJ_pdd.TXT_codigo_ubigeo.setEnabled(valor);
                OBJ_pdd.TXT_referencia.setEnabled(valor);
                OBJ_pdd.CBX_tipo_direccion.setEnabled(valor);
                OBJ_pdd.BTN_agregar.setEnabled(valor);
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
    
    public KeyListener evento_press(pnl_datos_direccion OBJ_pdd, KeyListener KeyEvnt) {
        
        return KeyEvnt;
    }
    
    public ActionListener evento_click(pnl_datos_direccion OBJ_pdd, ActionListener Listener) {
        OBJ_pdd.BTN_nuevo.addActionListener(Listener);
        OBJ_pdd.BTN_agregar.addActionListener(Listener);
        OBJ_pdd.BTN_eliminar.addActionListener(Listener);
        OBJ_pdd.BTN_editar.addActionListener(Listener);
        return Listener;
    }
    
}
