package JAVA.ANCESTRO.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.dlg_busq_ubigeo;
import java.sql.ResultSet;
import javax.swing.JTextField;

public class activa_buscador {

    ResultSet lq_rs;
    String ls_modulo = "ANCESTRO", ls_capa = "LOGICA", ls_clase = "activa_buscador";

    public void busq_ubigeo(JTextField codigo, JTextField descripcion) {
        go_dlg_busq_ubigeo = new dlg_busq_ubigeo(null, true);
        go_dlg_busq_ubigeo.setVisible(true);
        String ls_codigo_ubigeo = go_dlg_busq_ubigeo.ls_codigo_ubigeo;

        if (ls_codigo_ubigeo != null) {
            codigo.setText(ls_codigo_ubigeo);
            get_descripcion_ubigeo(ls_codigo_ubigeo, codigo, descripcion);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5", "SELECCIONE UBIGEO");
            codigo.setText("");
            descripcion.setText("");
        }
    }

    public boolean get_descripcion_ubigeo(String ls_codigo_ubigeo, JTextField codigo, JTextField descripcion) {
        boolean resp = false;
        ls_codigo_ubigeo = codigo.getText().trim();
        try {
            lq_rs = go_dao_ubigeo.SLT_descripcion_ubigeo_x_codigo(ls_codigo_ubigeo);
            if (lq_rs != null) {
                descripcion.setText(lq_rs.getString(1));
                resp = true;
            } else {
                codigo.setText("");
                descripcion.setText("");
            }
        } catch (Exception e) {
        }
        return resp;
    }
}
