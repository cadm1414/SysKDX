package JAVA.ANCESTRO.LOGICA;

import JAVA.CONFIG.LOGICA.muestra_reporte_config;
import JAVA.CONFIG.LOGICA.muestra_pestania_config;
import JAVA.CONFIG.LOGICA.muestra_jif_config;
import JAVA.ANCESTRO.DAO.*;
import JAVA.CONFIG.GUI.frm_datos_rol_menu;
import JAVA.ANCESTRO.GUI.frm_principal;
import JAVA.CONFIG.BEAN.BEAN_general;
import JAVA.CONFIG.DAO.*;
import JAVA.CONFIG.GUI.dlg_busq_almacen;
import JAVA.CONFIG.GUI.dlg_busq_entidad;
import JAVA.CONFIG.GUI.dlg_busq_entidad_parametros;
import JAVA.CONFIG.GUI.dlg_busq_rol;
import JAVA.CONFIG.GUI.dlg_busq_sucursal;
import JAVA.CONFIG.GUI.dlg_busq_tipo_movimiento;
import JAVA.CONFIG.GUI.dlg_busq_ubigeo;
import JAVA.CONFIG.GUI.dlg_busq_unidad_medida;
import JAVA.CONFIG.GUI.dlg_busq_usuario;
import JAVA.CONFIG.GUI.dlg_busq_vendedor;
import JAVA.CONFIG.GUI.dlg_tipo_movimiento_parametros;
import JAVA.CONFIG.GUI.frm_datos_general;
import JAVA.CONFIG.GUI.jif_datos_almacen;
import JAVA.CONFIG.GUI.jif_datos_entidad;
import JAVA.CONFIG.GUI.jif_datos_sucursal;
import JAVA.CONFIG.GUI.jif_datos_tipo_movimiento;
import JAVA.CONFIG.GUI.jif_datos_unidad_medida;
import JAVA.CONFIG.GUI.jif_datos_usuario;
import JAVA.CONFIG.GUI.jif_datos_usuario_permisos;
import JAVA.CONFIG.LOGICA.evt_datos_general;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_almacen;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_entidad;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_sucursal;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_tipo_movimiento;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_unidad_medida;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_usuario;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_usuario_permisos;
import JAVA.CTACOB.DAO.DAO_banco;
import JAVA.CTACOB.DAO.DAO_cuenta_corriente_rv;
import JAVA.CTACOB.DAO.DAO_recibo_cobranza;
import JAVA.CTACOB.DAO.DAO_recibo_cobranza_detalle;
import JAVA.CTACOB.GUI.dlg_busq_recibo_cobranza;
import JAVA.CTACOB.GUI.dlg_datos_seleccion_saldos;
import JAVA.CTACOB.GUI.dlg_rpt_saldo_cta_corriente;
import JAVA.CTACOB.GUI.dlg_rpt_tarjeta_cuenta_corriente;
import JAVA.CTACOB.LOGICA.muestra_dlg_ctacob;
import JAVA.CTACOB.LOGICA.muestra_pestania_ctacob;
import JAVA.CTACOB.LOGICA.muestra_reporte_ctacob;
import JAVA.CTACOB.REPORT.pnl_rpt_saldo_cta_corriente;
import JAVA.INVENT.DAO.*;
import JAVA.INVENT.GUI.dlg_almacen_x_permiso;
import JAVA.INVENT.GUI.dlg_busq_articulo;
import JAVA.INVENT.GUI.dlg_busq_articulo_costo;
import JAVA.INVENT.GUI.dlg_busq_familia;
import JAVA.INVENT.GUI.dlg_busq_kardex;
import JAVA.INVENT.GUI.dlg_busq_marca;
import JAVA.INVENT.GUI.dlg_busq_producto;
import JAVA.INVENT.GUI.dlg_busq_stock_x_lote;
import JAVA.INVENT.GUI.dlg_busq_subfamilia;
import JAVA.INVENT.GUI.dlg_ini_almacen;
import JAVA.INVENT.GUI.dlg_rpt_stock;
import JAVA.INVENT.GUI.jif_datos_articulo;
import JAVA.INVENT.GUI.jif_datos_articulo_costo;
import JAVA.INVENT.GUI.jif_datos_familia;
import JAVA.INVENT.GUI.jif_datos_marca;
import JAVA.INVENT.GUI.jif_datos_producto;
import JAVA.INVENT.GUI.jif_datos_subfamilia;
import JAVA.INVENT.GUI.jif_guia_ingreso;
import JAVA.INVENT.GUI.jif_guia_salida;
import JAVA.INVENT.GUI.jif_saldos_iniciales;
import JAVA.INVENT.LOGICA.muestra_dlg_invent;
import JAVA.INVENT.LOGICA.muestra_jif_invent;
import JAVA.INVENT.LOGICA.muestra_pestania_invent;
import JAVA.INVENT.LOGICA.muestra_reporte_invent;
import JAVA.INVENT.REPORT.pnl_rpt_lista_familia;
import JAVA.INVENT.REPORT.pnl_rpt_lista_marca;
import JAVA.INVENT.REPORT.pnl_rpt_lista_producto;
import JAVA.INVENT.REPORT.pnl_rpt_lista_subfamilia;
import JAVA.INVENT.REPORT.pnl_rpt_stock_futuro;
import JAVA.INVENT.REPORT.pnl_rpt_stock_normal;
import JAVA.INVENT.REPORT.pnl_rpt_stock_simplificado;
import JAVA.INVENT.REPORT.pnl_rpt_stock_valorizado;
import JAVA.UTILITARIOS.CONEXION.*;
import JAVA.UTILITARIOS.FUNCION.*;
import JAVA.VENTAS.DAO.*;
import JAVA.VENTAS.GUI.dlg_anula_factura;
import JAVA.VENTAS.GUI.dlg_busq_entidad_direccion;
import JAVA.VENTAS.GUI.dlg_busq_facturacion;
import JAVA.VENTAS.GUI.dlg_busq_guia_remision;
import JAVA.VENTAS.GUI.dlg_busq_pedido;
import JAVA.VENTAS.GUI.dlg_busq_registro_ventas;
import JAVA.VENTAS.GUI.dlg_busq_transportista;
import JAVA.VENTAS.GUI.dlg_control_pedido;
import JAVA.VENTAS.GUI.dlg_datos_pl;
import JAVA.VENTAS.GUI.dlg_datos_seleccion_guiar;
import JAVA.VENTAS.GUI.dlg_datos_seleccion_pedido;
import JAVA.VENTAS.GUI.dlg_despacho_pedido;
import JAVA.VENTAS.GUI.dlg_ini_serie;
import JAVA.VENTAS.GUI.jif_factura;
import JAVA.VENTAS.GUI.jif_guia_remision;
import JAVA.VENTAS.GUI.jif_pedido;
import JAVA.CTACOB.GUI.jif_recibo_cobranza;
import JAVA.CTACOB.REPORT.pnl_rpt_estado_cuenta;
import JAVA.CTACOB.REPORT.pnl_rpt_listado_cobranzas;
import JAVA.CTACOB.REPORT.pnl_rpt_listado_cobranzas_sr;
import JAVA.CTACOB.REPORT.pnl_rpt_tarjeta_cuenta_corriente;
import JAVA.DISTBR.GUI.dlg_ini_serie_sector;
import JAVA.DISTBR.LOGICA.muestra_dlg_distbr;
import JAVA.INVENT.GUI.dlg_rpt_kardex_mercaderia;
import JAVA.INVENT.GUI.dlg_rpt_producto_x_movimiento;
import JAVA.INVENT.REPORT.pnl_rpt_kardex_mercaderia_normal;
import JAVA.INVENT.REPORT.pnl_rpt_kardex_mercaderia_val;
import JAVA.INVENT.REPORT.pnl_rpt_producto_x_movimiento;
import JAVA.VENTAS.GUI.dlg_busq_ref_documento;
import JAVA.VENTAS.GUI.dlg_resumen_documento;
import JAVA.VENTAS.GUI.dlg_rpt_registro_ventas;
import JAVA.VENTAS.GUI.jif_cierre_pedidos;
import JAVA.VENTAS.GUI.jif_nota_credito;
import JAVA.VENTAS.GUI.jif_tipo_cambio;
import JAVA.VENTAS.LOGICA.evt_imprime_doc_ventas;
import JAVA.VENTAS.LOGICA.muestra_dlg_ventas;
import JAVA.VENTAS.LOGICA.muestra_jif_ventas;
import JAVA.VENTAS.LOGICA.muestra_pestania_ventas;
import JAVA.VENTAS.LOGICA.muestra_reporte_ventas;
import JAVA.VENTAS.REPORT.pnl_rpt_control_pedido;
import JAVA.VENTAS.REPORT.pnl_rpt_control_pedido_pendiente;
import JAVA.VENTAS.REPORT.pnl_rpt_despacho_pedido;
import JAVA.VENTAS.REPORT.pnl_rpt_diferencia_pedido;
import JAVA.VENTAS.REPORT.pnl_rpt_registro_ventas;
import JAVA.VENTAS.REPORT.pnl_rpt_resumen_documento;

public class variables_globales {

    //CONEXION
    public static CONEXION_emp go_conexion_emp = new CONEXION_emp();
    public static CONEXION_db go_conexion_db = new CONEXION_db();

    //FUNCIONES
    public static fnc_mensaje go_fnc_mensaje = new fnc_mensaje();
    public static fnc_cierra_sistema go_fnc_cierra_sistema = new fnc_cierra_sistema();
    public static fnc_operaciones_campos go_fnc_operaciones_campos = new fnc_operaciones_campos();
    public static fnc_finaliza_conexion go_fnc_finaliza_conexion = new fnc_finaliza_conexion();
    public static fnc_filtrar_tablas go_fnc_filtrar_tablas = new fnc_filtrar_tablas();
    public static fnc_valida_ruc go_fnc_valida_ruc = new fnc_valida_ruc();

    //VARIABLES
    public static String gs_base_datos,
            gs_periodo,
            gs_nombre_usuario,
            gs_datos_usuario,
            gs_nombre_rol,
            gs_modulo[],
            gs_codigo_modulo[],
            gs_direccion_ip,
            gs_nombre_pc,
            gs_direccion_mac,
            gs_dia,
            gs_mes,
            gs_tipo_comercio,
            gs_entidad_usuario,
            gs_vendedor_usuario;
    public static String[] gs_parametros = new String[99999];
    public static int gi_codigo_empresa,
            gi_id_usuario,
            gi_id_rol;
    public static int[] gi_parametros_2 = new int[99999];

    //DAO
    public static DAO_registro_empresa go_dao_registro_empresa = new DAO_registro_empresa();
    public static DAO_periodo_empresa go_dao_periodo_empresa = new DAO_periodo_empresa();
    public static DAO_usuario go_dao_usuario = new DAO_usuario();
    public static DAO_general go_dao_general = new DAO_general();
    public static DAO_rol_menu go_dao_rol_menu = new DAO_rol_menu();
    public static DAO_moneda go_dao_moneda = new DAO_moneda();
    public static DAO_ubigeo go_dao_ubigeo = new DAO_ubigeo();
    public static DAO_menu go_dao_menu = new DAO_menu();
    public static DAO_rol go_dao_rol = new DAO_rol();
    public static DAO_sucursal go_dao_sucursal = new DAO_sucursal();
    public static DAO_almacen go_dao_almacen = new DAO_almacen();
    public static DAO_usuario_permisos go_dao_usuario_permisos = new DAO_usuario_permisos();
    public static DAO_taba_sunat go_dao_tabla_sunat = new DAO_taba_sunat();
    public static DAO_tipo_movimiento go_dao_tipo_movimiento = new DAO_tipo_movimiento();
    public static DAO_marca go_dao_marca = new DAO_marca();
    public static DAO_producto go_dao_producto = new DAO_producto();
    public static DAO_familia go_dao_familia = new DAO_familia();
    public static DAO_subfamilia go_dao_subfamilia = new DAO_subfamilia();
    public static DAO_unidad_medida go_dao_unidad_medida = new DAO_unidad_medida();
    public static DAO_grupo_detraccion go_dao_grupo_detraccion = new DAO_grupo_detraccion();
    public static DAO_grupo_percepcion go_dao_grupo_percepcion = new DAO_grupo_percepcion();
    public static DAO_articulo go_dao_articulo = new DAO_articulo();
    public static DAO_articulo_costo go_dao_articulo_costo = new DAO_articulo_costo();
    public static DAO_tipo_documento go_dao_tipo_documento = new DAO_tipo_documento();
    public static DAO_kardex go_dao_kardex = new DAO_kardex();
    public static DAO_kardex_detalle go_dao_kardex_detalle = new DAO_kardex_detalle();
    public static DAO_auditoria go_dao_auditoria = new DAO_auditoria();
    public static DAO_pais go_dao_pais = new DAO_pais();
    public static DAO_entidad go_dao_entidad = new DAO_entidad();
    public static DAO_vendedor go_dao_vendedor = new DAO_vendedor();
    public static DAO_entidad_direccion go_dao_entidad_direccion = new DAO_entidad_direccion();
    public static DAO_serie go_dao_serie = new DAO_serie();
    public static DAO_igv go_dao_igv = new DAO_igv();
    public static DAO_pedido go_dao_pedido = new DAO_pedido();
    public static DAO_tipo_cambio go_dao_tipo_cambio = new DAO_tipo_cambio();
    public static DAO_reportes go_dao_reportes = new DAO_reportes();
    public static DAO_pedido_detalle go_dao_pedido_detalle = new DAO_pedido_detalle();
    public static DAO_registro_ventas go_dao_registro_ventas = new DAO_registro_ventas();
    public static DAO_registro_ventas_detalle go_dao_registro_ventas_detalle = new DAO_registro_ventas_detalle();
    public static DAO_transportista go_dao_transportista = new DAO_transportista();
    public static DAO_guia_remision go_dao_guia_remision = new DAO_guia_remision();
    public static DAO_guia_remision_detalle go_dao_guia_remision_detalle = new DAO_guia_remision_detalle();
    public static DAO_precios go_dao_precios = new DAO_precios();
    public static DAO_banco go_dao_banco = new DAO_banco();
    public static DAO_recibo_cobranza go_dao_recibo_cobranza = new DAO_recibo_cobranza();
    public static DAO_cuenta_corriente_rv go_dao_cuenta_corriente_rv = new DAO_cuenta_corriente_rv();
    public static DAO_recibo_cobranza_detalle go_dao_recibo_cobranza_detalle = new DAO_recibo_cobranza_detalle();
    public static DAO_entidad_contacto go_dao_entidad_contacto = new DAO_entidad_contacto();
    public static DAO_tipo_comercio go_dao_tipo_comercio = new DAO_tipo_comercio();
    public static DAO_tabla_ayuda go_dao_tabla_ayuda = new DAO_tabla_ayuda();
    public static DAO_sector_distribucion go_dao_sector_distribucion = new DAO_sector_distribucion();

    //GUI
    public static frm_principal go_frm_principal;
    public static frm_datos_general go_frm_datos_general;
    public static frm_datos_rol_menu go_frm_datos_rol_menu;

    //BEAN
    public static BEAN_general go_bean_general = new BEAN_general();

    //CLASE
    public static evt_salir go_evt_salir = new evt_salir();
    public static cbx_trato_datos go_cbx_trato_datos = new cbx_trato_datos();
    public static evt_datos_general go_evt_datos_general = new evt_datos_general();
    public static muestra_reporte_config go_evt_muestra_reporte = new muestra_reporte_config();
    public static muestra_jif_config go_muestra_jif = new muestra_jif_config();
    public static muestra_pestania_config go_muestra_pestania = new muestra_pestania_config();
    public static muestra_jif_invent go_muestra_jif_invent = new muestra_jif_invent();
    public static muestra_pestania_invent go_muestra_pestania_invent = new muestra_pestania_invent();
    public static muestra_reporte_invent go_muestra_reporte_invent = new muestra_reporte_invent();
    public static muestra_dlg_invent go_muestra_dlg_invent = new muestra_dlg_invent();
    public static muestra_dlg_ventas go_muestra_dlg_ventas = new muestra_dlg_ventas();
    public static muestra_jif_ventas go_muestra_jif_ventas = new muestra_jif_ventas();
    public static activa_buscador go_activa_buscador = new activa_buscador();
    public static evt_imprime_doc_ventas go_evt_imprime_doc_ventas = new evt_imprime_doc_ventas();
    public static muestra_reporte_ventas go_muestra_reporte_ventas = new muestra_reporte_ventas();
    public static muestra_pestania_ventas go_muestra_pestania_ventas = new muestra_pestania_ventas();
    public static muestra_dlg_ctacob go_muestra_dlg_ctacob = new muestra_dlg_ctacob();
    public static muestra_reporte_ctacob go_muestra_reporte_ctacob = new muestra_reporte_ctacob();
    public static muestra_pestania_ctacob go_muestra_pestania_ctacob = new muestra_pestania_ctacob();
    public static muestra_dlg_distbr go_muestra_dlg_distbr = new muestra_dlg_distbr();

    //DLG 
    public static dlg_busq_ubigeo go_dlg_busq_ubigeo;
    public static dlg_busq_rol go_dlg_busq_rol;
    public static dlg_busq_usuario go_dlg_busq_usuario;
    public static dlg_busq_sucursal go_dlg_busq_sucursal;
    public static dlg_busq_almacen go_dlg_busq_almacen;
    public static dlg_busq_tipo_movimiento go_dlg_busq_tipo_movimiento;
    public static dlg_busq_marca go_dlg_busq_marca;
    public static dlg_busq_producto go_dlg_busq_producto;
    public static dlg_busq_familia go_dlg_busq_familia;
    public static dlg_busq_subfamilia go_dlg_busq_subfamilia;
    public static dlg_busq_unidad_medida go_dlg_busq_unidad_medida;
    public static dlg_busq_articulo go_dlg_busq_articulo;
    public static dlg_busq_articulo_costo go_dlg_busq_articulo_costo;
    public static dlg_ini_almacen go_dlg_ini_almacen;
    public static dlg_almacen_x_permiso go_dlg_almacen_x_permiso;
    public static dlg_tipo_movimiento_parametros go_dlg_tipo_movimiento_parametros;
    public static dlg_busq_kardex go_dlg_busq_kardex;
    public static dlg_rpt_stock go_dlg_rpt_stock;
    public static dlg_busq_stock_x_lote go_dlg_busq_stock_x_lote;
    public static dlg_busq_entidad go_dlg_busq_entidad;
    public static dlg_ini_serie go_dlg_ini_serie;
    public static dlg_busq_entidad_parametros go_dlg_busq_entidad_parametros;
    public static dlg_busq_vendedor go_dlg_busq_vendedor;
    public static dlg_busq_facturacion go_dlg_busq_facturacion;
    public static dlg_busq_pedido go_dlg_busq_pedido;
    public static dlg_busq_registro_ventas go_dlg_busq_registro_ventas;
    public static dlg_anula_factura go_dlg_anula_factura;
    public static dlg_datos_pl go_dlg_datos_pl;
    public static dlg_busq_entidad_direccion go_dlg_busq_entidad_direccion;
    public static dlg_busq_transportista go_dlg_busq_transportista;
    public static dlg_datos_seleccion_pedido go_dlg_datos_seleccion_pedido;
    public static dlg_busq_guia_remision go_dlg_busq_guia_remision;
    public static dlg_datos_seleccion_guiar go_dlg_datos_seleccion_guiar;
    public static dlg_control_pedido go_dlg_control_pedido;
    public static dlg_despacho_pedido go_dlg_despacho_pedido;
    public static dlg_rpt_saldo_cta_corriente go_dlg_rpt_saldo_cta_corriente;
    public static dlg_datos_seleccion_saldos go_dlg_datos_seleccion_saldos;
    public static dlg_busq_recibo_cobranza go_dlg_busq_recibo_cobranza;
    public static dlg_rpt_kardex_mercaderia go_dlg_rpt_kardex_mercaderia;
    public static dlg_rpt_tarjeta_cuenta_corriente go_dlg_rpt_tarjeta_cuenta_corriente;
    public static dlg_rpt_registro_ventas go_dlg_rpt_registro_ventas;
    public static dlg_busq_ref_documento go_dlg_busq_ref_documento;
    public static dlg_resumen_documento go_dlg_resumen_documento;
    public static dlg_rpt_producto_x_movimiento go_dlg_rpt_producto_x_movimiento;
    public static dlg_ini_serie_sector go_dlg_ini_serie_sector;

    //JIF
    public static jif_datos_usuario go_jif_datos_usuario;
    public static jif_datos_sucursal go_jif_datos_sucursal;
    public static jif_datos_almacen go_jif_datos_almacen;
    public static jif_datos_usuario_permisos go_jif_datos_usuario_permisos;
    public static jif_datos_tipo_movimiento go_jif_datos_tipo_movimiento;
    public static jif_datos_marca go_jif_datos_marca;
    public static jif_datos_producto go_jif_datos_producto;
    public static jif_datos_familia go_jif_datos_familia;
    public static jif_datos_subfamilia go_jif_datos_subfamilia;
    public static jif_datos_unidad_medida go_jif_datos_unidad_medida;
    public static jif_datos_articulo go_jif_datos_articulo;
    public static jif_datos_articulo_costo go_jif_datos_articulo_costo;
    public static jif_saldos_iniciales go_jif_saldos_iniciales;
    public static jif_guia_ingreso go_jif_guia_ingreso;
    public static jif_guia_salida go_jif_guia_salida;
    public static jif_datos_entidad go_jif_datos_entidad;
    public static jif_pedido go_jif_pedido;
    public static jif_factura go_jif_factura;
    public static jif_factura go_jif_boleta;
    public static jif_tipo_cambio go_jif_tipo_cambio;
    public static jif_guia_remision go_jif_guia_remision;
    public static jif_recibo_cobranza go_jif_recibo_cobranza;
    public static jif_cierre_pedidos go_jif_cierre_pedidos;
    public static jif_nota_credito go_jif_nota_credito;

    //PNL
    public static pnl_rpt_lista_usuario go_pnl_rpt_lista_usuario;
    public static pnl_rpt_lista_sucursal go_pnl_rpt_lista_sucursal;
    public static pnl_rpt_lista_almacen go_pnl_rpt_lista_almacen;
    public static pnl_rpt_lista_usuario_permisos go_pnl_rpt_lista_usuario_permisos;
    public static pnl_rpt_lista_tipo_movimiento go_pnl_rpt_lista_tipo_movimiento;
    public static pnl_rpt_lista_marca go_pnl_rpt_lista_marca;
    public static pnl_rpt_lista_producto go_pnl_rpt_lista_producto;
    public static pnl_rpt_lista_familia go_pnl_rpt_lista_familia;
    public static pnl_rpt_lista_subfamilia go_pnl_rpt_lista_subfamilia;
    public static pnl_rpt_lista_unidad_medida go_pnl_rpt_lista_unidad_medida;
    public static pnl_rpt_stock_normal go_pnl_rpt_stock_normal;
    public static pnl_rpt_stock_valorizado go_pnl_rpt_stock_valorizado;
    public static pnl_rpt_stock_futuro go_pnl_rpt_stock_futuro;
    public static pnl_rpt_stock_simplificado go_pnl_rpt_stock_simplificado;
    public static pnl_rpt_control_pedido go_pnl_rpt_control_pedido;
    public static pnl_rpt_control_pedido_pendiente go_pnl_rpt_control_pedido_pendiente;
    public static pnl_rpt_diferencia_pedido go_pnl_rpt_diferencia_pedido;
    public static pnl_rpt_despacho_pedido go_pnl_rpt_despacho_pedido;
    public static pnl_rpt_saldo_cta_corriente go_pnl_rpt_saldo_cta_corriente;
    public static pnl_rpt_kardex_mercaderia_normal go_pnl_rpt_kardex_mercaderia_normal;
    public static pnl_rpt_kardex_mercaderia_val go_pnl_rpt_kardex_mercaderia_val;
    public static pnl_rpt_lista_entidad go_pnl_rpt_lista_entidad;
    public static pnl_rpt_tarjeta_cuenta_corriente go_pnl_rpt_tarjeta_cuenta_corriente;
    public static pnl_rpt_registro_ventas go_pnl_rpt_registro_ventas;
    public static pnl_rpt_estado_cuenta go_pnl_rpt_estado_cuenta;
    public static pnl_rpt_resumen_documento go_pnl_rpt_resumen_documento;
    public static pnl_rpt_producto_x_movimiento go_pnl_rpt_producto_x_movimiento;
    public static pnl_rpt_listado_cobranzas go_pnl_rpt_listado_cobranzas;
    public static pnl_rpt_listado_cobranzas_sr go_pnl_rpt_listado_cobranzas_sr;

}
