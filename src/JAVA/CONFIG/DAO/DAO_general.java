package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_general;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_general {

    Statement lq_stm = null;
    ResultSet lq_rs = null;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_general";

    public void SLT_datos() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_general() "
                    + "as (ruc character(11),razon_social character varying(150),giro character varying(150),direccion character varying(150),codigo_ubigeo character(6),descripcion_ubigeo character varying(100),telefono character varying(20),fax character varying(20),e_mail character varying(60),website character varying(60),nombre_reporte character varying(60),fecha_actividad date,codigo_moneda character(3),imagen_logo character varying(100),imagen_portada character varying(100))";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                do {
                    go_bean_general.setRuc(lq_rs.getString(1));
                    go_bean_general.setRazon_social(lq_rs.getString(2));
                    go_bean_general.setGiro(lq_rs.getString(3));
                    go_bean_general.setDireccion(lq_rs.getString(4));
                    go_bean_general.setCodigo_ubigeo(lq_rs.getString(5));
                    go_bean_general.setDescripcion_ubigeo(lq_rs.getString(6));
                    go_bean_general.setTelefono(lq_rs.getString(7));
                    go_bean_general.setFax(lq_rs.getString(8));
                    go_bean_general.setE_mail(lq_rs.getString(9));
                    go_bean_general.setWebsite(lq_rs.getString(10));
                    go_bean_general.setNombre_reporte(lq_rs.getString(11));
                    go_bean_general.setFecha_actividad(lq_rs.getString(12));
                    go_bean_general.setCodigo_moneda(lq_rs.getString(13));
                    go_bean_general.setImagen_logo(lq_rs.getString(14));
                    go_bean_general.setImagen_portada(lq_rs.getString(15));
                } while (lq_rs.next());
            } else {
                go_fnc_mensaje.GET_mensaje(gi_id_rol, ls_modulo, ls_capa, ls_clase, "SLT_datos", "TABLA NO CONTIENE DATOS");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(gi_id_rol, ls_modulo, ls_capa, ls_clase, "SLT_datos", e.getMessage());
        }
    }

    public int SLT_cta_datos_general() {
        int resp = 0;
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from slt_cta_datos_general() as (cont bigint)";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                resp = lq_rs.getInt(1);
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "SLT_cta_datos_general", e.getMessage());
        }
        return resp;
    }

    public void IST_general() throws SQLException {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from ist_general('" + go_bean_general.getRuc() + "','" + go_bean_general.getRazon_social() + "','" + go_bean_general.getGiro() + "','" + go_bean_general.getDireccion() + "','" + go_bean_general.getCodigo_ubigeo() + "','" + go_bean_general.getDescripcion_ubigeo() + "','" + go_bean_general.getTelefono() + "','" + go_bean_general.getFax() + "','" + go_bean_general.getE_mail() + "','" + go_bean_general.getWebsite() + "','" + go_bean_general.getNombre_reporte() + "','" + go_bean_general.getFecha_actividad() + "','" + go_bean_general.getCodigo_moneda() + "','','') "
                    + "as (resp integer)";
            lq_rs = lq_stm.executeQuery(SQL);

            if (lq_rs.next()) {
                if (lq_rs.getInt(1) == 1) {
                    lq_stm.getConnection().commit();
                    go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "INS_general", "SE ACTUALIZO BASE DE DATOS");
                } else {
                    go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "INS_general", "NO SE ACTUALIZO BASE DE DATOS");
                }
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "INS_general", e.getMessage());
            lq_stm.getConnection().rollback();
        }
    }

    public void UPD_general() throws SQLException {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from upd_general('" + go_bean_general.getRuc() + "','" + go_bean_general.getRazon_social() + "','" + go_bean_general.getGiro() + "','" + go_bean_general.getDireccion() + "','" + go_bean_general.getCodigo_ubigeo() + "','" + go_bean_general.getDescripcion_ubigeo() + "','" + go_bean_general.getTelefono() + "','" + go_bean_general.getFax() + "','" + go_bean_general.getE_mail() + "','" + go_bean_general.getWebsite() + "','" + go_bean_general.getNombre_reporte() + "','" + go_bean_general.getFecha_actividad() + "','" + go_bean_general.getCodigo_moneda() + "','','') ";
            lq_rs = lq_stm.executeQuery(SQL);
            if (lq_rs.next()) {
                lq_stm.getConnection().commit();
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "UPD_general", "SE ACTUALIZO BASE DE DATOS");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "UPD_general", e.getMessage());
            lq_stm.getConnection().rollback();
        }

    }
}
