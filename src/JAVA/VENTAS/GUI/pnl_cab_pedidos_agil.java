package JAVA.VENTAS.GUI;

import JAVA.ANCESTRO.LOGICA.evt_focus_component;
import JAVA.ANCESTRO.LOGICA.evt_focus_fecha;
import JAVA.UTILITARIOS.FUNCION.fnc_txt_mayuscula;
import java.text.DecimalFormatSymbols;

public class pnl_cab_pedidos_agil extends javax.swing.JPanel {

    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();

    public pnl_cab_pedidos_agil() {
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        initComponents();
        TXT_sucursal.setDocument(new fnc_txt_mayuscula());
        TXT_codigo_entidad.setDocument(new fnc_txt_mayuscula());
        TXT_razon_social.setDocument(new fnc_txt_mayuscula());
        //TXT_direccion.setDocument(new fnc_txt_mayuscula());
        
        TXT_descripcion.setDocument(new fnc_txt_mayuscula());
        TXT_observacion.setDocument(new fnc_txt_mayuscula());
        
        TXT_numero_doc.addFocusListener(new evt_focus_component());
        TXT_fecha_emision.addFocusListener(new evt_focus_fecha());
        CBX_doc_ref.addFocusListener(new evt_focus_component());
        TXT_codigo_entidad.addFocusListener(new evt_focus_component());
        CBX_direccion.addFocusListener(new evt_focus_component());
        TXT_observacion.addFocusListener(new evt_focus_component());
        TXT_razon_social.addFocusListener(new evt_focus_component());
        TXT_doc_id.addFocusListener(new evt_focus_component());
        TXT_codigo_ubigeo.addFocusListener(new evt_focus_component());
        CBX_sector.addFocusListener(new evt_focus_component());
        TXT_codigo_articulo.addFocusListener(new evt_focus_component());
        CBX_presentacion.addFocusListener(new evt_focus_component());
        TXT_precio.addFocusListener(new evt_focus_component());
        TXT_cantidad.addFocusListener(new evt_focus_component());
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CBX_doc_ref = new javax.swing.JComboBox<>();
        TXT_serie = new javax.swing.JFormattedTextField();
        TXT_numero_doc = new javax.swing.JFormattedTextField();
        jLabel47 = new javax.swing.JLabel();
        LBL_numero_doc = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        TXT_razon_social = new javax.swing.JTextField();
        CBX_tipo_documento_id = new javax.swing.JComboBox<>();
        TXT_doc_id = new javax.swing.JFormattedTextField();
        TXT_codigo_ubigeo = new javax.swing.JFormattedTextField();
        jLabel33 = new javax.swing.JLabel();
        TXT_descripcion = new javax.swing.JTextField();
        JRD_domiciliado = new javax.swing.JRadioButton();
        CBX_direccion = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        CBX_sector = new javax.swing.JComboBox<>();
        TXT_codigo_entidad = new javax.swing.JFormattedTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        TXT_observacion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TXT_codigo_articulo = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        TXT_nombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CBX_presentacion = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        TXT_cantidad = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        TXT_precio = new javax.swing.JFormattedTextField();
        BTN_agregar = new javax.swing.JButton();

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
        TXT_sucursal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_sucursal.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_sucursal.setEnabled(false);
        TXT_sucursal.setNextFocusableComponent(TXT_serie);

        TXT_fecha_emision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        try {
            TXT_fecha_emision.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_fecha_emision.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_fecha_emision.setEnabled(false);
        TXT_fecha_emision.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_fecha_emision.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_fecha_emision.setNextFocusableComponent(CBX_doc_ref);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel8.setText("T. Doc. Ref");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel9.setText(":");

        CBX_doc_ref.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_doc_ref.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FACTURA", "BOLETA" }));
        CBX_doc_ref.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_doc_ref.setEnabled(false);

        TXT_serie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
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

        TXT_numero_doc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
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

        jLabel47.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("NUMERO");

        LBL_numero_doc.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        LBL_numero_doc.setForeground(new java.awt.Color(0, 153, 153));
        LBL_numero_doc.setText("0000000000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_sucursal)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel6)
                                .addGap(4, 4, 4)
                                .addComponent(TXT_fecha_emision))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel9)
                                .addGap(4, 4, 4)
                                .addComponent(CBX_doc_ref, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel5)
                                .addGap(4, 4, 4)
                                .addComponent(TXT_serie, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(TXT_numero_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(114, 114, 114)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBL_numero_doc)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel47)))
                        .addGap(88, 88, 88))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(TXT_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(TXT_serie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_numero_doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(TXT_fecha_emision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(CBX_doc_ref, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel47)
                        .addGap(6, 6, 6)
                        .addComponent(LBL_numero_doc)))
                .addGap(6, 6, 6))
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

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/f5.png"))); // NOI18N
        jLabel32.setText(" ");
        jLabel32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TXT_razon_social.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_razon_social.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_razon_social.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_razon_social.setEnabled(false);

        CBX_tipo_documento_id.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_tipo_documento_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "DNI" }));
        CBX_tipo_documento_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_tipo_documento_id.setEnabled(false);

        TXT_doc_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        try {
            TXT_doc_id.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_doc_id.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_doc_id.setEnabled(false);
        TXT_doc_id.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_doc_id.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        TXT_codigo_ubigeo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
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
        TXT_descripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_descripcion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_descripcion.setEnabled(false);

        JRD_domiciliado.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JRD_domiciliado.setText("Domiciliado");
        JRD_domiciliado.setEnabled(false);

        CBX_direccion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_direccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_direccion.setEnabled(false);

        jLabel49.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel49.setText("Sector :");

        CBX_sector.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_sector.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_sector.setEnabled(false);

        TXT_codigo_entidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        try {
            TXT_codigo_entidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("A#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_codigo_entidad.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_codigo_entidad.setEnabled(false);
        TXT_codigo_entidad.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_codigo_entidad.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel46.setText("Observacion");

        jLabel48.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel48.setText(":");

        TXT_observacion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_observacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_observacion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_observacion.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel31))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel30))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel29))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel28)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TXT_codigo_ubigeo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel33)
                                .addGap(4, 4, 4)
                                .addComponent(TXT_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(CBX_sector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(TXT_codigo_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel32))
                                    .addComponent(CBX_tipo_documento_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(TXT_doc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JRD_domiciliado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(75, 75, 75))
                                    .addComponent(TXT_razon_social)))
                            .addComponent(CBX_direccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel48)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_observacion, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_razon_social, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_codigo_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel30)
                    .addComponent(CBX_tipo_documento_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_doc_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JRD_domiciliado))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel29)
                    .addComponent(CBX_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(TXT_codigo_ubigeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(CBX_sector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel48)
                    .addComponent(TXT_observacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRODUCTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 154, 154))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel7.setText("C. Articulo");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel10.setText(":");

        TXT_codigo_articulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        try {
            TXT_codigo_articulo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-######U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXT_codigo_articulo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_codigo_articulo.setEnabled(false);
        TXT_codigo_articulo.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_codigo_articulo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/f5.png"))); // NOI18N
        jLabel34.setText(" ");
        jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TXT_nombre.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_nombre.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_nombre.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel11.setText("Tipo Venta");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel12.setText(":");

        CBX_presentacion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_presentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRESENTACION", "UNIDAD" }));
        CBX_presentacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_presentacion.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel16.setText("Cantidad");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel17.setText(":");

        TXT_cantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_cantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00",simbolos))));
        TXT_cantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TXT_cantidad.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_cantidad.setEnabled(false);
        TXT_cantidad.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_cantidad.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel18.setText("Precio");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel19.setText(":");

        TXT_precio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_precio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00000",simbolos))));
        TXT_precio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TXT_precio.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_precio.setEnabled(false);
        TXT_precio.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_precio.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        BTN_agregar.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        BTN_agregar.setText("+");
        BTN_agregar.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_codigo_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel34)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel17)
                                .addGap(4, 4, 4)
                                .addComponent(TXT_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel12)
                                .addGap(4, 4, 4)
                                .addComponent(CBX_presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel19)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(BTN_agregar)))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(TXT_codigo_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(CBX_presentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(TXT_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(TXT_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTN_agregar)
                        .addComponent(jLabel19)))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(401, 401, 401))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_agregar;
    public javax.swing.JComboBox<String> CBX_direccion;
    public javax.swing.JComboBox<String> CBX_doc_ref;
    public javax.swing.JComboBox<String> CBX_presentacion;
    public javax.swing.JComboBox<String> CBX_sector;
    public javax.swing.JComboBox<String> CBX_tipo_documento_id;
    public javax.swing.JRadioButton JRD_domiciliado;
    public javax.swing.JLabel LBL_numero_doc;
    public javax.swing.JFormattedTextField TXT_cantidad;
    public javax.swing.JFormattedTextField TXT_codigo_articulo;
    public javax.swing.JFormattedTextField TXT_codigo_entidad;
    public javax.swing.JFormattedTextField TXT_codigo_ubigeo;
    public javax.swing.JTextField TXT_descripcion;
    public javax.swing.JFormattedTextField TXT_doc_id;
    public javax.swing.JFormattedTextField TXT_fecha_emision;
    public javax.swing.JTextField TXT_nombre;
    public javax.swing.JFormattedTextField TXT_numero_doc;
    public javax.swing.JTextField TXT_observacion;
    public javax.swing.JFormattedTextField TXT_precio;
    public javax.swing.JTextField TXT_razon_social;
    public javax.swing.JFormattedTextField TXT_serie;
    public javax.swing.JTextField TXT_sucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
