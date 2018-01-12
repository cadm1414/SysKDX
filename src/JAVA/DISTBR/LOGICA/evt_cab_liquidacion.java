package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.BEAN.BEAN_liquidacion;
import JAVA.DISTBR.GUI.pnl_cab_liquidacion;
import JAVA.DISTBR.GUI.pnl_grid_liquidacion;
import JAVA.DISTBR.GUI.pnl_grid_programacion;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

public class evt_cab_liquidacion {

    String ls_modulo = "DISTBR", ls_capa = "LOGICA", ls_clase = "evt_datos_programacion";

    public void activa_campos(int op, pnl_cab_liquidacion OBJ_pcp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pcp.TXT_numero.setEnabled(valor);
                OBJ_pcp.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcp.TXT_programacion.setEnabled(valor);
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                OBJ_pcp.TXT_numero.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_cab_liquidacion OBJ_pcp) {
        OBJ_pcp.TXT_numero.setText("0000000000");
        OBJ_pcp.TXT_fecha_emision.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcp.CBX_estado.setSelectedIndex(1);
        OBJ_pcp.TXT_observacion.setText("");
        OBJ_pcp.TXT_programacion.setText("");
        OBJ_pcp.LBL_fecha_registro.setText("");
        OBJ_pcp.LBL_numero_doc.setText("0000000000");
    }

    public boolean valida_campos(pnl_cab_liquidacion OBJ_pcp) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_numero)) {
            OBJ_pcp.TXT_numero.setText(go_fnc_operaciones_campos.completa_digitos(OBJ_pcp.TXT_numero.getText().trim(), "0", 10));
            OBJ_pcp.LBL_numero_doc.setText(OBJ_pcp.TXT_numero.getText());
            if (go_fnc_operaciones_campos.valida_fecha(OBJ_pcp.TXT_fecha_emision.getText())) {
                if (go_fnc_operaciones_campos.valida_periodo(OBJ_pcp.TXT_fecha_emision.getText(), gs_periodo)) {
                    if (go_fnc_operaciones_campos.campo_blanco(OBJ_pcp.TXT_numero)) {
                        resp = true;
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE PROGRAMACION");
                        OBJ_pcp.TXT_numero.requestFocus();
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "PERIODO INVALIDO");
                    OBJ_pcp.TXT_fecha_emision.setText("");
                    OBJ_pcp.TXT_fecha_emision.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "FECHA INVALIDA");
                OBJ_pcp.TXT_fecha_emision.setText("");
                OBJ_pcp.TXT_fecha_emision.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE NUMERO DOCUMENTO");
            OBJ_pcp.TXT_numero.requestFocus();
        }
        return resp;
    }

    public void setea_campos(BEAN_liquidacion OBJ_bpe, pnl_cab_liquidacion OBJ_pcp, pnl_grid_liquidacion OBJ_pgp) {
        try {

            OBJ_bpe.setNumero_documento(OBJ_pcp.TXT_numero.getText().trim());
            OBJ_bpe.setFecha_emision(OBJ_pcp.TXT_fecha_emision.getText().trim());
            OBJ_bpe.setObservacion(OBJ_pcp.TXT_observacion.getText().trim());
            OBJ_bpe.setStatus(OBJ_pcp.CBX_estado.getSelectedIndex() + "");
            OBJ_bpe.setDescuento(Double.parseDouble(OBJ_pgp.LBL_desc.getText().replaceAll(",", "")));
            OBJ_bpe.setTotal_credito(Double.parseDouble(OBJ_pgp.LBL_cr.getText().replaceAll(",", "")));
            OBJ_bpe.setTotal_efectivo(Double.parseDouble(OBJ_pgp.LBL_ef.getText().replaceAll(",", "")));
        } catch (Exception e) {
        }
    }

    public KeyListener evento_press(pnl_cab_liquidacion OBJ_pcp, KeyListener KeyEvnt) {
        OBJ_pcp.TXT_numero.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_fecha_emision.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_observacion.addKeyListener(KeyEvnt);
        OBJ_pcp.TXT_programacion.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }

    public FocusListener evento_focus(pnl_cab_liquidacion OBJ_pcp, FocusListener FocusEvent) {
        OBJ_pcp.TXT_numero.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_fecha_emision.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_observacion.addFocusListener(FocusEvent);
        OBJ_pcp.TXT_programacion.addFocusListener(FocusEvent);
        return FocusEvent;
    }

}
