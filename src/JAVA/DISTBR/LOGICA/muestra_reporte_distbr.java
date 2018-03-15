package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.REPORT.ruta_distbr_report;
import java.net.URL;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class muestra_reporte_distbr {

    JasperReport jr = null;
    URL path;
    String ls_modulo = "DISTBR", ls_capa = "LOGICA", ls_clase = "muestra_reporte_distribucion";
    Connection lq_con;

    public void reporte_pestania(String reporte, Map<String, Object> parametro, String nombre, int op) {
        try {
            lq_con = go_conexion_db.getConexion_db();
            path = ruta_distbr_report.class.getResource(reporte);
            jr = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, lq_con);
            lq_con.close();
            JRViewer jr = new JRViewer(jp);
            switch (op) {
                case 0:
                    go_muestra_pestania_distbr.rpt_resumen_liquidacion(jr, nombre);
                case 1:
                    go_muestra_pestania_distbr.rpt_despacho_preliminar(jr, nombre);
                    break;
            }
        } catch (Exception e) {
        }

    }

}
