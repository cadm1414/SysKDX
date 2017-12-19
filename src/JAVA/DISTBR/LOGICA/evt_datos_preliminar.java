package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.GUI.pnl_datos_preliminar;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class evt_datos_preliminar {

    ResultSet lq_rs;

    public void limpia_tabla(pnl_datos_preliminar OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedido.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void recupera_detalle(String codigo_vendedor, String codigo, pnl_datos_preliminar OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedido.getModel();
        int a = 0;
        lq_rs = go_dao_pedido.SLT_grid_preliminar(codigo_vendedor, codigo);
        try {
            if (lq_rs != null) {
                do {
                    modelo.addRow(new Object[]{""});
                    OBJ_pgp.TBL_pedido.setValueAt(lq_rs.getString(1), a, 0);
                    OBJ_pgp.TBL_pedido.setValueAt(lq_rs.getString(2), a, 1);
                    OBJ_pgp.TBL_pedido.setValueAt(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(3)), a, 2);
                    OBJ_pgp.TBL_pedido.setValueAt(lq_rs.getString(4), a, 3);
                    OBJ_pgp.TBL_pedido.setValueAt(lq_rs.getString(5), a, 4);
                    OBJ_pgp.TBL_pedido.setValueAt(lq_rs.getString(6), a, 5);
                    OBJ_pgp.TBL_pedido.setValueAt(lq_rs.getString(7), a, 6);
                    OBJ_pgp.TBL_pedido.setValueAt(lq_rs.getString(8), a, 7);
                    OBJ_pgp.TBL_pedido.setValueAt(false, a, 8);
                    a++;
                } while (lq_rs.next());
            }
        } catch (Exception e) {

        }
    }

    public void selecciona_todo(boolean valor, pnl_datos_preliminar OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedido.getModel();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            OBJ_pgp.TBL_pedido.setValueAt(valor, i, 8);
        }

    }

    public void cuenta_seleccion(pnl_datos_preliminar OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedido.getModel();
        int cont = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if ((boolean) OBJ_pgp.TBL_pedido.getValueAt(i, 8)) {
                cont++;
            }
        }
        OBJ_pgp.LBL_contador.setText(cont + "");
    }

    public String genera_codigo(pnl_datos_preliminar OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedido.getModel();
        String codigo = "";
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if ((boolean) OBJ_pgp.TBL_pedido.getValueAt(i, 8)) {
                codigo = codigo + "'" + OBJ_pgp.TBL_pedido.getValueAt(i, 0).toString() + "'";
                if ((i + 1) < modelo.getRowCount()) {
                    codigo = codigo +",";
                }
            }
        }
        return codigo;
    }
    
    public String genera_pedidos(pnl_datos_preliminar OBJ_pgp) {
         DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedido.getModel();
        String codigo = "";
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if ((boolean) OBJ_pgp.TBL_pedido.getValueAt(i, 8)) {
                codigo = codigo + OBJ_pgp.TBL_pedido.getValueAt(i, 3).toString() ;
                if ((i + 1) < modelo.getRowCount()) {
                    codigo = codigo +",";
                }
            }
        }
        return codigo;
    }

    public ActionListener evento_click(pnl_datos_preliminar OBJ_pcp, ActionListener Listener) {
        OBJ_pcp.BTN_imprimir.addActionListener(Listener);
        return Listener;
    }

    public KeyListener evento_press(pnl_datos_preliminar OBJ_pcp, KeyListener KeyEvnt) {
        OBJ_pcp.CBX_codigo.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_tipo_busqueda.addKeyListener(KeyEvnt);
        OBJ_pcp.JRD_todos.addKeyListener(KeyEvnt);
        OBJ_pcp.BTN_imprimir.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_fecha_reparto.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_datos_preliminar OBJ_pcp, ItemListener ItemEvent) {
        OBJ_pcp.CBX_tipo_busqueda.addItemListener(ItemEvent);
        OBJ_pcp.CBX_codigo.addItemListener(ItemEvent);
        OBJ_pcp.JRD_todos.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
