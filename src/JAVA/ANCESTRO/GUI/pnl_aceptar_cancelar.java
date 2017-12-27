package JAVA.ANCESTRO.GUI;

public class pnl_aceptar_cancelar extends javax.swing.JPanel {

    public pnl_aceptar_cancelar() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTN_aceptar = new javax.swing.JButton();
        BTN_cancelar = new javax.swing.JButton();

        BTN_aceptar.setBackground(new java.awt.Color(0, 153, 153));
        BTN_aceptar.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        BTN_aceptar.setForeground(new java.awt.Color(255, 255, 255));
        BTN_aceptar.setText("ACEPTAR");

        BTN_cancelar.setBackground(new java.awt.Color(0, 153, 153));
        BTN_cancelar.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        BTN_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        BTN_cancelar.setText("CANCELAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_aceptar)
                .addGap(18, 18, 18)
                .addComponent(BTN_cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_aceptar)
                    .addComponent(BTN_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_aceptar;
    public javax.swing.JButton BTN_cancelar;
    // End of variables declaration//GEN-END:variables
}
