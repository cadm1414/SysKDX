package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.pnl_grid_usuario_permisos;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class evt_grid_usuario_permisos {

    ResultSet lq_rs;
    
    public void activa_campos(int op, pnl_grid_usuario_permisos OBJ_pgu,boolean valor) {
        switch (op) {
            case 0:
                OBJ_pgu.TBL_usuario_permisos.setEnabled(valor);
                break;
        }
    }

    public void datos_tabla(pnl_grid_usuario_permisos OBJ_pgu, DefaultTableModel modelo) {
        int a = 0;
        modelo = (DefaultTableModel) OBJ_pgu.TBL_usuario_permisos.getModel();
        lq_rs = go_dao_usuario_permisos.SLT_grid_usuario_permisos();

        if (lq_rs != null) {
            try {
                do {
                    modelo.addRow(new Object[]{false});
                    for (int x = 1; x < OBJ_pgu.TBL_usuario_permisos.getColumnCount(); x++) {
                        if (x < 4) {
                            OBJ_pgu.TBL_usuario_permisos.setValueAt(lq_rs.getString(x), a, x - 1);
                        } else {
                            OBJ_pgu.TBL_usuario_permisos.setValueAt(false, a, x);
                        }
                    }
                    a++;
                } while (lq_rs.next());
                OBJ_pgu.TBL_usuario_permisos.setDefaultRenderer(Object.class, new formato_grid_rol_menu());
            } catch (Exception e) {
            }
        }
    }

    public void muestra_datos(pnl_grid_usuario_permisos OBJ_gup, ResultSet rs) {
        boolean valor;
        try {
            do {
                for (int i = 0; i < OBJ_gup.TBL_usuario_permisos.getRowCount(); i++) {
                    if (OBJ_gup.TBL_usuario_permisos.getValueAt(i, 0).toString().equalsIgnoreCase(rs.getString(2)) && OBJ_gup.TBL_usuario_permisos.getValueAt(i, 2).toString().equalsIgnoreCase(rs.getString(3))) {
                        OBJ_gup.TBL_usuario_permisos.setValueAt(true, i, 3);
                        break;
                    }
                }
            } while (rs.next());

        } catch (Exception e) {
        }

    }

    public void limpia_tabla(pnl_grid_usuario_permisos OBJ_pgu) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgu.TBL_usuario_permisos.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
}
