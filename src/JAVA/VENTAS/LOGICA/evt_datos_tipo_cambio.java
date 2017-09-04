package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.pnl_datos_tipo_cambio;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class evt_datos_tipo_cambio {

    ResultSet lq_rs;

    public void activa_campos(int op, pnl_datos_tipo_cambio OBJ_pgp, boolean valor, boolean valor_op[]) {
        switch (op) {
            case 0:
                if (valor_op[5]) {
                    OBJ_pgp.CBX_moneda.setEnabled(valor);
                    OBJ_pgp.CBX_mes.setEnabled(valor);
                    OBJ_pgp.BTN_guardar.setEnabled(valor);
                    OBJ_pgp.TBL_tipo_cambio.setEnabled(valor);
                    OBJ_pgp.CBX_moneda.requestFocus();
                }
                break;
        }
    }

    public void limpia_tabla(pnl_datos_tipo_cambio OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_tipo_cambio.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void recupera_detalle(int mes, String moneda, pnl_datos_tipo_cambio OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_tipo_cambio.getModel();
        OBJ_pgp.TBL_tipo_cambio.setDefaultRenderer(Double.class, new formato_grid_tipo_cambio());
        int a = 0;
        lq_rs = go_dao_tipo_cambio.SLT_grid_tipo_cambio(mes, moneda);
        try {
            if (lq_rs != null) {
                do {
                    modelo.addRow(new Object[]{"", null, null});
                    OBJ_pgp.TBL_tipo_cambio.setValueAt(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(2)), a, 0);
                    OBJ_pgp.TBL_tipo_cambio.setValueAt(lq_rs.getDouble(3), a, 1);
                    OBJ_pgp.TBL_tipo_cambio.setValueAt(lq_rs.getDouble(4), a, 2);
                    a++;
                } while (lq_rs.next());
            }
        } catch (Exception e) {

        }
    }

    public ActionListener evento_click(pnl_datos_tipo_cambio OBJ_pop, ActionListener Listener) {
        OBJ_pop.BTN_guardar.addActionListener(Listener);
        return Listener;
    }

    public KeyListener evento_press(pnl_datos_tipo_cambio OBJ_pcp, KeyListener KeyEvnt) {
        OBJ_pcp.CBX_mes.addKeyListener(KeyEvnt);
        OBJ_pcp.CBX_moneda.addKeyListener(KeyEvnt);
        OBJ_pcp.TBL_tipo_cambio.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_datos_tipo_cambio OBJ_pcp, ItemListener ItemEvent) {
        OBJ_pcp.CBX_moneda.addItemListener(ItemEvent);
        OBJ_pcp.CBX_mes.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
