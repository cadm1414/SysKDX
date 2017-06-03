package JAVA.ANCESTRO.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;

public class recupera_valor_op {

    public boolean[] recupera(String codigo_modulo, String codigo_op) {
        ResultSet lq_rs = null;
        boolean lb_valor_op[] = new boolean[8];
        lq_rs = go_dao_rol_menu.SLT_status_x_rol_menu(codigo_modulo, codigo_op);
        if (lq_rs != null) {
            try {
                do {
                    for (int i = 0; i < lb_valor_op.length; i++) {
                        if (lq_rs.getString(i + 1).equalsIgnoreCase("1")) {
                            lb_valor_op[i] = true;
                        } else {
                            lb_valor_op[i] = false;
                        }
                    }
                } while (lq_rs.next());
            } catch (Exception e) {
            }
        }
        return lb_valor_op;
    }

}
