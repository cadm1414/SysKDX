package JAVA.ANCESTRO.DAO;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_registro_empresa {

    private Statement lq_stm = null;
    private ResultSet lq_rs = null;
    private String ls_modulo = "ANCESTRO", ls_capa = "DAO", ls_clase = "DAO_registro_empresa";

    public ResultSet SLT_datos() {
        try {
            lq_stm = go_conexion_emp.crearStatement();
            lq_rs = lq_stm.executeQuery("SELECT * FROM registro_empresa ORDER BY nombre_empresa");
            if (lq_rs.next()) {
                return lq_rs;
            } else {
                go_fnc_mensaje.GET_mensaje(3, ls_modulo, ls_capa, ls_clase, "SLT_datos", "TABLA NO CONTIENE DATOS");
            }
            go_fnc_finaliza_conexion.finalizar(lq_stm, lq_rs);
        } catch (SQLException e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "SLT_datos", e.getMessage());
        }
        return null;
    }

}
