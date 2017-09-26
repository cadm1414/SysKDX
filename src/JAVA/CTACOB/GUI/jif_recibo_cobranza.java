package JAVA.CTACOB.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import JAVA.ANCESTRO.LOGICA.evt_opciones_3;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.CTACOB.LOGICA.evt_cab_recibo_cobranza;
import JAVA.CTACOB.LOGICA.evt_grid_recibo_cobranza;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class jif_recibo_cobranza extends javax.swing.JInternalFrame {

    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    evt_opciones_3 lo_evt_opciones_3 = new evt_opciones_3();
    pnl_cab_recibo_cobranza lo_pnl_cab_recibo_cobranza = new pnl_cab_recibo_cobranza();
    evt_cab_recibo_cobranza lo_evt_cab_recibo_cobranza = new evt_cab_recibo_cobranza();
    pnl_grid_recibo_cobranza lo_pnl_grid_recibo_cobranza = new pnl_grid_recibo_cobranza();
    evt_grid_recibo_cobranza lo_evt_grid_recibo_cobranza = new evt_grid_recibo_cobranza();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs;
    cbx_moneda lo_cbx_moneda;
    int li_tipo_operacion;
    String ls_codigo_sucursal, ls_serie, ls_codigo;
    String ls_opcion = "M A A";
    String ls_modulo = "CTACOB", ls_capa = "GUI", ls_clase = "jif_recibo_cobranza";

    public jif_recibo_cobranza() {
        initComponents();
        formulario();
        activa_botones();
        get_moneda();
        get_banco();
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 120);
        lo_pnl_cab_recibo_cobranza.setBounds(12, 130, 1000, 240);
        lo_pnl_grid_recibo_cobranza.setBounds(15, 370, 1000, 280);

        this.add(lo_pnl_opciones_3);
        this.add(lo_pnl_cab_recibo_cobranza);
        this.add(lo_pnl_grid_recibo_cobranza);

        ls_codigo_sucursal = gs_parametros[0];
        ls_serie = gs_parametros[2];
        lo_pnl_cab_recibo_cobranza.TXT_sucursal.setText(gs_parametros[1]);
        lo_pnl_cab_recibo_cobranza.TXT_serie.setText(gs_parametros[2]);

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";

        lo_evt_opciones_3.evento_click(lo_pnl_opciones_3, Listener);
        lo_evt_opciones_3.evento_press(lo_pnl_opciones_3, KeyEvnt);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
    }

    private void get_banco() {
        lq_rs = go_dao_banco.SLT_cbx_moneda();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(17, lq_rs, lo_pnl_cab_recibo_cobranza.CBX_banco);
        }
    }

    private void get_moneda() {
        lq_rs = go_dao_moneda.SLT_moneda_x_visible("S");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(0, lq_rs, lo_pnl_cab_recibo_cobranza.CBX_moneda);
        }
    }

    private void get_tipo_cambio() {
        lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_recibo_cobranza.CBX_moneda.getSelectedItem();
        lo_pnl_grid_recibo_cobranza.LBL_simbolo.setText(lo_cbx_moneda.simbolo_moneda().trim());
        lo_pnl_cab_recibo_cobranza.TXT_tipo_cambio.setEnabled(false);
        lo_pnl_cab_recibo_cobranza.TXT_tipo_cambio.setText("0.000");
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_cab_recibo_cobranza.limpia_datos(lo_pnl_cab_recibo_cobranza);
        lo_evt_grid_recibo_cobranza.limpia_tabla(lo_pnl_grid_recibo_cobranza, li_tipo_operacion);
        li_tipo_operacion = 0;
        try {
            lq_rs = go_dao_recibo_cobranza.FNC_correlativo_recibo_cobranza("RC", ls_serie, ls_codigo_sucursal);
            if (lq_rs.next()) {
                lo_pnl_cab_recibo_cobranza.TXT_numero_doc.setText(lq_rs.getString(1));
                lo_pnl_cab_recibo_cobranza.LBL_numero_doc.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }

        lo_evt_cab_recibo_cobranza.activa_campos(0, lo_pnl_cab_recibo_cobranza, true);
        lo_evt_opciones_3.activa_btn_opciones(1, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_grid_recibo_cobranza.activa_campos(0, lo_pnl_grid_recibo_cobranza, true);
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_opciones_3.BTN_nuevo) {
                evt_nuevo();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_buscar) {
                //evt_buscar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_editar) {
                //evt_editar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_eliminar) {
                //evt_eliminar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_cancelar) {
                //evt_cancelar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_guardar) {
                //evt_guardar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_imprimir) {
                //evt_imprimir(lo_bean_pedido.getStatus(), lo_bean_pedido.getCodigo_operacion());
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F1 && lo_pnl_opciones_3.BTN_nuevo.isEnabled()) {
                evt_nuevo();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F2 && lo_pnl_opciones_3.BTN_buscar.isEnabled()) {
                //evt_buscar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F3 && lo_pnl_opciones_3.BTN_editar.isEnabled()) {
                //evt_editar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F4 && lo_pnl_opciones_3.BTN_eliminar.isEnabled()) {
                // evt_eliminar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE && lo_pnl_opciones_3.BTN_cancelar.isEnabled()) {
                // evt_cancelar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_opciones_3.BTN_guardar.isEnabled()) {
                //evt_guardar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_opciones_3.BTN_nuevo) {
                    evt_nuevo();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_buscar) {
                    //evt_buscar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_editar) {
                    //evt_editar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_eliminar) {
                    //evt_eliminar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_guardar) {
                    //evt_guardar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_cancelar) {
                    //evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_imprimir) {
                    //evt_imprimir(lo_bean_pedido.getStatus(), lo_bean_pedido.getCodigo_operacion());
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }

    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setTitle("RECIBO DE COBRANZA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 881, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
