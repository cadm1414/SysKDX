package JAVA.VENTAS.GUI;
import java.awt.Component; 
import javax.swing.text.JTextComponent;

public class pnl_grid_pedidos extends javax.swing.JPanel {
          
    public pnl_grid_pedidos() {
        initComponents();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_pedidos = new javax.swing.JTable(){
            public void changeSelection(int row, int column, boolean toggle,boolean extend){
                super.changeSelection(row, column, toggle, extend);
                if (editCellAt(row, column)){
                    Component editor = getEditorComponent();
                    editor.requestFocusInWindow();
                    ((JTextComponent)editor).selectAll();
                }
            }
        };
        jPanel1 = new javax.swing.JPanel();
        LBL_inafecto = new javax.swing.JLabel();
        LBL_afecto = new javax.swing.JLabel();
        LBL_igv = new javax.swing.JLabel();
        LBL_total = new javax.swing.JLabel();
        LBL_percepcion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LBL_importe = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LBL_simbolo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JRD_masivo = new javax.swing.JRadioButton();

        TBL_pedidos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Bulto", "C. Articulo", "Nombre", "Tara", "U.M.", "IGV", "Perc.", "Precio", "C. Bruto", "C. Neto", "Importe", "%", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, true, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_pedidos.setCellSelectionEnabled(true);
        TBL_pedidos.setEnabled(false);
        TBL_pedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_pedidos);
        if (TBL_pedidos.getColumnModel().getColumnCount() > 0) {
            TBL_pedidos.getColumnModel().getColumn(0).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(0).setPreferredWidth(1);
            TBL_pedidos.getColumnModel().getColumn(1).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(1).setPreferredWidth(10);
            TBL_pedidos.getColumnModel().getColumn(2).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(2).setPreferredWidth(50);
            TBL_pedidos.getColumnModel().getColumn(3).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(3).setPreferredWidth(200);
            TBL_pedidos.getColumnModel().getColumn(4).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(4).setPreferredWidth(5);
            TBL_pedidos.getColumnModel().getColumn(5).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(5).setPreferredWidth(1);
            TBL_pedidos.getColumnModel().getColumn(6).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(6).setPreferredWidth(1);
            TBL_pedidos.getColumnModel().getColumn(7).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(7).setPreferredWidth(1);
            TBL_pedidos.getColumnModel().getColumn(8).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(8).setPreferredWidth(50);
            TBL_pedidos.getColumnModel().getColumn(9).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(9).setPreferredWidth(40);
            TBL_pedidos.getColumnModel().getColumn(10).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(10).setPreferredWidth(40);
            TBL_pedidos.getColumnModel().getColumn(11).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(11).setPreferredWidth(50);
            TBL_pedidos.getColumnModel().getColumn(12).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(12).setPreferredWidth(1);
            TBL_pedidos.getColumnModel().getColumn(13).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(13).setPreferredWidth(15);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        LBL_inafecto.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        LBL_inafecto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_inafecto.setText("0.00");

        LBL_afecto.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        LBL_afecto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_afecto.setText("0.00");

        LBL_igv.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        LBL_igv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_igv.setText("0.00");

        LBL_total.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        LBL_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_total.setText("0.00");

        LBL_percepcion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        LBL_percepcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_percepcion.setText("0.00");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel1.setText("Inafecto");

        LBL_importe.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_importe.setForeground(new java.awt.Color(255, 0, 0));
        LBL_importe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_importe.setText("0.00");
        LBL_importe.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setText("Afecto");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("Igv");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel4.setText("Total");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText("Percep.");

        LBL_simbolo.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_simbolo.setForeground(new java.awt.Color(255, 0, 0));
        LBL_simbolo.setText("Imp (S/.)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LBL_simbolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LBL_inafecto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBL_afecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBL_igv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBL_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBL_percepcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBL_importe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LBL_inafecto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LBL_afecto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LBL_igv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(LBL_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LBL_percepcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_simbolo)
                    .addComponent(LBL_importe))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ITEM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        JRD_masivo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_masivo.setText("R.Masivo");
        JRD_masivo.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(JRD_masivo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JRD_masivo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton JRD_masivo;
    public javax.swing.JLabel LBL_afecto;
    public javax.swing.JLabel LBL_igv;
    public javax.swing.JLabel LBL_importe;
    public javax.swing.JLabel LBL_inafecto;
    public javax.swing.JLabel LBL_percepcion;
    public javax.swing.JLabel LBL_simbolo;
    public javax.swing.JLabel LBL_total;
    public javax.swing.JTable TBL_pedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
