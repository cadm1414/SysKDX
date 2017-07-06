package JAVA.INVENT.GUI;

import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.UTILITARIOS.FUNCION.fnc_txt_mayuscula;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class dlg_busq_producto extends javax.swing.JDialog {

    pnl_grid_busq_producto lo_pnl_grid_busq_producto = new pnl_grid_busq_producto();
    DefaultTableModel lm_modelo;
    ResultSet lq_rs;
    public String ls_codigo_producto;

    public dlg_busq_producto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
        datos_tabla();
    }

    private void formulario() {
        lo_pnl_grid_busq_producto.setBounds(0, 0, 300, 220);
        PNL_grid.add(lo_pnl_grid_busq_producto);

        TXT_dato.setDocument(new fnc_txt_mayuscula());

        lo_pnl_grid_busq_producto.TBL_producto.addMouseListener(MouseEvnt);
        lo_pnl_grid_busq_producto.TBL_producto.addKeyListener(KeyEvnt);
        TXT_dato.addKeyListener(KeyEvnt);
    }

    private void datos_tabla() {
        int a = 0;
        lm_modelo = (DefaultTableModel) lo_pnl_grid_busq_producto.TBL_producto.getModel();
        try {
            lq_rs = go_dao_producto.SLT_grid_producto();
            if (lq_rs != null) {
                do {
                    lm_modelo.addRow(new Object[]{""});
                    for (int x = 0; x < 3; x++) {
                        lo_pnl_grid_busq_producto.TBL_producto.setValueAt(lq_rs.getString(x + 1), a, x);
                    }
                    a++;
                } while (lq_rs.next());
            }
        } catch (Exception e) {
        }
    }

    public void retorna() {
        ls_codigo_producto = lo_pnl_grid_busq_producto.TBL_producto.getValueAt(lo_pnl_grid_busq_producto.TBL_producto.getSelectedRow(), 0).toString();
        this.dispose();
    }

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == TXT_dato) {
                    if (lo_pnl_grid_busq_producto.TBL_producto.getRowCount() != 0) {
                        lo_pnl_grid_busq_producto.TBL_producto.requestFocus();
                        lo_pnl_grid_busq_producto.TBL_producto.changeSelection(0, 0, false, false);
                    } else {
                        TXT_dato.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_grid_busq_producto.TBL_producto) {
                    retorna();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == TXT_dato) {
                go_fnc_filtrar_tablas.filtro(lm_modelo, lo_pnl_grid_busq_producto.TBL_producto, TXT_dato.getText(), 1);
            }
        }

    };

    MouseListener MouseEvnt = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == lo_pnl_grid_busq_producto.TBL_producto && me.getClickCount() == 2) {
                retorna();
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {

        }

        @Override
        public void mouseReleased(MouseEvent me) {

        }

        @Override
        public void mouseEntered(MouseEvent me) {

        }

        @Override
        public void mouseExited(MouseEvent me) {

        }

    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TXT_dato = new javax.swing.JTextField();
        PNL_grid = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BUSQUEDA PRODUCTO");
        setIconImage(getIconImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(202, 63));

        TXT_dato.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_dato.setNextFocusableComponent(TXT_dato);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TXT_dato, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TXT_dato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PNL_gridLayout = new javax.swing.GroupLayout(PNL_grid);
        PNL_grid.setLayout(PNL_gridLayout);
        PNL_gridLayout.setHorizontalGroup(
            PNL_gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PNL_gridLayout.setVerticalGroup(
            PNL_gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 99, Short.MAX_VALUE))
                    .addComponent(PNL_grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PNL_grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_busq_producto dialog = new dlg_busq_producto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_ancestro.class.getResource("buscar_d.png"));
        return retValue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNL_grid;
    private javax.swing.JTextField TXT_dato;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
