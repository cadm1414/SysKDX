package JAVA.INVENT.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import JAVA.ANCESTRO.LOGICA.evt_aceptar_cancelar;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRParameter;

public class dlg_rpt_kardex_mercaderia extends javax.swing.JDialog {

    pnl_rpt_kardex_mercaderia lo_pnl_rpt_kardex_mercaderia = new pnl_rpt_kardex_mercaderia();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    String ls_modulo = "INVENT", ls_capa = "GUI", ls_clase = "dlg_rpt_kardex_mercaderia";

    public dlg_rpt_kardex_mercaderia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_rpt_kardex_mercaderia.setBounds(10, 10, 500, 130);
        lo_pnl_aceptar_cancelar.setBounds(140, 130, 200, 50);

        this.add(lo_pnl_rpt_kardex_mercaderia);
        this.add(lo_pnl_aceptar_cancelar);

        lo_pnl_rpt_kardex_mercaderia.TXT_fecha_ini.setText("01" + gs_mes + gs_periodo);
        lo_pnl_rpt_kardex_mercaderia.TXT_fecha_fin.setText(gs_dia + gs_mes + gs_periodo);

        lo_pnl_rpt_kardex_mercaderia.TXT_codigo.addKeyListener(KeyEvnt);
        lo_pnl_rpt_kardex_mercaderia.TXT_codigo_articulo.addKeyListener(KeyEvnt);
        lo_pnl_rpt_kardex_mercaderia.CBX_formato.addKeyListener(KeyEvnt);
        lo_pnl_rpt_kardex_mercaderia.TXT_fecha_ini.addKeyListener(KeyEvnt);
        lo_pnl_rpt_kardex_mercaderia.TXT_fecha_fin.addKeyListener(KeyEvnt);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
        lo_evt_aceptar_cancelar.evento_press(lo_pnl_aceptar_cancelar, KeyEvnt);
    }

    private boolean valida_fecha(JTextField fecha) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.valida_fecha(fecha.getText())) {
            if (fecha.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                resp = true;
            } else {
                fecha.setText("");
                go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
            }
        } else {
            fecha.setText("");
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
        }
        return resp;
    }

    private boolean valida_campos() {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_rpt_kardex_mercaderia.TXT_codigo) && go_fnc_operaciones_campos.campo_blanco(lo_pnl_rpt_kardex_mercaderia.TXT_nombre)) {
            if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_rpt_kardex_mercaderia.TXT_codigo_articulo) && go_fnc_operaciones_campos.campo_blanco(lo_pnl_rpt_kardex_mercaderia.TXT_nombre_articulo)) {
                if (valida_fecha(lo_pnl_rpt_kardex_mercaderia.TXT_fecha_ini)) {
                    if (valida_fecha(lo_pnl_rpt_kardex_mercaderia.TXT_fecha_fin)) {
                        if (go_fnc_operaciones_campos.compara_fechas(lo_pnl_rpt_kardex_mercaderia.TXT_fecha_ini.getText(), lo_pnl_rpt_kardex_mercaderia.TXT_fecha_fin.getText()) <= 0) {
                            resp = true;
                        } else {
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "valida_campos", "FECHA INICIAL TIENE QUE SER MENOR y/o IGUAL A FECHA FINAL");
                        }
                    }
                }
            } else {
                go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE ARTICULO");
                lo_pnl_rpt_kardex_mercaderia.TXT_codigo_articulo.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE ALMACEN");
            lo_pnl_rpt_kardex_mercaderia.TXT_codigo.requestFocus();
        }
        return resp;
    }

    private void muestra_rpt() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        parametros.put("codigo_almacen", lo_pnl_rpt_kardex_mercaderia.TXT_codigo.getText());
        parametros.put("fecha_ini", go_fnc_operaciones_campos.formarto_date(lo_pnl_rpt_kardex_mercaderia.TXT_fecha_ini.getText()));
        parametros.put("fecha_fin", go_fnc_operaciones_campos.formarto_date(lo_pnl_rpt_kardex_mercaderia.TXT_fecha_fin.getText()));
        parametros.put("periodo", gs_periodo);
        parametros.put("nombre_almacen", lo_pnl_rpt_kardex_mercaderia.TXT_nombre.getText().trim());
        parametros.put("codigo_articulo", lo_pnl_rpt_kardex_mercaderia.TXT_codigo_articulo.getText());
        parametros.put(JRParameter.REPORT_LOCALE, Locale.ENGLISH);
        switch (lo_pnl_rpt_kardex_mercaderia.CBX_formato.getSelectedIndex()) {
            case 0:
                go_muestra_reporte_invent.reporte_pestania("rpt_kardex_mercaderia.jasper", parametros, "KARDEX NORMAL", 8);
                break;
            case 1:
                go_muestra_reporte_invent.reporte_pestania("rpt_kardex_mercaderia_val.jasper", parametros, "KARDEX VALORIZADO", 9);
                break;
        }
    }

    private void evt_aceptar() {
        if (valida_campos()) {
            muestra_rpt();
            dispose();
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_cancelar) {
                dispose();
            }
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                evt_aceptar();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_rpt_kardex_mercaderia.TXT_codigo) {
                    go_activa_buscador.busq_almacen_permiso("1", "1", "1", lo_pnl_rpt_kardex_mercaderia.TXT_codigo, lo_pnl_rpt_kardex_mercaderia.TXT_nombre);
                }
                if (ke.getSource() == lo_pnl_rpt_kardex_mercaderia.TXT_codigo_articulo) {
                    go_activa_buscador.busq_articulo(lo_pnl_rpt_kardex_mercaderia.TXT_codigo_articulo, lo_pnl_rpt_kardex_mercaderia.TXT_nombre_articulo);
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_rpt_kardex_mercaderia.TXT_codigo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_rpt_kardex_mercaderia.TXT_codigo.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                    go_activa_buscador.get_descripcion_almacen_permiso(lo_pnl_rpt_kardex_mercaderia.TXT_codigo.getText(), "1", "1", lo_pnl_rpt_kardex_mercaderia.TXT_codigo, lo_pnl_rpt_kardex_mercaderia.TXT_nombre);
                }
                if (ke.getSource() == lo_pnl_rpt_kardex_mercaderia.TXT_codigo_articulo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_rpt_kardex_mercaderia.TXT_codigo_articulo.getText().trim(), 1, 12)) {
                    getFocusOwner().transferFocus();
                    go_activa_buscador.get_descripcion_articulo(lo_pnl_rpt_kardex_mercaderia.TXT_codigo_articulo.getText().trim(), lo_pnl_rpt_kardex_mercaderia.TXT_codigo_articulo, lo_pnl_rpt_kardex_mercaderia.TXT_nombre_articulo);
                }
                if (ke.getSource() == lo_pnl_rpt_kardex_mercaderia.CBX_formato) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_rpt_kardex_mercaderia.TXT_fecha_ini && !lo_pnl_rpt_kardex_mercaderia.TXT_fecha_ini.getText().trim().equalsIgnoreCase("/  /")) {
                    if (valida_fecha(lo_pnl_rpt_kardex_mercaderia.TXT_fecha_ini)) {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_rpt_kardex_mercaderia.TXT_fecha_fin && !lo_pnl_rpt_kardex_mercaderia.TXT_fecha_fin.getText().trim().equalsIgnoreCase("/  /")) {
                    if (valida_fecha(lo_pnl_rpt_kardex_mercaderia.TXT_fecha_fin)) {
                        if (go_fnc_operaciones_campos.compara_fechas(lo_pnl_rpt_kardex_mercaderia.TXT_fecha_ini.getText(), lo_pnl_rpt_kardex_mercaderia.TXT_fecha_fin.getText()) <= 0) {
                            getFocusOwner().transferFocus();
                        } else {
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA INICIAL TIENE QUE SER MENOR y/o IGUAL A FECHA FINAL");
                        }
                    }
                }
                if(ke.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar){
                    evt_aceptar();
                }
                if(ke.getSource() == lo_pnl_aceptar_cancelar.BTN_cancelar){
                    dispose();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PARAMETROS");
        setIconImage(getIconImage());
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_rpt_kardex_mercaderia dialog = new dlg_rpt_kardex_mercaderia(new javax.swing.JFrame(), true);
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

    public Image
            getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_ancestro.class
                        .getResource("parametros.png"));
        return retValue;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
