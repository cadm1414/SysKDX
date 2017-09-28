package JAVA.CTACOB.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CTACOB.GUI.pnl_grid_recibo_cobranza;
import JAVA.INVENT.LOGICA.formato_grid_saldos_iniciales;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class evt_grid_recibo_cobranza {

    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    DecimalFormat dFormat;
    String ls_modulo = "CTACOB", ls_capa = "LOGICA", ls_clase = "evt_grid_recibo_cobranza";

    public void activa_campos(int op, pnl_grid_recibo_cobranza OBJ_pgp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pgp.TBL_cobranza.setEnabled(valor);
                break;
        }
    }

    public JButton genera_btn_eliminar() {
        JButton BTN_eliminar = new JButton("x");
        BTN_eliminar.setForeground(new java.awt.Color(204, 0, 51));
        return BTN_eliminar;
    }

    public void suma_importes(pnl_grid_recibo_cobranza OBJ_pgp) {
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        dFormat = new DecimalFormat("#,##0.00", simbolos);
        double total = 0;
        try {
            DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_cobranza.getModel();
            for (int i = 0; i < modelo.getRowCount(); i++) {
                total = total + Double.parseDouble(OBJ_pgp.TBL_cobranza.getValueAt(i, 9).toString());
            }
            OBJ_pgp.LBL_total_pago.setText(dFormat.format(total) + "");
        } catch (Exception e) {
        }

    }

    public void agrega_fila(pnl_grid_recibo_cobranza OBJ_pgp, int fila_s, int cantidad) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_cobranza.getModel();
        OBJ_pgp.TBL_cobranza.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());
        OBJ_pgp.TBL_cobranza.setDefaultRenderer(Double.class, new formato_grid_recibo_cobranza());
        int fila = OBJ_pgp.TBL_cobranza.getRowCount();

        if (fila == (fila_s + 1)) {
            if (fila < cantidad) {
                String item = go_fnc_operaciones_campos.completa_digitos(fila + 1 + "", "0", 3);
                modelo.addRow(new Object[]{"", "", item, "", "", "", "", "", null, 0.00, null, genera_btn_eliminar()});
                OBJ_pgp.TBL_cobranza.changeSelection(fila, 3, false, false);
                OBJ_pgp.TBL_cobranza.editCellAt(fila, 3);
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "agrega_fila", "NO SE PUEDE EXEDER DE " + cantidad + " ITEMS");
            }
        } else {
            OBJ_pgp.TBL_cobranza.changeSelection(fila_s + 1, 3, false, false);
            OBJ_pgp.TBL_cobranza.editCellAt(fila_s + 1, 3);
        }

    }

    public void limpia_tabla(pnl_grid_recibo_cobranza OBJ_pgp, int op) {
        if (op != 2) {
            OBJ_pgp.LBL_total_pago.setText("0.00");
        }
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_cobranza.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void elimina_fila(pnl_grid_recibo_cobranza OBJ_pgp, int fila) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_cobranza.getModel();
        modelo.removeRow(fila);
    }

    public void genera_item(pnl_grid_recibo_cobranza OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_cobranza.getModel();
        for (int x = 0; x < OBJ_pgp.TBL_cobranza.getRowCount(); x++) {
            modelo.setValueAt(go_fnc_operaciones_campos.completa_digitos((x + 1) + "", "0", 3), x, 2);
        }
    }

    public boolean valida_campos(pnl_grid_recibo_cobranza OBJ_pgp, int cantidad) {
        boolean resp = false;
        int valida = 0;
        if (OBJ_pgp.TBL_cobranza.getRowCount() != 0) {
            for (int i = 0; i < OBJ_pgp.TBL_cobranza.getRowCount(); i++) {
                for (int x = 1; x < OBJ_pgp.TBL_cobranza.getColumnCount() - 2; x++) {
                    if (OBJ_pgp.TBL_cobranza.getValueAt(i, x) != null) {
                        if (!OBJ_pgp.TBL_cobranza.getValueAt(i, x).toString().trim().equalsIgnoreCase("")) {
                            if (x == 9) {
                                if (Double.parseDouble(OBJ_pgp.TBL_cobranza.getValueAt(i, x).toString().trim()) > -1) {
                                    resp = true;
                                } else {
                                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "PAGO NO PUEDE SER MENOR y/o IGUAL A CERO");
                                    OBJ_pgp.TBL_cobranza.setValueAt(0.00, i, 9);
                                    OBJ_pgp.TBL_cobranza.changeSelection(i, 9, false, false);
                                    resp = false;
                                    valida++;
                                    break;
                                }
                            }
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FILA NO CONTIENE DATOS");
                            OBJ_pgp.TBL_cobranza.changeSelection(i, 2, false, false);
                            valida++;
                            resp = false;
                            break;
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FILA NO CONTIENE DATOS");
                        OBJ_pgp.TBL_cobranza.changeSelection(i, 2, false, false);
                        valida++;
                        resp = false;
                        break;
                    }
                }
                if (valida != 0) {
                    resp = false;
                    break;
                }
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "DOCUMENTO SIN DETALLE");
            agrega_fila(OBJ_pgp, -1, cantidad);
        }
        return resp;
    }

    public void recupera_detalle(ResultSet rs, pnl_grid_recibo_cobranza OBJ_pgp) {
        int a = 0;
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_cobranza.getModel();
        OBJ_pgp.TBL_cobranza.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());
        OBJ_pgp.TBL_cobranza.setDefaultRenderer(Double.class, new formato_grid_recibo_cobranza());
        if (rs != null) {
            try {
                do {   
                    modelo.addRow(new Object[]{"", "", "", "", "", "", "", "", null, 0.00, null, genera_btn_eliminar()});
                    OBJ_pgp.TBL_cobranza.setValueAt(rs.getString(1), a, 0);
                    OBJ_pgp.TBL_cobranza.setValueAt(rs.getString(2), a, 1);
                    OBJ_pgp.TBL_cobranza.setValueAt(rs.getString(3), a, 2);
                    OBJ_pgp.TBL_cobranza.setValueAt(rs.getString(4), a, 3);
                    OBJ_pgp.TBL_cobranza.setValueAt(rs.getString(5), a, 4);
                    OBJ_pgp.TBL_cobranza.setValueAt(rs.getString(6), a, 5);
                    OBJ_pgp.TBL_cobranza.setValueAt(go_fnc_operaciones_campos.recupera_fecha_formato(rs.getString(7)), a, 6);
                    OBJ_pgp.TBL_cobranza.setValueAt(rs.getString(8), a, 7);
                    OBJ_pgp.TBL_cobranza.setValueAt(rs.getDouble(9), a, 8);
                    OBJ_pgp.TBL_cobranza.setValueAt(rs.getDouble(10), a, 9);
                    OBJ_pgp.TBL_cobranza.setValueAt(rs.getDouble(11), a, 10);
                    a++;
                } while (rs.next());
            } catch (Exception e) {
            }
        }
    }

    public KeyListener evento_press(pnl_grid_recibo_cobranza OBJ_pgp, KeyListener KeyEvnt) {
        OBJ_pgp.TBL_cobranza.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
