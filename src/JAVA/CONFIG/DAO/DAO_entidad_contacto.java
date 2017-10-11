package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_entidad_contacto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_entidad_contacto {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_entidad_contacto";
    
    public ResultSet SLT_grid_entidad_contacto(String codigo_entidad) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_entidad_contacto('" + codigo_entidad + "') "
                    + "as (codigo_contacto character(3),nombre_contacto character varying(250),cargo character varying(150))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_entidad_contacto", e.getMessage());
        }
        return null;
    }
    
    public ResultSet SLT_datos_entidad_contacto(String codigo_entidad, String codigo_contacto) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_entidad_contacto('" + codigo_entidad + "','" + codigo_contacto + "') "
                    + "as (codigo_entidad character(6),codigo_contacto character(3),nombre_contacto character varying(250),cargo character varying(150),telefono character varying(20),anexo character varying(10),celular character varying(10),email character varying(40))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_entidad_contacto", e.getMessage());
        }
        return null;
    }
    
    public boolean DLT_entidad_contacto(String codigo_entidad, String codigo_contacto) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_entidad_contacto('" + codigo_entidad + "','" + codigo_contacto + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_entidad_contacto", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_entidad_contacto", e.getMessage());
        }
        return resp;
    }
    
    public boolean IST_entidad_contacto(BEAN_entidad_contacto OBJ_bet) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_entidad_contacto('" + OBJ_bet.getCodigo_entidad() + "',$$" + OBJ_bet.getNombre_contacto()+ "$$,$$" + OBJ_bet.getCargo()+ "$$,'" + OBJ_bet.getTelefono()+ "','" + OBJ_bet.getAnexo()+ "','" + OBJ_bet.getCelular()+ "','" + OBJ_bet.getEmail()+ "')";

            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_entidad_contacto", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_entidad_contacto", e.getMessage());
        }
        return resp;
    }
    
    public boolean UPD_entidad_contacto(BEAN_entidad_contacto OBJ_bet) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_entidad_contacto('" + OBJ_bet.getCodigo_entidad() + "','" + OBJ_bet.getCodigo_contacto()+ "',$$" + OBJ_bet.getNombre_contacto()+ "$$,$$" + OBJ_bet.getCargo()+ "$$,'" + OBJ_bet.getTelefono()+ "','" + OBJ_bet.getAnexo()+ "','" + OBJ_bet.getCelular()+ "','" + OBJ_bet.getEmail()+ "')";

            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_entidad_contacto", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_entidad_contacto", e.getMessage());
        }
        return resp;
    }
}
