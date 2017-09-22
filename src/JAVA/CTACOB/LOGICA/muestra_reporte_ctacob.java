package JAVA.CTACOB.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CTACOB.REPORT.ruta_ctacob_report;
import java.net.URL;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class muestra_reporte_ctacob {

    JasperReport jr = null;
    URL path;
    String ls_modulo = "CTACOB", ls_capa = "LOGICA", ls_clase = "muestra_reporte_ctacob";

    public void reporte_pestania(String reporte, Map<String, Object> parametro, String nombre, int op) {
        try {
            path = ruta_ctacob_report.class.getResource(reporte);
            jr = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, go_conexion_db.getConexion_db());
            JRViewer jr = new JRViewer(jp);
            switch (op) {
                case 0:
                    go_muestra_pestania_ctacob.rpt_saldo_cta_corriente(jr, nombre);
                    break;
            }
        } catch (Exception e) {
        }
    }
}
