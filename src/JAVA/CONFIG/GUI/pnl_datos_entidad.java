package JAVA.CONFIG.GUI;

import JAVA.UTILITARIOS.FUNCION.fnc_txt_mayuscula;
import java.text.DecimalFormatSymbols;

public class pnl_datos_entidad extends javax.swing.JPanel {

    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();

    public pnl_datos_entidad() {
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        initComponents();
        TXT_numero_doc_id.setDocument(new fnc_txt_mayuscula());
        TXT_papellido.setDocument(new fnc_txt_mayuscula());
        TXT_sapellido.setDocument(new fnc_txt_mayuscula());
        TXT_nombre.setDocument(new fnc_txt_mayuscula());
        TXT_razon_social.setDocument(new fnc_txt_mayuscula());
        TXT_nombre_comercial.setDocument(new fnc_txt_mayuscula());
        TXT_direccion.setDocument(new fnc_txt_mayuscula());
        TXT_descripcion_ubigeo.setDocument(new fnc_txt_mayuscula());
        TXT_observacion.setDocument(new fnc_txt_mayuscula());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GBT_procedencia = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        JRD_es_cliente = new javax.swing.JRadioButton();
        JRD_es_proveedor = new javax.swing.JRadioButton();
        JRD_es_trabajador = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXT_codigo_entidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CBX_tipo_persona = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TXT_papellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TXT_sapellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TXT_nombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CBX_estado = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        TXT_razon_social = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TXT_nombre_comercial = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        CBX_tipo_documento_id = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        TXT_numero_doc_id = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JRD_nacional = new javax.swing.JRadioButton();
        JRD_extranjero = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        CBX_pais = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        TXT_direccion = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        TXT_codigo_ubigeo = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        TXT_descripcion_ubigeo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        CBX_forma_pago = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        TXT_dias_cr = new javax.swing.JFormattedTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        TXT_limite_cr = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        CBX_sucursal = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        CBX_tipo_comercio = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        CBX_vendedor = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        TXT_observacion = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        CBX_sector = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        JRD_agente_percepcion = new javax.swing.JRadioButton();
        JRD_agente_retencion = new javax.swing.JRadioButton();
        JRD_entidad_excluida = new javax.swing.JRadioButton();
        JRD_es_domiciliado = new javax.swing.JRadioButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TIPO ENTIDAD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        JRD_es_cliente.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_es_cliente.setSelected(true);
        JRD_es_cliente.setText("Cliente");
        JRD_es_cliente.setEnabled(false);

        JRD_es_proveedor.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_es_proveedor.setText("Proveedor");
        JRD_es_proveedor.setEnabled(false);

        JRD_es_trabajador.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_es_trabajador.setText("Trabajador");
        JRD_es_trabajador.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JRD_es_cliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(JRD_es_proveedor)
                .addGap(10, 10, 10)
                .addComponent(JRD_es_trabajador)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(JRD_es_cliente)
                .addComponent(JRD_es_proveedor)
                .addComponent(JRD_es_trabajador))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS GENERALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel1.setText("Codigo");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 18, 70, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setText(":");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 18, -1, -1));

        TXT_codigo_entidad.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_codigo_entidad.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_codigo_entidad.setEnabled(false);
        jPanel2.add(TXT_codigo_entidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 15, 85, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("Tipo Persona");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 41, 70, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel4.setText(":");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 41, -1, -1));

        CBX_tipo_persona.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_tipo_persona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NATURAL", "JURIDICA" }));
        CBX_tipo_persona.setEnabled(false);
        jPanel2.add(CBX_tipo_persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 38, 85, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel7.setText("1° Apellido");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 91, 70, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel8.setText(":");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 91, -1, -1));

        TXT_papellido.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_papellido.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_papellido.setEnabled(false);
        jPanel2.add(TXT_papellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 88, 85, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel9.setText("2° Apellido");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 91, 70, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel10.setText(":");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 91, -1, -1));

        TXT_sapellido.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_sapellido.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_sapellido.setEnabled(false);
        jPanel2.add(TXT_sapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 88, 115, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText("Nombre(s)");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 116, 70, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel6.setText(":");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 116, -1, -1));

        TXT_nombre.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_nombre.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_nombre.setEnabled(false);
        jPanel2.add(TXT_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 113, 287, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel11.setText("Estado");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 18, 70, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel12.setText(":");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 18, -1, -1));

        CBX_estado.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BLOQUEADO", "ACTIVO" }));
        CBX_estado.setEnabled(false);
        jPanel2.add(CBX_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 15, 115, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel14.setText(":");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 141, -1, -1));

        TXT_razon_social.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_razon_social.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_razon_social.setEnabled(false);
        jPanel2.add(TXT_razon_social, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 138, 287, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel15.setText("N. Comercial");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 166, 70, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel16.setText(":");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 166, -1, -1));

        TXT_nombre_comercial.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_nombre_comercial.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_nombre_comercial.setEnabled(false);
        jPanel2.add(TXT_nombre_comercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 163, 287, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel17.setText("Tipo Doc.");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 41, 70, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel18.setText(":");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 41, -1, -1));

        CBX_tipo_documento_id.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_tipo_documento_id.setEnabled(false);
        jPanel2.add(CBX_tipo_documento_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 38, 115, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel19.setText("N° Documento");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 66, 70, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel20.setText(":");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 66, -1, -1));

        TXT_numero_doc_id.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_numero_doc_id.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_numero_doc_id.setEnabled(false);
        jPanel2.add(TXT_numero_doc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 63, 85, -1));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel44.setText("Razon Social");
        jPanel2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 141, 70, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROCEDENCIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        GBT_procedencia.add(JRD_nacional);
        JRD_nacional.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_nacional.setSelected(true);
        JRD_nacional.setText("Nacional");
        JRD_nacional.setEnabled(false);

        GBT_procedencia.add(JRD_extranjero);
        JRD_extranjero.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_extranjero.setText("Extranjero");
        JRD_extranjero.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JRD_nacional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JRD_extranjero)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRD_nacional)
                    .addComponent(JRD_extranjero)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UBICACION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel21.setText("Pais");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 18, 70, -1));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel22.setText(":");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 18, -1, -1));

        CBX_pais.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_pais.setEnabled(false);
        jPanel4.add(CBX_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 15, 92, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel23.setText("Direccion");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 43, 70, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel24.setText(":");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 43, -1, -1));

        TXT_direccion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_direccion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_direccion.setEnabled(false);
        jPanel4.add(TXT_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 40, 287, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel25.setText("Ubigeo");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 70, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel26.setText(":");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 68, -1, -1));

        try {
            TXT_codigo_ubigeo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_codigo_ubigeo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_codigo_ubigeo.setEnabled(false);
        TXT_codigo_ubigeo.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_codigo_ubigeo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel4.add(TXT_codigo_ubigeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 65, 61, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/f5.png"))); // NOI18N
        jLabel27.setText(" ");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 65, -1, 19));

        TXT_descripcion_ubigeo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_descripcion_ubigeo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_descripcion_ubigeo.setEnabled(false);
        jPanel4.add(TXT_descripcion_ubigeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 65, 194, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS COMERCIALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel28.setText("Forma Pago");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 29, 70, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel29.setText(":");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 29, -1, -1));

        CBX_forma_pago.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_forma_pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "CREDITO" }));
        CBX_forma_pago.setEnabled(false);
        jPanel5.add(CBX_forma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 26, 85, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel30.setText("Dias");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 29, 30, -1));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel31.setText(":");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 29, -1, -1));

        TXT_dias_cr.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        TXT_dias_cr.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_dias_cr.setEnabled(false);
        TXT_dias_cr.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_dias_cr.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel5.add(TXT_dias_cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 26, 25, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel32.setText("Limite");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 29, -1, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel33.setText(":");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 29, -1, -1));

        TXT_limite_cr.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00",simbolos))));
        TXT_limite_cr.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_limite_cr.setEnabled(false);
        TXT_limite_cr.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_limite_cr.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jPanel5.add(TXT_limite_cr, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 26, 58, -1));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel34.setText("Sucursal");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 54, 70, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel35.setText(":");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 54, -1, -1));

        CBX_sucursal.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_sucursal.setEnabled(false);
        jPanel5.add(CBX_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 51, 268, -1));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel36.setText("Tipo Comercio");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 79, -1, -1));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel37.setText(":");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 79, -1, -1));

        CBX_tipo_comercio.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_tipo_comercio.setEnabled(false);
        jPanel5.add(CBX_tipo_comercio, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 76, 268, -1));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel38.setText("Vendedor");
        jPanel5.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 104, 70, -1));

        jLabel39.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel39.setText(":");
        jPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 104, -1, -1));

        CBX_vendedor.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_vendedor.setEnabled(false);
        jPanel5.add(CBX_vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 101, 268, -1));

        jLabel40.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel40.setText("Observacion");
        jPanel5.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 154, 70, -1));

        jLabel41.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel41.setText(":");
        jPanel5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 154, -1, -1));

        TXT_observacion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_observacion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_observacion.setEnabled(false);
        jPanel5.add(TXT_observacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 151, 268, -1));

        jLabel42.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel42.setText("Sector");
        jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 129, 70, -1));

        jLabel43.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel43.setText(":");
        jPanel5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 129, -1, -1));

        CBX_sector.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_sector.setEnabled(false);
        jPanel5.add(CBX_sector, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 126, 268, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS SUNAT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JRD_agente_percepcion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_agente_percepcion.setText("A. Percepcion");
        JRD_agente_percepcion.setEnabled(false);
        jPanel6.add(JRD_agente_percepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 30, 107, -1));

        JRD_agente_retencion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_agente_retencion.setText("A. Retencion");
        JRD_agente_retencion.setEnabled(false);
        jPanel6.add(JRD_agente_retencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 30, -1, -1));

        JRD_entidad_excluida.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_entidad_excluida.setText("Entidad Excluida");
        JRD_entidad_excluida.setEnabled(false);
        jPanel6.add(JRD_entidad_excluida, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, -1, -1));

        JRD_es_domiciliado.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_es_domiciliado.setSelected(true);
        JRD_es_domiciliado.setText("Domiciliado");
        JRD_es_domiciliado.setEnabled(false);
        jPanel6.add(JRD_es_domiciliado, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 54, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> CBX_estado;
    public javax.swing.JComboBox<String> CBX_forma_pago;
    public javax.swing.JComboBox<String> CBX_pais;
    public javax.swing.JComboBox<String> CBX_sector;
    public javax.swing.JComboBox<String> CBX_sucursal;
    public javax.swing.JComboBox<String> CBX_tipo_comercio;
    public javax.swing.JComboBox<String> CBX_tipo_documento_id;
    public javax.swing.JComboBox<String> CBX_tipo_persona;
    public javax.swing.JComboBox<String> CBX_vendedor;
    private javax.swing.ButtonGroup GBT_procedencia;
    public javax.swing.JRadioButton JRD_agente_percepcion;
    public javax.swing.JRadioButton JRD_agente_retencion;
    public javax.swing.JRadioButton JRD_entidad_excluida;
    public javax.swing.JRadioButton JRD_es_cliente;
    public javax.swing.JRadioButton JRD_es_domiciliado;
    public javax.swing.JRadioButton JRD_es_proveedor;
    public javax.swing.JRadioButton JRD_es_trabajador;
    public javax.swing.JRadioButton JRD_extranjero;
    public javax.swing.JRadioButton JRD_nacional;
    public javax.swing.JTextField TXT_codigo_entidad;
    public javax.swing.JFormattedTextField TXT_codigo_ubigeo;
    public javax.swing.JTextField TXT_descripcion_ubigeo;
    public javax.swing.JFormattedTextField TXT_dias_cr;
    public javax.swing.JTextField TXT_direccion;
    public javax.swing.JFormattedTextField TXT_limite_cr;
    public javax.swing.JTextField TXT_nombre;
    public javax.swing.JTextField TXT_nombre_comercial;
    public javax.swing.JTextField TXT_numero_doc_id;
    public javax.swing.JTextField TXT_observacion;
    public javax.swing.JTextField TXT_papellido;
    public javax.swing.JTextField TXT_razon_social;
    public javax.swing.JTextField TXT_sapellido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
