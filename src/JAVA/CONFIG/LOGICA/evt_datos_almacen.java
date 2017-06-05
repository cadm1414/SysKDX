package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_almacen;
import JAVA.CONFIG.GUI.pnl_datos_almacen;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

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
    
    public void muestra_datos(pnl_datos_almacen OBJ_pda, BEAN_almacen OBJ_bal) {
        OBJ_pda.TXT_codigo_almacen.setText(OBJ_bal.getCodigo_almacen());
        OBJ_pda.TXT_nombre_almacen.setText(OBJ_bal.getNombre());
        OBJ_pda.TXT_direccion_almacen.setText(OBJ_bal.getDireccion());
        OBJ_pda.CBX_estado.setSelectedIndex(Integer.parseInt(OBJ_bal.getStatus()));
        OBJ_pda.TXT_ubigeo.setText(OBJ_bal.getUbigeo());
        OBJ_pda.TXT_descripcion.setText(OBJ_bal.getDescripcion());
        OBJ_pda.TXT_nota.setText(OBJ_bal.getNota());
        go_cbx_trato_datos.selecciona_valor(2, OBJ_bal.getCodigo_sucursal(), OBJ_pda.CBX_sucursal);
    }
    
    public void setea_recupera(BEAN_almacen OBJ_bal, ResultSet lq_rs) {
        try {
            OBJ_bal.setCodigo_almacen(lq_rs.getString(1));
            OBJ_bal.setNombre(lq_rs.getString(2));
            OBJ_bal.setDireccion(lq_rs.getString(3));
            OBJ_bal.setNota(lq_rs.getString(4));
            OBJ_bal.setStatus(lq_rs.getString(5));
            OBJ_bal.setUbigeo(lq_rs.getString(6));
            OBJ_bal.setDescripcion(lq_rs.getString(7));
            OBJ_bal.setTipo_almacen(lq_rs.getString(8));
            OBJ_bal.setCodigo_sucursal(lq_rs.getString(9));
        } catch (Exception e) {
        }
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
