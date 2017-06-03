package JAVA.ANCESTRO.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.jif_datos_almacen;
import JAVA.CONFIG.GUI.jif_datos_sucursal;
import JAVA.CONFIG.GUI.jif_datos_usuario;
import java.beans.PropertyVetoException;

public class muestra_jif {

    public void muestra_jif_usuario() throws PropertyVetoException {

        if (go_jif_datos_usuario != null) {
            if (go_jif_datos_usuario.isClosed()) {
                go_jif_datos_usuario = new jif_datos_usuario();
                go_frm_principal.JDP_principal.add(go_jif_datos_usuario);
                go_jif_datos_usuario.show();

            } else if (go_jif_datos_usuario.isIcon()) {
                go_jif_datos_usuario.setIcon(false);
            } else if (!go_jif_datos_usuario.isShowing()) {
                go_jif_datos_usuario = new jif_datos_usuario();
                go_frm_principal.JDP_principal.add(go_jif_datos_usuario);
                go_jif_datos_usuario.show();
            }
        } else {
            go_jif_datos_usuario = new jif_datos_usuario();
            go_frm_principal.JDP_principal.add(go_jif_datos_usuario);
            go_jif_datos_usuario.show();
        }
    }
    
    public void muestra_jif_sucursal() throws PropertyVetoException {

        if (go_jif_datos_sucursal != null) {
            if (go_jif_datos_sucursal.isClosed()) {
                go_jif_datos_sucursal = new jif_datos_sucursal();
                go_frm_principal.JDP_principal.add(go_jif_datos_sucursal);
                go_jif_datos_sucursal.show();

            } else if (go_jif_datos_sucursal.isIcon()) {
                go_jif_datos_sucursal.setIcon(false);
            } else if (!go_jif_datos_sucursal.isShowing()) {
                go_jif_datos_sucursal = new jif_datos_sucursal();
                go_frm_principal.JDP_principal.add(go_jif_datos_sucursal);
                go_jif_datos_sucursal.show();
            }
        } else {
            go_jif_datos_sucursal = new jif_datos_sucursal();
            go_frm_principal.JDP_principal.add(go_jif_datos_sucursal);
            go_jif_datos_sucursal.show();
        }
    }
    
    public void muestra_jif_almacen() throws PropertyVetoException {

        if (go_jif_datos_almacen != null) {
            if (go_jif_datos_almacen.isClosed()) {
                go_jif_datos_almacen = new jif_datos_almacen();
                go_frm_principal.JDP_principal.add(go_jif_datos_almacen);
                go_jif_datos_almacen.show();

            } else if (go_jif_datos_almacen.isIcon()) {
                go_jif_datos_almacen.setIcon(false);
            } else if (!go_jif_datos_almacen.isShowing()) {
                go_jif_datos_almacen = new jif_datos_almacen();
                go_frm_principal.JDP_principal.add(go_jif_datos_almacen);
                go_jif_datos_almacen.show();
            }
        } else {
            go_jif_datos_almacen = new jif_datos_almacen();
            go_frm_principal.JDP_principal.add(go_jif_datos_almacen);
            go_jif_datos_almacen.show();
        }
    }
}
