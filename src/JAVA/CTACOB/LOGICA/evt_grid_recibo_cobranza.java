package JAVA.CTACOB.LOGICA;

import JAVA.CTACOB.GUI.pnl_grid_recibo_cobranza;
import javax.swing.table.DefaultTableModel;

public class evt_grid_recibo_cobranza {

    public void activa_campos(int op, pnl_grid_recibo_cobranza OBJ_pgp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pgp.TBL_cobranza.setEnabled(valor);
                break;
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
}
