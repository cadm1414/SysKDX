package JAVA.CONFIG.LOGICA;

import JAVA.CONFIG.GUI.frm_datos_general;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.frm_datos_rol_menu;
import java.beans.PropertyVetoException;

public class opciones_menu {

    /*RETORNA TIPO DE FORMULARIO
        F = Jframe
        I = Jinternal
     */
    public String selecciona_formulario(int index, String dato) throws PropertyVetoException {
        String resp = "";
        String codigo_modulo = gs_codigo_modulo[index];

        switch (codigo_modulo) {
            case "CONFIG":
                if (dato.equalsIgnoreCase("EMPRESA")) {
                    go_frm_datos_general = new frm_datos_general();
                    go_frm_datos_general.setVisible(true);
                    resp = "F";
                }
                if (dato.equalsIgnoreCase("ROL")) {
                    go_frm_datos_rol_menu = new frm_datos_rol_menu();
                    go_frm_datos_rol_menu.setVisible(true);
                    resp = "F";
                }
                if (dato.equalsIgnoreCase("USUARIO")) {
                    go_muestra_jif.muestra_jif_usuario();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("SUCURSAL")) {
                    go_muestra_jif.muestra_jif_sucursal();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("ALMACEN")) {
                    go_muestra_jif.muestra_jif_almacen();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("PERMISOS")) {
                    go_muestra_jif.muestra_jif_usuario_permisos();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("TIPO MOVIMIENTO")) {
                    go_muestra_jif.muestra_jif_tipo_movimiento();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("UNIDAD DE MEDIDA")) {
                    go_muestra_jif.muestra_jif_unidad_medida();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("ENTIDAD")) {
                    go_muestra_jif.muestra_jif_entidad();
                    resp = "I";
                }
                break;
            case "INVENT":
                if (dato.equalsIgnoreCase("MARCA")) {
                    go_muestra_jif_invent.muestra_jif_marca();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("PRODUCTO-SERVICIO")) {
                    go_muestra_jif_invent.muestra_jif_producto();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("FAMILIA")) {
                    go_muestra_jif_invent.muestra_jif_familia();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("SUBFAMILIA")) {
                    go_muestra_jif_invent.muestra_jif_subfamilia();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("ITEM")) {
                    go_muestra_jif_invent.muestra_jif_articulo();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("ARTICULO")) {
                    go_muestra_jif_invent.muestra_jif_articulo_costo();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("SALDOS INICIALES")) {
                    go_muestra_dlg_invent.muestra_dlg_saldos_iniciales();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("INGRESO")) {
                    go_muestra_dlg_invent.muestra_dlg_guia_ingreso();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("SALIDA")) {
                    go_muestra_dlg_invent.muestra_dlg_guia_salida();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("STOCK ALMACEN")) {
                    go_muestra_dlg_invent.muestra_dlg_rpt_stock();
                    resp = "I";
                }
                break;
            case "VENTAS":
                if (dato.equalsIgnoreCase("PEDIDOS")) {
                    go_muestra_dlg_ventas.muestra_dlg_pedido();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("FACTURA")) {
                    go_muestra_dlg_ventas.muestra_dlg_factura("01");
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("BOLETA")) {
                    go_muestra_dlg_ventas.muestra_dlg_boleta("03");
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("GUIA REMISION")) {
                    go_muestra_dlg_ventas.muestra_dlg_guia_remision("09");
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("TIPO DE CAMBIO")) {
                    go_muestra_jif_ventas.muestra_jif_entidad();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("CONTROL PEDIDOS")) {
                    go_muestra_dlg_ventas.muestra_dlg_control_pedido();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("DESPACHO PEDIDO")) {
                    go_muestra_dlg_ventas.muestra_dlg_despacho_pedido();
                    resp = "I";
                }
                break;
            case "CTACOB":
                if (dato.equalsIgnoreCase("SALDO CTA CORRIENTE")) {
                    go_muestra_dlg_ctacob.muestra_dlg_rpt_saldo_cta_corriente();
                    resp = "I";
                }
                if (dato.equalsIgnoreCase("RECIBO COBRANZA")) {
                    go_muestra_dlg_ctacob.muestra_dlg_recibo_cobranza("RC");
                    resp = "I";
                }
                break;
        }
        return resp;
    }
}
