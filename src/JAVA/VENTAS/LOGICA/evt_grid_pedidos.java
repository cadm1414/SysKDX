package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.LOGICA.formato_grid_saldos_iniciales;
import JAVA.VENTAS.GUI.pnl_grid_pedidos;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class evt_grid_pedidos {

    ResultSet lq_rs;
    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    DecimalFormat dFormat;
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
        OBJ_pgp.LBL_total.setText("0.00");
        OBJ_pgp.LBL_inafecto.setText("0.00");
        OBJ_pgp.LBL_afecto.setText("0.00");
        OBJ_pgp.LBL_igv.setText("0.00");
        OBJ_pgp.LBL_importe.setText("0.00");
        OBJ_pgp.LBL_percepcion.setText("0.00");
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

    public void suma_importes(int afecto_igv, double igv_p, boolean es_sigv, pnl_grid_pedidos OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        dFormat = new DecimalFormat("#,##0.00", simbolos);
        double importe = 0.0, inafecto = 0.0, total = 0.0, percepcion = 0.0, afecto = 0.0, igv = 0.0, afecto_s = 0.0, igv_s = 0.0;
        dFormat.format(total);
        try {
            switch (afecto_igv) {
                case 0:
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        total = total + Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 11).toString());
                        percepcion = percepcion + ((Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 7).toString())/100)*Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 11).toString()));
                    }
                    break;
                case 1:
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        percepcion = percepcion + ((Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 7).toString())/100)*Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 11).toString()));
                        if ((boolean) OBJ_pgp.TBL_pedidos.getValueAt(i, 6) == false) {
                            inafecto = inafecto + Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 11).toString());
                        } else {
                            if (es_sigv == false) {
                                afecto = Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 11).toString()) / (igv_p + 1);
                            } else {
                                afecto = Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 11).toString());
                            }
                            igv = afecto * igv_p;
                            afecto_s = afecto_s + afecto;
                            igv_s = igv_s + igv;
                        }
                    }
                    break;
            }
        } catch (Exception e) {
        }

        total = total + inafecto + afecto_s + igv_s;
        importe = total + percepcion;
        OBJ_pgp.LBL_total.setText(dFormat.format(total) + "");
        OBJ_pgp.LBL_inafecto.setText(dFormat.format(inafecto) + "");
        OBJ_pgp.LBL_afecto.setText(dFormat.format(afecto_s) + "");
        OBJ_pgp.LBL_igv.setText(dFormat.format(igv_s) + "");
        OBJ_pgp.LBL_percepcion.setText(dFormat.format(percepcion) + "");
        OBJ_pgp.LBL_importe.setText(dFormat.format(importe) + "");
    }
    
    public void elimina_fila(pnl_grid_pedidos OBJ_pgp, int fila) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        modelo.removeRow(fila);
    }

    public void genera_item(pnl_grid_pedidos OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        for (int x = 0; x < OBJ_pgp.TBL_pedidos.getRowCount(); x++) {
            modelo.setValueAt(go_fnc_operaciones_campos.completa_digitos((x + 1) + "", "0", 3), x, 0);
        }
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
