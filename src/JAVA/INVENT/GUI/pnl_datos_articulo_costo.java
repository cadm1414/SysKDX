
package JAVA.INVENT.GUI;

import JAVA.UTILITARIOS.FUNCION.fnc_txt_mayuscula;

public class pnl_datos_articulo_costo extends javax.swing.JPanel {

    public pnl_datos_articulo_costo() {
        initComponents();
        TXT_nombre.setDocument(new fnc_txt_mayuscula());
        TXT_nombre_entidad.setDocument(new fnc_txt_mayuscula());
        TXT_codigo_entidad.setDocument(new fnc_txt_mayuscula());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigo_articulo = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        TXT_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CBX_procedencia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CBX_tipo_procedencia = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CBX_mes = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TXT_codigo_entidad = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        TXT_nombre_entidad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        TXT_costo = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        TXT_fecha_ingreso = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        TXT_fecha_produccion = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        TXT_fecha_vencimiento = new javax.swing.JFormattedTextField();
        TXT_numero = new javax.swing.JFormattedTextField();
        TXT_periodo = new javax.swing.JFormattedTextField();
        TXT_anio = new javax.swing.JFormattedTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel1.setText("C. Articulo");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setText(":");

        try {
            txt_codigo_articulo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-######U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_codigo_articulo.setEnabled(false);
        txt_codigo_articulo.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txt_codigo_articulo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/f5.png"))); // NOI18N
        jLabel27.setText(" ");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TXT_nombre.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_nombre.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("Procedencia");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel4.setText(":");

        CBX_procedencia.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_procedencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COMPRA", "PROCESO", "OTROS" }));
        CBX_procedencia.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText("T. Procedencia");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel6.setText(":");

        CBX_tipo_procedencia.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_tipo_procedencia.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel7.setText("Orden Compra");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel8.setText(":");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel9.setText("-");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel10.setText("P. Produccion");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel11.setText(":");

        CBX_mes.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        CBX_mes.setSelectedIndex(1);
        CBX_mes.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel12.setText("Año");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel13.setText(":");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel14.setText("Proveedor");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel15.setText(":");

        TXT_codigo_entidad.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_codigo_entidad.setEnabled(false);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/f5.png"))); // NOI18N
        jLabel28.setText(" ");
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TXT_nombre_entidad.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_nombre_entidad.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel16.setText("Costo");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel17.setText(":");

        TXT_costo.setEnabled(false);
        TXT_costo.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_costo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel18.setText("F. Ingreso");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel19.setText(":");

        try {
            TXT_fecha_ingreso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_fecha_ingreso.setEnabled(false);
        TXT_fecha_ingreso.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_fecha_ingreso.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel20.setText("F. Produccion");

        try {
            TXT_fecha_produccion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_fecha_produccion.setEnabled(false);
        TXT_fecha_produccion.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_fecha_produccion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel21.setText(":");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel22.setText("F. Vencimiento");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel23.setText(":");

        try {
            TXT_fecha_vencimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_fecha_vencimiento.setEnabled(false);
        TXT_fecha_vencimiento.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_fecha_vencimiento.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        try {
            TXT_numero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_numero.setEnabled(false);
        TXT_numero.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_numero.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        try {
            TXT_periodo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_periodo.setEnabled(false);
        TXT_periodo.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_periodo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        try {
            TXT_anio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_anio.setEnabled(false);
        TXT_anio.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_anio.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXT_codigo_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CBX_mes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TXT_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TXT_periodo))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_codigo_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel27))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CBX_procedencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXT_nombre_entidad)
                            .addComponent(TXT_nombre)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TXT_anio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CBX_tipo_procedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TXT_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXT_fecha_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_fecha_produccion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_fecha_vencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigo_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(CBX_procedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(CBX_tipo_procedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(TXT_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(CBX_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(TXT_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(TXT_codigo_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_nombre_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(TXT_fecha_vencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel19)
                        .addComponent(TXT_fecha_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(TXT_fecha_produccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> CBX_mes;
    public javax.swing.JComboBox<String> CBX_procedencia;
    public javax.swing.JComboBox<String> CBX_tipo_procedencia;
    public javax.swing.JFormattedTextField TXT_anio;
    public javax.swing.JTextField TXT_codigo_entidad;
    public javax.swing.JFormattedTextField TXT_costo;
    public javax.swing.JFormattedTextField TXT_fecha_ingreso;
    public javax.swing.JFormattedTextField TXT_fecha_produccion;
    public javax.swing.JFormattedTextField TXT_fecha_vencimiento;
    public javax.swing.JTextField TXT_nombre;
    public javax.swing.JTextField TXT_nombre_entidad;
    public javax.swing.JFormattedTextField TXT_numero;
    public javax.swing.JFormattedTextField TXT_periodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JFormattedTextField txt_codigo_articulo;
    // End of variables declaration//GEN-END:variables
}
