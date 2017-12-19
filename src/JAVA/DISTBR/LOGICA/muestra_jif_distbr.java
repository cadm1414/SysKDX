package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.GUI.jif_preliminar;
import java.beans.PropertyVetoException;

public class muestra_jif_distbr {

    public void muestra_jif_preliminar() throws PropertyVetoException {
        if (go_jif_preliminar != null) {
            if (go_jif_preliminar.isClosed()) {
                go_jif_preliminar = new jif_preliminar();
                go_frm_principal.JDP_principal.add(go_jif_preliminar);
                go_jif_preliminar.show();

            } else if (go_jif_preliminar.isIcon()) {
                go_jif_preliminar.setIcon(false);
            } else if (!go_jif_preliminar.isShowing()) {
                go_jif_preliminar = new jif_preliminar();
                go_frm_principal.JDP_principal.add(go_jif_preliminar);
                go_jif_preliminar.show();
            }
        } else {
            go_jif_preliminar = new jif_preliminar();
            go_frm_principal.JDP_principal.add(go_jif_preliminar);
            go_jif_preliminar.show();
        }
    }

}
