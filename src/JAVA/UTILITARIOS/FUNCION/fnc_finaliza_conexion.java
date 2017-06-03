package JAVA.UTILITARIOS.FUNCION;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class fnc_finaliza_conexion {

    public void finalizar(Statement stm, ResultSet rs) {
        try {
            stm.close();
            rs = null;
        } catch (SQLException e) {
        }
    }
}
