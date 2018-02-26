package JAVA.DISTBR.GUI;

import JAVA.ANCESTRO.LOGICA.evt_previous_focus;
import static JAVA.ANCESTRO.LOGICA.variables_globales.go_fnc_operaciones_campos;
import javax.swing.ActionMap;

public class pnl_grid_programacion extends javax.swing.JPanel {

    ActionMap am;

    public pnl_grid_programacion() {
        initComponents();
        go_fnc_operaciones_campos.ancho_columna(TBL_programacion, 0, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_programacion, 4, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_programacion, 5, 0);

        am = TBL_programacion.getActionMap();
        am.put("selectPreviousColumnCell", new evt_previous_focus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_programacion = new javax.swing.JTable();

        TBL_programacion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_programacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo_operacion", "Item", "Sucursal", "F. Emision", "codigo_documento", "serie_documento", "Numero", "Razon Social", "F.P.", "Vendedor", "Sector", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_programacion.setCellSelectionEnabled(true);
        TBL_programacion.setEnabled(false);
        jScrollPane1.setViewportView(TBL_programacion);
        if (TBL_programacion.getColumnModel().getColumnCount() > 0) {
            TBL_programacion.getColumnModel().getColumn(0).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(0).setPreferredWidth(0);
            TBL_programacion.getColumnModel().getColumn(1).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(1).setPreferredWidth(15);
            TBL_programacion.getColumnModel().getColumn(2).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(2).setPreferredWidth(15);
            TBL_programacion.getColumnModel().getColumn(3).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(3).setPreferredWidth(35);
            TBL_programacion.getColumnModel().getColumn(4).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(4).setPreferredWidth(0);
            TBL_programacion.getColumnModel().getColumn(5).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(5).setPreferredWidth(0);
            TBL_programacion.getColumnModel().getColumn(6).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(6).setPreferredWidth(50);
            TBL_programacion.getColumnModel().getColumn(7).setPreferredWidth(200);
            TBL_programacion.getColumnModel().getColumn(8).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(8).setPreferredWidth(5);
            TBL_programacion.getColumnModel().getColumn(9).setPreferredWidth(150);
            TBL_programacion.getColumnModel().getColumn(10).setPreferredWidth(80);
            TBL_programacion.getColumnModel().getColumn(11).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(11).setPreferredWidth(10);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_programacion;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
