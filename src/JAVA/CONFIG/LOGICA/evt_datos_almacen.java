package JAVA.CONFIG.LOGICA;

import JAVA.CONFIG.GUI.pnl_datos_almacen;
import java.awt.event.KeyListener;

public class evt_datos_almacen {

    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "evt_datos_almacen";

    public void activa_campos(int op, pnl_datos_almacen OBJ_pda, boolean valor) {
        switch (op) {
            case 0:
                //OBJ_pds.TXT_codigo.setEnabled(valor);
                OBJ_pda.TXT_nombre_almacen.setEnabled(valor);
                OBJ_pda.TXT_direccion_almacen.setEnabled(valor);
                OBJ_pda.CBX_estado.setEnabled(valor);
                OBJ_pda.CBX_tipo_almacen.setEnabled(valor);
                OBJ_pda.CBX_sucursal.setEnabled(valor);
                OBJ_pda.TXT_ubigeo.setEnabled(valor);
                OBJ_pda.TXT_nota.setEnabled(valor);
                OBJ_pda.TXT_nombre_almacen.requestFocus();
                break;
        }
    }
    
    public void limpia_datos(pnl_datos_almacen OBJ_pda) {
        OBJ_pda.TXT_codigo_almacen.setText("");
        OBJ_pda.TXT_nombre_almacen.setText("");
        OBJ_pda.TXT_direccion_almacen.setText("");
        OBJ_pda.TXT_ubigeo.setText("");
        OBJ_pda.TXT_descripcion.setText("");
        OBJ_pda.TXT_nota.setText("");
    }
    
    public KeyListener evento_press(pnl_datos_almacen OBJ_pda, KeyListener KeyEvnt) {
        OBJ_pda.TXT_codigo_almacen.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_nombre_almacen.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_direccion_almacen.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_estado.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_tipo_almacen.addKeyListener(KeyEvnt);
        OBJ_pda.CBX_sucursal.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_ubigeo.addKeyListener(KeyEvnt);
        OBJ_pda.TXT_nota.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
