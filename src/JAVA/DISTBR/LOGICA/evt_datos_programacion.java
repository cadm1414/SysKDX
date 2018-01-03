package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.BEAN.BEAN_programacion;
import JAVA.DISTBR.GUI.pnl_datos_programacion;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class evt_datos_programacion {

    String ls_modulo = "DISTBR", ls_capa = "LOGICA", ls_clase = "evt_datos_programacion";

    public void activa_campos(int op, pnl_datos_programacion OBJ_pcp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pcp.TXT_numero.setEnabled(valor);
                OBJ_pcp.TXT_fecha_reparto.setEnabled(valor);
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                OBJ_pcp.TXT_codigo_transportista.setEnabled(valor);
                OBJ_pcp.TXT_fecha_preventa.setEnabled(valor);
                OBJ_pcp.TXT_numero.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_datos_programacion OBJ_pcp) {
        OBJ_pcp.TXT_numero.setText("0000000000");
        OBJ_pcp.TXT_fecha_reparto.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcp.CBX_estado.setSelectedIndex(1);
        OBJ_pcp.TXT_observacion.setText("");
        OBJ_pcp.TXT_codigo_transportista.setText("");
        OBJ_pcp.TXT_nombre_transportista.setText("");
        OBJ_pcp.TXT_licencia.setText("");
        OBJ_pcp.TXT_empresa.setText("");
        OBJ_pcp.TXT_ruc_empresa.setText("");
        OBJ_pcp.TXT_codigo_vehiculo.setText("");
        OBJ_pcp.TXT_marca.setText("");
        OBJ_pcp.TXT_civ.setText("");
        OBJ_pcp.TXT_codigo_vehiculo_v2.setText("");
        OBJ_pcp.TXT_marca_v2.setText("");
        OBJ_pcp.TXT_civ_v2.setText("");
        OBJ_pcp.TXT_fecha_preventa.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcp.LBL_fecha_registro.setText("");
        OBJ_pcp.LBL_numero_doc.setText("0000000000");
    }

    public boolean valida_campos(pnl_datos_programacion OBJ_pcp) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_numero)) {
            OBJ_pcp.TXT_numero.setText(go_fnc_operaciones_campos.completa_digitos(OBJ_pcp.TXT_numero.getText().trim(), "0", 10));
            OBJ_pcp.LBL_numero_doc.setText(OBJ_pcp.TXT_numero.getText());
            if (go_fnc_operaciones_campos.valida_fecha(OBJ_pcp.TXT_fecha_reparto.getText())) {
                if (go_fnc_operaciones_campos.valida_periodo(OBJ_pcp.TXT_fecha_reparto.getText(), gs_periodo)) {
                    if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_codigo_transportista) || go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_nombre_transportista)) {
                        if (go_fnc_operaciones_campos.valida_fecha(OBJ_pcp.TXT_fecha_preventa.getText())) {
                            resp = true;
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FECHA INVALIDA");
                            OBJ_pcp.TXT_fecha_preventa.setText("");
                            OBJ_pcp.TXT_fecha_preventa.requestFocus();
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE TRANSPORTISTA");
                        OBJ_pcp.TXT_codigo_transportista.requestFocus();
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "PERIODO INVALIDO");
                    OBJ_pcp.TXT_fecha_reparto.setText("");
                    OBJ_pcp.TXT_fecha_reparto.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FECHA INVALIDA");
                OBJ_pcp.TXT_fecha_reparto.setText("");
                OBJ_pcp.TXT_fecha_reparto.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NUMERO DOCUMENTO");
            OBJ_pcp.TXT_numero.requestFocus();
        }
        return resp;
    }

    public void setea_campos(BEAN_programacion OBJ_bpe, pnl_datos_programacion OBJ_pcp) {
        try {
            OBJ_bpe.setNumero_documento(OBJ_pcp.TXT_numero.getText().trim());
            OBJ_bpe.setFecha_reparto(OBJ_pcp.TXT_fecha_reparto.getText().trim());
            OBJ_bpe.setCodigo_transportista(OBJ_pcp.TXT_codigo_transportista.getText().trim());
            OBJ_bpe.setNombre_transportista(OBJ_pcp.TXT_nombre_transportista.getText().trim());
            OBJ_bpe.setNumero_licencia(OBJ_pcp.TXT_licencia.getText().trim());
            OBJ_bpe.setRazon_social_trans(OBJ_pcp.TXT_empresa.getText().trim());
            OBJ_bpe.setRuc_trans(OBJ_pcp.TXT_ruc_empresa.getText().trim());
            OBJ_bpe.setCodigo_vehiculo(OBJ_pcp.TXT_codigo_vehiculo.getText().trim());
            OBJ_bpe.setMarca(OBJ_pcp.TXT_marca.getText().trim());
            OBJ_bpe.setNumero_civ(OBJ_pcp.TXT_civ.getText().trim());
            OBJ_bpe.setCodigo_vehiculo_2(OBJ_pcp.TXT_codigo_vehiculo_v2.getText().trim());
            OBJ_bpe.setMarca_2(OBJ_pcp.TXT_marca_v2.getText().trim());
            OBJ_bpe.setNumero_civ_2(OBJ_pcp.TXT_civ_v2.getText().trim());
            OBJ_bpe.setEs_liquidado("0");
            OBJ_bpe.setStatus(OBJ_pcp.CBX_estado.getSelectedIndex() + "");
            OBJ_bpe.setObservacion(OBJ_pcp.TXT_observacion.getText().trim());
            OBJ_bpe.setFecha_preventa(OBJ_pcp.TXT_fecha_preventa.getText().trim());
        } catch (Exception e) {
        }
    }

    public void setea_recupera(BEAN_programacion OBJ_bpe, ResultSet lq_rs) {
        try {
            OBJ_bpe.setCodigo_programacion(lq_rs.getString(1));
            OBJ_bpe.setCodigo_sucursal(lq_rs.getString(2));
            OBJ_bpe.setNumero_documento(lq_rs.getString(3));
            OBJ_bpe.setFecha_reparto(go_fnc_operaciones_campos.recupera_fecha_formato((lq_rs.getString(4))));
            OBJ_bpe.setFecha_registro(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(5).substring(0, 10)) + " " + lq_rs.getString(5).substring(11));
            OBJ_bpe.setCodigo_transportista(lq_rs.getString(6));
            OBJ_bpe.setNombre_transportista(lq_rs.getString(7));
            OBJ_bpe.setNumero_licencia(lq_rs.getString(8));
            OBJ_bpe.setRazon_social_trans(lq_rs.getString(9));
            OBJ_bpe.setRuc_trans(lq_rs.getString(10));
            OBJ_bpe.setCodigo_vehiculo(lq_rs.getString(11));
            OBJ_bpe.setMarca(lq_rs.getString(12));
            OBJ_bpe.setNumero_civ(lq_rs.getString(13));
            OBJ_bpe.setCodigo_vehiculo_2(lq_rs.getString(14));
            OBJ_bpe.setMarca_2(lq_rs.getString(15));
            OBJ_bpe.setNumero_civ_2(lq_rs.getString(16));
            OBJ_bpe.setEs_liquidado(lq_rs.getString(17));
            OBJ_bpe.setStatus(lq_rs.getString(18));
            OBJ_bpe.setObservacion(lq_rs.getString(19));            
            OBJ_bpe.setFecha_preventa(go_fnc_operaciones_campos.recupera_fecha_formato((lq_rs.getString(20))));
        } catch (Exception e) {
        }
    }

    public void muestra_datos(pnl_datos_programacion OBJ_pdp, BEAN_programacion OBJ_bpe) {
        OBJ_pdp.TXT_numero.setText(OBJ_bpe.getNumero_documento());
        OBJ_pdp.LBL_numero_doc.setText(OBJ_bpe.getNumero_documento());
        OBJ_pdp.TXT_fecha_reparto.setText(OBJ_bpe.getFecha_reparto());
        OBJ_pdp.LBL_fecha_registro.setText(OBJ_bpe.getFecha_registro());
        OBJ_pdp.TXT_codigo_transportista.setText(OBJ_bpe.getCodigo_transportista());
        OBJ_pdp.TXT_nombre_transportista.setText(OBJ_bpe.getNombre_transportista());
        OBJ_pdp.TXT_empresa.setText(OBJ_bpe.getRazon_social_trans());
        OBJ_pdp.TXT_ruc_empresa.setText(OBJ_bpe.getRuc_trans());
        OBJ_pdp.TXT_licencia.setText(OBJ_bpe.getNumero_licencia());
        OBJ_pdp.TXT_codigo_vehiculo.setText(OBJ_bpe.getCodigo_vehiculo());
        OBJ_pdp.TXT_marca.setText(OBJ_bpe.getMarca());
        OBJ_pdp.TXT_civ.setText(OBJ_bpe.getNumero_civ());
        OBJ_pdp.TXT_codigo_vehiculo_v2.setText(OBJ_bpe.getCodigo_vehiculo_2());
        OBJ_pdp.TXT_marca_v2.setText(OBJ_bpe.getMarca_2());
        OBJ_pdp.TXT_civ_v2.setText(OBJ_bpe.getNumero_civ_2());
        OBJ_pdp.TXT_observacion.setText(OBJ_bpe.getObservacion());
        OBJ_pdp.CBX_estado.setSelectedIndex(Integer.parseInt(OBJ_bpe.getStatus()));
        OBJ_pdp.TXT_fecha_preventa.setText(OBJ_bpe.getFecha_preventa());
    }

    public KeyListener evento_press(pnl_datos_programacion OBJ_pcp, KeyListener KeyEvnt) {
        OBJ_pcp.TXT_numero.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_fecha_reparto.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_observacion.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_codigo_transportista.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_fecha_preventa.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public FocusListener evento_focus(pnl_datos_programacion OBJ_pcp, FocusListener FocusEvent) {
        OBJ_pcp.TXT_numero.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_fecha_reparto.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_observacion.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_codigo_transportista.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_fecha_preventa.addFocusListener(FocusEvent);
        return FocusEvent;
    }
}
