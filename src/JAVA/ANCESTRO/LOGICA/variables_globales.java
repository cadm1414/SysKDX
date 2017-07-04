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
import JAVA.CONFIG.GUI.dlg_busq_rol;
import JAVA.CONFIG.GUI.dlg_busq_sucursal;
import JAVA.CONFIG.GUI.dlg_busq_tipo_movimiento;
import JAVA.CONFIG.GUI.dlg_busq_ubigeo;
import JAVA.CONFIG.GUI.dlg_busq_unidad_medida;
import JAVA.CONFIG.GUI.dlg_busq_usuario;
import JAVA.CONFIG.GUI.dlg_tipo_movimiento_parametros;
import JAVA.CONFIG.GUI.frm_datos_general;
import JAVA.CONFIG.GUI.jif_datos_almacen;
import JAVA.CONFIG.GUI.jif_datos_sucursal;
import JAVA.CONFIG.GUI.jif_datos_tipo_movimiento;
import JAVA.CONFIG.GUI.jif_datos_unidad_medida;
import JAVA.CONFIG.GUI.jif_datos_usuario;
import JAVA.CONFIG.GUI.jif_datos_usuario_permisos;
import JAVA.CONFIG.LOGICA.evt_datos_general;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_almacen;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_sucursal;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_tipo_movimiento;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_unidad_medida;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_usuario;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_usuario_permisos;
import JAVA.INVENT.DAO.*;
import JAVA.INVENT.GUI.dlg_almacen_x_permiso;
import JAVA.INVENT.GUI.dlg_busq_articulo;
import JAVA.INVENT.GUI.dlg_busq_articulo_costo;
import JAVA.INVENT.GUI.dlg_busq_familia;
import JAVA.INVENT.GUI.dlg_busq_kardex;
import JAVA.INVENT.GUI.dlg_busq_marca;
import JAVA.INVENT.GUI.dlg_busq_producto;
import JAVA.INVENT.GUI.dlg_busq_subfamilia;
import JAVA.INVENT.GUI.dlg_ini_almacen;
import JAVA.INVENT.GUI.jif_datos_articulo;
import JAVA.INVENT.GUI.jif_datos_articulo_costo;
import JAVA.INVENT.GUI.jif_datos_familia;
import JAVA.INVENT.GUI.jif_datos_marca;
import JAVA.INVENT.GUI.jif_datos_producto;
import JAVA.INVENT.GUI.jif_datos_subfamilia;
import JAVA.INVENT.GUI.jif_saldos_iniciales;
import JAVA.INVENT.LOGICA.muestra_dlg_invent;
import JAVA.INVENT.LOGICA.muestra_jif_invent;
import JAVA.INVENT.LOGICA.muestra_pestania_invent;
import JAVA.INVENT.LOGICA.muestra_reporte_invent;
import JAVA.INVENT.REPORT.pnl_rpt_lista_familia;
import JAVA.INVENT.REPORT.pnl_rpt_lista_marca;
import JAVA.INVENT.REPORT.pnl_rpt_lista_producto;
import JAVA.INVENT.REPORT.pnl_rpt_lista_subfamilia;
import JAVA.UTILITARIOS.CONEXION.*;
import JAVA.UTILITARIOS.FUNCION.*;

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
            gs_codigo_modulo[];
    public static String[] gs_parametros  = new String[99999];
    public static int gi_codigo_empresa,
            gi_id_usuario,
            gi_id_rol;

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
}
