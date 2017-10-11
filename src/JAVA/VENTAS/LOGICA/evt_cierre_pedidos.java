package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.pnl_cierre_pedidos;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class evt_cierre_pedidos {

    ResultSet lq_rs;

    public void activa_campos(int op, pnl_cierre_pedidos OBJ_pgp, boolean valor, boolean valor_op[]) {
        switch (op) {
            case 0:
                if (valor_op[5]) {
                    OBJ_pgp.TXT_codigo.setEnabled(valor);
                    OBJ_pgp.CBX_serie.setEnabled(valor);
                    OBJ_pgp.BTN_guardar.setEnabled(valor);
                    OBJ_pgp.TBL_pedidos.setEnabled(valor);
                }
                break;
        }
    }

    public void limpia_tabla(pnl_cierre_pedidos OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void recupera_detalle(String codigo_sucursal, String serie, pnl_cierre_pedidos OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        OBJ_pgp.TBL_pedidos.setDefaultRenderer(Double.class, new formato_grid_tipo_cambio());
        int a = 0;
        lq_rs = go_dao_pedido.SLT_grid_cierre_pedidos(codigo_sucursal, serie);
        try {
            if (lq_rs != null) {
                do {
                    modelo.addRow(new Object[]{"", "", "", "", "", false});
                    OBJ_pgp.TBL_pedidos.setValueAt(lq_rs.getString(1), a, 0);
                    OBJ_pgp.TBL_pedidos.setValueAt(lq_rs.getString(2), a, 1);
                    OBJ_pgp.TBL_pedidos.setValueAt(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(3)), a, 2);
                    OBJ_pgp.TBL_pedidos.setValueAt(lq_rs.getString(4), a, 3);
                    OBJ_pgp.TBL_pedidos.setValueAt(lq_rs.getString(5), a, 4);
                    a++;
                } while (lq_rs.next());
            }
        } catch (Exception e) {

        }
    }

    public int cuenta_seleccion(pnl_cierre_pedidos OBJ_pgp) {
        int resp = 0;
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        for (int i = 0;i < modelo.getRowCount(); i++) {
            if((boolean)modelo.getValueAt(i, 5)){
                resp++;
            }
        }
        return resp;
    }
}
