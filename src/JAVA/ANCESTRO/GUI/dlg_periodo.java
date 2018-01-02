package JAVA.ANCESTRO.GUI;

import JAVA.ANCESTRO.BEAN.BEAN_periodo_empresa;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class dlg_periodo extends javax.swing.JDialog {

    pnl_periodo lo_pnl_periodo = new pnl_periodo();
    BEAN_periodo_empresa lo_bean_periodo_empresa = new BEAN_periodo_empresa();
    ResultSet lq_rs;

    public dlg_periodo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
        get_periodo();
    }

    private void formulario() {
        lo_pnl_periodo.setBounds(0, 0, 300, 100);
        PNL_periodo.add(lo_pnl_periodo);

        lo_pnl_periodo.BTN_aceptar.addActionListener(listener);
        lo_pnl_periodo.CBX_periodo.addKeyListener(KeyEvnt);
        lo_pnl_periodo.BTN_aceptar.addKeyListener(KeyEvnt);

    }

    private void get_periodo() {

        lo_bean_periodo_empresa.setCodigo_empresa(gi_codigo_empresa);
        lq_rs = go_dao_periodo_empresa.SLT_datos_x_empresa(lo_bean_periodo_empresa);

        if (lq_rs != null) {
            try {
                do {
                    lo_pnl_periodo.CBX_periodo.addItem(lq_rs.getString(1));
                } while (lq_rs.next());
            } catch (Exception e) {
            }
        }
    }

    private void evt_aceptar() {
        gs_periodo = lo_pnl_periodo.CBX_periodo.getSelectedItem().toString().trim();
        dispose();
    }

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_periodo.BTN_aceptar) {
                evt_aceptar();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_periodo.CBX_periodo) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_periodo.BTN_aceptar) {
                    evt_aceptar();
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

        PNL_periodo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CAMBIAR PERIODO");
        setIconImage(getIconImage());

        javax.swing.GroupLayout PNL_periodoLayout = new javax.swing.GroupLayout(PNL_periodo);
        PNL_periodo.setLayout(PNL_periodoLayout);
        PNL_periodoLayout.setHorizontalGroup(
            PNL_periodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        PNL_periodoLayout.setVerticalGroup(
            PNL_periodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PNL_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PNL_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dlg_periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlg_periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlg_periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlg_periodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_periodo dialog = new dlg_periodo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_ancestro.class.getResource("calendario.png"));
        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNL_periodo;
    // End of variables declaration//GEN-END:variables
}
