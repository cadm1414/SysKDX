package JAVA.INVENT.GUI;

import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;

public class jif_saldos_iniciales extends javax.swing.JInternalFrame {

    pnl_grid_saldos_iniciales lo_pnl_grid_saldos_iniciales = new pnl_grid_saldos_iniciales();
    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    static int ls_indicador;
    
    public jif_saldos_iniciales() {
        initComponents();              
        formulario(); 
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 150);
        lo_pnl_grid_saldos_iniciales.setBounds(15, 200, 1000, 500);        
        
        this.add(lo_pnl_opciones_3);
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
