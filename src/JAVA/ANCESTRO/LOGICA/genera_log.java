package JAVA.ANCESTRO.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import java.io.File;
import java.io.FileWriter;

public class genera_log {

    public void genera_log_tc(String texto) {
        try {
            File archivo = new File(new File("").getAbsolutePath() + "\\log.txt");
            FileWriter escribir = new FileWriter(archivo, true);

            escribir.write(gs_direccion_ip+";"+gs_dia+"/"+gs_mes+"/"+gs_periodo+texto+"\r\n");
            escribir.close();

        } catch (Exception e) {
        }
    }
}
