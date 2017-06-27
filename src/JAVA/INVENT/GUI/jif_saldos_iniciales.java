package JAVA.INVENT.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;

public class jif_saldos_iniciales extends javax.swing.JInternalFrame {

    pnl_grid_saldos_iniciales lo_pnl_grid_saldos_iniciales = new pnl_grid_saldos_iniciales();
    static int ls_indicador;
    
    public jif_saldos_iniciales() {
        initComponents();              
        formulario();
        parametros_iniciales();  
    }

    private void parametros_iniciales() {
        go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
        go_dlg_ini_almacen.setVisible(true);
        ls_indicador = go_dlg_ini_almacen.ls_indicador;
        if ( ls_indicador== 0) {
            this.dispose();
        }
    }

    private void formulario() {
        lo_pnl_grid_saldos_iniciales.setBounds(10, 200, 1000, 500);
        this.add(lo_pnl_grid_saldos_iniciales);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("SALDOS INICIALES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
