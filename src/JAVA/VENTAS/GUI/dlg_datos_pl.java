package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.IMAGES.VENTAS_ruta_images;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;

public class dlg_datos_pl extends javax.swing.JDialog {

    pnl_datos_pl lo_pnl_datos_pl = new pnl_datos_pl();
    ResultSet lq_rs;
    String codigo_entidad;

    public dlg_datos_pl(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_datos_pl.setBounds(10, 10, 700, 400);
        this.add(lo_pnl_datos_pl);
        
        codigo_entidad = gs_parametros[0];
        gs_parametros[0] = "";
        
        try {
            if (go_dao_transportista.SLT_cta_transportista() == 1) {
                lq_rs = go_dao_transportista.SLT_datos_pl("%");
                if (lq_rs != null) {
                    lo_pnl_datos_pl.TXT_codigo_transportista.setEnabled(false);
                    lo_pnl_datos_pl.TXT_codigo_transportista.setText(lq_rs.getString(1));
                    lo_pnl_datos_pl.TXT_nombre_transportista.setText(lq_rs.getString(2));
                    lo_pnl_datos_pl.TXT_licencia.setText(lq_rs.getString(3));
                    lo_pnl_datos_pl.TXT_empresa.setText(lq_rs.getString(4));
                    lo_pnl_datos_pl.TXT_ruc_empresa.setText(lq_rs.getString(5));
                    lo_pnl_datos_pl.TXT_codigo_vehiculo.setText(lq_rs.getString(6));
                    lo_pnl_datos_pl.TXT_marca.setText(lq_rs.getString(7));
                    lo_pnl_datos_pl.TXT_civ.setText(lq_rs.getString(8));
                    lo_pnl_datos_pl.TXT_codigo_vehiculo_v2.setText(lq_rs.getString(9));
                    lo_pnl_datos_pl.TXT_marca_v2.setText(lq_rs.getString(10));
                    lo_pnl_datos_pl.TXT_civ_v2.setText(lq_rs.getString(11));
                }
            }
        } catch (Exception e) {
        }

    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(VENTAS_ruta_images.class.getResource("camion.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DATOS TRANSPORTE");
        setIconImage(getIconImage());
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_datos_pl dialog = new dlg_datos_pl(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
