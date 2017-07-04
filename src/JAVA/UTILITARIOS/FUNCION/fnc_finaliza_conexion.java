package JAVA.UTILITARIOS.FUNCION;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class fnc_finaliza_conexion {

    public void finalizar(Statement stm, Connection con) {
        try {
            con.close();
            stm.close();            
        } catch (SQLException e) {
        }
    }
}
