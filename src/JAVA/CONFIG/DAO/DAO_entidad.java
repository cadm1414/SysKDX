package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_entidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_entidad {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_entidad";

    public ResultSet FNC_codigo_entidad(String caracter) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_codigo_entidad('" + caracter + "') as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs != null) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "FNC_codigo_entidad", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_grid_entidad() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_entidad() "
                    + "as (codigo_entidad character(6),razon_social character varying(250),numero_doc character varying(15),estado text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_entidad", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_datos_entidad(String codigo_entidad) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_entidad('" + codigo_entidad + "') "
                    + "as (codigo_entidad character(6),es_cliente character(1),es_proveedor character(1),es_trabajador character(1),status character(1),tipo_procedencia character(1),razon_social character varying(250),nombre_comercial character varying(250),tipo_persona character(1),tipo_documento_id character(1),numero_documento_id character varying(15),es_domiciliado character(1),direccion character varying(250),codigo_ubigeo character(6),descripcion_ubigeo character varying(100),codigo_pais character varying(3),dias_credito integer,limite_credito numeric(11,2),codigo_sucursal character(4),tipo_comercio character(4),codigo_vendedor character(4),agente_percepcion character(1),agente_retencion character(1),entidad_excluida character(1),observacion text,forma_pago character(2),nombres character varying(150),primer_apellido character varying(150),segundo_apellido character varying(150),codigo_sector character(6))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_entidad", e.getMessage());
        }
        return null;
    }

    public boolean DLT_entidad(String codigo_entidad) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_entidad('" + codigo_entidad + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_entidad", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_entidad", e.getMessage());
        }
        return resp;
    }

    public boolean IST_entidad(BEAN_entidad OBJ_bet) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_entidad('" + OBJ_bet.getCodigo_entidad() + "','" + OBJ_bet.getEs_cliente() + "','" + OBJ_bet.getEs_proveedor() + "','" + OBJ_bet.getEs_trabajador() + "','" + OBJ_bet.getStatus() + "','" + OBJ_bet.getTipo_procedencia() + "',$$" + OBJ_bet.getRazon_social() + "$$,$$" + OBJ_bet.getNombre_comercial() + "$$,'" + OBJ_bet.getTipo_persona() + "','" + OBJ_bet.getTipo_documento_id() + "','" + OBJ_bet.getNumero_documento_id() + "','" + OBJ_bet.getEs_domiciliado() + "',$$" + OBJ_bet.getDireccion() + "$$,'" + OBJ_bet.getCodigo_ubigeo() + "','" + OBJ_bet.getDescripcion_ubigeo() + "','" + OBJ_bet.getCodigo_pais() + "'," + OBJ_bet.getDias_credito() + "," + OBJ_bet.getLimite_credito() + ",'" + OBJ_bet.getCodigo_sucursal() + "','" + OBJ_bet.getTipo_comercio() + "','" + OBJ_bet.getCodigo_vendedor() + "','" + OBJ_bet.getAgente_percepcion() + "','" + OBJ_bet.getAgente_retencion() + "','" + OBJ_bet.getEntidad_excluida() + "','" + OBJ_bet.getObservacion() + "','" + OBJ_bet.getForma_pago() + "',$$" + OBJ_bet.getNombres() + "$$,$$" + OBJ_bet.getPrimer_apellido() + "$$,$$" + OBJ_bet.getSegundo_apellido() + "$$,'"+OBJ_bet.getCodigo_sector()+"')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_entidad", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_entidad", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_entidad(BEAN_entidad OBJ_bet) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_entidad('" + OBJ_bet.getCodigo_entidad() + "','" + OBJ_bet.getEs_cliente() + "','" + OBJ_bet.getEs_proveedor() + "','" + OBJ_bet.getEs_trabajador() + "','" + OBJ_bet.getStatus() + "','" + OBJ_bet.getTipo_procedencia() + "',$$" + OBJ_bet.getRazon_social() + "$$,$$" + OBJ_bet.getNombre_comercial() + "$$,'" + OBJ_bet.getTipo_persona() + "','" + OBJ_bet.getTipo_documento_id() + "','" + OBJ_bet.getNumero_documento_id() + "','" + OBJ_bet.getEs_domiciliado() + "','" + OBJ_bet.getDireccion() + "','" + OBJ_bet.getCodigo_ubigeo() + "','" + OBJ_bet.getDescripcion_ubigeo() + "','" + OBJ_bet.getCodigo_pais() + "'," + OBJ_bet.getDias_credito() + "," + OBJ_bet.getLimite_credito() + ",'" + OBJ_bet.getCodigo_sucursal() + "','" + OBJ_bet.getTipo_comercio() + "','" + OBJ_bet.getCodigo_vendedor() + "','" + OBJ_bet.getAgente_percepcion() + "','" + OBJ_bet.getAgente_retencion() + "','" + OBJ_bet.getEntidad_excluida() + "','" + OBJ_bet.getObservacion() + "','" + OBJ_bet.getForma_pago() + "',$$" + OBJ_bet.getNombres() + "$$,$$" + OBJ_bet.getPrimer_apellido() + "$$,$$" + OBJ_bet.getSegundo_apellido() + "$$,'"+OBJ_bet.getCodigo_sector()+"')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_entidad", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_entidad", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_grid_entidad_parametros(String tipo_documento, String status, String es_cliente, String es_proveedor, String es_trabajador) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_entidad_parametros('" + tipo_documento + "','" + status + "','" + es_cliente + "','" + es_proveedor + "','" + es_trabajador + "') "
                    + "as (codigo_entidad character(6),razon_social character varying(250),numero_doc character varying(15),estado text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_entidad_parametros", e.getMessage());
        }
        return null;
    }
    
    public ResultSet SLT_datos_entidad_x_facturacion(String codigo_entidad,String dato) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_entidad_x_facturacion('" + codigo_entidad + "','"+dato+"') "
                    + "as (codigo_entidad character(6),razon_social character varying(250),numero_doc character varying(15),es_domiciliado character(1),codigo_vendedor character(4),nombre_vendedor character varying(250),forma_pago character(2),dias_credito integer,codigo_ubigeo character(6),direccion character varying(250),descripcion_ubigeo character varying(100))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_entidad_x_facturacion", e.getMessage());
        }
        return null;
    }
    
    public ResultSet SLT_datos_forma_pago(String codigo_entidad) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_forma_pago('"+codigo_entidad+"') "
                    + "as (forma_pago integer,dias_credito integer)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_forma_pago", e.getMessage());
        }
        return null;
    }

}
