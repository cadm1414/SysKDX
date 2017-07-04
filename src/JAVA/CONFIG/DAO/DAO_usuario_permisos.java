package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_usuario_permisos;
import JAVA.CONFIG.GUI.pnl_grid_usuario_permisos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_usuario_permisos {

    ResultSet lq_rs = null;
    Statement lq_stm = null;
    private String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_usuario_permisos";

    public ResultSet SLT_grid_usuario_permisos() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_usuario_permisos() "
                    + "as (codigo character(4),nombre character varying(100),tipo_almacen text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_usuario_permisos", e.getMessage());
        }
        return null;
    }

    public ResultSet SLT_usuario_permisos_x_idusuario(int id_usuario) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_usuario_permisos_x_idusuario(" + id_usuario + ") "
                    + "as (id_usuario int,sucursal_almacen character(4),tipo_almacen text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_usuario_permisos_x_idusuario", "USUARIO NO CUENTA CON PERMISOS");
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_usuari_permisos_x_idusuario", e.getMessage());
        }
        return null;
    }

    public boolean DLT_usuario_permisos(int id_usuario) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_usuario_permisos(" + id_usuario + ")";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_usuario_permisos", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_usuario_permisos", e.getMessage());
        }
        return resp;
    }

    public boolean IST_usuario_permisos(BEAN_usuario_permisos OBJ_bup, pnl_grid_usuario_permisos OBJ_pgu) throws SQLException {
        boolean resp = false;
        String tipo_almacen = "";
        lq_stm = go_conexion_db.crearStatement();
        lq_rs = lq_stm.executeQuery("select * from dlt_usuario_permisos(" + OBJ_bup.getId_usuario() + ")");
        try {
            for (int i = 0; i < OBJ_pgu.TBL_usuario_permisos.getRowCount(); i++) {
                if (go_fnc_operaciones_campos.boolean_int((boolean) OBJ_pgu.TBL_usuario_permisos.getValueAt(i, 3)) == 1) {
                    switch (OBJ_pgu.TBL_usuario_permisos.getValueAt(i, 2).toString()) {
                        case "ALMACEN":
                            tipo_almacen = "1";
                            break;
                        case "SUCURSAL":
                            tipo_almacen = "2";
                            break;
                        case "VENTA":
                            tipo_almacen = "0";
                            break;
                    }
                    String SQL = "select * from ist_usuario_permisos(" + OBJ_bup.getId_usuario() + ",'" + tipo_almacen + "','" + OBJ_pgu.TBL_usuario_permisos.getValueAt(i, 0) + "')";
                    lq_rs = lq_stm.executeQuery(SQL);
                }
            }
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_usuario_permisos", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_usuario_permisos", e.getMessage());
        }
        return resp;
    }

    public int SLT_cta_usuario_permisos(int id_usuario) {
        int resp = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cta_usuario_permisos(" + id_usuario + ") as (cont bigint)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                resp = lq_rs.getInt(1);
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "SLT_cta_usuario_permisos", e.getMessage());
        }
        return resp;
    }

    public ResultSet SLT_grid_almacen_x_permiso(int id_usuario, String tipo_almacen, String status, String almacen) {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_grid_almacen_x_permiso(" + id_usuario + ",'" + tipo_almacen + "','" + status + "','" + almacen + "') "
                    + "as (codigo_almacen character(4),nombre_almacen character varying(100))";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs;
            }            
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_grid_usuario_permisos", e.getMessage());
        }
        return null;
    }

}
