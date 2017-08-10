package JAVA.CONFIG.LOGICA;

import JAVA.CONFIG.GUI.pnl_datos_entidad;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;

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
                OBJ_pde.TXT_nombre_comercial.setEnabled(valor);
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
        return KeyEvnt;
    }
    
    public ItemListener evento_item(pnl_datos_entidad OBJ_pde, ItemListener ItemEvent) {
        OBJ_pde.JRD_es_proveedor.addItemListener(ItemEvent);
        OBJ_pde.JRD_es_trabajador.addItemListener(ItemEvent);
        OBJ_pde.CBX_tipo_persona.addItemListener(ItemEvent);
        OBJ_pde.CBX_tipo_documento_id.addItemListener(ItemEvent);
        return ItemEvent;
    }
}
