package JAVA.VENTAS.GUI;

import JAVA.ANCESTRO.LOGICA.evt_previous_focus;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.awt.Component;
import javax.swing.ActionMap;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public class pnl_grid_pedidos_agil extends javax.swing.JPanel {

    ActionMap am;
    public JLabel LBL_inafecto = new JLabel();
    public JLabel LBL_afecto = new JLabel();
    public JLabel LBL_igv = new JLabel();
    public JLabel LBL_total = new JLabel();
    public JLabel LBL_percepcion = new JLabel();
    public JLabel LBL_utilidad_p = new JLabel();

    public pnl_grid_pedidos_agil() {
        initComponents();
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 0, 32);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 1, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 2, 40);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 3, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 4, 240);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 5, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 6, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 7, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 8, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 9, 70);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 10, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 11, 45);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 12, 70);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 13, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 14, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 15, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 16, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 17, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_pedidos, 18, 0);

        am = TBL_pedidos.getActionMap();
        am.put("selectPreviousColumnCell", new evt_previous_focus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_pedidos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        LBL_importe = new javax.swing.JLabel();
        LBL_simbolo = new javax.swing.JLabel();

        TBL_pedidos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "", "Bulto", "C. Articulo", "Nombre", "Tara", "U.M.", "IGV", "Perc.", "Precio", "C. Bruto", "C. Neto", "Importe", "%", "", "presentacion", "precio_min", "codigo_ref", "item_ref"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_pedidos.setEnabled(false);
        TBL_pedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_pedidos);
        if (TBL_pedidos.getColumnModel().getColumnCount() > 0) {
            TBL_pedidos.getColumnModel().getColumn(0).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(0).setPreferredWidth(1);
            TBL_pedidos.getColumnModel().getColumn(1).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(1).setPreferredWidth(0);
            TBL_pedidos.getColumnModel().getColumn(2).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(2).setPreferredWidth(10);
            TBL_pedidos.getColumnModel().getColumn(3).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(3).setPreferredWidth(50);
            TBL_pedidos.getColumnModel().getColumn(4).setPreferredWidth(200);
            TBL_pedidos.getColumnModel().getColumn(5).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(5).setPreferredWidth(5);
            TBL_pedidos.getColumnModel().getColumn(6).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(6).setPreferredWidth(1);
            TBL_pedidos.getColumnModel().getColumn(7).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(7).setPreferredWidth(1);
            TBL_pedidos.getColumnModel().getColumn(8).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(8).setPreferredWidth(1);
            TBL_pedidos.getColumnModel().getColumn(9).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(9).setPreferredWidth(50);
            TBL_pedidos.getColumnModel().getColumn(10).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(10).setPreferredWidth(40);
            TBL_pedidos.getColumnModel().getColumn(11).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(11).setPreferredWidth(40);
            TBL_pedidos.getColumnModel().getColumn(12).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(12).setPreferredWidth(50);
            TBL_pedidos.getColumnModel().getColumn(13).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(13).setPreferredWidth(1);
            TBL_pedidos.getColumnModel().getColumn(14).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(14).setPreferredWidth(15);
            TBL_pedidos.getColumnModel().getColumn(15).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(15).setPreferredWidth(0);
            TBL_pedidos.getColumnModel().getColumn(16).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(16).setPreferredWidth(0);
            TBL_pedidos.getColumnModel().getColumn(17).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(17).setPreferredWidth(0);
            TBL_pedidos.getColumnModel().getColumn(18).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(18).setPreferredWidth(0);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        LBL_importe.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LBL_importe.setForeground(new java.awt.Color(255, 0, 0));
        LBL_importe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_importe.setText("0.00");
        LBL_importe.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        LBL_simbolo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LBL_simbolo.setForeground(new java.awt.Color(255, 0, 0));
        LBL_simbolo.setText("Imp (S/.)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(LBL_simbolo)
                .addGap(18, 18, 18)
                .addComponent(LBL_importe, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_simbolo)
                    .addComponent(LBL_importe))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel LBL_importe;
    public javax.swing.JLabel LBL_simbolo;
    public javax.swing.JTable TBL_pedidos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
