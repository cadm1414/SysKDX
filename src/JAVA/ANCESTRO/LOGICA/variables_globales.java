package JAVA.ANCESTRO.LOGICA;

import JAVA.ANCESTRO.DAO.DAO_periodo_empresa;
import JAVA.ANCESTRO.DAO.DAO_registro_empresa;
import JAVA.CONFIG.GUI.frm_datos_rol_menu;
import JAVA.ANCESTRO.GUI.frm_principal;
import JAVA.CONFIG.BEAN.BEAN_general;
import JAVA.CONFIG.DAO.DAO_almacen;
import JAVA.CONFIG.DAO.DAO_general;
import JAVA.CONFIG.DAO.DAO_menu;
import JAVA.CONFIG.DAO.DAO_moneda;
import JAVA.CONFIG.DAO.DAO_rol;
import JAVA.CONFIG.DAO.DAO_rol_menu;
import JAVA.CONFIG.DAO.DAO_sucursal;
import JAVA.CONFIG.DAO.DAO_ubigeo;
import JAVA.CONFIG.DAO.DAO_usuario;
import JAVA.CONFIG.GUI.dlg_busq_almacen;
import JAVA.CONFIG.GUI.dlg_busq_rol;
import JAVA.CONFIG.GUI.dlg_busq_sucursal;
import JAVA.CONFIG.GUI.dlg_busq_ubigeo;
import JAVA.CONFIG.GUI.dlg_busq_usuario;
import JAVA.CONFIG.GUI.frm_datos_general;
import JAVA.CONFIG.GUI.jif_datos_almacen;
import JAVA.CONFIG.GUI.jif_datos_sucursal;
import JAVA.CONFIG.GUI.jif_datos_usuario;
import JAVA.CONFIG.LOGICA.evt_datos_general;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_almacen;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_sucursal;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_usuario;
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
    public static muestra_reporte go_evt_muestra_reporte = new muestra_reporte();
    public static muestra_jif go_muestra_jif = new muestra_jif();
    public static muestra_pestania go_muestra_pestania = new muestra_pestania();

    //DLG 
    public static dlg_busq_ubigeo go_dlg_busq_ubigeo;
    public static dlg_busq_rol go_dlg_busq_rol;
    public static dlg_busq_usuario go_dlg_busq_usuario;
    public static dlg_busq_sucursal go_dlg_busq_sucursal;
    public static dlg_busq_almacen go_dlg_busq_almacen;

    //JIF
    public static jif_datos_usuario go_jif_datos_usuario;
    public static jif_datos_sucursal go_jif_datos_sucursal;
    public static jif_datos_almacen go_jif_datos_almacen;

    //PNL
    public static pnl_rpt_lista_usuario go_pnl_rpt_lista_usuario;
    public static pnl_rpt_lista_sucursal go_pnl_rpt_lista_sucursal;
    public static pnl_rpt_lista_almacen go_pnl_rpt_lista_almacen;
}
