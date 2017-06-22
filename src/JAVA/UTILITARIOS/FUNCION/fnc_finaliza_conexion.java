package JAVA.UTILITARIOS.FUNCION;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class fnc_finaliza_conexion {

    public void finalizar(Statement stm, ResultSet rs,Connection con) {
        try {
            con.close();
            stm.close();
            rs = null;
        } catch (SQLException e) {
        }
    }
}
