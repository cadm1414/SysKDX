package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.LOGICA.formato_grid_saldos_iniciales;
import JAVA.VENTAS.GUI.pnl_grid_pedidos;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class evt_grid_pedidos {
    
    ResultSet lq_rs;
    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "evt_grid_pedidos";
    
    public void activa_campos(int op, pnl_grid_pedidos OBJ_pgp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pgp.TBL_pedidos.setEnabled(valor);
                OBJ_pgp.JRD_masivo.setEnabled(valor);
                break;
        }
    }
    
    public void limpia_tabla(pnl_grid_pedidos OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    public JButton genera_btn_eliminar() {
        JButton BTN_eliminar = new JButton("x");
        BTN_eliminar.setForeground(new java.awt.Color(204, 0, 51));
        return BTN_eliminar;
    }
    
    public void agrega_fila(pnl_grid_pedidos OBJ_pgp, int fila_s) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        OBJ_pgp.TBL_pedidos.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());
        OBJ_pgp.TBL_pedidos.setDefaultRenderer(Double.class, new formato_grid_pedido());
        
        int fila = OBJ_pgp.TBL_pedidos.getRowCount();
        
        if (fila == (fila_s + 1)) {
            String item = go_fnc_operaciones_campos.completa_digitos(fila + 1 + "", "0", 3);
            modelo.addRow(new Object[]{item, null, "", "", null, "", false, null, null, null, null, null, null, genera_btn_eliminar()});
            OBJ_pgp.TBL_pedidos.changeSelection(fila, 1, false, false);
            OBJ_pgp.TBL_pedidos.editCellAt(fila, 1);
        } else {
            OBJ_pgp.TBL_pedidos.changeSelection(fila_s + 1, 1, false, false);
            OBJ_pgp.TBL_pedidos.editCellAt(fila_s + 1, 1);
        }
        
    }
    
    public void suma_importes(int afecto_igv, int igv, boolean es_sigv, pnl_grid_pedidos OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        double importe = 0.0;
        try {
            if (afecto_igv == 0) {
                for (int i = 0; i > modelo.getRowCount(); i++) {
                    importe = importe + Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(11, i).toString());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        OBJ_pgp.LBL_importe.setText(importe + "");
    }
    
    public KeyListener evento_press(pnl_grid_pedidos OBJ_pgp, KeyListener KeyEvnt) {
        OBJ_pgp.TBL_pedidos.addKeyListener(KeyEvnt);
        OBJ_pgp.JRD_masivo.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
    
    public ItemListener evento_item(pnl_grid_pedidos OBJ_pgp, ItemListener ItemEvent) {
        OBJ_pgp.JRD_masivo.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
