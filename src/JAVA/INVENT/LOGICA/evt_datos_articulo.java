package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.LOGICA.cbx_tabla_sunat;
import JAVA.CONFIG.LOGICA.cbx_unidad_medida;
import JAVA.INVENT.BEAN.BEAN_articulo;
import JAVA.INVENT.GUI.pnl_datos_articulo;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_articulo {

    String ls_modulo = "INVENT", ls_capa = "LOGICA", ls_clase = "evt_datos_articulo";

    public void activa_campos(int op, pnl_datos_articulo OBJ_pda, boolean valor) {
        switch (op) {
            case 0:
                //OBJ_pda.TXT_codigo.setEnabled(valor);
                //OBJ_pda.TXT_nombre.setEnabled(valor);
                OBJ_pda.TXT_serie.setEnabled(valor);
                OBJ_pda.CBX_producto.setEnabled(valor);
                OBJ_pda.CBX_marca.setEnabled(valor);
                OBJ_pda.TXT_caracteristica.setEnabled(valor);
                OBJ_pda.CBX_unidad_medida.setEnabled(valor);
                OBJ_pda.CBX_um_bulto.setEnabled(valor);
                OBJ_pda.TXT_tara.setEnabled(valor);
                OBJ_pda.CBX_estado.setEnabled(valor);
                OBJ_pda.CBX_afecto.setEnabled(valor);
                OBJ_pda.CBX_existencia.setEnabled(valor);
                //OBJ_pda.CBX_detraccion.setEnabled(valor);
                //OBJ_pda.CBX_percepcion.setEnabled(valor);
                OBJ_pda.CBX_operacion.setEnabled(valor);
                OBJ_pda.TXT_codigo_barra.setEnabled(valor);
                OBJ_pda.CBX_familia.setEnabled(valor);
                OBJ_pda.CBX_subfamilia.setEnabled(valor);
                OBJ_pda.TXT_observacion.setEnabled(valor);

                OBJ_pda.TXT_serie.requestFocus();
                break;
            case 1:
                OBJ_pda.TXT_caracteristica.setEnabled(valor);
                OBJ_pda.CBX_unidad_medida.setEnabled(valor);

                if ((OBJ_pda.CBX_um_bulto.getSelectedItem() + "").equalsIgnoreCase("CAJA")) {
                    OBJ_pda.TXT_tara.setEnabled(valor);
                }
                if (OBJ_pda.CBX_detraccion.getSelectedIndex() != 0) {
                    OBJ_pda.CBX_detraccion.setEnabled(valor);
                }
                if (OBJ_pda.CBX_percepcion.getSelectedIndex() != 0) {
                    OBJ_pda.CBX_percepcion.setEnabled(valor);
                }

                OBJ_pda.CBX_afecto.setEnabled(valor);
                OBJ_pda.CBX_existencia.setEnabled(valor);
                OBJ_pda.CBX_estado.setEnabled(valor);
                OBJ_pda.CBX_operacion.setEnabled(valor);
                OBJ_pda.TXT_codigo_barra.setEnabled(valor);
                OBJ_pda.CBX_familia.setEnabled(valor);
                OBJ_pda.CBX_subfamilia.setEnabled(valor);
                OBJ_pda.TXT_observacion.setEnabled(valor);
                OBJ_pda.TXT_caracteristica.requestFocus();
                break;
            case 2:
                OBJ_pda.CBX_afecto.setEnabled(valor);
                OBJ_pda.CBX_existencia.setEnabled(valor);
                OBJ_pda.CBX_operacion.setEnabled(valor);
                OBJ_pda.TXT_codigo_barra.setEnabled(valor);
                OBJ_pda.CBX_familia.setEnabled(valor);
                OBJ_pda.CBX_subfamilia.setEnabled(valor);
                OBJ_pda.TXT_observacion.setEnabled(valor);
                OBJ_pda.TXT_caracteristica.requestFocus();
                OBJ_pda.CBX_afecto.requestFocus();
        }
    }

    public void limpia_datos(pnl_datos_articulo OBJ_pda) {
        OBJ_pda.TXT_serie.setText("");
        OBJ_pda.TXT_codigo.setText("");
        OBJ_pda.TXT_nombre.setText("");
        OBJ_pda.CBX_producto.setSelectedIndex(0);
        OBJ_pda.CBX_marca.setSelectedIndex(0);
        OBJ_pda.TXT_caracteristica.setText("");
        OBJ_pda.CBX_unidad_medida.setSelectedIndex(0);
        OBJ_pda.CBX_um_bulto.setSelectedIndex(1);
        OBJ_pda.TXT_tara.setText("");
        OBJ_pda.CBX_estado.setSelectedIndex(1);
        OBJ_pda.CBX_afecto.setSelectedIndex(1);
        OBJ_pda.CBX_existencia.setSelectedIndex(0);
        OBJ_pda.CBX_detraccion.setSelectedIndex(0);
        OBJ_pda.CBX_percepcion.setSelectedIndex(0);
        OBJ_pda.CBX_operacion.setSelectedIndex(0);
        OBJ_pda.TXT_codigo_barra.setText("");
        OBJ_pda.CBX_familia.setSelectedIndex(0);

        OBJ_pda.CBX_subfamilia.removeAllItems();
        ResultSet lq_rs = go_dao_subfamilia.SLT_cbx_subfamilia_x_familia("0001");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(9, lq_rs, OBJ_pda.CBX_subfamilia);
        }

        OBJ_pda.CBX_subfamilia.setSelectedIndex(0);
        OBJ_pda.TXT_observacion.setText("");
    }

    public void muestra_datos(pnl_datos_articulo OBJ_pda, BEAN_articulo OBJ_bar) {        
        OBJ_pda.TXT_codigo.setText(OBJ_bar.getCodigo_articulo());
        OBJ_pda.TXT_nombre.setText(OBJ_bar.getNombre_articulo());
        go_cbx_trato_datos.selecciona_valor(6, OBJ_bar.getCodigo_producto(), OBJ_pda.CBX_producto);
        go_cbx_trato_datos.selecciona_valor(7, OBJ_bar.getCodigo_marca(), OBJ_pda.CBX_marca);
        OBJ_pda.TXT_caracteristica.setText(OBJ_bar.getCaracteristica());
        go_cbx_trato_datos.selecciona_valor(8, OBJ_bar.getCodigo_unidad(), OBJ_pda.CBX_unidad_medida);
        go_cbx_trato_datos.selecciona_valor(8, OBJ_bar.getBulto_um(), OBJ_pda.CBX_um_bulto);
        OBJ_pda.TXT_tara.setText(OBJ_bar.getTara() + "");
        OBJ_pda.CBX_estado.setSelectedIndex(Integer.parseInt(OBJ_bar.getStatus()));
        OBJ_pda.CBX_afecto.setSelectedIndex(Integer.parseInt(OBJ_bar.getAfecto_igv()));
        go_cbx_trato_datos.selecciona_valor(4, OBJ_bar.getCodigo_sunat(), OBJ_pda.CBX_existencia);
        go_cbx_trato_datos.selecciona_valor(10, OBJ_bar.getCodigo_detraccion(), OBJ_pda.CBX_detraccion);
        go_cbx_trato_datos.selecciona_valor(11, OBJ_bar.getCodigo_percepcion(), OBJ_pda.CBX_percepcion);
        OBJ_pda.CBX_operacion.setSelectedIndex(Integer.parseInt(OBJ_bar.getTipo_operacion()));
        OBJ_pda.TXT_codigo_barra.setText(OBJ_bar.getCodigo_barra());
        go_cbx_trato_datos.selecciona_valor(5, OBJ_bar.getCodigo_familia(), OBJ_pda.CBX_familia);

        OBJ_pda.CBX_subfamilia.removeAllItems();
        ResultSet lq_rs = go_dao_subfamilia.SLT_cbx_subfamilia_x_familia(OBJ_bar.getCodigo_familia());
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(9, lq_rs, OBJ_pda.CBX_subfamilia);
        }

        go_cbx_trato_datos.selecciona_valor(9, OBJ_bar.getCodigo_subfamilia(), OBJ_pda.CBX_subfamilia);
        OBJ_pda.TXT_observacion.setText(OBJ_bar.getObservacion());
        OBJ_pda.TXT_serie.setText(OBJ_bar.getSerie());
    }

    public void setea_recupera(BEAN_articulo OBJ_bar, ResultSet lq_rs) {
        try {            
            OBJ_bar.setCodigo_articulo(lq_rs.getString(1));
            OBJ_bar.setNombre_articulo(lq_rs.getString(2));
            OBJ_bar.setCodigo_producto(lq_rs.getString(3));
            OBJ_bar.setCodigo_marca(lq_rs.getString(4));
            OBJ_bar.setClase_producto(lq_rs.getString(5));
            OBJ_bar.setCaracteristica(lq_rs.getString(6));
            OBJ_bar.setCodigo_unidad(lq_rs.getString(7));
            OBJ_bar.setBulto_um(lq_rs.getString(8));
            OBJ_bar.setTara(lq_rs.getDouble(9));
            OBJ_bar.setStatus(lq_rs.getString(10));
            OBJ_bar.setAfecto_igv(lq_rs.getString(11));
            OBJ_bar.setCodigo_sunat(lq_rs.getString(12));
            OBJ_bar.setAfecto_detraccion(lq_rs.getString(13));
            OBJ_bar.setCodigo_detraccion(lq_rs.getString(14));
            OBJ_bar.setAfecto_percepcion(lq_rs.getString(15));
            OBJ_bar.setCodigo_percepcion(lq_rs.getString(16));
            OBJ_bar.setTipo_operacion(lq_rs.getString(17));
            OBJ_bar.setCodigo_barra(lq_rs.getString(18));
            OBJ_bar.setCodigo_familia(lq_rs.getString(19));
            OBJ_bar.setCodigo_subfamilia(lq_rs.getString(20));
            OBJ_bar.setObservacion(lq_rs.getString(21));
            OBJ_bar.setSerie(lq_rs.getString(22));
        } catch (Exception e) {
        }
    }

    public boolean valida_campos(pnl_datos_articulo OBJ_pda, String afecto_detraccion, String afecto_percepcion) {
        boolean resp = false;
        if (afecto_detraccion.equalsIgnoreCase("1")) {
            if (OBJ_pda.CBX_detraccion.getSelectedIndex() != 0) {
                if (afecto_percepcion.equalsIgnoreCase("1")) {
                    if (OBJ_pda.CBX_percepcion.getSelectedIndex() != 0) {
                        resp = true;
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE PERCEPCION");
                        OBJ_pda.CBX_percepcion.requestFocus();
                    }
                } else {
                    resp = true;
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE DETRACCION");
                OBJ_pda.CBX_detraccion.requestFocus();
            }
        } else {
            if (afecto_percepcion.equalsIgnoreCase("1")) {
                if (OBJ_pda.CBX_percepcion.getSelectedIndex() != 0) {
                    resp = true;
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE PERCEPCION");
                    OBJ_pda.CBX_percepcion.requestFocus();
                }
            } else {
                resp = true;
            }
        }
        if (!go_fnc_operaciones_campos.campo_blanco(OBJ_pda.TXT_tara)) {
            OBJ_pda.TXT_tara.setText("0.0");
        }
        return resp;
    }

    public void setea_campos(BEAN_articulo OBJ_bar, pnl_datos_articulo OBJ_pda, cbx_familia cbx_familia, cbx_marca cbx_marca, cbx_producto cbx_producto, cbx_unidad_medida cbx_unidad, cbx_unidad_medida cbx_um_bulto, cbx_tabla_sunat cbx_existencia, cbx_grupo_detraccion cbx_grupo_detraccion, cbx_grupo_percepcion cbx_grupo_percepcion, cbx_subfamilia cbx_subfamilia) {
        try {            
            OBJ_bar.setCodigo_articulo(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_codigo));
            OBJ_bar.setNombre_articulo(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_nombre));
            OBJ_bar.setCodigo_producto(cbx_producto.getID());
            OBJ_bar.setCodigo_marca(cbx_marca.getID());
            OBJ_bar.setCaracteristica(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_caracteristica));
            OBJ_bar.setCodigo_unidad(cbx_unidad.getID());
            OBJ_bar.setBulto_um(cbx_um_bulto.getID());
            OBJ_bar.setTara(Double.parseDouble(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_tara)));
            OBJ_bar.setStatus(OBJ_pda.CBX_estado.getSelectedIndex() + "");
            OBJ_bar.setAfecto_igv(OBJ_pda.CBX_afecto.getSelectedIndex() + "");
            OBJ_bar.setCodigo_sunat(cbx_existencia.getID());
            OBJ_bar.setCodigo_detraccion(cbx_grupo_detraccion.getID());
            OBJ_bar.setCodigo_percepcion(cbx_grupo_percepcion.getID());
            OBJ_bar.setTipo_operacion(OBJ_pda.CBX_operacion.getSelectedIndex() + "");
            OBJ_bar.setCodigo_barra(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_codigo_barra));
            OBJ_bar.setCodigo_familia(cbx_familia.getID());
            OBJ_bar.setCodigo_subfamilia(cbx_subfamilia.getID());
            OBJ_bar.setObservacion(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_observacion));
            OBJ_bar.setSerie(go_fnc_operaciones_campos.get_campo_str(OBJ_pda.TXT_serie));
        } catch (Exception e) {
        }
    }

    public boolean verifica_cambios(BEAN_articulo OBJ_bar, pnl_datos_articulo OBJ_pda, cbx_unidad_medida cbx_unidad, cbx_tabla_sunat cbx_existencia, cbx_grupo_detraccion cbx_grupo_detraccion, cbx_grupo_percepcion cbx_grupo_percepcion, cbx_familia cbx_familia, cbx_subfamilia cbx_subfamilia) {
        boolean resp = false;
        if (OBJ_bar.getCaracteristica().equalsIgnoreCase(OBJ_pda.TXT_caracteristica.getText().trim())) {
            if (OBJ_bar.getCodigo_unidad().equalsIgnoreCase(cbx_unidad.getID())) {
                if (OBJ_bar.getTara() == Double.parseDouble(OBJ_pda.TXT_tara.getText().trim())) {
                    if (OBJ_bar.getStatus().equalsIgnoreCase(OBJ_pda.CBX_estado.getSelectedIndex() + "")) {
                        if (OBJ_bar.getAfecto_igv().equalsIgnoreCase(OBJ_pda.CBX_afecto.getSelectedIndex() + "")) {
                            if (OBJ_bar.getCodigo_sunat().equalsIgnoreCase(cbx_existencia.getID())) {
                                if (OBJ_bar.getCodigo_detraccion().equalsIgnoreCase(cbx_grupo_detraccion.getID())) {
                                    if (OBJ_bar.getCodigo_percepcion().equalsIgnoreCase(cbx_grupo_percepcion.getID())) {
                                        if (OBJ_bar.getTipo_operacion().equalsIgnoreCase(OBJ_pda.CBX_operacion.getSelectedIndex() + "")) {
                                            if (OBJ_bar.getCodigo_barra().equalsIgnoreCase(OBJ_pda.TXT_codigo_barra.getText().trim())) {
                                                if (OBJ_bar.getCodigo_familia().equalsIgnoreCase(cbx_familia.getID())) {
                                                    if (OBJ_bar.getCodigo_subfamilia().equalsIgnoreCase(cbx_subfamilia.getID())) {
                                                        if (OBJ_bar.getObservacion().equalsIgnoreCase(OBJ_pda.TXT_observacion.getText().trim())) {
                                                        } else {
                                                            resp = true;
                                                        }
                                                    } else {
                                                        resp = true;
                                                    }
                                                } else {
                                                    resp = true;
                                                }
                                            } else {
                                                resp = true;
                                            }
                                        } else {
                                            resp = true;
                                        }
                                    } else {
                                        resp = true;
                                    }
                                } else {
                                    resp = true;
                                }
                            } else {
                                resp = true;
                            }
                        } else {
                            resp = true;
                        }
                    } else {
                        resp = true;
                    }
                } else {
                    resp = true;
                }
            } else {
                resp = true;
            }
        } else {
            resp = true;
        }
        return resp;
    }

    public KeyListener evento_press(pnl_datos_articulo OBJ_pda, KeyListener KeyEvnt) {
        OBJ_pda.TXT_codigo.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_serie.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_nombre.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_producto.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_marca.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_caracteristica.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_unidad_medida.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_um_bulto.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_tara.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_estado.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_afecto.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_existencia.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_detraccion.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_percepcion.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_operacion.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_codigo_barra.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_familia.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_subfamilia.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_observacion.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_datos_articulo obj_pda, ItemListener ItemEvent) {
        obj_pda.CBX_producto.addItemListener(ItemEvent);
        obj_pda.CBX_marca.addItemListener(ItemEvent);
        obj_pda.CBX_unidad_medida.addItemListener(ItemEvent);
        obj_pda.CBX_um_bulto.addItemListener(ItemEvent);
        obj_pda.CBX_familia.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
