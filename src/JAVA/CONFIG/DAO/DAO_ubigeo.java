package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO_ubigeo {

    Statement lq_stm = null;
    ResultSet lq_rs = null;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_ubigeo";

    public ResultSet SLT_datos_ubigeo() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_datos_ubigeo() "
                    + "as (codigo_ubigeo character(6),distrito character varying(60),provincia character varying(60),departamente character varying(60))";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_ubigeo", "NO EXISTEN DATOS DE UBIGEO");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs,lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_datos_ubigeo", e.getMessage());
        }
        return null;
    }
    
    public ResultSet SLT_descripcion_ubigeo_x_codigo(String codigo_ubigeo){
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_descripcion_ubigeo_x_codigo('"+codigo_ubigeo+"') "
                    + "as (descripcion character varying(100))";
            lq_rs = lq_stm.executeQuery(SQL);
            if(lq_rs.next()){
                return lq_rs;
            }else{
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_descripcion_ubigeo_x_codigo", "NO EXISTE UBIGEO");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs,lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_descripcion_ubigeo_x_codigo", e.getMessage());
        }
        return null;
    }
    
    public int SLT_cta_ubigeo_x_codigo(String codigo_ubigeo){
        int cont = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cta_ubigeo_x_codigo('"+codigo_ubigeo+"') "
                    + "as (resp bigint)";
            lq_rs = lq_stm.executeQuery(SQL);
            if(lq_rs.next()){
                cont = lq_rs.getInt(1);
                return cont;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs,lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "SLT_cta_ubigeo_x_codigo", e.getMessage());
        }
        return cont;
    }
}
