package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.GUI.pnl_grid_saldos_iniciales;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class evt_grid_saldos_iniciales {

    ResultSet lq_rs;
    String ls_modulo = "INVENT", ls_capa = "LOGICA", ls_clase = "evt_grid_saldos_iniciales";

    public void activa_campos(int op, pnl_grid_saldos_iniciales OBJ_pgs, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pgs.TBL_saldos_iniciales.setEnabled(valor);
                break;
        }
    }

    public JButton genera_btn_eliminar() {
        JButton BTN_eliminar = new JButton("x");
        return BTN_eliminar;
    }

    public void agrega_fila(pnl_grid_saldos_iniciales OBJ_pgs, int fila_s) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgs.TBL_saldos_iniciales.getModel();
        OBJ_pgs.TBL_saldos_iniciales.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());

        int fila = OBJ_pgs.TBL_saldos_iniciales.getRowCount();

        if (fila == (fila_s + 1)) {
            String item = go_fnc_operaciones_campos.completa_digitos(fila + 1 + "", "0", 3);
            modelo.addRow(new Object[]{item, "", "", "", "", "", "", 0, 0, 0, 0, genera_btn_eliminar()});
            OBJ_pgs.TBL_saldos_iniciales.changeSelection(fila, 1, false, false);
            OBJ_pgs.TBL_saldos_iniciales.editCellAt(fila, 1);
        } else {
            OBJ_pgs.TBL_saldos_iniciales.changeSelection(fila_s + 1, 1, false, false);
            OBJ_pgs.TBL_saldos_iniciales.editCellAt(fila_s + 1, 1);
        }

    }
    
    public void elimina_fila(pnl_grid_saldos_iniciales OBJ_pgs, int fila) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgs.TBL_saldos_iniciales.getModel();
        modelo.removeRow(fila);        
    }

    public void genera_item(pnl_grid_saldos_iniciales OBJ_pgs){
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgs.TBL_saldos_iniciales.getModel();
        for(int x = 0; x < OBJ_pgs.TBL_saldos_iniciales.getRowCount(); x++){
            modelo.setValueAt(go_fnc_operaciones_campos.completa_digitos((x+1)+"", "0", 3), x, 0);
        }
    }
    
    public KeyListener evento_press(pnl_grid_saldos_iniciales OBJ_pdc, KeyListener KeyEvnt) {
        OBJ_pdc.TBL_saldos_iniciales.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
