package JAVA.ANCESTRO.LOGICA;

import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.CONFIG.LOGICA.cbx_rol;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class cbx_trato_datos {

    DefaultComboBoxModel lo_model;
    cbx_moneda lo_cbx_moneda;
    cbx_rol lo_cbx_rol;
    cbx_sucursal lo_cbx_sucursal;

    /*VALORES OPERACION
    0 = cbx_moneda
    1 = cbx_rol
    2 = cbx_sucursal
     */
    public void recupera_valor(int op, ResultSet rs, JComboBox cbx_combo) {
        switch (op) {
            case 0:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_moneda(rs.getString(1), rs.getString(2), rs.getString(3)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 1:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_rol(rs.getInt(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 2:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_sucursal(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
        }
    }

    public void selecciona_valor(int op, String dato, JComboBox cbx_combo) {
        String codigo;
        switch (op) {
            case 0:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_moneda = (cbx_moneda) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_moneda.getID();
                    if (codigo.equalsIgnoreCase(dato)) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 1:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_rol = (cbx_rol) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_rol.getID() + "";
                    if (codigo.equalsIgnoreCase(dato)) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 2:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_sucursal = (cbx_sucursal) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_sucursal.getID();
                    if (codigo.equalsIgnoreCase(dato)) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
        }

    }

}
