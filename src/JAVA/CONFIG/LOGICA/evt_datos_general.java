package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.pnl_datos_general;
import java.awt.event.KeyListener;

public class evt_datos_general {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_general";

    /*  SWITCH PRINCIPAL 
        0 = EDITAR
        1 = GUARDAR
        2 = CANCELAR
     */
    public void evt_control(int op, pnl_datos_general OBJ_pdg) {
        int cont = go_dao_general.SLT_cta_datos_general();
        switch (op) {
            case 0:
                if (cont == 0) {
                    OBJ_pdg.TXT_ruc.setEnabled(true);
                    OBJ_pdg.TXT_ruc.requestFocus();
                } else {
                    OBJ_pdg.TXT_ruc.setEnabled(false);
                    OBJ_pdg.TXT_razon_social.requestFocus();
                }
                break;
            case 1:
                break;
            case 2:
                break;
        }

    }

    public void activa_bloquea_campos(pnl_datos_general OBJ_pdg, boolean valor) {
        OBJ_pdg.TXT_ruc.setEnabled(valor);
        OBJ_pdg.TXT_razon_social.setEnabled(valor);
        OBJ_pdg.TXT_giro.setEnabled(valor);
        OBJ_pdg.TXT_direccion.setEnabled(valor);
        OBJ_pdg.TXT_ubigeo.setEnabled(valor);
        OBJ_pdg.TXT_fecha_actividad.setEnabled(valor);
        OBJ_pdg.TXT_telf.setEnabled(valor);
        OBJ_pdg.TXT_fax.setEnabled(valor);
        OBJ_pdg.TXT_email.setEnabled(valor);
        OBJ_pdg.TXT_website.setEnabled(valor);
        OBJ_pdg.CBX_moneda.setEnabled(valor);
        //OBJ_pdg.BTN_buscar_logo.setEnabled(valor);
        //OBJ_pdg.BTN_buscar_portada.setEnabled(valor);

    }

    public void muestra_datos(pnl_datos_general OBJ_pdg) {
        OBJ_pdg.TXT_ruc.setText(go_bean_general.getRuc());
        OBJ_pdg.TXT_razon_social.setText(go_bean_general.getRazon_social());
        OBJ_pdg.TXT_giro.setText(go_bean_general.getGiro());
        OBJ_pdg.TXT_direccion.setText(go_bean_general.getDireccion());
        OBJ_pdg.TXT_ubigeo.setText(go_bean_general.getCodigo_ubigeo());
        OBJ_pdg.TXT_descripcion.setText(go_bean_general.getDescripcion_ubigeo());
        OBJ_pdg.TXT_fecha_actividad.setText(go_fnc_operaciones_campos.recupera_fecha(go_bean_general.getFecha_actividad()));
        OBJ_pdg.TXT_telf.setText(go_bean_general.getTelefono());
        OBJ_pdg.TXT_fax.setText(go_bean_general.getFax());
        OBJ_pdg.TXT_email.setText(go_bean_general.getE_mail());
        OBJ_pdg.TXT_website.setText(go_bean_general.getWebsite());
        OBJ_pdg.TXT_logo.setText(go_bean_general.getImagen_logo());
        OBJ_pdg.TXT_portada.setText(go_bean_general.getImagen_portada());
        go_cbx_trato_datos.selecciona_valor(0, go_bean_general.getCodigo_moneda(), OBJ_pdg.CBX_moneda);
    }

    public boolean valida_campos(pnl_datos_general OBJ_pdg) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pdg.TXT_ruc) && go_fnc_operaciones_campos.cant_caracter(OBJ_pdg.TXT_ruc.getText().trim(), 4, 11)) {
            if (go_fnc_valida_ruc.valida_ruc(OBJ_pdg.TXT_ruc.getText().trim())) {
                if (go_fnc_operaciones_campos.campo_blanco(OBJ_pdg.TXT_razon_social)) {
                    if (go_fnc_operaciones_campos.campo_blanco(OBJ_pdg.TXT_ubigeo)) {
                        if (go_dao_ubigeo.SLT_cta_ubigeo_x_codigo(OBJ_pdg.TXT_ubigeo.getText().trim()) != 0) {
                            if (go_fnc_operaciones_campos.campo_blanco(OBJ_pdg.TXT_descripcion)) {
                                if (!OBJ_pdg.TXT_fecha_actividad.getText().trim().equalsIgnoreCase("/  /") && go_fnc_operaciones_campos.valida_fecha(OBJ_pdg.TXT_fecha_actividad.getText().trim())) {
                                    resp = true;
                                } else {
                                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE FECHA CORRECTA");
                                    OBJ_pdg.TXT_fecha_actividad.requestFocus();
                                }
                            } else {
                                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "CODIGO UBIGEO NO EXISTE");
                                OBJ_pdg.TXT_ubigeo.requestFocus();
                            }
                        } else {
                            OBJ_pdg.TXT_ubigeo.requestFocus();
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE CODIGO UBIGEO");
                        OBJ_pdg.TXT_ubigeo.requestFocus();
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE RAZON SOCIAL");
                    OBJ_pdg.TXT_razon_social.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "RUC INVALIDO");
                OBJ_pdg.TXT_ruc.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE RUC");
            OBJ_pdg.TXT_ruc.requestFocus();
        }
        return resp;
    }

    public void setea_campos(pnl_datos_general OBJ_pgr, cbx_moneda cbx_moneda) {
        go_bean_general.setRuc(OBJ_pgr.TXT_ruc.getText().trim());
        go_bean_general.setRazon_social(OBJ_pgr.TXT_razon_social.getText().trim());
        go_bean_general.setGiro(OBJ_pgr.TXT_giro.getText().trim());
        go_bean_general.setDireccion(OBJ_pgr.TXT_direccion.getText().trim());
        go_bean_general.setCodigo_ubigeo(OBJ_pgr.TXT_ubigeo.getText().trim());
        go_bean_general.setDescripcion_ubigeo(OBJ_pgr.TXT_descripcion.getText().trim());
        go_bean_general.setTelefono(OBJ_pgr.TXT_telf.getText().trim());
        go_bean_general.setFax(OBJ_pgr.TXT_fax.getText().trim());
        go_bean_general.setE_mail(OBJ_pgr.TXT_email.getText().trim());
        go_bean_general.setWebsite(OBJ_pgr.TXT_website.getText().trim());
        go_bean_general.setNombre_reporte(OBJ_pgr.TXT_razon_social.getText().trim());
        go_bean_general.setFecha_actividad(OBJ_pgr.TXT_fecha_actividad.getText().trim());
        go_bean_general.setCodigo_moneda(cbx_moneda.getID());
        go_bean_general.setImagen_logo(OBJ_pgr.TXT_logo.getText().trim());
        go_bean_general.setImagen_portada(OBJ_pgr.TXT_portada.getText().trim());
    }

    public boolean verifica_cambios(pnl_datos_general OBJ_pgr, cbx_moneda cbx_moneda) {
        boolean resp = false;
        if (go_bean_general.getRuc().equalsIgnoreCase(OBJ_pgr.TXT_ruc.getText().trim())) {
            if (go_bean_general.getRazon_social().equalsIgnoreCase(OBJ_pgr.TXT_razon_social.getText().trim())) {
                if (go_bean_general.getGiro().equalsIgnoreCase(OBJ_pgr.TXT_giro.getText().trim())) {
                    if (go_bean_general.getDireccion().equalsIgnoreCase(OBJ_pgr.TXT_direccion.getText().trim())) {
                        if (go_bean_general.getCodigo_ubigeo().equalsIgnoreCase(OBJ_pgr.TXT_ubigeo.getText().trim())) {
                            if (go_bean_general.getDescripcion_ubigeo().equalsIgnoreCase(OBJ_pgr.TXT_descripcion.getText().trim())) {
                                if (go_bean_general.getTelefono().equalsIgnoreCase(OBJ_pgr.TXT_telf.getText().trim())) {
                                    if (go_bean_general.getFax().equalsIgnoreCase(OBJ_pgr.TXT_fax.getText().trim())) {
                                        if (go_bean_general.getE_mail().equalsIgnoreCase(OBJ_pgr.TXT_email.getText().trim())) {
                                            if (go_bean_general.getWebsite().equalsIgnoreCase(OBJ_pgr.TXT_website.getText().trim())) {
                                                if (go_bean_general.getNombre_reporte().equalsIgnoreCase(OBJ_pgr.TXT_razon_social.getText().trim())) {
                                                    if (go_fnc_operaciones_campos.recupera_fecha_formato(go_bean_general.getFecha_actividad()).equalsIgnoreCase(OBJ_pgr.TXT_fecha_actividad.getText().trim())) {
                                                        if (go_bean_general.getCodigo_moneda().equalsIgnoreCase(cbx_moneda.getID())) {
                                                            if (go_bean_general.getImagen_logo().equalsIgnoreCase(OBJ_pgr.TXT_logo.getText().trim())) {
                                                                if (go_bean_general.getImagen_portada().equalsIgnoreCase(OBJ_pgr.TXT_portada.getText().trim())) {
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
            } else {
                resp = true;
            }
        } else {
            resp = true;
        }
        return resp;
    }

    public KeyListener evento_press(pnl_datos_general OBJ_pgr, KeyListener KeyEvnt) {
        OBJ_pgr.TXT_ruc.addKeyListener(KeyEvnt);
        OBJ_pgr.TXT_razon_social.addKeyListener(KeyEvnt);
        OBJ_pgr.TXT_giro.addKeyListener(KeyEvnt);
        OBJ_pgr.TXT_direccion.addKeyListener(KeyEvnt);
        OBJ_pgr.TXT_ubigeo.addKeyListener(KeyEvnt);
        OBJ_pgr.TXT_fecha_actividad.addKeyListener(KeyEvnt);
        OBJ_pgr.TXT_telf.addKeyListener(KeyEvnt);
        OBJ_pgr.TXT_fax.addKeyListener(KeyEvnt);
        OBJ_pgr.TXT_email.addKeyListener(KeyEvnt);
        OBJ_pgr.TXT_website.addKeyListener(KeyEvnt);
        OBJ_pgr.CBX_moneda.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
