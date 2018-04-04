package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.LOGICA.formato_grid_saldos_iniciales;
import JAVA.VENTAS.GUI.pnl_grid_pedidos_agil;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class evt_grid_pedidos_agil {

    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "evt_grid_pedidos_agil";
    DecimalFormat dFormat;

    public void activa_campos(int op, pnl_grid_pedidos_agil OBJ_pgp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pgp.TBL_pedidos.setEnabled(valor);
                break;
        }
    }

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
            modelo.setValueAt(go_fnc_operaciones_campos.completa_digitos((x + 1) + "", "0", 3), x, 0);
        }
    }

    public void suma_importes(int afecto_igv, double igv_p, boolean es_sigv, pnl_grid_pedidos_agil OBJ_pgp, String codigo_td) {
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
                        total = total + Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 12).toString());
                        percepcion_s = 0.00;
                        inafecto = 0.00;
                        igv_s = 0.00;
                        afecto_s = 0.00;
                    }
                    break;
                case 1:
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        if ((boolean) OBJ_pgp.TBL_pedidos.getValueAt(i, 7) == false) {
                            inafecto = go_fnc_operaciones_campos.redondea(inafecto + Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 12).toString()), 2);
                            percepcion = go_fnc_operaciones_campos.redondea((Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 8).toString()) / 100) * Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 12).toString()), 2);
                            percepcion_s = percepcion_s + percepcion;
                        } else {
                            afecto = afecto + Double.parseDouble(OBJ_pgp.TBL_pedidos.getValueAt(i, 12).toString());
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
                    total = total + inafecto;
                    break;
            }
            //total = total + inafecto + afecto_s + igv_s;
            importe = total + percepcion_s;
            OBJ_pgp.LBL_total.setText(dFormat.format(total) + "");
            OBJ_pgp.LBL_inafecto.setText(dFormat.format(inafecto) + "");
            OBJ_pgp.LBL_afecto.setText(dFormat.format(afecto_s) + "");
            OBJ_pgp.LBL_igv.setText(dFormat.format(igv_s) + "");
            OBJ_pgp.LBL_percepcion.setText(dFormat.format(percepcion_s) + "");
            OBJ_pgp.LBL_importe.setText(dFormat.format(importe) + "");

            //activar en BOLETA
            /*if (codigo_td.equalsIgnoreCase("03") && importe >= 700) {
                OBJ_pgp.LBL_aviso.setText("MONTO MAYOR A 700 INGRESAR NOMBRE COMPLETO y DNI");
            } else {
                OBJ_pgp.LBL_aviso.setText("");
            }*/
        } catch (Exception e) {
        }
    }

    public void elimina_fila(pnl_grid_pedidos_agil OBJ_pgp, int fila) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        modelo.removeRow(fila);
    }

    public KeyListener evento_press(pnl_grid_pedidos_agil OBJ_pgp, KeyListener KeyEvnt) {
        OBJ_pgp.TBL_pedidos.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public MouseListener mouse_click(pnl_grid_pedidos_agil OBJ_pgp, MouseListener MouseEvnt) {
        OBJ_pgp.TBL_pedidos.addMouseListener(MouseEvnt);
        return MouseEvnt;
    }
}
