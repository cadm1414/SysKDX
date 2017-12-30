package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.GUI.pnl_grid_programacion;
import JAVA.INVENT.LOGICA.formato_grid_saldos_iniciales;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
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
            String item = go_fnc_operaciones_campos.completa_digitos(fila + 1 + "", "0", 3);
            modelo.addRow(new Object[]{"", item, null, "", "", "", "", "", "", "", "", genera_btn_eliminar()});
            OBJ_pgp.TBL_programacion.changeSelection(fila, 2, false, false);
            //OBJ_pgp.TBL_pedidos.editCellAt(fila, 1);
        } else {
            OBJ_pgp.TBL_programacion.changeSelection(fila_s + 1, 2, false, false);
            //OBJ_pgp.TBL_pedidos.editCellAt(fila_s + 1, 1);
        }
    }

    public void genera_item(pnl_grid_programacion OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_programacion.getModel();
        for (int x = 0; x < OBJ_pgp.TBL_programacion.getRowCount(); x++) {
            modelo.setValueAt(go_fnc_operaciones_campos.completa_digitos((x + 1) + "", "0", 3), x, 1);
        }
    }

    public void recupera_detalle(ResultSet rs, pnl_grid_programacion OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_programacion.getModel();
        OBJ_pgp.TBL_programacion.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());
        int a = 0;
        if (rs != null) {
            try {
                do {
                    modelo.addRow(new Object[]{"", "", null, "", "", "", "", "", "", "", "", genera_btn_eliminar()});
                    OBJ_pgp.TBL_programacion.setValueAt(rs.getString(3), a, 0);
                    OBJ_pgp.TBL_programacion.setValueAt(rs.getString(2), a, 1);
                    OBJ_pgp.TBL_programacion.setValueAt(rs.getString(4), a, 2);
                    OBJ_pgp.TBL_programacion.setValueAt(rs.getString(5), a, 3);
                    OBJ_pgp.TBL_programacion.setValueAt(rs.getString(6), a, 4);
                    OBJ_pgp.TBL_programacion.setValueAt(rs.getString(7), a, 5);
                    OBJ_pgp.TBL_programacion.setValueAt(rs.getString(8), a, 6);
                    OBJ_pgp.TBL_programacion.setValueAt(rs.getString(9), a, 7);
                    OBJ_pgp.TBL_programacion.setValueAt(rs.getString(10), a, 8);
                    OBJ_pgp.TBL_programacion.setValueAt(rs.getString(11), a, 9);
                    OBJ_pgp.TBL_programacion.setValueAt(rs.getString(12), a, 10);
                    a++;
                } while (rs.next());
            } catch (Exception e) {
            }
        }
    }

    public boolean valida_campos(pnl_grid_programacion OBJ_pgp) {
        boolean resp = false;
        int valida = 0;
        if (OBJ_pgp.TBL_programacion.getRowCount() != 0) {
            for (int i = 0; i < OBJ_pgp.TBL_programacion.getRowCount(); i++) {
                if (!OBJ_pgp.TBL_programacion.getValueAt(i, 6).toString().trim().equalsIgnoreCase("")) {
                    resp = true;
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FILA NO CONTIENE DATOS");
                    OBJ_pgp.TBL_programacion.changeSelection(i, 2, false, false);
                    OBJ_pgp.TBL_programacion.requestFocus();
                    valida++;
                    break;
                }
                if (valida != 0) {
                    resp = false;
                    break;
                }
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "DOCUMENTO SIN DETALLE");
            OBJ_pgp.TBL_programacion.requestFocus();
            agrega_fila(OBJ_pgp, -1);
        }
        return resp;
    }

    public void elimina_fila(pnl_grid_programacion OBJ_pgp, int fila) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_programacion.getModel();
        modelo.removeRow(fila);
    }

    public KeyListener evento_press(pnl_grid_programacion OBJ_pgp, KeyListener KeyEvnt) {
        OBJ_pgp.TBL_programacion.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
