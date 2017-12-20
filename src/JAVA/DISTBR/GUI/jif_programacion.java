package JAVA.DISTBR.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import JAVA.ANCESTRO.LOGICA.evt_opciones_3;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.DISTBR.LOGICA.evt_datos_programacion;
import JAVA.DISTBR.LOGICA.evt_grid_programacion;
import JAVA.VENTAS.GUI.dlg_busq_transportista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class jif_programacion extends javax.swing.JInternalFrame {

    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    evt_opciones_3 lo_evt_opciones_3 = new evt_opciones_3();
    pnl_datos_programacion lo_pnl_datos_programacion = new pnl_datos_programacion();
    evt_datos_programacion lo_evt_datos_programacion = new evt_datos_programacion();
    pnl_grid_programacion lo_pnl_grid_programacion = new pnl_grid_programacion();
    evt_grid_programacion lo_evt_grid_programacion = new evt_grid_programacion();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs;
    DefaultTableModel modelo;
    int li_tipo_operacion, cont = 0, li_cantidad;
    String ls_codigo, ls_codigo_sucursal, ls_serie, ls_codigo_transportista;
    String ls_modulo = "DISTBR", ls_capa = "GUI", ls_clase = "jif_programacion";
    String ls_opcion = "M A A";

    public jif_programacion() {
        initComponents();
        formulario();
        activa_botones();
        lo_pnl_grid_programacion.TBL_programacion.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(title).getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 110);
        lo_pnl_datos_programacion.setBounds(12, 120, 1100, 220);
        lo_pnl_grid_programacion.setBounds(13, 340, 1100, 280);

        this.add(lo_pnl_opciones_3);
        this.add(lo_pnl_datos_programacion);
        this.add(lo_pnl_grid_programacion);

        ls_codigo_sucursal = gs_parametros[0];
        ls_serie = ls_codigo_sucursal;

        lo_pnl_datos_programacion.TXT_sucursal.setText(gs_parametros[1]);
        gs_parametros[0] = "";
        gs_parametros[1] = "";

        modelo = (DefaultTableModel) lo_pnl_grid_programacion.TBL_programacion.getModel();
        modelo.addTableModelListener(TablaListener);

        lo_evt_opciones_3.evento_click(lo_pnl_opciones_3, Listener);
        lo_evt_opciones_3.evento_press(lo_pnl_opciones_3, KeyEvnt);
        lo_evt_datos_programacion.evento_press(lo_pnl_datos_programacion, KeyEvnt);
        lo_evt_datos_programacion.evento_focus(lo_pnl_datos_programacion, FocusEvent);
        lo_pnl_grid_programacion.TBL_programacion.addMouseListener(MouseEvent);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
    }

    public void get_transportista(String codigo) {
        try {
            lq_rs = go_dao_transportista.SLT_datos_pl(codigo);
            if (lq_rs != null) {
                lo_pnl_datos_programacion.TXT_codigo_transportista.setText(lq_rs.getString(1));
                lo_pnl_datos_programacion.TXT_nombre_transportista.setText(lq_rs.getString(2));
                lo_pnl_datos_programacion.TXT_licencia.setText(lq_rs.getString(3));
                lo_pnl_datos_programacion.TXT_empresa.setText(lq_rs.getString(4));
                lo_pnl_datos_programacion.TXT_ruc_empresa.setText(lq_rs.getString(5));
                lo_pnl_datos_programacion.TXT_codigo_vehiculo.setText(lq_rs.getString(6));
                lo_pnl_datos_programacion.TXT_marca.setText(lq_rs.getString(7));
                lo_pnl_datos_programacion.TXT_civ.setText(lq_rs.getString(8));
                lo_pnl_datos_programacion.TXT_codigo_vehiculo_v2.setText(lq_rs.getString(9));
                lo_pnl_datos_programacion.TXT_marca_v2.setText(lq_rs.getString(10));
                lo_pnl_datos_programacion.TXT_civ_v2.setText(lq_rs.getString(11));
                getFocusOwner().transferFocus();
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_transportista", "TRANSPORTISTA NO EXISTE");
                lo_pnl_datos_programacion.TXT_codigo_transportista.requestFocus();
                limpia_transportista();
            }
        } catch (Exception e) {
        }
    }

    private void limpia_transportista() {
        lo_pnl_datos_programacion.TXT_codigo_transportista.setText("");
        lo_pnl_datos_programacion.TXT_nombre_transportista.setText("");
        lo_pnl_datos_programacion.TXT_licencia.setText("");
        lo_pnl_datos_programacion.TXT_ruc_empresa.setText("");
        lo_pnl_datos_programacion.TXT_empresa.setText("");
        lo_pnl_datos_programacion.TXT_codigo_vehiculo.setText("");
        lo_pnl_datos_programacion.TXT_codigo_vehiculo_v2.setText("");
        lo_pnl_datos_programacion.TXT_marca.setText("");
        lo_pnl_datos_programacion.TXT_marca_v2.setText("");
        lo_pnl_datos_programacion.TXT_civ.setText("");
        lo_pnl_datos_programacion.TXT_civ_v2.setText("");
    }

    private void evt_f5_transportista() {
        go_dlg_busq_transportista = new dlg_busq_transportista(null, true);
        go_dlg_busq_transportista.setVisible(true);
        ls_codigo_transportista = go_dlg_busq_transportista.ls_codigo_transportista;
        if (ls_codigo_transportista != null) {
            get_transportista(ls_codigo_transportista);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5_transportista", "SELECCIONE TRANSPORTISTA");
            lo_pnl_datos_programacion.TXT_codigo_transportista.requestFocus();
            limpia_transportista();
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_datos_programacion.limpia_datos(lo_pnl_datos_programacion);
        lo_evt_grid_programacion.limpia_tabla(lo_pnl_grid_programacion);
        li_tipo_operacion = 0;

        try {
            lq_rs = go_dao_programacion.FNC_correlativo_programacion(ls_codigo_sucursal);
            if (lq_rs.next()) {
                lo_pnl_datos_programacion.TXT_numero.setText(lq_rs.getString(1));
                lo_pnl_datos_programacion.LBL_numero_doc.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }

        lo_evt_opciones_3.activa_btn_opciones(1, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_datos_programacion.activa_campos(0, lo_pnl_datos_programacion, true);
        lo_evt_grid_programacion.activa_campos(0, lo_pnl_grid_programacion, true);
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_opciones_3.BTN_nuevo) {
                evt_nuevo();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F1 && lo_pnl_opciones_3.BTN_nuevo.isEnabled()) {
                evt_nuevo();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_datos_programacion.TXT_codigo_transportista) {
                    evt_f5_transportista();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_opciones_3.BTN_nuevo) {
                    evt_nuevo();
                }
                if (ke.getSource() == lo_pnl_datos_programacion.TXT_numero) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_programacion.TXT_numero)) {
                        lo_pnl_datos_programacion.TXT_numero.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_datos_programacion.TXT_numero.getText().trim(), "0", 10));
                        lo_pnl_datos_programacion.LBL_numero_doc.setText(lo_pnl_datos_programacion.TXT_numero.getText());
                        lo_pnl_datos_programacion.TXT_fecha_reparto.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_datos_programacion.TXT_fecha_reparto && !lo_pnl_datos_programacion.TXT_fecha_reparto.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_datos_programacion.TXT_fecha_reparto.getText())) {
                        if (lo_pnl_datos_programacion.TXT_fecha_reparto.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                            getFocusOwner().transferFocus();
                        } else {
                            lo_pnl_datos_programacion.TXT_fecha_reparto.setText("");
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                        }
                    } else {
                        lo_pnl_datos_programacion.TXT_fecha_reparto.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }

                if (ke.getSource() == lo_pnl_datos_programacion.TXT_codigo_transportista && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_programacion.TXT_codigo_transportista)) {
                    lo_pnl_datos_programacion.TXT_codigo_transportista.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_datos_programacion.TXT_codigo_transportista.getText().trim(), "0", 4));
                    get_transportista(lo_pnl_datos_programacion.TXT_codigo_transportista.getText().trim());
                }
                if (ke.getSource() == lo_pnl_datos_programacion.TXT_observacion) {
                    if (lo_pnl_grid_programacion.TBL_programacion.getRowCount() == 0) {
                        lo_pnl_grid_programacion.TBL_programacion.requestFocus();
                        lo_evt_grid_programacion.agrega_fila(lo_pnl_grid_programacion, -1);
                    } else {
                        lo_pnl_grid_programacion.TBL_programacion.requestFocus();
                        lo_pnl_grid_programacion.TBL_programacion.changeSelection(0, 2, false, false);
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_datos_programacion.TXT_numero) {
                lo_pnl_datos_programacion.LBL_numero_doc.setText(lo_pnl_datos_programacion.TXT_numero.getText());
            }
        }

    };

    MouseListener MouseEvent = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == lo_pnl_grid_programacion.TBL_programacion && lo_pnl_grid_programacion.TBL_programacion.isEnabled()) {
                int columna = lo_pnl_grid_programacion.TBL_programacion.getColumnModel().getColumnIndexAtX(me.getX());
                int fila = me.getY() / lo_pnl_grid_programacion.TBL_programacion.getRowHeight();
                Object value = lo_pnl_grid_programacion.TBL_programacion.getValueAt(fila, columna);
                if (value instanceof JButton) {
                    if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR ITEM " + go_fnc_operaciones_campos.completa_digitos((fila + 1) + "", "0", 3) + "?") == 0) {
                        lo_evt_grid_programacion.elimina_fila(lo_pnl_grid_programacion, fila);
                        lo_evt_grid_programacion.genera_item(lo_pnl_grid_programacion);
                    }
                }
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

    FocusListener FocusEvent = new FocusListener() {
        @Override
        public void focusGained(java.awt.event.FocusEvent fe) {
            ((JComponent) fe.getComponent()).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent fe) {
            ((JComponent) fe.getComponent()).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        }
    };

    TableModelListener TablaListener = new TableModelListener() {

        @Override
        public void tableChanged(TableModelEvent tme) {
            if (tme.getType() == TableModelEvent.UPDATE && li_tipo_operacion == 1) {
                cont++;
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("PROGRAMACION REPARTO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 844, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
