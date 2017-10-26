package JAVA.VENTAS.GUI;

import JAVA.UTILITARIOS.FUNCION.fnc_txt_mayuscula;
import java.text.DecimalFormatSymbols;

public class pnl_cab_nota_credito extends javax.swing.JPanel {

    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();

    public pnl_cab_nota_credito() {
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        initComponents();
        TXT_sucursal.setDocument(new fnc_txt_mayuscula());
        TXT_codigo_entidad.setDocument(new fnc_txt_mayuscula());
        TXT_razon_social.setDocument(new fnc_txt_mayuscula());
        TXT_descripcion.setDocument(new fnc_txt_mayuscula());
        TXT_codigo_pagador.setDocument(new fnc_txt_mayuscula());
        TXT_pagador.setDocument(new fnc_txt_mayuscula());
        TXT_nombre_vendedor.setDocument(new fnc_txt_mayuscula());
        TXT_observacion.setDocument(new fnc_txt_mayuscula());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TXT_sucursal = new javax.swing.JTextField();
        TXT_fecha_emision = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TXT_tipo_cambio = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CBX_codigo_detraccion = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        TXT_detraccion = new javax.swing.JFormattedTextField();
        CBX_moneda = new javax.swing.JComboBox<>();
        CBX_igv = new javax.swing.JComboBox<>();
        TXT_serie = new javax.swing.JFormattedTextField();
        TXT_numero_doc = new javax.swing.JFormattedTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        CBX_afecto_igv = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        CBX_status = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TXT_serie_ref = new javax.swing.JFormattedTextField();
        TXT_numero_ref = new javax.swing.JFormattedTextField();
        JRD_precio_igv = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        TXT_codigo_entidad = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        TXT_razon_social = new javax.swing.JTextField();
        CBX_tipo_documento_id = new javax.swing.JComboBox<>();
        TXT_doc_id = new javax.swing.JFormattedTextField();
        TXT_codigo_ubigeo = new javax.swing.JFormattedTextField();
        jLabel33 = new javax.swing.JLabel();
        TXT_descripcion = new javax.swing.JTextField();
        JRD_domiciliado = new javax.swing.JRadioButton();
        CBX_direccion = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        TXT_codigo_pagador = new javax.swing.JTextField();
        TXT_codigo_vendedor = new javax.swing.JFormattedTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        TXT_pagador = new javax.swing.JTextField();
        TXT_nombre_vendedor = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        TXT_observacion = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        CBX_concepto = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        CBX_registra_item = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        TXT_total = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        LBL_fecha_registro = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        LBL_numero_doc = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel1.setText("Sucursal");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setText("Serie-Numero");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("F. Emision");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel4.setText(":");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText(":");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel6.setText(":");

        TXT_sucursal.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_sucursal.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_sucursal.setEnabled(false);
        TXT_sucursal.setNextFocusableComponent(TXT_serie);

        try {
            TXT_fecha_emision.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_fecha_emision.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_fecha_emision.setEnabled(false);
        TXT_fecha_emision.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_fecha_emision.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_fecha_emision.setNextFocusableComponent(TXT_serie_ref);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel10.setText("T. Cambio");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel12.setText("Moneda");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel13.setText(":");

        TXT_tipo_cambio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.000",simbolos))));
        TXT_tipo_cambio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TXT_tipo_cambio.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_tipo_cambio.setEnabled(false);
        TXT_tipo_cambio.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_tipo_cambio.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_tipo_cambio.setNextFocusableComponent(CBX_igv);

        jLabel20.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel20.setText("% I.G.V.");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel21.setText(":");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel14.setText("% Detraccion");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel15.setText(":");

        CBX_codigo_detraccion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_codigo_detraccion.setEnabled(false);
        CBX_codigo_detraccion.setNextFocusableComponent(TXT_detraccion);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel16.setText("C. Detraccion");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel17.setText(":");

        TXT_detraccion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        TXT_detraccion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TXT_detraccion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_detraccion.setEnabled(false);
        TXT_detraccion.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_detraccion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_detraccion.setNextFocusableComponent(CBX_status);

        CBX_moneda.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_moneda.setEnabled(false);
        CBX_moneda.setNextFocusableComponent(TXT_tipo_cambio);

        CBX_igv.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_igv.setEnabled(false);
        CBX_igv.setNextFocusableComponent(CBX_afecto_igv);

        try {
            TXT_serie.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_serie.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_serie.setEnabled(false);
        TXT_serie.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_serie.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_serie.setNextFocusableComponent(TXT_numero_doc);

        try {
            TXT_numero_doc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_numero_doc.setText("0000000000");
        TXT_numero_doc.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_numero_doc.setEnabled(false);
        TXT_numero_doc.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_numero_doc.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_numero_doc.setNextFocusableComponent(TXT_fecha_emision);

        jLabel53.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel53.setText(":");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel18.setText("Afecto IGV");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel19.setText(":");

        CBX_afecto_igv.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_afecto_igv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        CBX_afecto_igv.setEnabled(false);
        CBX_afecto_igv.setNextFocusableComponent(CBX_codigo_detraccion);

        jLabel22.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel22.setText("Estado");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel23.setText(":");

        CBX_status.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ANULADO", "VIGENTE" }));
        CBX_status.setEnabled(false);
        CBX_status.setNextFocusableComponent(JRD_precio_igv);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel7.setText("Doc. Ref.");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel8.setText(":");

        try {
            TXT_serie_ref.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_serie_ref.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_serie_ref.setEnabled(false);
        TXT_serie_ref.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_serie_ref.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_serie_ref.setNextFocusableComponent(TXT_numero_ref);

        try {
            TXT_numero_ref.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_numero_ref.setText("0000000000");
        TXT_numero_ref.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_numero_ref.setEnabled(false);
        TXT_numero_ref.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_numero_ref.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_numero_ref.setNextFocusableComponent(CBX_moneda);

        JRD_precio_igv.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_precio_igv.setText("Precio Sin IGV");
        JRD_precio_igv.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_sucursal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_fecha_emision, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_serie_ref, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_numero_ref))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_serie, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_numero_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBX_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TXT_tipo_cambio)
                                    .addComponent(CBX_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBX_afecto_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addGap(4, 4, 4)
                        .addComponent(CBX_status, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel17)
                            .addGap(4, 4, 4)
                            .addComponent(TXT_detraccion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(jLabel15)
                            .addGap(4, 4, 4)
                            .addComponent(CBX_codigo_detraccion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JRD_precio_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(TXT_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel53)
                                    .addComponent(CBX_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(TXT_serie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXT_numero_doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(TXT_tipo_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(CBX_codigo_detraccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(TXT_detraccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)
                                    .addComponent(CBX_igv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(TXT_fecha_emision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(CBX_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(CBX_afecto_igv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(TXT_serie_ref, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_numero_ref, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JRD_precio_igv))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel24.setText("Cod. Cliente");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel25.setText("Doc. Identidad");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel26.setText("Direccion");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel27.setText("Ubigeo");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel28.setText(":");

        jLabel29.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel29.setText(":");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel30.setText(":");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel31.setText(":");

        TXT_codigo_entidad.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_codigo_entidad.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_codigo_entidad.setEnabled(false);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/f5.png"))); // NOI18N
        jLabel32.setText(" ");
        jLabel32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TXT_razon_social.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_razon_social.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_razon_social.setEnabled(false);

        CBX_tipo_documento_id.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_tipo_documento_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "DNI" }));
        CBX_tipo_documento_id.setEnabled(false);

        try {
            TXT_doc_id.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_doc_id.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_doc_id.setEnabled(false);
        TXT_doc_id.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_doc_id.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        try {
            TXT_codigo_ubigeo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_codigo_ubigeo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_codigo_ubigeo.setEnabled(false);
        TXT_codigo_ubigeo.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_codigo_ubigeo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/f5.png"))); // NOI18N
        jLabel33.setText(" ");
        jLabel33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TXT_descripcion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_descripcion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_descripcion.setEnabled(false);

        JRD_domiciliado.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_domiciliado.setText("Domiciliado");
        JRD_domiciliado.setEnabled(false);

        CBX_direccion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_direccion.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TXT_codigo_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32))
                            .addComponent(CBX_tipo_documento_id, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TXT_doc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JRD_domiciliado, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(TXT_razon_social)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TXT_codigo_ubigeo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_descripcion))
                    .addComponent(CBX_direccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel31)
                    .addComponent(TXT_codigo_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_razon_social, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel30)
                    .addComponent(CBX_tipo_documento_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_doc_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JRD_domiciliado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel29)
                    .addComponent(CBX_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(TXT_codigo_ubigeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESPECIFICACIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel34.setText("Pagador");

        jLabel35.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel35.setText(":");

        jLabel36.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel36.setText("Vendedor");

        jLabel37.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel37.setText(":");

        TXT_codigo_pagador.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_codigo_pagador.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_codigo_pagador.setEnabled(false);

        try {
            TXT_codigo_vendedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_codigo_vendedor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_codigo_vendedor.setEnabled(false);
        TXT_codigo_vendedor.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_codigo_vendedor.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/f5.png"))); // NOI18N
        jLabel42.setText(" ");
        jLabel42.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/f5.png"))); // NOI18N
        jLabel43.setText(" ");
        jLabel43.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TXT_pagador.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_pagador.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_pagador.setEnabled(false);

        TXT_nombre_vendedor.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_nombre_vendedor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_nombre_vendedor.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel46.setText("Observacion");

        jLabel48.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel48.setText(":");

        TXT_observacion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_observacion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_observacion.setEnabled(false);

        jLabel49.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel49.setText("Concepto");

        jLabel50.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel50.setText(":");

        CBX_concepto.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_concepto.setEnabled(false);

        jLabel38.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel38.setText("R. Item");

        jLabel39.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel39.setText(":");

        CBX_registra_item.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_registra_item.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        CBX_registra_item.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel40.setText("Total");

        jLabel41.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel41.setText(":");

        TXT_total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00",simbolos))));
        TXT_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TXT_total.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_total.setEnabled(false);
        TXT_total.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_total.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_observacion))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBX_concepto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel37)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXT_codigo_vendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(TXT_codigo_pagador, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXT_nombre_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_pagador, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBX_registra_item, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_total)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(TXT_codigo_pagador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_pagador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(TXT_codigo_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_nombre_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel48)
                    .addComponent(TXT_observacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addComponent(CBX_concepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(TXT_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(jLabel39)
                        .addComponent(CBX_registra_item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel44.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel44.setText("Fecha Registro");

        jLabel45.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel45.setText(":");

        LBL_fecha_registro.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_fecha_registro.setForeground(new java.awt.Color(204, 0, 51));
        LBL_fecha_registro.setText(" ");

        jLabel47.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("NUMERO");

        LBL_numero_doc.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        LBL_numero_doc.setForeground(new java.awt.Color(0, 153, 153));
        LBL_numero_doc.setText("0000000000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBL_numero_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBL_fecha_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_numero_doc)
                    .addComponent(jLabel47))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(LBL_fecha_registro))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> CBX_afecto_igv;
    public javax.swing.JComboBox<String> CBX_codigo_detraccion;
    public javax.swing.JComboBox<String> CBX_concepto;
    public javax.swing.JComboBox<String> CBX_direccion;
    public javax.swing.JComboBox<String> CBX_igv;
    public javax.swing.JComboBox<String> CBX_moneda;
    public javax.swing.JComboBox<String> CBX_registra_item;
    public javax.swing.JComboBox<String> CBX_status;
    public javax.swing.JComboBox<String> CBX_tipo_documento_id;
    public javax.swing.JRadioButton JRD_domiciliado;
    public javax.swing.JRadioButton JRD_precio_igv;
    public javax.swing.JLabel LBL_fecha_registro;
    public javax.swing.JLabel LBL_numero_doc;
    public javax.swing.JTextField TXT_codigo_entidad;
    public javax.swing.JTextField TXT_codigo_pagador;
    public javax.swing.JFormattedTextField TXT_codigo_ubigeo;
    public javax.swing.JFormattedTextField TXT_codigo_vendedor;
    public javax.swing.JTextField TXT_descripcion;
    public javax.swing.JFormattedTextField TXT_detraccion;
    public javax.swing.JFormattedTextField TXT_doc_id;
    public javax.swing.JFormattedTextField TXT_fecha_emision;
    public javax.swing.JTextField TXT_nombre_vendedor;
    public javax.swing.JFormattedTextField TXT_numero_doc;
    public javax.swing.JFormattedTextField TXT_numero_ref;
    public javax.swing.JTextField TXT_observacion;
    public javax.swing.JTextField TXT_pagador;
    public javax.swing.JTextField TXT_razon_social;
    public javax.swing.JFormattedTextField TXT_serie;
    public javax.swing.JFormattedTextField TXT_serie_ref;
    public javax.swing.JTextField TXT_sucursal;
    public javax.swing.JFormattedTextField TXT_tipo_cambio;
    public javax.swing.JFormattedTextField TXT_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
