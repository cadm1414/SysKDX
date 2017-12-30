package JAVA.DISTBR.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;

public class pnl_busq_doc extends javax.swing.JPanel {

    public pnl_busq_doc() {
        initComponents();
        go_fnc_operaciones_campos.ancho_columna(TBL_datos, 0, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_datos, 1, 40);
        go_fnc_operaciones_campos.ancho_columna(TBL_datos, 2, 40);
        go_fnc_operaciones_campos.ancho_columna(TBL_datos, 3, 65);
        go_fnc_operaciones_campos.ancho_columna(TBL_datos, 4, 25);
        go_fnc_operaciones_campos.ancho_columna(TBL_datos, 5, 40);
        go_fnc_operaciones_campos.ancho_columna(TBL_datos, 6, 70);
        go_fnc_operaciones_campos.ancho_columna(TBL_datos, 8, 25);
        go_fnc_operaciones_campos.ancho_columna(TBL_datos, 11, 25);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_datos = new javax.swing.JTable();
        JRD_todos = new javax.swing.JRadioButton();
        LBL_contador = new javax.swing.JLabel();

        TBL_datos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo_operacion", "Item", "Suc.", "F. Emision", "CD", "Serie", "Numero", "Razon Social", "FP", "Vendedor", "Sector", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_datos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_datos);
        if (TBL_datos.getColumnModel().getColumnCount() > 0) {
            TBL_datos.getColumnModel().getColumn(0).setResizable(false);
            TBL_datos.getColumnModel().getColumn(0).setPreferredWidth(0);
            TBL_datos.getColumnModel().getColumn(1).setResizable(false);
            TBL_datos.getColumnModel().getColumn(1).setPreferredWidth(5);
            TBL_datos.getColumnModel().getColumn(2).setResizable(false);
            TBL_datos.getColumnModel().getColumn(2).setPreferredWidth(5);
            TBL_datos.getColumnModel().getColumn(3).setResizable(false);
            TBL_datos.getColumnModel().getColumn(3).setPreferredWidth(15);
            TBL_datos.getColumnModel().getColumn(4).setResizable(false);
            TBL_datos.getColumnModel().getColumn(4).setPreferredWidth(5);
            TBL_datos.getColumnModel().getColumn(5).setResizable(false);
            TBL_datos.getColumnModel().getColumn(5).setPreferredWidth(5);
            TBL_datos.getColumnModel().getColumn(6).setPreferredWidth(20);
            TBL_datos.getColumnModel().getColumn(7).setPreferredWidth(200);
            TBL_datos.getColumnModel().getColumn(8).setResizable(false);
            TBL_datos.getColumnModel().getColumn(8).setPreferredWidth(5);
            TBL_datos.getColumnModel().getColumn(9).setPreferredWidth(100);
            TBL_datos.getColumnModel().getColumn(10).setPreferredWidth(100);
            TBL_datos.getColumnModel().getColumn(11).setResizable(false);
            TBL_datos.getColumnModel().getColumn(11).setPreferredWidth(5);
        }

        JRD_todos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_todos.setText("Todos");

        LBL_contador.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_contador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_contador.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JRD_todos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LBL_contador, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRD_todos)
                    .addComponent(LBL_contador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton JRD_todos;
    public javax.swing.JLabel LBL_contador;
    public javax.swing.JTable TBL_datos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
