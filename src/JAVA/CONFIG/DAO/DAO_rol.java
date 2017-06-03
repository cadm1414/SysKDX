package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_rol;
import JAVA.CONFIG.GUI.pnl_grid_rol_menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_rol {

    Statement lq_stm = null;
    ResultSet lq_rs = null;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_rol";

    public ResultSet SLT_datos_rol() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_rol() "
                    + "as (id_rol integer,nombre_rol character varying(30))";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_rol", "NO SE ENCONTRARON DATOS REGISTRADOS");
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_rol", e.getMessage());
        }
        return null;
    }

    public boolean IST_rol(BEAN_rol OBJ_rol, pnl_grid_rol_menu OBJ_prm) throws SQLException {
        boolean resp = false;
        OBJ_rol.setId_rol(SLT_ultimo_registro());
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_rol(" + OBJ_rol.getId_rol() + ",'" + OBJ_rol.getNombre_rol() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                for (int i = 0; i < OBJ_prm.TBL_rol_menu.getRowCount(); i++) {
                    SQL = "select * from ist_rol_menu(" + OBJ_rol.getId_rol() + ",'" + OBJ_prm.TBL_rol_menu.getValueAt(i, 1).toString() + "','" + OBJ_prm.TBL_rol_menu.getValueAt(i, 2).toString() + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 0)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 4)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 5)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 6)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 7)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 8)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 9)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 10)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 11)) + "')";
                    lq_rs = lq_stm.executeQuery(SQL);
                }
                if (lq_rs.next()) {
                    lq_stm.getConnection().commit();
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_rol", "SE ACTUALIZO BASE DE DATOS");
                    resp = true;
                }
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            SLT_reinicia_registro(OBJ_rol.getId_rol());
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_rol", e.getMessage());
        }
        return resp;
    }

    public int SLT_ultimo_registro() {
        int resp = 0;
        try {
            String SQL = "SELECT nextval('rol_id'::regclass)";
            lq_stm = go_conexion_db.crearStatement();
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                resp = lq_rs.getInt(1);
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
        }
        return resp;
    }

    public void SLT_reinicia_registro(int numero) {
        try {
            String SQL = "ALTER SEQUENCE rol_id restart " + numero;
            lq_stm = go_conexion_db.crearStatement();
            lq_stm.executeUpdate(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
        }
    }

    public boolean DLT_rol(int id_rol) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from dlt_rol(" + id_rol + ")";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "DLT_rol", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "DLT_rol", e.getMessage());
        }
        return resp;
    }

    public boolean UPD_rol(BEAN_rol OBJ_rol, pnl_grid_rol_menu OBJ_prm, int id_rol) throws SQLException {
        boolean resp = false;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_rol(" + id_rol + ",'" + OBJ_rol.getNombre_rol() + "')";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                for (int i = 0; i < OBJ_prm.TBL_rol_menu.getRowCount(); i++) {
                    SQL = "select * from ist_rol_menu(" + id_rol + ",'" + OBJ_prm.TBL_rol_menu.getValueAt(i, 1).toString() + "','" + OBJ_prm.TBL_rol_menu.getValueAt(i, 2).toString() + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 0)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 4)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 5)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 6)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 7)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 8)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 9)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 10)) + "','"
                            + go_fnc_operaciones_campos.boolean_int((boolean) OBJ_prm.TBL_rol_menu.getValueAt(i, 11)) + "')";
                    lq_rs = lq_stm.executeQuery(SQL);
                }
                if (lq_rs.next()) {
                    lq_stm.getConnection().commit();
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_rol", "SE ACTUALIZO BASE DE DATOS");
                    resp = true;
                }
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_rol", e.getMessage());
        }
        return resp;
    }

}
