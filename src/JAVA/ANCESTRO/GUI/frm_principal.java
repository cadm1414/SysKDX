package JAVA.ANCESTRO.GUI;

import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.DAO.DAO_auditoria;
import JAVA.CONFIG.LOGICA.jtr_menu_opciones;
import JAVA.CONFIG.LOGICA.lst_menu_modulo;
import JAVA.CONFIG.LOGICA.opciones_menu;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;

public class frm_principal extends javax.swing.JFrame {
    
    HashMap<String, Icon> ls_elementos = new HashMap<String, Icon>();
    HashMap<String, String> ls_tooltip = new HashMap<String, String>();
    jtr_menu_opciones lo_jtr_menu_opciones = new jtr_menu_opciones();
    opciones_menu lo_opciones_menu = new opciones_menu();
    DefaultMutableTreeNode nodoSeleccionado;
    Calendar fecha = Calendar.getInstance();
    ResultSet lq_rs = null;
    boolean resp;
    String ls_nodo;
    String ls_modulo = "ANCESTRO", ls_capa = "GUI", ls_clase = "frm_principal";
    
    public frm_principal() throws UnknownHostException, SocketException {
        initComponents();
        datos_pantalla();
        lista_modulo();
        datos_pc();
        registra_auditoria("INICIO DE SESION");
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }
    
    private void datos_pantalla() {
        LBL_rol.setText(gs_nombre_rol);
        LBL_periodo.setText(gs_periodo);
        LBL_usuario.setText(gs_nombre_usuario);
        LBL_usuario.setToolTipText(gs_datos_usuario);
        go_dao_general.SLT_datos();
        LBL_razon_social.setText(go_bean_general.getRazon_social());
        gs_mes = go_fnc_operaciones_campos.completa_digitos((fecha.get(Calendar.MONTH) + 1) + "", "0", 2);
        gs_dia = go_fnc_operaciones_campos.completa_digitos((fecha.get(Calendar.DAY_OF_MONTH)) + "", "0", 2);
    }
    
    private void datos_pc() throws UnknownHostException, SocketException {
        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(address.getLocalHost());
            byte[] mac = network.getHardwareAddress();
            gs_direccion_ip = address.getHostAddress();
            gs_nombre_pc = address.getHostName();
            gs_direccion_mac = go_fnc_operaciones_campos.get_mac(mac);
        } catch (Exception e) {
            gs_direccion_mac = "00-00-00-00-00-00";
            gs_nombre_pc = "SIN CONECCION";
            gs_direccion_ip = "255.255.255.255";
        }
        
    }
    
    private void registra_auditoria(String dato) {
        try {
            go_dao_auditoria.IST_auditoria(dato, "", "CONFIG", "0", "0013");
        } catch (Exception e) {
        }
    }
    
    private void lista_modulo() {
        try {
            resp = go_dao_rol_menu.SLT_rol_menu_x_idrol();
            if (resp) {
                LST_modulo.setListData(gs_modulo);
                for (int i = 0; i < gs_modulo.length; i++) {
                    ls_elementos.put(gs_modulo[i].toString(), new ImageIcon(IMAGES_ruta_ancestro.class.getResource(gs_codigo_modulo[i] + ".png")));
                    ls_tooltip.put(gs_modulo[i].toString(), gs_modulo[i]);
                }
                lst_menu_modulo render = new lst_menu_modulo(ls_elementos, ls_tooltip);
                LST_modulo.setCellRenderer(render);
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "lista_modulo", e.getMessage());
        }
    }
    
    private void evt_opciones_menu() {
        try {
            nodoSeleccionado = (DefaultMutableTreeNode) JTR_menu_opciones.getLastSelectedPathComponent();
            ls_nodo = nodoSeleccionado.toString();
            if (lo_opciones_menu.selecciona_formulario(LST_modulo.getSelectedIndex(), ls_nodo).equalsIgnoreCase("F")) {
                this.dispose();
            }
        } catch (Exception e) {
        }
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_ancestro.class.getResource("imagen_inicio.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTR_menu_opciones = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        LST_modulo = new javax.swing.JList<>();
        JDP_principal = new javax.swing.JDesktopPane();
        TBP_contenedor = new javax.swing.JTabbedPane();
        LBL_usuario = new javax.swing.JLabel();
        LBL_periodo = new javax.swing.JLabel();
        LBL_razon_social = new javax.swing.JLabel();
        LBL_rol = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("System");
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jSplitPane1.setDividerLocation(200);

        jSplitPane2.setDividerLocation(350);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        JTR_menu_opciones.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("OPCIONES");
        JTR_menu_opciones.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        JTR_menu_opciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTR_menu_opcionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTR_menu_opciones);

        jSplitPane2.setTopComponent(jScrollPane1);

        LST_modulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LST_moduloMouseClicked(evt);
            }
        });
        LST_modulo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LST_moduloValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(LST_modulo);

        jSplitPane2.setRightComponent(jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel1);

        JDP_principal.setBackground(new java.awt.Color(240, 240, 240));

        TBP_contenedor.setForeground(new java.awt.Color(0, 153, 153));

        LBL_usuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LBL_usuario.setForeground(new java.awt.Color(0, 153, 153));
        LBL_usuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LBL_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/usuario.png"))); // NOI18N
        LBL_usuario.setText(" ");
        LBL_usuario.setToolTipText("USUARIO");

        LBL_periodo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LBL_periodo.setForeground(new java.awt.Color(0, 153, 153));
        LBL_periodo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LBL_periodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/calendario.png"))); // NOI18N
        LBL_periodo.setText(" ");
        LBL_periodo.setToolTipText("PERIODO");

        LBL_razon_social.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LBL_razon_social.setForeground(new java.awt.Color(0, 153, 153));
        LBL_razon_social.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LBL_razon_social.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/empresa.png"))); // NOI18N
        LBL_razon_social.setText("  ");
        LBL_razon_social.setToolTipText("EMPRESA");

        LBL_rol.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LBL_rol.setForeground(new java.awt.Color(0, 153, 153));
        LBL_rol.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LBL_rol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/rol_use.png"))); // NOI18N
        LBL_rol.setText(" ");
        LBL_rol.setToolTipText("ROL");

        JDP_principal.setLayer(TBP_contenedor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDP_principal.setLayer(LBL_usuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDP_principal.setLayer(LBL_periodo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDP_principal.setLayer(LBL_razon_social, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDP_principal.setLayer(LBL_rol, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDP_principalLayout = new javax.swing.GroupLayout(JDP_principal);
        JDP_principal.setLayout(JDP_principalLayout);
        JDP_principalLayout.setHorizontalGroup(
            JDP_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDP_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JDP_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TBP_contenedor)
                    .addGroup(JDP_principalLayout.createSequentialGroup()
                        .addComponent(LBL_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBL_razon_social, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                        .addGap(110, 110, 110)
                        .addComponent(LBL_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBL_rol)))
                .addContainerGap())
        );
        JDP_principalLayout.setVerticalGroup(
            JDP_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDP_principalLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(JDP_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBL_periodo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JDP_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LBL_usuario)
                        .addComponent(LBL_rol)
                        .addComponent(LBL_razon_social)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TBP_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        jSplitPane1.setRightComponent(JDP_principal);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Utilitarios");

        jMenuItem1.setText("Cambiar Periodo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LST_moduloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LST_moduloMouseClicked
        lo_jtr_menu_opciones.menu_opciones(JTR_menu_opciones, LST_modulo.getSelectedIndex());
    }//GEN-LAST:event_LST_moduloMouseClicked

    private void JTR_menu_opcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTR_menu_opcionesMouseClicked
        if (evt.getClickCount() == 2) {
            evt_opciones_menu();
        }
    }//GEN-LAST:event_JTR_menu_opcionesMouseClicked

    private void LST_moduloValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LST_moduloValueChanged
        lo_jtr_menu_opciones.menu_opciones(JTR_menu_opciones, LST_modulo.getSelectedIndex());
    }//GEN-LAST:event_LST_moduloValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (go_fnc_mensaje.get_respuesta(0, "DESEA SALIR DEL SISTEMA") == 0) {
            registra_auditoria("CIERRA SESION");
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        go_dlg_periodo = new dlg_periodo(null, true);
        go_dlg_periodo.setVisible(true);
        LBL_periodo.setText(gs_periodo);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    public static void main(String args[]) throws UnknownHostException, SocketException {
        new frm_principal().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane JDP_principal;
    private javax.swing.JTree JTR_menu_opciones;
    private javax.swing.JLabel LBL_periodo;
    private javax.swing.JLabel LBL_razon_social;
    private javax.swing.JLabel LBL_rol;
    private javax.swing.JLabel LBL_usuario;
    private javax.swing.JList<String> LST_modulo;
    public javax.swing.JTabbedPane TBP_contenedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    // End of variables declaration//GEN-END:variables
}
