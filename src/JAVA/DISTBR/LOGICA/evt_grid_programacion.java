package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.GUI.pnl_grid_programacion;
import JAVA.INVENT.LOGICA.formato_grid_saldos_iniciales;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class evt_grid_programacion {

    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "evt_grid_pedidos";

    public void activa_campos(int op, pnl_grid_programacion OBJ_pgp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pgp.TBL_programacion.setEnabled(valor);
                break;
        }
    }

    public void limpia_tabla(pnl_grid_programacion OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_programacion.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public JButton genera_btn_eliminar() {
        JButton BTN_eliminar = new JButton("x");
        BTN_eliminar.setForeground(new java.awt.Color(204, 0, 51));
        return BTN_eliminar;
    }

    public void agrega_fila(pnl_grid_programacion OBJ_pgp, int fila_s) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_programacion.getModel();
        OBJ_pgp.TBL_programacion.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());
        int fila = OBJ_pgp.TBL_programacion.getRowCount();

        if (fila == (fila_s + 1)) {
            //String item = go_fnc_operaciones_campos.completa_digitos(fila + 1 + "", "0", 3);
            modelo.addRow(new Object[]{"", "", "", "", "", "", "", "", "", "", genera_btn_eliminar()});
            OBJ_pgp.TBL_programacion.changeSelection(fila, 1, false, false);
            //OBJ_pgp.TBL_pedidos.editCellAt(fila, 1);
        } else {
            OBJ_pgp.TBL_programacion.changeSelection(fila_s + 1, 1, false, false);
            //OBJ_pgp.TBL_pedidos.editCellAt(fila_s + 1, 1);
        }
    }
    
    public void elimina_fila(pnl_grid_programacion OBJ_pgp, int fila) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_programacion.getModel();
        modelo.removeRow(fila);
    }
}
