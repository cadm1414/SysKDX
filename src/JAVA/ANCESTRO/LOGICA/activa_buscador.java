package JAVA.ANCESTRO.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.dlg_busq_entidad;
import JAVA.CONFIG.GUI.dlg_busq_ubigeo;
import JAVA.CONFIG.GUI.dlg_busq_vendedor;
import JAVA.INVENT.GUI.dlg_almacen_x_permiso;
import JAVA.INVENT.GUI.dlg_busq_articulo;
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
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "busq_ubigeo", "SELECCIONE UBIGEO");
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
                 codigo.transferFocus();
                resp = true;
            } else {
                codigo.setText("");
                descripcion.setText("");
                codigo.requestFocus();
            }
        } catch (Exception e) {
        }
        return resp;
    }

    public void busq_entidad(JTextField codigo, JTextField descripcion) {
        go_dlg_busq_entidad = new dlg_busq_entidad(null, true);
        go_dlg_busq_entidad.setVisible(true);
        String ls_codigo_entidad = go_dlg_busq_entidad.ls_codigo_entidad;

        if (ls_codigo_entidad != null) {
            codigo.setText(ls_codigo_entidad);
            get_descripcion_entidad(ls_codigo_entidad, codigo, descripcion);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "busq_entidad", "SELECCIONE ENTIDAD");
            codigo.setText("");
            descripcion.setText("");
        }
    }

    public boolean get_descripcion_entidad(String ls_codigo_entidad, JTextField codigo, JTextField descripcion) {
        boolean resp = false;
        ls_codigo_entidad = codigo.getText().trim();
        try {
            lq_rs = go_dao_entidad.SLT_datos_entidad(ls_codigo_entidad);
            if (lq_rs != null) {
                descripcion.setText(lq_rs.getString(7));
                codigo.transferFocus();
                resp = true;
            } else {
                codigo.setText("");
                descripcion.setText("");
                codigo.requestFocus();
            }
        } catch (Exception e) {
        }
        return resp;
    }

    public void busq_almacen_permiso(String parametro, String tipo_almacen, String estado, JTextField codigo, JTextField nombre) {
        gs_parametros[0] = parametro;
        go_dlg_almacen_x_permiso = new dlg_almacen_x_permiso(null, true);
        go_dlg_almacen_x_permiso.setVisible(true);
        String ls_codigo = go_dlg_almacen_x_permiso.ls_codigo_almacen;
        if (ls_codigo != null) {
            get_descripcion_almacen_permiso(ls_codigo, tipo_almacen, estado, codigo, nombre);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "busq_almacen_permiso", "SELECCIONE ALMACEN");
            codigo.setText("");
            nombre.setText("");
            codigo.requestFocus();
        }
    }

    public boolean get_descripcion_almacen_permiso(String ls_codigo, String tipo_almacen, String estado, JTextField codigo, JTextField nombre) {
        boolean resp = false;
        try {
            lq_rs = go_dao_usuario_permisos.SLT_grid_almacen_x_permiso(gi_id_usuario, tipo_almacen, estado, ls_codigo);
            if (lq_rs != null) {
                codigo.setText(lq_rs.getString(1));
                nombre.setText(lq_rs.getString(2));
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_almacen_permiso", "USUARIO SIN PERMISOS y/o ALMACEN NO EXISTE");
                codigo.setText("");
                nombre.setText("");
                codigo.requestFocus();
            }
        } catch (Exception e) {
        }
        return resp;
    }

    public void busq_articulo(JTextField codigo, JTextField nombre) {
        go_dlg_busq_articulo = new dlg_busq_articulo(null, true);
        go_dlg_busq_articulo.setVisible(true);
        String ls_codigo_articulo = go_dlg_busq_articulo.ls_codigo_articulo;
        if (ls_codigo_articulo != null) {
            get_descripcion_articulo(ls_codigo_articulo, codigo, nombre);
            codigo.setText(ls_codigo_articulo);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE ARTICULO");
            codigo.setText("");
            nombre.setText("");
        }
    }

    public void get_descripcion_articulo(String ls_codigo, JTextField codigo, JTextField nombre) {
        try {
            lq_rs = go_dao_articulo.SLT_datos_articulo(ls_codigo);
            if (lq_rs != null) {
                codigo.setText(lq_rs.getString(1));
                nombre.setText(lq_rs.getString(2));
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_articulo", "ARTICULO NO EXISTE");
                codigo.setText("");
                nombre.setText("");
                codigo.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    public void busq_vendedor(JTextField codigo, JTextField nombre) {
        go_dlg_busq_vendedor = new dlg_busq_vendedor(null, true);
        go_dlg_busq_vendedor.setVisible(true);
        String ls_codigo_vendedor = go_dlg_busq_vendedor.ls_codigo_vendedor;
        if (ls_codigo_vendedor != null) {
            codigo.setText(ls_codigo_vendedor);
            get_descripcion_vendedor(ls_codigo_vendedor, codigo, nombre);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "busq_vendedor", "SELECCIONE VENDEDOR");
            codigo.setText("");
            nombre.setText("");
            codigo.requestFocus();
        }
    }

    public void get_descripcion_vendedor(String ls_codigo, JTextField codigo, JTextField nombre) {
        try {
            lq_rs = go_dao_vendedor.SLT_datos_vendedor(ls_codigo, "1");
            if (lq_rs != null) {
                codigo.setText(lq_rs.getString(1));
                nombre.setText(lq_rs.getString(2));
                codigo.transferFocus();
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_vendedor", "VENDEDOR NO EXISTE y/o BLOQUEADO");
                codigo.setText("");
                nombre.setText("");
                codigo.requestFocus();
            }
        } catch (Exception e) {
        }
    }
}
