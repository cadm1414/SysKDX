package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.REPORT.ruta_distbr_report;
import java.net.URL;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class muestra_reporte_distbr {

    JasperReport jasperReport;
    JasperPrint jasperPrint;
    JasperReport jr = null;
    URL path;
    Connection lq_con;
    String ls_modulo = "DISTBR", ls_capa = "LOGICA", ls_clase = "evt_imprime_doc_distbr";

    public void imprime_documentos(int op, String reporte, Map<String, Object> parametros) {
        try {
            lq_con = go_conexion_db.getConexion_db();
            path = ruta_distbr_report.class.getResource(reporte);

            jr = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, lq_con);
            lq_con.close();
            // TRUE: muestra la ventana de dialogo "preferencias de impresion"
            JasperPrintManager.printReport(jp, true);
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_imprimir", e.getMessage());
        }
    }
}
