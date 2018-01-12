package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CTACOB.LOGICA.formato_grid_recibo_cobranza;
import JAVA.DISTBR.GUI.pnl_grid_liquidacion;
import JAVA.INVENT.LOGICA.formato_grid_saldos_iniciales;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class evt_grid_liquidacion {

    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    DecimalFormat dFormat;
    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "evt_grid_pedidos";

    public void activa_campos(int op, pnl_grid_liquidacion OBJ_pgp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pgp.TBL_liquidacion.setEnabled(valor);
                break;
        }
    }

    public JButton genera_btn_eliminar() {
        JButton BTN_eliminar = new JButton("x");
        BTN_eliminar.setForeground(new java.awt.Color(204, 0, 51));
        return BTN_eliminar;
    }

    public void agrega_fila(pnl_grid_liquidacion OBJ_pgp, int fila_s) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_liquidacion.getModel();
        OBJ_pgp.TBL_liquidacion.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());
        OBJ_pgp.TBL_liquidacion.setDefaultRenderer(Double.class, new formato_grid_recibo_cobranza());
        int fila = OBJ_pgp.TBL_liquidacion.getRowCount();

        if (fila == (fila_s + 1)) {
            String item = go_fnc_operaciones_campos.completa_digitos(fila + 1 + "", "0", 3);
            modelo.addRow(new Object[]{"", item, "", "", "", null, true, false, 0.00, 0.00, 0.00, genera_btn_eliminar()});
            OBJ_pgp.TBL_liquidacion.changeSelection(fila, 3, false, false);
            //OBJ_pgp.TBL_pedidos.editCellAt(fila, 1);
        } else {
            OBJ_pgp.TBL_liquidacion.changeSelection(fila_s + 1, 3, false, false);
            //OBJ_pgp.TBL_pedidos.editCellAt(fila_s + 1, 1);
        }
    }

    public void suma_importes(pnl_grid_liquidacion OBJ_pgp) {
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        dFormat = new DecimalFormat("#,##0.00", simbolos);
        double total_ef = 0, total_cr = 0, total_ds = 0;
        try {
            DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_liquidacion.getModel();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                total_ds = total_ds + Double.parseDouble(OBJ_pgp.TBL_liquidacion.getValueAt(i, 9).toString());
                total_cr = total_cr + Double.parseDouble(OBJ_pgp.TBL_liquidacion.getValueAt(i, 10).toString());
                total_ef = total_ef + Double.parseDouble(OBJ_pgp.TBL_liquidacion.getValueAt(i, 8).toString());
            }

            OBJ_pgp.LBL_desc.setText(dFormat.format(total_ds) + "");
            OBJ_pgp.LBL_cr.setText(dFormat.format(total_cr) + "");
            OBJ_pgp.LBL_ef.setText(dFormat.format(total_ef) + "");
        } catch (Exception e) {
        }

    }

    public void limpia_tabla(pnl_grid_liquidacion OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_liquidacion.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    public boolean valida_campos(pnl_grid_liquidacion OBJ_pgp) {
        boolean resp = false;
        int valida = 0;
        if (OBJ_pgp.TBL_liquidacion.getRowCount() != 0) {
            for (int i = 0; i < OBJ_pgp.TBL_liquidacion.getRowCount(); i++) {
                if (!OBJ_pgp.TBL_liquidacion.getValueAt(i, 5).toString().trim().equalsIgnoreCase("")) {
                    resp = true;
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FILA NO CONTIENE DATOS");
                    OBJ_pgp.TBL_liquidacion.changeSelection(i, 2, false, false);
                    OBJ_pgp.TBL_liquidacion.requestFocus();
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
            OBJ_pgp.TBL_liquidacion.requestFocus();
            agrega_fila(OBJ_pgp, -1);
        }
        return resp;
    }

    public void genera_item(pnl_grid_liquidacion OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_liquidacion.getModel();
        for (int x = 0; x < OBJ_pgp.TBL_liquidacion.getRowCount(); x++) {
            modelo.setValueAt(go_fnc_operaciones_campos.completa_digitos((x + 1) + "", "0", 3), x, 1);
        }
    }

    public void elimina_fila(pnl_grid_liquidacion OBJ_pgp, int fila) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_liquidacion.getModel();
        modelo.removeRow(fila);
    }

    public KeyListener evento_press(pnl_grid_liquidacion OBJ_pgp, KeyListener KeyEvnt) {
        OBJ_pgp.TBL_liquidacion.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
