package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.pnl_grid_rol_menu;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class evt_grid_rol_menu {

    ResultSet lq_rs;

    public void datos_tabla(pnl_grid_rol_menu OBJ_pgr, DefaultTableModel modelo) {
        int a = 0;
        modelo = (DefaultTableModel) OBJ_pgr.TBL_rol_menu.getModel();
        lq_rs = go_dao_menu.SLT_tipo_menu();

        if (lq_rs != null) {
            try {
                do {
                    modelo.addRow(new Object[]{false});
                    for (int x = 1; x < OBJ_pgr.TBL_rol_menu.getColumnCount(); x++) {
                        if (x < 4) {
                            OBJ_pgr.TBL_rol_menu.setValueAt(lq_rs.getString(x), a, x);
                        } else {
                            OBJ_pgr.TBL_rol_menu.setValueAt(false, a, x);
                        }
                    }
                    a++;
                } while (lq_rs.next());
                OBJ_pgr.TBL_rol_menu.setDefaultRenderer(Object.class, new formato_grid_rol_menu());
            } catch (Exception e) {
            }
        }
    }

    public void limpia_tabla(pnl_grid_rol_menu OBJ_pgr) {
        DefaultTableModel modelo = (DefaultTableModel) OBJ_pgr.TBL_rol_menu.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void muestra_datos(pnl_grid_rol_menu OBJ_grm, ResultSet rs) {
        boolean valor;
        try {
            do {
                for (int i = 0; i < OBJ_grm.TBL_rol_menu.getRowCount(); i++) {
                    if (OBJ_grm.TBL_rol_menu.getValueAt(i, 1).toString().equalsIgnoreCase(rs.getString(4)) && OBJ_grm.TBL_rol_menu.getValueAt(i, 2).toString().equalsIgnoreCase(rs.getString(5))) {

                        for (int x = 0; x < OBJ_grm.TBL_rol_menu.getColumnCount(); x++) {

                            if (rs.getString(x + 3).equalsIgnoreCase("1")) {
                                valor = true;
                            } else {
                                valor = false;
                            }
                            if (x < 1 || x > 3) {
                                OBJ_grm.TBL_rol_menu.setValueAt(valor, i, x);
                            }
                        }
                        break;
                    }
                }
            } while (rs.next());

        } catch (Exception e) {
        }

    }

}
