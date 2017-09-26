package JAVA.ANCESTRO.LOGICA;

import JAVA.CONFIG.LOGICA.cbx_almacen;
import JAVA.CONFIG.LOGICA.cbx_sucursal;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.CONFIG.LOGICA.cbx_pais;
import JAVA.CONFIG.LOGICA.cbx_rol;
import JAVA.CONFIG.LOGICA.cbx_tabla_sunat;
import JAVA.CONFIG.LOGICA.cbx_tipo_documento;
import JAVA.CONFIG.LOGICA.cbx_unidad_medida;
import JAVA.CONFIG.LOGICA.cbx_vendedor;
import JAVA.CTACOB.LOGICA.cbx_banco;
import JAVA.INVENT.LOGICA.cbx_entidad_ubigeo;
import JAVA.INVENT.LOGICA.cbx_familia;
import JAVA.INVENT.LOGICA.cbx_grupo_detraccion;
import JAVA.INVENT.LOGICA.cbx_grupo_percepcion;
import JAVA.INVENT.LOGICA.cbx_marca;
import JAVA.INVENT.LOGICA.cbx_producto;
import JAVA.INVENT.LOGICA.cbx_subfamilia;
import JAVA.VENTAS.LOGICA.cbx_igv;
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
    cbx_producto lo_cbx_producto;
    cbx_marca lo_cbx_marca;
    cbx_unidad_medida lo_cbx_unidad_medida;
    cbx_subfamilia lo_cbx_subfamilia;
    cbx_grupo_detraccion lo_cbx_grupo_detraccion;
    cbx_grupo_percepcion lo_cbx_grupo_percepcion;
    cbx_tipo_documento lo_cbx_tipo_documento;
    cbx_pais lo_cbx_pais;
    cbx_vendedor lo_cbx_vendedor;
    cbx_igv lo_cbx_igv;
    cbx_entidad_ubigeo lo_cbx_entidad_ubigeo;
    cbx_banco lo_cbx_banco;

    /*VALORES OPERACION
    0 = cbx_moneda
    1 = cbx_rol
    2 = cbx_sucursal
    3 = cx_almacen
    4 = cbx_tabla_sunat
    5 = cbx_familia
    6 = cbx_producto
    7 = cbx_marca
    8 = cbx_unidad_medida
    9 = cbx_subfamilia
    10 = cbx_grupo_detraccion
    11 = cbx_grupo_percepcion
    12 = cbx_tipo_documento
    13 = cbx_pais
    14 = cbx_vendedor
    15 = cbx_igv
    16 = cbx_entidad_ubigeo
    17 = cbx_banco
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
            case 6:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_producto(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 7:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_marca(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 8:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_unidad_medida(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 9:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_subfamilia(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 10:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_grupo_detraccion(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 11:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_grupo_percepcion(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 12:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_tipo_documento(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 13:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_pais(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 14:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_vendedor(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 15:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_igv(rs.getString(1), rs.getString(2)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 16:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_entidad_ubigeo(rs.getString(9), rs.getString(10), rs.getString(11)));
                    } while (rs.next());
                    cbx_combo.setModel(lo_model);
                } catch (Exception e) {
                }
                break;
            case 17:
                try {
                    lo_model = new DefaultComboBoxModel();
                    do {
                        lo_model.addElement(new cbx_banco(rs.getString(1), rs.getString(2)));
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
            case 6:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_producto = (cbx_producto) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_producto.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 7:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_marca = (cbx_marca) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_marca.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 8:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_unidad_medida = (cbx_unidad_medida) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_unidad_medida.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 9:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_subfamilia = (cbx_subfamilia) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_subfamilia.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 10:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_grupo_detraccion = (cbx_grupo_detraccion) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_grupo_detraccion.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 11:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_grupo_percepcion = (cbx_grupo_percepcion) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_grupo_percepcion.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 12:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_tipo_documento = (cbx_tipo_documento) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_tipo_documento.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 13:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_pais = (cbx_pais) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_pais.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 14:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_vendedor = (cbx_vendedor) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_vendedor.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 15:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_igv = (cbx_igv) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_igv.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 16:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_entidad_ubigeo = (cbx_entidad_ubigeo) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_entidad_ubigeo.getID();
                    if (codigo.equalsIgnoreCase(dato)) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
            case 17:
                for (int i = 0; i < cbx_combo.getModel().getSize(); i++) {
                    lo_cbx_banco = (cbx_banco) cbx_combo.getItemAt(i);
                    codigo = lo_cbx_banco.getID();
                    if (codigo.equalsIgnoreCase(dato.trim())) {
                        cbx_combo.setSelectedIndex(i);
                    }
                }
                break;
        }
    }
}
