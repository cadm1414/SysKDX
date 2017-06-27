package JAVA.INVENT.GUI;

import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import java.awt.Image;
import java.awt.Toolkit;

public class dlg_ini_almacen extends javax.swing.JDialog {

    pnl_ini_almacen lo_pnl_ini_almacen = new pnl_ini_almacen();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    public static int ls_indicador;
    
    public dlg_ini_almacen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();  
        formulario();
    }

    private void formulario(){
        lo_pnl_ini_almacen.setBounds(10, 10, 500, 70);
        lo_pnl_aceptar_cancelar.setBounds(100, 70, 200, 50);
        
        this.add(lo_pnl_ini_almacen);
        this.add(lo_pnl_aceptar_cancelar);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PARAMETROS");
        setIconImage(getIconImage());
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_ini_almacen dialog = new dlg_ini_almacen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        ls_indicador = 0;
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_ancestro.class.getResource("parametros.png"));       
        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
