package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.VENTAS.LOGICA.evt_cierre_pedidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jif_cierre_pedidos extends javax.swing.JInternalFrame {

    pnl_cierre_pedidos lo_pnl_cierre_pedidos = new pnl_cierre_pedidos();
    evt_cierre_pedidos lo_evt_cierre_pedidos = new evt_cierre_pedidos();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs;
    String ls_opcion = "M A H";
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "jif_cierre_pedidos";

    public jif_cierre_pedidos() {
        initComponents();
        formulario();
        activa_botones();
    }

    private void formulario() {
        lo_pnl_cierre_pedidos.setBounds(0, 10, 600, 600);
        this.add(lo_pnl_cierre_pedidos);

        lo_pnl_cierre_pedidos.TXT_codigo.addKeyListener(KeyEvnt);
        lo_pnl_cierre_pedidos.CBX_serie.addKeyListener(KeyEvnt);
        lo_pnl_cierre_pedidos.BTN_guardar.addKeyListener(KeyEvnt);
        lo_pnl_cierre_pedidos.BTN_guardar.addActionListener(Listener);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_cierre_pedidos.activa_campos(0, lo_pnl_cierre_pedidos, true, lb_valor_op);
    }

    private void limpia_datos() {
        lo_pnl_cierre_pedidos.TXT_codigo.setText("");
        lo_pnl_cierre_pedidos.TXT_nombre.setText("");
        lo_pnl_cierre_pedidos.CBX_serie.removeAllItems();
        lo_pnl_cierre_pedidos.TXT_codigo.requestFocus();
    }

    private void get_serie(String codigo) {
        lo_pnl_cierre_pedidos.CBX_serie.removeAllItems();
        lo_evt_cierre_pedidos.limpia_tabla(lo_pnl_cierre_pedidos);
        try {
            lq_rs = go_dao_serie.SLT_cbx_serie(codigo);
            if (lq_rs != null) {
                do {
                    lo_pnl_cierre_pedidos.CBX_serie.addItem(lq_rs.getString(1));
                } while (lq_rs.next());
                lo_pnl_cierre_pedidos.CBX_serie.requestFocus();
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_serie", "SUCURSAL NO CUENTA CON SERIE");
                limpia_datos();
            }
        } catch (Exception e) {
        }
    }

    private void evt_guardar() {
        if (lo_evt_cierre_pedidos.cuenta_seleccion(lo_pnl_cierre_pedidos) > 0) {
            try {
                if (go_dao_pedido_detalle.UPD_actualiza_facturado(lo_pnl_cierre_pedidos.TBL_pedidos)) {
                    limpia_datos();
                    lo_evt_cierre_pedidos.limpia_tabla(lo_pnl_cierre_pedidos);
                }
            } catch (Exception e) {
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_guardar", "SELECCIONE PEDIDO(S)");
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_cierre_pedidos.BTN_guardar) {
                evt_guardar();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_cierre_pedidos.BTN_guardar.isEnabled()) {
                evt_guardar();
            }

            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_cierre_pedidos.TXT_codigo) {
                    go_activa_buscador.busq_almacen_permiso("2", "2", "1", lo_pnl_cierre_pedidos.TXT_codigo, lo_pnl_cierre_pedidos.TXT_nombre);
                    get_serie(lo_pnl_cierre_pedidos.TXT_codigo.getText().trim());
                }
            }

            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_cierre_pedidos.TXT_codigo && go_fnc_operaciones_campos.campo_blanco(lo_pnl_cierre_pedidos.TXT_codigo)) {
                    lo_pnl_cierre_pedidos.TXT_codigo.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cierre_pedidos.TXT_codigo.getText().trim(), "0", 4));
                    go_activa_buscador.get_descripcion_almacen_permiso(lo_pnl_cierre_pedidos.TXT_codigo.getText().trim(), "2", "1", lo_pnl_cierre_pedidos.TXT_codigo, lo_pnl_cierre_pedidos.TXT_nombre);
                    get_serie(lo_pnl_cierre_pedidos.TXT_codigo.getText().trim());
                }
                if (ke.getSource() == lo_pnl_cierre_pedidos.CBX_serie && lo_pnl_cierre_pedidos.CBX_serie.getItemCount() > 0) {
                    lo_evt_cierre_pedidos.limpia_tabla(lo_pnl_cierre_pedidos);
                    lo_evt_cierre_pedidos.recupera_detalle(lo_pnl_cierre_pedidos.TXT_codigo.getText().trim(), lo_pnl_cierre_pedidos.CBX_serie.getSelectedItem().toString(), lo_pnl_cierre_pedidos);
                    lo_pnl_cierre_pedidos.TBL_pedidos.requestFocus();
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
        setIconifiable(true);
        setTitle("CIERRE PEDIDOS");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/VENTAS/IMAGES/baja.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
