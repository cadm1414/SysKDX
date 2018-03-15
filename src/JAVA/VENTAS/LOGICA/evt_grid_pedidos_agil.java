package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.LOGICA.formato_grid_saldos_iniciales;
import JAVA.VENTAS.GUI.pnl_grid_pedidos_agil;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class evt_grid_pedidos_agil {
    
    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "evt_grid_pedidos_agil";

    public void limpia_tabla(pnl_grid_pedidos_agil OBJ_pgp, int op) {

        if (op != 2) {
            OBJ_pgp.LBL_total.setText("0.00");
            OBJ_pgp.LBL_inafecto.setText("0.00");
            OBJ_pgp.LBL_afecto.setText("0.00");
            OBJ_pgp.LBL_igv.setText("0.00");
            OBJ_pgp.LBL_importe.setText("0.00");
            OBJ_pgp.LBL_percepcion.setText("0.00");
        }

        OBJ_pgp.LBL_utilidad_p.setText("0.00 %");
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
    
    public boolean agrega_fila(pnl_grid_pedidos_agil OBJ_pgp, int fila_s, int cantidad) {
        boolean resp = false;
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        int fila = OBJ_pgp.TBL_pedidos.getRowCount();
        //boolean es_presentacion = (gs_tipo_comercio.equalsIgnoreCase("0")) ? false : true;
        if (fila == (fila_s + 1)) {
            if (fila < cantidad) {
                String item = go_fnc_operaciones_campos.completa_digitos(fila + 1 + "", "0", 3);
                modelo.addRow(new Object[]{item, false, 0, "", "", 0.00, "", false, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, genera_btn_eliminar(), 1, 0.00, "", ""});
                OBJ_pgp.TBL_pedidos.changeSelection(fila, 1, false, false);
                resp = true;
                //OBJ_pgp.TBL_pedidos.editCellAt(fila, 1);
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "agrega_fila", "NO SE PUEDE EXEDER DE " + cantidad + " ITEMS");                
            }
        } else {
            OBJ_pgp.TBL_pedidos.changeSelection(fila_s + 1, 1, false, false);
            //OBJ_pgp.TBL_pedidos.editCellAt(fila_s + 1, 1);
        }
        OBJ_pgp.TBL_pedidos.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());
        OBJ_pgp.TBL_pedidos.setDefaultRenderer(Double.class, new formato_grid_pedido());
        return resp;
    }
    
    public void genera_item(pnl_grid_pedidos_agil OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        for (int x = 0; x < OBJ_pgp.TBL_pedidos.getRowCount(); x++) {
            if (Integer.parseInt(modelo.getValueAt(x, 0).toString()) < 600) {
                modelo.setValueAt(go_fnc_operaciones_campos.completa_digitos((x + 1) + "", "0", 3), x, 0);
            }
        }
    }

    public KeyListener evento_press(pnl_grid_pedidos_agil OBJ_pgp, KeyListener KeyEvnt) {
        OBJ_pgp.TBL_pedidos.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
