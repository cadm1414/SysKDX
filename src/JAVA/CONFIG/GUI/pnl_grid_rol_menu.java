package JAVA.CONFIG.GUI;

public class pnl_grid_rol_menu extends javax.swing.JPanel {

    public pnl_grid_rol_menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_rol_menu = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                if(TBL_rol_menu.getValueAt(row, 3).toString().substring(0, 1).equalsIgnoreCase("M") || TBL_rol_menu.getValueAt(row, 3).toString().substring(0, 1).equalsIgnoreCase("S")){
                    if(column == 0){
                        return true;
                    }else{
                        return false;
                    }
                }
                return true;
            }
        };

        TBL_rol_menu.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_rol_menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Modulo", "Menu", "Descripcion", "Nuevo", "Buscar", "Editar", "Eliminar", "Anular", "Guardar", "Imprimir", "Reporte"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_rol_menu.setEnabled(false);
        TBL_rol_menu.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_rol_menu);
        if (TBL_rol_menu.getColumnModel().getColumnCount() > 0) {
            TBL_rol_menu.getColumnModel().getColumn(0).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(0).setPreferredWidth(10);
            TBL_rol_menu.getColumnModel().getColumn(1).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(1).setPreferredWidth(20);
            TBL_rol_menu.getColumnModel().getColumn(2).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(2).setPreferredWidth(20);
            TBL_rol_menu.getColumnModel().getColumn(3).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(3).setPreferredWidth(200);
            TBL_rol_menu.getColumnModel().getColumn(4).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(4).setPreferredWidth(25);
            TBL_rol_menu.getColumnModel().getColumn(5).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(5).setPreferredWidth(25);
            TBL_rol_menu.getColumnModel().getColumn(6).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(6).setPreferredWidth(25);
            TBL_rol_menu.getColumnModel().getColumn(7).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(7).setPreferredWidth(25);
            TBL_rol_menu.getColumnModel().getColumn(8).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(8).setPreferredWidth(25);
            TBL_rol_menu.getColumnModel().getColumn(9).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(9).setPreferredWidth(25);
            TBL_rol_menu.getColumnModel().getColumn(10).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(10).setPreferredWidth(25);
            TBL_rol_menu.getColumnModel().getColumn(11).setResizable(false);
            TBL_rol_menu.getColumnModel().getColumn(11).setPreferredWidth(25);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_rol_menu;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
