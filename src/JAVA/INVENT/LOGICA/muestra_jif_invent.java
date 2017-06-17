package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.GUI.jif_datos_marca;
import JAVA.INVENT.GUI.jif_datos_producto;
import java.beans.PropertyVetoException;

public class muestra_jif_invent {
    public void muestra_jif_marca() throws PropertyVetoException {

        if (go_jif_datos_marca != null) {
            if (go_jif_datos_marca.isClosed()) {
                go_jif_datos_marca = new jif_datos_marca();
                go_frm_principal.JDP_principal.add(go_jif_datos_marca);
                go_jif_datos_marca.show();

            } else if (go_jif_datos_marca.isIcon()) {
                go_jif_datos_marca.setIcon(false);
            } else if (!go_jif_datos_marca.isShowing()) {
                go_jif_datos_marca = new jif_datos_marca();
                go_frm_principal.JDP_principal.add(go_jif_datos_marca);
                go_jif_datos_marca.show();
            }
        } else {
            go_jif_datos_marca = new jif_datos_marca();
            go_frm_principal.JDP_principal.add(go_jif_datos_marca);
            go_jif_datos_marca.show();
        }
    }
    
    public void muestra_jif_producto() throws PropertyVetoException {

        if (go_jif_datos_producto != null) {
            if (go_jif_datos_producto.isClosed()) {
                go_jif_datos_producto = new jif_datos_producto();
                go_frm_principal.JDP_principal.add(go_jif_datos_producto);
                go_jif_datos_producto.show();

            } else if (go_jif_datos_producto.isIcon()) {
                go_jif_datos_producto.setIcon(false);
            } else if (!go_jif_datos_producto.isShowing()) {
                go_jif_datos_producto = new jif_datos_producto();
                go_frm_principal.JDP_principal.add(go_jif_datos_producto);
                go_jif_datos_producto.show();
            }
        } else {
            go_jif_datos_producto = new jif_datos_producto();
            go_frm_principal.JDP_principal.add(go_jif_datos_producto);
            go_jif_datos_producto.show();
        }
    }
}
