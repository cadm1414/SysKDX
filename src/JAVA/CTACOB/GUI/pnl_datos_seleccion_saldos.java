package JAVA.CTACOB.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;

public class pnl_datos_seleccion_saldos extends javax.swing.JPanel {

    public pnl_datos_seleccion_saldos() {
        initComponents();
        go_fnc_operaciones_campos.oculta_columna(TBL_detalle_saldos, 0);
        go_fnc_operaciones_campos.oculta_columna(TBL_detalle_saldos, 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_detalle_saldos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        LBL_total = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JRD_todos = new javax.swing.JRadioButton();

        TBL_detalle_saldos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_detalle_saldos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo_operacion", "codigo_vendedor", "T.D.", "Serie", "Numero", "F. Emision", "C.M.", "Saldo", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_detalle_saldos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_detalle_saldos);
        if (TBL_detalle_saldos.getColumnModel().getColumnCount() > 0) {
            TBL_detalle_saldos.getColumnModel().getColumn(0).setResizable(false);
            TBL_detalle_saldos.getColumnModel().getColumn(0).setPreferredWidth(0);
            TBL_detalle_saldos.getColumnModel().getColumn(1).setResizable(false);
            TBL_detalle_saldos.getColumnModel().getColumn(1).setPreferredWidth(0);
            TBL_detalle_saldos.getColumnModel().getColumn(2).setResizable(false);
            TBL_detalle_saldos.getColumnModel().getColumn(2).setPreferredWidth(10);
            TBL_detalle_saldos.getColumnModel().getColumn(3).setResizable(false);
            TBL_detalle_saldos.getColumnModel().getColumn(3).setPreferredWidth(20);
            TBL_detalle_saldos.getColumnModel().getColumn(4).setResizable(false);
            TBL_detalle_saldos.getColumnModel().getColumn(4).setPreferredWidth(30);
            TBL_detalle_saldos.getColumnModel().getColumn(5).setResizable(false);
            TBL_detalle_saldos.getColumnModel().getColumn(5).setPreferredWidth(30);
            TBL_detalle_saldos.getColumnModel().getColumn(6).setResizable(false);
            TBL_detalle_saldos.getColumnModel().getColumn(6).setPreferredWidth(5);
            TBL_detalle_saldos.getColumnModel().getColumn(7).setResizable(false);
            TBL_detalle_saldos.getColumnModel().getColumn(7).setPreferredWidth(30);
            TBL_detalle_saldos.getColumnModel().getColumn(8).setResizable(false);
            TBL_detalle_saldos.getColumnModel().getColumn(8).setPreferredWidth(5);
        }

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("Total");

        LBL_total.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBL_total.setText("0");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText(":");

        JRD_todos.setText("Todos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JRD_todos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBL_total, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRD_todos)
                    .addComponent(jLabel3)
                    .addComponent(LBL_total)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton JRD_todos;
    public javax.swing.JLabel LBL_total;
    public javax.swing.JTable TBL_detalle_saldos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
