package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.GUI.pnl_grid_guia_ingreso;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class evt_grid_guia_ingreso {

    ResultSet lq_rs;
    String ls_modulo = "INVENT", ls_capa = "LOGICA", ls_clase = "evt_grid_saldos_iniciales";

    public void activa_campos(int op, pnl_grid_guia_ingreso OBJ_pgs, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pgs.TBL_guia_ingreso.setEnabled(valor);
                break;
        }
    }

    public JButton genera_btn_eliminar() {
        JButton BTN_eliminar = new JButton("x");
        BTN_eliminar.setForeground(new java.awt.Color(204, 0, 51));
        return BTN_eliminar;
    }

    public void limpia_tabla(pnl_grid_guia_ingreso OBJ_pgs) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgs.TBL_guia_ingreso.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void agrega_fila(pnl_grid_guia_ingreso OBJ_pgs, int fila_s,String lote) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgs.TBL_guia_ingreso.getModel();
        OBJ_pgs.TBL_guia_ingreso.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());
        
        int fila = OBJ_pgs.TBL_guia_ingreso.getRowCount();

        if (fila == (fila_s + 1)) {
            String item = go_fnc_operaciones_campos.completa_digitos(fila + 1 + "", "0", 3);
            modelo.addRow(new Object[]{item, lote, "", "", "", "", "", null, null, null, null, genera_btn_eliminar()});
            OBJ_pgs.TBL_guia_ingreso.changeSelection(fila, 2, false, false);
            OBJ_pgs.TBL_guia_ingreso.editCellAt(fila, 2);
        } else {
            OBJ_pgs.TBL_guia_ingreso.changeSelection(fila_s + 1, 2, false, false);
            OBJ_pgs.TBL_guia_ingreso.editCellAt(fila_s + 1, 2);            
        }   
        
        actualiza_lote(OBJ_pgs, lote);
    }

    public void recupera_detalle(pnl_grid_guia_ingreso OBJ_pgs, String codigo) {
        int a = 0;
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgs.TBL_guia_ingreso.getModel();
        lq_rs = go_dao_kardex_detalle.SLT_datos_kardex_detalle(codigo);
        if (lq_rs != null) {
            try {
                do {
                    modelo.addRow(new Object[]{""});
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(lq_rs.getString(1), a, 0);
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(lq_rs.getString(2), a, 1);
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(lq_rs.getString(3), a, 2);
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(lq_rs.getString(4), a, 3);
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(lq_rs.getString(5), a, 4);
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(lq_rs.getString(6), a, 5);
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(lq_rs.getString(7), a, 6);
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(lq_rs.getInt(8), a, 7);
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(lq_rs.getDouble(9), a, 8);
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(lq_rs.getDouble(10), a, 9);
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(lq_rs.getDouble(11), a, 10);
                    OBJ_pgs.TBL_guia_ingreso.setValueAt(genera_btn_eliminar(), a, 11);
                    a++;
                } while (lq_rs.next());
                OBJ_pgs.TBL_guia_ingreso.setDefaultRenderer(Object.class, new formato_grid_saldos_iniciales());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void elimina_fila(pnl_grid_guia_ingreso OBJ_pgs, int fila) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgs.TBL_guia_ingreso.getModel();
        modelo.removeRow(fila);
    }

    public void genera_item(pnl_grid_guia_ingreso OBJ_pgs) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgs.TBL_guia_ingreso.getModel();
        for (int x = 0; x < OBJ_pgs.TBL_guia_ingreso.getRowCount(); x++) {
            modelo.setValueAt(go_fnc_operaciones_campos.completa_digitos((x + 1) + "", "0", 3), x, 0);
        }
    }
    
    public void actualiza_lote(pnl_grid_guia_ingreso OBJ_pgs,String lote){
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgs.TBL_guia_ingreso.getModel();
        for (int x = 0; x < OBJ_pgs.TBL_guia_ingreso.getRowCount(); x++) {
            modelo.setValueAt(lote, x, 1);
        }
    }

    public boolean valida_campos(pnl_grid_guia_ingreso OBJ_pgs,String lote_auto) {
        boolean resp = false;
        int valida = 0;
        if (OBJ_pgs.TBL_guia_ingreso.getRowCount() != 0) {
            for (int i = 0; i < OBJ_pgs.TBL_guia_ingreso.getRowCount(); i++) {
                for (int x = 0; x < OBJ_pgs.TBL_guia_ingreso.getColumnCount(); x++) {
                    if (OBJ_pgs.TBL_guia_ingreso.getValueAt(i, x) != null) {
                        if (!OBJ_pgs.TBL_guia_ingreso.getValueAt(i, x).toString().trim().equalsIgnoreCase("")) {
                            if (x == 1) {
                                String lote = OBJ_pgs.TBL_guia_ingreso.getValueAt(i, x).toString().trim();
                                if (go_fnc_operaciones_campos.cant_caracter(lote, 4, 6) && lote.matches("\\d*")) {
                                    resp = true;
                                } else {
                                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FORMATO DE LOTE INCORRECTO");
                                    OBJ_pgs.TBL_guia_ingreso.setValueAt("", i, 1);
                                    OBJ_pgs.TBL_guia_ingreso.changeSelection(i, 1, false, false);
                                    resp = false;
                                    valida++;
                                    break;
                                }
                            }
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FILA NO CONTIENE DATOS");
                            OBJ_pgs.TBL_guia_ingreso.changeSelection(i, 1, false, false);
                            valida++;
                            resp = false;
                            break;
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FILA NO CONTIENE DATOS");
                        OBJ_pgs.TBL_guia_ingreso.changeSelection(i, 1, false, false);
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
            agrega_fila(OBJ_pgs, -1,lote_auto);
        }
        return resp;
    }

    public KeyListener evento_press(pnl_grid_guia_ingreso OBJ_pdc, KeyListener KeyEvnt) {
        OBJ_pdc.TBL_guia_ingreso.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
