package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.jif_tipo_cambio;
import java.beans.PropertyVetoException;

public class muestra_jif_ventas {

    public void muestra_jif_entidad() throws PropertyVetoException {

        if (go_jif_tipo_cambio != null) {
            if (go_jif_tipo_cambio.isClosed()) {
                go_jif_tipo_cambio = new jif_tipo_cambio();
                go_frm_principal.JDP_principal.add(go_jif_tipo_cambio);
                go_jif_tipo_cambio.show();

            } else if (go_jif_tipo_cambio.isIcon()) {
                go_jif_tipo_cambio.setIcon(false);
            } else if (!go_jif_tipo_cambio.isShowing()) {
                go_jif_tipo_cambio = new jif_tipo_cambio();
                go_frm_principal.JDP_principal.add(go_jif_tipo_cambio);
                go_jif_tipo_cambio.show();
            }
        } else {
            go_jif_tipo_cambio = new jif_tipo_cambio();
            go_frm_principal.JDP_principal.add(go_jif_tipo_cambio);
            go_jif_tipo_cambio.show();
        }
    }
}
