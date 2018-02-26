package JAVA.VENTAS.GUI;

import JAVA.ANCESTRO.LOGICA.evt_previous_focus;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import javax.swing.ActionMap;

public class pnl_grid_facturacion_pr extends javax.swing.JPanel {

    ActionMap am;

    public pnl_grid_facturacion_pr() {
        initComponents();
        go_fnc_operaciones_campos.ancho_columna(TBL_facturacion, 10, 0);

        am = TBL_facturacion.getActionMap();
        am.put("selectPreviousColumnCell", new evt_previous_focus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_facturacion = new javax.swing.JTable();

        TBL_facturacion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_facturacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doc", "C. Articulo", "Nombre", "Tara", "U.M.", "IGV", "D(%)", "Bulto", "P. Bruto", "P. Neto", "codigo_op"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_facturacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_facturacion);
        if (TBL_facturacion.getColumnModel().getColumnCount() > 0) {
            TBL_facturacion.getColumnModel().getColumn(0).setResizable(false);
            TBL_facturacion.getColumnModel().getColumn(0).setPreferredWidth(90);
            TBL_facturacion.getColumnModel().getColumn(1).setResizable(false);
            TBL_facturacion.getColumnModel().getColumn(1).setPreferredWidth(60);
            TBL_facturacion.getColumnModel().getColumn(2).setPreferredWidth(210);
            TBL_facturacion.getColumnModel().getColumn(3).setResizable(false);
            TBL_facturacion.getColumnModel().getColumn(3).setPreferredWidth(7);
            TBL_facturacion.getColumnModel().getColumn(4).setResizable(false);
            TBL_facturacion.getColumnModel().getColumn(4).setPreferredWidth(5);
            TBL_facturacion.getColumnModel().getColumn(5).setResizable(false);
            TBL_facturacion.getColumnModel().getColumn(5).setPreferredWidth(1);
            TBL_facturacion.getColumnModel().getColumn(6).setResizable(false);
            TBL_facturacion.getColumnModel().getColumn(6).setPreferredWidth(1);
            TBL_facturacion.getColumnModel().getColumn(7).setResizable(false);
            TBL_facturacion.getColumnModel().getColumn(7).setPreferredWidth(15);
            TBL_facturacion.getColumnModel().getColumn(8).setResizable(false);
            TBL_facturacion.getColumnModel().getColumn(8).setPreferredWidth(30);
            TBL_facturacion.getColumnModel().getColumn(9).setResizable(false);
            TBL_facturacion.getColumnModel().getColumn(9).setPreferredWidth(30);
            TBL_facturacion.getColumnModel().getColumn(10).setResizable(false);
            TBL_facturacion.getColumnModel().getColumn(10).setPreferredWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_facturacion;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
