package JAVA.ANCESTRO.LOGICA;

import JAVA.CONFIG.LOGICA.cbx_almacen;
import JAVA.CONFIG.LOGICA.cbx_sucursal;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.CONFIG.LOGICA.cbx_rol;
import JAVA.CONFIG.LOGICA.cbx_tabla_sunat;
import JAVA.INVENT.LOGICA.cbx_familia;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class cbx_trato_datos {

    DefaultComboBoxModel lo_model;
    cbx_moneda lo_cbx_moneda;
    cbx_rol lo_cbx_rol;
    cbx_sucursal lo_cbx_sucursal;
    cbx_almacen lo_cbx_almacen;
    cbx_tabla_sunat lo_cbx_tabla_sunat;
    cbx_familia lo_cbx_familia;

    /*VALORES OPERACION
    0 = cbx_moneda
    1 = cbx_rol
    2 = cbx_sucursal
    3 = cx_almacen
    4 = cbx_tabla_sunat
    5 = cbx_subfamilia
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
            case 3:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_almacen(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 4:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_tabla_sunat(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 5:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_familia(rs.getString(1), rs.getString(2)));
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
            case 3:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_almacen = (cbx_almacen) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_almacen.getID();
                    if (codigo.equalsIgnoreCase(dato)) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 4:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_tabla_sunat = (cbx_tabla_sunat) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_tabla_sunat.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 5:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_familia = (cbx_familia) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_familia.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
        }
    }
}
