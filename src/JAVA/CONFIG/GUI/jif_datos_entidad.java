package JAVA.CONFIG.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.BEAN.BEAN_entidad;
import JAVA.CONFIG.BEAN.BEAN_entidad_contacto;
import JAVA.CONFIG.BEAN.BEAN_entidad_direccion;
import JAVA.CONFIG.LOGICA.cbx_pais;
import JAVA.CONFIG.LOGICA.cbx_sector_distribucion;
import JAVA.CONFIG.LOGICA.cbx_sucursal;
import JAVA.CONFIG.LOGICA.cbx_tabla_sunat;
import JAVA.CONFIG.LOGICA.cbx_tipo_comercio;
import JAVA.CONFIG.LOGICA.cbx_vendedor;
import JAVA.CONFIG.LOGICA.evt_datos_contacto;
import JAVA.CONFIG.LOGICA.evt_datos_direccion;
import JAVA.CONFIG.LOGICA.evt_datos_entidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextField;

public class jif_datos_entidad extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    pnl_datos_entidad lo_pnl_datos_entidad = new pnl_datos_entidad();
    evt_datos_entidad lo_evt_datos_entidad = new evt_datos_entidad();
    pnl_datos_contacto lo_pnl_datos_contacto = new pnl_datos_contacto();
    evt_datos_contacto lo_evt_datos_contacto = new evt_datos_contacto();
    pnl_datos_direccion lo_pnl_datos_direccion = new pnl_datos_direccion();
    evt_datos_direccion lo_evt_datos_direccion = new evt_datos_direccion();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    BEAN_entidad lo_bean_entidad = new BEAN_entidad();
    BEAN_entidad_direccion lo_bean_entidad_direccion = new BEAN_entidad_direccion();
    BEAN_entidad_contacto lo_bean_entidad_contacto = new BEAN_entidad_contacto();
    cbx_tabla_sunat lo_cbx_tipo_doc_id;
    cbx_sucursal lo_cbx_sucursal;
    cbx_vendedor lo_cbx_vendedor;
    cbx_pais lo_cbx_pais;
    cbx_tipo_comercio lo_cbx_tipo_comercio;
    cbx_sector_distribucion lo_cbx_sector_distribucion;
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs;
    int li_tipo_operacion, li_tipo_operacion_d, li_tipo_operacion_c;
    String ls_codigo, ls_codigo_ubigeo;
    String ls_opcion = "M C F";
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "jif_datos_entidad";

    public jif_datos_entidad() {
        initComponents();
        formulario();
        activa_botones();
        get_tabla_sunat();
        get_pais();
        get_sucursal();
        get_vendedor();
        get_tipo_comercio();
        get_sector_distribucion();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        TBP_entidad.addTab("REGISTRO", lo_pnl_datos_entidad);

        this.add(lo_pnl_opciones_2);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);
        lo_evt_datos_entidad.evento_press(lo_pnl_datos_entidad, KeyEvnt);
        lo_evt_datos_entidad.evento_item(lo_pnl_datos_entidad, ItemEvent);

        lo_evt_datos_contacto.evento_click(lo_pnl_datos_contacto, Listener);
        lo_evt_datos_contacto.evento_press(lo_pnl_datos_contacto, KeyEvnt);
        lo_evt_datos_direccion.evento_press(lo_pnl_datos_direccion, KeyEvnt);
        lo_evt_datos_direccion.evento_click(lo_pnl_datos_direccion, Listener);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void evt_f5(JTextField codigo_ubigeo, JTextField descripcion) {
        go_dlg_busq_ubigeo = new dlg_busq_ubigeo(null, true);
        go_dlg_busq_ubigeo.setVisible(true);
        ls_codigo_ubigeo = go_dlg_busq_ubigeo.ls_codigo_ubigeo;

        if (ls_codigo_ubigeo != null) {
            codigo_ubigeo.setText(ls_codigo_ubigeo);
            get_descripcion_ubigeo(codigo_ubigeo, descripcion);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5", "SELECCIONE UBIGEO");
            codigo_ubigeo.setText("");
            descripcion.setText("");
        }
    }

    private void get_descripcion_ubigeo(JTextField codigo_ubigeo, JTextField descripcion) {
        ls_codigo_ubigeo = codigo_ubigeo.getText().trim();
        try {
            lq_rs = go_dao_ubigeo.SLT_descripcion_ubigeo_x_codigo(ls_codigo_ubigeo);
            if (lq_rs != null) {
                descripcion.setText(lq_rs.getString(1));
                getFocusOwner().transferFocus();
            } else {
                codigo_ubigeo.setText("");
                descripcion.setText("");
            }
        } catch (Exception e) {
        }
    }

    private void get_tabla_sunat() {
        lq_rs = go_dao_tabla_sunat.SLT_cbx_tabla_sunat("002");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(4, lq_rs, lo_pnl_datos_entidad.CBX_tipo_documento_id);
        }
    }

    private void get_sector_distribucion() {
        lq_rs = go_dao_sector_distribucion.SLT_cbx_sector_distribucion();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(20, lq_rs, lo_pnl_datos_entidad.CBX_sector);
        }
    }

    private void get_tipo_comercio() {
        lq_rs = go_dao_tipo_comercio.SLT_cbx_tipo_comercio();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(18, lq_rs, lo_pnl_datos_entidad.CBX_tipo_comercio);
        }
    }

    private void get_sucursal() {
        lq_rs = go_dao_sucursal.SLT_cbx_sucursal("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(2, lq_rs, lo_pnl_datos_entidad.CBX_sucursal);
        }
    }

    private void get_pais() {
        lq_rs = go_dao_pais.SLT_cbx_pais();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(13, lq_rs, lo_pnl_datos_entidad.CBX_pais);
        }
    }

    private void get_vendedor() {
        lq_rs = go_dao_vendedor.SLT_cbx_vendedor();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(14, lq_rs, lo_pnl_datos_entidad.CBX_vendedor);
        }
    }

    private void get_descripcion_entidad(String codigo) {
        TBP_entidad.addTab("DIRECCION", lo_pnl_datos_direccion);
        TBP_entidad.addTab("CONTACTO", lo_pnl_datos_contacto);
        try {
            lq_rs = go_dao_entidad.SLT_datos_entidad(codigo);
            if (lq_rs != null) {
                lo_evt_datos_entidad.setea_recupera(lo_bean_entidad, lq_rs);
                lo_evt_datos_entidad.muestra_datos(lo_pnl_datos_entidad, lo_bean_entidad);
            }
            lo_evt_datos_direccion.datos_tabla(codigo, lo_pnl_datos_direccion);
            lo_evt_datos_contacto.datos_tabla(codigo, lo_pnl_datos_contacto);
        } catch (Exception e) {
        }
    }

    private void genera_razon_social() {
        lo_pnl_datos_entidad.TXT_razon_social.setText(lo_pnl_datos_entidad.TXT_papellido.getText().trim() + " " + lo_pnl_datos_entidad.TXT_sapellido.getText().trim() + " " + lo_pnl_datos_entidad.TXT_nombre.getText().trim() + " ");
    }

    private void genera_codigo_entidad(String caracter) {
        try {
            lq_rs = go_dao_entidad.FNC_codigo_entidad(caracter.substring(0, 1));
            if (lq_rs.next()) {
                lo_pnl_datos_entidad.TXT_codigo_entidad.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        TBP_entidad.remove(lo_pnl_datos_contacto);
        TBP_entidad.remove(lo_pnl_datos_direccion);
        lo_evt_datos_entidad.limpia_datos(lo_pnl_datos_entidad);
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_entidad.activa_campos(0, lo_pnl_datos_entidad, true);
    }

    private void evt_buscar() {
        li_tipo_operacion = 2;
        go_dlg_busq_entidad = new dlg_busq_entidad(null, true);
        go_dlg_busq_entidad.setVisible(true);
        ls_codigo = go_dlg_busq_entidad.ls_codigo_entidad;
        if (ls_codigo != null) {
            get_descripcion_entidad(ls_codigo);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE ENTIDAD");
            lo_evt_datos_entidad.limpia_datos(lo_pnl_datos_entidad);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
            TBP_entidad.remove(lo_pnl_datos_contacto);
            TBP_entidad.remove(lo_pnl_datos_direccion);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_cbx_tipo_doc_id = (cbx_tabla_sunat) lo_pnl_datos_entidad.CBX_tipo_documento_id.getSelectedItem();
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_entidad.activa_campos(1, lo_pnl_datos_entidad, true);
        lo_evt_datos_direccion.activa_campos(0, lo_pnl_datos_direccion, true);
        lo_evt_datos_contacto.activa_campos(0, lo_pnl_datos_contacto, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR ENTIDAD " + lo_bean_entidad.getRazon_social() + "?") == 0) {
            try {
                if (go_dao_entidad.DLT_entidad(ls_codigo)) {
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_entidad.activa_campos(0, lo_pnl_datos_entidad, false);
                    lo_evt_datos_entidad.limpia_datos(lo_pnl_datos_entidad);
                    TBP_entidad.remove(lo_pnl_datos_contacto);
                    TBP_entidad.remove(lo_pnl_datos_direccion);
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_guardar() {
        if (li_tipo_operacion == 0) {
            genera_codigo_entidad(lo_pnl_datos_entidad.TXT_razon_social.getText().trim());
        }

        lo_cbx_tipo_doc_id = (cbx_tabla_sunat) lo_pnl_datos_entidad.CBX_tipo_documento_id.getSelectedItem();
        lo_cbx_sucursal = (cbx_sucursal) lo_pnl_datos_entidad.CBX_sucursal.getSelectedItem();
        lo_cbx_vendedor = (cbx_vendedor) lo_pnl_datos_entidad.CBX_vendedor.getSelectedItem();
        lo_cbx_pais = (cbx_pais) lo_pnl_datos_entidad.CBX_pais.getSelectedItem();
        lo_cbx_tipo_comercio = (cbx_tipo_comercio) lo_pnl_datos_entidad.CBX_tipo_comercio.getSelectedItem();
        lo_cbx_sector_distribucion = (cbx_sector_distribucion) lo_pnl_datos_entidad.CBX_sector.getSelectedItem();

        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_entidad.valida_campos(lo_pnl_datos_entidad, lo_cbx_tipo_doc_id)) {
                    try {
                        lo_evt_datos_entidad.setea_campos(lo_bean_entidad, lo_pnl_datos_entidad, lo_cbx_tipo_doc_id, lo_cbx_pais, lo_cbx_vendedor, lo_cbx_sucursal, lo_cbx_tipo_comercio, lo_cbx_sector_distribucion);
                        if (go_dao_entidad.IST_entidad(lo_bean_entidad)) {
                            lo_evt_datos_entidad.limpia_datos(lo_pnl_datos_entidad);
                            lo_evt_datos_entidad.activa_campos(0, lo_pnl_datos_entidad, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                            TBP_entidad.remove(lo_pnl_datos_contacto);
                            TBP_entidad.remove(lo_pnl_datos_direccion);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_entidad.verifica_cambios(lo_bean_entidad, lo_pnl_datos_entidad, lo_cbx_sucursal, lo_cbx_vendedor, lo_cbx_tipo_comercio, lo_cbx_sector_distribucion)) {
                    if (lo_evt_datos_entidad.valida_campos(lo_pnl_datos_entidad, lo_cbx_tipo_doc_id)) {
                        try {
                            lo_evt_datos_entidad.setea_campos(lo_bean_entidad, lo_pnl_datos_entidad, lo_cbx_tipo_doc_id, lo_cbx_pais, lo_cbx_vendedor, lo_cbx_sucursal, lo_cbx_tipo_comercio, lo_cbx_sector_distribucion);
                            if (go_dao_entidad.UPD_entidad(lo_bean_entidad)) {
                                lo_evt_datos_entidad.limpia_datos(lo_pnl_datos_entidad);
                                lo_evt_datos_entidad.activa_campos(0, lo_pnl_datos_entidad, false);
                                lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                                TBP_entidad.remove(lo_pnl_datos_contacto);
                                TBP_entidad.remove(lo_pnl_datos_direccion);
                            }
                        } catch (Exception e) {
                        }
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_guardar", "NO SE A REALIZADO CAMBIOS");
                }
                break;
        }
    }

    private void evt_cancelar() {
        lo_evt_datos_entidad.activa_campos(0, lo_pnl_datos_entidad, false);
        if (ls_codigo != null) {
            lo_evt_datos_entidad.muestra_datos(lo_pnl_datos_entidad, lo_bean_entidad);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
            lo_evt_datos_direccion.limpia_datos(lo_pnl_datos_direccion);
            lo_evt_datos_direccion.activa_campos(0, lo_pnl_datos_direccion, false);
            lo_evt_datos_direccion.datos_tabla(ls_codigo, lo_pnl_datos_direccion);

            lo_evt_datos_contacto.limpia_datos(lo_pnl_datos_contacto);
            lo_evt_datos_contacto.activa_campos(0, lo_pnl_datos_contacto, false);
            lo_evt_datos_contacto.datos_tabla(ls_codigo, lo_pnl_datos_contacto);
        } else {
            lo_evt_datos_entidad.limpia_datos(lo_pnl_datos_entidad);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    public void evt_reporte() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        go_evt_muestra_reporte.reporte_pestania("rpt_lista_entidad.jasper", parametros, "Etidad", 6);
    }

    private void evt_nuevo_direccion() {
        li_tipo_operacion_d = 0;
        lo_evt_datos_direccion.activa_campos(1, lo_pnl_datos_direccion, true);
        lo_evt_datos_direccion.limpia_datos(lo_pnl_datos_direccion);
    }

    private void evt_editar_direccion() {
        li_tipo_operacion_d = 1;
        try {
            lq_rs = go_dao_entidad_direccion.SLT_datos_entidad_direccion(ls_codigo, lo_pnl_datos_direccion.TBL_direccion.getValueAt(lo_pnl_datos_direccion.TBL_direccion.getSelectedRow(), 0).toString());
            if (lq_rs != null) {
                lo_evt_datos_direccion.setea_recupera(lo_bean_entidad_direccion, lq_rs);
                lo_evt_datos_direccion.muestra_datos(lo_pnl_datos_direccion, lo_bean_entidad_direccion);
                lo_evt_datos_direccion.activa_campos(1, lo_pnl_datos_direccion, true);
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_editar_direccion", "SELECCIONE DIRECCION");
        }
    }

    private void evt_eliminar_direccion() {
        try {
            if (!lo_pnl_datos_direccion.TBL_direccion.getValueAt(lo_pnl_datos_direccion.TBL_direccion.getSelectedRow(), 0).toString().equalsIgnoreCase("000")) {
                if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR DIRECCION " + lo_pnl_datos_direccion.TBL_direccion.getValueAt(lo_pnl_datos_direccion.TBL_direccion.getSelectedRow(), 0) + "?") == 0) {
                    if (go_dao_entidad_direccion.DLT_entidad_direccion(ls_codigo, lo_pnl_datos_direccion.TBL_direccion.getValueAt(lo_pnl_datos_direccion.TBL_direccion.getSelectedRow(), 0).toString())) {
                        lo_evt_datos_direccion.datos_tabla(ls_codigo, lo_pnl_datos_direccion);
                        lo_evt_datos_direccion.limpia_datos(lo_pnl_datos_direccion);
                        lo_evt_datos_direccion.activa_campos(1, lo_pnl_datos_direccion, false);
                    }
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_eliminar_direccion", "DIRECCION PRINCIPAL NO PUEDE SER ELIMINADA");
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_eliminar_direccion", "SELECCIONE DIRECCION");
        }
    }

    private void evt_guardar_direccion() {
        lo_bean_entidad_direccion.setCodigo_entidad(ls_codigo);
        switch (li_tipo_operacion_d) {
            case 0:
                if (lo_evt_datos_direccion.valida_campos(lo_pnl_datos_direccion)) {
                    try {
                        lo_evt_datos_direccion.setea_campos(lo_bean_entidad_direccion, lo_pnl_datos_direccion);
                        if (go_dao_entidad_direccion.IST_entidad_direccion(lo_bean_entidad_direccion)) {
                            lo_evt_datos_direccion.limpia_datos(lo_pnl_datos_direccion);
                            lo_evt_datos_direccion.datos_tabla(ls_codigo, lo_pnl_datos_direccion);
                            lo_evt_datos_direccion.activa_campos(1, lo_pnl_datos_direccion, false);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_direccion.verifica_cambios(lo_bean_entidad_direccion, lo_pnl_datos_direccion)) {
                    if (lo_evt_datos_direccion.valida_campos(lo_pnl_datos_direccion)) {
                        try {
                            lo_evt_datos_direccion.setea_campos(lo_bean_entidad_direccion, lo_pnl_datos_direccion);
                            if (go_dao_entidad_direccion.UPD_entidad_direccion(lo_bean_entidad_direccion)) {
                                lo_evt_datos_direccion.limpia_datos(lo_pnl_datos_direccion);
                                lo_evt_datos_direccion.datos_tabla(ls_codigo, lo_pnl_datos_direccion);
                                lo_evt_datos_direccion.activa_campos(1, lo_pnl_datos_direccion, false);
                            }
                        } catch (Exception e) {
                        }
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_guardar_direccion", "NO SE A REALIZADO CAMBIOS");
                }
                break;
        }
    }

    private void evt_nuevo_contacto() {
        li_tipo_operacion_c = 0;
        lo_evt_datos_contacto.activa_campos(1, lo_pnl_datos_contacto, true);
        lo_evt_datos_contacto.limpia_datos(lo_pnl_datos_contacto);
    }

    private void evt_editar_contacto() {
        li_tipo_operacion_c = 1;
        try {
            lq_rs = go_dao_entidad_contacto.SLT_datos_entidad_contacto(ls_codigo, lo_pnl_datos_contacto.TBL_contacto.getValueAt(lo_pnl_datos_contacto.TBL_contacto.getSelectedRow(), 0).toString());
            if (lq_rs != null) {
                lo_evt_datos_contacto.setea_recupera(lo_bean_entidad_contacto, lq_rs);
                lo_evt_datos_contacto.muestra_datos(lo_pnl_datos_contacto, lo_bean_entidad_contacto);
                lo_evt_datos_contacto.activa_campos(1, lo_pnl_datos_contacto, true);
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_editar_contacto", "SELECCIONE CONTACTO");
        }
    }

    private void evt_eliminar_contacto() {
        try {
            if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR CONTACTO " + lo_pnl_datos_contacto.TBL_contacto.getValueAt(lo_pnl_datos_contacto.TBL_contacto.getSelectedRow(), 0) + "?") == 0) {
                if (go_dao_entidad_contacto.DLT_entidad_contacto(ls_codigo, lo_pnl_datos_contacto.TBL_contacto.getValueAt(lo_pnl_datos_contacto.TBL_contacto.getSelectedRow(), 0).toString())) {
                    lo_evt_datos_contacto.datos_tabla(ls_codigo, lo_pnl_datos_contacto);
                    lo_evt_datos_contacto.limpia_datos(lo_pnl_datos_contacto);
                    lo_evt_datos_contacto.activa_campos(1, lo_pnl_datos_contacto, false);
                }
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_eliminar_contacto", "SELECCIONE CONTACTO");
        }
    }

    private void evt_guardar_contacto() {
        lo_bean_entidad_contacto.setCodigo_entidad(ls_codigo);
        switch (li_tipo_operacion_c) {
            case 0:
                if (lo_evt_datos_contacto.valida_campos(lo_pnl_datos_contacto)) {
                    try {
                        lo_evt_datos_contacto.setea_campos(lo_bean_entidad_contacto, lo_pnl_datos_contacto);
                        if (go_dao_entidad_contacto.IST_entidad_contacto(lo_bean_entidad_contacto)) {
                            lo_evt_datos_contacto.limpia_datos(lo_pnl_datos_contacto);
                            lo_evt_datos_contacto.datos_tabla(ls_codigo, lo_pnl_datos_contacto);
                            lo_evt_datos_contacto.activa_campos(1, lo_pnl_datos_contacto, false);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_contacto.verifica_cambios(lo_bean_entidad_contacto, lo_pnl_datos_contacto)) {
                    if (lo_evt_datos_contacto.valida_campos(lo_pnl_datos_contacto)) {
                        try {
                            lo_evt_datos_contacto.setea_campos(lo_bean_entidad_contacto, lo_pnl_datos_contacto);
                            if (go_dao_entidad_contacto.UPD_entidad_contacto(lo_bean_entidad_contacto)) {
                                lo_evt_datos_contacto.limpia_datos(lo_pnl_datos_contacto);
                                lo_evt_datos_contacto.datos_tabla(ls_codigo, lo_pnl_datos_contacto);
                                lo_evt_datos_contacto.activa_campos(1, lo_pnl_datos_contacto, false);
                            }
                        } catch (Exception e) {
                        }
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_guardar_contacto", "NO SE A REALIZADO CAMBIOS");
                }
                break;
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_opciones_2.BTN_nuevo) {
                evt_nuevo();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_buscar) {
                evt_buscar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_editar) {
                evt_editar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_eliminar) {
                evt_eliminar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_guardar) {
                evt_guardar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_cancelar) {
                evt_cancelar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_reporte) {
                evt_reporte();
            }
            if (ae.getSource() == lo_pnl_datos_direccion.BTN_nuevo) {
                evt_nuevo_direccion();
            }
            if (ae.getSource() == lo_pnl_datos_direccion.BTN_editar) {
                evt_editar_direccion();
            }
            if (ae.getSource() == lo_pnl_datos_direccion.BTN_eliminar) {
                evt_eliminar_direccion();
            }
            if (ae.getSource() == lo_pnl_datos_direccion.BTN_guardar) {
                evt_guardar_direccion();
            }
            if (ae.getSource() == lo_pnl_datos_contacto.BTN_nuevo) {
                evt_nuevo_contacto();
            }
            if (ae.getSource() == lo_pnl_datos_contacto.BTN_editar) {
                evt_editar_contacto();
            }
            if (ae.getSource() == lo_pnl_datos_contacto.BTN_eliminar) {
                evt_eliminar_contacto();
            }
            if (ae.getSource() == lo_pnl_datos_contacto.BTN_guardar) {
                evt_guardar_contacto();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_datos_entidad.TXT_codigo_ubigeo) {
                    evt_f5(lo_pnl_datos_entidad.TXT_codigo_ubigeo, lo_pnl_datos_entidad.TXT_descripcion_ubigeo);
                }
                if (ke.getSource() == lo_pnl_datos_direccion.TXT_codigo_ubigeo) {
                    evt_f5(lo_pnl_datos_direccion.TXT_codigo_ubigeo, lo_pnl_datos_direccion.TXT_descripcion_ubigeo);
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_F1 && lo_pnl_opciones_2.BTN_nuevo.isEnabled()) {
                evt_nuevo();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F2 && lo_pnl_opciones_2.BTN_buscar.isEnabled()) {
                evt_buscar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F3 && lo_pnl_opciones_2.BTN_editar.isEnabled()) {
                evt_editar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F4 && lo_pnl_opciones_2.BTN_eliminar.isEnabled()) {
                evt_eliminar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_opciones_2.BTN_guardar.isEnabled()) {
                evt_guardar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE && lo_pnl_opciones_2.BTN_cancelar.isEnabled()) {
                evt_cancelar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_opciones_2.BTN_nuevo) {
                    evt_nuevo();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_buscar) {
                    evt_buscar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_editar) {

                    evt_editar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_eliminar) {
                    evt_eliminar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_guardar) {
                    evt_guardar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_cancelar) {
                    evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_reporte) {
                    evt_reporte();
                }
                if (ke.getSource() == lo_pnl_datos_entidad.JRD_es_cliente || ke.getSource() == lo_pnl_datos_entidad.JRD_es_proveedor || ke.getSource() == lo_pnl_datos_entidad.JRD_es_trabajador || ke.getSource() == lo_pnl_datos_entidad.JRD_nacional || ke.getSource() == lo_pnl_datos_entidad.JRD_extranjero || ke.getSource() == lo_pnl_datos_entidad.CBX_estado || ke.getSource() == lo_pnl_datos_entidad.CBX_tipo_documento_id || ke.getSource() == lo_pnl_datos_entidad.TXT_nombre_comercial) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_entidad.CBX_tipo_persona) {
                    if (lo_pnl_datos_entidad.CBX_tipo_persona.getSelectedIndex() == 1) {
                        go_cbx_trato_datos.selecciona_valor(4, "6", lo_pnl_datos_entidad.CBX_tipo_documento_id);
                    }
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_entidad.TXT_numero_doc_id && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_entidad.TXT_numero_doc_id)) {
                    lo_cbx_tipo_doc_id = (cbx_tabla_sunat) lo_pnl_datos_entidad.CBX_tipo_documento_id.getSelectedItem();
                    if (lo_cbx_tipo_doc_id.getID().equalsIgnoreCase("6")) {
                        if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_entidad.TXT_numero_doc_id.getText().trim(), 4, 11)) {
                            if (go_fnc_operaciones_campos.valida_ruc(lo_pnl_datos_entidad.TXT_numero_doc_id.getText().trim())) {
                                if (lo_pnl_datos_entidad.CBX_tipo_persona.getSelectedIndex() == 1) {
                                    if (lo_pnl_datos_entidad.TXT_numero_doc_id.getText().trim().substring(0, 2).equalsIgnoreCase("20")) {
                                        getFocusOwner().transferFocus();
                                    } else {
                                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "keyPressed", "RUC DEBE INICIAR CON 20");
                                    }
                                } else if (!lo_pnl_datos_entidad.TXT_numero_doc_id.getText().trim().substring(0, 2).equalsIgnoreCase("20")) {
                                    getFocusOwner().transferFocus();
                                } else {
                                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "keyPressed", "RUC NO DEBE INICIAR CON 20");
                                }

                            } else {
                                lo_pnl_datos_entidad.TXT_numero_doc_id.setText("");
                                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "keyPressed", "RUC INCORRECTO");
                            }
                        } else {
                            lo_pnl_datos_entidad.TXT_numero_doc_id.setText("");
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "keyPressed", "RUC INCORRECTO");
                        }
                    } else if (lo_cbx_tipo_doc_id.getID().equalsIgnoreCase("1")) {
                        if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_entidad.TXT_numero_doc_id.getText().trim(), 4, 8)) {
                            getFocusOwner().transferFocus();
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "keyPressed", "DNI INCORRECTO");
                        }
                    } else if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_entidad.TXT_numero_doc_id.getText().trim(), 1, 3)) {
                        getFocusOwner().transferFocus();
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "keyPressed", "NUMERO DOCUMENTO INCORRECTO");
                    }
                }
                if (ke.getSource() == lo_pnl_datos_entidad.TXT_papellido) {
                    if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_entidad.TXT_papellido.getText().trim(), 1, 3)) {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_datos_entidad.TXT_sapellido) {
                    if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_entidad.TXT_sapellido.getText().trim(), 1, 3)) {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_datos_entidad.TXT_nombre) {
                    if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_entidad.TXT_nombre.getText().trim(), 1, 3)) {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_datos_entidad.TXT_razon_social) {
                    if (li_tipo_operacion == 0) {
                        genera_codigo_entidad(lo_pnl_datos_entidad.TXT_razon_social.getText().trim());
                    }
                    if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_entidad.TXT_razon_social.getText().trim(), 1, 3)) {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_datos_entidad.TXT_direccion) {
                    if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_entidad.TXT_direccion.getText().trim(), 1, 3)) {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_datos_entidad.TXT_codigo_ubigeo && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_entidad.TXT_codigo_ubigeo)) {
                    get_descripcion_ubigeo(lo_pnl_datos_entidad.TXT_codigo_ubigeo, lo_pnl_datos_entidad.TXT_descripcion_ubigeo);
                }
                if (ke.getSource() == lo_pnl_datos_entidad.CBX_forma_pago || ke.getSource() == lo_pnl_datos_entidad.TXT_dias_cr || ke.getSource() == lo_pnl_datos_entidad.TXT_limite_cr || ke.getSource() == lo_pnl_datos_entidad.CBX_sucursal || ke.getSource() == lo_pnl_datos_entidad.CBX_vendedor || ke.getSource() == lo_pnl_datos_entidad.CBX_tipo_comercio || ke.getSource() == lo_pnl_datos_entidad.TXT_observacion || ke.getSource() == lo_pnl_datos_entidad.JRD_agente_percepcion || ke.getSource() == lo_pnl_datos_entidad.JRD_agente_retencion || ke.getSource() == lo_pnl_datos_entidad.JRD_entidad_excluida || ke.getSource() == lo_pnl_datos_entidad.JRD_es_domiciliado || ke.getSource() == lo_pnl_datos_entidad.CBX_sector) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_direccion.TXT_nombre_direccion && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_direccion.TXT_nombre_direccion.getText().trim(), 1, 3)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_direccion.TXT_direccion && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_direccion.TXT_direccion.getText().trim(), 1, 3)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_direccion.TXT_referencia) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_direccion.TXT_codigo_ubigeo && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_direccion.TXT_codigo_ubigeo)) {
                    get_descripcion_ubigeo(lo_pnl_datos_direccion.TXT_codigo_ubigeo, lo_pnl_datos_direccion.TXT_descripcion_ubigeo);
                }
                if (ke.getSource() == lo_pnl_datos_contacto.TXT_nombre_contacto && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_contacto.TXT_nombre_contacto.getText().trim(), 1, 3)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_contacto.TXT_cargo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_contacto.TXT_cargo.getText().trim(), 1, 3)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_contacto.TXT_telefono || ke.getSource() == lo_pnl_datos_contacto.TXT_anexo || ke.getSource() == lo_pnl_datos_contacto.TXT_celular || ke.getSource() == lo_pnl_datos_contacto.TXT_email) {
                    getFocusOwner().transferFocus();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_datos_entidad.TXT_nombre || ke.getSource() == lo_pnl_datos_entidad.TXT_sapellido || ke.getSource() == lo_pnl_datos_entidad.TXT_papellido) {
                genera_razon_social();
            }
        }
    };

    ItemListener ItemEvent = new ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent ie) {
            if (li_tipo_operacion != 2) {
                if (ie.getSource() == lo_pnl_datos_entidad.JRD_es_proveedor && li_tipo_operacion == 0) {
                    if (lo_pnl_datos_entidad.JRD_es_proveedor.isSelected() == true) {
                        lo_pnl_datos_entidad.CBX_tipo_documento_id.setEnabled(false);
                        lo_pnl_datos_entidad.JRD_es_trabajador.setEnabled(false);
                        lo_pnl_datos_entidad.JRD_es_trabajador.setSelected(false);
                        go_cbx_trato_datos.selecciona_valor(4, "6", lo_pnl_datos_entidad.CBX_tipo_documento_id);
                    } else {
                        lo_pnl_datos_entidad.JRD_es_trabajador.setEnabled(true);
                        lo_pnl_datos_entidad.CBX_tipo_documento_id.setEnabled(true);
                    }
                }
                if (ie.getSource() == lo_pnl_datos_entidad.JRD_es_trabajador && li_tipo_operacion == 0) {
                    if (lo_pnl_datos_entidad.JRD_es_trabajador.isSelected() == true) {
                        lo_pnl_datos_entidad.JRD_es_proveedor.setEnabled(false);
                        lo_pnl_datos_entidad.CBX_tipo_persona.setEnabled(false);
                        lo_pnl_datos_entidad.CBX_tipo_documento_id.setEnabled(false);
                        lo_pnl_datos_entidad.JRD_es_proveedor.setSelected(false);
                        lo_pnl_datos_entidad.CBX_tipo_persona.setSelectedIndex(0);
                        go_cbx_trato_datos.selecciona_valor(4, "1", lo_pnl_datos_entidad.CBX_tipo_documento_id);
                    } else {
                        lo_pnl_datos_entidad.JRD_es_proveedor.setEnabled(true);
                        lo_pnl_datos_entidad.CBX_tipo_persona.setEnabled(true);
                        lo_pnl_datos_entidad.CBX_tipo_documento_id.setEnabled(true);
                    }
                }
                if (ie.getSource() == lo_pnl_datos_entidad.CBX_tipo_persona) {
                    if (lo_pnl_datos_entidad.CBX_tipo_persona.getSelectedIndex() == 1) {
                        go_cbx_trato_datos.selecciona_valor(4, "6", lo_pnl_datos_entidad.CBX_tipo_documento_id);
                        lo_pnl_datos_entidad.CBX_tipo_documento_id.setEnabled(false);
                        lo_pnl_datos_entidad.TXT_papellido.setEnabled(false);
                        lo_pnl_datos_entidad.TXT_sapellido.setEnabled(false);
                        lo_pnl_datos_entidad.TXT_nombre.setEnabled(false);
                        lo_pnl_datos_entidad.TXT_papellido.setText("");
                        lo_pnl_datos_entidad.TXT_sapellido.setText("");
                        lo_pnl_datos_entidad.TXT_nombre.setText("");
                        lo_pnl_datos_entidad.TXT_razon_social.setEnabled(true);

                    } else {
                        lo_pnl_datos_entidad.TXT_papellido.setEnabled(true);
                        lo_pnl_datos_entidad.TXT_sapellido.setEnabled(true);
                        lo_pnl_datos_entidad.TXT_nombre.setEnabled(true);
                        lo_pnl_datos_entidad.TXT_razon_social.setEnabled(false);
                        if (lo_pnl_datos_entidad.JRD_es_proveedor.isSelected() == true) {
                            lo_pnl_datos_entidad.CBX_tipo_documento_id.setEnabled(false);
                        } else {
                            lo_pnl_datos_entidad.CBX_tipo_documento_id.setEnabled(true);
                        }
                    }
                }
                if (ie.getSource() == lo_pnl_datos_entidad.JRD_extranjero) {
                    if (lo_pnl_datos_entidad.JRD_extranjero.isSelected() == true) {
                        go_cbx_trato_datos.selecciona_valor(13, "US", lo_pnl_datos_entidad.CBX_pais);
                        lo_pnl_datos_entidad.CBX_pais.setEnabled(true);
                        lo_pnl_datos_entidad.TXT_codigo_ubigeo.setEnabled(false);
                        lo_pnl_datos_entidad.TXT_codigo_ubigeo.setText("999999");
                        lo_pnl_datos_entidad.TXT_descripcion_ubigeo.setText("");
                        lo_pnl_datos_entidad.JRD_es_domiciliado.setSelected(false);
                        get_descripcion_ubigeo(lo_pnl_datos_entidad.TXT_codigo_ubigeo, lo_pnl_datos_entidad.TXT_descripcion_ubigeo);
                    } else {
                        go_cbx_trato_datos.selecciona_valor(13, "PE", lo_pnl_datos_entidad.CBX_pais);
                        lo_pnl_datos_entidad.JRD_es_domiciliado.setSelected(true);
                        lo_pnl_datos_entidad.CBX_pais.setEnabled(false);
                        lo_pnl_datos_entidad.TXT_codigo_ubigeo.setEnabled(true);
                        lo_pnl_datos_entidad.TXT_codigo_ubigeo.setText("");
                        lo_pnl_datos_entidad.TXT_descripcion_ubigeo.setText("");
                    }
                }
                if (ie.getSource() == lo_pnl_datos_entidad.CBX_forma_pago) {
                    if (lo_pnl_datos_entidad.CBX_forma_pago.getSelectedIndex() == 1) {
                        lo_pnl_datos_entidad.TXT_limite_cr.setEnabled(true);
                        lo_pnl_datos_entidad.TXT_dias_cr.setEnabled(true);
                    } else {
                        lo_pnl_datos_entidad.TXT_limite_cr.setText(0 + "");
                        lo_pnl_datos_entidad.TXT_dias_cr.setText(0 + "");
                        lo_pnl_datos_entidad.TXT_limite_cr.setEnabled(false);
                        lo_pnl_datos_entidad.TXT_dias_cr.setEnabled(false);
                    }
                }
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TBP_entidad = new javax.swing.JTabbedPane();

        setClosable(true);
        setIconifiable(true);
        setTitle("ENTIDAD");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/CONFIG/IMAGES/entidad.png"))); // NOI18N

        TBP_entidad.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TBP_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(TBP_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TBP_entidad;
    // End of variables declaration//GEN-END:variables
}
