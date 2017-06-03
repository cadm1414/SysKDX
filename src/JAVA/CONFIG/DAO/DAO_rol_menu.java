package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_rol_menu {

    Statement lq_stm = null;
    ResultSet lq_rs = null;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_rol_menu";

    public boolean SLT_rol_menu_x_idrol() {
        int cont = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_rol_menu_x_idrol(" + gi_id_rol + ") "
                    + "as (cont integer,codigo_modulo character(6),nombre_opcion character varying(100))";

            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                gs_codigo_modulo = new String[lq_rs.getInt(1)];
                gs_modulo = new String[lq_rs.getInt(1)];
                do {
                    gs_codigo_modulo[cont] = lq_rs.getString(2);
                    gs_modulo[cont] = lq_rs.getString(3);
                    cont++;
                } while (lq_rs.next());
                return true;
            } else {
                go_fnc_mensaje.GET_mensaje(gi_id_rol, ls_modulo, ls_capa, ls_clase, "SLT_rol_menu_x_idrol", "USUARIO NO CUENTA CON MODULOS ACTIVOS");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(gi_id_rol, ls_modulo, ls_capa, ls_clase, "SLT_rol_menu_x_idrol", e.getMessage());
        }
        return false;
    }

    public ResultSet SLT_rol_menu_x_idrol_op(String codigo_modulo) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_rol_menu_x_idrol_op(" + gi_id_rol + ",'" + codigo_modulo + "') "
                    + "as (codigo_opcion character varying(30),nombre_opcion character varying(100),status character(1))";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_rol_menu_x_idrol_op", "USUARIO NO CUENTA CON OPCIONES ACTIVAS");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_rol_menu_x_idrol_op", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_status_x_rol_menu(String codigo_modulo, String codigo_op) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_status_x_rol_menu('" + codigo_modulo + "','" + codigo_op + "'," + gi_id_rol + ") "
                    + "as (status_nuevo character(1),status_buscar character(1),status_editar character(1),status_eliminar character(1),status_anular character(1),status_guardar character(1),status_imprimir character(1),status_reporte character(1))";            
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_status_x_rol_menu", "USUARIO " + gs_nombre_rol + " NO CUENTA CON ACCESO AL FORMULARIO");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_status_x_rol_menu", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_status_op_x_idrol(int id_rol) {        
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_status_op_x_idrol("+id_rol+") "
                    + "as (id_rol integer,nombre character varying(30),status_activo character(1),codigo_modulo character(6),codigo_opcion character varying(30),dato unknown ,status_nuevo character(1),status_buscar character(1),status_editar character(1),status_eliminar character(1),status_anular character(1),status_guardar  character(1),status_imprimir character(1),status_reporte character(1))";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_status_op_x_idrol", "NO SE ENCONTRARON DATOS REGISTRADOS");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_status_op_x_idrol", e.getMessage());
        }
        return null;
    }
}
