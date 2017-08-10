package JAVA.CONFIG.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import static JAVA.ANCESTRO.LOGICA.variables_globales.go_cbx_trato_datos;
import static JAVA.ANCESTRO.LOGICA.variables_globales.go_dao_tabla_sunat;
import JAVA.CONFIG.LOGICA.cbx_tabla_sunat;
import JAVA.CONFIG.LOGICA.evt_datos_entidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class jif_datos_entidad extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    pnl_datos_entidad lo_pnl_datos_entidad = new pnl_datos_entidad();
    evt_datos_entidad lo_evt_datos_entidad = new evt_datos_entidad();
    pnl_datos_contacto lo_pnl_datos_contacto = new pnl_datos_contacto();
    pnl_datos_direccion lo_pnl_datos_direccion = new pnl_datos_direccion();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    cbx_tabla_sunat lo_cbx_tipo_doc_id;
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs;
    int li_tipo_operacion;
    String ls_codigo, ls_codigo_ubigeo;
    String ls_opcion = "M C F";
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "jif_datos_entidad";

    public jif_datos_entidad() {
        initComponents();
        formulario();
        activa_botones();
        get_tabla_sunat();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        TBP_entidad.addTab("REGISTRO", lo_pnl_datos_entidad);
        TBP_entidad.addTab("DIRECCION", lo_pnl_datos_direccion);
        TBP_entidad.addTab("CONTACTO", lo_pnl_datos_contacto);

        this.add(lo_pnl_opciones_2);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);
        lo_evt_datos_entidad.evento_press(lo_pnl_datos_entidad, KeyEvnt);
        lo_evt_datos_entidad.evento_item(lo_pnl_datos_entidad, ItemEvent);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void get_tabla_sunat() {
        lq_rs = go_dao_tabla_sunat.SLT_cbx_tabla_sunat("002");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(4, lq_rs, lo_pnl_datos_entidad.CBX_tipo_documento_id);
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_datos_entidad.limpia_datos(lo_pnl_datos_entidad);
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_entidad.activa_campos(0, lo_pnl_datos_entidad, true);
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_opciones_2.BTN_nuevo) {
                evt_nuevo();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_buscar) {
                //evt_buscar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_editar) {
                //evt_editar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_eliminar) {
                //evt_eliminar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_guardar) {
                //evt_guardar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_cancelar) {
                //evt_cancelar();
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
//            if (ke.getKeyCode() == KeyEvent.VK_F5) {
//                if (ke.getSource() == lo_pnl_datos_almacen.TXT_ubigeo) {
//                    evt_f5();
//                }
//            }
            if (ke.getKeyCode() == KeyEvent.VK_F1 && lo_pnl_opciones_2.BTN_nuevo.isEnabled()) {
                evt_nuevo();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F2 && lo_pnl_opciones_2.BTN_buscar.isEnabled()) {
                //evt_buscar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F3 && lo_pnl_opciones_2.BTN_editar.isEnabled()) {
                //evt_editar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F4 && lo_pnl_opciones_2.BTN_eliminar.isEnabled()) {
                //evt_eliminar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_opciones_2.BTN_guardar.isEnabled()) {
                //evt_guardar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE && lo_pnl_opciones_2.BTN_cancelar.isEnabled()) {
                //evt_cancelar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_opciones_2.BTN_nuevo) {
                    evt_nuevo();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_buscar) {
                    //evt_buscar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_editar) {
                    //evt_editar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_eliminar) {
                    //evt_eliminar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_guardar) {
                    //evt_guardar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_cancelar) {
                    //evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_reporte) {
                    //evt_reporte();
                }
                if (ke.getSource() == lo_pnl_datos_entidad.JRD_es_cliente || ke.getSource() == lo_pnl_datos_entidad.JRD_es_proveedor || ke.getSource() == lo_pnl_datos_entidad.JRD_es_trabajador || ke.getSource() == lo_pnl_datos_entidad.JRD_nacional || ke.getSource() == lo_pnl_datos_entidad.JRD_extranjero || ke.getSource() == lo_pnl_datos_entidad.CBX_estado || ke.getSource() == lo_pnl_datos_entidad.CBX_tipo_documento_id) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_entidad.CBX_tipo_persona) {
                    if (lo_pnl_datos_entidad.CBX_tipo_persona.getSelectedIndex() == 1) {
                        go_cbx_trato_datos.selecciona_valor(4, "6", lo_pnl_datos_entidad.CBX_tipo_documento_id);
                    }
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_entidad.TXT_numero_doc_id && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_entidad.TXT_numero_doc_id)) {
                    if (lo_cbx_tipo_doc_id.getID().equalsIgnoreCase("6")) {
                        if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_entidad.TXT_numero_doc_id.getText().trim(), 4, 11)) {
                            if (go_fnc_operaciones_campos.valida_ruc(lo_pnl_datos_entidad.TXT_numero_doc_id.getText().trim())) {
                                getFocusOwner().transferFocus();
                            } else {
                                lo_pnl_datos_entidad.TXT_numero_doc_id.setText("");
                                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "keyPressed", "RUC INCORRECTO");
                            }
                        }else{
                            lo_pnl_datos_entidad.TXT_numero_doc_id.setText("");
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "keyPressed", "RUC INCORRECTO");
                        }
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }
    };

    ItemListener ItemEvent = new ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent ie) {
            if (ie.getSource() == lo_pnl_datos_entidad.JRD_es_proveedor) {
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
            if (ie.getSource() == lo_pnl_datos_entidad.JRD_es_trabajador) {
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
                }
            }
            if (ie.getSource() == lo_pnl_datos_entidad.CBX_tipo_documento_id) {
                lo_cbx_tipo_doc_id = (cbx_tabla_sunat) lo_pnl_datos_entidad.CBX_tipo_documento_id.getSelectedItem();
                if (lo_cbx_tipo_doc_id.getID().equalsIgnoreCase("6")) {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TBP_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(TBP_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TBP_entidad;
    // End of variables declaration//GEN-END:variables
}
