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

    public void limpia_tabla(pnl_grid_pedidos OBJ_pgp, int op) {
        if (op != 2) {
            OBJ_pgp.LBL_total.setText("0.00");
            OBJ_pgp.LBL_inafecto.setText("0.00");
            OBJ_pgp.LBL_afecto.setText("0.00");
            OBJ_pgp.LBL_igv.setText("0.00");
            OBJ_pgp.LBL_importe.setText("0.00");
            OBJ_pgp.LBL_percepcion.setText("0.00");
        }

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

    public void agrega_fila(pnl_grid_pedidos OBJ_pgp, int fila_s, int cantidad) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        OBJ_pgp.TBL_pedidos.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());
        OBJ_pgp.TBL_pedidos.setDefaultRenderer(Double.class, new formato_grid_pedido());
        int fila = OBJ_pgp.TBL_pedidos.getRowCount();
        if (fila < cantidad) {
            if (fila == (fila_s + 1)) {
                String item = go_fnc_operaciones_campos.completa_digitos(fila + 1 + "", "0", 3);
                modelo.addRow(new Object[]{item, 0, "", "", null, "", false, null, null, null, null, null, null, genera_btn_eliminar()});
                OBJ_pgp.TBL_pedidos.changeSelection(fila, 1, false, false);
                OBJ_pgp.TBL_pedidos.editCellAt(fila, 1);
            } else {
                OBJ_pgp.TBL_pedidos.changeSelection(fila_s + 1, 1, false, false);
                OBJ_pgp.TBL_pedidos.editCellAt(fila_s + 1, 1);
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "agrega_fila", "NO SE PUEDE EXEDER DE " + cantidad + " ITEMS");
        }
    }

    public void suma_importes(int afecto_igv, double igv_p, boolean es_sigv, pnl_grid_pedidos OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        dFormat = new DecimalFormat("#,##0.00", simbolos);
        double importe = 0.0, inafecto = 0.0, total = 0.0, percepcion = 0.0, percepcion_s = 0.0, afecto = 0.0, igv = 0.0, afecto_s = 0.0, igv_s = 0.0;
        dFormat.format(total);
        try {
            switch (afecto_igv) {
                case 0:
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        total = total + Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 11).toString());
                        percepcion_s = 0.00;
                        inafecto = 0.00;
                        igv_s = 0.00;
                        afecto_s = 0.00;
                    }
                    break;
                case 1:
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        if ((boolean) OBJ_pgp.TBL_pedidos.getValueAt(i, 6) == false) {
                            inafecto = go_fnc_operaciones_campos.redondea(inafecto + Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 11).toString()), 2);
                            percepcion = go_fnc_operaciones_campos.redondea((Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 7).toString()) / 100) * Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 11).toString()), 2);
                            percepcion_s = percepcion_s + percepcion;
                        } else {
                            afecto = afecto + Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 11).toString());
                        }
                    }
                    if (es_sigv == false) {
                        total = go_fnc_operaciones_campos.redondea(afecto, 2);
                        afecto_s = go_fnc_operaciones_campos.redondea(total / (igv_p + 1), 2);
                        igv_s = go_fnc_operaciones_campos.redondea(total - afecto_s, 2);
                    } else {
                        afecto_s = go_fnc_operaciones_campos.redondea(afecto, 2);
                        igv_s = go_fnc_operaciones_campos.redondea(afecto_s * igv_p, 2);
                        total = afecto_s + igv_s;
                    }

                    break;
            }
        } catch (Exception e) {
        }

        //total = total + inafecto + afecto_s + igv_s;
        importe = total + percepcion_s;
        OBJ_pgp.LBL_total.setText(dFormat.format(total) + "");
        OBJ_pgp.LBL_inafecto.setText(dFormat.format(inafecto) + "");
        OBJ_pgp.LBL_afecto.setText(dFormat.format(afecto_s) + "");
        OBJ_pgp.LBL_igv.setText(dFormat.format(igv_s) + "");
        OBJ_pgp.LBL_percepcion.setText(dFormat.format(percepcion_s) + "");
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

    public boolean valida_campos(pnl_grid_pedidos OBJ_pgp, int cantidad) {
        boolean resp = false;
        int valida = 0;
        if (OBJ_pgp.TBL_pedidos.getRowCount() != 0) {
            for (int i = 0; i < OBJ_pgp.TBL_pedidos.getRowCount(); i++) {
                for (int x = 1; x < OBJ_pgp.TBL_pedidos.getColumnCount() - 2; x++) {
                    if (OBJ_pgp.TBL_pedidos.getValueAt(i, x) != null) {
                        if (!OBJ_pgp.TBL_pedidos.getValueAt(i, x).toString().trim().equalsIgnoreCase("")) {
                            if (x == 8 || x == 10) {
                                if (Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, x).toString().trim()) > -1) {
                                    resp = true;
                                } else {
                                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "PRECIO/PESO INCORRECTOS");
                                    OBJ_pgp.TBL_pedidos.setValueAt("", i, 1);
                                    OBJ_pgp.TBL_pedidos.changeSelection(i, 1, false, false);
                                    resp = false;
                                    valida++;
                                    break;
                                }
                            }
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FILA NO CONTIENE DATOS");
                            OBJ_pgp.TBL_pedidos.changeSelection(i, 1, false, false);
                            valida++;
                            resp = false;
                            break;
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FILA NO CONTIENE DATOS");
                        OBJ_pgp.TBL_pedidos.changeSelection(i, 1, false, false);
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

    public void recupera_detalle(ResultSet rs, pnl_grid_pedidos OBJ_pgp, int es_precio_igv) {
        int a = 0;
        //limpia_tabla(OBJ_pgp, 1);
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        OBJ_pgp.TBL_pedidos.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());
        OBJ_pgp.TBL_pedidos.setDefaultRenderer(Double.class, new formato_grid_pedido());
        if (rs != null) {
            try {
                do {
                    modelo.addRow(new Object[]{null, null, "", "", null, "", false, null, null, null, null, null, null, genera_btn_eliminar()});
                    OBJ_pgp.TBL_pedidos.setValueAt(rs.getString(1), a, 0);
                    OBJ_pgp.TBL_pedidos.setValueAt(rs.getInt(2), a, 1);
                    OBJ_pgp.TBL_pedidos.setValueAt(rs.getString(3), a, 2);
                    OBJ_pgp.TBL_pedidos.setValueAt(rs.getString(4), a, 3);
                    OBJ_pgp.TBL_pedidos.setValueAt(rs.getDouble(5), a, 4);
                    OBJ_pgp.TBL_pedidos.setValueAt(rs.getString(6), a, 5);
                    OBJ_pgp.TBL_pedidos.setValueAt(go_fnc_operaciones_campos.int_boolean(rs.getInt(7)), a, 6);
                    OBJ_pgp.TBL_pedidos.setValueAt(rs.getDouble(8), a, 7);
                    switch (es_precio_igv) {
                        case 0:
                            if (rs.getString(7).equalsIgnoreCase("1")) {
                                OBJ_pgp.TBL_pedidos.setValueAt(rs.getDouble(9), a, 8);
                                OBJ_pgp.TBL_pedidos.setValueAt(rs.getDouble(13), a, 11);
                            } else {
                                OBJ_pgp.TBL_pedidos.setValueAt(rs.getDouble(10), a, 8);
                                OBJ_pgp.TBL_pedidos.setValueAt(rs.getDouble(14), a, 11);
                            }
                            break;
                        case 1:
                            OBJ_pgp.TBL_pedidos.setValueAt(rs.getDouble(10), a, 8);
                            OBJ_pgp.TBL_pedidos.setValueAt(rs.getDouble(14), a, 11);
                            break;
                    }
                    OBJ_pgp.TBL_pedidos.setValueAt(rs.getDouble(11), a, 9);
                    OBJ_pgp.TBL_pedidos.setValueAt(rs.getDouble(12), a, 10);
                    a++;
                } while (rs.next());
            } catch (Exception e) {
            }
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
