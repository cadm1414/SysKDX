package JAVA.DISTBR.GUI;

import JAVA.ANCESTRO.LOGICA.evt_previous_focus;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.awt.Component;
import javax.swing.ActionMap;
import javax.swing.text.JTextComponent;

public class pnl_grid_liquidacion extends javax.swing.JPanel {

    ActionMap am;

    public pnl_grid_liquidacion() {
        initComponents();
        go_fnc_operaciones_campos.ancho_columna(TBL_liquidacion, 0, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_liquidacion, 2, 0);

        am = TBL_liquidacion.getActionMap();
        am.put("selectPreviousColumnCell", new evt_previous_focus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_liquidacion = new javax.swing.JTable(){
            public void changeSelection(int row, int column, boolean toggle,boolean extend){
                super.changeSelection(row, column, toggle, extend);
                if (editCellAt(row, column)){
                    if(column == 8 || column == 9){
                        Component editor = getEditorComponent();
                        editor.requestFocusInWindow();
                        ((JTextComponent)editor).selectAll();}
                }
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LBL_ef = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LBL_cr = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LBL_desc = new javax.swing.JLabel();

        TBL_liquidacion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_liquidacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo_op", "Item", "codigo_op_ref", "Documento", "Razon Social", "Total", "EF", "DP", "Acuenta", "Dsc/Rdn", "Importe", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_liquidacion.setColumnSelectionAllowed(true);
        TBL_liquidacion.setEnabled(false);
        TBL_liquidacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_liquidacion);
        if (TBL_liquidacion.getColumnModel().getColumnCount() > 0) {
            TBL_liquidacion.getColumnModel().getColumn(0).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(0).setPreferredWidth(0);
            TBL_liquidacion.getColumnModel().getColumn(1).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(1).setPreferredWidth(0);
            TBL_liquidacion.getColumnModel().getColumn(2).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(2).setPreferredWidth(0);
            TBL_liquidacion.getColumnModel().getColumn(3).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(3).setPreferredWidth(35);
            TBL_liquidacion.getColumnModel().getColumn(4).setPreferredWidth(200);
            TBL_liquidacion.getColumnModel().getColumn(5).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(5).setPreferredWidth(20);
            TBL_liquidacion.getColumnModel().getColumn(6).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(6).setPreferredWidth(0);
            TBL_liquidacion.getColumnModel().getColumn(7).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(7).setPreferredWidth(0);
            TBL_liquidacion.getColumnModel().getColumn(8).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(8).setPreferredWidth(20);
            TBL_liquidacion.getColumnModel().getColumn(9).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(9).setPreferredWidth(20);
            TBL_liquidacion.getColumnModel().getColumn(10).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(10).setPreferredWidth(20);
            TBL_liquidacion.getColumnModel().getColumn(11).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(11).setPreferredWidth(0);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel1.setText("T. Efectivo: (S/.)");

        LBL_ef.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_ef.setForeground(new java.awt.Color(255, 0, 51));
        LBL_ef.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_ef.setText("0.00 ");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("T. Credito: (S/.)");

        LBL_cr.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_cr.setForeground(new java.awt.Color(255, 0, 51));
        LBL_cr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_cr.setText("0.00 ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText("T. Desc/Rnd: (S/.)");

        LBL_desc.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_desc.setForeground(new java.awt.Color(255, 0, 51));
        LBL_desc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_desc.setText("0.00 ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_ef, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_cr, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(LBL_desc))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(LBL_cr))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(LBL_ef)))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel LBL_cr;
    public javax.swing.JLabel LBL_desc;
    public javax.swing.JLabel LBL_ef;
    public javax.swing.JTable TBL_liquidacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
