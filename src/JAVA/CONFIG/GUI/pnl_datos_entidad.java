package JAVA.CONFIG.GUI;

import JAVA.ANCESTRO.LOGICA.evt_focus_component;
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
        
        TXT_codigo_ubigeo.addFocusListener(new evt_focus_component());
        TXT_dias_cr.addFocusListener(new evt_focus_component());
        TXT_direccion.addFocusListener(new evt_focus_component());
        TXT_limite_cr.addFocusListener(new evt_focus_component());
        TXT_nombre.addFocusListener(new evt_focus_component());
        TXT_nombre_comercial.addFocusListener(new evt_focus_component());
        TXT_numero_doc_id.addFocusListener(new evt_focus_component());
        TXT_observacion.addFocusListener(new evt_focus_component());
        TXT_papellido.addFocusListener(new evt_focus_component());
        TXT_razon_social.addFocusListener(new evt_focus_component());
        TXT_sapellido.addFocusListener(new evt_focus_component());
        CBX_estado.addFocusListener(new evt_focus_component());
        CBX_forma_pago.addFocusListener(new evt_focus_component());
        CBX_sector.addFocusListener(new evt_focus_component());
        CBX_pais.addFocusListener(new evt_focus_component());
        CBX_sucursal.addFocusListener(new evt_focus_component());
        CBX_tipo_comercio.addFocusListener(new evt_focus_component());
        CBX_tipo_documento_id.addFocusListener(new evt_focus_component());
        CBX_tipo_persona.addFocusListener(new evt_focus_component());
        CBX_vendedor.addFocusListener(new evt_focus_component());
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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel1.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setText(":");

        TXT_codigo_entidad.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_codigo_entidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_codigo_entidad.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_codigo_entidad.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("Tipo Persona");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel4.setText(":");

        CBX_tipo_persona.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_tipo_persona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NATURAL", "JURIDICA" }));
        CBX_tipo_persona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_tipo_persona.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel7.setText("1° Apellido");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel8.setText(":");

        TXT_papellido.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_papellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_papellido.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_papellido.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel9.setText("2° Apellido");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel10.setText(":");

        TXT_sapellido.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_sapellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_sapellido.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_sapellido.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText("Nombre(s)");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel6.setText(":");

        TXT_nombre.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_nombre.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_nombre.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel11.setText("Estado");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel12.setText(":");

        CBX_estado.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BLOQUEADO", "ACTIVO" }));
        CBX_estado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_estado.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel14.setText(":");

        TXT_razon_social.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_razon_social.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_razon_social.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_razon_social.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel15.setText("N. Comercial");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel16.setText(":");

        TXT_nombre_comercial.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_nombre_comercial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_nombre_comercial.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_nombre_comercial.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel17.setText("Tipo Doc.");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel18.setText(":");

        CBX_tipo_documento_id.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_tipo_documento_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_tipo_documento_id.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel19.setText("N° Documento");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel20.setText(":");

        TXT_numero_doc_id.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_numero_doc_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_numero_doc_id.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_numero_doc_id.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel44.setText("Razon Social");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_codigo_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel12)
                        .addGap(4, 4, 4)
                        .addComponent(CBX_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(CBX_tipo_persona, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18)
                        .addGap(4, 4, 4)
                        .addComponent(CBX_tipo_documento_id, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel20)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_numero_doc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel8)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_papellido, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_sapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel14)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_razon_social, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel16)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_nombre_comercial, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(CBX_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TXT_codigo_entidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(CBX_tipo_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18)
                        .addComponent(CBX_tipo_documento_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXT_numero_doc_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXT_papellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_sapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXT_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXT_razon_social, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel14))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXT_nombre_comercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(6, 6, 6))
        );

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

        jLabel21.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel21.setText("Pais");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel22.setText(":");

        CBX_pais.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_pais.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_pais.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel23.setText("Direccion");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel24.setText(":");

        TXT_direccion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_direccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_direccion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_direccion.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel25.setText("Ubigeo");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel26.setText(":");

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

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/f5.png"))); // NOI18N
        jLabel27.setText(" ");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TXT_descripcion_ubigeo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_descripcion_ubigeo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_descripcion_ubigeo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_descripcion_ubigeo.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel22)
                        .addGap(4, 4, 4)
                        .addComponent(CBX_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel24)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel26)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_codigo_ubigeo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel27)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_descripcion_ubigeo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(CBX_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXT_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXT_codigo_ubigeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_descripcion_ubigeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS COMERCIALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel28.setText("Forma Pago");

        jLabel29.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel29.setText(":");

        CBX_forma_pago.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_forma_pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "CREDITO" }));
        CBX_forma_pago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_forma_pago.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel30.setText("Dias");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel31.setText(":");

        TXT_dias_cr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_dias_cr.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        TXT_dias_cr.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_dias_cr.setEnabled(false);
        TXT_dias_cr.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_dias_cr.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel32.setText("Limite");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel33.setText(":");

        TXT_limite_cr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_limite_cr.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00",simbolos))));
        TXT_limite_cr.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_limite_cr.setEnabled(false);
        TXT_limite_cr.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        TXT_limite_cr.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel34.setText("Sucursal");

        jLabel35.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel35.setText(":");

        CBX_sucursal.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_sucursal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_sucursal.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel36.setText("Tipo Comercio");

        jLabel37.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel37.setText(":");

        CBX_tipo_comercio.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_tipo_comercio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_tipo_comercio.setEnabled(false);

        jLabel38.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel38.setText("Vendedor");

        jLabel39.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel39.setText(":");

        CBX_vendedor.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_vendedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_vendedor.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel40.setText("Observacion");

        jLabel41.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel41.setText(":");

        TXT_observacion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TXT_observacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        TXT_observacion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        TXT_observacion.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel42.setText("Sector");

        jLabel43.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel43.setText(":");

        CBX_sector.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        CBX_sector.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CBX_sector.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel29)
                        .addGap(4, 4, 4)
                        .addComponent(CBX_forma_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel31)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_dias_cr, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel32)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_limite_cr, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel35)
                        .addGap(4, 4, 4)
                        .addComponent(CBX_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel37)
                        .addGap(4, 4, 4)
                        .addComponent(CBX_tipo_comercio, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel39)
                        .addGap(4, 4, 4)
                        .addComponent(CBX_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel43)
                        .addGap(4, 4, 4)
                        .addComponent(CBX_sector, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel41)
                        .addGap(4, 4, 4)
                        .addComponent(TXT_observacion, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBX_forma_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_dias_cr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_limite_cr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBX_sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBX_tipo_comercio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBX_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBX_sector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXT_observacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41))
                .addGap(12, 12, 12))
        );

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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(197, 197, Short.MAX_VALUE))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
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
