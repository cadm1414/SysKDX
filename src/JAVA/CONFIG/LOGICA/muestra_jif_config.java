package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.jif_datos_almacen;
import JAVA.CONFIG.GUI.jif_datos_sucursal;
import JAVA.CONFIG.GUI.jif_datos_tipo_movimiento;
import JAVA.CONFIG.GUI.jif_datos_unidad_medida;
import JAVA.CONFIG.GUI.jif_datos_usuario;
import JAVA.CONFIG.GUI.jif_datos_usuario_permisos;
import java.beans.PropertyVetoException;

public class muestra_jif_config {

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
    
    public void muestra_jif_usuario_permisos() throws PropertyVetoException {

        if (go_jif_datos_usuario_permisos != null) {
            if (go_jif_datos_usuario_permisos.isClosed()) {
                go_jif_datos_usuario_permisos = new jif_datos_usuario_permisos();
                go_frm_principal.JDP_principal.add(go_jif_datos_usuario_permisos);
                go_jif_datos_usuario_permisos.show();

            } else if (go_jif_datos_usuario_permisos.isIcon()) {
                go_jif_datos_usuario_permisos.setIcon(false);
            } else if (!go_jif_datos_usuario_permisos.isShowing()) {
                go_jif_datos_usuario_permisos = new jif_datos_usuario_permisos();
                go_frm_principal.JDP_principal.add(go_jif_datos_usuario_permisos);
                go_jif_datos_usuario_permisos.show();
            }
        } else {
            go_jif_datos_usuario_permisos = new jif_datos_usuario_permisos();
            go_frm_principal.JDP_principal.add(go_jif_datos_usuario_permisos);
            go_jif_datos_usuario_permisos.show();
        }
    }
    
    public void muestra_jif_tipo_movimiento() throws PropertyVetoException {

        if (go_jif_datos_tipo_movimiento != null) {
            if (go_jif_datos_tipo_movimiento.isClosed()) {
                go_jif_datos_tipo_movimiento = new jif_datos_tipo_movimiento();
                go_frm_principal.JDP_principal.add(go_jif_datos_tipo_movimiento);
                go_jif_datos_tipo_movimiento.show();

            } else if (go_jif_datos_tipo_movimiento.isIcon()) {
                go_jif_datos_tipo_movimiento.setIcon(false);
            } else if (!go_jif_datos_tipo_movimiento.isShowing()) {
                go_jif_datos_tipo_movimiento = new jif_datos_tipo_movimiento();
                go_frm_principal.JDP_principal.add(go_jif_datos_tipo_movimiento);
                go_jif_datos_tipo_movimiento.show();
            }
        } else {
            go_jif_datos_tipo_movimiento = new jif_datos_tipo_movimiento();
            go_frm_principal.JDP_principal.add(go_jif_datos_tipo_movimiento);
            go_jif_datos_tipo_movimiento.show();
        }
    }
    
    public void muestra_jif_unidad_medida() throws PropertyVetoException {

        if (go_jif_datos_unidad_medida != null) {
            if (go_jif_datos_unidad_medida.isClosed()) {
                go_jif_datos_unidad_medida = new jif_datos_unidad_medida();
                go_frm_principal.JDP_principal.add(go_jif_datos_unidad_medida);
                go_jif_datos_unidad_medida.show();

            } else if (go_jif_datos_unidad_medida.isIcon()) {
                go_jif_datos_unidad_medida.setIcon(false);
            } else if (!go_jif_datos_unidad_medida.isShowing()) {
                go_jif_datos_unidad_medida = new jif_datos_unidad_medida();
                go_frm_principal.JDP_principal.add(go_jif_datos_unidad_medida);
                go_jif_datos_unidad_medida.show();
            }
        } else {
            go_jif_datos_unidad_medida = new jif_datos_unidad_medida();
            go_frm_principal.JDP_principal.add(go_jif_datos_unidad_medida);
            go_jif_datos_unidad_medida.show();
        }
    }
}
