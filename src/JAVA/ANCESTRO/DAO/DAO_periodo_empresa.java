package JAVA.ANCESTRO.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.BEAN.BEAN_periodo_empresa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_periodo_empresa {

    private Statement lq_stm = null;
    private ResultSet lq_rs = null;
    private String ls_modulo = "ANCESTRO", ls_capa = "DAO", ls_clase = "DAO_periodo_empresa";

    public ResultSet SLT_datos_x_empresa(BEAN_periodo_empresa OBJ_bpe) {
        try {
            lq_stm = go_conexion_emp.crearStatement();
            lq_rs = lq_stm.executeQuery("SELECT * FROM periodo_empresa WHERE codigo_empresa = " + OBJ_bpe.getCodigo_empresa() + " ORDER BY anio");
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "SLT_datos_x_empresa", "TABLA NO CONTIENE DATOS");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs,lq_stm.getConnection());
        } catch (SQLException e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "SLT_datos_x_empresa", e.getMessage());
        }
        return null;
    }

}
