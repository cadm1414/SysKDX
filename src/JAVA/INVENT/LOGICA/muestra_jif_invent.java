package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.GUI.jif_datos_articulo;
import JAVA.INVENT.GUI.jif_datos_articulo_costo;
import JAVA.INVENT.GUI.jif_datos_familia;
import JAVA.INVENT.GUI.jif_datos_marca;
import JAVA.INVENT.GUI.jif_datos_producto;
import JAVA.INVENT.GUI.jif_datos_subfamilia;
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
    
    public void muestra_jif_familia() throws PropertyVetoException {
        if (go_jif_datos_familia != null) {
            if (go_jif_datos_familia.isClosed()) {
                go_jif_datos_familia = new jif_datos_familia();
                go_frm_principal.JDP_principal.add(go_jif_datos_familia);
                go_jif_datos_familia.show();

            } else if (go_jif_datos_familia.isIcon()) {
                go_jif_datos_familia.setIcon(false);
            } else if (!go_jif_datos_familia.isShowing()) {
                go_jif_datos_familia = new jif_datos_familia();
                go_frm_principal.JDP_principal.add(go_jif_datos_familia);
                go_jif_datos_familia.show();
            }
        } else {
            go_jif_datos_familia = new jif_datos_familia();
            go_frm_principal.JDP_principal.add(go_jif_datos_familia);
            go_jif_datos_familia.show();
        }
    }
    
    public void muestra_jif_subfamilia() throws PropertyVetoException {
        if (go_jif_datos_subfamilia != null) {
            if (go_jif_datos_subfamilia.isClosed()) {
                go_jif_datos_subfamilia = new jif_datos_subfamilia();
                go_frm_principal.JDP_principal.add(go_jif_datos_subfamilia);
                go_jif_datos_subfamilia.show();

            } else if (go_jif_datos_subfamilia.isIcon()) {
                go_jif_datos_subfamilia.setIcon(false);
            } else if (!go_jif_datos_subfamilia.isShowing()) {
                go_jif_datos_subfamilia = new jif_datos_subfamilia();
                go_frm_principal.JDP_principal.add(go_jif_datos_subfamilia);
                go_jif_datos_subfamilia.show();
            }
        } else {
            go_jif_datos_subfamilia = new jif_datos_subfamilia();
            go_frm_principal.JDP_principal.add(go_jif_datos_subfamilia);
            go_jif_datos_subfamilia.show();
        }
    }
    
    public void muestra_jif_articulo() throws PropertyVetoException {
        if (go_jif_datos_articulo != null) {
            if (go_jif_datos_articulo.isClosed()) {
                go_jif_datos_articulo = new jif_datos_articulo();
                go_frm_principal.JDP_principal.add(go_jif_datos_articulo);
                go_jif_datos_articulo.show();

            } else if (go_jif_datos_articulo.isIcon()) {
                go_jif_datos_articulo.setIcon(false);
            } else if (!go_jif_datos_articulo.isShowing()) {
                go_jif_datos_articulo = new jif_datos_articulo();
                go_frm_principal.JDP_principal.add(go_jif_datos_articulo);
                go_jif_datos_articulo.show();
            }
        } else {
            go_jif_datos_articulo = new jif_datos_articulo();
            go_frm_principal.JDP_principal.add(go_jif_datos_articulo);
            go_jif_datos_articulo.show();
        }
    }
    
    public void muestra_jif_articulo_costo() throws PropertyVetoException {
        if (go_jif_datos_articulo_costo != null) {
            if (go_jif_datos_articulo_costo.isClosed()) {
                go_jif_datos_articulo_costo = new jif_datos_articulo_costo();
                go_frm_principal.JDP_principal.add(go_jif_datos_articulo_costo);
                go_jif_datos_articulo_costo.show();

            } else if (go_jif_datos_articulo_costo.isIcon()) {
                go_jif_datos_articulo_costo.setIcon(false);
            } else if (!go_jif_datos_articulo_costo.isShowing()) {
                go_jif_datos_articulo_costo = new jif_datos_articulo_costo();
                go_frm_principal.JDP_principal.add(go_jif_datos_articulo_costo);
                go_jif_datos_articulo_costo.show();
            }
        } else {
            go_jif_datos_articulo_costo = new jif_datos_articulo_costo();
            go_frm_principal.JDP_principal.add(go_jif_datos_articulo_costo);
            go_jif_datos_articulo_costo.show();
        }
    }
}
