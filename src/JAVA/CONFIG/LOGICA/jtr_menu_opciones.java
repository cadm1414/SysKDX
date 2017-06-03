package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class jtr_menu_opciones {

    DefaultMutableTreeNode nivel0;
    DefaultMutableTreeNode nivel1;
    DefaultMutableTreeNode nivel2;
    DefaultMutableTreeNode nivel3;
    DefaultTreeModel modelo;
    ResultSet lq_rs;

    public void menu_opciones(JTree menu_opciones, int index) {
        nivel0 = new DefaultMutableTreeNode("OPCIONES");
        String menu = "";
        String status = "";
        String codigo_modulo = gs_codigo_modulo[index];

        try {
            lq_rs = go_dao_rol_menu.SLT_rol_menu_x_idrol_op(codigo_modulo);
            if (lq_rs != null) {
                do {
                    if (lq_rs.getString(1).length() == 3) {
                        menu = lq_rs.getString(1);
                        status = lq_rs.getString(3);
                        if (status.equalsIgnoreCase("1")) {
                            nivel1 = new DefaultMutableTreeNode(lq_rs.getString(2));
                            nivel0.add(nivel1);
                        }
                    } else if (lq_rs.getString(1).substring(0, 3).equalsIgnoreCase(menu) && status.equalsIgnoreCase("1")) {
                        switch (lq_rs.getString(1).length()) {
                            case 5:
                                if (lq_rs.getString(3).equalsIgnoreCase("1")) {
                                    nivel2 = new DefaultMutableTreeNode(lq_rs.getString(2));
                                    nivel1.add(nivel2);
                                }
                                break;
                            case 7:
                                if (lq_rs.getString(3).equalsIgnoreCase("1")) {
                                    nivel3 = new DefaultMutableTreeNode(lq_rs.getString(2));
                                    nivel2.add(nivel3);
                                }
                                break;
                        }
                    }

                } while (lq_rs.next());
                modelo = new DefaultTreeModel(nivel0);
                menu_opciones.setModel(modelo);
            }else{
                modelo = new DefaultTreeModel(nivel0);
                menu_opciones.setModel(modelo);
            }
        } catch (Exception e) {
        }

    }

}
