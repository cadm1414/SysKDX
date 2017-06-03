package JAVA.CONFIG.GUI;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.UTILITARIOS.FUNCION.fnc_txt_mayuscula;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class dlg_busq_rol extends javax.swing.JDialog {

    pnl_grid_busq_rol lo_pgr = new pnl_grid_busq_rol();
    DefaultTableModel lm_modelo;
    ResultSet lq_rs;
    public String ls_codigo_rol;

    public dlg_busq_rol(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
        datos_tabla();
    }

    private void formulario() {
        lo_pgr.setBounds(0, 0, 300, 220);
        PNL_grid.add(lo_pgr);

        TXT_dato.setDocument(new fnc_txt_mayuscula());

        lo_pgr.TBL_rol.addMouseListener(MouseEvnt);
        lo_pgr.TBL_rol.addKeyListener(KeyEvnt);
        TXT_dato.addKeyListener(KeyEvnt);

    }

    private void datos_tabla() {
        int a = 0;
        lm_modelo = (DefaultTableModel) lo_pgr.TBL_rol.getModel();
        try {
            lq_rs = go_dao_rol.SLT_datos_rol();
            if (lq_rs != null) {
                do {
                    lm_modelo.addRow(new Object[]{""});
                    for (int x = 0; x < 2; x++) {
                        lo_pgr.TBL_rol.setValueAt(lq_rs.getString(x + 1), a, x);
                    }
                    a++;
                } while (lq_rs.next());
            }
        } catch (Exception e) {
        }
    }
    
    public void retorna(){
        ls_codigo_rol = lo_pgr.TBL_rol.getValueAt(lo_pgr.TBL_rol.getSelectedRow(), 0).toString();
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
                    lo_pgr.TBL_rol.requestFocus();
                    lo_pgr.TBL_rol.changeSelection(0, 0, false, false);
                }
                if (ke.getSource() == lo_pgr.TBL_rol) {
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
                go_fnc_filtrar_tablas.filtro(lm_modelo, lo_pgr.TBL_rol, TXT_dato.getText(), 1);
            }
        }
    };
    
    MouseListener MouseEvnt = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {  
            if(me.getSource()== lo_pgr.TBL_rol && me.getClickCount()==2){
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
        setTitle("BUSQUEDA ROL");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        TXT_dato.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

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
            .addGap(0, 300, Short.MAX_VALUE)
        );
        PNL_gridLayout.setVerticalGroup(
            PNL_gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PNL_grid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                dlg_busq_rol dialog = new dlg_busq_rol(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNL_grid;
    private javax.swing.JTextField TXT_dato;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
