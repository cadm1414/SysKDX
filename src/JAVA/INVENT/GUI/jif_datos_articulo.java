package JAVA.INVENT.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.LOGICA.cbx_tabla_sunat;
import JAVA.CONFIG.LOGICA.cbx_unidad_medida;
import JAVA.INVENT.BEAN.BEAN_articulo;
import JAVA.INVENT.LOGICA.cbx_familia;
import JAVA.INVENT.LOGICA.cbx_grupo_detraccion;
import JAVA.INVENT.LOGICA.cbx_grupo_percepcion;
import JAVA.INVENT.LOGICA.cbx_marca;
import JAVA.INVENT.LOGICA.cbx_producto;
import JAVA.INVENT.LOGICA.cbx_subfamilia;
import JAVA.INVENT.LOGICA.evt_datos_articulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class jif_datos_articulo extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    pnl_datos_articulo lo_pnl_datos_articulo = new pnl_datos_articulo();
    evt_datos_articulo lo_evt_datos_articulo = new evt_datos_articulo();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    BEAN_articulo lo_bean_articulo = new BEAN_articulo();
    static boolean lb_valor_op[] = new boolean[8];
    cbx_familia lo_cbx_familia;
    cbx_marca lo_cbx_marca;
    cbx_producto lo_cbx_producto;
    cbx_unidad_medida lo_cbx_unidad, lo_cbx_um_bulto;
    cbx_tabla_sunat lo_cbx_existencia;
    cbx_grupo_detraccion lo_cbx_grupo_detraccion;
    cbx_grupo_percepcion lo_cbx_grupo_percepcion;
    cbx_subfamilia lo_cbx_subfamilia;
    ResultSet lq_rs = null;
    int li_tipo_operacion;
    String ls_codigo, ls_codigo_generado, ls_nombre, ls_correlativo, ls_letra, ls_afecto_detraccion, ls_afecto_percepcion, ls_clase_producto;
    String ls_opcion = "M C E";
    String ls_modulo = "INVENT", ls_capa = "GUI", ls_clase = "jif_datos_articulo";

    public jif_datos_articulo() {
        initComponents();
        formulario();
        activa_botones();
        get_producto();
        get_marca();
        get_familia();
        get_unidad_media();
        get_um_bulto();
        get_tabla_sunat();
        get_grupo_detraccion();
        get_grupo_percepcion();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_articulo.setBounds(12, 130, 500, 420);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_articulo);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);

        lo_evt_datos_articulo.evento_press(lo_pnl_datos_articulo, KeyEvnt);
        lo_evt_datos_articulo.evento_item(lo_pnl_datos_articulo, ItemEvent);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void get_producto() {
        lq_rs = go_dao_producto.SLT_cbx_producto("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(6, lq_rs, lo_pnl_datos_articulo.CBX_producto);
        }
    }

    private void get_marca() {
        lq_rs = go_dao_marca.SLT_cbx_marca("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(7, lq_rs, lo_pnl_datos_articulo.CBX_marca);
        }
    }

    private void get_unidad_media() {
        lq_rs = go_dao_unidad_medida.SLT_cbx_unidad_medida();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(8, lq_rs, lo_pnl_datos_articulo.CBX_unidad_medida);
        }
    }

    private void get_um_bulto() {
        lq_rs = go_dao_unidad_medida.SLT_cbx_unidad_medida();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(8, lq_rs, lo_pnl_datos_articulo.CBX_um_bulto);
        }
    }

    private void get_tabla_sunat() {
        lq_rs = go_dao_tabla_sunat.SLT_cbx_tabla_sunat("005");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(4, lq_rs, lo_pnl_datos_articulo.CBX_existencia);
        }
    }

    private void get_grupo_detraccion() {
        lq_rs = go_dao_grupo_detraccion.SLT_cbx_grupo_detraccion("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(10, lq_rs, lo_pnl_datos_articulo.CBX_detraccion);
        }
    }

    private void get_grupo_percepcion() {
        lq_rs = go_dao_grupo_percepcion.SLT_cbx_grupo_percepcion("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(11, lq_rs, lo_pnl_datos_articulo.CBX_percepcion);
        }
    }

    private void get_familia() {
        lq_rs = go_dao_familia.SLT_cbx_familia();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(5, lq_rs, lo_pnl_datos_articulo.CBX_familia);
        }
        get_subfamilia();
    }

    private void get_subfamilia() {
        lo_pnl_datos_articulo.CBX_subfamilia.removeAllItems();
        lo_cbx_familia = (cbx_familia) lo_pnl_datos_articulo.CBX_familia.getSelectedItem();
        lq_rs = go_dao_subfamilia.SLT_cbx_subfamilia_x_familia(lo_cbx_familia.getID());
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(9, lq_rs, lo_pnl_datos_articulo.CBX_subfamilia);
        }
    }

    private void get_descripcion_articulo(String codigo) {
        try {
            lq_rs = go_dao_articulo.SLT_datos_articulo(codigo);
            if (lq_rs != null) {
                lo_evt_datos_articulo.setea_recupera(lo_bean_articulo, lq_rs);
                lo_evt_datos_articulo.muestra_datos(lo_pnl_datos_articulo, lo_bean_articulo);
               
                ls_clase_producto = lo_bean_articulo.getClase_producto();
                if(lo_pnl_datos_articulo.CBX_detraccion.getSelectedIndex()==0){
                    ls_afecto_detraccion = "0";
                }else{
                    ls_afecto_detraccion = "1";
                }
                if(lo_pnl_datos_articulo.CBX_percepcion.getSelectedIndex()==0){
                    ls_afecto_percepcion = "0";
                }else{
                    ls_afecto_percepcion = "1";
                }
            }
        } catch (Exception e) {
        }
    }

    private void genera_nombre() {
        ls_nombre = lo_pnl_datos_articulo.CBX_producto.getSelectedItem() + " " + lo_pnl_datos_articulo.CBX_marca.getSelectedItem() + " " + lo_pnl_datos_articulo.TXT_caracteristica.getText().trim();
        lo_pnl_datos_articulo.TXT_nombre.setText(ls_nombre);
    }

    private void genera_letra() {
        if (lo_cbx_um_bulto.getID().equalsIgnoreCase("0007")) {
            ls_letra = "C";
            lo_pnl_datos_articulo.TXT_tara.setEnabled(true);
            lo_pnl_datos_articulo.TXT_tara.setText("");
        } else {
            ls_letra = "B";
            lo_pnl_datos_articulo.TXT_tara.setEnabled(false);
            if (li_tipo_operacion == 0) {
                lo_pnl_datos_articulo.TXT_tara.setEnabled(false);
                lo_pnl_datos_articulo.TXT_tara.setText("0.000");
            }
        }
    }

    private void activa_campos() {
        try {
            lq_rs = go_dao_articulo.FNC_activa_campos_articulo(lo_cbx_producto.getID());
            if (lq_rs != null) {
                ls_afecto_detraccion = lq_rs.getString(1);
                ls_afecto_percepcion = lq_rs.getString(2);
                ls_clase_producto = lq_rs.getString(3);
            }

            if (ls_afecto_detraccion.equalsIgnoreCase("0")) {
                lo_pnl_datos_articulo.CBX_detraccion.setEnabled(false);
            } else {
                lo_pnl_datos_articulo.CBX_detraccion.setEnabled(true);
            }

            if (ls_afecto_percepcion.equalsIgnoreCase("0")) {
                lo_pnl_datos_articulo.CBX_percepcion.setEnabled(false);
            } else {
                lo_pnl_datos_articulo.CBX_percepcion.setEnabled(true);
            }
        } catch (Exception e) {
        }
    }

    private void genera_codigo() {
        lo_cbx_producto = (cbx_producto) lo_pnl_datos_articulo.CBX_producto.getSelectedItem();
        lo_cbx_marca = (cbx_marca) lo_pnl_datos_articulo.CBX_marca.getSelectedItem();
        lo_cbx_um_bulto = (cbx_unidad_medida) lo_pnl_datos_articulo.CBX_um_bulto.getSelectedItem();

        try {
            lq_rs = go_dao_articulo.FNC_correlativo_articulo(lo_cbx_producto.getID(), lo_cbx_marca.getID());
            if (lq_rs.next()) {
                ls_correlativo = lq_rs.getString(1);
            }
        } catch (Exception e) {
        }
        genera_letra();
        ls_codigo_generado = lo_cbx_producto.getID() + lo_cbx_marca.getID() + ls_correlativo + ls_letra;
        lo_pnl_datos_articulo.TXT_codigo.setText(ls_codigo_generado);
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_datos_articulo.limpia_datos(lo_pnl_datos_articulo);
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_articulo.activa_campos(0, lo_pnl_datos_articulo, true);
        activa_campos();
        genera_codigo();
        genera_nombre();
    }

    private void evt_buscar() {
        li_tipo_operacion = 2;
        go_dlg_busq_articulo = new dlg_busq_articulo(null, true);
        go_dlg_busq_articulo.setVisible(true);
        ls_codigo = go_dlg_busq_articulo.ls_codigo_articulo;
        if (ls_codigo != null) {
            get_descripcion_articulo(ls_codigo);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE ARTICULO");
            lo_evt_datos_articulo.limpia_datos(lo_pnl_datos_articulo);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_editar() {        
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        int cant = go_dao_articulo_costo.SLT_cta_articulo_costo_x_articulo(ls_codigo);        
        if (cant == 0) {
            lo_evt_datos_articulo.activa_campos(1, lo_pnl_datos_articulo, true);
        }else{
            lo_evt_datos_articulo.activa_campos(2, lo_pnl_datos_articulo, true);
        }        
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR ARTICULO " + lo_bean_articulo.getNombre_articulo() + "?") == 0) {
            try {
                if (go_dao_articulo.DLT_articulo(ls_codigo)) {
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_articulo.activa_campos(0, lo_pnl_datos_articulo, false);
                    lo_evt_datos_articulo.limpia_datos(lo_pnl_datos_articulo);
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_guardar() {        
        lo_cbx_familia = (cbx_familia) lo_pnl_datos_articulo.CBX_familia.getSelectedItem();
        lo_cbx_existencia = (cbx_tabla_sunat) lo_pnl_datos_articulo.CBX_existencia.getSelectedItem();
        lo_cbx_producto = (cbx_producto) lo_pnl_datos_articulo.CBX_producto.getSelectedItem();
        lo_cbx_marca = (cbx_marca) lo_pnl_datos_articulo.CBX_marca.getSelectedItem();
        lo_cbx_unidad = (cbx_unidad_medida) lo_pnl_datos_articulo.CBX_unidad_medida.getSelectedItem();
        lo_cbx_um_bulto = (cbx_unidad_medida) lo_pnl_datos_articulo.CBX_um_bulto.getSelectedItem();
        lo_cbx_grupo_detraccion = (cbx_grupo_detraccion) lo_pnl_datos_articulo.CBX_detraccion.getSelectedItem();
        lo_cbx_grupo_percepcion = (cbx_grupo_percepcion) lo_pnl_datos_articulo.CBX_percepcion.getSelectedItem();
        lo_cbx_subfamilia = (cbx_subfamilia) lo_pnl_datos_articulo.CBX_subfamilia.getSelectedItem();
        lo_bean_articulo.setClase_producto(ls_clase_producto);
        lo_bean_articulo.setAfecto_detraccion(ls_afecto_detraccion);
        lo_bean_articulo.setAfecto_percepcion(ls_afecto_percepcion);
        /*
        NUEVO = 0
        EDITAR = 1
         */
        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_articulo.valida_campos(lo_pnl_datos_articulo, ls_afecto_detraccion, ls_afecto_percepcion)) {
                    try {
                        lo_evt_datos_articulo.setea_campos(lo_bean_articulo, lo_pnl_datos_articulo, lo_cbx_familia, lo_cbx_marca, lo_cbx_producto, lo_cbx_unidad, lo_cbx_um_bulto, lo_cbx_existencia, lo_cbx_grupo_detraccion, lo_cbx_grupo_percepcion, lo_cbx_subfamilia);
                        if (go_dao_articulo.IST_articulo(lo_bean_articulo)) {
                            lo_evt_datos_articulo.limpia_datos(lo_pnl_datos_articulo);
                            lo_evt_datos_articulo.activa_campos(0, lo_pnl_datos_articulo, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_articulo.verifica_cambios(lo_bean_articulo, lo_pnl_datos_articulo, lo_cbx_unidad, lo_cbx_existencia, lo_cbx_grupo_detraccion, lo_cbx_grupo_percepcion, lo_cbx_familia, lo_cbx_subfamilia)) {
                    if (lo_evt_datos_articulo.valida_campos(lo_pnl_datos_articulo, ls_afecto_detraccion, ls_afecto_percepcion)) {
                        try {
                            lo_evt_datos_articulo.setea_campos(lo_bean_articulo, lo_pnl_datos_articulo, lo_cbx_familia, lo_cbx_marca, lo_cbx_producto, lo_cbx_unidad, lo_cbx_um_bulto, lo_cbx_existencia, lo_cbx_grupo_detraccion, lo_cbx_grupo_percepcion, lo_cbx_subfamilia);
                            if (go_dao_articulo.UPD_articulo(lo_bean_articulo)) {
                                lo_evt_datos_articulo.limpia_datos(lo_pnl_datos_articulo);
                                lo_evt_datos_articulo.activa_campos(0, lo_pnl_datos_articulo, false);
                                lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
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
        li_tipo_operacion = 2;
        lo_evt_datos_articulo.activa_campos(0, lo_pnl_datos_articulo, false);
        if (ls_codigo != null) {
            lo_evt_datos_articulo.muestra_datos(lo_pnl_datos_articulo, lo_bean_articulo);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_articulo.limpia_datos(lo_pnl_datos_articulo);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
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
                //evt_reporte();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
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
                    //evt_reporte();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_producto) {
                    genera_codigo();
                    genera_nombre();
                    lo_pnl_datos_articulo.CBX_marca.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_marca) {
                    genera_codigo();
                    genera_nombre();
                    lo_pnl_datos_articulo.TXT_caracteristica.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.TXT_caracteristica) {
                    lo_pnl_datos_articulo.CBX_unidad_medida.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_unidad_medida) {
                    if (lo_pnl_datos_articulo.CBX_um_bulto.isEnabled()) {
                        lo_pnl_datos_articulo.CBX_um_bulto.requestFocus();
                    } else {
                        if (lo_pnl_datos_articulo.TXT_tara.isEnabled()) {
                            lo_pnl_datos_articulo.TXT_tara.requestFocus();
                        } else {
                            lo_pnl_datos_articulo.CBX_estado.requestFocus();
                        }
                    }
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_um_bulto) {
                    genera_codigo();
                    if (lo_pnl_datos_articulo.TXT_tara.isEnabled()) {
                        lo_pnl_datos_articulo.TXT_tara.requestFocus();
                    } else {
                        lo_pnl_datos_articulo.CBX_estado.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_datos_articulo.TXT_tara) {
                    lo_pnl_datos_articulo.CBX_estado.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_estado) {
                    lo_pnl_datos_articulo.CBX_afecto.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_afecto) {
                    lo_pnl_datos_articulo.CBX_existencia.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_existencia) {
                    if (lo_pnl_datos_articulo.CBX_detraccion.isEnabled()) {
                        lo_pnl_datos_articulo.CBX_detraccion.requestFocus();
                    } else {
                        if (lo_pnl_datos_articulo.CBX_percepcion.isEnabled()) {
                            lo_pnl_datos_articulo.CBX_percepcion.requestFocus();
                        } else {
                            lo_pnl_datos_articulo.CBX_operacion.requestFocus();
                        }
                    }
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_detraccion) {
                    if (lo_pnl_datos_articulo.CBX_percepcion.isEnabled()) {
                        lo_pnl_datos_articulo.CBX_percepcion.requestFocus();
                    } else {
                        lo_pnl_datos_articulo.CBX_operacion.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_percepcion) {
                    lo_pnl_datos_articulo.CBX_operacion.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_operacion) {
                    lo_pnl_datos_articulo.TXT_codigo_barra.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.TXT_codigo_barra) {
                    lo_pnl_datos_articulo.CBX_familia.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_familia) {
                    lo_pnl_datos_articulo.CBX_subfamilia.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.CBX_subfamilia) {
                    lo_pnl_datos_articulo.TXT_observacion.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo.TXT_observacion) {
                    lo_pnl_opciones_2.BTN_guardar.requestFocus();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_datos_articulo.TXT_caracteristica) {
                genera_nombre();
            }
        }
    };

    ItemListener ItemEvent = new ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent ie) {
            if (li_tipo_operacion != 2) {
                if (ie.getSource() == lo_pnl_datos_articulo.CBX_marca || ie.getSource() == lo_pnl_datos_articulo.CBX_um_bulto) {
                    genera_codigo();
                    genera_nombre();
                }
                if (ie.getSource() == lo_pnl_datos_articulo.CBX_producto) {
                    genera_codigo();
                    genera_nombre();
                    activa_campos();
                }
                if (ie.getSource() == lo_pnl_datos_articulo.CBX_familia) {
                    get_subfamilia();
                }
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("ITEM");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/INVENT/IMAGES/articulo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
