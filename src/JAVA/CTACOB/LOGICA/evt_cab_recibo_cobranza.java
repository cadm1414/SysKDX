package JAVA.CTACOB.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CTACOB.GUI.pnl_cab_recibo_cobranza;

public class evt_cab_recibo_cobranza {

    public void activa_campos(int op, pnl_cab_recibo_cobranza OBJ_pcp, boolean valor) {
        switch (op) {
            case 0:
                OBJ_pcp.TXT_numero_doc.setEnabled(valor);
                OBJ_pcp.TXT_fecha_emision.setEnabled(valor);
                OBJ_pcp.CBX_moneda.setEnabled(valor);
                OBJ_pcp.TXT_codigo_pagador.setEnabled(valor);                                
                OBJ_pcp.TXT_observacion.setEnabled(valor);
                OBJ_pcp.CBX_forma_pago.setEnabled(valor);
                OBJ_pcp.TXT_tipo_cambio.setEnabled(false);
                OBJ_pcp.TXT_numero_doc.requestFocus();
                break;
        }
    }

    public void limpia_datos(pnl_cab_recibo_cobranza OBJ_pcp) {
        OBJ_pcp.LBL_numero_doc.setText("0000000000");
        OBJ_pcp.TXT_numero_doc.setText("");
        OBJ_pcp.TXT_fecha_emision.setText(gs_dia + gs_mes + gs_periodo);
        OBJ_pcp.CBX_moneda.setSelectedIndex(0);
        OBJ_pcp.TXT_codigo_pagador.setText("");
        OBJ_pcp.TXT_nombre_pagador.setText("");
        OBJ_pcp.TXT_tipo_cambio.setText("0.000");
        OBJ_pcp.TXT_codigo_pagador.setText("");
        OBJ_pcp.CBX_forma_pago.setSelectedIndex(0);
        OBJ_pcp.TXT_observacion.setText("");
        OBJ_pcp.CBX_status.setSelectedIndex(1);
        OBJ_pcp.LBL_fecha_registro.setText("");
        OBJ_pcp.CBX_forma_pago.setSelectedIndex(0);
        OBJ_pcp.CBX_banco.setSelectedIndex(0);
        OBJ_pcp.TXT_numero_op.setText("");
        OBJ_pcp.TXT_fecha_op.setText(gs_dia + gs_mes + gs_periodo);
    }
}
