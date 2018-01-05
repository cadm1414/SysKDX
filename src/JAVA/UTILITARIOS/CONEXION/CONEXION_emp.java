package JAVA.UTILITARIOS.CONEXION;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CONEXION_emp {

    Connection lq_con = null;
    Statement lq_stm = null;
    String ls_server, ls_port, ls_nombre;
    String ls_path = new File("").getAbsolutePath();
    String ls_modulo = "UTILITARIOS", ls_capa = "CONEXION", ls_clase = "CONEXION_db";

    public Connection getConexion_emp() {
        try {
            Properties lp_p = new Properties();
            lp_p.load(new FileInputStream(ls_path + "\\config.properties"));
            ls_server = lp_p.getProperty("Server_emp");
            ls_nombre = lp_p.getProperty("Nombre_emp");
            ls_port = lp_p.getProperty("Port_emp");

            Class.forName("org.postgresql.Driver");
            lq_con = DriverManager.getConnection("jdbc:postgresql://" + ls_server + ":" + ls_port + "/" + ls_nombre, "postgres", "CaDm1414");
            lq_con.setAutoCommit(false);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "getconexion_emp", e.getMessage());
            go_fnc_cierra_sistema.cierra_sistema();
        }
        return lq_con;
    }

    public Statement crearStatement() {
        try {
            lq_stm = getConexion_emp().createStatement();
        } catch (SQLException e) {
        }
        return lq_stm;
    }
}
