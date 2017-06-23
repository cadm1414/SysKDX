package JAVA.INVENT.GUI;

import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;

public class jif_datos_articulo_costo extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    pnl_datos_articulo_costo lo_pnl_datos_articulo_costo = new pnl_datos_articulo_costo();
    
    public jif_datos_articulo_costo() {
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_articulo_costo.setBounds(12, 130, 550, 350);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_articulo_costo);

        //lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        //lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);

        //lo_evt_datos_subfamilia.evento_press(lo_pnl_datos_subfamilia, KeyEvnt);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("ARTICULO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/INVENT/IMAGES/costo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
