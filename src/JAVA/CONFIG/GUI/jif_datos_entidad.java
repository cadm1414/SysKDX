package JAVA.CONFIG.GUI;

import JAVA.ANCESTRO.GUI.pnl_opciones_2;

public class jif_datos_entidad extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    pnl_datos_entidad lo_pnl_datos_entidad = new pnl_datos_entidad();

    public jif_datos_entidad() {
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        TBP_entidad.addTab("REGISTRO", lo_pnl_datos_entidad);

        this.add(lo_pnl_opciones_2);
    }

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
                .addComponent(TBP_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TBP_entidad;
    // End of variables declaration//GEN-END:variables
}
