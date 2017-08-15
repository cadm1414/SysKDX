package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_entidad;
import JAVA.CONFIG.GUI.pnl_datos_entidad;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_entidad {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_almacen";

    public void activa_campos(int op, pnl_datos_entidad OBJ_pde, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pde.JRD_es_cliente.setEnabled(valor);
                OBJ_pde.JRD_es_proveedor.setEnabled(valor);
                OBJ_pde.JRD_es_trabajador.setEnabled(valor);
                OBJ_pde.JRD_nacional.setEnabled(valor);
                OBJ_pde.JRD_extranjero.setEnabled(valor);
                OBJ_pde.CBX_estado.setEnabled(valor);
                OBJ_pde.CBX_tipo_persona.setEnabled(valor);
                OBJ_pde.CBX_tipo_documento_id.setEnabled(valor);
                OBJ_pde.TXT_numero_doc_id.setEnabled(valor);
                OBJ_pde.TXT_papellido.setEnabled(valor);
                OBJ_pde.TXT_sapellido.setEnabled(valor);
                OBJ_pde.TXT_nombre.setEnabled(valor);
                OBJ_pde.TXT_nombre_comercial.setEnabled(valor);
                OBJ_pde.TXT_direccion.setEnabled(valor);
                OBJ_pde.TXT_codigo_ubigeo.setEnabled(valor);
                OBJ_pde.CBX_forma_pago.setEnabled(valor);
                OBJ_pde.CBX_sucursal.setEnabled(valor);
                OBJ_pde.CBX_vendedor.setEnabled(valor);
                OBJ_pde.TXT_observacion.setEnabled(valor);
                OBJ_pde.JRD_agente_percepcion.setEnabled(valor);
                OBJ_pde.JRD_agente_retencion.setEnabled(valor);
                OBJ_pde.JRD_entidad_excluida.setEnabled(valor);
                OBJ_pde.JRD_es_domiciliado.setEnabled(valor);
                OBJ_pde.CBX_tipo_comercio.setEnabled(valor);
                OBJ_pde.TXT_dias_cr.setEnabled(false);
                OBJ_pde.TXT_limite_cr.setEnabled(false);
                OBJ_pde.TXT_razon_social.setEnabled(false);
                OBJ_pde.JRD_es_cliente.requestFocus();
                break;
            case 1:
                OBJ_pde.JRD_es_cliente.setEnabled(valor);
                OBJ_pde.TXT_numero_doc_id.setEnabled(valor);
                if (OBJ_pde.CBX_tipo_documento_id.getSelectedItem().toString().equalsIgnoreCase("DNI")) {
                    OBJ_pde.JRD_es_trabajador.setEnabled(valor);
                } else {
                    OBJ_pde.JRD_es_proveedor.setEnabled(valor);
                }
                OBJ_pde.CBX_estado.setEnabled(valor);
                if (OBJ_pde.CBX_tipo_persona.getSelectedIndex() == 0) {
                    OBJ_pde.TXT_papellido.setEnabled(valor);
                    OBJ_pde.TXT_sapellido.setEnabled(valor);
                    OBJ_pde.TXT_nombre.setEnabled(valor);
                } else {
                    OBJ_pde.TXT_razon_social.setEnabled(valor);
                }
                OBJ_pde.TXT_nombre_comercial.setEnabled(valor);
                OBJ_pde.CBX_forma_pago.setEnabled(valor);
                OBJ_pde.CBX_sucursal.setEnabled(valor);
                OBJ_pde.CBX_vendedor.setEnabled(valor);
                OBJ_pde.TXT_observacion.setEnabled(valor);
                OBJ_pde.JRD_agente_percepcion.setEnabled(valor);
                OBJ_pde.JRD_agente_retencion.setEnabled(valor);
                OBJ_pde.JRD_entidad_excluida.setEnabled(valor);
                OBJ_pde.JRD_es_domiciliado.setEnabled(valor);
                OBJ_pde.CBX_tipo_comercio.setEnabled(valor);
                OBJ_pde.JRD_es_cliente.requestFocus();
                if (OBJ_pde.CBX_forma_pago.getSelectedIndex() == 1) {
                    OBJ_pde.TXT_dias_cr.setEnabled(valor);
                    OBJ_pde.TXT_limite_cr.setEnabled(valor);
                }
                OBJ_pde.JRD_es_cliente.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_entidad OBJ_pde) {
        OBJ_pde.JRD_es_cliente.setSelected(true);
        OBJ_pde.JRD_es_proveedor.setSelected(false);
        OBJ_pde.JRD_es_trabajador.setSelected(false);
        OBJ_pde.JRD_nacional.setSelected(true);
        OBJ_pde.TXT_codigo_entidad.setText("");
        OBJ_pde.CBX_estado.setSelectedIndex(1);
        OBJ_pde.CBX_tipo_persona.setSelectedIndex(0);
        OBJ_pde.TXT_numero_doc_id.setText("");
        OBJ_pde.TXT_papellido.setText("");
        OBJ_pde.TXT_sapellido.setText("");
        OBJ_pde.TXT_nombre.setText("");
        OBJ_pde.TXT_razon_social.setText("");
        OBJ_pde.TXT_nombre_comercial.setText("");
        OBJ_pde.TXT_direccion.setText("");
        OBJ_pde.TXT_codigo_ubigeo.setText("");
        OBJ_pde.TXT_descripcion_ubigeo.setText("");
        OBJ_pde.CBX_pais.setSelectedIndex(0);
        OBJ_pde.CBX_forma_pago.setSelectedIndex(0);
        OBJ_pde.TXT_dias_cr.setText("0");
        OBJ_pde.TXT_limite_cr.setText(0.0 + "");
        OBJ_pde.CBX_sucursal.setSelectedIndex(1);
        OBJ_pde.TXT_observacion.setText("");
        OBJ_pde.JRD_agente_percepcion.setSelected(false);
        OBJ_pde.JRD_agente_retencion.setSelected(false);
        OBJ_pde.JRD_entidad_excluida.setSelected(false);
        OBJ_pde.JRD_es_domiciliado.setSelected(true);
        OBJ_pde.CBX_tipo_comercio.setSelectedIndex(0);
    }

    private boolean valida_numero_doc(String numero, int tipo_persona, String tipo_doc) {
        boolean resp = false;
        switch (tipo_persona) {
            case 0:
                if (tipo_doc.equalsIgnoreCase("6")) {
                    if (numero.length() == 11 && !numero.substring(0, 2).equalsIgnoreCase("20") && go_fnc_operaciones_campos.valida_ruc(numero)) {
                        resp = true;
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "NUMERO RUC INCORRECTO");
                    }
                } else if (tipo_doc.equalsIgnoreCase("1")) {
                    if (numero.length() == 8) {
                        resp = true;
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "NUMERO DNI INCORRECTO");
                    }
                } else if (numero.length() > 2) {
                    resp = true;
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NUMERO DE DOCUMENTO");
                }
                break;
            case 1:
                if (numero.length() == 11 && numero.substring(0, 2).equalsIgnoreCase("20") && go_fnc_operaciones_campos.valida_ruc(numero)) {
                    resp = true;
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "NUMERO RUC INCORRECTO");
                }
                break;
        }
        return resp;
    }

    public boolean valida_campos(pnl_datos_entidad OBJ_dpe, cbx_tabla_sunat cbx_tabla_sunat) {
        boolean resp = false;
        if (OBJ_dpe.JRD_es_cliente.isSelected() == true || OBJ_dpe.JRD_es_proveedor.isSelected() == true || OBJ_dpe.JRD_es_trabajador.isSelected() == true) {
            if (go_fnc_operaciones_campos.campo_blanco(OBJ_dpe.TXT_codigo_entidad)) {
                if (go_fnc_operaciones_campos.campo_blanco(OBJ_dpe.TXT_numero_doc_id)) {
                    if (valida_numero_doc(OBJ_dpe.TXT_numero_doc_id.getText().trim(), OBJ_dpe.CBX_tipo_persona.getSelectedIndex(), cbx_tabla_sunat.getID())) {
                        if (go_fnc_operaciones_campos.cant_caracter(OBJ_dpe.TXT_razon_social.getText().trim(), 1, 3)) {
                            if (go_fnc_operaciones_campos.cant_caracter(OBJ_dpe.TXT_direccion.getText().trim(), 1, 3)) {
                                if (go_fnc_operaciones_campos.cant_caracter(OBJ_dpe.TXT_codigo_ubigeo.getText().trim(), 4, 6)) {
                                    if (go_fnc_operaciones_campos.cant_caracter(OBJ_dpe.TXT_codigo_ubigeo.getText().trim(), 1, 6)) {
                                        if (go_fnc_operaciones_campos.campo_blanco(OBJ_dpe.TXT_dias_cr)) {
                                            if (go_fnc_operaciones_campos.campo_blanco(OBJ_dpe.TXT_limite_cr)) {
                                                resp = true;
                                            } else {
                                                OBJ_dpe.TXT_limite_cr.setText(0.0 + "");
                                            }
                                        } else {
                                            OBJ_dpe.TXT_dias_cr.setText("0");
                                        }
                                    } else {
                                        OBJ_dpe.TXT_codigo_ubigeo.requestFocus();
                                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE UBIGEO");
                                    }
                                } else {
                                    OBJ_dpe.TXT_codigo_ubigeo.requestFocus();
                                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE UBIGEO");
                                }
                            } else {
                                OBJ_dpe.TXT_direccion.requestFocus();
                                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE DIRECCION");
                            }
                        } else {
                            OBJ_dpe.TXT_numero_doc_id.requestFocus();
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE RAZON SOCIAL");
                        }
                    } else {
                        OBJ_dpe.TXT_numero_doc_id.requestFocus();
                    }
                } else {
                    OBJ_dpe.TXT_numero_doc_id.requestFocus();
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NUMERO DE DOCUMENTO");
                }
            } else {
                OBJ_dpe.JRD_es_cliente.requestFocus();
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "NO SE GENERO CODIGO ENTIDAD");
            }
        } else {
            OBJ_dpe.JRD_es_cliente.requestFocus();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE TIPO ENTIDAD");
        }
        return resp;
    }

    public boolean verifica_cambios(BEAN_entidad OBJ_bal, pnl_datos_entidad OBJ_dpe, cbx_sucursal cbx_sucursal, cbx_vendedor cbx_vendedor) {
        boolean resp = false;
        int forma_pago = 0;
        if (OBJ_bal.getForma_pago().equalsIgnoreCase("CR")) {
            forma_pago = 1;
        }
        if (OBJ_dpe.JRD_es_cliente.isSelected() == go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getEs_cliente()))) {
            if (OBJ_dpe.JRD_es_proveedor.isSelected() == go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getEs_proveedor()))) {
                if (OBJ_dpe.JRD_es_trabajador.isSelected() == go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getEs_trabajador()))) {
                    if (OBJ_dpe.CBX_estado.getSelectedIndex() == Integer.parseInt(OBJ_bal.getStatus())) {
                        if (OBJ_dpe.TXT_numero_doc_id.getText().trim().equalsIgnoreCase(OBJ_bal.getNumero_documento_id()) && OBJ_dpe.TXT_papellido.getText().trim().equalsIgnoreCase(OBJ_bal.getPrimer_apellido()) && OBJ_dpe.TXT_sapellido.getText().trim().equalsIgnoreCase(OBJ_bal.getSegundo_apellido()) && OBJ_dpe.TXT_nombre.getText().trim().equalsIgnoreCase(OBJ_bal.getNombres()) && OBJ_dpe.TXT_razon_social.getText().trim().equalsIgnoreCase(OBJ_bal.getRazon_social()) && OBJ_dpe.TXT_nombre_comercial.getText().trim().equalsIgnoreCase(OBJ_bal.getNombre_comercial()) && OBJ_dpe.TXT_observacion.getText().trim().equalsIgnoreCase(OBJ_bal.getObservacion())) {
                            if (OBJ_dpe.CBX_forma_pago.getSelectedIndex() == forma_pago) {
                                if (Integer.parseInt(OBJ_dpe.TXT_dias_cr.getText().trim()) == OBJ_bal.getDias_credito() && Double.parseDouble(OBJ_dpe.TXT_limite_cr.getText().trim().replaceAll(",", "")) == OBJ_bal.getLimite_credito()) {
                                    if (OBJ_dpe.CBX_tipo_comercio.getSelectedIndex() == Integer.parseInt(OBJ_bal.getTipo_comercio())) {
                                        if (cbx_sucursal.getID().equalsIgnoreCase(OBJ_bal.getCodigo_sucursal()) && cbx_vendedor.getID().equalsIgnoreCase(OBJ_bal.getCodigo_vendedor())) {
                                            if (OBJ_dpe.JRD_agente_percepcion.isSelected() == go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getAgente_percepcion())) && OBJ_dpe.JRD_agente_retencion.isSelected() == go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getAgente_retencion())) && OBJ_dpe.JRD_entidad_excluida.isSelected() == go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getEntidad_excluida())) && OBJ_dpe.JRD_es_domiciliado.isSelected() == go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getEs_domiciliado()))) {
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

    public void muestra_datos(pnl_datos_entidad OBJ_pde, BEAN_entidad OBJ_bal) {
        OBJ_pde.JRD_es_cliente.setSelected(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getEs_cliente())));
        OBJ_pde.JRD_es_proveedor.setSelected(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getEs_proveedor())));
        OBJ_pde.JRD_es_trabajador.setSelected(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getEs_trabajador())));
        if (OBJ_bal.getTipo_procedencia().equalsIgnoreCase("0")) {
            OBJ_pde.JRD_nacional.setSelected(true);
        } else {
            OBJ_pde.JRD_extranjero.setSelected(true);
        }
        OBJ_pde.TXT_codigo_entidad.setText(OBJ_bal.getCodigo_entidad());
        OBJ_pde.CBX_estado.setSelectedIndex(Integer.parseInt(OBJ_bal.getStatus()));
        OBJ_pde.CBX_tipo_persona.setSelectedIndex(Integer.parseInt(OBJ_bal.getTipo_persona()));
        go_cbx_trato_datos.selecciona_valor(4, OBJ_bal.getTipo_documento_id(), OBJ_pde.CBX_tipo_documento_id);
        OBJ_pde.TXT_numero_doc_id.setText(OBJ_bal.getNumero_documento_id());
        OBJ_pde.TXT_papellido.setText(OBJ_bal.getPrimer_apellido());
        OBJ_pde.TXT_sapellido.setText(OBJ_bal.getSegundo_apellido());
        OBJ_pde.TXT_nombre.setText(OBJ_bal.getNombres());
        OBJ_pde.TXT_razon_social.setText(OBJ_bal.getRazon_social());
        OBJ_pde.TXT_nombre_comercial.setText(OBJ_bal.getNombre_comercial());
        go_cbx_trato_datos.selecciona_valor(13, OBJ_bal.getCodigo_pais(), OBJ_pde.CBX_pais);
        OBJ_pde.TXT_direccion.setText(OBJ_bal.getDireccion());
        OBJ_pde.TXT_codigo_ubigeo.setText(OBJ_bal.getCodigo_ubigeo());
        OBJ_pde.TXT_descripcion_ubigeo.setText(OBJ_bal.getDescripcion_ubigeo());
        if (OBJ_bal.getForma_pago().equalsIgnoreCase("EF")) {
            OBJ_pde.CBX_forma_pago.setSelectedIndex(0);
        } else {
            OBJ_pde.CBX_forma_pago.setSelectedIndex(1);
        }
        OBJ_pde.TXT_dias_cr.setText(OBJ_bal.getDias_credito() + "");
        OBJ_pde.TXT_limite_cr.setText(OBJ_bal.getLimite_credito() + "");
        go_cbx_trato_datos.selecciona_valor(2, OBJ_bal.getCodigo_sucursal(), OBJ_pde.CBX_sucursal);
        OBJ_pde.CBX_tipo_comercio.setSelectedIndex(Integer.parseInt(OBJ_bal.getTipo_comercio()));
        go_cbx_trato_datos.selecciona_valor(14, OBJ_bal.getCodigo_vendedor(), OBJ_pde.CBX_vendedor);
        OBJ_pde.TXT_observacion.setText(OBJ_bal.getObservacion());
        OBJ_pde.JRD_agente_percepcion.setSelected(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getAgente_percepcion())));
        OBJ_pde.JRD_agente_retencion.setSelected(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getAgente_retencion())));
        OBJ_pde.JRD_entidad_excluida.setSelected(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getEntidad_excluida())));
        OBJ_pde.JRD_es_domiciliado.setSelected(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(OBJ_bal.getEs_domiciliado())));
    }

    public void setea_recupera(BEAN_entidad OBJ_bet, ResultSet lq_rs) {
        try {
            OBJ_bet.setCodigo_entidad(lq_rs.getString(1));
            OBJ_bet.setEs_cliente(lq_rs.getString(2));
            OBJ_bet.setEs_proveedor(lq_rs.getString(3));
            OBJ_bet.setEs_trabajador(lq_rs.getString(4));
            OBJ_bet.setStatus(lq_rs.getString(5));
            OBJ_bet.setTipo_procedencia(lq_rs.getString(6));
            OBJ_bet.setRazon_social(lq_rs.getString(7));
            OBJ_bet.setNombre_comercial(lq_rs.getString(8));
            OBJ_bet.setTipo_persona(lq_rs.getString(9));
            OBJ_bet.setTipo_documento_id(lq_rs.getString(10));
            OBJ_bet.setNumero_documento_id(lq_rs.getString(11));
            OBJ_bet.setEs_domiciliado(lq_rs.getString(12));
            OBJ_bet.setDireccion(lq_rs.getString(13));
            OBJ_bet.setCodigo_ubigeo(lq_rs.getString(14));
            OBJ_bet.setDescripcion_ubigeo(lq_rs.getString(15));
            OBJ_bet.setCodigo_pais(lq_rs.getString(16));
            OBJ_bet.setCodigo_sucursal(lq_rs.getString(19));
            OBJ_bet.setTipo_comercio(lq_rs.getString(20));
            OBJ_bet.setCodigo_vendedor(lq_rs.getString(21));
            OBJ_bet.setAgente_percepcion(lq_rs.getString(22));
            OBJ_bet.setAgente_retencion(lq_rs.getString(23));
            OBJ_bet.setEntidad_excluida(lq_rs.getString(24));
            OBJ_bet.setObservacion(lq_rs.getString(25));
            OBJ_bet.setForma_pago(lq_rs.getString(26));
            OBJ_bet.setNombres(lq_rs.getString(27));
            OBJ_bet.setPrimer_apellido(lq_rs.getString(28));
            OBJ_bet.setSegundo_apellido(lq_rs.getString(29));
            OBJ_bet.setDias_credito(lq_rs.getInt(17));
            OBJ_bet.setLimite_credito(lq_rs.getDouble(18));
        } catch (Exception e) {
        }
    }

    public void setea_campos(BEAN_entidad OBJ_bet, pnl_datos_entidad obj_pde, cbx_tabla_sunat cbx_tipo_doc, cbx_pais cbx_pais, cbx_vendedor cbx_vendedor, cbx_sucursal cbx_sucursal) {
        try {
            String procedencia = "", forma_pago = "";
            if (obj_pde.JRD_nacional.isSelected() == true) {
                procedencia = "0";
            } else {
                procedencia = "1";
            }
            if (obj_pde.CBX_forma_pago.getSelectedIndex() == 0) {
                forma_pago = "EF";
            } else {
                forma_pago = "CR";
            }
            OBJ_bet.setCodigo_entidad(obj_pde.TXT_codigo_entidad.getText().trim());
            OBJ_bet.setEs_cliente(go_fnc_operaciones_campos.boolean_int(obj_pde.JRD_es_cliente.isSelected()) + "");
            OBJ_bet.setEs_proveedor(go_fnc_operaciones_campos.boolean_int(obj_pde.JRD_es_proveedor.isSelected()) + "");
            OBJ_bet.setEs_trabajador(go_fnc_operaciones_campos.boolean_int(obj_pde.JRD_es_trabajador.isSelected()) + "");
            OBJ_bet.setStatus(obj_pde.CBX_estado.getSelectedIndex() + "");
            OBJ_bet.setTipo_procedencia(procedencia);
            OBJ_bet.setRazon_social(obj_pde.TXT_razon_social.getText().trim());
            OBJ_bet.setNombre_comercial(obj_pde.TXT_nombre_comercial.getText().trim());
            OBJ_bet.setTipo_persona(obj_pde.CBX_tipo_persona.getSelectedIndex() + "");
            OBJ_bet.setTipo_documento_id(cbx_tipo_doc.getID());
            OBJ_bet.setNumero_documento_id(obj_pde.TXT_numero_doc_id.getText().trim());
            OBJ_bet.setEs_domiciliado(go_fnc_operaciones_campos.boolean_int(obj_pde.JRD_es_domiciliado.isSelected()) + "");
            OBJ_bet.setDireccion(obj_pde.TXT_direccion.getText().trim());
            OBJ_bet.setCodigo_ubigeo(obj_pde.TXT_codigo_ubigeo.getText().trim());
            OBJ_bet.setDescripcion_ubigeo(obj_pde.TXT_descripcion_ubigeo.getText().trim());
            OBJ_bet.setCodigo_pais(cbx_pais.getID());
            OBJ_bet.setCodigo_sucursal(cbx_sucursal.getID());
            OBJ_bet.setTipo_comercio(obj_pde.CBX_tipo_comercio.getSelectedIndex() + "");
            OBJ_bet.setCodigo_vendedor(cbx_vendedor.getID());
            OBJ_bet.setAgente_percepcion(go_fnc_operaciones_campos.boolean_int(obj_pde.JRD_agente_percepcion.isSelected()) + "");
            OBJ_bet.setAgente_retencion(go_fnc_operaciones_campos.boolean_int(obj_pde.JRD_agente_retencion.isSelected()) + "");
            OBJ_bet.setEntidad_excluida(go_fnc_operaciones_campos.boolean_int(obj_pde.JRD_entidad_excluida.isSelected()) + "");
            OBJ_bet.setObservacion(obj_pde.TXT_observacion.getText().trim());
            OBJ_bet.setForma_pago(forma_pago);
            OBJ_bet.setNombres(obj_pde.TXT_nombre.getText().trim());
            OBJ_bet.setPrimer_apellido(obj_pde.TXT_papellido.getText().trim());
            OBJ_bet.setSegundo_apellido(obj_pde.TXT_sapellido.getText().trim());
            OBJ_bet.setDias_credito(Integer.parseInt(obj_pde.TXT_dias_cr.getText().trim()));
            OBJ_bet.setLimite_credito(Double.parseDouble(obj_pde.TXT_limite_cr.getText().trim().replaceAll(",", "")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public KeyListener evento_press(pnl_datos_entidad OBJ_pde, KeyListener KeyEvnt) {
        OBJ_pde.JRD_es_cliente.addKeyListener(KeyEvnt);
        OBJ_pde.JRD_es_proveedor.addKeyListener(KeyEvnt);
        OBJ_pde.JRD_es_trabajador.addKeyListener(KeyEvnt);
        OBJ_pde.JRD_es_trabajador.addKeyListener(KeyEvnt);
        OBJ_pde.JRD_nacional.addKeyListener(KeyEvnt);
        OBJ_pde.JRD_extranjero.addKeyListener(KeyEvnt);
        OBJ_pde.CBX_estado.addKeyListener(KeyEvnt);
        OBJ_pde.CBX_tipo_persona.addKeyListener(KeyEvnt);
        OBJ_pde.CBX_tipo_documento_id.addKeyListener(KeyEvnt);
        OBJ_pde.TXT_numero_doc_id.addKeyListener(KeyEvnt);
        OBJ_pde.TXT_papellido.addKeyListener(KeyEvnt);
        OBJ_pde.TXT_sapellido.addKeyListener(KeyEvnt);
        OBJ_pde.TXT_nombre.addKeyListener(KeyEvnt);
        OBJ_pde.TXT_razon_social.addKeyListener(KeyEvnt);
        OBJ_pde.TXT_nombre_comercial.addKeyListener(KeyEvnt);
        OBJ_pde.CBX_pais.addKeyListener(KeyEvnt);
        OBJ_pde.TXT_direccion.addKeyListener(KeyEvnt);
        OBJ_pde.TXT_codigo_ubigeo.addKeyListener(KeyEvnt);
        OBJ_pde.CBX_forma_pago.addKeyListener(KeyEvnt);
        OBJ_pde.TXT_dias_cr.addKeyListener(KeyEvnt);
        OBJ_pde.TXT_limite_cr.addKeyListener(KeyEvnt);
        OBJ_pde.CBX_sucursal.addKeyListener(KeyEvnt);
        OBJ_pde.CBX_vendedor.addKeyListener(KeyEvnt);
        OBJ_pde.TXT_observacion.addKeyListener(KeyEvnt);
        OBJ_pde.JRD_agente_percepcion.addKeyListener(KeyEvnt);
        OBJ_pde.JRD_agente_retencion.addKeyListener(KeyEvnt);
        OBJ_pde.JRD_entidad_excluida.addKeyListener(KeyEvnt);
        OBJ_pde.JRD_es_domiciliado.addKeyListener(KeyEvnt);
        OBJ_pde.CBX_tipo_comercio.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public ItemListener evento_item(pnl_datos_entidad OBJ_pde, ItemListener ItemEvent) {
        OBJ_pde.JRD_es_proveedor.addItemListener(ItemEvent);
        OBJ_pde.JRD_es_trabajador.addItemListener(ItemEvent);
        OBJ_pde.CBX_tipo_persona.addItemListener(ItemEvent);
        OBJ_pde.CBX_tipo_documento_id.addItemListener(ItemEvent);
        OBJ_pde.JRD_extranjero.addItemListener(ItemEvent);
        OBJ_pde.CBX_forma_pago.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
