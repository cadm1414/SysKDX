package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.BEAN.BEAN_kardex;
import JAVA.INVENT.GUI.pnl_cab_saldos_iniciales;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.Calendar;

public class evt_cab_saldos_iniciales {

    String ls_modulo = "INVENT", ls_capa = "LOGICA", ls_clase = "evt_cab_saldos_iniciales";
    Calendar fecha = Calendar.getInstance();
    String mes = go_fnc_operaciones_campos.completa_digitos((fecha.get(Calendar.MONTH) + 1) + "", "0", 2);
    String dia = go_fnc_operaciones_campos.completa_digitos((fecha.get(Calendar.DAY_OF_MONTH)) + "", "0", 2);
    
    public void activa_campos(int op, pnl_cab_saldos_iniciales OBJ_pdc, boolean valor) {
        switch (op) {
            case 0:                
                OBJ_pdc.CBX_tipo_doc_ref.setEnabled(valor);
                OBJ_pdc.TXT_numero.setEnabled(valor);
                OBJ_pdc.TXT_numero_ref.setEnabled(valor);
                OBJ_pdc.TXT_fecha_emision.setEnabled(valor);
                OBJ_pdc.TXT_observacion.setEnabled(valor);
                OBJ_pdc.TXT_numero.requestFocus();
                break;
        }
    }
    
    public void limpia_datos(pnl_cab_saldos_iniciales OBJ_pdc) {
        OBJ_pdc.TXT_numero.setText("");
        OBJ_pdc.TXT_numero_ref.setText("");
        OBJ_pdc.TXT_numero.setText("");
        OBJ_pdc.TXT_fecha_emision.setText(dia+mes+gs_periodo);
        OBJ_pdc.TXT_observacion.setText("");
        OBJ_pdc.CBX_estado.setSelectedIndex(1);
        OBJ_pdc.LBL_fecha_registro.setText("");
    }
    
    public void setea_recupera(BEAN_kardex OBJ_bka, ResultSet lq_rs) {
        try {
            OBJ_bka.setCodigo_operacion(lq_rs.getString(1));
            OBJ_bka.setFecha_registro(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(2).substring(0,10))+" "+lq_rs.getString(2).substring(11));
            OBJ_bka.setCodigo_almacen(lq_rs.getString(3));
            OBJ_bka.setFecha_emision(go_fnc_operaciones_campos.recupera_fecha_formato((lq_rs.getString(4))));
            OBJ_bka.setCodigo_movimiento(lq_rs.getString(5));           
            OBJ_bka.setCodigo_documento(lq_rs.getString(6));
            OBJ_bka.setSerie_documento(lq_rs.getString(7));
            OBJ_bka.setNumero_documento(lq_rs.getString(8));
            OBJ_bka.setCodigo_documento_ref(lq_rs.getString(9));
            OBJ_bka.setSerie_documento_ref(lq_rs.getString(10));
            OBJ_bka.setNumero_documento_ref(lq_rs.getString(11));
            OBJ_bka.setTipo_movimiento(lq_rs.getString(12));
            OBJ_bka.setEs_transferencia(lq_rs.getString(13));
            OBJ_bka.setCodigo_almacen_origen(lq_rs.getString(14));
            OBJ_bka.setObservacion(lq_rs.getString(15));
            OBJ_bka.setStatus(lq_rs.getString(16));
        } catch (Exception e) {
        }
    }
    
    public void muestra_datos(pnl_cab_saldos_iniciales OBJ_pds, BEAN_kardex OBJ_bka) {
        OBJ_pds.CBX_estado.setSelectedIndex(Integer.parseInt(OBJ_bka.getStatus()));
        OBJ_pds.TXT_numero.setText(OBJ_bka.getNumero_documento());
        go_cbx_trato_datos.selecciona_valor(12, OBJ_bka.getCodigo_documento_ref(), OBJ_pds.CBX_tipo_doc_ref);
        OBJ_pds.TXT_numero_ref.setText(OBJ_bka.getNumero_documento_ref());
        OBJ_pds.TXT_fecha_emision.setText(OBJ_bka.getFecha_emision());
        OBJ_pds.TXT_observacion.setText(OBJ_bka.getObservacion());
        OBJ_pds.LBL_numero_doc.setText(OBJ_bka.getNumero_documento());
        OBJ_pds.LBL_fecha_registro.setText(OBJ_bka.getFecha_registro());
    }
    
    public KeyListener evento_press(pnl_cab_saldos_iniciales OBJ_pdc, KeyListener KeyEvnt) {
        OBJ_pdc.TXT_numero.addKeyListener(KeyEvnt);
        OBJ_pdc.CBX_tipo_doc_ref.addKeyListener(KeyEvnt);
        OBJ_pdc.TXT_numero_ref.addKeyListener(KeyEvnt);
        OBJ_pdc.TXT_fecha_emision.addKeyListener(KeyEvnt);
        OBJ_pdc.TXT_observacion.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
