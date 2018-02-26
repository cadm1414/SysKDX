package JAVA.CONFIG.GUI;

import JAVA.ANCESTRO.LOGICA.evt_previous_focus;
import javax.swing.ActionMap;

public class pnl_grid_busq_ubigeo extends javax.swing.JPanel {

    ActionMap am;

    public pnl_grid_busq_ubigeo() {
        initComponents();

        am = TBL_ubigeo.getActionMap();
        am.put("selectPreviousColumnCell", new evt_previous_focus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_ubigeo = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int colum){
                return false;
            }
        };

        TBL_ubigeo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_ubigeo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Distrito", "Provincia", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TBL_ubigeo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_ubigeo);
        if (TBL_ubigeo.getColumnModel().getColumnCount() > 0) {
            TBL_ubigeo.getColumnModel().getColumn(0).setResizable(false);
            TBL_ubigeo.getColumnModel().getColumn(0).setPreferredWidth(20);
            TBL_ubigeo.getColumnModel().getColumn(1).setResizable(false);
            TBL_ubigeo.getColumnModel().getColumn(2).setResizable(false);
            TBL_ubigeo.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_ubigeo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
