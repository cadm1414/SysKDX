package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.pnl_grid_pedidos;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class evt_grid_pedidos {

    ResultSet lq_rs;
    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "evt_grid_pedidos";

    public void activa_campos(int op, pnl_grid_pedidos OBJ_pgp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pgp.TBL_pedidos.setEnabled(valor);
                break;
        }
    }
    
    public void limpia_tabla(pnl_grid_pedidos OBJ_pgp) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgp.TBL_pedidos.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
}
