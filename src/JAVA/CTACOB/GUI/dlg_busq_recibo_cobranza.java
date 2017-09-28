package JAVA.CTACOB.GUI;

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

public class dlg_busq_recibo_cobranza extends javax.swing.JDialog {

    pnl_grid_busq_recibo_cobranza lo_pnl_grid_busq_recibo_cobranza = new pnl_grid_busq_recibo_cobranza();
    DefaultTableModel lm_modelo;
    ResultSet lq_rs;
    public String ls_codigo;
    String ls_codigo_sucursal, ls_fecha_ini, ls_fecha_fin;
    String ls_modulo = "CTACOB", ls_capa = "GUI", ls_clase = "dlg_busq_recibo_cobranza";

    public dlg_busq_recibo_cobranza(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
        get_parametros();
        datos_tabla();
    }

    private void get_parametros() {
        ls_codigo_sucursal = gs_parametros[0];
        ls_fecha_ini = gs_parametros[1];
        ls_fecha_fin = gs_parametros[2];

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";

        TXT_fecha_ini.setText(ls_fecha_ini);
        TXT_fecha_fin.setText(ls_fecha_fin);
    }

    private void formulario() {
        lo_pnl_grid_busq_recibo_cobranza.setBounds(0, 0, 300, 220);
        PNL_grid.add(lo_pnl_grid_busq_recibo_cobranza);

        TXT_dato.setDocument(new fnc_txt_mayuscula());

        lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza.addMouseListener(MouseEvnt);
        lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza.addKeyListener(KeyEvnt);
        TXT_dato.addKeyListener(KeyEvnt);
        TXT_fecha_ini.addKeyListener(KeyEvnt);
        TXT_fecha_fin.addKeyListener(KeyEvnt);
    }

    private void datos_tabla() {
        int a = 0;
        lm_modelo = (DefaultTableModel) lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza.getModel();
        try {
            lq_rs = go_dao_recibo_cobranza.SLT_grid_recibo_cobranza(ls_codigo_sucursal, ls_fecha_ini, ls_fecha_fin);
            if (lq_rs != null) {
                do {
                    lm_modelo.addRow(new Object[]{""});
                    for (int x = 0; x < 4; x++) {
                        if (x == 0) {
                            lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza.setValueAt(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(x + 1)), a, x);
                        } else {
                            lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza.setValueAt(lq_rs.getString(x + 1), a, x);
                        }
                    }
                    a++;
                } while (lq_rs.next());
            }
        } catch (Exception e) {
        }
    }

    public void limpia_tabla() {
        DefaultTableModel modelo = (DefaultTableModel) lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void actualiza_tabla() {
        ls_fecha_ini = TXT_fecha_ini.getText();
        ls_fecha_fin = TXT_fecha_fin.getText();
        if (go_fnc_operaciones_campos.compara_fechas(ls_fecha_ini, ls_fecha_fin) <= 0) {
            limpia_tabla();
            datos_tabla();
        } else {
            TXT_fecha_ini.requestFocus();
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA INICIAL TIENE QUE SER MENOR y/o IGUAL A FECHA FINAL");
        }
    }

    public void retorna() {
        ls_codigo = lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza.getValueAt(lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza.getSelectedRow(), 3).toString();
        this.dispose();
    }

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == TXT_fecha_ini && !TXT_fecha_ini.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(TXT_fecha_ini.getText())) {
                        TXT_fecha_fin.requestFocus();
                        actualiza_tabla();
                    } else {
                        TXT_fecha_ini.setText(ls_fecha_ini);
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }

                }
                if (ke.getSource() == TXT_fecha_fin && !TXT_fecha_fin.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(TXT_fecha_fin.getText())) {
                        TXT_dato.requestFocus();
                        actualiza_tabla();
                    } else {
                        TXT_fecha_ini.setText(ls_fecha_fin);
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }
                if (ke.getSource() == TXT_dato) {
                    if (lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza.getRowCount() != 0) {
                        lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza.requestFocus();
                        lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza.changeSelection(0, 0, false, false);
                    } else {
                        TXT_dato.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza) {
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
                go_fnc_filtrar_tablas.filtro(lm_modelo, lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza, TXT_dato.getText(), 1);
            }
        }

    };

    MouseListener MouseEvnt = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == lo_pnl_grid_busq_recibo_cobranza.TBL_recibo_cobranza && me.getClickCount() == 2) {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TXT_fecha_ini = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TXT_fecha_fin = new javax.swing.JFormattedTextField();
        PNL_grid = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BUSQUEDA DOCUMENTO");
        setIconImage(getIconImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(202, 63));

        TXT_dato.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_dato.setNextFocusableComponent(TXT_fecha_ini);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel1.setText("Numero");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setText(":");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("F. Inicial");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel4.setText(":");

        try {
            TXT_fecha_ini.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_fecha_ini.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_fecha_ini.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText("F. Final");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel6.setText(":");

        try {
            TXT_fecha_fin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_fecha_fin.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_fecha_fin.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TXT_fecha_ini, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TXT_dato))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(TXT_fecha_ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(TXT_fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(TXT_dato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PNL_gridLayout = new javax.swing.GroupLayout(PNL_grid);
        PNL_grid.setLayout(PNL_gridLayout);
        PNL_gridLayout.setHorizontalGroup(
            PNL_gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
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
                    .addComponent(PNL_grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PNL_grid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_busq_recibo_cobranza dialog = new dlg_busq_recibo_cobranza(new javax.swing.JFrame(), true);
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
    private javax.swing.JFormattedTextField TXT_fecha_fin;
    private javax.swing.JFormattedTextField TXT_fecha_ini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
