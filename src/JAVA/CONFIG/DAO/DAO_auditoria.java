package JAVA.CONFIG.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class DAO_auditoria {

    ResultSet lq_rs;
    Statement lq_stm;
    String ls_modulo = "CONFIG", ls_capa = "DAO", ls_clase = "DAO_auditoria";
    Calendar fecha = Calendar.getInstance();
    String mes = go_fnc_operaciones_campos.completa_digitos((fecha.get(Calendar.MONTH) + 1) + "", "0", 2);
    String dia = go_fnc_operaciones_campos.completa_digitos((fecha.get(Calendar.DAY_OF_MONTH)) + "", "0", 2);
    String anio = go_fnc_operaciones_campos.completa_digitos((fecha.get(Calendar.YEAR)) + "", "0", 4);

    public String FNC_correlativo_auditoria() {
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "select * from fnc_correlativo_auditoria('" + gs_periodo + mes + "'," + gi_id_usuario + ",'" + gs_direccion_ip + "','" + gs_periodo + "') as (codigo text)";
            lq_rs = lq_stm.executeQuery(SQL);
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
            if (lq_rs.next()) {
                return lq_rs.getString(1);
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "fnc_correlativo_auditoria", e.getMessage());
        }
        return null;
    }

    public boolean IST_auditoria(String dato, String sql, String modulo, String tipo_operacion, String tabla) throws SQLException {
        boolean resp = false;
        String correlativo = FNC_correlativo_auditoria();
        try {
            lq_stm = go_conexion_db.crearStatement();
            String SQL = "insert into auditoria_" + gs_periodo + " values('" + gs_periodo + mes + "','" + correlativo + "'," + gi_id_usuario + ",'" + gs_direccion_ip + "',now(),'" + gs_nombre_usuario + "','" + gs_nombre_pc + "','" + gs_direccion_mac + "','" + dato + "',$$" + sql + "$$,'" + tipo_operacion + "','" + modulo + "','" + tabla + "')";
            int rs = lq_stm.executeUpdate(SQL);
            if (rs == 1) {
                lq_stm.getConnection().commit();
                //go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "IST_auditoria", "SE ACTUALIZO BASE DE DATOS");
                resp = true;
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_stm.getConnection());
        } catch (Exception e) {
            lq_stm.getConnection().rollback();
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "IST_auditoria", e.getMessage());
        }
        return resp;
    }
}
